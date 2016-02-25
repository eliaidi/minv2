package com.repair.zx.service.impl;


import java.util.List;

import com.repair.entity.DictJcFixMileage;
import com.repair.zx.dao.IDictJcFixMileageDao;
import com.repair.zx.service.IDictJcFixMileageService;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 修次service层 
 * @author 周云韬
 * @date 2015-12-10
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


	/**
	 * 通过Id得到对象
	 * @param id	ID
	 * @return	修次对象
	 */
	public DictJcFixMileage findById(Long id){
		return dictJcFixMileageDao.findById(id);
	}
	
	
	/**
	 * 列出所有修程修次
	 * @return
	 */
	public List<DictJcFixMileage> listAll(){
		return dictJcFixMileageDao.listAll();
	}


	public void setDictJcFixMileageDao(IDictJcFixMileageDao dictJcFixMileageDao) {
		this.dictJcFixMileageDao = dictJcFixMileageDao;
	}
	
	
	
}
