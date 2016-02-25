package com.repair.report.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.dao.IJtReportDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 机车中修\小辅修\临修，报活表（所有修程报活）dao层
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class JtReportDaoImpl  extends DaoSupport<JtReport> implements IJtReportDao{
	
	/**
	 * 查询 指定机车日计划、指定用户ID 的报活记录
	 * @param planDateId	机车检修日计划
	 * @param usersId		用户ID
	 * @return	报活记录集合
	 */
	public List<JtReport> listMyReport(Long planDateId,Long usersId){
		String hql="from JtReport where planDate.id=? and reportUsers.id=? order by fixEndTime desc";
		return hibernateTemplate.find(hql,planDateId,usersId);
	}
	
	
	/**
	 * 查询 指定机车日计划、指定班组ID 的报活记录，传递一个角色类型，通过角色类型来判断查询出来的记录通过什么进行排序显示
	 * @param planDateId	机车检修日计划
	 * @param proteamId		班组ID
	 * @paran roleType		角色类型
	 * @return	报活记录集合
	 */
	public List<JtReport> listReport(Long planDateId,Long proteamId,Integer roleType){
		StringBuffer hql=new StringBuffer();
		hql.append("from JtReport where planDate.id=?  ");
		if(proteamId != null){
			hql.append("and proteam.id ="+proteamId);
		}
		if(Constants.ROLE_TYPE_FIX_USERS.equals(roleType) || roleType == null){
			//如果是工人进行查询
			hql.append(" order by fixEndTime desc");
		}else if(Constants.ROLE_TYPE_LEAD.equals(roleType)){
			//如果是工长进行查询
			hql.append(" and  leadCheck = "+Constants.CHECK_STATUS_NEED_CHECK+" order by leadUsersCheckTime desc");
		}else if(Constants.ROLE_TYPE_COMMIT_LEAD.equals(roleType)){
			//如果是交车工长进行查询
			hql.append(" and  commitLeadCheck = "+Constants.CHECK_STATUS_NEED_CHECK+" order by commitLeadCheckTime desc");
		}else if(Constants.ROLE_TYPE_QC.equals(roleType)){
			//如果是质检进行查询
			hql.append(" and qcCheck = "+Constants.CHECK_STATUS_NEED_CHECK+" order by qcCheckTime desc");
		}else if(Constants.ROLE_TYPE_TECHNICIAN.equals(roleType)){
			//如果是技术员进行查询
			hql.append(" and technicianCheck = "+Constants.CHECK_STATUS_NEED_CHECK+" order by technicianCheckTime desc");
		}else if(Constants.ROLE_TYPE_ACCEPTANCE.equals(roleType)){
			//如果是验收员进行查询
			hql.append(" and acceptanceCheck = "+Constants.CHECK_STATUS_NEED_CHECK+"order by acceptanceCheckTime desc");
		}
		
		hql.append(" ,record_status asc");
		
		return hibernateTemplate.find(hql.toString(),planDateId);
	}
	
	
	/**
	 * 查询 指定机车日计划 的报活记录，传递一个角色类型，通过角色类型来判断查询出来的记录通过什么进行排序显示
	 * @param planDateId	机车检修日计划
	 * @paran roleType		角色类型
	 * @return	报活记录集合
	 */
	public List<JtReport> listReport(Long planDateId,Integer roleType){

		return listReport(planDateId, null, roleType);
	}
	

}
