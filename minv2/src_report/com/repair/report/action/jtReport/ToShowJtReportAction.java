package com.repair.report.action.jtReport;

import com.google.gxp.compiler.base.Concatenation;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;
/**
 * 
* @ClassName: SelectJtReportAction
* @Description: 通过Id查询详细的报活信息
* @author 方岳
* @version V1.0  
* @date 2015-12-25 上午10:49:48
 */
public class ToShowJtReportAction extends BaseAction {
	private IJtReportService jtReportService;
	private Long id;
	@Override
	public String execute() throws Exception {
		JtReport jtReport = jtReportService.findById(id);
		this.request.setAttribute("jtReport", jtReport);
		
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		request.setAttribute("recordStatusMap", Constants.JT_REPORT_RECORD_STATUS);
		request.setAttribute("reportType", Constants.JT_REPORT_TYPE);
		return Action.SUCCESS;
	}
	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
