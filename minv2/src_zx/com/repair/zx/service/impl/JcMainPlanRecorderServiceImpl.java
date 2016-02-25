package com.repair.zx.service.impl;

import java.util.List;

import com.repair.entity.JcMainPlanRecorder;
import com.repair.zx.dao.IJcMainPlanRecorderDao;
import com.repair.zx.service.IJcMainPlanRecorderService;

/**
 * @see 机车检修主计划详情service层
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public class JcMainPlanRecorderServiceImpl implements IJcMainPlanRecorderService{
	
	private IJcMainPlanRecorderDao jcMainPlanRecorderDao;
	
	/**
	 * 通过cash字段的值查询主计划详情
	 * @param cash	0为未兑现，1为已兑现
	 * @return
	 */
	public List<JcMainPlanRecorder> listByCash(int cash){
		return jcMainPlanRecorderDao.listByCash(cash);
	}

	
	/**
	 * 列出本周兑现或未兑现的机车检修主计划详情
	 * @param cash	0为未兑现，1为已兑现
	 * @return	机车检修主计划详情集合
	 */
	public List<JcMainPlanRecorder> listThisWeek(int cash){
		return jcMainPlanRecorderDao.listThisWeek(cash);
	}
	
	
	/**
	 * 通过机车型号、机车号、是否兑现进行
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		机车号
	 * @param cash			兑现状态
	 * @return
	 */
	public List<JcMainPlanRecorder> listByConditions(String jcTypeValue,String jcNumber,int cash){
		return jcMainPlanRecorderDao.listByConditions(jcTypeValue, jcNumber, cash);
	}
	
	
	/**
	 * 修改机车检修主计划详情
	 * @param rec	机车检修主计划详情对象
	 */
	public void update(JcMainPlanRecorder rec){
		jcMainPlanRecorderDao.update(rec);
	}
	
	public void setJcMainPlanRecorderDao(
			IJcMainPlanRecorderDao jcMainPlanRecorderDao) {
		this.jcMainPlanRecorderDao = jcMainPlanRecorderDao;
	}
	
}
