package com.repair.oil.action.oilAssayChildItemRec;

import java.sql.Date;
import com.repair.constant.Constants;
import com.repair.entity.OilAssayChildItem;
import com.repair.entity.OilAssayChildItemRec;
import com.repair.oil.service.IOilAssayChildItemRecService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see ajax修改油水化验子记录真实检测值
 * @author 周云韬
 * @date 2015-12-23
 * @version 1.0
 */
public class AjaxUpdateActualCheckDataAction extends BaseAction{
	//油水化验子记录ID
	private Long childRecId;
	
	private IOilAssayChildItemRecService oilAssayChildItemRecService ;
	
	//实际检测数据
	private Double actualCheckData;
	
	@Override
	public String execute() throws Exception {
		if(actualCheckData == null){
			writeJson(-1, "检测数据为空");
			return null;
		}
		OilAssayChildItemRec rec=oilAssayChildItemRecService.findById(childRecId);
		
		OilAssayChildItem item=rec.getChildItem();
		rec.setEndTime(new Date(System.currentTimeMillis()));
		rec.setAssayUsers(getLoginUsers());
		
		if(actualCheckData >= item.getMinValue()  &&  actualCheckData <= item.getMaxValue()){
			rec.setAssayStatus(Constants.OIL_ACI_REC_ASSAY_STATUS_QUALIFIED);
		}else{
			rec.setAssayStatus(Constants.OIL_ACI_REC_ASSAY_STATUS_UNQUALIFIED);
		}
		rec.setActualCheckData(actualCheckData);
		
		oilAssayChildItemRecService.update(rec);
		
		writeJson(0, Constants.COMMON_MESSAGE_OPERATE_SUC);
		return null;
	}

	public void setChildRecId(Long childRecId) {
		this.childRecId = childRecId;
	}

	public void setOilAssayChildItemRecService(
			IOilAssayChildItemRecService oilAssayChildItemRecService) {
		this.oilAssayChildItemRecService = oilAssayChildItemRecService;
	}

	public void setActualCheckData(Double actualCheckData) {
		this.actualCheckData = actualCheckData;
	}
	
	
	
	
	
}
