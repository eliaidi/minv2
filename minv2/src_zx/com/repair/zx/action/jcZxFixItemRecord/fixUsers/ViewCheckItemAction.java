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
 * 检修工人进行项目签认数据的查询
 * @author think  唐鹏
 *
 */
public class ViewCheckItemAction extends BaseAction{

	private IJcZxFixItemRecordService jcZxFixItemRecordService; 
	private IJcPlanDateService jcPlanDateService;
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		List<JcZxFixItemRecord> zxFixItemRecList=jcZxFixItemRecordService.listByConditions(planDateId, getLoginUsers().getDictProteam().getId(), Constants.JC_ZX_FIX_ITEM_TYPE_JIANCHA, Constants.ROLE_TYPE_FIX_USERS);
		JcPlanDate plandDate=jcPlanDateService.findById(planDateId);
		request.setAttribute("jcZxFixItemRecordMap",JcZxFixItemRecordUtil.packageByPreinstallType(zxFixItemRecList));
		request.setAttribute("plandDate", plandDate);
		request.setAttribute("fixUsersFinishiType", Constants.JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH);
		request.setAttribute("checkItem", Constants.JC_ZX_FIX_ITEM_TYPE_JIANCHA);
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
