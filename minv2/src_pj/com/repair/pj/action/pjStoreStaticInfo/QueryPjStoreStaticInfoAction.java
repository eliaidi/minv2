package com.repair.pj.action.pjStoreStaticInfo;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.DictStorePosition;
import com.repair.pj.dto.PjStoreStaticInfoSearchDto;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreStaticInfoService;
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
public class QueryPjStoreStaticInfoAction extends BaseAction implements ModelDriven<PjStoreStaticInfoSearchDto>{
	
	private PjStoreStaticInfoSearchDto dto=new PjStoreStaticInfoSearchDto();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	private DictStorePositionService dictStorePositionService; 
	private DictJcTypeService dictJcTypeService;
	
	//表明此action跳转来源。 如果为unit，则说明从配件动态信息管理-->专业分类进入
//						如果为jcType，则说明从配件动态信息管理-->车型分类进入
	private String flag;
	
	
	@Override
	public String execute() throws Exception {
		//通过条件查询，得到静态配件集合
		SplitPageModel sp=pjStoreStaticInfoService.listPageByDto(dto);
		request.setAttribute("sp", sp);
		
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
	
	
	
	public PjStoreStaticInfoSearchDto getModel() {
		return this.dto;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
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

	
	
}
