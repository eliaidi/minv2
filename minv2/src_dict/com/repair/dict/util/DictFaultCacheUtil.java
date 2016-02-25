package com.repair.dict.util;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import com.repair.constant.CacheConstants;
import com.repair.dict.service.DictFaultService;
import com.repair.entity.DictFault;
import com.repair.util.ServletContextUtil;

/**
 * 
 * @see 故障字典缓存类
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public class DictFaultCacheUtil implements InitializingBean{
	private DictFaultService dictFaultService;
	
	private static final Logger LOGGER=Logger.getLogger(DictionaryBaseCacheUtil.class);
	
	private ServletContextUtil servletContextUtil; //注入servletContextUtil对全局信息存储空间类（类注入）

	

	/** 
	* @Title: afterPropertiesSet 
	* @Description: 实现InitializingBean接口,spring加载时启动,从数据库中dict_fault读取所有数据，并加入到ServletContext中，供全局使用
	* @param  无
	* @return 无
	* @throws 
	*/ 	
	@Override
	public void afterPropertiesSet() throws Exception {
		List<DictFault> list=dictFaultService.findAll();
		
		servletContextUtil.setServletContext(CacheConstants.CACHE_DICT_FAULT_LIST, list);
	}
	
	public void setDictFaultService(DictFaultService dictFaultService) {
		this.dictFaultService = dictFaultService;
	}
	
	public void setServletContextUtil(ServletContextUtil servletContextUtil) {
		this.servletContextUtil = servletContextUtil;
	}

}
