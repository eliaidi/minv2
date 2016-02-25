package com.repair.service.impl;

import com.repair.dao.TestPageDao;
import com.repair.entity.UsersPrivs;
import com.repair.service.TestPageService;
import com.repair.util.page.PageModel;

/**
 * @ClassName: TestPageServiceImpl
 * @Description: TODO(��ҳ����serviceʵ����)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 ����10:21:08
 */

public class TestPageServiceImpl implements TestPageService {

	private TestPageDao testPageDao;
	
	/** 
	 *��ȡ�����û����� 
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
