package com.repair.constant;

/**
 * 
 * @see 用来存放  在ServletContext中的key
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public interface CacheConstants {

	/**
	 * 故障字典表的缓存key,通过此key获取的返回值为List
	 */
	String CACHE_DICT_FAULT_LIST="cacheDictFaultList";
	
	/**
	 * 班组表的缓存key,通过此key获取的返回值为List
	 */
	String CACHE_DICT_PROTEAM_LIST="cacheDictProteamList";
	
}
