package com.elm.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
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

@ServerEndpoint("/websocket")
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

    /**
     * ���ӽ����ɹ����õķ���
     *
     * @param session ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig config) throws IOException {
        this.session = session;
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
        	Map data = dataMap.get(id);
        	JSONObject json = JSONObject.fromObject(data);
        	try {
				webSocketMap.get(id + "this").sendMessage(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else if (map.get("message").equals("init")) {
        	this.id = id;
        	webSocketMap.put(id + "this", this);
        	if (!dataMap.containsKey(id)) {
            	Map<String,Object> data = new HashMap<String,Object>();
            	long nowTime = new Date().getTime();
            	data.put("time", nowTime);
            	dataMap.put(id.toString(), data);
            } else if (!dataMap.get(id).containsKey("time")){
            	Map data = dataMap.get(id);
            	long nowTime = new Date().getTime();
            	data.put("time", nowTime);
            } else {
            	long oldTime = (long) dataMap.get(id).get("time");
            	long nowTime = new Date().getTime();
            	long fifteenMs = 2 * 60 * 1000;
            	if ((nowTime - oldTime) >= fifteenMs){
            		Integer orderId = (Integer) map.get("orderId");
            		orderService.updateOrderState(orderId, Order.ALREADY_CLOSE);
            		webSocketMap.get(id + "this").sendMessage("close");
            		webSocketMap.remove(id + "this");
            		dataMap.remove(id);
            	}
            }
        	Map data = dataMap.get(id);
        	JSONObject json = JSONObject.fromObject(data);
        	webSocketMap.get(id + "this").sendMessage(json.toString());
        } else if (map.get("message").equals("cancle")) {
        	Integer orderId = (Integer) map.get("orderId");
        	orderService.updateOrderState(orderId, Order.ALREADY_CLOSE);
        	webSocketMap.remove(id + "this");
    		dataMap.remove(id);
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
