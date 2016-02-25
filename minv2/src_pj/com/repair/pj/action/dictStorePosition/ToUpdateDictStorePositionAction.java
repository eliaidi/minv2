package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictArea;
import com.repair.entity.DictProteam;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.users.service.DictAreaService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

public class ToUpdateDictStorePositionAction extends BaseAction implements ModelDriven<DictStorePosition>{
		private DictProteamService dictProteamService;
        private DictStorePosition position=new DictStorePosition();
 		private DictStorePositionService dictStorePositionService;
 		private DictAreaService dictAreaService;
 		private String dictStorePositionId;
		@Override
		public String execute() throws Exception {
		// 查找仓库表信息
		 DictStorePosition dictStorePosition=dictStorePositionService.findById(position.getId());
		 request.setAttribute("storePosition", dictStorePosition);
		 
		 // 查找地区/机务段表信息
		 List<DictArea> list = dictAreaService.listAll();
		 request.setAttribute("areaList", list);
		 
		// 获取班组信息
		 List<DictProteam> dpList = dictProteamService.listAll();
		 if(dpList !=null){
			 request.setAttribute("dpList", dpList);
		 }
		 
		// 查找仓库表信息
		 request.setAttribute("prositionType", Constants.DICT_STORE_POSITION_TYPE);
		 
		 return SUCCESS;
		}
	
		public void setDictStorePositionService(
				DictStorePositionService dictStorePositionService) {
			this.dictStorePositionService = dictStorePositionService;
		}
		
		public void setDictAreaService(DictAreaService dictAreaService) {
			this.dictAreaService = dictAreaService;
		}
		
		public void setDictStorePositionId(String dictStorePositionId) {
			this.dictStorePositionId = dictStorePositionId;
		}
		public DictStorePosition getModel() {
			return this.position;
		}
		
		public void setDictProteamService(DictProteamService dictProteamService) {
			this.dictProteamService = dictProteamService;
		}
	
			
}
