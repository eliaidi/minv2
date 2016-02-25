package com.repair.plan.service.impl;


import com.repair.entity.DictJcFixMileage;
import com.repair.plan.dao.IDictJcFixMileageDao;
import com.repair.plan.service.IDictJcFixMileageService;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 修次service层 
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class DictJcFixMileageServiceImpl extends DaoSupport implements IDictJcFixMileageService{
	
	private IDictJcFixMileageDao dictJcFixMileageDao;
	
	/**
	 * 通过修次值得到对象
	 * @param fixMileageValue	修次的值
	 * @return	修次对象
	 */
	public DictJcFixMileage findByFixMileageValue(String fixMileageValue){
		return dictJcFixMileageDao.findByFixMileageValue(fixMileageValue);
	}

	public void setDictJcFixMileageDao(IDictJcFixMileageDao dictJcFixMileageDao) {
		this.dictJcFixMileageDao = dictJcFixMileageDao;
	}

	
	
	
}
