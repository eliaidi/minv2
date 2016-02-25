package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pjFix.dao.DictPjFirstUnitDao;
import com.repair.pjFix.service.DictPjFirstUnitService;

/**
* @ClassName: DictPjFirstUnitServiceImpl
* @Description: TODO 大部件(专业)表 service层接口实现层
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午4:44:19
 */
public class DictPjFirstUnitServiceImpl implements DictPjFirstUnitService{

	private DictPjFirstUnitDao dictPjFirstUnitForPjFixDao;
	
	/**
	 * 添加大部件
	 * @param	firstUnit：大部件对象
	 */
	public void addDictPjFirstUnit(DictPjFirstUnit firstUnit) {
		dictPjFirstUnitForPjFixDao.addDictPjFirstUnit(firstUnit);
	}

	/**
	 * 
	* 通过大部件(专业名)模糊查询大部件
	* @param   unitName：大部件(专业名)
	* @return 大部件集合
	 */
	public List<DictPjFirstUnit> findDictPjFirstUnitByUnitName(String unitName) {
		return dictPjFirstUnitForPjFixDao.findDictPjFirstUnitByUnitName(unitName);
	}
	
	/**
	 * 查询所有大部件
	 */
	public List<DictPjFirstUnit> findAllDictPjFirstUnit() {
		return dictPjFirstUnitForPjFixDao.findAllDictPjFirstUnit();
	}
	
	/**
	 * 删除数据-大部件（专业）
	 */
	public void deleteDictPjFirstUnit(long id) {
		dictPjFirstUnitForPjFixDao.deleteDictPjFirstUnit(id);
	}

	/**
	 * 通过Id查询数据-大部件（专业）
	 */
	public DictPjFirstUnit findDictPjFirstUnitById(long id) {
		return dictPjFirstUnitForPjFixDao.findDictPjFirstUnitById(id);
	}

	/**
	* @Title: updateDictPjFirstUnit 
	* @Description: TODO(修改数据-大部件（专业）) 
	 */
	public void updateDictPjFirstUnit(DictPjFirstUnit dictPjFirstUnit) {
		dictPjFirstUnitForPjFixDao.updateDictPjFirstUnit(dictPjFirstUnit);
	}
	
	/**
	* 通过专业名或拼音模糊查询大部件（不区分大小写）
	* @param   unitNameOrPy：专业名或拼音
	* @return 大部件集合
	 */
	public  List<DictPjFirstUnit> findDictPjFirstUnitListByUnitNameOrPy(String unitNameOrPy){
		return dictPjFirstUnitForPjFixDao.findDictPjFirstUnitListByUnitNameOrPy(unitNameOrPy);
	}

	public DictPjFirstUnitDao getDictPjFirstUnitForPjFixDao() {
		return dictPjFirstUnitForPjFixDao;
	}

	public void setDictPjFirstUnitForPjFixDao(
			DictPjFirstUnitDao dictPjFirstUnitForPjFixDao) {
		this.dictPjFirstUnitForPjFixDao = dictPjFirstUnitForPjFixDao;
	}
	
}
