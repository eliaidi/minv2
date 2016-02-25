package com.repair.pjFix.service.impl;

import com.repair.entity.PjSDInfoRecordFix;
import com.repair.pjFix.dao.PjSDInfoRecordFixDao;
import com.repair.pjFix.service.PjSDInfoRecordFixService;

/**
* @ClassName: PjSDInfoRecordFixServiceImpl
* @Description: TODO 配件检修记录service层实现类
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午11:32:45
 */
public class PjSDInfoRecordFixServiceImpl implements PjSDInfoRecordFixService{
	
	private PjSDInfoRecordFixDao pjSDInfoRecordFixForPjFixDao;
	
	/**
 	 * 通过配件检修记录ID得到动态配件检修记录对象
	 * @return PjSDInfoRecordFix    
	 * @throws
	 */
	public PjSDInfoRecordFix findPjSDInfoRecordFixById(long id){
		return pjSDInfoRecordFixForPjFixDao.findPjSDInfoRecordFixById(id);
	}
	
	/**
	 * 修改配件检修记录
	 * @throws
	 */
	public void updatePjSDInfoRecordFix(PjSDInfoRecordFix fix){
		pjSDInfoRecordFixForPjFixDao.updatePjSDInfoRecordFix(fix);
	}
	
	public void setPjSDInfoRecordFixForPjFixDao(
			PjSDInfoRecordFixDao pjSDInfoRecordFixForPjFixDao) {
		this.pjSDInfoRecordFixForPjFixDao = pjSDInfoRecordFixForPjFixDao;
	}
	
}
