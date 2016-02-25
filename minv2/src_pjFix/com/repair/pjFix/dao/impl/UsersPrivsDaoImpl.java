package com.repair.pjFix.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.dao.UsersPrivsDao;

/**
* @ClassName: UsersPrivsDaoImpl
* @Description: TODO	用户类(UsersPrivs)的dao实现
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 上午10:39:44
 */
public class UsersPrivsDaoImpl  implements UsersPrivsDao {
	
	private HibernateTemplate hibernateTemplate;
	
	/**根据用户id，查找
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：id[用户id]*/
	public UsersPrivs findUsersById(long id) {
		return this.hibernateTemplate.get(UsersPrivs.class, id);
	}

	/**
	* 查询所有用户的信息
	*回类型  useraPrivs集合
	* @throws
	 */
	public List<UsersPrivs> findAllUsersPrivs() {
		return this.hibernateTemplate.find("from UsersPrivs");
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
