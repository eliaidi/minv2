package com.repair.pojoUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.PjSDIRecordFixCheck;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.PjStoreDynamicInfo;

/**
* @ClassName: PjSDInfoRecordUtil
* @Description: TODO(配件动态信息记录工具类)
* @author 周云韬
* @version V1.0  
* @date Nov 20, 2015 3:50:08 PM
 */
public class PjSDInfoRecordUtil {
	
	/** 
	* @Title: listPjSDInfoFixMainRecord 
	* @Description: TODO 获得 动态配件检修主记录集合，并按记录时间从大到小排序
	* @param  psdi		动态配件对象
	* @param  sortType	排序类型，如果为null或为0，则不排序，如果为1，降序排序，如果为2，升序排序
	* @return	动态配件检修主记录集合.
	* 
	* @throws
	 */
	public static List<PjSDInfoRecord> listPjSDInfoFixMainRecord(PjStoreDynamicInfo psdi,Integer sortType){
		List<PjSDInfoRecord> list=new ArrayList<PjSDInfoRecord>();
		if(psdi == null || psdi.getPjSDInfoRecords() == null){
			return list;
		}
		
		for (PjSDInfoRecord record : psdi.getPjSDInfoRecords()) {
			boolean bool=record.getStoreUnitProteamStatus() == Constants.STORE_UNIT_PROTEAM_STATUS_THREE
						 &&  record.getReceivingDeliverStatus() == Constants.RECEIVING_DELIVER_STATUS_ONE
						 && record.getPjSDInfoRecordFixs().size() > 0;
			if(bool){
				list.add(record);
			}

		}
		//不排序
		if(sortType == null || sortType == 0){
			return list;
		}
		//降序排列
		if(sortType == 1 ){
			Collections.sort(list, new Comparator<PjSDInfoRecord>() {
				public int compare(PjSDInfoRecord o1, PjSDInfoRecord o2) {
					if(o1.getRecordTime().getTime() > o2.getRecordTime().getTime()){
						return -1;
					}
					if(o1.getRecordTime().getTime() < o2.getRecordTime().getTime()){
						return 1;
					}
					return 0;
				}
				
			});
		}
		//升序排列
		if(sortType == 2 ){
			Collections.sort(list, new Comparator<PjSDInfoRecord>() {
				public int compare(PjSDInfoRecord o1, PjSDInfoRecord o2) {
					if(o1.getRecordTime().getTime() > o2.getRecordTime().getTime()){
						return 1;
					}
					if(o1.getRecordTime().getTime() < o2.getRecordTime().getTime()){
						return -1;
					}
					return 0;
				}
				
			});
		}
		return list;
	}
	
	/**
	 * 此次检修是否检修完毕
	 * @param record	动态配件记录
	 * @return
	 */
	public static boolean isFixFinish(PjSDInfoRecord record){
		if(record == null){
			return false;
		}
		
		if(record.getPjSDInfoRecordFixs().isEmpty()){
			return false;
		}
		
		Iterator<PjSDInfoRecordFix> it=record.getPjSDInfoRecordFixs().iterator();
		while (it.hasNext()) {
			PjSDInfoRecordFix fix=it.next();
			
			//如果检修人未检修，则为null
			if(fix.getFixUsersIds() == null){
				return false;
			}
			
			PjSDIRecordFixCheck check=fix.getPjSDIRecordFixCheck();
			//如果工长需要卡控且还未签认
			if(check.getLeadCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
					&& check.getLeadUsers() == null){
				return false;
			}
			
			//如果交车工长需要卡控且还未签认
			if(check.getCommitLeadCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
					&& check.getCommitLeadUsers() == null){
				return false;
			}
			
			//如果技术员需要卡控且还未签认
			if(check.getTechnicianCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
					&& check.getTechnicianUsers() == null){
				return false;
			}
			//如果质检员需要卡控且还未签认
			if(check.getQcCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
					&& check.getQcUsers() == null){
				return false;
			}
			//如果验收员需要卡控且还未签认
			if(check.getAcceptanceCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
					&& check.getAcceptanceUsers() == null){
				return false;
			}
			//如果复探需要卡控且还未签认
			if(check.getTwoInspectionCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
					&& check.getTwoInspectionUsers() == null){
				return false;
			}
		}
		
		return true;
		
	}
}
