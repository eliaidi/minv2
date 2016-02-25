package com.repair.pj.dao.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.PjSDInfoRecord;
import com.repair.pj.dao.PjSDInfoRecordDao;
import com.repair.pj.dto.PjSDInfoRecordSearchDto;
import com.repair.util.StringUtil;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @ClassName: PjSDInfoRecordDaoImpl
 * @Description: TODO(配件动态信息记录的dao层实现层)
 * @author lxb
 * @version V1.0
 * @date 2015-9-1 上午8:46:22
 */
public class PjSDInfoRecordDaoImpl extends DaoSupport<PjSDInfoRecord> implements PjSDInfoRecordDao {
	
	
	/**
	 *   多条件查询 动态配件出库入库记录，具体查询条件请参考pj/iframePage/pjSDInfoRecord/pjSDInfoRecordManageIframe.jsp页面
	 *   @param PjSDInfoRecordSearchDto  动态配件出库入库记录
	 *   @return 动态配件出库入库记录集合（分页模型）
	 */
	public SplitPageModel queryPjSDInfoRecord(PjSDInfoRecordSearchDto dto){
		StringBuffer hql=new StringBuffer();
		List pars=new ArrayList();
		hql.append(" from PjSDInfoRecord psdir where 1=1 ");
		
		//出入库状态
		Long[] receivingDeliverStatus=dto.getReceivingDeliverStatus();
		if(receivingDeliverStatus !=null && receivingDeliverStatus.length > 0){
			hql.append(" and psdir.receivingDeliverStatus in (");
			for (int i = 0; i < receivingDeliverStatus.length; i++) {
				hql.append(receivingDeliverStatus[i]);
				if(i != receivingDeliverStatus.length-1){
					hql.append(",");
				}
			}
			hql.append(")");
		}
		
		//移库（出库）状态
		Long[] storeUnitProteamStatus=dto.getStoreUnitProteamStatus();
		if(storeUnitProteamStatus != null && storeUnitProteamStatus.length > 0){
			hql.append(" and psdir.storeUnitProteamStatus in (");
			for (int i = 0; i < storeUnitProteamStatus.length; i++) {
				hql.append(storeUnitProteamStatus[i]);
				if(i != storeUnitProteamStatus.length-1){
					hql.append(",");
				}
			}
			hql.append(")");
		}
		
		//仓库人员
		if(StringUtil.isNotBlank(dto.getStoreUsersName())){
			hql.append(" and  psdir.id in (select psdirsp.pjSDInfoRecord.id from " +
					" PjSDInfoRecordSp psdirsp where psdirsp.storeUsers.userName like ? )  or " +
					"  psdir.id in (select psdirsu.pjSDInfoRecord.id from PjSDInfoRecordSu psdirsu" +
					"    where psdirsu.usersPrivs.userName like ? )");
			pars.add("%"+dto.getStoreUsersName().trim()+"%");
			pars.add("%"+dto.getStoreUsersName().trim()+"%");
		}
		
		//配件编码
		if(StringUtil.isNotBlank(dto.getPjdCode())){
			hql.append(" and psdir.pjStoreDynamicInfo.pjdCode like ?");
			pars.add("%"+dto.getPjdCode().trim()+"%");
		}
		
		//配件名称
		if(StringUtil.isNotBlank(dto.getPjName())){
			hql.append(" and psdir.pjStoreDynamicInfo.pjStoreStaticInfo.pjName like ?");
			pars.add("%"+dto.getPjName().trim()+"%");
		}
		
		//通过仓库ID查询
		if(dto.getStorePositionId() != null){
			hql.append(" and  psdir.pjStoreDynamicInfo.dictStorePosition.id = ?");
			pars.add(dto.getStorePositionId());
		}
		//通过专业名称模糊查询
		if(StringUtil.isNotBlank(dto.getFirstUnitName())){
			hql.append(" and  psdir.pjStoreDynamicInfo.pjStoreStaticInfo.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
						" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.firstUnitName like ? ) ))");
			pars.add("%"+dto.getFirstUnitName()+"%");
		}
		
		//通过班组单位人员查询
		if(StringUtil.isNotBlank(dto.getProteamUsersName())){
			hql.append(" and  psdir.id in (select psdirsp.pjSDInfoRecord.id from PjSDInfoRecordSp psdirsp " +
					" where psdirsp.proteamUsers.userName like ?) or " +
					"	psdir.id in (select psdirpp.pjSDInfoRecord.id from PjSDInfoRecordPp psdirpp " +
					" where psdirpp.proteamUsersB.userName like ? or psdirpp.proteamUsersA.userName like ? )");
			pars.add("%"+dto.getProteamUsersName()+"%");
			pars.add("%"+dto.getProteamUsersName()+"%");
			pars.add("%"+dto.getProteamUsersName()+"%");
		}
				
		//通过相关单位人员查询
		if(StringUtil.isNotBlank(dto.getCorrelationName())){
			hql.append(" and  psdir.id in (select psdirsu.pjSDInfoRecord.id from PjSDInfoRecordSu psdirsu " +
						" where psdirsu.correlationName like ?)");
			pars.add("%"+dto.getCorrelationName()+"%");
		}
		
		//记录时间段
		Date startRecordTime=dto.getStartRecordTime();
		Date endRecordTime=dto.getEndRecordTime();
		
		if( startRecordTime != null && endRecordTime != null){
			hql.append(" and psdir.recordTime between ? and ?");
			pars.add(startRecordTime);
			pars.add(new Date(endRecordTime.getYear(),endRecordTime.getMonth(),endRecordTime.getDate()+1));
		}
		if( startRecordTime != null && endRecordTime == null){
			hql.append(" and psdir.recordTime >= ?");
			pars.add(startRecordTime);
		}
		if( startRecordTime == null && endRecordTime != null){
			hql.append(" and psdir.recordTime <= ?");
			pars.add(new Date(endRecordTime.getYear(),endRecordTime.getMonth(),endRecordTime.getDate()+1));
		}
		
		return splitPageDao.queryList(hql.toString(), pars,dto.getPageNo(),dto.getPageSize());
	}	
	
	

	

}
