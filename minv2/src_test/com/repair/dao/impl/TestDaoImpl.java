package com.repair.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.repair.dao.TestDao;
import com.repair.entity.JcPlanDate;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.Test;
import com.repair.util.StringUtil;
import com.repair.util.splitPage.SearchDto;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
 * ClassName: TestDaoImpl 
 * @Package com.repair.dao.impl
 * @Description: TODO
 * @author andy
 * @datetime Jul 16, 2015 5:10:14 PM
 */
public class TestDaoImpl implements TestDao {
	private HibernateTemplate hibernateTemplate;
	
	private SplitPageDao splitPageDao;
	
	
	public void addTest(Test test) {
		System.out.println("把"+test.getName()+",插入到数据库...");
		this.hibernateTemplate.save(test);
	}

	//成员变量的get和set
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	
	
	public SplitPageModel findAllTest(Test test) {
		List list=new ArrayList();
		String hql="from Test where 1=1 ";
		if(StringUtil.isNotBlank(test.getName())){
			hql += " and name like ?";
			list.add("%"+test.getName()+"%");
		}
		return splitPageDao.queryList(hql,list, test.getPageNo(), test.getPageSize());
		
	}

	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}

	/**
	 * 联想输入获取数据接口层
	 */
	@SuppressWarnings("unchecked")
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfoByPjName() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from PjStoreStaticInfo");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JcPlanDate> findAllJcName() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from JcPlanDate  where jcPlanStatus>3");
	}
	
	
}

