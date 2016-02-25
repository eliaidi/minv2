package com.repair.pojoUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.repair.constant.Constants;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.DictProteam;
import com.repair.entity.FixItemPreinstallDetails;
import com.repair.entity.FixItemPreinstallType;
import com.repair.entity.JcZxFixItem;
import com.repair.entity.JcZxFixItemRecord;

public class JcZxFixItemRecordUtil {

	/**
	 * 以预设分类形式对检修项目记录列表进行包装
	 * @param recordList	检修项目记录列表
	 * @return	map集合，key为预设分类类型，value为对应的检修项目记录列表
	 */
	public static Map<FixItemPreinstallType, List<JcZxFixItemRecord>> packageByPreinstallType(List<JcZxFixItemRecord> recordList){
		Map<FixItemPreinstallType, List<JcZxFixItemRecord>> map=new HashMap<FixItemPreinstallType, List<JcZxFixItemRecord>>();
		
		for (JcZxFixItemRecord record : recordList) {
			JcZxFixItem fixItem=record.getFixItem();
			if(fixItem == null){
				continue;
			}
			
			FixItemPreinstallType type=fixItem.getPreinstallType();
		
			if(type == null){
				continue;
			}
			
			List<JcZxFixItemRecord> tempList=map.get(type);
			if(tempList == null){
				tempList = new ArrayList<JcZxFixItemRecord>();
			}
			
			tempList.add(record);
			map.put(type, tempList);
		}
		
		
		return map;
	}
	
	
	
	/**
	 * 以班组分类形式对检修项目记录列表进行包装
	 * @param recordList	检修项目记录列表
	 * @return	map集合，key为班组，value为对应的检修项目记录列表
	 */
	public static Map<DictProteam, List<JcZxFixItemRecord>> packageByProteam(List<JcZxFixItemRecord> recordList){
		Map<DictProteam, List<JcZxFixItemRecord>> map=new HashMap<DictProteam, List<JcZxFixItemRecord>>();
		
		for (JcZxFixItemRecord record : recordList) {
			JcZxFixItem fixItem=record.getFixItem();
			if(fixItem == null){
				continue;
			}
			
			DictProteam proteam=fixItem.getProteam();
		
			if(proteam == null){
				continue;
				
			}
			
			List<JcZxFixItemRecord> tempList=map.get(proteam);
			if(tempList == null){
				tempList = new ArrayList<JcZxFixItemRecord>();
			}
			
			tempList.add(record);
			map.put(proteam, tempList);
		}
		
		
		return map;
	}
	
	
	/**
	 * 以专业分类形式对检修项目记录列表进行包装
	 * @param recordList	检修项目记录列表
	 * @return	map集合，key为专业，value为对应的检修项目记录列表
	 */
	public static Map<DictPjFirstUnit, List<JcZxFixItemRecord>> packageByFirstUnit(List<JcZxFixItemRecord> recordList){
		Map<DictPjFirstUnit, List<JcZxFixItemRecord>> map=new HashMap<DictPjFirstUnit, List<JcZxFixItemRecord>>();
		
		for (JcZxFixItemRecord record : recordList) {
			JcZxFixItem fixItem=record.getFixItem();
			if(fixItem == null){
				continue;
			}
			
			DictPjFirstUnit firstUnit=fixItem.getFirstUnit();
		
			if(firstUnit == null){
				continue;
			}
			
			List<JcZxFixItemRecord> tempList=map.get(firstUnit);
			if(tempList == null){
				tempList = new ArrayList<JcZxFixItemRecord>();
			}
			
			tempList.add(record);
			map.put(firstUnit, tempList);
		}
		
		
		return map;
	}
	
	
	
	/**
	 * 中修检查项目是否检修完毕
	 * @param record
	 * @return
	 */
	public static boolean isFixFinish(JcZxFixItemRecord record){
		if(record.getFixUsers() == null){
			return false;
		}
		
		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getLeadCheck()) && record.getLeadUsers() == null){
			return false;
		}
		
		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getCommitLeadCheck()) && record.getCommitLeadUsers() == null){
			return false;
		}
		
		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getTechnicianCheck()) && record.getTechnicianUsers() == null){
			return false;
		}
		
		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getQcCheck()) && record.getQcUsers() == null){
			return false;
		}
		

		if(Constants.CHECK_STATUS_NEED_CHECK.equals(record.getAcceptanceCheck()) && record.getAcceptanceUsers() == null){
			return false;
		}
		return true;
	}
	
}
