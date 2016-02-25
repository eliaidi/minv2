package com.repair.pj.action.pjStoreDynamicInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.constant.MessageConstants;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: DeletePjStoreDynamicInfoAction
 * @Description: TODO(删除配件动态信息通过id，命名中缺少后缀ById)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午10:04:11
 */
public class DeletePjStoreDynamicInfoAction extends BaseAction implements ModelDriven<PjStoreDynamicInfo> {

	private PjStoreDynamicInfo pjStoreDynamicInfo = new PjStoreDynamicInfo();
	private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	private long[] ids;
	private String returnUrl;

	@Override
	public String execute() throws Exception {
		try {
			if(ids != null){
				for (long id : ids) {
					PjStoreDynamicInfo storeDynamicInfo = pjStoreDynamicInfoService.findById(id);
					if (storeDynamicInfo != null) {
						pjStoreDynamicInfoService.delete(storeDynamicInfo);
					}
				}
			}else {
				PjStoreDynamicInfo storeDynamicInfo = pjStoreDynamicInfoService.findById(pjStoreDynamicInfo.getId());
				if (storeDynamicInfo != null) {
					pjStoreDynamicInfoService.delete(storeDynamicInfo);
				}
			}
			writeJson(MessageConstants.ERRCODE_NOT_ERROR, MessageConstants.MSG_OPERATOR_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			writeJson(MessageConstants.ERRCODE_EXCEPTION, MessageConstants.MSG_OPERATOR_ERROR);
		}
		
		return null;
	}

	public PjStoreDynamicInfo getModel() {
		return this.pjStoreDynamicInfo;
	}

	public PjStoreDynamicInfoService getPjStoreDynamicInfoService() {
		return pjStoreDynamicInfoService;
	}

	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}

	
	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
	
	

}
