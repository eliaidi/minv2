package com.repair.pjFix.action.pjSDInfoRecordFix.lead;

import java.util.Iterator;
import com.repair.constant.Constants;
import com.repair.entity.PjSDIRecordFixCheck;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.pjFix.service.PjSDInfoRecordService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/**
* @ClassName: SignAllJianCeFixItemByLeadAction
* @Description: TODO 工长卡控--卡控全部检测项目
* @author 周云韬
* @version V1.0  
* @date 2015-9-29 上午10:26:57
 */
public class SignAllJianCeFixItemByLeadAction extends BaseAction{
	
	private PjSDInfoRecordService pjSDInfoRecordForPjFixService;
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	
	//用于接收动态配件记录（PjSDInfoRecord）ID
	private Long id;
	
	@Override
	public String execute() throws Exception {
		
		response.setCharacterEncoding(Constants.RESPONSE_DEFAULT_ENCODING);
		
		if(id == null ){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		UsersPrivs loginUsers=(UsersPrivs) request.getSession().getAttribute(Constants.LOGIN_USER);
		//如果用户没有登录，不进行操作
		if(loginUsers == null){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		try{
			PjSDInfoRecord record=pjSDInfoRecordForPjFixService.findPjSDInfoRecordById(id);
			Iterator<PjSDInfoRecordFix> it=record.getPjSDInfoRecordFixs().iterator();
			
			while (it.hasNext()) {
				PjSDInfoRecordFix fix=it.next();
				PjSDIRecordFixCheck fixCheck=fix.getPjSDIRecordFixCheck();
				//代表工人已签认
				if(fix.getFixUsersIds() != null){
					//代表需要卡控且是检测项目
					if(fixCheck.getLeadCheck() == Constants.PJ_SDIRF_CHECK_CHECK_STATU_ONE
							&& fix.getPjFixItem().getDefaultValue() != null){
						//修改工长签认时间和检修人
						fixCheck.setLeadCheckTime(Constants.TIME_STAMP_SYSTEM_DATE);
						fixCheck.setLeadUsers(loginUsers);
					}
				}
				//修改检修项目节点
				fix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_THREE);
				pjSDInfoRecordFixForPjFixService.updatePjSDInfoRecordFix(fix);
			}
			
			if(PjSDInfoRecordUtil.isFixFinish(record)){
				record.getPjStoreDynamicInfo().setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ONE);
				pjSDInfoRecordForPjFixService.updatePjSDInfoRecord(record);
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_SUC);
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPjSDInfoRecordForPjFixService(
			PjSDInfoRecordService pjSDInfoRecordForPjFixService) {
		this.pjSDInfoRecordForPjFixService = pjSDInfoRecordForPjFixService;
	}

	public void setPjSDInfoRecordFixForPjFixService(
			PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}

	
}
