package com.repair.zx.action.dictJcFixMileage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.DictJcFixMileage;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IDictJcFixMileageService;
/**
 * 
 * @see 跳至选择流程页面
 * @author 周云韬
 * @date 2015-12-11
 * @version 1.0
 */
public class ToChoiceFixMileageAction extends BaseAction{
	
	private IDictJcFixMileageService dictJcFixMileageService;
	
	@Override
	public String execute() throws Exception {
		List<DictJcFixMileage> fixMileageList=dictJcFixMileageService.listAll();
		
		Map<Integer, List<DictJcFixMileage>> map=new HashMap<Integer, List<DictJcFixMileage>>();
		
		
		/** 通过类型进行分类 */
		List<DictJcFixMileage> tempList=null;
		for (DictJcFixMileage fixMileage : fixMileageList) {
			Integer mileageType=fixMileage.getMileageType();
		
			tempList=map.get(mileageType);
			if(tempList == null){
				tempList=new ArrayList<DictJcFixMileage>();
			}
			
			tempList.add(fixMileage);
			map.put(mileageType, tempList);
		}
		request.setAttribute("fixMileageMap", map);
		request.setAttribute("otherFixType", Constants.JC_FIX_MILEAGE_TYPE_OTHER_FIX);
		request.setAttribute("fixTypeMap", Constants.JC_FIX_MILEAGE_TYPE);
		return Action.SUCCESS;
	}

	public void setDictJcFixMileageService(
			IDictJcFixMileageService dictJcFixMileageService) {
		this.dictJcFixMileageService = dictJcFixMileageService;
	}

	

	
	
	
	
}
