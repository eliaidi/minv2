package com.repair.pj.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.pj.dao.JcPlanDateDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 机车检修日计划dao层实现
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class JcPlanDateDaoImpl extends DaoSupport<JcPlanDate> implements JcPlanDateDao{

	/**
	 * 通过修次类型获取 尚未交车的机车检修日计划
	 * @param projectType	如果为null，则查询所有未交车的日计划
	 * @return
	 */
	public List<JcPlanDate> listUnDeal(Integer projectType){
		StringBuffer hql=new StringBuffer("from JcPlanDate where 1=1 ");
		
		if(projectType != null){
			hql.append(" and projectType="+projectType);
		}
		
		hql.append(" and jcPlanStatus < "+Constants.JC_PLAN_STATUS_YET_DEAL);
		
		return hibernateTemplate.find(hql.toString());
	}
}
