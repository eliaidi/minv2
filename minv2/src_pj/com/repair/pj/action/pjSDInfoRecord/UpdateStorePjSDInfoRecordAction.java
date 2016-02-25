package com.repair.pj.action.pjSDInfoRecord;
        
import java.util.HashSet;
import java.util.Set;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSp;
import com.repair.pj.service.PjSDInfoRecordService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: MoveStorePjSDInfoRecordAction
* @Description: TODO(移库修改记录表)
* @author lxb
* @version V1.0  
* @date 2015-9-8 下午3:30:32
 */
public class UpdateStorePjSDInfoRecordAction extends BaseAction implements ModelDriven<PjSDInfoRecordSp>{
		private PjSDInfoRecordService pjSDInfoRecordService;
		private PjStoreDynamicInfoService pjStoreDynamicInfoService;
		private PjSDInfoRecordSp pjSDInfoRecordSp = new PjSDInfoRecordSp(); 
		//批量移库获取界面批量ID
		private int[] pjStoreDynamicInfoId;
		@Override
		public String execute() throws Exception {
			//批量移库
			for (int i = 0; i < pjStoreDynamicInfoId.length; i++) {
				//创建配件动态主记录对象
				PjSDInfoRecord pjSDInfoRecord = new PjSDInfoRecord();
				pjSDInfoRecord.setReceivingDeliverStatus(Constants.RECEIVING_DELIVER_STATUS_ZERO);
				pjSDInfoRecord.setStoreUnitProteamStatus(Constants.STORE_UNIT_PROTEAM_STATUS_ZERO);
				pjSDInfoRecord.setRecordTime(Constants.TIME_STAMP_SYSTEM_DATE);
				pjSDInfoRecord.setPjStoreDynamicInfo(pjStoreDynamicInfoService.findById(pjStoreDynamicInfoId[i]));
				if(Constants.STORE_UNIT_PROTEAM_STATUS_ZERO == 0 ){
					 //实例化一个set集合
					Set<PjSDInfoRecordSp> pjSDInfoRecordSpSet = new HashSet<PjSDInfoRecordSp>();
					pjSDInfoRecordSpSet.add(pjSDInfoRecordSp);
					pjSDInfoRecord.setPjSDInfoRecordSps(pjSDInfoRecordSpSet);
				}
				//添加主记录
				pjSDInfoRecordService.save(pjSDInfoRecord);
			}
			return SUCCESS;
		}

	

		public void setPjSDInfoRecordService(PjSDInfoRecordService pjSDInfoRecordService) {
			this.pjSDInfoRecordService = pjSDInfoRecordService;
		}

		
		public void setPjSDInfoRecordSp(PjSDInfoRecordSp pjSDInfoRecordSp) {
			this.pjSDInfoRecordSp = pjSDInfoRecordSp;
		}
		
		public int[] getPjStoreDynamicInfoId() {
			return pjStoreDynamicInfoId;
		}

		public void setPjStoreDynamicInfoId(int[] pjStoreDynamicInfoId) {
			this.pjStoreDynamicInfoId = pjStoreDynamicInfoId;
		}

	

		public void setPjStoreDynamicInfoService(
				PjStoreDynamicInfoService pjStoreDynamicInfoService) {
			this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
		}

		public PjSDInfoRecordSp getModel() {
			return this.pjSDInfoRecordSp;
		}
}
