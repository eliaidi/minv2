package com.repair.users.service;

import java.util.List;
import com.repair.entity.DictDepart;
import com.repair.util.serviceSupport.BaseService;

/** 
* @ClassName: DictDepartService
* @Description: TODO(部门类(DictDepartService)接口)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-4 上午10:42:56
 */
public interface DictDepartService extends BaseService<DictDepart>{
	
	
	
	/**根据部门名，删除
	 * 参数：depatName[部门名]*/
	public void delByDictDepartame(String departName);
	
	
	
	/**根据部门名，查询部门
	 * 返回类型：DictDepart[部门对象]
	 * 参数：depatName[（部门名]*/
	public DictDepart findDictDepartByName(String departName);
}

