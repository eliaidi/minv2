package com.repair.plan.action.jcMainPlan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictJcFixMileage;
import com.repair.entity.JcMainPlan;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.service.IDictJcFixMileageService;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 保存主计划--同时保存主计划详情	返回json数据  
 * 示例：{"errCode":"0","retMsg":"操作成功"}
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class AjaxSaveJcMainPlanAction extends BaseAction implements ModelDriven<JcMainPlan>{
	
	private IJcMainPlanService jcMainPlanService;
	
	private IDictJcFixMileageService dictJCFixMileageService;
	
	private JcMainPlan plan=new JcMainPlan();
	
	@Override
	public String execute() throws Exception {
		if(getLoginUsers() == null){
			writeJson("-1", "请先登录！");
			return null;
		}
		try{
			plan.setMaker(getLoginUsers().getUserName());
			plan.setMakeTime(new Date(System.currentTimeMillis()));
			plan.setStatus(0);
			
			String jsonStr=request.getParameter("jsonStr");
			JSONArray jsonArr=new JSONArray(jsonStr);
			
			Set<JcMainPlanRecorder> recordSet=new HashSet<JcMainPlanRecorder>();
			for(int i=0;i<jsonArr.length();i++){	
				JSONObject json=jsonArr.getJSONObject(i);
				JcMainPlanRecorder recorder=new JcMainPlanRecorder();
				
				String xcxc=json.getString("xcxc") == null ? "" : json.getString("xcxc").toUpperCase();
				DictJcFixMileage fixMileage=dictJCFixMileageService.findByFixMileageValue(xcxc);
				
				recorder.setPlanWeek(json.getString("planWeek"));
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				recorder.setPlanDate(format.parse(json.getString("planDate")));
				recorder.setJcType(json.getString("jcTypeValue"));
				recorder.setJcNumber(json.getString("jcNumber"));
				recorder.setJcTypeValue(json.getString("jcTypeValue"));
				recorder.setPlanKilometre("".equals(json.getString("planKilometre"))  ? null : json.getInt("planKilometre"));
				recorder.setRealityKilometre("".equals(json.getString("realityKilometre"))  ? null : json.getInt("realityKilometre"));
				recorder.setDictJcFixMileage(fixMileage);
				recorder.setJcMainPlan(plan);
				recorder.setRemark(json.getString("remark"));
				recorder.setCash(0);
				recorder.setMainPlanNum(i+1);
				
				recordSet.add(recorder);
			}
			plan.setPlanRecorderSet(recordSet);
			
			jcMainPlanService.save(plan);
			
			writeJson("0", plan.getId()+"");
		}catch(Exception e){
			e.printStackTrace();
			writeJson("1", Constants.COMMON_MESSAGE_OPERATE_ERROR);
		}
		return null;
	}



	public void setJcMainPlanService(IJcMainPlanService jcMainPlanService) {
		this.jcMainPlanService = jcMainPlanService;
	}



	public JcMainPlan getModel() {
		return this.plan;
	}



	public void setDictJCFixMileageService(
			IDictJcFixMileageService dictJCFixMileageService) {
		this.dictJCFixMileageService = dictJCFixMileageService;
	}



	
	
	
}
