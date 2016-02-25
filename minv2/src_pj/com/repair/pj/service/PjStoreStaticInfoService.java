package com.repair.pj.service;

import java.util.List;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.dto.PjStoreStaticInfoSearchDto;
import com.repair.util.serviceSupport.BaseService;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreStaticInfoService
* @Description: TODO 配件仓库静态/基本信息 service层
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午10:35:36
 */
public interface PjStoreStaticInfoService extends BaseService<PjStoreStaticInfo>{

	
	
	/**
	 *  通过配件名称进行查询
	 *  @param	storeStaticInfo  配件仓库静态信息对象
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoByPjName(String pjName);
	
	
	
	/**
	 *	 通过查询条件查询配件仓库静态信息，具体查询条件请参考
	 *	@param	dto  查询静态配件时需要使用的dto
	 *	@return	配件仓库静态信息集合
	 */
	public SplitPageModel listPageByDto(PjStoreStaticInfoSearchDto dto);
	
	
	/**
	 * 通过配件名称或拼音模糊查询配件仓库静态信息集合
	 */
	public List<PjStoreStaticInfo> findPjStoreStaticInfoListByPjNameOrPy(String pjNameOrPy);
	
}
