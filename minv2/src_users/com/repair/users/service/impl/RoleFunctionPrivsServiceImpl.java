package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.users.dao.RoleFunctionPrivsDao;
import com.repair.users.service.RoleFunctionPrivsService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
* @ClassName: RoleFunctionPrivsServiceImpl
* @Description: TODO(角色功能中间表类service接口实现)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午2:42:40
*/
public class RoleFunctionPrivsServiceImpl extends ServiceSupport<RoleFunctionPrivs> implements RoleFunctionPrivsService{
	
	private RoleFunctionPrivsDao roleFunctionPrivsDao;
	
	public void setRoleFunctionPrivsDao(RoleFunctionPrivsDao roleFunctionPrivsDao) {
		this.roleFunctionPrivsDao = roleFunctionPrivsDao;
	}

	
	/**根据角色id，删除
	 * 参数：rolePrivsId[角色id]*/
	public void delRoleFunctionByRole_privs_id(long rolePrivsId){
		roleFunctionPrivsDao.delRoleFunctionByRole_privs_id(rolePrivsId);
	}
	/**根据功能id，删除
	 * 参数：functionPrivsId[功能id]*/
	public void delRoleFunctionByFunctionPrivsId(long functionPrivsId){
		roleFunctionPrivsDao.delRoleFunctionByFunctionPrivsId(functionPrivsId);
	}

	/** 通过角色id查找所有角色功能 */
	public RoleFunctionPrivs findRoleFunctionPrivsByID(long roleId) {
		return roleFunctionPrivsDao.findRoleFunctionPrivsByID(roleId);
	}

	/**通过roleId获取角色所拥有的功能*/
	public List<RoleFunctionPrivs> findRoleFuncs(long roleId) {
		return roleFunctionPrivsDao.findRoleFuncs(roleId);
	}
	
}
