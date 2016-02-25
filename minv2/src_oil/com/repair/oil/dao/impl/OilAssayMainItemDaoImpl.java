package com.repair.oil.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.OilAssayMainItem;
import com.repair.oil.dao.IOilAssayMainItemDao;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * 
 * @see 油水化验主项目dao层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayMainItemDaoImpl extends DaoSupport<OilAssayMainItem> implements IOilAssayMainItemDao{

	/**
	 * 列出已启用的  所有与此机车型号有关的油水化验集合
	 * @param jcType	机车型号
	 * @return	油水化验项目集合
	 */
	public List<OilAssayMainItem> listUseByJcType(String jcType){
		String hql="from OilAssayMainItem a where a.id in (select b.item.id  from OilAMIJcType b where b.jcType.jcTypeValue=?) and a.status="+Constants.OIL_AM_ITEM_STATUS_ENABLE;
		return hibernateTemplate.find(hql,jcType);
	}
}
