package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pjFix.dto.PjStoreDynamicInfoSearchDto;
import com.repair.pjFix.service.DictJcTypeService;
import com.repair.pjFix.service.DictStorePositionService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: QueryPjStoreDynamicInfoAction
* @Description: TODO(查询动态配件)
* @author 周云韬
* @version V1.0  
* @date 2015-9-25 上午10:53:00
 */
public class QueryPjStoreDynamicInfoAction extends ActionSupport implements ModelDriven<PjStoreDynamicInfoSearchDto>{
   
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	private DictStorePositionService dictStorePositionForPjFixService; 
	private DictJcTypeService dictJcTypeForPjFixService;
	
	private PjStoreDynamicInfoSearchDto dto =new PjStoreDynamicInfoSearchDto();
	
	@Override
	public String execute() throws Exception {
		//查询动态动态配件
		SplitPageModel sp=pjSDInfoForPjFixService.queryPjStoreDynamicInfo(dto);
		ServletActionContext.getRequest().setAttribute("spm",sp);
		
		Map<PjStoreStaticInfo,List<PjStoreDynamicInfo>> map=new HashMap<PjStoreStaticInfo, List<PjStoreDynamicInfo>>();
		
		List<PjStoreDynamicInfo> psdiList=sp.getData();
		
		for (PjStoreDynamicInfo psdi : psdiList) {
			PjStoreStaticInfo pssi=psdi.getPjStoreStaticInfo();
			List<PjStoreDynamicInfo> tempList=new ArrayList<PjStoreDynamicInfo>();
			if(map.get(pssi) != null){
				tempList=map.get(pssi);
			}
			tempList.add(psdi);
			map.put(pssi, tempList);
		}
		ServletActionContext.getRequest().setAttribute("map",map);
		
		//配件所在仓库信息
		List<DictStorePosition>  storePositionList=dictStorePositionForPjFixService.findAllDictStorePosition();
		ServletActionContext.getRequest().setAttribute("storePositionList", storePositionList);
		//dto
		ServletActionContext.getRequest().setAttribute("dto", dto);
		//机车型号
		List<DictJcType> jcType=dictJcTypeForPjFixService.findAllDictJcType();
		ServletActionContext.getRequest().setAttribute("jcType", jcType);
		//配件状态
		ServletActionContext.getRequest().setAttribute("statusType",Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS);
		
		return Action.SUCCESS;
	}
	
	public PjStoreDynamicInfoSearchDto getModel() {
		return this.dto;
	}

	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setDictStorePositionForPjFixService(DictStorePositionService dictStorePositionForPjFixService) {
		this.dictStorePositionForPjFixService = dictStorePositionForPjFixService;
	}

	public void setDictJcTypeForPjFixService(DictJcTypeService dictJcTypeForPjFixService) {
		this.dictJcTypeForPjFixService = dictJcTypeForPjFixService;
	}
	
}
