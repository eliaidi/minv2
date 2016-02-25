package com.repair.pjFix.service;

import java.util.List;
import com.repair.entity.DictJcType;

/**
* @ClassName: DictJcTypeService
* @Description: TODO 机车类型service层接口
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午11:39:31
 */
public interface DictJcTypeService {
	
	/**
	 * 获得所有机车类型
	 * @return List<DictJcType>   
	 */
	public List<DictJcType> findAllDictJcType();
	
	/**
	* @Title: findDictJcTypeById 
	* @Description: TODO(通过机车类型ID获取机车类型) 
	* @param @param id
	* @throws
	 */
	public DictJcType findDictJcTypeById(long id);
}
