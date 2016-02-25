package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.DictDepart;
import com.repair.users.dao.DictDepartDao;
import com.repair.users.service.DictDepartService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
* @ClassName: DictDepartServiceImpl
* @Description:部门字典接口的实现
* @author 唐鹏
* @version V1.0  
* @date Jul 30, 2015 上午10:25:53 PM
*/
public class DictDepartServiceImpl extends ServiceSupport<DictDepart> implements DictDepartService {

	private DictDepartDao dictDepartDao;
	
	
	/**根据部门名，删除
	 * 参数：depatName[部门名]*/
	public void delByDictDepartame(String departName) {
		dictDepartDao.delByDictDepartame(departName);
	}
	


	/**根据部门名，查询部门
	 * 返回类型：DictDepart[部门对象]
	 * 参数：depatName[（部门名]*/
	public DictDepart findDictDepartByName(String departName) {
		return dictDepartDao.findDictDepartByName(departName);
	}

	
	
	public void setDictDepartDao(DictDepartDao dictDepartDao) {
		this.dictDepartDao = dictDepartDao;
	}
}
