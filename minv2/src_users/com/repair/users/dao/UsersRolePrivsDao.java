package com.repair.users.dao;

import com.repair.entity.UsersRolePrivs;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @ClassName: UsersRolePrivsDao
 * @Description: TODO(用户角色中间表)
 * @author lxb
 * @version V1.0
 * @date 2015-8-25 上午8:32:56
 */
public interface UsersRolePrivsDao extends BaseDao<UsersRolePrivs>{
	
	
	
    
    /**根据角色id，删除
   	 * 参数：id[usersPrivsId(用户ID)]*/
    public void delUsersRoleByUsers_idDao(long usersPrivsId);
    
    
}
