package com.repair.util.ganged;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
* 下拉框联动查询工具类，将其他的实体类转换为 Ganged
* @ClassName: GangedUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午4:27:07
*/
public class GangedUtil {
	/**
	 * 将单个对象转换为Ganged对象，自动调用obj的getter方法获取值
	 * @param obj：要转换的对象
	 * @param valueField：要转换的值字段名（作为option的value值）
	 * @param showValueField：要转换的显示值字段名（作为option显示的值）
	 * @return Ganged    
	 * @throws Exception 
	 */
	public static Ganged convert(Object obj,String valueField,String showValueField) throws Exception{
		if(obj == null){
			return null;
		}
		Class cls=obj.getClass();
		
		Field[] fields=cls.getDeclaredFields();
		if(fields.length >= 2){
			Ganged ganged=new Ganged();
			//调用obj的get方法，获取并设置value字段值
			String methodName=valueField.substring(0,1).toUpperCase()+valueField.substring(1);
			String retValue =String.valueOf(cls.getMethod("get"+methodName).invoke(obj));
			ganged.setValue(retValue);
			
			//调用obj的get方法，获取并设置showValue字段值
			methodName=showValueField.substring(0,1).toUpperCase()+showValueField.substring(1);
			retValue =String.valueOf(cls.getMethod("get"+methodName).invoke(obj));
			ganged.setShowValue(retValue);
			return ganged;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 将一个对象集合转换为Gange集合 
	 * @return List<Ganged>    
	 * @throws
	 */
	public static List<Ganged> convert(List list,String valueField,String showValueField) throws Exception{
		List<Ganged> gangedList=new ArrayList<Ganged>();
		for (Object obj : list) {
			Ganged ganged=convert(obj, valueField, showValueField);
			gangedList.add(ganged);
		}
		
		return gangedList;
	}
	
}
