package com.repair.report.action.jtReport.technician;

import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.pojoUtil.JtReportUtil;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 质检员身份列出  指定日计划所有报活记录
 * @author 周云韬
 * @date 2015-12-28
 * @version 1.0
 */
public class ListReportByTechnicianAction extends BaseAction{

	private IJtReportService jtReportService;
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		List<JtReport> reportList=jtReportService.listReport(planDateId,Constants.ROLE_TYPE_TECHNICIAN);
		request.setAttribute("jtReportMap", JtReportUtil.packageByProteam(reportList));
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		request.setAttribute("leadCheckFlag", Constants.JT_REPORT_RECORD_STATUS_LEAD_CHECK);
		request.setAttribute("reportType", Constants.JT_REPORT_TYPE);
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		request.setAttribute("technicianCheckFlag", Constants.JT_REPORT_RECORD_STATUS_QC_OR_TECH_CHECK);
		return SUCCESS;
	}


	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}


	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	
	
}
