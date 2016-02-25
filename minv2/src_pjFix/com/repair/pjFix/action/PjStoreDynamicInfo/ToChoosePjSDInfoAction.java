package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjStoreDynamicInfoService;

/**
 * 
 * @ClassName: ToChoosePjSDInfoAction
 * @Description: TODO 跳至配件大类--添加待修配件--选择（按钮）--选中动态配件对话框
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-31 上午10:00:25
 */
public class ToChoosePjSDInfoAction  extends ActionSupport{

	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	private long pjSStInfoId;
	
	@Override
	public String execute() throws Exception {
		//配件状态数组
		long [] pjdStatusArr=new long[]{Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ZERO,Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ONE,
										Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_SIX};
		//查询，获得动态配件集合
		List<PjStoreDynamicInfo> pjSDInfo=pjSDInfoForPjFixService.findPjSDInfoListByPssiIdAndPjdStatusArr(pjSStInfoId, pjdStatusArr);
		ServletActionContext.getRequest().setAttribute("pjSDInfos",pjSDInfo);
		
		return Action.SUCCESS;
	}
	
	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setPjSStInfoId(long pjSStInfoId) {
		this.pjSStInfoId = pjSStInfoId;
	}

}
