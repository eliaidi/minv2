package com.repair.oil.dao;

import java.util.List;
import com.repair.entity.JcPlanDate;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 机车日计划dao层
 * @author 周云韬
 * @date 2015-12-22
 * @version 1.0
 */
public interface IJcPlanDateDao extends BaseDao<JcPlanDate>{

	/**
	 * 列出 在修状态的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listInRepair();
}
