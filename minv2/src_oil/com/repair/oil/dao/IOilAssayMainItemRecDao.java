package com.repair.oil.dao;

import com.repair.entity.OilAssayMainItemRec;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 油水化验主项目dao层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public interface IOilAssayMainItemRecDao extends BaseDao<OilAssayMainItemRec>{

	/**
	 * 通过日计划Id查询油化实验记录主表
	 * @param planDateId 日计划Id
	 * @return
	 */
	public OilAssayMainItemRec findOilAssayMainItemRecByPlanDateId(Long planDateId);
}
