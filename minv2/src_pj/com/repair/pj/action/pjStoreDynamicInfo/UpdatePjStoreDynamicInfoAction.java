package com.repair.pj.action.pjStoreDynamicInfo;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjSDInfoRecordSu;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: UpdatePjStoreDynamicInfoAction
 * @Description: TODO(实现updatePjStoreDynamicInfo方法，修改数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午10:02:34
 */
public class UpdatePjStoreDynamicInfoAction extends BaseAction implements
		ModelDriven<PjStoreDynamicInfo> {
	private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private DictStorePositionService dictStorePositionService;
	private PjSDInfoRecordSu pjSDInfoRecordSu ;
	private String returnUrl;

	@Override
	public String execute() throws Exception {
		try {
			//通过ID获取当前动态配件信息
			PjStoreDynamicInfo psdi=pjStoreDynamicInfoService.findById(this.pjStoreDynamicInfo.getId());
			
			//通过动态配件查找配件静态信息
			PjStoreStaticInfo pjStoreStaticInfo=pjStoreStaticInfoService.findById(pjStoreDynamicInfo.getPjStoreStaticInfo().getId());
			pjStoreDynamicInfo.setPjStoreStaticInfo(pjStoreStaticInfo);
			psdi.setPjStoreStaticInfo(pjStoreStaticInfo);
			
			//通过动态配件查找仓库信息
			DictStorePosition dictStorePosition=dictStorePositionService.
						findById(this.pjStoreDynamicInfo.getDictStorePosition().getId());
			psdi.setDictStorePosition(dictStorePosition);
			
			//查找记录。。。
			PjStoreDynamicInfo parentPsdi=pjStoreDynamicInfoService.findById(pjStoreDynamicInfo.getParentPjStoreDynamicInfo().getId());
			psdi.setPjdCode(pjStoreDynamicInfo.getPjdCode());
			psdi.setPjdFactory(pjStoreDynamicInfo.getPjdFactory());
			psdi.setPjdInPrice(pjStoreDynamicInfo.getPjdInPrice());
			psdi.setPjdOutFactoryDate(pjStoreDynamicInfo.getPjdOutFactoryDate());
			psdi.setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ZERO);
			psdi.setPy(pjStoreDynamicInfo.getPy());
			psdi.setParentPjStoreDynamicInfo(parentPsdi);
			psdi.setRemark("关于动态信息的主要记录");
			
			pjStoreDynamicInfoService.update(psdi);
			session.setAttribute("message", Constants.COMMON_MESSAGE_UPDATE_SUC);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Constants.COMMON_MESSAGE_UPDATE_ERROR);
		}
		return Action.SUCCESS;
	}

	public PjStoreDynamicInfo getModel() {
		return this.pjStoreDynamicInfo;
	}

	public void setPjStoreDynamicInfoService(PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}

	public void setPjSDInfoRecordSu(PjSDInfoRecordSu pjSDInfoRecordSu) {
		this.pjSDInfoRecordSu = pjSDInfoRecordSu;
	}

	public void setPjStoreStaticInfoService(PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}	

	public void setDictStorePositionService(DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
}
