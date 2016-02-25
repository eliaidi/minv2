package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.dao.UsersPrivsDao;
import com.repair.pjFix.service.UsersPrivsService;

/**
* @ClassName: UsersPrivsServiceImpl
* @Description: TODO(用户类service层接口实现）
* @author andy
* @version V1.0  
* @date Aug 3, 2015 9:43:11 AM
 */
public class UsersPrivsServiceImpl implements UsersPrivsService{
	
	private UsersPrivsDao usersPrivsForPjFixDao;
	
	/**根据用户id，查找
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：id[用户id]*/
	public UsersPrivs findUsersById(long id){
		return usersPrivsForPjFixDao.findUsersById(id);
	}
	
	/**
	* 查询所有用户的信息
	*回类型  useraPrivs集合
	* @throws
	 */
	public List<UsersPrivs> findAllUsersPrivs() {
		return usersPrivsForPjFixDao.findAllUsersPrivs();
	}

	public void setUsersPrivsForPjFixDao(UsersPrivsDao usersPrivsForPjFixDao) {
		this.usersPrivsForPjFixDao = usersPrivsForPjFixDao;
	}
	
}
