package com.repair.pjFix.action.pjSDInfoRecordFix.fixUsers;

import com.repair.entity.PjSDInfoRecordFix;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: UpdatePjSDInfoRecordFixAction
* @Description: TODO(检修记录是否启用-修改动态配件信息记录，通过id)
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
	
	public void setPjSDInfoRecordFixForPjFixService(
			PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}
	
	public void setPjSDInfoRecordFixId(int pjSDInfoRecordFixId) {
		this.pjSDInfoRecordFixId = pjSDInfoRecordFixId;
	}
	
	public void setFixItemStatus(int fixItemStatus) {
		this.fixItemStatus = fixItemStatus;
	}
	
}
