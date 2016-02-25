package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.PjFixItem;
import com.repair.entity.PjSDIRecordFixCheck;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjStoreDynamicInfoService;

/**
* @ClassName: SureFixPjStoreDynamicInfoAction
* @Description: TODO(点击选择检修，改变配件检修状态)
* @author 唐鹏
* @version V1.0  
* @date 2015-10-8 下午02:58:02
 */
public class SureFixPjStoreDynamicInfoAction extends ActionSupport{
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	private long id;
	
	private String returnUrl;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoById(id);
		if(psdi == null ){
			request.setAttribute(Constants.PROMPT_MESSAGE_ATTRIBUTE_NAME, Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return SUCCESS;
		}
		try{
			psdi.setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FOUR);
			psdi.getPjSDInfoRecords().add(createPjSDInfoRecord(psdi));
			pjSDInfoForPjFixService.updatePjStoreDynamicInfo(psdi);
		}catch (Exception e) {
			request.setAttribute(Constants.PROMPT_MESSAGE_ATTRIBUTE_NAME, Constants.COMMON_MESSAGE_OPERATE_SUC);
			e.printStackTrace();
		}
		
		return Action.SUCCESS;
	}

	/**
	 * 创建动态配件记录
	 * @return PjSDInfoRecord    
	 * @throws
	 */
	public PjSDInfoRecord createPjSDInfoRecord(PjStoreDynamicInfo psdi){
		PjSDInfoRecord pjSDInfoRecord=new PjSDInfoRecord();
		pjSDInfoRecord.setPjStoreDynamicInfo(psdi);
		pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ONE);
		pjSDInfoRecord.setRecordTime(new Timestamp(System.currentTimeMillis()));
		pjSDInfoRecord.setRemark("测试：配件检修--主记录");
		pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_THREE);
		pjSDInfoRecord.setPjSDInfoRecordFixs(createPjSDInfoRecordFixSet(psdi,pjSDInfoRecord));
		return pjSDInfoRecord;
	}

	/**
  	 * 创建配件检修记录集合
  	 * @param  psdi				动态配件
  	 * @param  record			动态配件记录
	 * @return Set<PjSDInfoRecordFix>    配件检修记录集合
	 * 
	 * @throws 
	 */
	public Set<PjSDInfoRecordFix> createPjSDInfoRecordFixSet(PjStoreDynamicInfo psdi,PjSDInfoRecord record){
		Set<PjSDInfoRecordFix> recordFixSet=new HashSet<PjSDInfoRecordFix>();
		
		if(psdi == null || psdi.getPjStoreStaticInfo() == null){
			return null;
		}
		//通过动态配件获取需检修项目集合
		Set<PjFixItem> fixItemList=psdi.getPjStoreStaticInfo().getPjFixItems();
		
		//有多少条检修项目就添加多少检修记录
		for (PjFixItem pjFixItem : fixItemList) {
			PjSDInfoRecordFix recordFix=new PjSDInfoRecordFix();
			recordFix.setPjSDInfoRecord(record);
			recordFix.setFixItemStatus(Constants.PJ_SDI_RECORD_FIX_FIX_ITEM_STATUS_ENABLE);
			
			//检修班组为当前登录用户所属班组
			UsersPrivs users=(UsersPrivs)ServletActionContext.getRequest().getSession().getAttribute(Constants.LOGIN_USER);
			if(users != null){
				recordFix.setDictProteam(users.getDictProteam());
			}
			
			recordFix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_FIRST);
			recordFix.setPjFixItem(pjFixItem);
			
			PjSDIRecordFixCheck fixCheck=createPjSDIRecordFixCheck(recordFix, pjFixItem);
			recordFix.setPjSDIRecordFixCheck(fixCheck);
			
			recordFixSet.add(recordFix);
		}
		
		return recordFixSet;
	}
	
	/**
	 * 创建配件检修记录卡控信息
	 * @param  recordFix		配件检修记录
	 * @param  fixItem			配件检修项目
	 * @return PjSDIRecordFixCheck    配件检修记录卡控信息
	 * @throws
	 */
	public PjSDIRecordFixCheck createPjSDIRecordFixCheck(PjSDInfoRecordFix recordFix,PjFixItem fixItem){
		PjSDIRecordFixCheck recordFixCheck=new PjSDIRecordFixCheck();
		recordFixCheck.setPjSDInfoRecordFix(recordFix);
		
		recordFixCheck.setLeadCheck(fixItem.getLeadCheck());
		recordFixCheck.setCommitLeadCheck(fixItem.getCommitLeadCheck());
		recordFixCheck.setTechnicianCheck(fixItem.getTechnicianCheck());
		recordFixCheck.setAcceptanceCheck(fixItem.getAcceptanceCheck());
		recordFixCheck.setQcCheck(fixItem.getAcceptanceCheck());
		recordFixCheck.setTwoInspectionCheck(fixItem.getTwoInspectionCheck());
		
		return recordFixCheck;
	}
	
	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}
	
}
