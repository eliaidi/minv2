package com.repair.pojoUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.repair.entity.DictProteam;
import com.repair.entity.JtReport;


/**
 * 
 * @see 报活记录工具类
 * @author 周云韬
 * @date 2015-12-28
 * @version 1.0
 */
public class JtReportUtil {

	/**
	 * 以班组形式对报活记录列表进行包装
	 * @param reportList	报活记录列表
	 * @return	map集合，key为班组，value为对应的报活记录列表
	 */
	public static Map<DictProteam, List<JtReport>> packageByProteam(List<JtReport> reportList){
		Map<DictProteam, List<JtReport>> map=new HashMap<DictProteam, List<JtReport>>();
		
		for (JtReport report : reportList) {
			
			List<JtReport> tempList=map.get(report.getProteam());
			if(tempList == null){
				tempList = new ArrayList<JtReport>();
			}
			
			tempList.add(report);
			map.put(report.getProteam(), tempList);
		}
		
		
		return map;
	}
	
}
