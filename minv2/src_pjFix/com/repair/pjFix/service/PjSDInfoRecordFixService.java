package com.repair.pjFix.service;

import com.repair.entity.PjSDInfoRecordFix;

/** 
* @ClassName: PjSDInfoRecordFixServiceImpl
* @Description: TODO 配件动态信息检修记录service层接口
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午11:32:45
 */
public interface PjSDInfoRecordFixService {
	/**
 	 * 通过配件检修记录ID得到动态配件检修记录对象
	 * @return PjSDInfoRecordFix    
	 * @throws
	 */
	public PjSDInfoRecordFix findPjSDInfoRecordFixById(long id);
	
	/**
	 * 修改配件检修记录
	 * @throws
	 */
	public void updatePjSDInfoRecordFix(PjSDInfoRecordFix fix);
}
