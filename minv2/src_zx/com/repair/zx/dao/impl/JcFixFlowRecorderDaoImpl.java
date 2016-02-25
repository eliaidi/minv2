package com.repair.zx.dao.impl;

import java.util.List;

import com.repair.entity.JcFixFlowRecorder;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.zx.dao.IJcFixFlowRecorderDao;

/**
 * 
 * @see 机车检修流程节点记录dao层
 * @author 周云韬
 * @date 2015-12-16
 * @version 1.0
 */
public class JcFixFlowRecorderDaoImpl extends DaoSupport<JcFixFlowRecorder> implements IJcFixFlowRecorderDao{

	/**
	 * 通过日计划ID列出流程节点记录
	 * @param planDateId
	 * @return
	 */
	public List<JcFixFlowRecorder> listByPlanDateId(Long planDateId){
		return hibernateTemplate.find("from JcFixFlowRecorder where jcPlanDate.id="+planDateId);
	}
}
