package com.repair.report.service.impl;

import java.util.List;

import com.repair.entity.DictFault;
import com.repair.report.dao.IDictFaultDao;
import com.repair.report.service.IDictFaultService;
import com.repair.util.serviceSupport.ServiceSupport;

public class DictFaultServiceImpl extends ServiceSupport<DictFault> implements IDictFaultService{

	private IDictFaultDao dictFaultDao;
	
	/**
	 * 通过 父级ID进行查找，如果父级ID为null，则查询所有一级部件  
	 * @param parentId	父级ID
	 * @return	故障集合
	 */
	public List<DictFault> listByConditions(Long parentId){
		return dictFaultDao.listByConditions(parentId);
	}

	public void setDictFaultDao(IDictFaultDao dictFaultDao) {
		this.dictFaultDao = dictFaultDao;
	}
	
}
