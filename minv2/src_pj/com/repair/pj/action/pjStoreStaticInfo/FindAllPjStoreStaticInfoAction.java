package com.repair.pj.action.pjStoreStaticInfo;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: FindAllPjStoreStaticInfoAction
* @Description: TODO(实现findAllPjStoreStaticInfo方法，查询数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-8 上午10:20:39
 */
public class FindAllPjStoreStaticInfoAction extends BaseAction implements
		ModelDriven<PjStoreStaticInfo> {

	private PjStoreStaticInfo pjStoreStaticInfo = new PjStoreStaticInfo();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
   
	@Override
	public String execute() throws Exception {
		//查询所有静态配件
		List<PjStoreStaticInfo> list=pjStoreStaticInfoService.listAll();
		request.setAttribute("pjStoreStaticInfo", list);
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
