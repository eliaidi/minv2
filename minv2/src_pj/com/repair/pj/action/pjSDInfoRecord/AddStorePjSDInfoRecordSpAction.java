package com.repair.pj.action.pjSDInfoRecord;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSp;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjSDInfoRecordService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: MoveStorePjSDInfoRecordAction
* @Description: TODO(移库修改记录表)
* @author lxb
* @version V1.0  
* @date 2015-9-8 下午3:30:32
 */
public class AddStorePjSDInfoRecordSpAction extends BaseAction implements ModelDriven<PjSDInfoRecordSp>{
		private PjSDInfoRecordService pjSDInfoRecordService;
		private PjStoreDynamicInfoService pjStoreDynamicInfoService;
		private DictStorePositionService  dictStorePositionService;
		private UsersPrivsService usersPrivsService;
		
		private int dictStorePositionId;
		private int[] pjStoreDynamicInfoId;
		private Integer[] proteamUsersId;
		private Integer storeUsersId;
		
		private PjSDInfoRecordSp pjSDInfoRecordSp = new PjSDInfoRecordSp(); 
		private String returnUrl;
		
		@Override
		public String execute() throws Exception {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			PrintWriter printWriter=ServletActionContext.getResponse().getWriter();
			
			try {
				//判断动态配件ID  班组ID   仓库人员ID是否为  null
				if(pjStoreDynamicInfoId == null || proteamUsersId == null || storeUsersId == null ){
					printWriter.write("数据异常");
					session.setAttribute("message","数据异常");
					return null;
				}
				for (int i = 0; i < pjStoreDynamicInfoId.length; i++) {
					//修改动态配件中对应的配件所在位置/仓库ID
					PjStoreDynamicInfo pjStoreDynamicInfo = pjStoreDynamicInfoService.findById(pjStoreDynamicInfoId[i]);
					DictStorePosition dictStore = dictStorePositionService.findById(dictStorePositionId);
					pjStoreDynamicInfo.setDictStorePosition(dictStore);
					pjStoreDynamicInfoService.update(pjStoreDynamicInfo);
					
					//添加动态配件主要记录表
					PjSDInfoRecord pjSDInfoRecord = new PjSDInfoRecord();
					pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ZERO);
					pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_ZERO);
					pjSDInfoRecord.setRecordTime(Constants.TIME_STAMP_SYSTEM_DATE);
					pjSDInfoRecord.setRemark("关于主仓库和班组库的主要记录");
					pjSDInfoRecord.setPjStoreDynamicInfo(pjStoreDynamicInfo);
					
					//pjSDInfoRecordSp字段信息
					PjSDInfoRecordSp pjSDInfoRecordSp=new PjSDInfoRecordSp();
					pjSDInfoRecordSp.setPjSDInfoRecord(pjSDInfoRecord);
					pjSDInfoRecordSp.setStoreUsers(usersPrivsService.findUsersById(storeUsersId));
					//如果是班组库移库配件仓库，接收多个班组ID
					if(proteamUsersId.length != 1){
						pjSDInfoRecordSp.setProteamUsers(usersPrivsService.findUsersById(proteamUsersId[i]));
					}else{
						pjSDInfoRecordSp.setProteamUsers(usersPrivsService.findUsersById(proteamUsersId[0]));
					}
					
					pjSDInfoRecordSp.setRemark("关于主仓库和班组仓库的子记录");
					if(Constants.STORE_UNIT_PROTEAM_STATUS_ZERO == 0 ){
						Set<PjSDInfoRecordSp> pjSDInfoRecordSpSet = new HashSet<PjSDInfoRecordSp>();
						pjSDInfoRecordSpSet.add(pjSDInfoRecordSp);
						pjSDInfoRecord.setPjSDInfoRecordSps(pjSDInfoRecordSpSet);
					}
					pjSDInfoRecordService.save(pjSDInfoRecord);
				}
				printWriter.write(Constants.MOVE_STORE_POSITION_DIALOG_SUC);
				session.setAttribute("message",Constants.MOVE_STORE_POSITION_DIALOG_SUC);
			} catch (Exception e) {
				printWriter.write(Constants.MOVE_STORE_POSITION_DIALOG_ERROR);
				session.setAttribute("message",Constants.MOVE_STORE_POSITION_DIALOG_ERROR);
				e.printStackTrace();
			}
			return null;
		}

		public void setPjSDInfoRecordService(PjSDInfoRecordService pjSDInfoRecordService) {
			this.pjSDInfoRecordService = pjSDInfoRecordService;
		}

		public void setPjSDInfoRecordSp(PjSDInfoRecordSp pjSDInfoRecordSp) {
			this.pjSDInfoRecordSp = pjSDInfoRecordSp;
		}

		public void setPjStoreDynamicInfoId(int[] pjStoreDynamicInfoId) {
			this.pjStoreDynamicInfoId = pjStoreDynamicInfoId;
		}

		public void setPjStoreDynamicInfoService(PjStoreDynamicInfoService pjStoreDynamicInfoService) {
			this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
		}

		public void setDictStorePositionService(
				DictStorePositionService dictStorePositionService) {
			this.dictStorePositionService = dictStorePositionService;
		}

		public void setDictStorePositionId(int dictStorePositionId) {
			this.dictStorePositionId = dictStorePositionId;
		}

		public PjSDInfoRecordSp getModel() {
			return this.pjSDInfoRecordSp;
		}

		public String getReturnUrl() {
			return returnUrl;
		}

		public void setReturnUrl(String returnUrl) {
			this.returnUrl = returnUrl;
		}

		public void setProteamUsersId(Integer[] proteamUsersId) {
			this.proteamUsersId = proteamUsersId;
		}

		public void setStoreUsersId(Integer storeUsersId) {
			this.storeUsersId = storeUsersId;
		}

		public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
			this.usersPrivsService = usersPrivsService;
		}
			
}
