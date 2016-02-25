package com.repair.pjFix.action.pjFixItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pjFix.dto.PjStoreDynamicInfoSearchDto;
import com.repair.pjFix.dto.PjStoreStaticInfoSearchDto;
import com.repair.pjFix.service.DictJcTypeService;
import com.repair.pjFix.service.DictPjFirstUnitService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pjFix.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: QueryPjSSInfoByCommitLeadAction
* @Description: TODO(配件检修，选择配件，（交车工长）通过静态配件查询所有数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-9-22 上午08:57:21
 */
public class QueryPjSSInfoByCommitLeadAction extends BaseAction implements ModelDriven<PjStoreStaticInfoSearchDto>{
    
	private PjStoreStaticInfoService pjSSInfoForPjFixService;
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	private DictJcTypeService dictJcTypeForPjFixService;
	private DictPjFirstUnitService dictPjFirstUnitForPjFixService;
	
	private PjStoreStaticInfoSearchDto dto=new PjStoreStaticInfoSearchDto();
	
	@Override
	public String execute() throws Exception {
		
		//通过条件查询，得到静态配件集合
		SplitPageModel sp=pjSSInfoForPjFixService.findPagePjStoreStaticInfo(dto);
		request.setAttribute("spm", sp);
		
		//待签配件集合
		Map<Long, Long> staySignPjMap=new HashMap<Long, Long>();
		//检修中配件集合
		Map<Long, Long> fixingPjMap=new HashMap<Long, Long>();
		//合格配件集合
		Map<Long, Long> standardPjMap=new HashMap<Long, Long>();
		
		List<PjStoreStaticInfo> pssiList=sp.getData();
		
		for (PjStoreStaticInfo pssi : pssiList) {
			Iterator<PjStoreDynamicInfo> it=pssi.getPjStoreDynamicInfos().iterator();
			//待签个数
			PjStoreDynamicInfoSearchDto dto=new PjStoreDynamicInfoSearchDto();
			dto.setFixItemQueryFlag(Constants.PJ_SDIS_DTO_FIX_ITEM_QUERY_FALG_UN_SIGNALL);
			dto.setRoleType(Constants.ROLE_TYPE_COMMIT_LEAD);
			dto.setPjSSInfoId(pssi.getId());
			
			long staySignCount=pjSDInfoForPjFixService.queryPjStoreDynamicInfo(dto).getTotalCount();
			
			long fixingCount=0;
			long standardCount=0;
			
			while (it.hasNext()) {
				PjStoreDynamicInfo psdi=it.next();
				//判断是检修中 和 委外检修
				if(psdi.getPjdStatus() == Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FOUR || psdi.getPjdStatus() == Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FIVE){
					++fixingCount;
				//判断是新建合格 和 修竣合格
				}else if(psdi.getPjdStatus() == Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ZERO || psdi.getPjdStatus() == Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ONE){
					++standardCount;
				}
			}
			
			staySignPjMap.put(pssi.getId(),staySignCount);
			fixingPjMap.put(pssi.getId(),fixingCount);
			standardPjMap.put(pssi.getId(),standardCount);
		}
		
		request.setAttribute("staySignPjMap", staySignPjMap);
		request.setAttribute("fixingPjMap", fixingPjMap);
		request.setAttribute("standardPjMap", standardPjMap);
		
		//查询机车型号
		List<DictJcType> list=dictJcTypeForPjFixService.findAllDictJcType();
		request.setAttribute("jcTypeList", list);
		
		//查询专业
		List<DictPjFirstUnit> pjFirstUnit=dictPjFirstUnitForPjFixService.findAllDictPjFirstUnit();
		
		request.setAttribute("pjFirstUnitList", pjFirstUnit);
		request.setAttribute("dto", dto);
		
		return Action.SUCCESS;
	}
	
	public PjStoreStaticInfoSearchDto getModel() {
		return this.dto;
	}

	public void setPjSSInfoForPjFixService(
			PjStoreStaticInfoService pjSSInfoForPjFixService) {
		this.pjSSInfoForPjFixService = pjSSInfoForPjFixService;
	}

	public void setDictJcTypeForPjFixService(
			DictJcTypeService dictJcTypeForPjFixService) {
		this.dictJcTypeForPjFixService = dictJcTypeForPjFixService;
	}

	public void setDictPjFirstUnitForPjFixService(
			DictPjFirstUnitService dictPjFirstUnitForPjFixService) {
		this.dictPjFirstUnitForPjFixService = dictPjFirstUnitForPjFixService;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
}
