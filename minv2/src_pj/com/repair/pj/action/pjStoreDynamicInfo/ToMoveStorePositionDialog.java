package com.repair.pj.action.pjStoreDynamicInfo;

import java.util.List;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: ToMoveStorePositionDialog
* @Description: TODO(查询所有移库页面的需要显示的信息)
* @author lxb
* @version V1.0  
* @date 2015-9-8 下午1:21:03
 */
public class ToMoveStorePositionDialog extends BaseAction implements ModelDriven<PjStoreDynamicInfo>{
		private PjStoreDynamicInfoService pjStoreDynamicInfoService;
		private DictStorePositionService  dictStorePositionService;
		private UsersPrivsService usersPrivsService;
		private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
		private long[] pjStoreDynamicInfoIds;
			
		@Override
		public String execute() throws Exception {
	       pjStoreDynamicInfo =pjStoreDynamicInfoService.findById(pjStoreDynamicInfo.getId());
	       if(pjStoreDynamicInfoIds !=null){
	       	 pjStoreDynamicInfo =pjStoreDynamicInfoService.findById(this.pjStoreDynamicInfoIds[0]);
	       }
	       List<DictStorePosition> dictStorePosition = dictStorePositionService.listAll();
	       List<UsersPrivs> usersList = usersPrivsService.findAllUsers();
	       request.setAttribute("pjStoreDynamic", pjStoreDynamicInfo);
	       request.setAttribute("dictStorePositionList", dictStorePosition);	
	       request.setAttribute("usersList", usersList);	
	       request.setAttribute("pjStoreDynamicInfoIds", pjStoreDynamicInfoIds);
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

		

		public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
			this.usersPrivsService = usersPrivsService;
		}


		public long[] getPjStoreDynamicInfoIds() {
			return pjStoreDynamicInfoIds;
		}


		public void setPjStoreDynamicInfoIds(long[] pjStoreDynamicInfoIds) {
			this.pjStoreDynamicInfoIds = pjStoreDynamicInfoIds;
		}

		
}
