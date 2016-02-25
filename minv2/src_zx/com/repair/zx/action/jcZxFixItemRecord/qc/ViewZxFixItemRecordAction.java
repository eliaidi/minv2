package com.repair.zx.action.jcZxFixItemRecord.qc;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.JcPlanDate;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.pojoUtil.JcZxFixItemRecordUtil;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcPlanDateService;
import com.repair.zx.service.IJcZxFixItemRecordService;

/**
 * 
 * @see 中修项目签认
 * @author 周云韬
 * @date 2016-1-8
 * @version 1.0
 */
public class ViewZxFixItemRecordAction extends BaseAction {

	private IJcZxFixItemRecordService jcZxFixItemRecordService; 
	private IJcPlanDateService jcPlanDateService;
	private Long planDateId;
	
	//排序类型
	private Integer sortType;
	
	@Override
	public String execute() throws Exception {
		List<JcZxFixItemRecord> recordList=jcZxFixItemRecordService.listByConditions(planDateId, null, null, Constants.ROLE_TYPE_QC);
		JcPlanDate plandDate=jcPlanDateService.findById(planDateId);
		request.setAttribute("planDate", plandDate);
		request.setAttribute("needCheck", Constants.CHECK_STATUS_NEED_CHECK);
		
		if(sortType == null || sortType == 0){
			request.setAttribute("zxFixItemRecMap", JcZxFixItemRecordUtil.packageByProteam(recordList));
		}else{
			request.setAttribute("zxFixItemRecMap", JcZxFixItemRecordUtil.packageByFirstUnit(recordList));
		}
		
		return Action.SUCCESS;
	}

	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}

	
	
}
