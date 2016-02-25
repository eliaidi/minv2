package com.repair.zx.action.jcZxFixItemRecord.fixUsers;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.pojoUtil.JcZxFixItemRecordUtil;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;
import com.repair.zx.service.IJcZxFixItemRecordService;

/**
 * 工人检测项目数据显示
 * @author think 唐鹏
 *
 */
public class ViewDetectionItemAction extends BaseAction{

	private IJcZxFixItemRecordService jcZxFixItemRecordService; 
	private IJcPlanDateService jcPlanDateService;
	private Long planDateId;
	@Override
	public String execute() throws Exception {
		List<JcZxFixItemRecord> zxFixItemRecList=jcZxFixItemRecordService.listByConditions(planDateId, getLoginUsers().getDictProteam().getId(), Constants.JC_ZX_FIX_ITEM_TYPE_JIANCE, Constants.ROLE_TYPE_FIX_USERS);
		JcPlanDate plandDate=jcPlanDateService.findById(planDateId);
		request.setAttribute("jcZxFixItemRecordMap",JcZxFixItemRecordUtil.packageByPreinstallType(zxFixItemRecList));
		request.setAttribute("plandDate", plandDate);
		request.setAttribute("detectionItem", Constants.JC_ZX_FIX_ITEM_TYPE_JIANCE);
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		return Action.SUCCESS;
	}

	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}
	
}
