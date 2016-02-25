package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.HashSet;
import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSu;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: AddPjStoreDynamicInfoAction
 * @Description: TODO(添加配件动态信息)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午10:05:02
 */
public class AddPjStoreDynamicInfoAction extends BaseAction implements ModelDriven<PjStoreDynamicInfo> {
	private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
	private PjStoreStaticInfoService  pjStoreStaticInfoService;
	private DictStorePositionService dictStorePositionService;
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private UsersPrivsService  usersPrivsService;
	private PjStoreStaticInfo  pjStoreStaticInfo;
	private DictStorePosition dictStorePosition;
	private PjSDInfoRecord pjSDInfoRecord;
	private String correlationUnit;
	private String correlationName;

	@Override
	public String execute() throws Exception {
		dictStorePosition  = dictStorePositionService.findById(pjStoreDynamicInfo.getDictStorePosition().getId());
		pjStoreStaticInfo = pjStoreStaticInfoService.findPjStoreStaticInfoByPjName(pjStoreDynamicInfo.getPjStoreStaticInfo().getPjName());
		
		if(pjStoreStaticInfo == null){
			session.setAttribute("message",  Constants.PJ_STATIC_NOT_IN);
			return Action.SUCCESS;
		}
		
		if(dictStorePosition !=null && pjStoreStaticInfo !=null){
			//获取关联表数据信息
			pjStoreDynamicInfo.setPjStoreStaticInfo(pjStoreStaticInfo);
			pjStoreDynamicInfo.setDictStorePosition(dictStorePosition);
			
			//给pjSDInfoRecord对象赋值ֵ
			pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ZERO);
			pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_TWO);
			pjSDInfoRecord.setRecordTime(Constants.TIME_STAMP_SYSTEM_DATE);
			pjSDInfoRecord.setPjStoreDynamicInfo(pjStoreDynamicInfo);
			pjSDInfoRecord.setRemark("测试：关于动态信息的主要记录");
			
			//添加动态信息，默人为合格状态״̬
			pjStoreDynamicInfo.setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ZERO);
			Set<PjSDInfoRecord> pjSDInfoRecords=new HashSet<PjSDInfoRecord>();
			pjSDInfoRecords.add(pjSDInfoRecord);
			pjStoreDynamicInfo.setPjSDInfoRecords(pjSDInfoRecords);
			
			//UsersPrivs usersPrivs=(UsersPrivs) ServletActionContext.getRequest().getSession().getAttribute(Constants.LOGIN_USER);
			//没有登陆当前页面，所以填入一个数字去查询，以后需要进行修改
			UsersPrivs usersPrivs = usersPrivsService.findUsersById(87);
			
			//添加子记录信息
			PjSDInfoRecordSu  pjSDInfoRecordSu  = new PjSDInfoRecordSu();
			pjSDInfoRecordSu.setUsersPrivs(usersPrivs);
			pjSDInfoRecordSu.setPjSDInfoRecord(pjSDInfoRecord);
			pjSDInfoRecordSu.setCorrelationName(correlationName);
			pjSDInfoRecordSu.setCorrelationUnit(correlationUnit);
			pjSDInfoRecordSu.setRemark("测试：关于新建动态配件时，添加的关于配件仓库和相关单位的子记录");
			
			Set<PjSDInfoRecordSu> pjSDInfoRecordSus=new HashSet<PjSDInfoRecordSu>();
			pjSDInfoRecordSus.add(pjSDInfoRecordSu);
			pjSDInfoRecord.setPjSDInfoRecordSus(pjSDInfoRecordSus);
		}
		pjStoreDynamicInfoService.save(pjStoreDynamicInfo);
		return Action.SUCCESS;
	}

	public PjStoreDynamicInfo getModel() {
		return this.pjStoreDynamicInfo;
	}


	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}

	

	public PjStoreStaticInfoService getPjStoreStaticInfoService() {
		return pjStoreStaticInfoService;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}


	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}


	public void setDictStorePosition(DictStorePosition dictStorePosition) {
		this.dictStorePosition = dictStorePosition;
	}

	public String getCorrelationUnit() {
		return correlationUnit;
	}

	public void setCorrelationUnit(String correlationUnit) {
		this.correlationUnit = correlationUnit;
	}

	public String getCorrelationName() {
		return correlationName;
	}

	public void setCorrelationName(String correlationName) {
		this.correlationName = correlationName;
	}

	public UsersPrivsService getUsersPrivsService() {
		return usersPrivsService;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public PjSDInfoRecord getPjSDInfoRecord() {
		return pjSDInfoRecord;
	}

	public void setPjSDInfoRecord(PjSDInfoRecord pjSDInfoRecord) {
		this.pjSDInfoRecord = pjSDInfoRecord;
	}
	
	
	
}
