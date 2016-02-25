package com.repair.oil.service.impl;

import java.util.List;

import com.repair.entity.OilAssayMainItem;
import com.repair.oil.dao.IOilAssayMainItemDao;
import com.repair.oil.service.IOilAssayMainItemService;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.serviceSupport.BaseService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * 
 * @see 油水化验主项目service层
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayMainItemServiceImpl extends ServiceSupport<OilAssayMainItem> implements IOilAssayMainItemService{

	private IOilAssayMainItemDao oilAssayMainItemDao;
	
	/**
	 * 列出已启用的  所有与此机车型号有关的油水化验集合
	 * @param jcType	机车型号
	 * @return	油水化验项目集合
	 */
	public List<OilAssayMainItem> listUseByJcType(String jcType){
		return oilAssayMainItemDao.listUseByJcType(jcType);
	}

	public void setOilAssayMainItemDao(IOilAssayMainItemDao oilAssayMainItemDao) {
		this.oilAssayMainItemDao = oilAssayMainItemDao;
	}
	
}
