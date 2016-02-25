package com.repair.pj.action.pjStoreStaticInfo;

import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: FindPjStoreStaticInfoByPjNameAction
* @Description: TODO(查找静态配件名称)
* @author lxb
* @version V1.0  
* @date 2015-9-18 上午9:23:15
 */
public class FindPjStoreStaticInfoByPjNameAction extends BaseAction {
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	//配件名
	private String pjName;

	@Override
	public String execute() throws Exception {
		PjStoreStaticInfo pjStoreStaticInfo = pjStoreStaticInfoService
				.findPjStoreStaticInfoByPjName(this.pjName);
		if(pjStoreStaticInfo == null){
			response.setHeader("content-type","text/html; charset=utf-8");
			response.getWriter().write("静态配件不存在,请输入正确的静态配件！");
		}
		return null;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

}
