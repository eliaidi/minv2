package com.repair.dict.service.impl;

import java.util.List;

import com.repair.dict.dao.DictFaultDao;
import com.repair.dict.service.DictFaultService;
import com.repair.entity.DictFault;

/**
 * 
 * @see 故障字典service层
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public class DictFaultServiceImpl implements DictFaultService{

	private DictFaultDao dictFaultDao;
	
	public List<DictFault> findAll(){
		return dictFaultDao.findAll();
	}

	public void setDictFaultDao(DictFaultDao dictFaultDao) {
		this.dictFaultDao = dictFaultDao;
	}
	
	
}
