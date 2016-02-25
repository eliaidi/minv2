package com.repair.dict.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.repair.dict.dao.DictionaryBaseDao;
import com.repair.entity.DictionaryBase;
import com.repair.entity.Test;


/**
* @ClassName: DictionaryBaseDaoImpl
* @Description: 字典缓存数据的实现类，把DICTIONARY_BASE表中的数据全部加载到内存中
* @author andy
* @version V1.0  
* @date Jul 24, 2015 9:24:23 AM
*/
public class DictionaryBaseDaoImpl implements DictionaryBaseDao{
	//定义成员变量
	private HibernateTemplate hibernateTemplate;

	public List<DictionaryBase> findAll() {
		return this.hibernateTemplate.find("from DictionaryBase");
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
