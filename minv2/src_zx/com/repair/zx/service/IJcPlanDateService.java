package com.repair.zx.service;

import java.util.List;
import com.repair.entity.JcPlanDate;

/**
 * 
 * @see 机车检修日计划service层
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public interface IJcPlanDateService {
	
	/**
	 * 列出所有未交车的机车日计划
	 * @return
	 */
	public List<JcPlanDate> listByUnOut();
	
	/**
	 * 保存日计划
	 * @param planDate 机车检修日计划对象
	 * @return 返回保存后的ID，如果添加失败，返回0.
	 */
	public Long save(JcPlanDate planDate);
	
	/**
	 * 修改机车检修日计划
	 * @param planDate	机车检修日计划对象
	 */
	public void update(JcPlanDate planDate);
	
	/**
	 * 删除机车检修日计划
	 * @param planDate	机车检修日计划对象
	 */
	public void delete(JcPlanDate planDate);
	
	/**
	 * 通过ID查找机车检修日计划
	 * @param id
	 */
	public JcPlanDate findById(Long id);
	
	/**
	 * 通过机车型号和机车号进行查询
	 * @param jcTypeValue	机车型号
	 * @param jcNumber		车号
	 * @return
	 */
	public List<JcPlanDate> listByConditions(String jcTypeValue,String jcNumber);
	
}
