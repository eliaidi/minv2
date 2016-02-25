package com.repair.pjFix.service;

import java.util.List;
import com.repair.entity.DictStorePosition;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: DictStorePositionService
* @Description: TODO 配件所在位置/仓库表 service层
* @author 周云韬
* @version V1.0  
* @date 2015-8-28 下午4:28:46
 */
public interface DictStorePositionService {

	/**
	 * 通过仓库（所在位置）名称模糊查询
	 * @param storePositionName  仓库名
	 * @return 仓库（所在位置）集合
	 */
	public List<DictStorePosition> findDictStorePositionByName(String storePositionName);
	
	/**
	 * 通过仓库（位置）类型 查询
	 * @param storePositionType  仓库(位置类型)
	 * @return 仓库（所在位置）集合
	 */
	public List<DictStorePosition> findDictStorePositionByType(int storePositionType);
	
	/**
	 * 通过机务段(地区)ID进行查询
	 * @param dictAreaId：机务段(地区)ID
	 * @return 仓库（所在位置）集合    
	 */
	public List<DictStorePosition> findDictStorePositionByDictAreaId(String dictAreaId);
	
	/**
	 *	获得所有仓库（所在位置）信息 
	 */
	public List<DictStorePosition> findAllDictStorePosition();
	
	/**
	 *	通过查询条件查询仓库集合，具体查询请参考pj/iframePage/storePosition/storePositionManagerIframe.jsp页面
	 *	
	 */
	public SplitPageModel queryDictStorePosition(DictStorePosition dictStorePosition);
	
	/**
	 * 修改配件仓库(所在位置)
	 */
	public void updateDictStorePosition(DictStorePosition storePosition);
	
	/**
	 * 删除配件仓库(所在位置)
	 */
	public void deleteDictStorePosition(DictStorePosition storePosition);
	
	/**
	 * 添加配件仓库(所在位置)
	 */
	public void addDictStorePosition(DictStorePosition storePosition);
	
	/**
	 * 通过ID获取配件位置
	 */
	public DictStorePosition findDictStorePositionById(long id);
	
	/**
	 * 通过ID删除配置仓库位置
	 */
	public void delDictStorePositionById(long id);
	
}
