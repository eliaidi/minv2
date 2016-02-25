package com.repair.service.impl;

import com.repair.dao.TestPageDao;
import com.repair.entity.UsersPrivs;
import com.repair.service.TestPageService;
import com.repair.util.page.PageModel;

/**
 * @ClassName: TestPageServiceImpl
 * @Description: TODO(分页测试service实现类)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 上午10:21:08
 */

public class TestPageServiceImpl implements TestPageService {

	private TestPageDao testPageDao;
	
	/** 
	 *获取所有用户数据 
	 */
	public PageModel<UsersPrivs> findAllUserList() {
		return testPageDao.findAllUserList();
	}

	public TestPageDao getTestPageDao() {
		return testPageDao;
	}

	public void setTestPageDao(TestPageDao testPageDao) {
		this.testPageDao = testPageDao;
	}
	
}
