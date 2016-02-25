package com.repair.pj.dao.impl;

import java.util.List;

import com.repair.entity.PjAssembleRecord;
import com.repair.pj.dao.IPjAssembleRecordDao;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 车上组装记录dao层
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class PjAssembleRecordDaoImpl extends DaoSupport<PjAssembleRecord> implements IPjAssembleRecordDao{

	
	/**
	 * 通过 机车检修日计划ID 进行查询车上组装记录
	 * @param planDateId	机车检修日计划ID
	 * @return
	 */
	public List<PjAssembleRecord> listByPlanDateId(long planDateId){
		return hibernateTemplate.find("from PjAssembleRecord where planDate.id="+planDateId);
	}
}
