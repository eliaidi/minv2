package com.repair.pj.service.impl;

import com.repair.entity.PjSDInfoRecordSu;
import com.repair.pj.dao.PjSDInfoRecordSuDao;
import com.repair.pj.service.PjSDInfoRecordSuService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
* @ClassName: PjSDInfoRecordSuServiceImpl
* @Description: TODO(动态配件子记录-主仓库，单位)
* @author 周云韬
* @version V1.0  
* @date Nov 25, 2015 9:44:28 AM
 */
public class PjSDInfoRecordSuServiceImpl extends ServiceSupport<PjSDInfoRecordSu> implements PjSDInfoRecordSuService{
	
	private PjSDInfoRecordSuDao pjSDInfoRecordSuDao;
	
	
	public void setPjSDInfoRecordSuDao(PjSDInfoRecordSuDao pjSDInfoRecordSuDao) {
		this.pjSDInfoRecordSuDao = pjSDInfoRecordSuDao;
	}

}
