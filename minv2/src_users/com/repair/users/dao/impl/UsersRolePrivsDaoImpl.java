package com.repair.users.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.UsersRolePrivs;
import com.repair.users.dao.UsersRolePrivsDao;
import com.repair.util.daoSupport.DaoSupport;

/**
* @ClassName: UsersRolePrivsDaoImpl
* @Description: TODO(用户角色实现类dao层)
* @author 廖雪冰
* @version V1.0  
* @date 2015-8-25 上午8:58:44
 */
public class UsersRolePrivsDaoImpl extends DaoSupport<UsersRolePrivs> implements UsersRolePrivsDao{
	
   
	/** 删除用户角色，通过用户id */
	public void delUsersRoleByUsers_idDao(long usersPrivsId) {
		@SuppressWarnings("unchecked")
		List<UsersRolePrivs> list = this.hibernateTemplate.find(" from UsersRolePrivs"+
		" where usersPrivs.id = ?",new Object[]{usersPrivsId});
		for (UsersRolePrivs usersRolePrivs : list) {
		      this.hibernateTemplate.delete(usersRolePrivs);
		}
		
	}

	


	
}
