package com.repair.pj.action.pjSDInfoRecord;

import java.util.HashSet;
import java.util.Set;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordPp;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjSDInfoRecordService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: AddStorePjSDInfoRecordSpAction
* @Description: TODO(主仓库往班组库中添加数据记录)
* @author lxb
* @version V1.0  
* @date 2015-9-10 下午7:32:47
 */
public class AddStorePjSDInfoRecordPpAction extends BaseAction implements ModelDriven<PjSDInfoRecordPp>{
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private PjSDInfoRecordService  pjSDInfoRecordService;
	private DictStorePositionService dictStorePositionService;
	private PjSDInfoRecordPp pjSDInfoRecordPp = new PjSDInfoRecordPp();
	private int dictStorePositionId;
	private int[] pjStoreDynamicInfoId;
	private String returnUrl;
	
	@Override
	public String execute() throws Exception {
		try {
			//修改动态配件中对应的配件所在位置/仓库ID
			for (int i = 0; i < pjStoreDynamicInfoId.length; i++) {
				PjStoreDynamicInfo pjStoreDynamic =	pjStoreDynamicInfoService.findById(pjStoreDynamicInfoId[i]);
				DictStorePosition storePosition =  dictStorePositionService.findById(dictStorePositionId);
				pjStoreDynamic.setDictStorePosition(storePosition);
				pjStoreDynamicInfoService.update(pjStoreDynamic);
				
				//添加动态配件主要记录表
				PjSDInfoRecord pjSDInfoRecord = new PjSDInfoRecord();
				pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ZERO);
				pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_ONE);
				pjSDInfoRecord.setRecordTime(Constants.TIME_STAMP_SYSTEM_DATE);
				pjSDInfoRecord.setRemark("关于班组库和班组库的主要记录");
				pjSDInfoRecord.setPjStoreDynamicInfo(pjStoreDynamic);
				if(Constants.STORE_UNIT_PROTEAM_STATUS_ONE == 1 ){
					Set<PjSDInfoRecordPp> pjSDInfoRecordPpSet = new HashSet<PjSDInfoRecordPp>();
					pjSDInfoRecordPp.setPjSDInfoRecord(pjSDInfoRecord);
					pjSDInfoRecordPp.setRemark("关于班组移至班组的子记录");
					pjSDInfoRecordPpSet.add(pjSDInfoRecordPp);
					pjSDInfoRecord.setPjSDInfoRecordPps(pjSDInfoRecordPpSet);
				}
				
				pjSDInfoRecordService.save(pjSDInfoRecord);
			}
			session.setAttribute("message", Constants.MOVE_STORE_POSITION_DIALOG_SUC);
		} catch (Exception e) {
			session.setAttribute("message", Constants.MOVE_STORE_POSITION_DIALOG_ERROR);
		}
		return SUCCESS;
	}



	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}

	
	public void setPjSDInfoRecordService(PjSDInfoRecordService pjSDInfoRecordService) {
		this.pjSDInfoRecordService = pjSDInfoRecordService;
	}

	

	public void setDictStorePositionId(int dictStorePositionId) {
		this.dictStorePositionId = dictStorePositionId;
	}
	
	public int[] getPjStoreDynamicInfoId() {
		return pjStoreDynamicInfoId;
	}

	public void setPjStoreDynamicInfoId(int[] pjStoreDynamicInfoId) {
		this.pjStoreDynamicInfoId = pjStoreDynamicInfoId;
	}

	public DictStorePositionService getDictStorePositionService() {
		return dictStorePositionService;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public PjSDInfoRecordPp getModel() {
		return this.pjSDInfoRecordPp;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
}
