package com.repair.pojoUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.entity.PjStaticJcTypePjFU;
import com.repair.entity.PjStoreDynamicInfo;

/**
 * @author 周云韬
 * @version 1.0
 * @see	动态配件相关的工具类
 */
public class PjSDInfoUtil {
	/**
	 * 
	* @Title: getDynamicCountByDictPjFirstUnit 
	* @Description: TODO  获得一个专业里面有多少个动态配件
	* @return Integer    
	* @throws
	 */
	public static Integer getDynamicCountByDictPjFirstUnit(DictPjFirstUnit dictPjFirstUnit){
		int count=0;
		if(dictPjFirstUnit != null){
			Iterator<JcTypePjFirstUnit> jcTypePjFirstUnitIt=dictPjFirstUnit.getJcTypePjFirstUnits().iterator();
			
			while(jcTypePjFirstUnitIt.hasNext()){
				JcTypePjFirstUnit jcTypePjFirstUnit=jcTypePjFirstUnitIt.next();
				Set<PjStaticJcTypePjFU> pjStaticJcTypePjSet=jcTypePjFirstUnit.getPjStaticJcTypePjFUs();
				if(pjStaticJcTypePjSet == null){
					continue;
				}
				Iterator<PjStaticJcTypePjFU> pjStaticJcTypePjFUIt=pjStaticJcTypePjSet.iterator();
				
				
				
				while(pjStaticJcTypePjFUIt.hasNext()){
					PjStaticJcTypePjFU pjStaticJcTypePjFU=pjStaticJcTypePjFUIt.next();
					Set<PjStoreDynamicInfo> pjStoreDynamicInfoSet=pjStaticJcTypePjFU.getPjStoreStaticInfo().getPjStoreDynamicInfos();
					if(pjStoreDynamicInfoSet == null){
						continue;
					}
					count += pjStoreDynamicInfoSet.size();
				}
				
			}
		}
		return count;
	}
	
	/**
	 * 通过大部件（专业）集合得到 一个每个专业有多少个动态配件
	 * @param   list：通过大部件（专业）集合
	 * @return  Map集合
	 * 			key:大部件ID
	 * 			value：大部件对应的动态配件个数  
	 */
	public static Map<String, Integer> getDynamicCountByDictPjFirstUnitList(List<DictPjFirstUnit> list){
		//key:DictPjFirstUnit的ID。value： 动态配件个数
		Map<String, Integer> pjFirstUnitMap=new HashMap<String, Integer>();
		int totalCount=0;
		for (DictPjFirstUnit dictPjFirstUnit : list) {
			
			int count=	getDynamicCountByDictPjFirstUnit(dictPjFirstUnit);
			
			pjFirstUnitMap.put(dictPjFirstUnit.getId()+"", count);
			if(!pjFirstUnitMap.containsKey(dictPjFirstUnit.getId())){
				totalCount += count;
			}
		}
		pjFirstUnitMap.put(Constants.ROOT, totalCount);
		return pjFirstUnitMap;
	}
	
	
	/**
	* @Title: getDynamicCountByDictJcType 
	* @Description: TODO     获取一个车型里面有多少个动态配件
	* @return Integer    
	* @throws
	 */
	public static Integer getDynamicCountByDictJcType(DictJcType dictJcType){
		Integer count=0;
		if(dictJcType != null){
			
			Set<JcTypePjFirstUnit> jtpfuSet=dictJcType.getJcTypePjFirstUnits();
			if(jtpfuSet != null){
				Iterator<JcTypePjFirstUnit> it=jtpfuSet.iterator();
				while(it.hasNext()){
					DictPjFirstUnit dictPjFirstUnit=it.next().getDictPjFirstUnit();
					count += getDynamicCountByDictPjFirstUnit(dictPjFirstUnit);
				}
			}
		}
		return count;
	}
	
	/**
	* @Title: getDynamicCountByDictJcTypeList 
	* @Description: TODO	获取每个车型有多少动态配件
	* @return Map<String,Integer>    key:机车型号ID	value：动态配件个数
	* @throws
	 */
	public static Map<String,Integer> getDynamicCountByDictJcTypeList(List<DictJcType> list){
		Integer totalCount=0;
		Map<String,Integer> map=new HashMap<String, Integer>();
		
		Map<String, Integer> pjFirstUnitMap=new HashMap<String, Integer>();
		if(list != null){
			for (DictJcType dictJcType : list) {
				int count=getDynamicCountByDictJcType(dictJcType);
				map.put(dictJcType.getId()+"", count);
				
				Iterator<JcTypePjFirstUnit> it=dictJcType.getJcTypePjFirstUnits().iterator();
				while (it.hasNext()) {
					DictPjFirstUnit dictPjFirstUnit=it.next().getDictPjFirstUnit();
					
					//避免重复的专业累加，所以使用pjFirstUnitMap存储个数！
					if(!pjFirstUnitMap.containsKey(dictPjFirstUnit.getId()+"")){
						pjFirstUnitMap.put(dictPjFirstUnit.getId()+"",getDynamicCountByDictPjFirstUnit(dictPjFirstUnit));
						totalCount += pjFirstUnitMap.get(dictPjFirstUnit.getId()+"");
					}
				}	
			}
		}
		map.put(Constants.ROOT, totalCount);
		return map;
	}
}
