package com.repair.oil.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.oil.dao.IJcPlanDateDao;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 机车日计划dao层
 * @author 周云韬
 * @date 2015-12-22
 * @version 1.0
 */
public class JcPlanDateDaoImpl extends DaoSupport<JcPlanDate> implements IJcPlanDateDao{

	/**
	 * 列出 在修状态的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listInRepair(){
		String hql="from JcPlanDate where jcPlanStatus="+Constants.JC_PLAN_STATUS_IN_REPAIR;
		return hibernateTemplate.find(hql);
	}
}
