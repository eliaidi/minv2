package com.repair.oil.dao.impl;

import java.util.List;

import com.repair.entity.OilAssayChildItemRec;
import com.repair.oil.dao.IOilAssayChildItemRecDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 油水化验子项目dao层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayChildItemRecDaoImpl extends DaoSupport<OilAssayChildItemRec> implements IOilAssayChildItemRecDao{


	/**
	 * 通过油水化验主项目ID 和 日计划ID 进行查询   对应的子项目记录集合
	 * @param planDateId	日计划ID
	 * @param mainItemId	油水化验主项目ID
	 * @return	油水化验子记录集合
	 */
	@SuppressWarnings("unchecked")
	public List<OilAssayChildItemRec> listByConditions(Long planDateId,Long mainItemId){
		String hql="from OilAssayChildItemRec where mainItemRec.planDate.id=? and childItem.item.id=?";
		return hibernateTemplate.find(hql,planDateId,mainItemId);
	}

	/**
	 * 通过油化实验记录主表Id,查询对应的油化实验记录IAO数据
	 */
	@SuppressWarnings("unchecked")
	public List<OilAssayChildItemRec> listOilAssayChildItemRecByMainItemId(
			Long mainItemId) {
		String hql="from OilAssayChildItemRec where mainItemRec.id=?";
		return  hibernateTemplate.find(hql,mainItemId);
	}


}
