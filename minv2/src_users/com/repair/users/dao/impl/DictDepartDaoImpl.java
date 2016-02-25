package com.repair.users.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.DictDepart;
import com.repair.users.dao.DictDepartDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
* @ClassName: DictDepartDaoImpl
* @Description: TODO(部门类(DictDepartDao)接口的实现)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-4 上午10:41:43
 */
public class DictDepartDaoImpl extends DaoSupport<DictDepart> implements DictDepartDao {
    

	
	/** 根据部门名，删除*/
	public void delByDictDepartame(String departName) {
		DictDepart depart=findDictDepartByName(departName);
		if(depart!=null){
			this.hibernateTemplate.delete(depart);
		}
	}

	

	
	/**
	 * 根据部门名，查询部门
	 */
	public DictDepart findDictDepartByName(String departName) {
		// TODO Auto-generated method stub
		DictDepart depart=null;
		List<DictDepart> list=this.hibernateTemplate.find("from DictDepart where departName=?",new Object[]{departName});
		if(list.size()>0)
		{
			depart=list.get(0);
		}
		return depart;
	}

	
	
}
