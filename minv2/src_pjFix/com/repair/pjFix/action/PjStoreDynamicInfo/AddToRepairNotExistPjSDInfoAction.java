package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSp;
import com.repair.entity.PjSDInfoRecordSu;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjStoreStaticInfoService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pjFix.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: AddToRepairExistPjSDInfoAction
* @Description: TODO 不存在动态配件款存在的配件（添加待修配件），走下车入库检修流程，先入库主仓库，再移库班组库
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 下午6:16:11
 */
public class AddToRepairNotExistPjSDInfoAction extends BaseAction{
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	private PjStoreStaticInfoService pjSSInfoForPjFixService;
	private UsersPrivsService usersPrivsForPjFixService;
	
	
	/** 配件编号数组*/
	private String[] pjdCodes;
	/** 配件静态大类ID */
	private long[] pjStoreStaticInfoId;
	/** 配件生产厂家 */
	private String[] pjdFactory;
	/** 配件出厂日期 */
	private Date[] pjdOutFactoryDate;
	/** 配件出厂价格 */
	private Double[] pjdOutPrice;
	
	
	private UsersPrivs loginUsers;
	
	@Override
	public String execute() throws Exception {
		UsersPrivs users=getLoginUsers();
		
		if(getLoginUsers() != null){
			loginUsers=usersPrivsForPjFixService.findUsersById(users.getId());
		}
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_JSON);
		
		//如果配件编码集合为null，或者长度为0，直接退出
		if(pjdCodes == null || pjdCodes.length == 0 || pjStoreStaticInfoId == null || pjdCodes.length != pjStoreStaticInfoId.length){
			pw.write(Constants.COMMON_MESSAGE_ADD_ERROR);
			return null;
		}
		
		for (int i=0;i<pjdCodes.length;i++) {
			String factory=i <= (pjdFactory != null ? pjdFactory.length-1 :0 )? pjdFactory[i] : null;
			Date outFactoryDate=i <= (pjdOutFactoryDate != null ? pjdOutFactoryDate.length-1 :0 ) ? pjdOutFactoryDate[i] : null;
						
			Double outFactoryPrice=i <= (pjdOutPrice != null ? pjdOutPrice.length-1 : 0) ? pjdOutPrice[i] : null;
			
			//入库主仓库
			PjStoreDynamicInfo psdi=createPjStoreDynamicInfo(pjdCodes[i],factory,outFactoryDate,outFactoryPrice);
			
			if(psdi == null){
				continue;
			}
			psdi.setPjStoreStaticInfo(pjSSInfoForPjFixService.findPjStoreStaticInfoById(pjStoreStaticInfoId[i]));
			
			Set<PjSDInfoRecord> recordSet=new HashSet<PjSDInfoRecord>() ;
			//添加配件检修记录
//			recordSet.add(createPjSDInfoFixRecord(psdi));
			//添加配件入库记录
			recordSet.add(createPjSDInfoInStoreRecord(psdi));
			//添加配件移库记录
			recordSet.add(createPjSDInfoMoveStoreRecord(psdi));
			
			psdi.setPjSDInfoRecords(recordSet);
			
			pjSDInfoForPjFixService.addPjStoreDynamicInfo(psdi);
		}
		
		response.getWriter().write(Constants.COMMON_MESSAGE_ADD_SUC);
		
		return null;
	}

	
	/**
	 * 创建动态配件对象
	 * @param pjdCode：配件编号
	 * @param pjdFactory：配件生产厂家
	 * @param pjdOutFactoryDate：配件出厂日期
	 * @param pjdOutPrice：配件出厂价格
  	 * @return PjStoreDynamicInfo    
	 * @throws
	 */
	public PjStoreDynamicInfo createPjStoreDynamicInfo(String pjdCode,String pjdFactory,Date pjdOutFactoryDate,Double pjdOutPrice){
		PjStoreDynamicInfo psdi=new PjStoreDynamicInfo();
		
		if(loginUsers != null && loginUsers.getDictProteam()!=null){
			//设置动态配件所属仓库（当前登录用户所处的班组库）
			psdi.setDictStorePosition(loginUsers.getDictProteam().getDictStorePosition());
		}
		
		psdi.setPjdCode(pjdCode);
		psdi.setPjdFactory(pjdFactory);
		//默认待检修状态
		psdi.setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_TWO);
		psdi.setPjdOutFactoryDate(pjdOutFactoryDate);
		psdi.setPjdInPrice(pjdOutPrice);
		
		return psdi;
	}
	
