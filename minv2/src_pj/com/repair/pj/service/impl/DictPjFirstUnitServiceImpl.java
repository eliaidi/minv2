package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.dao.DictPjFirstUnitDao;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.util.serviceSupport.ServiceSupport;

/** 
* @ClassName: DictPjFirstUnitServiceImpl
* @Description: TODO 大部件(专业)表 service层接口实现层
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午4:44:19
 */
public class DictPjFirstUnitServiceImpl extends ServiceSupport<DictPjFirstUnit> implements DictPjFirstUnitService{

	private DictPjFirstUnitDao dictPjFirstUnitDao;
	
	

	/**
	* 通过大部件(专业名)模糊查询大部件
	* @param   unitName：大部件(专业名)
	* @return 大部件集合
	 */
	public List<DictPjFirstUnit> findDictPjFirstUnitByUnitName(String unitName) {
		return dictPjFirstUnitDao.findDictPjFirstUnitByUnitName(unitName);
	}
	
	

	/**
	* 通过专业名或拼音模糊查询大部件（不区分大小写）
	* @param   unitNameOrPy：专业名或拼音
	* @return 大部件集合
	 */
	public  List<DictPjFirstUnit> findDictPjFirstUnitListByUnitNameOrPy(String unitNameOrPy){
		return dictPjFirstUnitDao.findDictPjFirstUnitListByUnitNameOrPy(unitNameOrPy);
	}
	
	public void setDictPjFirstUnitDao(DictPjFirstUnitDao dictPjFirstUnitDao) {
		this.dictPjFirstUnitDao = dictPjFirstUnitDao;
	}	
}
