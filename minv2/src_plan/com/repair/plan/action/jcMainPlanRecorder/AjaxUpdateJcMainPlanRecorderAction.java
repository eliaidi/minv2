package com.repair.plan.action.jcMainPlanRecorder;


import com.repair.constant.Constants;
import com.repair.entity.DictJcFixMileage;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.service.IDictJcFixMileageService;
import com.repair.plan.service.IJcMainPlanRecorderService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see ajax修改 计划详情各字段
 * @author 周云韬
 * @date 2015-11-15
 * @version 1.0
 */
public class AjaxUpdateJcMainPlanRecorderAction extends BaseAction{
	
	private IJcMainPlanRecorderService jcMainPlanRecorderService;
	
	private IDictJcFixMileageService dictJCFixMileageService;
	
	private Long planRecorderId;
	
	private String fieldName;
	
	private String fieldValue;
	
	@Override
	public String execute() throws Exception {
		if(planRecorderId == null){
			writeJson("0", "计划详情ID为空");
			return null;
		}
		
		try {
			JcMainPlanRecorder recorder=jcMainPlanRecorderService.findById(planRecorderId);
			
			if(recorder == null){
				writeJson("0", Constants.COMMON_MESSAGE_UPDATE_ERROR);
			}else{
				
				if("xcxc".equals(fieldName)){
					String xcxc=fieldValue == null ? "" : fieldValue.toUpperCase();
					DictJcFixMileage fixMileage=dictJCFixMileageService.findByFixMileageValue(xcxc);
					if(fixMileage != null){
						fieldValue=fixMileage.getId().toString();
						fieldName="dictJcFixMileage.id";
						jcMainPlanRecorderService.update(planRecorderId,fieldName,fieldValue);
						
					}else{
						writeJson("0", Constants.COMMON_MESSAGE_UPDATE_ERROR);
						return null;
					}
				}else if("kcArea".equals(fieldName)){
					
				}else{
					jcMainPlanRecorderService.update(planRecorderId,fieldName,fieldValue);
					
				}
				
			}
			writeJson("0", Constants.COMMON_MESSAGE_UPDATE_SUC);
			
		} catch (Exception e) {
			e.printStackTrace();
			writeJson("1", Constants.COMMON_MESSAGE_UPDATE_ERROR);
		}
		
		
		return null;
	}

	public void setJcMainPlanRecorderService(
			IJcMainPlanRecorderService jcMainPlanRecorderService) {
		this.jcMainPlanRecorderService = jcMainPlanRecorderService;
	}

	public void setPlanRecorderId(Long planRecorderId) {
		this.planRecorderId = planRecorderId;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public void setDictJCFixMileageService(
			IDictJcFixMileageService dictJCFixMileageService) {
		this.dictJCFixMileageService = dictJCFixMileageService;
	}

	

	

	
	
	
}
