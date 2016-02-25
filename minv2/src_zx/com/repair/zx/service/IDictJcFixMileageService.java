package com.repair.zx.service;

import java.util.List;

import com.repair.entity.DictJcFixMileage;

/**
 * 
 * @see 修层修次service层 
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public interface IDictJcFixMileageService {
	
	/**
	 * 通过修次值得到对象
	 * @param fixMileageValue	修次的值
	 * @return	修次对象
	 */
	public DictJcFixMileage findByFixMileageValue(String fixMileageValue);
	
	
	/**
	 * 通过Id得到对象
	 * @param id	ID
	 * @return	修次对象
	 */
	public DictJcFixMileage findById(Long id);
	
	/**
	 * 列出所有修程修次
	 * @return
	 */
	public List<DictJcFixMileage> listAll();
}
