package com.repair.pjFix.action.pjSDInfoRecordFix.lead;

import com.repair.entity.PjSDInfoRecordFix;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: UpdatePjSDInfoRecordFixAction
* @Description: TODO(工长检测项目  是否启用ajax  ,检修记录是否启用)
* @author lxb
* @version V1.0  
* @date 2015-10-9 下午10:45:05
 */
public class UpdatePjSDInfoRecordFixAction extends BaseAction{
	
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	
	//配件检修ID
	private int pjSDInfoRecordFixId;
	//是否启用
	private int fixItemStatus;
	
	@Override
	public String execute() throws Exception {
		PjSDInfoRecordFix pjSDInfoRecordFix = pjSDInfoRecordFixForPjFixService.findPjSDInfoRecordFixById(pjSDInfoRecordFixId);
		pjSDInfoRecordFix.setFixItemStatus(fixItemStatus);
		pjSDInfoRecordFixForPjFixService.updatePjSDInfoRecordFix(pjSDInfoRecordFix);
		return null;
	}
	
	public PjSDInfoRecordFixService getPjSDInfoRecordFixForPjFixService() {
		return pjSDInfoRecordFixForPjFixService;
	}
	
	public void setPjSDInfoRecordFixForPjFixService(PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}
	
	public int getPjSDInfoRecordFixId() {
		return pjSDInfoRecordFixId;
	}
	
	public void setPjSDInfoRecordFixId(int pjSDInfoRecordFixId) {
		this.pjSDInfoRecordFixId = pjSDInfoRecordFixId;
	}
	
	public int getFixItemStatus() {
		return fixItemStatus;
	}
	
	public void setFixItemStatus(int fixItemStatus) {
		this.fixItemStatus = fixItemStatus;
	}
	
}
