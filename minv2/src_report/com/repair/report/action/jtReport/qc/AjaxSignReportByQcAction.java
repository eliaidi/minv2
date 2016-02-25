package com.repair.report.action.jtReport.qc;

import java.util.Date;

import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.entity.UsersPrivs;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 质检员签认报活
 * @author 周云韬
 * @date 2015-12-28
 * @version 1.0
 */
public class AjaxSignReportByQcAction extends BaseAction{

	//使用,分隔，例如：1,2,3
	private String ids;
	
	private IJtReportService jtReportService;
	
	@Override
	public String execute() throws Exception {
		if(getLoginUsers() == null){
			writeJson(-1, "请先登录");
			return null;
		}
		if(ids == null || ids.split(",").length == 0){
			writeJson(0, Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		try{
			String[] idArr=ids.split(",");
			for (String string : idArr) {
				Long id=Long.parseLong(string);
				JtReport report=jtReportService.findById(id);
				UsersPrivs loginUsers=getLoginUsers();
				
				if(isNeedSign(report)){
					report.setQcUsers(getLoginUsers());
					report.setQcCheckTime(new Date(System.currentTimeMillis()));
					report.setRecordStatus(Constants.JT_REPORT_RECORD_STATUS_QC_OR_TECH_CHECK);
				}
				
				jtReportService.update(report);
			}
			
			writeJson(0, Constants.COMMON_MESSAGE_OPERATE_SUC);
		}catch(Exception e){
			e.printStackTrace();
			writeJson(1, Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		
		return null;
	}

	/**
	 * 是否需要签认
	 * @param report	报活记录
	 * @return
	 */
	public boolean isNeedSign(JtReport report){
		if(report == null){
			return false;
		}
		if(report.getFixUsers() == null && report.getFixEndTime() == null){
			return false;
		}
		if(report.getLeadCheck() == Constants.CHECK_STATUS_NEED_CHECK && report.getLeadUsers() == null){
			return false;
		}
		if(report.getCommitLeadCheck() == Constants.CHECK_STATUS_NEED_CHECK && report.getCommitLeadUsers() == null){
			return false;
		}
		if(report.getQcCheck() == Constants.CHECK_STATUS_NOT_CHECK){
			return false;
		}
		return true;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}
	
	
	
	
}
