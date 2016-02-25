package com.repair.zx.service;

import java.util.List;

import com.repair.entity.JcFixFlowRecorder;

/**
 * 
 * @see 机车检修流程节点记录
 * @author 周云韬
 * @date 2015-12-16
 * @version 1.0
 */
public interface IJcFixFlowRecorderService {

	/**
	 * 保存机车检修流程节点记录
	 * @param rec
	 * @return
	 */
	public Long save(JcFixFlowRecorder rec);
	
	
	/**
	 * 修改机车检修流程记录
	 * @param rec
	 */
	public void update(JcFixFlowRecorder rec);
	
	/**
	 * 通过日计划ID列出流程节点记录
	 * @param planDateId
	 * @return
	 */
	public List<JcFixFlowRecorder> listByPlanDateId(Long planDateId);
}
