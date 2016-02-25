package com.repair.plan.service.impl;

import java.util.Date;
import java.util.List;
import com.repair.entity.JcMainPlan;
import com.repair.plan.dao.IJcMainPlanDao;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @see 机车检修主计划service层实现
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class JcMainPlanServiceImpl implements IJcMainPlanService{

	private IJcMainPlanDao jcMainPlanDao;
	
	/**
	 * 通过主计划ID查找主计划
	 * @param mainPlanId
	 * @return
	 */
	public JcMainPlan findById(Long mainPlanId){
		return jcMainPlanDao.findById(mainPlanId);
	}
	
	
	/**
	 * 保存机车检修主计划，返回主键ID
	 * @param jcMainPlan
	 * @return
	 */
	public Long save(JcMainPlan jcMainPlan){
		return jcMainPlanDao.save(jcMainPlan);
	}
	
	/**
	 * 修改机车检修主计划
	 * @param jcMainPlan
	 * @return
	 */
	public void update(JcMainPlan jcMainPlan){
		jcMainPlanDao.update(jcMainPlan);
	}

	

	/**
	 * 删除机车检修主计划
	 * @param jcMainPlan
	 * @return
	 */
	public void delete(JcMainPlan jcMainPlan){
		jcMainPlanDao.delete(jcMainPlan);
	}
	
	/**
	 * 通过时间段查询机车检修主计划
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @param pageNo	页数，第几页
	 * @param pageSize	每页大小
	 * @return	机车检修主计划集合
	 */
	public SplitPageModel<JcMainPlan> listPageByTimePeriod(Date startTime,Date endTime,int pageNo,int pageSize){
		return jcMainPlanDao.listPageByTimePeriod(startTime, endTime, pageNo, pageSize);
		
	}
	
	/**
	 * 通过时间段查询机车检修主计划
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @return	机车检修主计划集合
	 */
	public List<JcMainPlan> listByTimePeriod(Date startTime,Date endTime){
		return jcMainPlanDao.listByTimePeriod(startTime, endTime);
	}
	
	


	public void setJcMainPlanDao(IJcMainPlanDao jcMainPlanDao) {
		this.jcMainPlanDao = jcMainPlanDao;
	}
	
	
}
