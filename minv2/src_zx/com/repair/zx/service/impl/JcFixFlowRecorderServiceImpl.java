package com.repair.zx.service.impl;

import java.util.List;

import com.repair.entity.JcFixFlowRecorder;
import com.repair.zx.dao.IJcFixFlowRecorderDao;
import com.repair.zx.service.IJcFixFlowRecorderService;

/**
 * 
 * @see 机车检修流程节点记录
 * @author 周云韬
 * @date 2015-12-16
 * @version 1.0
 */
public class JcFixFlowRecorderServiceImpl implements IJcFixFlowRecorderService{

	private IJcFixFlowRecorderDao jcFixFlowRecorderDao;
	
	/**
	 * 保存机车检修流程节点记录
	 * @param rec
	 * @return
	 */
	public Long save(JcFixFlowRecorder rec){
		return (Long) jcFixFlowRecorderDao.save(rec);
	}
	
	
	/**
	 * 修改机车检修流程记录
	 * @param rec
	 */
	public void update(JcFixFlowRecorder rec){
		jcFixFlowRecorderDao.update(rec);
	}

	/**
	 * 通过日计划ID列出流程节点记录
	 * @param planDateId
	 * @return
	 */
	public List<JcFixFlowRecorder> listByPlanDateId(Long planDateId){
		return jcFixFlowRecorderDao.listByPlanDateId(planDateId);
	}
	
	
	public void setJcFixFlowRecorderDao(IJcFixFlowRecorderDao jcFixFlowRecorderDao) {
		this.jcFixFlowRecorderDao = jcFixFlowRecorderDao;
	}
	
	
	
}
