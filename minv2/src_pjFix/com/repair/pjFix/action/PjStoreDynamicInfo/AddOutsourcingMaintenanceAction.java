package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.util.HashSet;
import java.util.Set;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSu;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjSDInfoRecordService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;

/**
* @ClassName: AddOutsourcingMaintenanceAction
* @Description: TODO(提交委外检修，添加数据)
* @author lxb
* @version V1.0  
* @date 2015-10-9 上午10:07:58
 */
public class AddOutsourcingMaintenanceAction extends ActionSupport{
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	private PjSDInfoRecordService pjSDInfoRecordForPjFixService;
	
	//跳转到当前路径
	private String returnUrl;
	//动态配件ID
	private Long pjSDInfoId;
	//相关单位<委外厂家>
	private String correlationUnit;
	
	@Override
	public String execute() throws Exception {
		try {
		    PjStoreDynamicInfo pjsdInfo = pjSDInfoForPjFixService.findPjStoreDynamicInfoById(pjSDInfoId);
			//委外检修，将pjdStatus状态改为5<委外检修状态>
		    pjsdInfo.setPjdStatus(Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FIVE);
		    pjsdInfo.setDictStorePosition(null);
		    
		    //添加一条主记录,pjSDInfoRecord
		    PjSDInfoRecord pjSDInfoRecord = new PjSDInfoRecord();
		    pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ONE);
		    pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_TWO);
		    pjSDInfoRecord.setRecordTime(Constants.TIME_STAMP_SYSTEM_DATE);
		    pjSDInfoRecord.setPjStoreDynamicInfo(pjsdInfo);
		    pjSDInfoRecord.setRemark("测试：委外检修记录主记录");
		    
		    //添加一条子记录,pjSDInfoRecordSu
		    PjSDInfoRecordSu pjSDInfoRecordSu = new PjSDInfoRecordSu();
		    pjSDInfoRecordSu.setPjSDInfoRecord(pjSDInfoRecord);
		    pjSDInfoRecordSu.setCorrelationUnit(correlationUnit);
		    pjSDInfoRecordSu.setCorrelationName("");
		    //当前登录班组人员，还未给值 ，现为null.
		    pjSDInfoRecordSu.setUsersPrivs(null);
		    pjSDInfoRecordSu.setRemark("测试：委外检修子记录");
		    
		    //Set集合
		    Set<PjSDInfoRecordSu> setPjSDInfoRecordSu = new HashSet<PjSDInfoRecordSu>();
		    setPjSDInfoRecordSu.add(pjSDInfoRecordSu);
		    pjSDInfoRecord.setPjSDInfoRecordSus(setPjSDInfoRecordSu);
		    
		    //添加主记录
		    pjsdInfo.getPjSDInfoRecords().add(pjSDInfoRecord);
		    
		    //修改动态配件信息
			pjSDInfoForPjFixService.updatePjStoreDynamicInfo(pjsdInfo);
			ServletActionContext.getRequest().getSession().setAttribute("message", Constants.PJ_O_M_FIX_SUC);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("message", "Constants.PJ_O_M_FIX_ERROR");
			
		}
	    return SUCCESS;
	}
	
	public PjStoreDynamicInfoService getPjSDInfoForPjFixService() {
		return pjSDInfoForPjFixService;
	}
	
	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
	public Long getPjSDInfoId() {
		return pjSDInfoId;
	}
	
	public void setPjSDInfoId(Long pjSDInfoId) {
		this.pjSDInfoId = pjSDInfoId;
	}
	
	public PjSDInfoRecordService getPjSDInfoRecordForPjFixService() {
		return pjSDInfoRecordForPjFixService;
	}
	
	public void setPjSDInfoRecordForPjFixService(PjSDInfoRecordService pjSDInfoRecordForPjFixService) {
		this.pjSDInfoRecordForPjFixService = pjSDInfoRecordForPjFixService;
	}
	
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getCorrelationUnit() {
		return correlationUnit;
	}
	public void setCorrelationUnit(String correlationUnit) {
		this.correlationUnit = correlationUnit;
	}
	
}
