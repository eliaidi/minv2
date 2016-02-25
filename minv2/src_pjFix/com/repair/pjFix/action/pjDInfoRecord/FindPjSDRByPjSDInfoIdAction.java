package com.repair.pjFix.action.pjDInfoRecord;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.pjFix.service.PjSDInfoRecordService;
import com.repair.util.action.BaseAction;
/**
* @ClassName: FindPjSDRByPjSDInfoIdAction
* @Description: TODO(查询配件检修记录,通过配件仓库动态信息记录编Id,查看详情)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-24 下午06:28:40
 */
public class FindPjSDRByPjSDInfoIdAction extends BaseAction {
    
	private PjSDInfoRecordService pjSDInfoRecordForPjFixService;
	
	private long pjSDInfoRecordId;
	
	@Override
	public String execute() throws Exception {

		PjSDInfoRecord pjSDR=pjSDInfoRecordForPjFixService.findPjSDInfoRecordById(pjSDInfoRecordId);
		pjSDR.getPjSDInfoRecordFixs();
		request.setAttribute("pjSDR", pjSDR);
		
		request.setAttribute("pjSDInfoPjdStatusMap", Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS);
		request.setAttribute("pjSDInfoPjdStypeMap", Constants.DICT_STORE_POSITION_TYPE);
		
		return Action.SUCCESS;
	}

	public void setPjSDInfoRecordForPjFixService(
			PjSDInfoRecordService pjSDInfoRecordForPjFixService) {
		this.pjSDInfoRecordForPjFixService = pjSDInfoRecordForPjFixService;
	}

	public void setPjSDInfoRecordId(long pjSDInfoRecordId) {
		this.pjSDInfoRecordId = pjSDInfoRecordId;
	}

}
