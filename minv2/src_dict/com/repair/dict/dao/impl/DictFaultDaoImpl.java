package com.repair.dict.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.dict.dao.DictFaultDao;
import com.repair.entity.DictFault;

/**
 * 
 * @see 故障字典dao层实现
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public class DictFaultDaoImpl implements DictFaultDao{

	//定义成员变量
	private HibernateTemplate hibernateTemplate;
	
	public List<DictFault> findAll(){
		return hibernateTemplate.find("from DictFault");
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
