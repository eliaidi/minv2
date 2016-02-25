package com.repair.users.dao;

import java.util.List;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: RoleFunctionPrivsDao
* @Description: TODO(��ɫ�����м����dao�ӿ�)
* @author andy
* @version V1.0  
* @date Aug 3, 2015 10:31:32 AM
*/
public interface RoleFunctionPrivsDao extends BaseDao<RoleFunctionPrivs>{
	
	/**��ݽ�ɫid��ɾ��
	 * ����rolePrivsId[��ɫid]*/
	public void delRoleFunctionByRole_privs_id(long rolePrivsId);
	/**��ݹ���id��ɾ��
	 * ����functionPrivsId[����id]*/
	public void delRoleFunctionByFunctionPrivsId(long functionPrivsId);
	/**��ݽ�ɫId����ѯ��ɫ����
	 **����roleId[��ɫID]/*/
	public RoleFunctionPrivs findRoleFunctionPrivsByID(long roleId);
	/**��ݽ�ɫid�������
	 * ����roleId[��ɫID]*/
	public List<RoleFunctionPrivs> findRoleFuncs(long roleId);	
}
