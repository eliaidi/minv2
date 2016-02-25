package com.repair.users.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.users.dao.RoleFunctionPrivsDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
* @ClassName: RoleFunctionPrivsDaoImpl
* @Description: TODO(角色功能中间表类dao接口实现)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午2:24:43
 */
public class RoleFunctionPrivsDaoImpl extends DaoSupport<RoleFunctionPrivs> implements RoleFunctionPrivsDao {
	
	/**根据角色id，删除
	 * 参数：rolePrivsId[角色id]*/
	@SuppressWarnings("unchecked")
	public void delRoleFunctionByRole_privs_id(long rolePrivsId){
		List<RoleFunctionPrivs> list=this.hibernateTemplate.find("from RoleFunctionPrivs " +
				" where rolePrivs.id=?",new Object[]{rolePrivsId});
		
		for (RoleFunctionPrivs roleFunctionPrivs : list) {
			this.hibernateTemplate.delete(roleFunctionPrivs);
		}
	}
	/**根据功能id，删除
	 * 参数：functionPrivsId[功能id]*/
	@SuppressWarnings("unchecked")
	public void delRoleFunctionByFunctionPrivsId(long functionPrivsId){
		List<RoleFunctionPrivs> list=this.hibernateTemplate.find("from RoleFunctionPrivs " +
				" where functionPrivs.id=?",new Object[]{functionPrivsId});
		
		for (RoleFunctionPrivs roleFunctionPrivs : list) {
			this.hibernateTemplate.delete(roleFunctionPrivs);
		}
	}
	
	/** 查找角色功能，通过角色id */
	@SuppressWarnings("unchecked")
	public RoleFunctionPrivs findRoleFunctionPrivsByID(long roleId) {
		RoleFunctionPrivs roleFunctionPrivs=null;
		List<RoleFunctionPrivs> list=this.hibernateTemplate.find("from RoleFunctionPrivs where rolePrivs.id=?", new Object[]{roleId});
		if(list.size()>0)
		{
			roleFunctionPrivs=list.get(0);
		}
		return roleFunctionPrivs;
	}

	/** 查找角色功能，通过角色id */
	@SuppressWarnings("unchecked")
	public List<RoleFunctionPrivs> findRoleFuncs(long roleId) {
		List<RoleFunctionPrivs> list=this.hibernateTemplate.find("from RoleFunctionPrivs where rolePrivs.id=?", new Object[]{roleId});
		return list;
	}
}
