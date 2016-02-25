package com.repair.zx.action.jcZxFixItemRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.JcPlanDate;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;
import com.repair.zx.dto.JcZxFixItemRecordDto;
import com.repair.zx.service.IJcPlanDateService;
import com.repair.zx.service.IJcZxFixItemRecordService;

/**
 * 
 * @see 整车记录查询
 * @author 周云韬
 * @date 2015-12-18
 * @version 1.0
 */
public class ViewZxRecordAction extends BaseAction implements ModelDriven<JcZxFixItemRecordDto>{
	
	private IJcZxFixItemRecordService jcZxFixItemRecordService ;
	private IJcPlanDateService jcPlanDateService;
	
	
	private JcZxFixItemRecordDto dto=new JcZxFixItemRecordDto();
	
	@Override
	public String execute() throws Exception {
		SplitPageModel<JcZxFixItemRecord> spm=jcZxFixItemRecordService.listPageByDto(dto);
		
		JcPlanDate planDate=jcPlanDateService.findById(dto.getPlanDateId());
		
		Map<DictPjFirstUnit, List<JcZxFixItemRecord>> map=new HashMap<DictPjFirstUnit, List<JcZxFixItemRecord>>();
		
		
		for (JcZxFixItemRecord rec : spm.getData()) {
			DictPjFirstUnit fisrUnit=rec.getFixItem().getFirstUnit();
			List<JcZxFixItemRecord> tempList=map.get(fisrUnit);
			if(tempList == null){
				tempList=new ArrayList<JcZxFixItemRecord>();
			}
			tempList.add(rec);
			map.put(fisrUnit, tempList);
		}
		
		request.setAttribute("pd", planDate);
		request.setAttribute("recMap", map);
		request.setAttribute("spm", spm);
		return Action.SUCCESS;
	}


	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}



	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}


	public JcZxFixItemRecordDto getModel() {
		return this.dto;
	}
	
	
	
}
