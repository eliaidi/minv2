package com.repair.pjFix.action.pjDInfoRecord;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindPjSDInfoRecordByPjSDInfoIdAction
* @Description: TODO(查询配件检修记录，检修记录按钮事件的实现，通过动态配件Id查询数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-24 上午09:38:23
 */
public class FindPjSDInfoRecordByPjSDInfoIdAction extends BaseAction {
    
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	private long pjSDInfoId;
	
	@Override
	public String execute() throws Exception {
		
		PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoById(pjSDInfoId);
		request.setAttribute("psdi", psdi);
		
		List<PjSDInfoRecord> list=PjSDInfoRecordUtil.listPjSDInfoFixMainRecord(psdi,2);
		
		if(list.size() == 0){
			return Action.SUCCESS;
		}
		
		request.setAttribute("recordList", list);
		request.setAttribute("pjSDInfoPjdStatusMap", Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS);
		request.setAttribute("pjSDInfoPjdStypeMap", Constants.DICT_STORE_POSITION_TYPE);
		
		return Action.SUCCESS;
	}

	public void setPjSDInfoId(long pjSDInfoId) {
		this.pjSDInfoId = pjSDInfoId;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
}
