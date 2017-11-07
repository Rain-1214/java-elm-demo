package com.elm.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.context.ContextLoader;

import com.elm.entity.Order;
import com.elm.service.OrderService;

import net.sf.json.JSONObject;

@ServerEndpoint(value = "/websocket",configurator=GetHttpSessionConfigurator.class)
public class Websocket{

	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static ConcurrentHashMap<String,Websocket> webSocketMap = new ConcurrentHashMap<String,Websocket>();
    public static ConcurrentHashMap<String,Map> dataMap = new ConcurrentHashMap<String,Map>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String id;
    private OrderService orderService;
    private HttpSession httpSession;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig config) throws IOException {
        this.session = session;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        System.out.println(this.httpSession.getId());
        orderService = (OrderService) ContextLoader.getCurrentWebApplicationContext().getBean("orderService");
        addOnlineCount(); //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        String sessionId = session.getId();
        webSocketMap.remove(this.id + "this"); // 删除
        subOnlineCount(); //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     * @throws IOException 
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map = JSONObject.fromObject(message);
        String id = (String) map.get("id").toString();
        
        if (map.get("message").equals("getTime")) {
        	getTime(id);
        } else if (map.get("message").equals("init")) {
        	this.id = id;
        	webSocketMap.put(id + "this", this);
        	if (!dataMap.containsKey(id)) {
            	initOrder();
            } else {
            	Integer orderId = (Integer) map.get("orderId");
            	checkOldOrder(orderId);
            }
        } else if (map.get("message").equals("cancle")) {
        	Integer orderId = (Integer) map.get("orderId");
        	cancleOrder(orderId);
        } else if (map.get("message").equals("pay")) {
        	Integer orderId = (Integer) map.get("orderId");
        	payOrder(orderId);
        }
        
    }

    

	/**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        webSocketMap.remove(this.id + "this");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
    
    public void sendMessageToAllUser(String message) {
    	//群发消息
        Iterator<String> entries = webSocketMap.keySet().iterator();
        while(entries.hasNext()){
        	String entry = entries.next();
        	try {
        		webSocketMap.get(entry).sendMessage(message);
        	} catch (IOException e) {
        		e.printStackTrace();
                continue;
        	}
        }
    }
    
    public void getTime(String id) throws IOException {
    	Map data = dataMap.get(this.id);
    	JSONObject json = JSONObject.fromObject(data);
    	sendMessage(json.toString());
    }
    
    public void initOrder() throws IOException {
    	Map<String,Object> data = new HashMap<String,Object>();
    	long nowTime = new Date().getTime();
    	data.put("time", nowTime);
    	dataMap.put(this.id.toString(), data);
    	JSONObject json = JSONObject.fromObject(data);
    	sendMessage(json.toString());
    }
    
    public void checkOldOrder(Integer orderId) throws IOException{
    	long oldTime = (long) dataMap.get(this.id).get("time");
    	long nowTime = new Date().getTime();
    	long fifteenMs = 15 * 60 * 1000;
    	if ((nowTime - oldTime) >= fifteenMs){
    		orderService.updateOrderState(orderId, Order.ALREADY_CLOSE);
    		removeAllAssets();
    	} else {
    		Map data = dataMap.get(this.id);
    		JSONObject json = JSONObject.fromObject(data);
        	sendMessage(json.toString());
    	}
    }
    
    private void payOrder(Integer orderId) throws IOException {
    	orderService.updateOrderState(orderId, Order.WAIT_COMPLETE);
    	sendMessage("paySuccess");
    	removeAllAssets();
	}
    
    public void cancleOrder(Integer orderId) throws IOException {
    	orderService.updateOrderState(orderId, Order.ALREADY_CLOSE);
    	sendMessage("cancleSuccess");
    	removeAllAssets();
    }
    
    public void removeAllAssets(){
    	String sessionId = this.httpSession.getId();
		this.httpSession.removeAttribute(sessionId + "currentOrder");
		System.out.println(httpSession.getAttribute(sessionId + "currentOrder"));
    	webSocketMap.remove(this.id + "this");
		dataMap.remove(this.id);
    }
    
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
    	Websocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
    	Websocket.onlineCount--;
    }
    
    
	
}
