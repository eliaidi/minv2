package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.List;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: ToUpdateDynamicInfoDialog
* @Description: TODO 跳转至修改动态配件对话框
* @author 周云韬
* @version V1.0  
* @date 2015-9-24 上午9:30:52
 */
public class ToUpdateDynamicInfoDialog extends BaseAction implements ModelDriven<PjStoreDynamicInfo>{
		private PjStoreDynamicInfoService pjStoreDynamicInfoService;
		private DictStorePositionService dictStorePositionService;
		private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
		
		 @Override
		public String execute() throws Exception {
			pjStoreDynamicInfo = pjStoreDynamicInfoService.findById(pjStoreDynamicInfo.getId());
			request.setAttribute("pjStoreDynamic", pjStoreDynamicInfo);
	        List<DictStorePosition> dictStorePosition = dictStorePositionService.listAll();
	        request.setAttribute("dictStorePositionList", dictStorePosition);	
			return SUCCESS;
		}
		 
		
		public void setPjStoreDynamicInfoService(
				PjStoreDynamicInfoService pjStoreDynamicInfoService) {
			this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
		}
		
		
		public void setDictStorePositionService(
				DictStorePositionService dictStorePositionService) {
			this.dictStorePositionService = dictStorePositionService;
		}
		public PjStoreDynamicInfo getModel() {
			return this.pjStoreDynamicInfo;
		}
			 
			 
}
