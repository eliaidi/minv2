package com.repair.pj.dao;

import java.util.List;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.dto.PjStoreStaticInfoSearchDto;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreStaticInfoDao
* @Description: TODO 配件仓库静态/基本信息 dao层
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午10:26:29
 */
public interface PjStoreStaticInfoDao extends BaseDao<PjStoreStaticInfo>{
	  

	
	
	/**
	 *	 通过查询条件查询配件仓库静态信息，具体查询条件请参考
	 *	@param	dto  查询静态配件时需要使用的dto
	 *	@return	配件仓库静态信息集合
	 */
	public SplitPageModel listPageByDto(PjStoreStaticInfoSearchDto dto);
	
	/**
	 * 通过pjName查询条件查询配件仓库静态信息
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoByPjName(String pjName);
	
	
	
	/**
	 * 通过配件名称或拼音模糊查询配件仓库静态信息集合
	 */
	public List<PjStoreStaticInfo> findPjStoreStaticInfoListByPjNameOrPy(String pjNameOrPy);
}
