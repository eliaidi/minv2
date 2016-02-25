package com.repair.report.action.jtReport.fixUsers;

import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.entity.UsersPrivs;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 工人签认报活
 * @author 周云韬
 * @date 2015-12-25
 * @version 1.0
 */
public class AjaxSignReportByFixUsersAction extends BaseAction{

	//使用,分隔，例如：1,2,3
	/**报活ID*/
	private String ids;
	/**检修情况*/
	private String fixCondition;
	
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
				report.setFixUsers(loginUsers.getUserName()+"_"+loginUsers.getJobNum()+report.getFixUsers()+",");
				report.setFixCondition(fixCondition);
				report.setFixEndTime(Constants.TIME_STAMP_SYSTEM_DATE);
				
				report.setRecordStatus(Constants.JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH);
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

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}
	
	
}
