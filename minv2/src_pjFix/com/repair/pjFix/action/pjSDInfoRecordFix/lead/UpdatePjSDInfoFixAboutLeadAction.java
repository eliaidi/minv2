package com.repair.pjFix.action.pjSDInfoRecordFix.lead;

import java.util.Iterator;
import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.PjSDIRecordFixCheck;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;
/**
* @ClassName: UpdatePjSDInfoFixAboutLeadAction
* @Description: TODO(签认工长，检查项目)
* @author lxb
* @version V1.0  
* @date 2015-10-15 上午10:13:17
 */
public class UpdatePjSDInfoFixAboutLeadAction extends BaseAction{
	
	private PjStoreDynamicInfoService pjStoreDynamicInfoForPjFixService;
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	
	/**动态信息ID*/
	private String psdiId;
	
	@Override
	public String execute() throws Exception {
		PjSDIRecordFixCheck pjSDIRecordFixCheck = new PjSDIRecordFixCheck();
		PjSDInfoRecordFix pjSDInfoRecordFix = new PjSDInfoRecordFix();
		PjStoreDynamicInfo psdi=pjStoreDynamicInfoForPjFixService.findPjStoreDynamicInfoById(Long.parseLong(psdiId));
		List<PjSDInfoRecord> list = PjSDInfoRecordUtil.listPjSDInfoFixMainRecord(psdi, 1);
		
		Iterator ite = list.get(0).getPjSDInfoRecordFixs().iterator();
		UsersPrivs loginUser = (UsersPrivs)request.getSession().getAttribute(Constants.LOGIN_USER);
		
		while(ite.hasNext()){
			pjSDInfoRecordFix =  (PjSDInfoRecordFix)ite.next();
		    pjSDIRecordFixCheck = pjSDInfoRecordFix.getPjSDIRecordFixCheck();
			pjSDIRecordFixCheck.setLeadCheckTime(Constants.TIME_STAMP_SYSTEM_DATE);
			pjSDIRecordFixCheck.setLeadUsers(loginUser);
			pjSDInfoRecordFix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_THREE);
			pjSDInfoRecordFix.setPjSDIRecordFixCheck(pjSDIRecordFixCheck);
			pjSDInfoRecordFixForPjFixService.updatePjSDInfoRecordFix(pjSDInfoRecordFix);
		}
		return SUCCESS;
	}
	
	public String getPsdiId() {
		return psdiId;
	}
	
	public void setPsdiId(String psdiId) {
		this.psdiId = psdiId;
	}
	
	public PjStoreDynamicInfoService getPjStoreDynamicInfoForPjFixService() {
		return pjStoreDynamicInfoForPjFixService;
	}
	
	public void setPjStoreDynamicInfoForPjFixService(
			PjStoreDynamicInfoService pjStoreDynamicInfoForPjFixService) {
		this.pjStoreDynamicInfoForPjFixService = pjStoreDynamicInfoForPjFixService;
	}
	
	public PjSDInfoRecordFixService getPjSDInfoRecordFixForPjFixService() {
		return pjSDInfoRecordFixForPjFixService;
	}
	
	public void setPjSDInfoRecordFixForPjFixService(PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}
	
}
