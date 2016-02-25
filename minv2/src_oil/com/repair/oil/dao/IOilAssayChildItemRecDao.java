package com.repair.oil.dao;

import java.util.List;
import com.repair.entity.OilAssayChildItemRec;
import com.repair.util.daoSupport.BaseDao;

/**
 * 
 * @see 油水化验子项目dao层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public interface IOilAssayChildItemRecDao extends BaseDao<OilAssayChildItemRec>{

	/**
	 * 通过油水化验主项目ID 和 日计划ID 进行查询   对应的子项目记录集合
	 * @param planDateId	日计划ID
	 * @param mainItemId	油水化验主项目ID
	 * @return	油水化验子记录集合
	 */
	public List<OilAssayChildItemRec> listByConditions(Long planDateId,Long mainItemId);
	
	/**
	 * 通过油化实验记录主表Id,查询对应的油化实验记录IAO数据
	 * @param mainItemId 油化实验记录主表Id
	 * @return
	 */
	public List<OilAssayChildItemRec> listOilAssayChildItemRecByMainItemId(Long mainItemId);
}
