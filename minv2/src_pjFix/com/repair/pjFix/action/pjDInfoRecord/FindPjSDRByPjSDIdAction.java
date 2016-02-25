package com.repair.pjFix.action.pjDInfoRecord;

import com.opensymphony.xwork2.Action;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindPjSDRByPjSDIdAction
* @Description: TODO(检修记录详情，查询子配件，通过动态配件Id查询子配件)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-24 下午03:59:25
 */
public class FindPjSDRByPjSDIdAction  extends BaseAction {
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	private long pjSDInfoId;//配件动态id
	
	@Override
	public String execute() throws Exception {
		
		PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoById(pjSDInfoId);
		
		request.setAttribute("psdi", psdi);
		
		return Action.SUCCESS;
	}

	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setPjSDInfoId(long pjSDInfoId) {
		this.pjSDInfoId = pjSDInfoId;
	}

	public long getPjSDInfoId() {
		return pjSDInfoId;
	}

}
