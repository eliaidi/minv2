package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.dao.PjStoreStaticInfoDao;
import com.repair.pj.dto.PjStoreStaticInfoSearchDto;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.serviceSupport.ServiceSupport;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreStaticInfoServiceImpl
* @Description: TODO(静态配件service接口实现类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 下午05:57:52
 */
public class PjStoreStaticInfoServiceImpl extends ServiceSupport<PjStoreStaticInfo> implements PjStoreStaticInfoService{

	private PjStoreStaticInfoDao pjStoreStaticInfoDao;
	
	
	/**
	 * 通过pjName进行查询
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoByPjName(String pjName){
		return pjStoreStaticInfoDao.findPjStoreStaticInfoByPjName(pjName);
	}

	/**
	 *	 通过查询条件查询配件仓库静态信息，具体查询条件请参考
	 *	@param	dto  查询静态配件时需要使用的dto
	 *	@return	配件仓库静态信息集合
	 */
	public SplitPageModel listPageByDto(PjStoreStaticInfoSearchDto dto){
		return pjStoreStaticInfoDao.listPageByDto(dto);
	}
	
	
	/**
	 * 通过配件名称或拼音模糊查询配件仓库静态信息集合
	 */
	public List<PjStoreStaticInfo> findPjStoreStaticInfoListByPjNameOrPy(String pjNameOrPy){
		return pjStoreStaticInfoDao.findPjStoreStaticInfoListByPjNameOrPy(pjNameOrPy);
	}
	
	public void setPjStoreStaticInfoDao(PjStoreStaticInfoDao pjStoreStaticInfoDao) {
		this.pjStoreStaticInfoDao=pjStoreStaticInfoDao;
	}

}
