package com.repair.service.impl;

import java.util.List;

import com.repair.dao.TestDao;
import com.repair.entity.JcPlanDate;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.Test;
import com.repair.service.TestService;
import com.repair.util.splitPage.SplitPageModel;

/**
 * ClassName: TestServiceImpl 
 * @Package com.repair.service.impl
 * @Description: 测试service实现类
 * @author andy
 * @datetime Jul 15, 2015 3:54:11 PM
 */
public class TestServiceImpl implements TestService {
	private TestDao testDao;
	
	public void addTest(Test test) {
		System.out.println("TestServiceImpl");
		testDao.addTest(test);
		
//		Test test1=new Test();
//		test1.setName("gaogao");
//		testDao.addTest(test1);
//		
//		throw new RuntimeException("手动抛出测试异常！，测试事务回滚");
		
	}
	
	public SplitPageModel findAllTest(Test test) {
		return testDao.findAllTest(test);
	}

	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
     
	/**
	 * 联想输入获取数据接口层
	 */
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfoByPjName() {
		// TODO Auto-generated method stub
		return testDao.findAllPjStoreStaticInfoByPjName();
	}

	@Override
	public List<JcPlanDate> findAllJcName() {
		// TODO Auto-generated method stub
		return testDao.findAllJcName();
	}
}
