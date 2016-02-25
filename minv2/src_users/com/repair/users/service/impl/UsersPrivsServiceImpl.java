package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.UsersPrivs;
import com.repair.users.dao.UsersPrivsDao;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.page.PageModel;


/**
 * 
* @ClassName: UsersPrivsServiceImpl
* @Description: TODO	用户类（UsersPrivs）的service的实现
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 上午10:41:57
 */
public class UsersPrivsServiceImpl implements UsersPrivsService {
	private UsersPrivsDao usersPrivsDao;
	
	public void setUsersPrivsDao(UsersPrivsDao usersPrivsDao) {
		this.usersPrivsDao = usersPrivsDao;
	}

	/**添加用户
	 * 参数：usersPrivs[用户对象]*/
	public void addUsers(UsersPrivs usersPrivs){
		usersPrivsDao.addUsers(usersPrivs);
	}
	/**根据id，删除
	 * 参数：id[用户id]*/
	public void delUsersById(long id){
		usersPrivsDao.delUsersById(id);
	}
	/**根据用户名，删除
	 * 参数：userName[用户名]*/
	public void delUsersByUserName(String userName){
		usersPrivsDao.delUsersByUserName(userName);
	}
	/**根据用户id，修改
	 * 参数：usersPrivs[用户对象]*/
	public void updateUsersById(UsersPrivs usersPrivs){
		usersPrivsDao.updateUsersById(usersPrivs);
	}
	/**查询所有用户
	 * 返回类型：List<UsersPrivs>[用户对象集合]*/
	public List<UsersPrivs> findAllUsers(){
		return usersPrivsDao.findAllUsers();
	}
	/**根据用户id，查找
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：id[用户id]*/
	public UsersPrivs findUsersById(long id){
		return usersPrivsDao.findUsersById(id);
	}
	/**根据用户名，查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：userName[用户名]*/
	public UsersPrivs findUsersByName(String userName){
		return usersPrivsDao.findUsersByName(userName);
	}
	/**根据地区/机务段id，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：dictAreaId[地区机/务段id]*/
	public List<UsersPrivs> findUsersByDictAreaId(String dictAreaId){
		return usersPrivsDao.findUsersByDictAreaId(dictAreaId);
	}
	/**根据激活状态，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：status[激活状态]*/
	public List<UsersPrivs> findUsersByStatus(int status){
		return usersPrivsDao.findUsersByStatus(status);
	}
	/**根据部门id，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：dictDepartId[部门id]*/
	public PageModel<UsersPrivs> findUsersByDictDepartId(long dictDepartId){
		return usersPrivsDao.findUsersByDictDepartId(dictDepartId);
	}
	/**根据班组id，查询
	 * 返回类型：List<UsersPrivs>[用户集合]
	 * 参数：dictProteamId[班组id]*/
	public PageModel<UsersPrivs> findUsersByDictProteamId(long dictProteamId){
		return usersPrivsDao.findUsersByDictProteamId(dictProteamId);
	}
	/**根据工号，查询
	 * 返回类型：UsersPrivs[用户类]
	 * 参数：jobNum[工号]*/
	public UsersPrivs findUsersByJobNum(String jobNum){
		return usersPrivsDao.findUsersByJobNum(jobNum);
	}
	/**根据卡号，查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：cardNum[卡号]*/
	public UsersPrivs findUsersByCardNum(String cardNum){
		return usersPrivsDao.findUsersByCardNum(cardNum);
	}
	/**根据角色id，查询。(角色表，其实就是职务表-字段ID)
	 * 返回类型：List<UsersPrivs>[用户集合]
	 * 参数：rolePrivsId[角色id]*/
	public List<UsersPrivs> findUsersByRolePrivsId(int rolePrivsId){
		return usersPrivsDao.findUsersByRolePrivsId(rolePrivsId);
	}
	/**根据性别，查询。（性别：0、男；1、女）
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：gender[性别]*/
	public List<UsersPrivs> findUsersByGender(int gender){
		return usersPrivsDao.findUsersByGender(gender);
	}
	
	/**根据工号和密码查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：jobNum[用户名]
	 * 参数：password[密码]*/
	public UsersPrivs findUsersByJobNumAndPassword(String jobNum,String password){
		return usersPrivsDao.findUsersByJobNumAndPassword(jobNum,password);
	}
	/**根据用户对象中不为空的值查询用户列表
	 * 返回类型：List<UsersPrivs>
	 * 参数：userPrivs
	 */
	public PageModel<UsersPrivs> findUsersList(UsersPrivs userPrivs){
		return usersPrivsDao.findUsersList(userPrivs);
	}
	
	/**根据部门或班组判别字段查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：DepartOrProteamStatus
	 * */
	public PageModel<UsersPrivs> findUsersByDepartOrProteamStatus(int status){
		return usersPrivsDao.findUsersByDepartOrProteamStatus(status);
	}
	
	/**根据班组标识字段查询
	 * 返回类型：PageModel<UsersPrivs>[用户对象集合]
	 * 参数：DepartOrProteamStatus*/
	public PageModel<UsersPrivs> findUsersByProteamWorkFlag(int workFlag){
		return usersPrivsDao.findUsersByProteamWorkFlag(workFlag);
	}
	
	
	/**
	 * 	 通过用户名或拼音查询用户列表(不区分大小写)
	 */
	public List<UsersPrivs> findUsersListByPjNameOrPy(String nameOrPy){
		return usersPrivsDao.findUsersListByPjNameOrPy(nameOrPy);
	}
	
	
	/**
	 * 通过班组ID获得所有此班组用户
	 * @param proteamId：班组ID
	 * @return 用户集合
	 */
	public List<UsersPrivs> findUsersListByProteamId(long proteamId){
		return usersPrivsDao.findUsersListByProteamId(proteamId);
	}
}
