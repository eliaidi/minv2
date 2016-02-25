package com.repair.util;

import javax.servlet.ServletContext;
import org.springframework.web.context.ServletContextAware;

/**
* @ClassName: ServletContextUtil
* @Description: 实现接口ServletContextAware，对全局信息存储空间ServletContext进行操作
* @author andy
* @version V1.0  
* @date Jul 17, 2015 2:45:23 PM
 */
public class ServletContextUtil implements ServletContextAware{
	private static ServletContext servletContext;
    
	 //实现ServletContextAware接口，得到ServletContext对象，并赋给成员变量
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
	}
	
	//把对象放入servletContext
	public void setServletContext(String name,Object object){
		this.servletContext.setAttribute(name, object);
	}
	
	//通过name得到servletContext中的对象
	public Object getServletContext(String name){
		return this.servletContext.getAttribute(name);
	}

}
