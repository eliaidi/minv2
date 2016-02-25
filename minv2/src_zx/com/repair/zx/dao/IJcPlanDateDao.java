package com.repair.zx.dao;

import java.util.List;
import com.repair.entity.JcPlanDate;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 机车检修日计划dao层
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public interface IJcPlanDateDao extends BaseDao<JcPlanDate>{
	
	/**
	 * 列出所有未交车的机车日计划
	 * @return
	 */
	public List<JcPlanDate> listByUnOut();
	
	
	/**
	 * 通过机车型号和机车号进行查询
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		车号
	 * @return
	 */
	public List<JcPlanDate> listByConditions(String jcTypeValue,String jcNumber);
}
