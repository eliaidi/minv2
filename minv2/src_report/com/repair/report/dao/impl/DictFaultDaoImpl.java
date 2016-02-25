package com.repair.report.dao.impl;

import java.util.List;

import com.repair.entity.DictFault;
import com.repair.report.dao.IDictFaultDao;
import com.repair.util.daoSupport.DaoSupport;

public class DictFaultDaoImpl extends DaoSupport<DictFault> implements IDictFaultDao{

	/**
	 * 通过 父级ID进行查找，如果父级ID为null，则查询所有一级部件  
	 * @param parentId	父级ID
	 * @return	故障集合
	 */
	public List<DictFault> listByConditions(Long parentId){
		if( parentId == null){
			String hql="from DictFault where parent.id is null";
			return hibernateTemplate.find(hql);
		}else{
			String hql="from DictFault where parent.id=? ";
			return hibernateTemplate.find(hql,parentId);
		}
	}
}
