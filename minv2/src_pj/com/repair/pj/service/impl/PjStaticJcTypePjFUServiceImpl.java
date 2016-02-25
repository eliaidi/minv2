package com.repair.pj.service.impl;

import com.repair.entity.PjStaticJcTypePjFU;
import com.repair.pj.dao.PjStaticJcTypePjFUDao;
import com.repair.pj.service.PjStaticJcTypePjFUService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
* @ClassName: PjStaticJcTypePjFUServiceImpl
* @Description: TODO(配件静态信息，机车类型-大部件（专业）中间表Service层实现类)
* @author 周云韬
* @version V1.0  
* @date Nov 25, 2015 9:47:27 AM
 */
public class PjStaticJcTypePjFUServiceImpl extends ServiceSupport<PjStaticJcTypePjFU> implements PjStaticJcTypePjFUService{

	private PjStaticJcTypePjFUDao pjStaticJcTypePjFUDao;
	
	
	public void setPjStaticJcTypePjFUDao(PjStaticJcTypePjFUDao pjStaticJcTypePjFUDao) {
		this.pjStaticJcTypePjFUDao = pjStaticJcTypePjFUDao;
	}

	
}
