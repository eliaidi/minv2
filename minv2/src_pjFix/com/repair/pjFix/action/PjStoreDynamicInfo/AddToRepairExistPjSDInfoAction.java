package com.repair.pjFix.action.pjStoreDynamicInfo;

import com.repair.constant.Constants;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: AddToRepairExistPjSDInfoAction
* @Description: TODO 已经在动态配件款存在的配件（添加待修配件）
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 下午6:16:11
 */
public class AddToRepairExistPjSDInfoAction extends BaseAction{
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	/** 配件编号数组*/
	private String[] pjdCodes;
	
	@Override
	public String execute() throws Exception {
		response.setCharacterEncoding(Constants.RESPONSE_DEFAULT_ENCODING);
		
		//如果配件编码集合为null，或者长度为0，直接退出
		if(pjdCodes == null || pjdCodes.length == 0){
			response.getWriter().write(Constants.COMMON_MESSAGE_OPERATE_ERROR);
			return null;
		}
		
		for (int i=0;i<pjdCodes.length;i++) {
			PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoByPjdCode(pjdCodes[i]);
			//动态配件库中不存在，或已经是待修配件了
			if(psdi == null || psdi.getPjdStatus() == Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_THREE){
				continue;
			}
			psdi.setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_TWO);
//			Set<PjSDInfoRecord> recordSet=psdi.getPjSDInfoRecords() == null ? new HashSet<PjSDInfoRecord>() : psdi.getPjSDInfoRecords();
//			recordSet.add(createPjSDInfoRecord(psdi));
//			psdi.setPjSDInfoRecords(recordSet);
			
			pjSDInfoForPjFixService.updatePjStoreDynamicInfo(psdi);
		}
		
		pw.write(Constants.COMMON_MESSAGE_OPERATE_SUC);
		return null;
	}
	
//	/**
//	 * 创建动态配件记录
//	 * @return PjSDInfoRecord    
//	 * @throws
//	 */
//	public PjSDInfoRecord createPjSDInfoRecord(PjStoreDynamicInfo psdi){
//		PjSDInfoRecord pjSDInfoRecord=new PjSDInfoRecord();
//		pjSDInfoRecord.setPjStoreDynamicInfo(psdi);
//		pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ONE);
//		pjSDInfoRecord.setRecordTime(new Timestamp(System.currentTimeMillis()));
//		pjSDInfoRecord.setRemark("配件检修--主记录");
//		pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_THREE);
//		pjSDInfoRecord.setPjSDInfoRecordFixs(createPjSDInfoRecordFixSet(psdi,pjSDInfoRecord));
//		return pjSDInfoRecord;
//	}
//
//	/**
//  	 * 创建配件检修记录集合
//  	 * @param  psdi				动态配件
//  	 * @param  record			动态配件记录
//	 * @return Set<PjSDInfoRecordFix>    配件检修记录集合
//	 * 
//	 * @throws 
//	 */
//	public Set<PjSDInfoRecordFix> createPjSDInfoRecordFixSet(PjStoreDynamicInfo psdi,PjSDInfoRecord record){
//		Set<PjSDInfoRecordFix> recordFixSet=new HashSet<PjSDInfoRecordFix>();
//		
//		if(psdi == null || psdi.getPjStoreStaticInfo() == null){
//			return null;
//		}
//		//通过动态配件获取需检修项目集合
//		Set<PjFixItem> fixItemList=psdi.getPjStoreStaticInfo().getPjFixItems();
//		
//		//有多少条检修项目就添加多少检修记录
//		for (PjFixItem pjFixItem : fixItemList) {
//			PjSDInfoRecordFix recordFix=new PjSDInfoRecordFix();
//			recordFix.setPjSDInfoRecord(record);
//			
//			//检修班组为当前登录用户所属班组
//			UsersPrivs users=(UsersPrivs)ServletActionContext.getRequest().getSession().getAttribute(Constants.LOGIN_USER);
//			if(users != null){
//				recordFix.setDictProteam(users.getDictProteam());
//			}
//			
//			recordFix.setFixCheckNode(Constants.PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_FIRST);
//			recordFix.setPjFixItem(pjFixItem);
//			
//			PjSDIRecordFixCheck fixCheck=createPjSDIRecordFixCheck(recordFix, pjFixItem);
//			recordFix.setPjSDIRecordFixCheck(fixCheck);
//			
//			recordFixSet.add(recordFix);
//		}
//		
//		return recordFixSet;
//	}
//	
//	/**
//	 * 创建配件检修记录卡控信息
//	 * @param  recordFix		配件检修记录
//	 * @param  fixItem			配件检修项目
//	 * @return PjSDIRecordFixCheck    配件检修记录卡控信息
//	 * @throws
//	 */
//	public PjSDIRecordFixCheck createPjSDIRecordFixCheck(PjSDInfoRecordFix recordFix,PjFixItem fixItem){
//		PjSDIRecordFixCheck recordFixCheck=new PjSDIRecordFixCheck();
//		recordFixCheck.setPjSDInfoRecordFix(recordFix);
//		
//		recordFixCheck.setLeadCheck(fixItem.getLeadCheck());
//		recordFixCheck.setCommitLeadCheck(fixItem.getCommitLeadCheck());
//		recordFixCheck.setTechnicianCheck(fixItem.getTechnicianCheck());
//		recordFixCheck.setAcceptanceCheck(fixItem.getAcceptanceCheck());
//		recordFixCheck.setQcCheck(fixItem.getAcceptanceCheck());
//		recordFixCheck.setTwoInspectionCheck(fixItem.getTwoInspectionCheck());
//		
//		return recordFixCheck;
//	}
//	
//	

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setPjdCodes(String[] pjdCodes) {
		this.pjdCodes = pjdCodes;
	}
	
}
