package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;

/**
 * 
 * @ClassName: FindPagePjStoreDynamicInfoByDictFirstUnitIdAction
 * @Description: TODO(通过大部件(专业)ID查询该大部件下配件动态信息，查找页面)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-31 下午12:47:30
 */
public class FindPagePjStoreDynamicInfoByDictFirstUnitIdAction extends BaseAction  {

	
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private DictStorePositionService dictStorePositionService;
	
	private Long firstUnitId;
	

	@Override
	public String execute() throws Exception {
		List<PjStoreDynamicInfo> list=pjStoreDynamicInfoService.findPagePjStoreDynamicInfoByFirstUnitid(firstUnitId);
		
		PageModel<PjStoreDynamicInfo> pm=new PageModel<PjStoreDynamicInfo>();
		pm.setDatas(list);
		request.setAttribute("pjStoreDynamicInfoPm", pm);
		
		//显示仓库位置
		List<DictStorePosition> storePositionList = dictStorePositionService.listAll();
		request.setAttribute("mapPjStatue", Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS);
		request.setAttribute("storePositionList", storePositionList);
		return super.execute();
	}
	
	


	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}


	public void setFirstUnitId(Long firstUnitId) {
		this.firstUnitId = firstUnitId;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}
	
	
	
}
