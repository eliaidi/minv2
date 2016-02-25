package com.repair.zx.dao;

import java.util.List;

import com.repair.entity.JcFixFlowRecorder;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 机车检修流程节点记录
 * @author 周云韬
 * @date 2015-12-16
 * @version 1.0
 */
public interface IJcFixFlowRecorderDao extends BaseDao<JcFixFlowRecorder>{

	
	
	/**
	 * 通过日计划ID列出流程节点记录
	 * @param planDateId
	 * @return
	 */
	public List<JcFixFlowRecorder> listByPlanDateId(Long planDateId);
}
