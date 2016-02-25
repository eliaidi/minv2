package com.repair.users.dao;

import java.util.List;
import com.repair.entity.DictDepart;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: DictDepartDao
* @Description: TODO(部门类(DictDepartDao)接口)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-4 上午10:39:57
*/
public interface DictDepartDao extends BaseDao<DictDepart>{
	
	
	
	/**根据部门名，删除
	 * 参数：depatName[部门名]*/
	public void delByDictDepartame(String departName);
	
	
	
	/**根据部门名，查询部门
	 * 返回类型：DictDepart[部门对象]
	 * 参数：depatName[（部门名]*/
	public DictDepart findDictDepartByName(String departName);
}
