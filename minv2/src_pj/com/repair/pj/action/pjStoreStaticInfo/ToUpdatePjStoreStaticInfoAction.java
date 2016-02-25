package com.repair.pj.action.pjStoreStaticInfo;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.DictProteam;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.ProteamPjStatic;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.pj.service.ProteamPjStaticService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: UpdatePjStoreStaticInfoAction
 * @Description: TODO(实现ToUpdatePjStoreStaticInfo方法,修改数据之前查询数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 上午11:25:17
 */
public class ToUpdatePjStoreStaticInfoAction extends BaseAction implements ModelDriven<PjStoreStaticInfo> {

	private PjStoreStaticInfo pjStoreStaticInfo = new PjStoreStaticInfo();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
    private DictProteamService dictProteamService;
    private JcTypePjFirstUnitService jcTypePjFirstUnitService;
    private DictJcTypeService dictJcTypeService;
    private ProteamPjStaticService proteamPjStaticService;

	@Override
	public String execute() throws Exception {
		//配件静态数据
		PjStoreStaticInfo staticInfo=pjStoreStaticInfoService.findById(pjStoreStaticInfo.getId());
		request.setAttribute("staticInfo",staticInfo);
		
	
		//组装状态
		request.setAttribute("pjAssemblyType",Constants.PJ_ASSEMBLY_TYPE);
		
		//车型_大部件中间数据
		List<JcTypePjFirstUnit> list=jcTypePjFirstUnitService.listAll();
		request.setAttribute("jcTypePjFirstUnitList",list);
		
		//车型数据
		List<DictJcType> dictJcType=dictJcTypeService.listAll();
		request.setAttribute("dictJcTypeList",dictJcType);
		
		//配件静态_车型_大部件中间数据
		//配件静态_班组中间表
		List<ProteamPjStatic> proteamPjStatic=proteamPjStaticService.listAll();
		session.setAttribute("proteamPjStaticList", proteamPjStatic);
		
		//班组数据
		List<DictProteam> dictProteams=dictProteamService.listAll();
		session.setAttribute("dictProteams", dictProteams);
		return Action.SUCCESS;
	}

	public PjStoreStaticInfo getModel() {
		return this.pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}

	public void setProteamPjStaticService(
			ProteamPjStaticService proteamPjStaticService) {
		this.proteamPjStaticService = proteamPjStaticService;
	}

	
	
	
}
