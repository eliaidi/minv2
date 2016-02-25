package com.repair.report.service;

import java.util.List;

import com.repair.entity.DictFault;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.serviceSupport.BaseService;

public interface IDictFaultService extends BaseService<DictFault>{

	/**
	 * 通过 父级ID进行查找，如果父级ID为null，则查询所有一级部件  
	 * @param parentId	父级ID
	 * @return	故障集合
	 */
	public List<DictFault> listByConditions(Long parentId);
}
