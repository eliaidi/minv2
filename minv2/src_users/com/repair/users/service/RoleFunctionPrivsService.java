package com.repair.users.service;

import java.util.List;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.util.serviceSupport.BaseService;

/**
* @ClassName: RoleFunctionPrivsService
* @Description: TODO(角色功能中间表类service接口)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午2:44:15
 */
public interface RoleFunctionPrivsService extends BaseService<RoleFunctionPrivs>{

	/**根据角色id，删除
	 * 参数：rolePrivsId[角色id]*/
	public void delRoleFunctionByRole_privs_id(long rolePrivsId);
	/**根据功能id，删除
	 * 参数：functionPrivsId[功能id]*/
	public void delRoleFunctionByFunctionPrivsId(long functionPrivsId);
	/**根据角色id查找所有角色功能 */
	public RoleFunctionPrivs findRoleFunctionPrivsByID(long roleId);
	/**根据角色id查出功能*/
	public List<RoleFunctionPrivs> findRoleFuncs(long roleId);		
}
