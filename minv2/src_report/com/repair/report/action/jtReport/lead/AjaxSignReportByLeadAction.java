package com.repair.report.action.jtReport.lead;

import java.util.Date;
import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.entity.UsersPrivs;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 工长签认报活
 * @author 周云韬
 * @date 2015-12-28
 * @version 1.0
 */
public class AjaxSignReportByLeadAction extends BaseAction{

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
				
				if(Constants.JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH.equals(report.getRecordStatus())){
					report.setLeadUsers(loginUsers);
					report.setLeadUsersCheckTime(new Date(System.currentTimeMillis()));
					report.setRecordStatus(Constants.JT_REPORT_RECORD_STATUS_LEAD_CHECK);
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

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}
	
	
	
	
}
