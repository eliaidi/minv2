package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.dto.PjSDInfoRecordSearchDto;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @ClassName: FindAllPjStoreDynamicInfoAction
 * @Description: TODO(查询配件动态信息数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午10:00:25
 */
public class FindAllPjStoreDynamicInfoAction extends BaseAction implements
		ModelDriven<PjStoreDynamicInfo> {

	private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private DictStorePositionService dictStorePositionService;
	private PjSDInfoRecordSearchDto dto=new PjSDInfoRecordSearchDto();

	@Override
	public String execute() throws Exception {
		SplitPageModel<PjStoreDynamicInfo> pm = pjStoreDynamicInfoService.listAllByPage(dto);
		//显示分页额数据
		request.setAttribute("pjStoreDynamicInfoPm", pm);
		//显示仓库位置
		List<DictStorePosition> storePositionList = dictStorePositionService.listAll();
		request.setAttribute("storePositionList", storePositionList);
		return Action.SUCCESS;
	}

	public PjStoreDynamicInfo getModel() {
		return this.pjStoreDynamicInfo;
	}


	public void setPjStoreDynamicInfoService(PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}


	public void setDictStorePositionService(DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public void setDto(PjSDInfoRecordSearchDto dto) {
		this.dto = dto;
	}
	
	
	
	
}
