package com.repair.report.service;

import java.util.List;

import com.repair.entity.JcPlanDate;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.serviceSupport.BaseService;

/**
 * 
 * @see 机车检修日计划
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public interface IJcPlanDateService extends BaseService<JcPlanDate>{

	/**
	 * 列出 所有未交车的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listUnDeal();
}
