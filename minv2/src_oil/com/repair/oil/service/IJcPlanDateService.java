package com.repair.oil.service;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.oil.dao.IJcPlanDateDao;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.serviceSupport.BaseService;

/**
 * 
 * @see 机车日计划service层
 * @author 周云韬
 * @date 2015-12-22
 * @version 1.0
 */
public interface IJcPlanDateService  extends BaseService<JcPlanDate>{

	/**
	 * 列出 在修状态的所有机车日计划
	 * @return	机车日计划集合
	 */
	public List<JcPlanDate> listInRepair();
	
}
