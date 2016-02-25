package com.repair.pjFix.action.pjStoreStaicInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pjFix.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindPjStoreStaticInfoByIdAction
* @Description: TODO(查询静态配件下的动态配件的动态配件编码)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-23 上午11:22:33
 */
public class FindPjStoreStaticInfoByIdAction extends BaseAction implements ModelDriven<PjStoreStaticInfo>{

	private PjStoreStaticInfoService pjSSInfoForPjFixService;
	
	private PjStoreStaticInfo pjSSInfo=new PjStoreStaticInfo();
	
	@Override
	public String execute() throws Exception {
		PjStoreStaticInfo pjssInfos = pjSSInfoForPjFixService.findPjStoreStaticInfoById(pjSSInfo.getId());
		request.setAttribute("pjSSInfo", pjssInfos);
		
		return Action.SUCCESS;
	}
	
	public PjStoreStaticInfo getModel() {
		return this.pjSSInfo;
	}

	public void setPjSSInfoForPjFixService(
			PjStoreStaticInfoService pjSSInfoForPjFixService) {
		this.pjSSInfoForPjFixService = pjSSInfoForPjFixService;
	}

}
