package com.repair.pjFix.dao;

import java.util.List;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pjFix.dto.PjStoreStaticInfoSearchDto;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreStaticInfoDao
* @Description: TODO 配件仓库静态/基本信息 dao层
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午10:26:29
 */
public interface PjStoreStaticInfoDao {
	  
	/**
	 *	 添加配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void addPjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo);
	
	/**
	 *	 通过配件仓库静态信息ID查询
	 *	@param  id：配件仓库静态信息ID
	 *	@return	查询到的 配件仓库静态信息对象
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoById(long id);
	
	/**
	 *	 删除配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void deletePjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo);
	
	/**
	 *	 修改配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void updatePjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo);
	
	/**
	 *	 通过查询条件查询配件仓库静态信息，具体查询条件请参考
	 *	@param	dto  查询静态配件时需要使用的dto
	 *	@return	配件仓库静态信息集合
	 */
	public SplitPageModel findPagePjStoreStaticInfo(PjStoreStaticInfoSearchDto dto);
	
	/**
	 * 通过pjName查询条件查询配件仓库静态信息
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoByPjName(String pjName);
	
	/**
	 * 查询所有静态配件信息
	 */
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfo();
	
	/**
	 * 
	* @Title: findAllPjStoreStaticInfoById 
	* @Description: TODO(通过ID查询数据) 
	* @param @param id
	 */
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfoById(long id);
	
	/**
	 * 通过配件名称或拼音模糊查询配件仓库静态信息集合
	 */
	public List<PjStoreStaticInfo> findPjStoreStaticInfoListByPjNameOrPy(String pjNameOrPy);
	
}
