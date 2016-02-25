package com.repair.users.service;

import java.util.List;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.util.page.PageModel;

/**
 * ClassName: RolePrivsService
 * 
 * @Package com.repair.users.service
 * @Description: TODO(角色表service接口)
 * @author lxb
 * @datetime 2015-8-4 上午09:15
 */
public interface RolePrivsService {
	/**
	 * 添加角色 参数：rolePrivs[角色对象]
	 */
	public void addRolePrivsService(RolePrivs rolePrivs);

	/**
	 * 根据id，删除 参数：id[角色id]
	 */
	public void deleteRolePrivsByIdService(long id);

	/**
	 * 根据角色名，删除 参数：roleName[角色名]
	 */
	public void deleteRolePrivsByRoleNameService(String roleName);

	/**
	 * 根据角色id，修改 参数：rolePrivs[角色对象]
	 */
	public void updateRolePrivsByIdService(RolePrivs rolePrivs);

	/**
	 * 查询所有角色 返回类型：List<RolePrivs>[角色对象集合]
	 */
	public List<RolePrivs> findRolePrivsAllService();

	/**
	 * 根据角色id，查找 返回类型：RolePrivs[角色] 参数：id[角色id]
	 */
	public RolePrivs findRolePrivsByIdService(long id);

	/**
	 * 根据角色Name,查找 返回类型：RolePrivs[角色]
	 */
	public RolePrivs findRolePrivsByNameService(String name);

	/**
	 * 根据用户对象中不为空的值查询用户列表 返回类型：List<UsersPrivs> 参数：userPrivs
	 */
	public PageModel<RolePrivs> findRolePrivsList();

	/** 根据roleID查找[function_privs]对象 */
	public List<RolePrivs> findFunctinPrivsAll(long roleId);

	/** 删除通过roleId删除角色中间表对应的数据 */
	public void deleteUsersRolePrivsByRoleId(long roleId);

	/** 根据roleId查询users_role_privs对象 */
	public List<UsersRolePrivs> findUserRolePrivsByRoleId(long roleid);

	/** 根据id查询users_role_privs对象 */
	public UsersRolePrivs findUsersRolePrivsById(long id);

	/** 返回所有users_role_privs对象 */
	public List<UsersRolePrivs> findAllUsersRolePrivs();
}
