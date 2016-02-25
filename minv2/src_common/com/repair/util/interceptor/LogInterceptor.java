package com.repair.util.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * @ClassName: LogInterceptor
 * @Description: spring 同一日志处理实现类
 * @author andy
 * @version V1.0
 * @date Jul 24, 2015 10:16:41 AM
 */

public class LogInterceptor implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Logger loger = Logger.getLogger(invocation.getClass());
		loger.info("--Log--------------------------------------------------------------------------------------------");
		loger.info(invocation.getMethod() + ":BEGIN!");// 方法前的操作
		Object obj = invocation.proceed();// 执行需要Log的方法
		loger.info(invocation.getMethod() + ":END!");// 方法后的操作
		loger.info("-------------------------------------------------------------------------------------------------");
		return obj;
	}
}
