package com.repair.oil.action.oilAssayMainItemRec;

import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.OilAssayMainItemRec;
import com.repair.oil.service.IOilAssayMainItemRecService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 修改油水化验主记录
 * @author 周云韬
 * @date 2015-12-23
 * @version 1.0
 */
public class UpdateOilAMIRecAction extends BaseAction implements ModelDriven<OilAssayMainItemRec>{

	private OilAssayMainItemRec mainItemRec=new OilAssayMainItemRec();
	
	private IOilAssayMainItemRecService oilAssayMainItemRecService;
	
	@Override
	public String execute() throws Exception {
	
		
		OilAssayMainItemRec rec=oilAssayMainItemRecService.findById(mainItemRec.getId());

		rec.setReceiveTime(mainItemRec.getReceiveTime());
		rec.setEndTime(mainItemRec.getEndTime());
		rec.setSendUsers(mainItemRec.getSendUsers());
		rec.setReceiveUsers(getLoginUsers());
		rec.setQualityStatus(mainItemRec.getQualityStatus());
		rec.setConditionStatus(mainItemRec.getConditionStatus());
		
		oilAssayMainItemRecService.update(rec);
		
		return SUCCESS;
	}

	public OilAssayMainItemRec getModel() {
		return this.mainItemRec;
	}

	public void setOilAssayMainItemRecService(
			IOilAssayMainItemRecService oilAssayMainItemRecService) {
		this.oilAssayMainItemRecService = oilAssayMainItemRecService;
	}
	
	
	
}
