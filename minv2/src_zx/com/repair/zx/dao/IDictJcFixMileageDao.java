package com.repair.zx.dao;

import java.util.List;

import com.repair.entity.DictJcFixMileage;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 修次修次dao层 
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public interface IDictJcFixMileageDao extends BaseDao<DictJcFixMileage>{
	
	/**
	 * 通过修次值得到对象
	 * @param fixMileageValue	修次的值
	 * @return	修次对象
	 */
	public DictJcFixMileage findByFixMileageValue(String fixMileageValue);
	
	
}
