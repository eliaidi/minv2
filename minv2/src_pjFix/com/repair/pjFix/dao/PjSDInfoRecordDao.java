package com.repair.pjFix.dao;

import java.util.List;
import com.repair.entity.PjSDInfoRecord;

/**
* @ClassName: PjSDInfoRecordDao
* @Description: TODO  配件检修记录dao层接口
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 下午2:55:38
 */
public interface PjSDInfoRecordDao {
	
    /**
     *  通过动态配件记录Id获得动态配件记录
     */
    public PjSDInfoRecord findPjSDInfoRecordById(long pjSDInfoRecordId);
    
    /**
	 * 通过动态配件ID获得配件记录集合
	 * @param  pjSDInfoId:动态配件ID
	 * @return List<PjSDInfoRecord>	动态配件记录集合   
	 */
	public List<PjSDInfoRecord> findPjSDInfoRecordByPjSDInfoId(long pjSDInfoId);

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
