package com.repair.report.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.report.dao.IJcPlanDateDao;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 机车检修日计划
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class JcPlanDateDaoImpl extends DaoSupport<JcPlanDate> implements IJcPlanDateDao{

	/**
	 * 列出 所有未交车的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listUnDeal(){
		String hql="from JcPlanDate where jcPlanStatus < "+Constants.JC_PLAN_STATUS_YET_DEAL;
		return hibernateTemplate.find(hql);
	}
}
