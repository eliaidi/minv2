package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.dao.PjStoreDynamicInfoDao;
import com.repair.pjFix.dto.PjStoreDynamicInfoSearchDto;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.util.page.PageModel;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreDynamicInfoServiceImpl
* @Description: TODO(配件动态信息接口的实现)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 下午09:25:44
 */
public class PjStoreDynamicInfoServiceImpl implements PjStoreDynamicInfoService{

	private PjStoreDynamicInfoDao pjSDInfoForPjFixDao;
	
	/**
	 * 添加配件仓库动态信息-->新件入库
	 * @param addPjStoreDynamicInfo 配件仓库动态信息/库存(所在位置) 对象
	 */
	public void addPjStoreDynamicInfo(PjStoreDynamicInfo storeDynamicInfo) {
		pjSDInfoForPjFixDao.addPjStoreDynamicInfo(storeDynamicInfo);
	}

	/**
	 * 删除动态配件
	 */
	public void deletePjStoreDynamicInfo(PjStoreDynamicInfo storeDynamicInfo) {
		pjSDInfoForPjFixDao.deletePjStoreDynamicInfo(storeDynamicInfo);
	}

	/**
	 * 查询所有动态配件（分页）
	 *  @return 动态配件集合
	 */
	public PageModel<PjStoreDynamicInfo> findAllPjStoreDynamicInfo() {
		return pjSDInfoForPjFixDao.findAllPjStoreDynamicInfo();
	}

	/**
	 * 通过动态配件ID查询动态配件
	 * @param id  动态配件ID
	 */
	public PjStoreDynamicInfo findPjStoreDynamicInfoById(long id) {
		return pjSDInfoForPjFixDao.findPjStoreDynamicInfoById(id);
	}

	/**
	 * 修改动态配件
	 */
	public void updatePjStoreDynamicInfo(PjStoreDynamicInfo storeDynamicInfo) {
		pjSDInfoForPjFixDao.updatePjStoreDynamicInfo(storeDynamicInfo);
	}
	
	/**
	 * 	通过大部件(专业)ID查找动态配件
	 * 	@param firstUnitid：大部件（专业）ID，如果为null或-1，则查询所有专业的动态配件
	 *  @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPagePjStoreDynamicInfoByFirstUnitid(Long firstUnitid){
		return pjSDInfoForPjFixDao.findPagePjStoreDynamicInfoByFirstUnitid(firstUnitid);
	}

	/**
	 *	 通过查询条件查询动态配件信息
	 *	@param	dto  查询动态配件时需要使用的dto
	 *	@return	配件仓库动态信息集合
	 */
	public SplitPageModel queryPjStoreDynamicInfo(PjStoreDynamicInfoSearchDto dto){
		return pjSDInfoForPjFixDao.queryPjStoreDynamicInfo(dto);
	}
	
	/**
	 * 使用ajax通过pjdCode查找当前输入的配件编号是否在数据库中存在
	 */
	public PjStoreDynamicInfo findPjStoreDynamicInfoByPjdCode(String pjdCode) {
		return pjSDInfoForPjFixDao.findPjStoreDynamicInfoByPjdCode(pjdCode);
	}
	
	/**
	 *   通过静态配件ID 查询 动态配件集合
	 *   @param pjStoreStaticInfoId：静态配件ID
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiId(long pjStoreStaticInfoId){
		return pjSDInfoForPjFixDao.findPjSDInfoListByPssiId(pjStoreStaticInfoId);
	}

	/**
	 *   通过静态配件ID和配件状态数组    查询 动态配件集合
	 *   @param pjStoreStaticInfoId：静态配件ID
	 *   @param pjdStatusArr	：配件状态数组
	 *   @return 动态配件集合
	 */
	public List<PjStoreDynamicInfo> findPjSDInfoListByPssiIdAndPjdStatusArr(long pjStoreStaticInfoId,long[] pjdStatusArr){
		return pjSDInfoForPjFixDao.findPjSDInfoListByPssiIdAndPjdStatusArr(pjStoreStaticInfoId, pjdStatusArr);
	}

	public void setPjSDInfoForPjFixDao(PjStoreDynamicInfoDao pjSDInfoForPjFixDao) {
		this.pjSDInfoForPjFixDao = pjSDInfoForPjFixDao;
	}
	
}
