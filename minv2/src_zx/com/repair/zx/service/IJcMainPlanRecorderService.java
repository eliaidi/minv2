package com.repair.zx.service;

import java.util.List;

import com.repair.entity.JcMainPlanRecorder;

/**
 * @see 机车检修主计划详情service层
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public interface IJcMainPlanRecorderService {
	
	
	/**
	 * 通过cash字段的值查询主计划详情
	 * @param cash	0为未兑现，1为已兑现
	 * @return
	 */
	public List<JcMainPlanRecorder> listByCash(int cash);
	
	/**
	 * 列出本周兑现或未兑现的机车检修主计划详情
	 * @param cash	0为未兑现，1为已兑现
	 * @return	机车检修主计划详情集合
	 */
	public List<JcMainPlanRecorder> listThisWeek(int cash);
	
	/**
	 * 通过机车型号、机车号、是否兑现进行
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		
	 * @param cash
	 * @return
	 */
	public List<JcMainPlanRecorder> listByConditions(String jcTypeValue,String jcNumber,int cash);

	/**
	 * 修改机车检修主计划详情
	 * @param rec	机车检修主计划详情对象
	 */
	public void update(JcMainPlanRecorder rec);
}
