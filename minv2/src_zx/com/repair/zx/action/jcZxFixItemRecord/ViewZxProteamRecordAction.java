package com.repair.zx.action.jcZxFixItemRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.DictProteam;
import com.repair.entity.JcPlanDate;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;
import com.repair.zx.dto.JcZxFixItemRecordDto;
import com.repair.zx.service.IJcPlanDateService;
import com.repair.zx.service.IJcZxFixItemRecordService;

/**
 * 机车部件信息
 * @author 唐鹏
 *
 */
public class ViewZxProteamRecordAction extends BaseAction implements ModelDriven<JcZxFixItemRecordDto>{

	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	private IJcPlanDateService jcPlanDateService;
	private JcZxFixItemRecordDto dto=new JcZxFixItemRecordDto();
	
	@Override
	public String execute() throws Exception {
		SplitPageModel<JcZxFixItemRecord> spm=jcZxFixItemRecordService.listPageByDto(dto);
		
		
		JcPlanDate planDate= jcPlanDateService.findById(dto.getPlanDateId());
		
		Map<DictProteam, List<JcZxFixItemRecord>> map=new HashMap<DictProteam, List<JcZxFixItemRecord>>();
		
		for (JcZxFixItemRecord rec : spm.getData()) {
			DictProteam proteam=rec.getFixItem().getProteam();
			List<JcZxFixItemRecord> tempList=map.get(proteam);
			if(tempList == null){
				tempList=new ArrayList<JcZxFixItemRecord>();
			}
			tempList.add(rec);
			map.put(proteam, tempList);
		}
		
		request.setAttribute("pd", planDate);
		request.setAttribute("recMap", map);
		request.setAttribute("spm", spm);
		return Action.SUCCESS;
	}
	
	public JcZxFixItemRecordDto getModel() {
		return this.dto;
	}

	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}

	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	
}
