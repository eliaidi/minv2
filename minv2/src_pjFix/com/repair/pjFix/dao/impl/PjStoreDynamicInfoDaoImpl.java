package com.repair.pjFix.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.dao.PjStoreDynamicInfoDao;
import com.repair.pjFix.dto.PjStoreDynamicInfoSearchDto;
import com.repair.util.StringUtil;
import com.repair.util.page.PageDao;
import com.repair.util.page.PageModel;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreDynamicInfoDaoImpl
* @Description: TODO 动态配件dao层实现
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午09:21:20
 */
public class PjStoreDynamicInfoDaoImpl extends PageDao implements PjStoreDynamicInfoDao{
	
	private SplitPageDao splitPageDao;
	
	/**
	 * 添加动态配件
	 * @param storeDynamicInfo 动态配件集合
	 */
	public void addPjStoreDynamicInfo(PjStoreDynamicInfo storeDynamicInfo) {
		this.getHibernateTemplate().save(storeDynamicInfo);
	}

	/**
	 * 删除动态配件
	 */
	public void deletePjStoreDynamicInfo(PjStoreDynamicInfo storeDynamicInfo) {
		this.getHibernateTemplate().delete(storeDynamicInfo);
	}

	/**
	 * 获取所有动态配件
	 *  @return 动态配件集合
	 */
	@SuppressWarnings("unchecked")
	public PageModel<PjStoreDynamicInfo> findAllPjStoreDynamicInfo() {
		StringBuffer hql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		hql.append(" from PjStoreDynamicInfo where 1=1");
		hql.append(" order by id desc");
		return findPageModel(hql.toString(), params.toArray());
	}

	/**
	 * 通过动态配件ID获取动态配件
	 * @param id 动态配件ID
	 */
	@SuppressWarnings("unchecked")
	public PjStoreDynamicInfo findPjStoreDynamicInfoById(long id) {
		PjStoreDynamicInfo pjStoreDynamicInfo=null;
		List<PjStoreDynamicInfo> list=this.getHibernateTemplate().find("from PjStoreDynamicInfo where id=?",new  Object[]{id});
		if(list.size()>0)
		{
			pjStoreDynamicInfo=list.get(0);
		}
		return pjStoreDynamicInfo;
	}

	/**
	 * 修改动态配件
	 */
	public void updatePjStoreDynamicInfo(PjStoreDynamicInfo storeDynamicInfo) {
		this.getHibernateTemplate().update(storeDynamicInfo);
	}

