package com.repair.pj.action.dictStorePosition;

import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

public class FindDictStorePositionByIdToPjAction extends BaseAction{
	private DictStorePositionService dictStorePositionService;
	private long storePositionId;
	@Override
	public String execute() throws Exception {
		DictStorePosition dictStorePosition = dictStorePositionService.findById(this.storePositionId);
		if(dictStorePosition != null){
			if(dictStorePosition.getPjStoreDynamicInfos().size()>0){
				response.setHeader("content-type",Constants.RESPONSE_HEADER_CONTENT_TYPE_TEXT); 
				pw.write(Constants.DICT_STORE_POSITION_ERROR);
			}
		}
		return null;
	}
	
	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}
	
	public void setStorePositionId(long storePositionId) {
		this.storePositionId = storePositionId;
	}
	
	
}
