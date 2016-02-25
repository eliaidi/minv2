package com.repair.pj.service.impl;

import java.util.List;

import com.repair.entity.PjAssembleRecord;
import com.repair.pj.dao.IPjAssembleRecordDao;
import com.repair.pj.service.IPjAssembleRecordService;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.serviceSupport.BaseService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 车上组装记录service层
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class PjAssembleRecordServiceImpl extends ServiceSupport<PjAssembleRecord> implements IPjAssembleRecordService{

	private IPjAssembleRecordDao pjAssembleRecordDao;
	
	/**
	 * 通过 机车检修日计划ID 进行查询车上组装记录
	 * @param planDateId	机车检修日计划ID
	 * @return
	 */
	public List<PjAssembleRecord> listByPlanDateId(long planDateId){
		return pjAssembleRecordDao.listByPlanDateId(planDateId);
	}

	public void setPjAssembleRecordDao(IPjAssembleRecordDao pjAssembleRecordDao) {
		this.pjAssembleRecordDao = pjAssembleRecordDao;
	}
	
}
