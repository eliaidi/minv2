package com.repair.service;

import com.repair.entity.UsersPrivs;
import com.repair.util.page.PageModel;

/**
 * @ClassName: TestPageService
 * @Description: TODO(��ҳ����service)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 ����10:20:14
 */

public interface TestPageService {
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
