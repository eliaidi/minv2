package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pjFix.dao.PjStoreStaticInfoDao;
import com.repair.pjFix.dto.PjStoreStaticInfoSearchDto;
import com.repair.pjFix.service.PjStoreStaticInfoService;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreStaticInfoServiceImpl
* @Description: TODO(配件静态信息接口的实现)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 下午05:57:52
 */
public class PjStoreStaticInfoServiceImpl implements PjStoreStaticInfoService{

	private PjStoreStaticInfoDao pjStoreStaticInfForPjFixDao;
	
	/**
	 *	 添加配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void addPjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo) {
		pjStoreStaticInfForPjFixDao.addPjStoreStaticInfo(storeStaticInfo);
	}

	/**
	 *	 删除配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void deletePjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo) {
		pjStoreStaticInfForPjFixDao.deletePjStoreStaticInfo(storeStaticInfo);
	}

	/**
	 *	 通过配件仓库静态信息ID查询
	 *	@param  id：配件仓库静态信息ID
	 *	@return	查询到的 配件仓库静态信息对象
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoById(long id) {
		return pjStoreStaticInfForPjFixDao.findPjStoreStaticInfoById(id);
	}


	/**
	 *	 修改配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void updatePjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo) {
		pjStoreStaticInfForPjFixDao.updatePjStoreStaticInfo(storeStaticInfo);
	}

	/**
	 * 通过pjName进行查询
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoByPjName(String pjName){
		return pjStoreStaticInfForPjFixDao.findPjStoreStaticInfoByPjName(pjName);
	}

	/**
	 *	 通过查询条件查询配件仓库静态信息，具体查询条件请参考
	 *	@param	dto  查询静态配件时需要使用的dto
	 *	@return	配件仓库静态信息集合
	 */
	public SplitPageModel findPagePjStoreStaticInfo(PjStoreStaticInfoSearchDto dto){
		return pjStoreStaticInfForPjFixDao.findPagePjStoreStaticInfo(dto);
	}
	
	/**
	 * 
	 * 查询所有静态配件信息
	 */
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfo() {
		return pjStoreStaticInfForPjFixDao.findAllPjStoreStaticInfo();
	}
	
	/**
	 * 根据Id查询数据
	 */
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfoById(long id) {
		return pjStoreStaticInfForPjFixDao.findAllPjStoreStaticInfoById(id);
	}
	
	/**
	 * 通过配件名称或拼音模糊查询配件仓库静态信息集合
	 */
	public List<PjStoreStaticInfo> findPjStoreStaticInfoListByPjNameOrPy(String pjNameOrPy){
		return pjStoreStaticInfForPjFixDao.findPjStoreStaticInfoListByPjNameOrPy(pjNameOrPy);
	}

	public PjStoreStaticInfoDao getPjStoreStaticInfForPjFixDao() {
		return pjStoreStaticInfForPjFixDao;
	}

	public void setPjStoreStaticInfForPjFixDao(
			PjStoreStaticInfoDao pjStoreStaticInfForPjFixDao) {
		this.pjStoreStaticInfForPjFixDao = pjStoreStaticInfForPjFixDao;
	}

}
