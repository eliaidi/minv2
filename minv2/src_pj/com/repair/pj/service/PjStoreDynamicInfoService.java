package com.repair.pj.service;

import java.util.List;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.dto.PjStoreDynamicInfoSearchDto;
import com.repair.util.page.PageModel;
import com.repair.util.serviceSupport.BaseService;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreDynamicInfoService 
* @Description: TODO 配件仓库动态信息/库存(所在位置)service层
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 上午11:09:10
 */
public interface PjStoreDynamicInfoService extends BaseService<PjStoreDynamicInfo>{

	
	
	/**
	 * 	通过大部件(专业)ID查找动态配件
	 * 	@param firstUnitid：大部件（专业）ID，如果为null或-1，则查询所有专业的动态配件
	 *  @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPagePjStoreDynamicInfoByFirstUnitid(Long firstUnitid);
	

	
	/**
	 *	 通过查询条件查询动态配件信息
	 *	@param	dto  查询动态配件时需要使用的dto
	 *	@return	配件仓库动态信息集合
	 */
	public SplitPageModel queryPjStoreDynamicInfo(PjStoreDynamicInfoSearchDto dto);
	
	/**
	 * 使用ajax通过pjdCode查找当前输入的配件编号是否在数据库中存在
	 */
	public PjStoreDynamicInfo findPjStoreDynamicInfoByPjdCode(String pjdCode) ;
	
	
	/**
	 *   通过静态配件ID 查询 动态配件集合
	 *   @param pjStoreStaticInfoId：静态配件ID
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiId(long pjStoreStaticInfoId);
	
}
