package com.repair.users.dao;

import java.util.List;
import com.repair.entity.UsersPrivs;
import com.repair.util.page.PageModel;

/**
* @ClassName: UsersPrivsDao
* @Description: TODO(用户类dao接口）
* @author andy
* @version V1.0  
* @date Aug 3, 2015 9:43:11 AM
 */
public interface UsersPrivsDao {
	/**添加用户
	 * 参数：usersPrivs[用户对象]*/
	public void addUsers(UsersPrivs usersPrivs);
	/**根据id，删除
	 * 参数：id[用户id]*/
	public void delUsersById(long id);
	/**根据用户名，删除
	 * 参数：userName[用户名]*/
	public void delUsersByUserName(String userName);
	/**根据用户id，修改
	 * 参数：usersPrivs[用户对象]*/
	public void updateUsersById(UsersPrivs usersPrivs);
	/**查询所有用户
	 * 返回类型：List<UsersPrivs>[用户对象集合]*/
	public List<UsersPrivs> findAllUsers();
	/**根据用户id，查找
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：id[用户id]*/
	public UsersPrivs findUsersById(long id);
	/**根据用户名，查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：userName[用户名]*/
	public UsersPrivs findUsersByName(String userName);
	/**根据地区/机务段id，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：dictAreaId[地区机/务段id]*/
	public List<UsersPrivs> findUsersByDictAreaId(String dictAreaId);
	/**根据激活状态，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：status[激活状态]*/
	public List<UsersPrivs> findUsersByStatus(int status);
	/**根据部门id，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：dictDepartId[部门id]*/
	public PageModel<UsersPrivs> findUsersByDictDepartId(long dictDepartId);
	/**根据班组id，查询
	 * 返回类型：List<UsersPrivs>[用户集合]
	 * 参数：dictProteamId[班组id]*/
	public PageModel<UsersPrivs> findUsersByDictProteamId(long dictProteamId);
	/**根据工号，查询
	 * 返回类型：UsersPrivs[用户类]
	 * 参数：jobNum[工号]*/
	public UsersPrivs findUsersByJobNum(String jobNum);
	/**根据卡号，查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：cardNum[卡号]*/
	public UsersPrivs findUsersByCardNum(String cardNum);
	/**根据角色id，查询。(角色表，其实就是职务表-字段ID)
	 * 返回类型：List<UsersPrivs>[用户集合]
	 * 参数：rolePrivsId[角色id]*/
	public List<UsersPrivs> findUsersByRolePrivsId(int rolePrivsId);
	/**根据性别，查询。（性别：0、男；1、女）
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：gender[性别]*/
	public List<UsersPrivs> findUsersByGender(int gender);
	/**根据工号和密码查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：jobNum[用户名]
	 * 参数：password[密码]*/
	public UsersPrivs findUsersByJobNumAndPassword(String jobNum,String password);
	/**根据用户对象中不为空的值查询用户列表
	 * 返回类型：PageModel<UsersPrivs>[分页，用户类型]
	 * 参数：userPrivs[用户类型]*/
	public PageModel<UsersPrivs> findUsersList(UsersPrivs userPrivs);
	/**根据部门或班组判别字段查询
	 * 返回类型：PageModel<UsersPrivs>[用户对象集合]
	 * 参数：status[判别字段]*/
	public PageModel<UsersPrivs> findUsersByDepartOrProteamStatus(int status);
	/**根据班组标识字段查询
	 * 返回类型：PageModel<UsersPrivs>[用户对象集合]
	 * 参数：workFlag[班组表示字段]*/
	public PageModel<UsersPrivs> findUsersByProteamWorkFlag(int workFlag);
	/**通过用户名或拼音查询用户列表
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：nameOrPy[用户名称或拼音]*/
	public List<UsersPrivs> findUsersListByPjNameOrPy(String nameOrPy);
	
	/**通过班组ID获得所有此班组用户
	 * @param proteamId：班组ID
	 * @return List<UsersPrivs>[用户集合]*/
	public List<UsersPrivs> findUsersListByProteamId(long proteamId);
}
