package com.repair.pjFix.dao;

import java.util.List;
import com.repair.entity.UsersPrivs;

/**
* @ClassName: UsersPrivsDao
* @Description: TODO(用户类dao接口）
* @author andy
* @version V1.0  
* @date Aug 3, 2015 9:43:11 AM
 */
public interface UsersPrivsDao {
	
	/**根据用户id，查找
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：id[用户id]*/
	public UsersPrivs findUsersById(long id);
	
	/**
	 * 查询所有用户的信息
	 */
	public List<UsersPrivs> findAllUsersPrivs();
}
