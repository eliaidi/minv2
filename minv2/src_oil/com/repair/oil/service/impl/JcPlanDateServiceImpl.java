package com.repair.oil.service.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.oil.dao.IJcPlanDateDao;
import com.repair.oil.service.IJcPlanDateService;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.serviceSupport.BaseService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 机车日计划service层
 * @author 周云韬
 * @date 2015-12-22
 * @version 1.0
 */
public class JcPlanDateServiceImpl  extends ServiceSupport<JcPlanDate> implements IJcPlanDateService{

	private IJcPlanDateDao jcPlanDateDao;
	
	/**
	 * 列出 在修状态的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listInRepair(){
		return jcPlanDateDao.listInRepair();
	}

	public void setJcPlanDateDao(IJcPlanDateDao jcPlanDateDao) {
		this.jcPlanDateDao = jcPlanDateDao;
	}
	
	
}
