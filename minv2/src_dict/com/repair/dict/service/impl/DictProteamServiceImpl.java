package com.repair.dict.service.impl;

import java.util.List;

import com.repair.dict.dao.DictProteamDao;
import com.repair.dict.service.DictProteamService;
import com.repair.entity.DictProteam;

/**
 * 
 * @see 班组service层
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public class DictProteamServiceImpl implements DictProteamService{

	private DictProteamDao dictProteamDao;
	
	public List<DictProteam> findAll(){
		return dictProteamDao.findAll();
	}

	public void setDictProteamDao(DictProteamDao dictProteamDao) {
		this.dictProteamDao = dictProteamDao;
	}
	
}
