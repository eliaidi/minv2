package com.repair.pjFix.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.PjSDInfoRecord;
import com.repair.pjFix.dao.PjSDInfoRecordDao;

/**
* @ClassName: PjSDInfoRecordDaoImpl
* @Description: TODO 配件检修记录dao层实现
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午11:51:57
 */
public class PjSDInfoRecordDaoImpl implements PjSDInfoRecordDao {
	
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 通过动态配件ID查询   动态配件检修记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @return List<PjSDInfoRecord>	 动态配件检修记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoId(long pjSDInfoId){
		String hql="from PjSDInfoRecord where pjStoreDynamicInfo.id=? order by recordTime asc";
		return hibernateTemplate.find(hql,pjSDInfoId);
	}
	
	 /**
     * 通过ID进行查询
     */
	public PjSDInfoRecord findPjSDInfoRecordById(long pjSDInfoRecordId) {
		List<PjSDInfoRecord> list =	this.hibernateTemplate.find(" from PjSDInfoRecord where id= ?",new Object[]{pjSDInfoRecordId});
		return list.size() == 0 ? null :list.get(0);
	}

	 /**
	 * 通过动态配件ID和状态查询   动态配件检修记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @param  storeUnitProteamStatus  0、主仓库-班组仓库，出库入库；1、班组仓库-班组仓库，出库入库；2、主仓库-相关单位-出库入库;3、下车入库
	 * @return List<PjSDInfoRecord>	 动态配件检修记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoIdAndStoreUPStatus(long pjSDInfoId,long storeUnitProteamStatus){
		String hql="from PjSDInfoRecord where pjStoreDynamicInfo.id=? and storeUnitProteamStatus=? order by recordTime asc";
		return hibernateTemplate.find(hql,pjSDInfoId,storeUnitProteamStatus);
	}
	
	/**
	 * 修改动态配件记录
	 * @param record
	 */
	public void updatePjSDInfoRecord(PjSDInfoRecord record) {
		hibernateTemplate.update(record);
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
