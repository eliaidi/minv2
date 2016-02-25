package com.repair.service;

import com.repair.entity.UsersPrivs;
import com.repair.util.page.PageModel;

/**
 * @ClassName: TestPageService
 * @Description: TODO(分页测试service)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 上午10:20:14
 */

public interface TestPageService {
	/**
	 * 
	* @Title: findAllUserList 
	* @Description: TODO(获取所有用户数据) 
	* @param @return    设定文件 
	* @return PageModel<UsersPrivs>    返回类型 
	* @throws
	 */
	public PageModel<UsersPrivs> findAllUserList();
	
	
}
