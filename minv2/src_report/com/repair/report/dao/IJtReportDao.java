package com.repair.report.dao;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 机车中修\小辅修\临修，报活表（所有修程报活）
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public interface IJtReportDao  extends BaseDao<JtReport>{
	
	/**
	 * 查询 指定机车日计划、指定用户ID 的报活记录
	 * @param planDateId	机车检修日计划
	 * @param usersId		用户ID
	 * @return	报活记录集合
	 */
	public List<JtReport> listMyReport(Long planDateId,Long usersId);
	
	
	/**
	 * 查询 指定机车日计划、指定班组ID 的报活记录，传递一个角色类型，通过角色类型来判断查询出来的记录通过什么进行排序显示
	 * @param planDateId	机车检修日计划
	 * @param proteamId		班组ID
	 * @paran roleType		角色类型
	 * @return	报活记录集合
	 */
	public List<JtReport> listReport(Long planDateId,Long proteamId,Integer roleType);
	
	
	/**
	 * 查询 指定机车日计划 的报活记录，传递一个角色类型，通过角色类型来判断查询出来的记录通过什么进行排序显示
	 * @param planDateId	机车检修日计划
	 * @paran roleType		角色类型
	 * @return	报活记录集合
	 */
	public List<JtReport> listReport(Long planDateId,Integer roleType);
	
}
