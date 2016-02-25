package com.repair.zx.action.jcPlanDate;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.JcFixFlow;
import com.repair.entity.JcPlanDate;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IDictJcFixMileageService;
import com.repair.zx.service.IJcFixFlowService;
import com.repair.zx.service.IJcPlanDateService;


/**
 * 添加日计划扣车信息
 * @author 唐鹏
 *
 */
public class SaveJcPlanDateAction extends BaseAction implements ModelDriven<JcPlanDate>{
	
	private IJcPlanDateService jcPlanDateService;
	private IDictJcFixMileageService dictJcFixMileageService;
	private IJcFixFlowService jcFixFlowService;
	
	
	private Long jcFixMileageId;
	private Long extraFixMileageId;
	private JcPlanDate jcPlanDate=new JcPlanDate();
	
	public String execute() throws Exception {
		if(getLoginUsers() == null){
			return Action.LOGIN;
		}
		
		try{
			jcPlanDate.setJcPlanStatus(Constants.JC_PLAN_STATUS_NEW);
			jcPlanDate.setPlanMaker(getLoginUsers().getUserName());
			jcPlanDate.setPlanMakeTime(Constants.TIME_STAMP_SYSTEM_DATE);
			jcPlanDate.setDictJcFixMileage(dictJcFixMileageService.findById(jcFixMileageId));
			
			List<JcFixFlow> fixFlowList=jcFixFlowService.list(jcPlanDate.getJcTypeValue(), jcPlanDate.getDictJcFixMileage().getFixMileageValue());
			if(fixFlowList.size() != 0){
				jcPlanDate.setJcFixFlow(fixFlowList.get(0));
			}
			
			
			if(extraFixMileageId != null){
				jcPlanDate.setExtraFixMileage(dictJcFixMileageService.findById(extraFixMileageId));
			}else{
				jcPlanDate.setExtraFixMileage(null);
			}
			
			
			/** 判断是中修还是小辅修  */
			if(jcPlanDate.getDictJcFixMileage().getMileageType().equals( Constants.JC_FIX_MILEAGE_TYPE_ZHONG_FIX)){
				jcPlanDate.setProjectType(Constants.JC_PLAN_DATE_PROJECT_TYPE_ZHONG_FIX);
			}else{
				jcPlanDate.setProjectType(Constants.JC_PLAN_DATE_PROJECT_TYPE_XIAOFU_FIX);
			}
			//修改日计划
			if(jcPlanDate.getId() != null){
				jcPlanDateService.update(jcPlanDate);
			}else{
				jcPlanDateService.save(jcPlanDate);
			}
			
			
			
			request.setAttribute("message", Constants.COMMON_MESSAGE_OPERATE_SUC);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", Constants.COMMON_MESSAGE_OPERATE_ERROR);
		}
		
		return Action.SUCCESS;
	}
	



	public void setDictJcFixMileageService(
			IDictJcFixMileageService dictJcFixMileageService) {
		this.dictJcFixMileageService = dictJcFixMileageService;
	}


	public void setJcFixMileageId(Long jcFixMileageId) {
		this.jcFixMileageId = jcFixMileageId;
	}

	

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	


	public void setJcFixFlowService(IJcFixFlowService jcFixFlowService) {
		this.jcFixFlowService = jcFixFlowService;
	}

	public void setExtraFixMileageId(Long extraFixMileageId) {
		this.extraFixMileageId = extraFixMileageId;
	}
	
	




	public JcPlanDate getModel() {
		return this.jcPlanDate;
	}
	
	
}
