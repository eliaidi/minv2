package com.repair.dao;

import java.util.List;

import com.repair.entity.Test;
import com.repair.entity.UsersPrivs;
import com.repair.util.page.PageModel;

/**
 * @ClassName: PageDao
 * @Description: TODO(��ҳ����dao)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 ����09:57:18
 */

public interface TestPageDao {
	/**
	 * 
	* @Title: findAllUserList 
	* @Description: TODO(��ȡ�����û�����) 
	* @param @return    �趨�ļ� 
	* @return PageModel<UsersPrivs>    �������� 
	* @throws
	 */
	public PageModel<UsersPrivs> findAllUserList();
	
	
	
}
