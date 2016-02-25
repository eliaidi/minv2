package com.repair.report.action.jtReport.fixUsers;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 工人身份  列出日计划的指定班组的报活记录
 * @author 周云韬
 * @date 2015-12-25
 * @version 1.0
 */
public class ListReportByFixUsersAction extends BaseAction{

	private IJtReportService jtReportService;
	/**计划ID*/
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		Long proteamId=getLoginUsers().getDictProteam().getId();
		List<JtReport> reportList=jtReportService.listReport(planDateId,proteamId,Constants.ROLE_TYPE_FIX_USERS);
		request.setAttribute("jtReportList", reportList);
		request.setAttribute("fixUsersFinishiType", Constants.JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH);
		request.setAttribute("reportType", Constants.JT_REPORT_TYPE);
		return SUCCESS;
	}


	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}


	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}



	
}