	/**
	 * 	通过专业ID获取动态配件信息
	 * 	@param firstUnitid  专业ID
	 *  @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPagePjStoreDynamicInfoByFirstUnitid(Long firstUnitid){
		StringBuffer hql=new StringBuffer();
		
		List<Object> pars=new ArrayList<Object>();
		
		hql.append(" from PjStoreDynamicInfo psdi where 1=1 ");
		
		if(firstUnitid != null && firstUnitid != -1){
			hql.append(" and psdi.pjStoreStaticInfo.id in (select pssi.id from PjStoreStaticInfo pssi where "+
						"pssi.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
						" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.id = ? ) ))");
			pars.add(firstUnitid);
		}
	
		return this.getHibernateTemplate().find(hql.toString(),pars.toArray());
	}
	
	/**
	 *	 查询动态配件
	 *	@param	dto  查询动态配件时所需要使用的数据传输对象
	 *	@return	分页模型
	 */
	public SplitPageModel queryPjStoreDynamicInfo(PjStoreDynamicInfoSearchDto dto){
		StringBuffer hql=new StringBuffer();
		
		List<Object> pars=new ArrayList<Object>();
		
		hql.append("from PjStoreDynamicInfo psdi where  1=1   ");
		
		//通过专业ID
		if(dto.getFirstUnitId() != null && dto.getFirstUnitId() != -1){
			hql.append(" and psdi.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.id = ?  ))");
			pars.add(dto.getFirstUnitId());
		}
		//通过配件静态信息id
		if(dto.getPjSSInfoId() !=null && dto.getPjSSInfoId() != -1){
			hql.append(" and psdi.pjStoreStaticInfo.id = ? ");
			pars.add(dto.getPjSSInfoId());
		}
		
		//机车类型ID
		if(dto.getJcTypeId() != null && dto.getJcTypeId() != -1){
			hql.append(" and psdi.pjStoreStaticInfo.id  in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictJcType.id = ?  ))");
			pars.add(dto.getJcTypeId());
		}
		
		//仓库ID
		if(dto.getStorePositionId() != null ){
			hql.append(" and psdi.dictStorePosition.id=?");
			pars.add(dto.getStorePositionId());
		}
		
		//机车类型名
		if(StringUtil.isNotBlank(dto.getJcType())){
			hql.append(" and psdi.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictJcType.jcType like ?  ))");
			pars.add("%"+dto.getJcType()+"%");
		}
		
		//配件编码
		if(StringUtil.isNotBlank(dto.getPjdCode())){
			hql.append(" and  psdi.pjdCode like ?");
			pars.add("%"+dto.getPjdCode()+"%");
		}
		
		//配件状态
		if(dto.getPjdStatus() !=null){
			hql.append(" and psdi.pjdStatus=? ");
			pars.add(dto.getPjdStatus());
		}
		
		//专业名称
		if(StringUtil.isNotBlank(dto.getFirstUnitName())){
			hql.append(" and  psdi.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
						" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.firstUnitName like ? ) ))");
			pars.add("%"+dto.getFirstUnitName()+"%");
		}
		
		//配件名称
		if(StringUtil.isNotBlank(dto.getPjName())){
			hql.append(" and psdi.pjStoreStaticInfo.pjName like ?");
			pars.add("%"+dto.getPjName()+"%");
		}
		
		//配件状态
		if(dto.getPjdStatus()!=null && dto.getPjdStatus()!=-1)
		{
			hql.append(" and psdi.pjdStatus=?");
			pars.add(dto.getPjdStatus());
		}
		
		//记录时间
		if(dto.getRecordTime() != null){
			hql.append(" and  psdi.id in (select  psdir.pjStoreDynamicInfo.id from PjSDInfoRecord psdir where" +
					" psdir.receivingDeliverStatus=0 and psdir.storeUnitProteamStatus=2 " +
					" and recordTime between ? and ?) ");
			pars.add(dto.getRecordTime());
			Timestamp endTime=new Timestamp(dto.getRecordTime().getTime()+86400000);
			
			pars.add(endTime);
		}	
		
		//如果不为null，查询完全签认完毕或未完全签认的动态配件
		if(dto.getFixItemQueryFlag() != null && dto.getRoleType() != null){
			hql.append(" and psdi.pjdStatus="+Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FOUR);
			hql.append(" and psdi.id in (");
			hql.append("select psdir.pjStoreDynamicInfo.id from  PjSDInfoRecord psdir where psdir.storeUnitProteamStatus="+Constants.STORE_UNIT_PROTEAM_STATUS_THREE);
			hql.append(" and  psdir.id in (select psdirf.pjSDInfoRecord.id from PjSDInfoRecordFix psdirf where 1=1 ");
			
			Integer roleType=dto.getRoleType();
			switch (dto.getFixItemQueryFlag()) {
			case 0:
				if(roleType == Constants.ROLE_TYPE_FIX_USERS){//工人
					hql.append(" and psdirf.fixTime is null " +
								"	and psdirf.fixUsersIds is null");
				}else if(roleType == Constants.ROLE_TYPE_LEAD){//工长
					hql.append(" and psdirf.pjSDIRecordFixCheck.leadCheckTime is null " +
								"	and psdirf.pjSDIRecordFixCheck.leadCheck="+Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE);
				}else if(roleType == Constants.ROLE_TYPE_COMMIT_LEAD){//交车工长
					hql.append(" and psdirf.pjSDIRecordFixCheck.commitLeadCheckTime is null " +
								"	and psdirf.pjSDIRecordFixCheck.commitLeadCheck="+Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE);
				}else if(roleType == Constants.ROLE_TYPE_QC){//质检员
					hql.append(" and psdirf.pjSDIRecordFixCheck.qcCheckTime is null " +
							"	and psdirf.pjSDIRecordFixCheck.qcCheck="+Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE);
				}else if(roleType == Constants.ROLE_TYPE_TECHNICIAN){//技术员
					hql.append(" and psdirf.pjSDIRecordFixCheck.technicianCheckTime is null " +
							"	and psdirf.pjSDIRecordFixCheck.technicianCheck="+Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE);
				}else if(roleType == Constants.ROLE_TYPE_ACCEPTANCE){//验收员
					hql.append(" and psdirf.pjSDIRecordFixCheck.acceptanceCheckTime is null " +
							"	and psdirf.pjSDIRecordFixCheck.acceptanceCheck="+Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE);
				}
				break;
			case 1:
				
				break;
			default:
				break;
			}
			hql.append("	 )");
			hql.append(") ");
		}
		
		hql.append(" order by psdi.id asc ");
		
		return splitPageDao.queryList(hql.toString(), pars, dto.getPageNo(), dto.getPageSize());
	}

	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}

	/**
	 * 通过配件编码获取所有动态配件
	 */
	public PjStoreDynamicInfo findPjStoreDynamicInfoByPjdCode(String pjdCode) {
		PjStoreDynamicInfo pjStoreDynamicInfo = null;
		@SuppressWarnings("unchecked")
		List<PjStoreDynamicInfo>  list = this.getHibernateTemplate().find(" from PjStoreDynamicInfo where pjdCode = ? ", new Object[]{pjdCode});
		if(list.size()>0){
			pjStoreDynamicInfo = list.get(0);
		}	
		return pjStoreDynamicInfo;
	}
	
	/**
	 *   通过静态配件ID获得动态配件集合
	 *   @param pjStoreStaticInfoId  静态配件ID
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiId(long pjStoreStaticInfoId){
		String hql="from PjStoreDynamicInfo psdi where psdi.pjStoreStaticInfo.id=?";
		return this.getHibernateTemplate().find(hql,pjStoreStaticInfoId);
	}
	
	
	/**
	 *   通过静态配件ID和配件状态数组查询动态配件集合
	 *   @param pjStoreStaticInfoId   静态配件ID
	 *   @param pjdStatusArr	配件状态数组
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiIdAndPjdStatusArr(long pjStoreStaticInfoId,long[] pjdStatusArr){
		StringBuffer hql=new StringBuffer();
		hql.append("from PjStoreDynamicInfo psdi where psdi.pjStoreStaticInfo.id=? ");
		
		List parsValue=new ArrayList();
		parsValue.add(pjStoreStaticInfoId);
		
		if(pjdStatusArr != null && pjdStatusArr.length > 0){
			hql.append(" and pjdStatus in ( ");
			for (int i=0;i<pjdStatusArr.length;i++) {
				hql.append(pjdStatusArr[i]);
				if(i != pjdStatusArr.length -1 ){
					hql.append(",");
				}
				//parsValue.add(pjdStatus);
			}
			hql.append(")");
		}
		return this.getHibernateTemplate().find(hql.toString(),parsValue.toArray());
	}

	
	public SplitPageDao getSplitPageDao() {
		return splitPageDao;
	}
	
}

