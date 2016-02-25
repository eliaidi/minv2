package com.repair.pj.dao;

import java.util.List;

import com.repair.entity.PjAssembleRecord;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 车上组装记录dao层
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public interface IPjAssembleRecordDao extends BaseDao<PjAssembleRecord>{

	/**
	 * 通过 机车检修日计划ID 进行查询车上组装记录
	 * @param planDateId	机车检修日计划ID
	 * @return
	 */
	public List<PjAssembleRecord> listByPlanDateId(long planDateId);
}
