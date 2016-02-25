package com.repair.plan.service;

import com.repair.entity.DictJcFixMileage;

/**
 * 
 * @see 修层修次service层 
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public interface IDictJcFixMileageService {
	
	/**
	 * 通过修次值得到对象
	 * @param fixMileageValue	修次的值
	 * @return	修次对象
	 */
	public DictJcFixMileage findByFixMileageValue(String fixMileageValue);
	
}
