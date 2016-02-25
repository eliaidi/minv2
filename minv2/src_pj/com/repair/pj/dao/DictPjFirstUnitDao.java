package com.repair.pj.dao;

import java.util.List;
import com.repair.entity.DictPjFirstUnit;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: DictPjFirstUnitDao
* @Description: TODO 大部件(专业)表 dao层
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午4:44:19
 */
public interface DictPjFirstUnitDao extends BaseDao<DictPjFirstUnit>{
	
	/**
	 * 
	* 通过大部件(专业名)模糊查询大部件
	* @param   unitName：大部件(专业名)
	* @return 大部件集合
	 */
	public  List<DictPjFirstUnit> findDictPjFirstUnitByUnitName(String unitName);
	
	
	/**
	 * 
	* 通过专业名或拼音模糊查询大部件（不区分大小写）
	* @param   unitNameOrPy：专业名或拼音
	* @return 大部件集合
	 */
	public  List<DictPjFirstUnit> findDictPjFirstUnitListByUnitNameOrPy(String unitNameOrPy);
	

	
}
