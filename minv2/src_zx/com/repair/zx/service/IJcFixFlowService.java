package com.repair.zx.service;

import java.util.List;

import com.repair.entity.JcFixFlow;



/**
 * 
 * @see 机车检修流程节点service层
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public interface IJcFixFlowService {
	
	/**
	 * 通过机车类型和修次列出流程节点
	 * @param jcType	机车类型
	 * @param fixMileage	修次
	 * @return	流程节点集合
	 */
	public List<JcFixFlow> list(String jcType,String fixMileage);
	
}
