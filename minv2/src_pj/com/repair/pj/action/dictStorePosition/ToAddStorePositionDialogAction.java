package com.repair.pj.action.dictStorePosition;

import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.DictArea;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictAreaService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: ToAddStorePositionDialogAction
* @Description: TODO(跳转到仓库新增页面)
* @author lxb
* @version V1.0  
* @date 2015-9-16 上午8:59:23
 */
public class ToAddStorePositionDialogAction extends BaseAction{
		private DictAreaService dictAreaService;
		private DictProteamService dictProteamService;
		@Override
		public String execute() throws Exception {
			List<DictArea> Arealist=dictAreaService.listAll();
			request.setAttribute("areaList", Arealist);
			List<DictProteam> dpList = dictProteamService.listAll();
			if(dpList!=null){
				request.setAttribute("dpList", dpList);
			}
			request.setAttribute("storePositionType", Constants.DICT_STORE_POSITION_TYPE);
			return SUCCESS;
		}
		
		public void setDictAreaService(DictAreaService dictAreaService) {
			this.dictAreaService = dictAreaService;
		}
		
		public void setDictProteamService(DictProteamService dictProteamService) {
			this.dictProteamService = dictProteamService;
		}
}
