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

	//��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
    private static int onlineCount = 0;

    //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
    public static ConcurrentHashMap<String,Websocket> webSocketMap = new ConcurrentHashMap<String,Websocket>();
    public static ConcurrentHashMap<String,Map> dataMap = new ConcurrentHashMap<String,Map>();

    //��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session session;
    private String id;
    private OrderService orderService;
    private HttpSession httpSession;

    /**
     * ���ӽ����ɹ����õķ���
     *
     * @param session ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig config) throws IOException {
        this.session = session;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        System.out.println(this.httpSession.getId());
        orderService = (OrderService) ContextLoader.getCurrentWebApplicationContext().getBean("orderService");
        addOnlineCount(); //��������1
        System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose(Session session) {
        String sessionId = session.getId();
        webSocketMap.remove(this.id + "this"); // ɾ��
        subOnlineCount(); //��������1
        System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
    }

    /**
     * �յ��ͻ�����Ϣ����õķ���
     *
     * @param message �ͻ��˷��͹�������Ϣ
     * @param session ��ѡ�Ĳ���
     * @throws IOException 
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("���Կͻ��˵���Ϣ:" + message);
        
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
     * ��������ʱ����
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("��������");
        webSocketMap.remove(this.id + "this");
        error.printStackTrace();
    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
    
    public void sendMessageToAllUser(String message) {
    	//Ⱥ����Ϣ
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
