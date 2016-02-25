package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.FunctionPrivs;
import com.repair.users.dao.FunctionPrivsDao;
import com.repair.users.service.FunctionPrivsService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
* @ClassName: FunctionPrivsServiceImpl
* @Description: TODO(操作功能(菜单)FunctionPrivs类的service实现)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午2:11:13
 */
public class FunctionPrivsServiceImpl extends ServiceSupport<FunctionPrivs> implements FunctionPrivsService {
	
	private FunctionPrivsDao functionPrivsDao;
	
	
	
	/**根据功能（资源）名，删除
	 * 参数：functionName[功能（资源）名]*/
	public void delFunctionByFunctionName(String functionName){
		functionPrivsDao.delFunctionByFunctionName(functionName);
	}
	
	
	
	/**根据父级id，查找
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]
	 * 参数：parentId[父级id]*/
	public List<FunctionPrivs> findFunctionByParentId(long parentId){
		return functionPrivsDao.findFunctionByParentId(parentId);
	}
	
	/**根据激活状态，查找
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]
	 * 参数：activate[激活状态]*/
	public List<FunctionPrivs> findFunctionByActivate(int activate){
		return functionPrivsDao.findFunctionByActivate(activate);
	}
	
	/**查询所有，按菜单（操作功能）名顺序，升序。
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]*/
	public List<FunctionPrivs> findAllOfFunctionOrderASC(){
		return functionPrivsDao.findAllOfFunctionOrderASC();
	}

	/** 通过角色id查找所有功能 */
	public List<FunctionPrivs> findAllFunctionPrivsByRoleId(long id) {
		return functionPrivsDao.findAllFunctionPrivsByRoleId(id);
	}

	public void setFunctionPrivsDao(FunctionPrivsDao functionPrivsDao) {
		this.functionPrivsDao = functionPrivsDao;
	}

}
