package com.repair.dict.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import com.repair.dict.service.DictionaryBaseService;
import com.repair.entity.DictionaryBase;
import com.repair.util.ServletContextUtil;



/**
* @ClassName: DictionaryCache
* @Description: 把DICTIONARY_BASE表中常用的基本数据在初始化的时候加载到内存中
* @author andy
* @version V1.0  
* @date Jul 17, 2015 2:45:23 PM
 */
public class DictionaryBaseCacheUtil implements InitializingBean{
	private DictionaryBaseService dictionaryBaseService;
	private static final Logger LOGGER=Logger.getLogger(DictionaryBaseCacheUtil.class);
	
	
	private static Map<String,List<DictionaryBase>> cache; //字典缓存
	private ServletContextUtil servletContextUtil; //注入servletContextUtil对全局信息存储空间类（类注入）
	/** 
	* @Title: afterPropertiesSet 
	* @Description: 实现InitializingBean接口,spring加载时启动,从数据库中dictionary_Base读取所有数据，迭代取出codeType值，
	* 				同时根据codeType从cache中取值得到List，如果List为空，则创建一个list并放入从数据库中取到的对象，
	* 				并以codeType为键，typeList为值，加入cache中。
	* 				并把cache加入servletContext上下文中，供全局使用
	* @param  无
	* @return 无
	* @throws 
	*/ 	
	public void afterPropertiesSet() throws Exception {
		List<DictionaryBase> list = dictionaryBaseService.findAll();
		cache=new HashMap<String,List<DictionaryBase>>();
		for(DictionaryBase dict:list){
			String codeType = dict.getCodeType();
			List<DictionaryBase> typeList = cache.get(codeType);
			if(typeList==null){
				typeList = new ArrayList<DictionaryBase>();
			}
			typeList.add(dict);
			cache.put(codeType, typeList);
		}
		this.servletContextUtil.setServletContext("cache", cache);
	}
	
	/** 
	* @Title: getDictionaryBaseCacheByCodeType 
	* @Description: 通过codeType从变量名为cacheMap中得到类型为DictionaryBaseCache的List集合
	* @param codeType：类型码 
	* @return List<DictionaryBaseCache>：类型为DictionaryBaseCache的List集合
	* @throws 
	*/ 
	public static List<DictionaryBase> getDictionaryBaseCacheByCodeType(String codeType){
		return cache.get(codeType);
	}
	
	public static Map<String, List<DictionaryBase>> getCache() {
		return cache;
	}
	public static void setCache(Map<String, List<DictionaryBase>> cache) {
		DictionaryBaseCacheUtil.cache = cache;
	}

	public DictionaryBaseService getDictionaryBaseService() {
		return dictionaryBaseService;
	}
	public void setDictionaryBaseService(DictionaryBaseService dictionaryBaseService) {
		this.dictionaryBaseService = dictionaryBaseService;
	}

	public ServletContextUtil getServletContextUtil() {
		return servletContextUtil;
	}

	public void setServletContextUtil(ServletContextUtil servletContextUtil) {
		this.servletContextUtil = servletContextUtil;
	}
}
