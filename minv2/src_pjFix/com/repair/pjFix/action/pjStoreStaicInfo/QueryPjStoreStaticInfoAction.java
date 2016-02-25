package com.repair.pjFix.action.pjStoreStaicInfo;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictJcType;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pjFix.dto.PjStoreStaticInfoSearchDto;
import com.repair.pjFix.service.DictJcTypeService;
import com.repair.pjFix.service.DictPjFirstUnitService;
import com.repair.pjFix.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: QueryPjStoreStaticInfopjFixAction
* @Description: TODO(查询配件大类中的数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-22 上午08:57:21
 */
public class QueryPjStoreStaticInfoAction extends BaseAction implements ModelDriven<PjStoreStaticInfoSearchDto>{
    
	private PjStoreStaticInfoService pjSSInfoForPjFixService;
	private DictJcTypeService dictJcTypeForPjFixService;
	private DictPjFirstUnitService dictPjFirstUnitForPjFixService;
	
	private PjStoreStaticInfoSearchDto dto=new PjStoreStaticInfoSearchDto();
	
	@Override
	public String execute() throws Exception {
		
		//通过条件查询，得到静态配件集合
		SplitPageModel sp=pjSSInfoForPjFixService.findPagePjStoreStaticInfo(dto);
		request.setAttribute("spm", sp);
		
		//查询机车型号
		List<DictJcType> list=dictJcTypeForPjFixService.findAllDictJcType();
		request.setAttribute("jcType", list);
		
		//查询专业
		List<DictPjFirstUnit> pjFirstUnit=dictPjFirstUnitForPjFixService.findAllDictPjFirstUnit();
		request.setAttribute("pjFirstUnit", pjFirstUnit);
		
		request.setAttribute("dto", dto);
		
		return Action.SUCCESS;
	}
	
	public PjStoreStaticInfoSearchDto getModel() {
		return this.dto;
	}

	public void setPjSSInfoForPjFixService(PjStoreStaticInfoService pjSSInfoForPjFixService) {
		this.pjSSInfoForPjFixService = pjSSInfoForPjFixService;
	}

	public void setDictJcTypeForPjFixService(DictJcTypeService dictJcTypeForPjFixService) {
		this.dictJcTypeForPjFixService = dictJcTypeForPjFixService;
	}

	public void setDictPjFirstUnitForPjFixService(DictPjFirstUnitService dictPjFirstUnitForPjFixService) {
		this.dictPjFirstUnitForPjFixService = dictPjFirstUnitForPjFixService;
	}
	
}
