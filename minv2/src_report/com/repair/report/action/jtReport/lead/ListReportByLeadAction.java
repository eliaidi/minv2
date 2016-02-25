package com.repair.report.action.jtReport.lead;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 工长身份列出  指定日计划和当前工长所在班组的报活记录
 * @author 周云韬
 * @date 2015-12-28
 * @version 1.0
 */
public class ListReportByLeadAction extends BaseAction{

	private IJtReportService jtReportService;
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		Long proteamId=getLoginUsers().getDictProteam().getId();
		List<JtReport> reportList=jtReportService.listReport(planDateId,proteamId,Constants.ROLE_TYPE_LEAD);
		request.setAttribute("jtReportList", reportList);
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		request.setAttribute("fixUsersCheckFlag", Constants.JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH);
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
