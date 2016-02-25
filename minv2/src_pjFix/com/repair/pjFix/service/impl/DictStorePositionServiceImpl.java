package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.pjFix.dao.DictStorePositionDao;
import com.repair.pjFix.service.DictStorePositionService;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: DictStorePositionService
* @Description: TODO 配件所在位置/仓库表 service层实现层
* @author lxb
* @version V1.0  
* @date 2015-8-28 下午5:00:46
 */
public class DictStorePositionServiceImpl implements DictStorePositionService {
	
	private DictStorePositionDao dictStorePositionForPjFixDao;
	
	/**
	 * 通过仓库（所在位置）名称模糊查询
	 */
	public List<DictStorePosition> findDictStorePositionByName(String storePositionName) {
		return dictStorePositionForPjFixDao.findDictStorePositionByName(storePositionName);
	}
	
	/**
	 * 通过仓库（所在位置）名称模糊查询
	 */
	public List<DictStorePosition> findDictStorePositionByType(int storePositionType) {
		return dictStorePositionForPjFixDao.findDictStorePositionByType(storePositionType);
	}
	
	/**
	 * 通过机务段(地区)ID进行查询
	 */
	public List<DictStorePosition> findDictStorePositionByDictAreaId(String dictAreaId) {
		return dictStorePositionForPjFixDao.findDictStorePositionByDictAreaId(dictAreaId);
	}
	
	/**
	 * 获得所有仓库（所在位置）信息 
	 */
	public List<DictStorePosition> findAllDictStorePosition() {
		return dictStorePositionForPjFixDao.findAllDictStorePosition();
	}

	/**
	 *	通过查询条件查询仓库集合，具体查询请参考pj/iframePage/storePosition/storePositionManagerIframe.jsp页面
	 *	配件所在位置分页service层
	 */
	public SplitPageModel queryDictStorePosition(DictStorePosition dictStorePosition){
		return dictStorePositionForPjFixDao.queryDictStorePosition(dictStorePosition);
	}
	
	/**
	 * 修改配件仓库(所在位置)
	 */
	public void updateDictStorePosition(DictStorePosition storePosition){
		dictStorePositionForPjFixDao.updateDictStorePosition(storePosition);
	}
	
	/**
	 * 删除配件仓库(所在位置)
	 */
	public void deleteDictStorePosition(DictStorePosition storePosition){
		dictStorePositionForPjFixDao.deleteDictStorePosition(storePosition);
	}
	
	/**
	 * 添加配件仓库(所在位置)
	 */
	public void addDictStorePosition(DictStorePosition storePosition){
		dictStorePositionForPjFixDao.addDictStorePosition(storePosition);
	}
	/**
	 * 通过ID获取配件位置
	 */
	public DictStorePosition findDictStorePositionById(long id) {
		return dictStorePositionForPjFixDao.findDictStorePositionById(id);
	}
	
	public void delDictStorePositionById(long id) {
		dictStorePositionForPjFixDao.delDictStorePositionById(id);

	}
	
	public DictStorePositionDao getDictStorePositionForPjFixDao() {
		return dictStorePositionForPjFixDao;
	}
	
	public void setDictStorePositionForPjFixDao(
			DictStorePositionDao dictStorePositionForPjFixDao) {
		this.dictStorePositionForPjFixDao = dictStorePositionForPjFixDao;
	}
	
}
