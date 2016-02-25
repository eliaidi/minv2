package com.repair.zx.service.impl;

import java.util.List;
import com.repair.entity.JcPlanDate;
import com.repair.zx.dao.IJcPlanDateDao;
import com.repair.zx.service.IJcPlanDateService;

/**
 * 
 * @see 机车检修日计划service层
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public class JcPlanDateServiceImpl implements IJcPlanDateService{
	
	private IJcPlanDateDao jcPlanDateDao;
	
	/**
	 * 列出所有未转出的机车日计划
	 * @return
	 */
	public List<JcPlanDate> listByUnOut(){
		return jcPlanDateDao.listByUnOut();
	}
	
	/**
	 * 保存日计划
	 * @param planDate 机车检修日计划对象
	 * @return 返回保存后的ID，如果添加失败，返回0.
	 */
	public Long save(JcPlanDate planDate){
		return (Long) jcPlanDateDao.save(planDate);
	}
	
	/**
	 * 删除机车检修日计划
	 * @param planDate	机车检修日计划对象
	 */
	public void delete(JcPlanDate planDate){
		jcPlanDateDao.delete(planDate);
	}
	
	/**
	 * 修改机车检修日计划
	 * @param planDate	机车检修日计划对象
	 */
	public void update(JcPlanDate planDate){
		jcPlanDateDao.update(planDate);
	}
	
	
	/**
	 * 通过ID查找机车检修日计划
	 * @param id
	 */
	public JcPlanDate findById(Long id){
		return jcPlanDateDao.findById(id);
	}

	
	/**
	 * 通过机车型号和机车号进行查询
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		车号
	 * @return
	 */
	public List<JcPlanDate> listByConditions(String jcTypeValue,String jcNumber){
		return jcPlanDateDao.listByConditions(jcTypeValue, jcNumber);
	}
	
	
	public void setJcPlanDateDao(IJcPlanDateDao jcPlanDateDao) {
		this.jcPlanDateDao = jcPlanDateDao;
	}

	
	
}
