package com.repair.util.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;

/**
 * @see 基础action，所有的action可继承此类
 * @version 1.0
 * @author 周云韬
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected HttpSession session;
	
	protected PrintWriter pw;
	
	protected ServletContext servletContext;
	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		response.setCharacterEncoding("UTF-8");
		try {
			this.pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=request.getSession();
		
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext=context;
	}
	
	
	/**
	 * 返回json文本，列如：{"errCode":"0","retMsg":"操作成功"}
	 * @param errCode
	 * @param retMsg
	 * @throws IOException 
	 */
	public void writeJson(Object errCode,Object retMsg) throws IOException{
		
		
		
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_JSON);
		
		Map<Object, Object> retMap=new HashMap<Object, Object>();
		retMap.put("errCode", errCode);
		retMap.put("retMsg", retMsg);
		
		pw.write(new Gson().toJson(retMap));
		pw.flush();
	}
	
	/**
	 * 获得登录用户
	 * @return
	 */
	public UsersPrivs getLoginUsers(){
		UsersPrivs usersPrivs=(UsersPrivs) session.getAttribute(Constants.LOGIN_USER);
		return usersPrivs;
	}

	
}
