package com.repair.oil.service.impl;

import java.util.List;

import com.repair.entity.OilAssayChildItemRec;
import com.repair.oil.dao.IOilAssayChildItemRecDao;
import com.repair.oil.dao.IOilAssayMainItemRecDao;
import com.repair.oil.service.IOilAssayChildItemRecService;
import com.repair.util.serviceSupport.BaseService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 油水化验子项目service层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayChildItemRecServiceImpl extends ServiceSupport<OilAssayChildItemRec> implements IOilAssayChildItemRecService {
	private IOilAssayChildItemRecDao oilAssayChildItemRecDao;
	
	/**
	 * 通过油水化验主项目ID 和 日计划ID 进行查询   对应的子项目记录集合
	 * @param planDateId	日计划ID
	 * @param mainItemId	油水化验主项目ID
	 * @return	油水化验子记录集合
	 */
	public List<OilAssayChildItemRec> listByConditions(Long planDateId,Long mainItemId){
		return oilAssayChildItemRecDao.listByConditions(planDateId, mainItemId);
	}
	
	/**
	 * 通过油化实验记录主表Id,查询对应的油化实验记录IAO数据
	 */
	public List<OilAssayChildItemRec> listOilAssayChildItemRecByMainItemId(
			Long mainItemId) {
		// TODO Auto-generated method stub
		return oilAssayChildItemRecDao.listOilAssayChildItemRecByMainItemId(mainItemId);
	}
	

	public void setOilAssayChildItemRecDao(
			IOilAssayChildItemRecDao oilAssayChildItemRecDao) {
		this.oilAssayChildItemRecDao = oilAssayChildItemRecDao;
	}

	
	
	
}
