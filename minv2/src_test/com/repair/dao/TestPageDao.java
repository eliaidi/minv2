package com.repair.dao;

import java.util.List;

import com.repair.entity.Test;
import com.repair.entity.UsersPrivs;
import com.repair.util.page.PageModel;

/**
 * @ClassName: PageDao
 * @Description: TODO(分页测试dao)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 上午09:57:18
 */

public interface TestPageDao {
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
