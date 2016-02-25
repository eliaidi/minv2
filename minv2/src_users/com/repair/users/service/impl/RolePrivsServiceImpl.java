package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.users.dao.RolePrivsDao;
import com.repair.users.service.RolePrivsService;
import com.repair.util.page.PageModel;

/**
 * ClassName: RolePrivsServiceImpl
 * @Package com.repair.users.service.impl
 * @Description: TODO(角色service接口实现类)
 * @author lxb
 * @datetime 2015-8-4 上午09:15
 */
public class RolePrivsServiceImpl implements RolePrivsService {
	// 定义成员变量
	private RolePrivsDao rolePrivsDao;

	/** 添加role信息*/
	public void addRolePrivsService(RolePrivs rolePrivs) {
		rolePrivsDao.addRolePrivsDao(rolePrivs);
	}

	/** 根据Id删除数据*/
	public void deleteRolePrivsByIdService(long id) {
		rolePrivsDao.deleteRolePrivsByIdDao(id);
	}

	/** 根据roleName删除数据*/
	public void deleteRolePrivsByRoleNameService(String roleName) {
		rolePrivsDao.deleteRolePrivsByRoleNameDao(roleName);
	}

	/** 查询Role所有信息 */
	public List<RolePrivs> findRolePrivsAllService() {
		return rolePrivsDao.findRolePrivsAllDao();
	}

	/** 根据Id查询数据*/
	public RolePrivs findRolePrivsByIdService(long id) {
		return rolePrivsDao.findRolePrivsByIdDao(id);
	}

	/** 通过id修改role数据*/
	public void updateRolePrivsByIdService(RolePrivs rolePrivs) {
		rolePrivsDao.updateRolePrivsByIdDao(rolePrivs);
	}

	/** 根据roleName查询数据*/
	public RolePrivs findRolePrivsByNameService(String name) {
		return this.rolePrivsDao.findRolePrivsByNameDao(name);
	}

	/** 根据用户对象中不为空的值查询用户列表 返回类型：List<RolePrivs> 参数：rolePrivs*/
	public PageModel<RolePrivs> findRolePrivsList() {
		return rolePrivsDao.findRolePrivsList();
	}
	
	 /** 根据角色Id,查询功能表信息*/
	public List<RolePrivs> findFunctinPrivsAll(long roleId) {
		return rolePrivsDao.findFunctinPrivsAll(roleId);
	}
	

	/**
	 * 通过角色id删除用户角色中间表对应的数据
	 */
	public void deleteUsersRolePrivsByRoleId(long roleId) {
		// TODO Auto-generated method stub
		rolePrivsDao.deleteUsersRolePrivsByRoleId(roleId);
	}

	/**
	 * 根据roleId查询users_role_privs对象
	 */
	public  List<UsersRolePrivs>   findUserRolePrivsByRoleId(long roleid) {
		// TODO Auto-generated method stub
		return rolePrivsDao.findUserRolePrivsByRoleId(roleid);
	}

	/**
	 * 根据Id查询users_role_privs对象
	 */
	public UsersRolePrivs findUsersRolePrivsById(long id) {
		// TODO Auto-generated method stub
		return rolePrivsDao.findUsersRolePrivsById(id);
	}

	public List<UsersRolePrivs> findAllUsersRolePrivs() {
		// TODO Auto-generated method stub
		return rolePrivsDao.findAllUsersRolePrivs();
	}

	public RolePrivsDao getRolePrivsDao() {
		return rolePrivsDao;
	}

	public void setRolePrivsDao(RolePrivsDao rolePrivsDao) {
		this.rolePrivsDao = rolePrivsDao;
	}

}
