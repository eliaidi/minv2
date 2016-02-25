package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.dto.PjStoreDynamicInfoSearchDto;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;

/**
 * 
* @ClassName: QueryPjStoreStaticInfoAction
* @Description: TODO 配件动态信息管理-->专业分类-->查询
* 					  配件动态信息管理-->车型分类-->查询
* @author 周云韬
* @version V1.0  
* @date 2015-9-6 下午5:15:37
 */
public class QueryPjStoreDynamicInfoAction extends BaseAction implements ModelDriven<PjStoreDynamicInfoSearchDto>{
	
	private PjStoreDynamicInfoSearchDto dto=new PjStoreDynamicInfoSearchDto();
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private DictStorePositionService dictStorePositionService; 
	private DictJcTypeService dictJcTypeService;
	
	//表明此action跳转来源。 如果为unit，则说明从配件动态信息管理-->专业分类进入
    //						如果为jcType，则说明从配件动态信息管理-->车型分类进入
	private String flag;
	
	
	@Override
	public String execute() throws Exception {
		//通过条件查询，得到静态配件集合
		SplitPageModel sp=pjStoreDynamicInfoService.queryPjStoreDynamicInfo(dto);
		request.setAttribute("sp",sp);
		
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
		request.setAttribute("map",map);
		
		//得到存储位置（仓库）集合
		List<DictStorePosition>  storePositionList=dictStorePositionService.listAll();
		request.setAttribute("storePositionList", storePositionList);
		
		
		//得到所有机车型号信息，并且拼接成字符串，方便自动提示
		List<DictJcType> dictJcTypeList=dictJcTypeService.listAll();
		StringBuffer jcTypeStr=new StringBuffer();
		for(int i=0;i<dictJcTypeList.size();i++){
			jcTypeStr.append(dictJcTypeList.get(i).getJcClass().getJcClassName());
			if(i != dictJcTypeList.size()-1){
				jcTypeStr.append(",");
			}
		}
		request.setAttribute("jcTypeStr", jcTypeStr);
		
		request.setAttribute("dto", dto);
		
		//跳转来源为专业分类
		if(Constants.QUERY_PJ_SD_INFO_PARAM_UNIT.equals(flag)){
			return Constants.QUERY_PJ_SD_INFO_PARAM_UNIT;
		}
		//跳转来源为专业分类
		if(Constants.QUERY_PJ_SD_INFO_PARAM_JCTYPE.equals(flag)){
			return Constants.QUERY_PJ_SD_INFO_PARAM_JCTYPE;
		}
		return Action.SUCCESS;
	}
	
	
	
	public PjStoreDynamicInfoSearchDto getModel() {
		return this.dto;
	}

	

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}



	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}

	
	
}
