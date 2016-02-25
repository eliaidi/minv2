package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.PjSDInfoRecord;
import com.repair.pjFix.dao.PjSDInfoRecordDao;
import com.repair.pjFix.service.PjSDInfoRecordService;

/**
* @ClassName: PjSDInfoRecordServiceImpl
* @Description: TODO 配件检修记录service层接口实现
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午11:51:57
 */
public class PjSDInfoRecordServiceImpl implements PjSDInfoRecordService{
	
	private PjSDInfoRecordDao pjSDInfoRecordForPjFixDao;
	
	/**
	 * 通过动态配件ID查询   动态配件检修记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @return List<PjSDInfoRecord>	 动态配件检修记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoId(long pjSDInfoId){
		return pjSDInfoRecordForPjFixDao.findPjSDInfoRecordByPjSDInfoId(pjSDInfoId);
	}
	
	 /**
     * 通过ID进行查询
     */
	public PjSDInfoRecord findPjSDInfoRecordById(long pjSDInfoRecordId){
		return pjSDInfoRecordForPjFixDao.findPjSDInfoRecordById(pjSDInfoRecordId);
	}

	 /**
	 * 通过动态配件ID和状态查询   动态配件检修记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @param  storeUnitProteamStatus  0、主仓库-班组仓库，出库入库；1、班组仓库-班组仓库，出库入库；2、主仓库-相关单位-出库入库;3、下车入库
	 * @return List<PjSDInfoRecord>	 动态配件检修记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoIdAndStoreUPStatus(long pjSDInfoId,long storeUnitProteamStatus){
		return pjSDInfoRecordForPjFixDao.findPjSDInfoRecordByPjSDInfoIdAndStoreUPStatus(pjSDInfoId, storeUnitProteamStatus);
	}
	
	/**
	 * 修改动态配件记录
	 * @param record
	 */
	public void updatePjSDInfoRecord(PjSDInfoRecord record){
		pjSDInfoRecordForPjFixDao.updatePjSDInfoRecord(record);
	}
	
	public void setPjSDInfoRecordForPjFixDao(
			PjSDInfoRecordDao pjSDInfoRecordForPjFixDao) {
		this.pjSDInfoRecordForPjFixDao = pjSDInfoRecordForPjFixDao;
	}

}
