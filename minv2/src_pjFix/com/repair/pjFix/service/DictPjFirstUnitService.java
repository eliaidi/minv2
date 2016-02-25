package com.repair.pjFix.service;

import java.util.List;
import com.repair.entity.DictPjFirstUnit;

/**
* @ClassName: DictPjFirstUnitService
* @Description: TODO 大部件(专业)表 service层
* @author唐鹏
* @version V1.0  
* @date 2015-8-28 下午4:44:19
 */
public interface DictPjFirstUnitService {
	
	/**
	 * 
	* 通过大部件(专业名)模糊查询大部件
	* @param   unitName：大部件(专业名)
	* @return 大部件集合
	 */
	public  List<DictPjFirstUnit> findDictPjFirstUnitByUnitName(String unitName);
	
	/**
	 * 添加大部件
	 * @param	firstUnit：大部件对象
	 */
	public void  addDictPjFirstUnit(DictPjFirstUnit firstUnit);
	
	/**
	 * 查询所有大部件
	 */
	public List<DictPjFirstUnit>  findAllDictPjFirstUnit();

	/**
	 * 通过id删除对象
	 */
	public void deleteDictPjFirstUnit(long id);
	
	/**
	 * 通过Id 查找信息
	 */
	public DictPjFirstUnit findDictPjFirstUnitById(long id);

	/**
	 * 修改数据
	 */
	
	public void updateDictPjFirstUnit(DictPjFirstUnit dictPjFirstUnit);
	
	/**
	 * 
	* 通过专业名或拼音模糊查询大部件（不区分大小写）
	* @param   unitNameOrPy：专业名或拼音
	* @return 大部件集合
	 */
	public  List<DictPjFirstUnit> findDictPjFirstUnitListByUnitNameOrPy(String unitNameOrPy);
}
