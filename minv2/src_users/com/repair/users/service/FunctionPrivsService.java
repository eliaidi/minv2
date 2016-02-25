package com.repair.users.service;

import java.util.List;
import com.repair.entity.FunctionPrivs;
import com.repair.util.serviceSupport.BaseService;

/**
* @ClassName: FunctionPrivsService
* @Description: TODO(功能(资源)FunctionPrivs类的service接口)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午2:10:29
 */
public interface FunctionPrivsService extends BaseService<FunctionPrivs>{
	
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
	/**通过角色id查找所有角色功能
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]*/
	public List<FunctionPrivs> findAllFunctionPrivsByRoleId(long roleId);

}
