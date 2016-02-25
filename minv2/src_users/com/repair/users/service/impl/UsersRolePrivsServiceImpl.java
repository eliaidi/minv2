package com.repair.users.service.impl;

import com.repair.entity.UsersRolePrivs;
import com.repair.users.dao.UsersRolePrivsDao;
import com.repair.users.service.UsersRolePrivsService;
import com.repair.util.serviceSupport.ServiceSupport;

public class UsersRolePrivsServiceImpl extends ServiceSupport<UsersRolePrivs> implements UsersRolePrivsService{
	private UsersRolePrivsDao usersRolePrivsDao;
	
	public void delUsersRoleByUsers_idService(long usersPrivsId) {
		usersRolePrivsDao.delUsersRoleByUsers_idDao(usersPrivsId);
	}
       



	public void setUsersRolePrivsDao(UsersRolePrivsDao usersRolePrivsDao) {
		this.usersRolePrivsDao = usersRolePrivsDao;
	}


}
