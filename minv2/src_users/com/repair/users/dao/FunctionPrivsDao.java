package com.repair.users.dao;

import java.util.List;
import com.repair.entity.FunctionPrivs;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: FunctionPrivsDao
* @Description: TODO(功能（资源）dao接口)
* @author andy
* @version V1.0  
* @date Aug 3, 2015 10:22:34 AM
*/
public interface FunctionPrivsDao extends BaseDao<FunctionPrivs>{
	
	/**根据功能（资源）名，删除
	 * 参数：functionName[功能（资源）名]*/
	public void delFunctionByFunctionName(String functionName);
	
	/**根据父级id，查找
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]
	 * 参数：parentId[父级id]*/
	public List<FunctionPrivs> findFunctionByParentId(long parentId);
	/**根据激活状态，查找
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]
	 * 参数：activate[激活状态]*/
	public List<FunctionPrivs> findFunctionByActivate(int activate);
	/**查询所有，按菜单（操作功能）名顺序，升序。
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]*/
	public List<FunctionPrivs> findAllOfFunctionOrderASC();
	//通过roleId查询
	public List<FunctionPrivs> findAllFunctionPrivsByRoleId(long id);
}
