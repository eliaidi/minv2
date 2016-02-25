package com.repair.users.dao;

import java.util.List;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.util.page.PageModel;

/**
* @ClassName: RolePrivsDao
* @Description: TODO(角色dao接口，其实就是职务dao接口）
* @author andy
* @version V1.0  
* @date Aug 3, 2015 10:03:40 AM
 */
public interface RolePrivsDao {
	/**添加角色
	 * 参数：rolePrivs[角色对象]*/
	public void addRolePrivsDao(RolePrivs rolePrivs);
	/**根据id，删除
	 * 参数：id[角色id]*/
	public void deleteRolePrivsByIdDao(long id);
	/**根据角色名，删除
	 * 参数：roleName[角色名]*/
	public void deleteRolePrivsByRoleNameDao(String roleName);
	/**根据角色id，修改
	 * 参数：rolePrivs[角色对象]*/
	public void updateRolePrivsByIdDao(RolePrivs rolePrivs);
	/**查询所有角色
	 * 返回类型：List<RolePrivs>[角色对象集合]*/
	public List<RolePrivs> findRolePrivsAllDao();
	/**根据角色id，查找
	 * 返回类型：RolePrivs[角色]
	 * 参数：id[角色id]*/
	public RolePrivs findRolePrivsByIdDao(long id);
	/**根据角色Name,查找
	 * 返回类型：RolePrivs[角色]*/
	public RolePrivs findRolePrivsByNameDao(String name);
	/**根据用户对象中不为空的值查询用户列表
	 * 返回类型：List<UsersPrivs>
	 * 参数：userPrivs*/
	public PageModel<RolePrivs> findRolePrivsList();
	/**根据roleID查找[function_privs]对象
	 *返回类型：List<RolePrivs>：角色类型集合
	 *参数：roleId[角色id]*/
	public List<RolePrivs> findFunctinPrivsAll(long roleId);
	/**删除通过roleId删除角色中间表对应的数据
	 *返回类型：List<RolePrivs>：角色类型集合
	 *参数：roleId[角色id]*/
	public void deleteUsersRolePrivsByRoleId(long id);
	/**根据roleId查询users_role_privs对象
	 * 参数：id[角色Id]*/
	public List<UsersRolePrivs>  findUserRolePrivsByRoleId(long roleid); 
	/** 根据id查询users_role_privs对象
	 *  返回类型：List<UsersRolePrivs>：用户类集合
	 *  参数：roleid[角色Id]*/
	 public UsersRolePrivs findUsersRolePrivsById(long id);
	 /**返回所有users_role_privs对象
	  * 返回类型：UsersRolePrivs：用户角色*/ 
	 public List<UsersRolePrivs> findAllUsersRolePrivs();
}
