package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.pj.dao.DictStorePositionDao;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.serviceSupport.ServiceSupport;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: DictStorePositionService
* @Description: TODO 配件所在位置/仓库表 service层实现层
* @author lxb
* @version V1.0  
* @date 2015-8-28 下午5:00:46
 */
public class DictStorePositionServiceImpl extends ServiceSupport<DictStorePosition> implements DictStorePositionService {
	
	private DictStorePositionDao dictStorePositionDao;
	
	/**
	 * 通过仓库（所在位置）名称模糊查询
	 */
	public List<DictStorePosition> findDictStorePositionByName(String storePositionName) {
		return dictStorePositionDao.findDictStorePositionByName(storePositionName);
	}
	
	/**
	 * 通过仓库（所在位置）名称模糊查询
	 */
	public List<DictStorePosition> findDictStorePositionByType(int storePositionType) {
		return dictStorePositionDao.findDictStorePositionByType(storePositionType);
	}
	
	/**
	 * 通过机务段(地区)ID进行查询
	 */
	public List<DictStorePosition> findDictStorePositionByDictAreaId(String dictAreaId) {
		return dictStorePositionDao.findDictStorePositionByDictAreaId(dictAreaId);
	}
	
	

	/**
	 *	通过查询条件查询仓库集合，具体查询请参考pj/iframePage/storePosition/storePositionManagerIframe.jsp页面
	 *	配件所在位置分页service层
	 */
	public SplitPageModel queryDictStorePosition(DictStorePosition dictStorePosition){
		return dictStorePositionDao.queryDictStorePosition(dictStorePosition);
	}
	
	

	public void setDictStorePositionDao(DictStorePositionDao dictStorePositionDao) {
		this.dictStorePositionDao = dictStorePositionDao;
	}

}
