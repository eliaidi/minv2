package com.repair.zx.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.zx.dao.IJcPlanDateDao;

/**
 * 
 * @see 机车检修日计划dao层
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public class JcPlanDateDaoImpl extends DaoSupport<JcPlanDate> implements IJcPlanDateDao{
	
	/**
	 * 列出所有未交车的机车日计划
	 * @return
	 */
	public List<JcPlanDate> listByUnOut(){
		return hibernateTemplate.find("from JcPlanDate where jcPlanStatus != "+Constants.JC_PLAN_STATUS_OUT);
	}
	
	/**
	 * 通过机车型号和机车号进行查询
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		车号
	 * @return
	 */
	public List<JcPlanDate> listByConditions(String jcTypeValue,String jcNumber){
		return hibernateTemplate.find("from JcPlanDate where jcTypeValue=? and jcNumber=?",jcTypeValue,jcNumber);
	}
	
}