//	/**
//	 * 创建动态配件记录（检修）
//	 * @return PjSDInfoRecord    
//	 * @throws
//	 */
//	public PjSDInfoRecord createPjSDInfoFixRecord(PjStoreDynamicInfo psdi){
//		PjSDInfoRecord pjSDInfoRecord=new PjSDInfoRecord();
//		pjSDInfoRecord.setPjStoreDynamicInfo(psdi);
//		pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ONE);
//		pjSDInfoRecord.setRecordTime(new Timestamp(System.currentTimeMillis()));
//		pjSDInfoRecord.setRemark("配件检修--主记录");
//		pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_THREE);
//		pjSDInfoRecord.setPjSDInfoRecordFixs(createPjSDInfoRecordFixSet(psdi,pjSDInfoRecord));
//		return pjSDInfoRecord;
//	}

	/**
	 * 创建动态配件新件入库记录
	 * @return PjSDInfoRecord    
	 * @throws
	 */
	public PjSDInfoRecord createPjSDInfoInStoreRecord(PjStoreDynamicInfo psdi){
		PjSDInfoRecord record=new PjSDInfoRecord();
		record.setPjStoreDynamicInfo(psdi);
		record.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ZERO);
		record.setRecordTime(new Date());
		record.setRemark("测试：配件检修--配件下车检修入库主记录");
		record.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_THREE);
		
		PjSDInfoRecordSu  pjSDInfoRecordSu=new PjSDInfoRecordSu();
		pjSDInfoRecordSu.setPjSDInfoRecord(record);
		pjSDInfoRecordSu.setRemark("测试：配件检修--配件下车检修入库子记录");
		
		Set<PjSDInfoRecordSu> set=new HashSet<PjSDInfoRecordSu>();
		set.add(pjSDInfoRecordSu);
		
		record.setPjSDInfoRecordSus(set);
		
		return record;
	}
	
	/**
	 * 创建动态配件移库记录
	 * @return PjSDInfoRecord    
	 * @throws
	 */
	public PjSDInfoRecord createPjSDInfoMoveStoreRecord(PjStoreDynamicInfo psdi){
		PjSDInfoRecord record=new PjSDInfoRecord();
		record.setPjStoreDynamicInfo(psdi);
		
		record.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ONE);
		record.setRecordTime(new Date());
		record.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_THREE);
		record.setRemark("测试：配件检修--配件下车检修移库主记录");
		
		PjSDInfoRecordSp recordSp=new PjSDInfoRecordSp();
		recordSp.setPjSDInfoRecord(record);
		
		recordSp.setProteamUsers(loginUsers);
		recordSp.setRemark("测试：配件检修--配件下车检修移库子记录");
		
		Set<PjSDInfoRecordSp> set=new HashSet<PjSDInfoRecordSp>();
		set.add(recordSp);
		record.setPjSDInfoRecordSps(set);
		
		return record;
	}
	
	/**
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
//			if(loginUsers != null){
//				recordFix.setDictProteam(loginUsers.getDictProteam());
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

	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setPjdCodes(String[] pjdCodes) {
		this.pjdCodes = pjdCodes;
	}

	public void setPjStoreStaticInfoId(long[] pjStoreStaticInfoId) {
		this.pjStoreStaticInfoId = pjStoreStaticInfoId;
	}

	public void setPjSSInfoForPjFixService(
			PjStoreStaticInfoService pjSSInfoForPjFixService) {
		this.pjSSInfoForPjFixService = pjSSInfoForPjFixService;
	}

	public void setPjdFactory(String[] pjdFactory) {
		this.pjdFactory = pjdFactory;
	}

	

	public void setPjdOutFactoryDate(Date[] pjdOutFactoryDate) {
		this.pjdOutFactoryDate = pjdOutFactoryDate;
	}


	public void setPjdOutPrice(Double[] pjdOutPrice) {
		this.pjdOutPrice = pjdOutPrice;
	}

	public void setUsersPrivsForPjFixService(
			UsersPrivsService usersPrivsForPjFixService) {
		this.usersPrivsForPjFixService = usersPrivsForPjFixService;
	}

}
