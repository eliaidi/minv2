package com.repair.pjFix.service;

import java.util.List;
import com.repair.entity.PjSDInfoRecord;

/**
* @ClassName: PjSDInfoRecordService
* @Description: TODO 配件动态信息记录service层接口
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午11:51:57
 */
public interface PjSDInfoRecordService {
	
	/**
	 * 通过动态配件ID查询   动态配件检修记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @return List<PjSDInfoRecord>	 动态配件检修记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoId(long pjSDInfoId);
	
	 /**
     * 通过ID进行查询
     */
	public PjSDInfoRecord findPjSDInfoRecordById(long pjSDInfoRecordId);

	 /**
	 * 通过动态配件ID和状态查询   动态配件检修记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @param  storeUnitProteamStatus  0、主仓库-班组仓库，出库入库；1、班组仓库-班组仓库，出库入库；2、主仓库-相关单位-出库入库;3、下车入库
	 * @return List<PjSDInfoRecord>	 动态配件检修记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoIdAndStoreUPStatus(long pjSDInfoId,long storeUnitProteamStatus);

	/**
	 * 修改动态配件记录
	 * @param record
	 */
	public void updatePjSDInfoRecord(PjSDInfoRecord record);
}
