package com.repair.oil.service.impl;

import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.dao.IOilAssayMainItemRecDao;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 油水化验主记录service层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayMainItemRecServiceImpl extends ServiceSupport<OilAssayMainItemRec> implements IOilAssayMainItemRecService{

	private IOilAssayMainItemRecDao oilAssayMainItemRecDao;
	
	/**
	 * 通过日计划Id查询油化实验记录主表
	 */
	public OilAssayMainItemRec findOilAssayMainItemRecByPlanDateId(
			Long planDateId) {
		return oilAssayMainItemRecDao.findOilAssayMainItemRecByPlanDateId(planDateId);
	}

	public void setOilAssayMainItemRecDao(
			IOilAssayMainItemRecDao oilAssayMainItemRecDao) {
		this.oilAssayMainItemRecDao = oilAssayMainItemRecDao;
	}

	
	
}
