package com.repair.zx.dao.impl;

import java.util.List;

import com.repair.entity.JcMainPlanRecorder;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.zx.dao.IJcMainPlanRecorderDao;

/**
 * @see 机车检修主计划详情dao层
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public class JcMainPlanRecorderDaoImpl extends DaoSupport<JcMainPlanRecorder> implements IJcMainPlanRecorderDao{
	
	
	/**
	 * 通过cash字段的值查询主计划详情
	 * @param cash	0为未兑现，1为已兑现
	 * @return
	 */
	public List<JcMainPlanRecorder> listByCash(int cash){
		return hibernateTemplate.find("from JcMainPlanRecorder where cash = ?",cash);
	}
	
	/**
	 * 列出本周兑现或未兑现的机车检修主计划详情
	 * @param cash	0为未兑现，1为已兑现
	 * @return	机车检修主计划详情集合
	 */
	public List<JcMainPlanRecorder> listThisWeek(int cash){
		return hibernateTemplate.find("from JcMainPlanRecorder where planDate>=trunc(sysdate,'iw') and planDate < trunc(sysdate+7,'iw') and cash = ?",cash);
	}

	
	/**
	 * 通过机车型号、机车号、是否兑现进行
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		
	 * @param cash
	 * @return
	 */
	public List<JcMainPlanRecorder> listByConditions(String jcTypeValue,String jcNumber,int cash){
		String hql="from JcMainPlanRecorder where jcTypeValue=? and jcNumber=? and cash=?";
		return hibernateTemplate.find(hql,jcTypeValue,jcNumber,cash);
	}
	
	
	
}
