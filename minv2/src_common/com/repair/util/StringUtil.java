package com.repair.util;

/**
 * 
* @ClassName: StringUtil
* @Description: TODO(字符串的工具类)
* @author 周云韬
* @version V1.0  
* @date 2015-8-19 下午6:31:55
 */
public class StringUtil {
	
	/**
	 * 
	* @Title: isNotBlank 
	* @Description: TODO(判断一个字符串是否为空) 
	* @param  str
	* @return boolean 如果非空，返回true
	 */
	public static boolean isNotBlank(String str){
		if(str == null){
			return false;
		}
		
		if("".equals(str.trim())){
			return false;
		}
		
		
		return true;
	}
}
