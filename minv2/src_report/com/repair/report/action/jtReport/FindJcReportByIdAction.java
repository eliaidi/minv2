package com.repair.report.action.jtReport;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 通过报活Id查询修改之前的数据
 * @see 
 * @author 唐鹏
 * @date 2015年12月25日
 * @version 1.0
 */
public class FindJcReportByIdAction extends BaseAction{
	
	private IJtReportService jtReportService;
	private Long jtReportId;
	
	@Override
	public String execute() throws Exception {
		JtReport jtReport=jtReportService.findById(jtReportId);
		request.setAttribute("jtReport", jtReport);
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		request.setAttribute("recordStatusMap", Constants.JT_REPORT_RECORD_STATUS);
		return Action.SUCCESS;
	}
	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}
	public void setJtReportId(Long jtReportId) {
		this.jtReportId = jtReportId;
	}

	
}
