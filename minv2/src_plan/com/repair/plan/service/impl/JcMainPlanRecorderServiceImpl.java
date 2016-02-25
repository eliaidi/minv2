package com.repair.plan.service.impl;

import java.util.Date;
import java.util.List;

import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.dao.IJcMainPlanRecorderDao;
import com.repair.plan.service.IJcMainPlanRecorderService;

/**
 * @see 机车检修主计划详情service层
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class JcMainPlanRecorderServiceImpl implements IJcMainPlanRecorderService{
	
	private IJcMainPlanRecorderDao jcMainPlanRecorderDao;
	
	/**
	 * 通过时间段查找机车检修主计划详情集合
	 * @param startTime		开始时间
	 * @param endTime		结束时间
	 * @return	机车检修主计划详情集合
	 */
	public List<JcMainPlanRecorder> listByTimePeriod(Date startTime,Date endTime){
		return jcMainPlanRecorderDao.listByTimePeriod(startTime, endTime);
	}
	
	
	/**
	 * 通过主计划详情ID获取对应的检修计划详情
	 * @param planRecorder
	 * @return
	 */
	public JcMainPlanRecorder findById(Long planRecorderId){
		return jcMainPlanRecorderDao.findById(planRecorderId);
	}
	
	/**
	 * 删除检修主计划
	 * @param recorder
	 */
	public void delete(JcMainPlanRecorder recorder){
		jcMainPlanRecorderDao.delete(recorder);
	}
	
	/**
	 * 保存或者修改主计划详情
	 * @param planRecorder	主计划详情对象
	 * @return  返回ID
	 */
	public Long save(JcMainPlanRecorder planRecorder){
		return jcMainPlanRecorderDao.save(planRecorder);
	}


	
	/**
	 * 修改主计划详情
	 * @param planRecorder	主计划详情对象
	 * @return  返回ID
	 */
	public void update(JcMainPlanRecorder planRecorder){
		jcMainPlanRecorderDao.update(planRecorder);
	}
	
	public void setJcMainPlanRecorderDao(
			IJcMainPlanRecorderDao jcMainPlanRecorderDao) {
		this.jcMainPlanRecorderDao = jcMainPlanRecorderDao;
	}
	
	/**
	 * 通过字段名和字段值进行修改
	 * @param id：机车检修计划详情ID
	 * @param fieldName	字段的名字
	 * @param fieldValue 字段的值
	 */
	public void update(Long id,String fieldName,Object fieldValue){
		jcMainPlanRecorderDao.update(id,fieldName,fieldValue);
	}
	
}
