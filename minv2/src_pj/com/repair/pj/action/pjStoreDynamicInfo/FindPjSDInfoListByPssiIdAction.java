package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindPjSDInfoListByPssiIdAction
* @Description: TODO(通过配件静态信息ID查询动态配件集合)
* @author 周云韬
* @version V1.0  
* @date 2015-9-15 下午4:50:03
 */
public class FindPjSDInfoListByPssiIdAction extends BaseAction {
	
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	
	private Long pssiId;
	
	@Override
	public String execute() throws Exception {
		List<PjStoreDynamicInfo> psdiList=pjStoreDynamicInfoService.findPjSDInfoListByPssiId(this.pssiId);
		request.setAttribute("psdiList", psdiList);
		return Action.SUCCESS;
	}

	public void setPssiId(Long pssiId) {
		this.pssiId = pssiId;
	}

	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}
	
	
	
	
}
