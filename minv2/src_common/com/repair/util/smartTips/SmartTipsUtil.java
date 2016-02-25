package com.repair.util.smartTips;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
* 将其他的实体对象转换为 智能联想所需的对象
* @ClassName: SmartTipsUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午4:27:07
*/
public class SmartTipsUtil {
	/**
	 * 将单个对象转换为Ganged对象，自动调用obj的getter方法获取值
	 * @param obj：要转换的对象
	 * @param idField：ID 字段名
	 * @param nameField：中文名字 字段名
	 * @param pyField：拼音 字段名
	 * @return SmartTips    
	 * @throws Exception 
	 */
	public static SmartTips convert(Object obj,String idField,String nameField,String pyField) throws Exception{
		if(obj == null){
			return null;
		}
		Class cls=obj.getClass();
		
		Field[] fields=cls.getDeclaredFields();
		if(fields.length >= 3){
			SmartTips smartTips=new SmartTips();
			//调用obj的get方法，获取并设置Id字段值
			String methodName=idField.substring(0,1).toUpperCase()+idField.substring(1);
			String retValue =String.valueOf(cls.getMethod("get"+methodName).invoke(obj));
			smartTips.setId(retValue);
			
			//调用obj的get方法，获取并设置name字段值
			methodName=nameField.substring(0,1).toUpperCase()+nameField.substring(1);
			retValue =String.valueOf(cls.getMethod("get"+methodName).invoke(obj));
			smartTips.setName(retValue);
			
			//调用obj的get方法，获取并设置py字段值
			methodName=pyField.substring(0,1).toUpperCase()+pyField.substring(1);
			retValue =String.valueOf(cls.getMethod("get"+methodName).invoke(obj));
			smartTips.setPy(retValue);
			
			return smartTips;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 将一个对象集合转换为SmartTips集合 
	 * @param obj：要转换的对象
	 * @param idField：ID 字段名
	 * @param nameField：中文名字 字段名
	 * @param pyField：拼音 字段名
	 * @return List<SmartTips>    
	 * @throws
	 */
	public static List<SmartTips> convert(List list,String idField,String nameField,String pyField) throws Exception{
		List<SmartTips> smartTipsList=new ArrayList<SmartTips>();
		for (Object obj : list) {
			SmartTips smart=convert(obj, idField, nameField,pyField);
			smartTipsList.add(smart);
		}
		
		return smartTipsList;
	}
	
}
