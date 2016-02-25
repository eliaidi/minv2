package com.repair.pj.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.dao.PjStoreDynamicInfoDao;
import com.repair.pj.dto.PjStoreDynamicInfoSearchDto;
import com.repair.util.StringUtil;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.page.PageDao;
import com.repair.util.page.PageModel;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreDynamicInfoDaoImpl
* @Description: TODO(配件动态信息实现类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 下午09:21:20
 */
public class PjStoreDynamicInfoDaoImpl extends DaoSupport<PjStoreDynamicInfo> implements PjStoreDynamicInfoDao{
	
	
	
	
	
	/**
	 * 	通过大部件(专业)ID查找动态配件
	 * 	@param firstUnitid：大部件（专业）ID，如果为null或-1，则查询所有专业的动态配件
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
		
		return this.hibernateTemplate.find(hql.toString(),pars.toArray());
	}
	
	
	/**
	 *	 通过查询条件查询动态配件信息
	 *	@param	dto  查询动态配件时需要使用的dto
	 *	@return	动态配件信息集合
	 */
	public SplitPageModel queryPjStoreDynamicInfo(PjStoreDynamicInfoSearchDto dto){
		StringBuffer hql=new StringBuffer();
		
		List<Object> pars=new ArrayList<Object>();
		
		hql.append("from PjStoreDynamicInfo psdi where  1=1   ");
		
		//通过大部件ID查询
		if(dto.getFirstUnitId() != null && dto.getFirstUnitId() != -1){
			hql.append(" and psdi.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.id = ?  ))");
			pars.add(dto.getFirstUnitId());
		}
		
		//机车型号ID如果为null或者-1.则查询全部静态配件
		if(dto.getJcTypeId() != null && dto.getJcTypeId() != -1){
			hql.append(" and psdi.pjStoreStaticInfo.id  in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictJcType.id = ?  ))");
			pars.add(dto.getJcTypeId());
		}
		
		//通过仓库ID查询
		if(dto.getStorePositionId() != null ){
			hql.append(" and psdi.dictStorePosition.id=?");
			pars.add(dto.getStorePositionId());
		}
		
		//通过机车型号模糊查询
		if(StringUtil.isNotBlank(dto.getJcType())){
			hql.append(" and psdi.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictJcType.jcType like ?  ))");
			pars.add("%"+dto.getJcType()+"%");
		}
		
		//通过配件编码查询
		if(StringUtil.isNotBlank(dto.getPjdCode())){
			hql.append(" and  psdi.pjdCode like ?");
			pars.add("%"+dto.getPjdCode()+"%");
		}
		
		//通过大部件名称模糊查询
		if(StringUtil.isNotBlank(dto.getFirstUnitName())){
			hql.append(" and  psdi.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
						" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.firstUnitName like ? ) ))");
			pars.add("%"+dto.getFirstUnitName()+"%");
		}
		
		//通过配件名称查询
		if(StringUtil.isNotBlank(dto.getPjName())){
			hql.append(" and psdi.pjStoreStaticInfo.pjName like ?");
			pars.add("%"+dto.getPjName()+"%");
		}
		
		//入库时间
		if(dto.getRecordTime() != null){
			hql.append(" and  psdi.id in (select  psdir.pjStoreDynamicInfo.id from PjSDInfoRecord psdir where" +
					" psdir.receivingDeliverStatus=0 and psdir.storeUnitProteamStatus=2 " +
					" and recordTime between ? and ?) ");
			pars.add(dto.getRecordTime());
			Timestamp endTime=new Timestamp(dto.getRecordTime().getTime()+86400000);
			
			pars.add(endTime);
		}
		hql.append(" order by psdi.id desc ");
		
		return splitPageDao.queryList(hql.toString(), pars, dto.getPageNo(), dto.getPageSize());
	}

	/**
	 * 使用ajax通过pjdCode查找当前输入的配件编号是否在数据库中存在
	 */
	public PjStoreDynamicInfo findPjStoreDynamicInfoByPjdCode(String pjdCode) {
		PjStoreDynamicInfo pjStoreDynamicInfo = null;
		@SuppressWarnings("unchecked")
		List<PjStoreDynamicInfo>  list = this.hibernateTemplate.find(" from PjStoreDynamicInfo where pjdCode = ? ", new Object[]{pjdCode});
		if(list.size()>0){
			pjStoreDynamicInfo = list.get(0);
		}	
		return pjStoreDynamicInfo;
	}
	
	/**
	 *   通过静态配件ID 查询 动态配件集合
	 *   @param pjStoreStaticInfoId：静态配件ID
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiId(long pjStoreStaticInfoId){
		String hql="from PjStoreDynamicInfo psdi where psdi.pjStoreStaticInfo.id=?";
		return this.hibernateTemplate.find(hql,pjStoreStaticInfoId);
	}
	
	
}
