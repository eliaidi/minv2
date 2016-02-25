package com.repair.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.repair.dao.TestPageDao;
import com.repair.entity.Test;
import com.repair.entity.UsersPrivs;
import com.repair.util.page.PageModel;
import com.repair.util.page.PageDao;
/**
 * @ClassName: TestPageDaoImpl
 * @Description: TODO(��ҳ����daoʵ����)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 ����10:05:18
 */

public class TestPageDaoImpl extends PageDao implements TestPageDao {
	/** 
	 *��ȡ�����û����� 
	 */
	@SuppressWarnings("unchecked")
	public PageModel<UsersPrivs> findAllUserList() {
		//��ѯsql
		String hql="from UsersPrivs";
		//��ѯ��������
		List<Object> params=new ArrayList<Object>();
		
		return findPageModel(hql,params.toArray());
	}

	
}
