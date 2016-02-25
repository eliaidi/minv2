package com.repair.pj.service.impl;

import java.util.List;

import com.repair.entity.JcPlanDate;
import com.repair.pj.dao.JcPlanDateDao;
import com.repair.pj.service.JcPlanDateService;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 机车检修日计划dao层实现
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class JcPlanDateServiceImpl extends ServiceSupport<JcPlanDate> implements JcPlanDateService{

	private JcPlanDateDao jcPlanDateDao;
	
	
	/**
	 * 通过修次类型获取 尚未交车的机车检修日计划
	 * @param projectType	如果为null，则查询所有未交车的日计划
	 * @return
	 */
	public List<JcPlanDate> listUnDeal(Integer projectType){
		return jcPlanDateDao.listUnDeal(projectType);
	}


	public void setJcPlanDateDao(JcPlanDateDao jcPlanDateDao) {
		this.jcPlanDateDao = jcPlanDateDao;
	}
	
}
