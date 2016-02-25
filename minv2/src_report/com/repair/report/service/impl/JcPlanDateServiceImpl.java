package com.repair.report.service.impl;

import java.util.List;

import com.repair.entity.JcPlanDate;
import com.repair.report.dao.IJcPlanDateDao;
import com.repair.report.service.IJcPlanDateService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 机车检修日计划
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class JcPlanDateServiceImpl extends ServiceSupport<JcPlanDate> implements IJcPlanDateService{

	private IJcPlanDateDao jcPlanDateDao;
	
	/**
	 * 列出 所有未交车的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listUnDeal(){
		return jcPlanDateDao.listUnDeal();
	}

	public void setJcPlanDateDao(IJcPlanDateDao jcPlanDateDao) {
		this.jcPlanDateDao = jcPlanDateDao;
	}
	
	
	
}
