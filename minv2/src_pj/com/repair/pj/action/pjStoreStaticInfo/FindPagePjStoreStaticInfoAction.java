package com.repair.pj.action.pjStoreStaticInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.pj.dto.PjStoreStaticInfoSearchDto;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: FindPagePjStoreStaticInfoAction
 * @Description: TODO(实现queryPjStoreStaticInfo方法，分页实现)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午12:47:30
 */
public class FindPagePjStoreStaticInfoAction extends BaseAction implements
		ModelDriven<PjStoreStaticInfoSearchDto> {

	private PjStoreStaticInfoService pjStoreStaticInfoService;
	private DictProteamService dictProteamService;
	
	private PjStoreStaticInfoSearchDto dto=new PjStoreStaticInfoSearchDto();
	
	@Override
	public String execute() throws Exception {
		if(dto.getPjActivate() == null){
			dto.setPjActivate(Constants.PJ_ACTIVATE_ENABLE);
		}
		request.setAttribute("pssiList", pjStoreStaticInfoService.listPageByDto(dto));
		
		//查询所有班组名称
		request.getSession().setAttribute("dictProteams", dictProteamService.listAll());

		//组装状态
		request.getSession().setAttribute("assembly", Constants.PJ_ASSEMBLY_TYPE);
		
		request.setAttribute("dto", dto);
		return Action.SUCCESS;
	}
	
	
	

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}



	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}


	public PjStoreStaticInfoSearchDto getModel() {
		return this.dto;
	}

	
	
}
