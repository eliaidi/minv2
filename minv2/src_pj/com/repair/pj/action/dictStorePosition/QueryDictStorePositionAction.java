package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictArea;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.users.service.DictAreaService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;

/**
 * 
 * @ClassName: QueryDictStorePositionAction
 * @Description: TODO(配件所在位置分页action层)
 * @author 周云韬
 * @version V1.0
 * @date 2015-9-1 上午9:44:46
 */
public class QueryDictStorePositionAction extends BaseAction implements ModelDriven<DictStorePosition>{
	private DictStorePositionService dictStorePositionService;
	private DictAreaService dictAreaService;
	private DictStorePosition dictStorePosition = new DictStorePosition();
	
	@Override
	public String execute() throws Exception {
		SplitPageModel sp = dictStorePositionService.queryDictStorePosition(dictStorePosition);
		request.setAttribute("sp", sp);
		request.setAttribute("storePositionTypeMap", Constants.DICT_STORE_POSITION_TYPE);
		List<DictArea> dictAreaList = dictAreaService.listAll();
		request.setAttribute("areaList", dictAreaList);
		return SUCCESS;
	}

	public DictStorePositionService getDictStorePositionService() {
		return dictStorePositionService;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	
	public DictAreaService getDictAreaService() {
		return dictAreaService;
	}

	public void setDictAreaService(DictAreaService dictAreaService) {
		this.dictAreaService = dictAreaService;
	}

	public DictStorePosition getModel() {
		// TODO Auto-generated method stub
		return this.dictStorePosition;
	}

}
