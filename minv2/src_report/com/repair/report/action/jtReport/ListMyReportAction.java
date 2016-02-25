package com.repair.report.action.jtReport;

import java.util.List;

import oracle.net.aso.r;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 查询 指定机车日计划、指定用户ID 的报活记录
 * @author 唐鹏
 * @date 2015年12月25日
 * @version 1.0
 */
public class ListMyReportAction extends BaseAction{

	private IJtReportService jtReportService;
	private Long planDateId;
	
	@Override
	public String execute() throws Exception {
		List<JtReport> jtReportList=jtReportService.listMyReport(planDateId, getLoginUsers().getId());
		request.setAttribute("jtReportList", jtReportList);
		request.setAttribute("reportType", Constants.JT_REPORT_TYPE);
		
		return Action.SUCCESS;
	}

	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	
	
}
