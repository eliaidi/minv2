package com.repair.report.action.jtReport;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JtReport;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;
/**
 * 
* @ClassName: DeleteJtReportAction
* @Description: 我的报活页面删除报活按钮
* @author 删除
* @version V1.0  
* @date 2015-12-25 下午2:10:35
 */
public class DeleteJtReportAction extends BaseAction {
	private IJtReportService jtReportService;
	private  Long id; 
	@Override
	public String execute() throws Exception {
		try{
			JtReport jtReport = jtReportService.findById(id);
			if (jtReport!=null){
				jtReportService.delete(jtReport);
				writeJson(0, Constants.COMMON_MESSAGE_OPERATE_SUC);
			}
		}catch (Exception e) {
			e.printStackTrace();
			writeJson(1, Constants.COMMON_MESSAGE_OPERATE_ERROR);
		}
		
		return null;
	}
	
	
	
	
	public void setId(Long id) {
		this.id = id;
	}




	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}
}
