package com.repair.pj.action.pjStoreStaticInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: FindPjStoreStaticInfoByIdAction
 * @Description: TODO(实现findPjStoreStaticInfoById方法，通过Id查新数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 上午11:25:45
 */
public class FindPjStoreStaticInfoByIdAction extends BaseAction implements
		ModelDriven<PjStoreStaticInfo> {

	private PjStoreStaticInfo pjStoreStaticInfo = new PjStoreStaticInfo();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	@Override
	public String execute() throws Exception {
		PjStoreStaticInfo pjssInfo = pjStoreStaticInfoService.findById(pjStoreStaticInfo.getId());
		request.getSession().setAttribute("pjSSInfo", pjssInfo);
		//组装状态
		request.setAttribute("pjAssemblyType", Constants.PJ_ASSEMBLY_TYPE);
		return Action.SUCCESS;
	}

	public PjStoreStaticInfo getModel() {
		return this.pjStoreStaticInfo;
	}


	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

}
