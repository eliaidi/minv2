package com.repair.plan.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.repair.entity.JcMainPlan;
import com.repair.plan.dao.IJcMainPlanDao;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @see 机车检修主计划Dao层实现
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 *
 */
public class JcMainPlanDaoImpl extends DaoSupport implements IJcMainPlanDao{

	/**
	 * 通过主计划ID查找主计划
	 * @param mainPlanId	主计划ID
	 * @return	主计划ID对象
	 */
	public JcMainPlan findById(Long mainPlanId){
		return hibernateTemplate.get(JcMainPlan.class, mainPlanId);
	}
	
	
	/**
	 * 保存机车检修主计划，返回主键ID
	 * @param jcMainPlan
	 * @return
	 */
	public Long save(JcMainPlan jcMainPlan){
		return (Long) hibernateTemplate.save(jcMainPlan);
	}
	
	
	/**
	 * 修改机车检修主计划
	 * @param jcMainPlan
	 * @return
	 */
	public void update(JcMainPlan jcMainPlan){
		hibernateTemplate.update(jcMainPlan);
	}
	
	/**
	 * 删除机车检修主计划
	 * @param jcMainPlan
	 * @return
	 */
	public void delete(JcMainPlan jcMainPlan){
		hibernateTemplate.delete(jcMainPlan);
	}

	
	/**
	 * 通过时间段分页查询机车检修主计划
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @param pageNo	页数，第几页
	 * @param pageSize	每页大小
	 * @return	机车检修主计划集合
	 */
	public SplitPageModel<JcMainPlan> listPageByTimePeriod(Date startTime,Date endTime,int pageNo,int pageSize){
		String hql="from JcMainPlan t where 1=1";
		List<Date> params=new ArrayList<Date>();
		if(startTime!=null){
			hql+=" and t.startTime>=?";
			params.add(startTime);
		}
		if(endTime!=null){
			hql+=" and t.endTime<=?";
			params.add(endTime);
		}
		hql+=" order by t.startTime desc, t.id";
		return splitPageDao.queryList(hql, params, pageNo, pageSize);
	}
	
	/**
	 * 通过时间段查询机车检修主计划
	 * @param startTime	开始时间
	 * @param endTime	结束时间
	 * @return	机车检修主计划集合
	 */
	public List<JcMainPlan> listByTimePeriod(Date startTime,Date endTime){
		String hql="from JcMainPlan t where 1=1";
		List<Date> params=new ArrayList<Date>();
		if(startTime!=null){
			hql+=" and t.startTime>=?";
			params.add(startTime);
		}
		if(endTime!=null){
			hql+=" and t.endTime<=?";
			params.add(endTime);
		}
		System.out.println(startTime+"----"+endTime);
		return hibernateTemplate.find(hql,params.toArray());
	}
	
	
}
