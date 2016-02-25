package com.repair.pj.action.pjStoreDynamicInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: FindPjStoreDynamicInfoByIdAction
 * @Description: TODO根据Id查询配件动态信息数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午09:59:25
 */
public class FindPjStoreDynamicInfoByIdAction extends BaseAction implements ModelDriven<PjStoreDynamicInfo> {

	private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;

	@Override
	public String execute() throws Exception {
		PjStoreDynamicInfo pjDynamicInfo = pjStoreDynamicInfoService.findById(pjStoreDynamicInfo.getId());
		return Action.SUCCESS;
	}

	public PjStoreDynamicInfo getModel() {
		return this.pjStoreDynamicInfo;
	}

	public PjStoreDynamicInfoService getPjStoreDynamicInfoService() {
		return pjStoreDynamicInfoService;
	}

	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}
}
