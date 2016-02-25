package com.repair.dict.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.dict.dao.DictFaultDao;
import com.repair.dict.dao.DictProteamDao;
import com.repair.entity.DictFault;
import com.repair.entity.DictProteam;

/**
 * 
 * @see 班组dao层实现
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public class DictProteamDaoImpl implements DictProteamDao{

	//定义成员变量
	private HibernateTemplate hibernateTemplate;
	
	public List<DictProteam> findAll(){
		return hibernateTemplate.find("from DictProteam");
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
