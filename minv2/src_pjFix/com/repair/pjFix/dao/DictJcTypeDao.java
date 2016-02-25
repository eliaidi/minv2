package com.repair.pjFix.dao;

import java.util.List;
import com.repair.entity.DictJcType;

/**
* @ClassName: DictJcType
* @Description: TODO 机车类型dao层接口
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午11:39:31
 */
public interface DictJcTypeDao {
	
	/**
	 * 获取所有机车类型
	 * @return List<DictJcType>
	 */
	public List<DictJcType> findAllDictJcType();
	
	
	/**
	* @Title: findDictJcTypeById 
	* @Description: TODO 通过ID获得机车类型
	* @param @param id
	* @throws
	 */
	public DictJcType findDictJcTypeById(long id);
}
