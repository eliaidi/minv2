package com.repair.zx.dao.impl;

import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.splitPage.SplitPageModel;
import com.repair.zx.dao.IJcZxFixItemRecordDao;
import com.repair.zx.dto.JcZxFixItemRecordDto;

/**
 * 
 * @see 中修检修项目记录
 * @author 周云韬
 * @date 2015-12-16
 * @version 1.0
 */
public class JcZxFixItemRecordDaoImpl extends DaoSupport<JcZxFixItemRecord> implements IJcZxFixItemRecordDao{

	
	
	/**
	 * 通过日计划ID获得中修检修记录
	 * @param planDateId	机车检修日计划ID
	 * @return	中修检修记录对象集合
	 */
	public List<JcZxFixItemRecord> listByPlanDateId(Long planDateId){
		return hibernateTemplate.find("from JcZxFixItemRecord where planDate.id="+planDateId);
	}

	/**
	 * 通过日计划ID分页查询中修检修记录
	 * @param planDateId	机车检修日计划ID
	 * @param pageNo	页数
	 * @param pageSize	每页大小
	 * @return 分页模型对象
	 */
	public SplitPageModel<JcZxFixItemRecord> listPageByPlanDateId(Long planDateId,int pageNo,int pageSize){
		String hql="from JcZxFixItemRecord where planDate.id="+planDateId;
		return splitPageDao.queryList(hql, pageNo, pageSize);
	}
	
	
	/**
	 * 通过dto进行分页查询操作
	 * @param dto
	 * @return
	 */
	public SplitPageModel<JcZxFixItemRecord> listPageByDto(JcZxFixItemRecordDto dto){
		StringBuffer hql=new StringBuffer();
		
		if(dto.getPlanDateId() == null){
			return null;
		}
		hql.append("from JcZxFixItemRecord where planDate.id="+dto.getPlanDateId());
		
		if(dto.getFirstUnitId() != null){
			hql.append(" and fixItem.firstUnit.id"+dto.getFirstUnitId());
		}
		
		if(dto.getProteamId() != null){
			hql.append(" and fixItem.firstUnit.proteam.id="+dto.getProteamId());
		}
		
		hql.append(" order by fixItem.firstUnit.id");
		return splitPageDao.queryList(hql.toString(), dto.getPageNo(), dto.getPageSize());
	}
	
	/**
	 * 通过 指定的日计划ID、班组ID（可为null）进行查询，并按照对应的角色类型进行记录排序
	 * @param planDateId	日计划ID
	 * @param proteamId		班组ID，可为null
	 * @param itemType		项目类型（检查、检测项目），可为null
	 * @param roleType		角色类型
	 * @return
	 */
	public List<JcZxFixItemRecord> listByConditions(long planDateId,Long proteamId,Integer itemType,int roleType){
		StringBuffer hql=new StringBuffer();
		
		hql.append("from JcZxFixItemRecord where planDate.id="+planDateId);
		
		if(proteamId != null){
			hql.append(" and fixItem.proteam.id="+proteamId);
		}
		if(itemType != null){
			hql.append(" and fixItem.itemType="+itemType);
		}
		
		
		if(Constants.ROLE_TYPE_FIX_USERS.equals(roleType)){
			
			hql.append(" order by fixUsersCheckTime desc");
			
		}else if(Constants.ROLE_TYPE_LEAD.equals(roleType)){
			
			hql.append(" and leadCheck="+Constants.CHECK_STATUS_NEED_CHECK);
			hql.append(" order by leadUsersCheckTime desc");
			
		}else if(Constants.ROLE_TYPE_COMMIT_LEAD.equals(roleType)){
			
			hql.append(" and commitLeadCheck="+Constants.CHECK_STATUS_NEED_CHECK);
			hql.append(" order by commitLeadCheckTime desc");
			
		}else if(Constants.ROLE_TYPE_TECHNICIAN.equals(roleType)){
			
			hql.append(" and technicianCheck="+Constants.CHECK_STATUS_NEED_CHECK);
			hql.append(" order by technicianCheckTime desc");
			
		}
		
		if(hql.toString().indexOf("order by") != -1){
			hql.append(",recordStatus asc");
		}else{
			hql.append(" order by recordStatus asc");
		}
		
		return hibernateTemplate.find(hql.toString());
	}
}
