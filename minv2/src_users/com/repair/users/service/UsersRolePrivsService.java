package com.repair.users.service;

import com.repair.entity.UsersRolePrivs;
import com.repair.util.serviceSupport.BaseService;


/**
* @ClassName: UsersRolePrivsService
* @Description: TODO(用户角色service层)
* @author lxb
* @version V1.0  
* @date 2015-8-25 上午8:58:10
 */
public interface UsersRolePrivsService extends BaseService<UsersRolePrivs>{
		
	    
	    /** 根据角色id，删除
	   	 * 参数：id[usersPrivsId(用户ID)]*/
	    public void delUsersRoleByUsers_idService(long usersPrivsId);
	   
}
