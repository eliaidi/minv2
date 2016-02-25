package com.repair.pjFix.dao;

import com.repair.entity.PjSDInfoRecordFix;

/**
* @ClassName: PjSDInfoRecordFixDao
* @Description: TODO 配件检修记录dao层接口-配件检修
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午10:38:09
 */
public interface PjSDInfoRecordFixDao {
	
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
