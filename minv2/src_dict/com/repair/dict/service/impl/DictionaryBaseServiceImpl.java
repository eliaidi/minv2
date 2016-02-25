package com.repair.dict.service.impl;

import java.util.List;

import com.repair.dict.dao.DictionaryBaseDao;
import com.repair.dict.service.DictionaryBaseService;
import com.repair.entity.DictionaryBase;

public class DictionaryBaseServiceImpl implements DictionaryBaseService {
	
	private DictionaryBaseDao dictionaryBaseDao;

	public List<DictionaryBase> findAll() {
		return dictionaryBaseDao.findAll();
	}

	public DictionaryBaseDao getDictionaryBaseDao() {
		return dictionaryBaseDao;
	}

	public void setDictionaryBaseDao(DictionaryBaseDao dictionaryBaseDao) {
		this.dictionaryBaseDao = dictionaryBaseDao;
	}
}
