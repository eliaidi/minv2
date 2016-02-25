package com.repair.pjFix.action.pjSDInfoRecordFix.fixUsers;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjSDInfoRecordFixService;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: UpdatePjSDInfoRecordFixAction
 * @Description: TODO(检修记录是否启用)
 * @author lxb
 * @version V1.0
 * @date 2015-10-9 下午10:45:05
 */
public class UpdateAllPjSDInfoRecordFixAction extends BaseAction {
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	private PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService;
	
	// 是否禁用
	private int fixItemStatus;
	// 动态配件ID
	private int psdiId;

	@Override
	public String execute() throws Exception {
		PjStoreDynamicInfo pjStoreDynamicInfo = pjSDInfoForPjFixService.findPjStoreDynamicInfoById(psdiId);
		List<PjSDInfoRecord> list = PjSDInfoRecordUtil.listPjSDInfoFixMainRecord(pjStoreDynamicInfo, 1);
		if (list.size() > 0) {
			PjSDInfoRecord pjSDInfoRecord = list.get(0);
			Set<PjSDInfoRecordFix> set = pjSDInfoRecord.getPjSDInfoRecordFixs();
			Iterator<PjSDInfoRecordFix> ite = set.iterator();
			while (ite.hasNext()) {
				PjSDInfoRecordFix pjSDInfoRecordFix = ite.next();
				if (pjSDInfoRecordFix.getPjFixItem().getDefaultValue() != null) {
					pjSDInfoRecordFix.setFixItemStatus(fixItemStatus);
					pjSDInfoRecordFixForPjFixService.updatePjSDInfoRecordFix(pjSDInfoRecordFix);
				}
			}
		}
		
		return null;
	}

	public PjStoreDynamicInfoService getPjSDInfoForPjFixService() {
		return pjSDInfoForPjFixService;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public int getPsdiId() {
		return psdiId;
	}

	public void setPsdiId(int psdiId) {
		this.psdiId = psdiId;
	}

	public int getFixItemStatus() {
		return fixItemStatus;
	}

	public void setFixItemStatus(int fixItemStatus) {
		this.fixItemStatus = fixItemStatus;
	}

	public PjSDInfoRecordFixService getPjSDInfoRecordFixForPjFixService() {
		return pjSDInfoRecordFixForPjFixService;
	}

	public void setPjSDInfoRecordFixForPjFixService(
			PjSDInfoRecordFixService pjSDInfoRecordFixForPjFixService) {
		this.pjSDInfoRecordFixForPjFixService = pjSDInfoRecordFixForPjFixService;
	}
	
}
