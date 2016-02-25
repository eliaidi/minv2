package com.repair.plan.dao;

import java.util.Date;
import java.util.List;

import com.repair.entity.JcMainPlan;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @see 机车检修主计划Dao层
 * @author Administrator
 * @date 2015-11-13
 * @version 1.0
 */
public interface IJcMainPlanDao {

	/**
	 * 通过主计划ID查找主计划
	 * @param mainPlanId
	 * @return
	 */
	public JcMainPlan findById(Long mainPlanId);
	
	
	/**
	 * 保存机车检修主计划，返回主键ID
	 * @param jcMainPlan
	 * @return
	 */
	public Long save(JcMainPlan jcMainPlan);
	
	/**
	 * 修改机车检修主计划
	 * @param jcMainPlan
	 * @return
	 */
	public void update(JcMainPlan jcMainPlan);


	/**
	 * 删除机车检修主计划
	 * @param jcMainPlan
	 * @return
	 */
	public void delete(JcMainPlan jcMainPlan);
	
	
	/**
	 * 通过时间段查询机车检修主计划
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @param pageNo	页数，第几页
	 * @param pageSize	每页大小
	 * @return	机车检修主计划集合
	 */
	public SplitPageModel<JcMainPlan> listPageByTimePeriod(Date startTime,Date endTime,int pageNo,int pageSize);
	
	
	/**
	 * 通过时间段查询机车检修主计划
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @return	机车检修主计划集合
	 */
	public List<JcMainPlan> listByTimePeriod(Date startTime,Date endTime);
}
