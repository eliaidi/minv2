package com.repair.zx.action.jcInformation;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.repair.entity.JcInformation;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcInformationService;
/**
 * @see 跳至选择车型页面
 * @author 方岳岳
 * @date 2015-12-17
 * @version 1.0
 */
public class ToChoiceJcInformationAction extends BaseAction {
	private IJcInformationService jcInformationService;

	@Override
	public String execute() throws Exception {
		/**查询所有机车信息*/
		List<JcInformation> listAll = jcInformationService.listAll();
		this.request.setAttribute("recList", listAll);
		return Action.SUCCESS;
	}
	
	public void setJcInformationService(IJcInformationService jcInformationService) {
		this.jcInformationService = jcInformationService;
	}
	
}
