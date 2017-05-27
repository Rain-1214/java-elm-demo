package com.imooc.action;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class LoginAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private String result;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	
	public String index(){
		return SUCCESS;
	}
	
	public String ajaxTest() throws Exception {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("userName", userName);
		map.put("passWord", passWord);
		
		JSONObject json = JSONObject.fromObject(map);
		result = json.toString();
		
		return SUCCESS;
		
	}
	
}
