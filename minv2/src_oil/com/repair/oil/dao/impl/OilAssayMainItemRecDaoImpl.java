package com.repair.oil.dao.impl;

import java.util.List;
import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.dao.IOilAssayMainItemRecDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 油水化验主项目dao层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayMainItemRecDaoImpl extends DaoSupport<OilAssayMainItemRec> implements IOilAssayMainItemRecDao{

	/**
	 * 通过日计划Id查询油化实验记录主表
	 */
	@SuppressWarnings("unchecked")
	public OilAssayMainItemRec findOilAssayMainItemRecByPlanDateId(
			Long planDateId) {
		String hql="from OilAssayMainItemRec rec where rec.planDate.id=?";
		List<OilAssayMainItemRec> list=hibernateTemplate.find(hql, new Object[]{planDateId});
		OilAssayMainItemRec oilAssayMainItemRec=null;
		if(list.size()>0)
		{
			oilAssayMainItemRec=list.get(0);
		}
		return oilAssayMainItemRec;
	}


}
