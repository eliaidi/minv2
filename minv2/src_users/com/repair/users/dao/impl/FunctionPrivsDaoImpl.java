package com.repair.users.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.FunctionPrivs;
import com.repair.users.dao.FunctionPrivsDao;
import com.repair.util.daoSupport.DaoSupport;

/**
* @ClassName: FunctionPrivsDaoImpl
* @Description: TODO(功能（资源）dao接口实现)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午2:51:46
*/
public class FunctionPrivsDaoImpl extends DaoSupport<FunctionPrivs> implements FunctionPrivsDao {
	


	/**根据功能（资源）名，删除
	 * 参数：functionName[功能（资源）名]*/
	@SuppressWarnings("unchecked")
	public void delFunctionByFunctionName(String functionName) {
		List<FunctionPrivs> list=this.hibernateTemplate.find("" +
				"from FunctionPrivs where functionName=?",new Object[]{functionName});
		
		FunctionPrivs fp=list.size() == 0 ? null :list.get(0);
		if(fp != null){
			this.hibernateTemplate.delete(fp);
		}
	}
	
	

	/**根据父级id，查找
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]
	 * 参数：parentId[父级id]*/
	@SuppressWarnings("unchecked")
	public List<FunctionPrivs> findFunctionByParentId(long parentId) {
		List<FunctionPrivs> list=this.hibernateTemplate.find("" +
				"from FunctionPrivs where parentId=? order by functionOrder desc",new Object[]{parentId});
		return list;
	}

	/**根据激活状态，查找
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]
	 * 参数：activate[激活状态]*/
	@SuppressWarnings("unchecked")
	public List<FunctionPrivs> findFunctionByActivate(int activate) {
		List<FunctionPrivs> list=this.hibernateTemplate.find("" +
				"from FunctionPrivs where status=?",new Object[]{activate});
		return list;
	}

	/**查询所有，按菜单（操作功能）名顺序，升序。
	 * 返回类型：List<FunctionPrivs>[功能（资源）对象集合]*/
	@SuppressWarnings("unchecked")
	public List<FunctionPrivs> findAllOfFunctionOrderASC() {
		List<FunctionPrivs> list=this.hibernateTemplate.find("" +
				"from FunctionPrivs order by functionOrder");
		return list;
	}

	/** 通过角色id查找所有的功能*/
	@SuppressWarnings("unchecked")
	public List<FunctionPrivs> findAllFunctionPrivsByRoleId(long roleId) {
		List<FunctionPrivs> list=this.hibernateTemplate.find("from FunctionPrivs where roleFunctionPrivs.id=?",new Object[]{roleId});
		return list;
	}

	/** 通过父id查找所有的功能*/
	@SuppressWarnings("unchecked")
	public List<FunctionPrivs> findFunctions(long parentId) {
		List<FunctionPrivs> list=this.hibernateTemplate.find("from FunctionPrivs where parentId=?",new Object[]{parentId});
		return list;
	}


}
