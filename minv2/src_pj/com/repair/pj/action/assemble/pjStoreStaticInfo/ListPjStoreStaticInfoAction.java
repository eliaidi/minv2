package com.repair.pj.action.assemble.pjStoreStaticInfo;

import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.dto.PjStoreStaticInfoSearchDto;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;

/**
 * 
 * @see 通过机型列出相对应的 静态配件（分页查询）
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class ListPjStoreStaticInfoAction extends BaseAction implements ModelDriven<PjStoreStaticInfoSearchDto>{

	private PjStoreStaticInfoSearchDto dto=new PjStoreStaticInfoSearchDto();

	private PjStoreStaticInfoService pjStoreStaticInfoService;
	
	@Override
	public String execute() throws Exception {
		SplitPageModel<PjStoreStaticInfo> spm=pjStoreStaticInfoService.listPageByDto(dto);
		
		
		
		return null;
	}
	
	
	@Override
	public PjStoreStaticInfoSearchDto getModel() {
		return this.dto;
	}
	
	
	
	
}
