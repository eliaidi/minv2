package com.repair.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 
 * @see 对于Class的一些操作
 * @author 周云韬
 * @date 2015-12-18
 * @version 1.0
 */
public class ClassUtil {
	/**
	 * 获取一个Class的父类的泛型参数的Class数组
	 * @param c 
	 * @return
	 */
	public static Class[] getGenericParametersForClass(Class c) {
	
		//获取泛型类，并转为ParameterizedType
		ParameterizedType  genericClass=(ParameterizedType)c.getGenericSuperclass();
		
		//获取类上的真实泛型参数
		Type[] types=genericClass.getActualTypeArguments();
		
		Class[] cs=new Class[types.length];
		
		for (int i=0;i<types.length;i++) {
			cs[i]=(Class)types[i];
		}
		
		return cs;
	}
}
