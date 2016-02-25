package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.dao.PjStoreDynamicInfoDao;
import com.repair.pj.dto.PjStoreDynamicInfoSearchDto;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.page.PageModel;
import com.repair.util.serviceSupport.ServiceSupport;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreDynamicInfoServiceImpl
* @Description: TODO(动态配件service接口实现类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 下午09:25:44
 */
public class PjStoreDynamicInfoServiceImpl extends ServiceSupport<PjStoreDynamicInfo> implements PjStoreDynamicInfoService{

	private PjStoreDynamicInfoDao pjStoreDynamicInfoDao;
	
	
	/**
	 * 	通过大部件(专业)ID查找动态配件
	 * 	@param firstUnitid：大部件（专业）ID，如果为null或-1，则查询所有专业的动态配件
	 *  @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPagePjStoreDynamicInfoByFirstUnitid(Long firstUnitid){
		return pjStoreDynamicInfoDao.findPagePjStoreDynamicInfoByFirstUnitid(firstUnitid);
	}

	/**
	 *	 通过查询条件查询动态配件信息
	 *	@param	dto  查询动态配件时需要使用的dto
	 *	@return	配件仓库动态信息集合
	 */
	public SplitPageModel queryPjStoreDynamicInfo(PjStoreDynamicInfoSearchDto dto){
		return pjStoreDynamicInfoDao.queryPjStoreDynamicInfo(dto);
	}
	
	/**
	 * 使用ajax通过pjdCode查找当前输入的配件编号是否在数据库中存在
	 */
	public PjStoreDynamicInfo findPjStoreDynamicInfoByPjdCode(String pjdCode) {
		return pjStoreDynamicInfoDao.findPjStoreDynamicInfoByPjdCode(pjdCode);
	}
	
	/**
	 *   通过静态配件ID 查询 动态配件集合
	 *   @param pjStoreStaticInfoId：静态配件ID
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiId(long pjStoreStaticInfoId){
		return pjStoreDynamicInfoDao.findPjSDInfoListByPssiId(pjStoreStaticInfoId);
	}
	
	public void setPjStoreDynamicInfoDao(PjStoreDynamicInfoDao pjStoreDynamicInfoDao) {
		this.pjStoreDynamicInfoDao = pjStoreDynamicInfoDao;
	}

}
