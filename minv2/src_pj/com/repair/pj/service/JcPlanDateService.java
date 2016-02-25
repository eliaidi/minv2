package com.repair.pj.service;

import java.util.List;

import com.repair.entity.JcPlanDate;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.serviceSupport.BaseService;

/**
 * 
 * @see 机车检修日计划service层接口
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public interface JcPlanDateService extends BaseService<JcPlanDate>{

	
	/**
	 * 通过修次类型获取 尚未交车的机车检修日计划
	 * @param projectType	如果为null，则查询所有未交车的日计划
	 * @return
	 */
	public List<JcPlanDate> listUnDeal(Integer projectType);
}
