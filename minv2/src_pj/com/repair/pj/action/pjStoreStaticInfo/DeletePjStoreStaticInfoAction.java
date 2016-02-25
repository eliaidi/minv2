package com.repair.pj.action.pjStoreStaticInfo;

import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: DeletePjStoreStaticInfoAction
 * @Description: TODO(实现deletePjStoreStaticInfo方法，删除数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-9-1 下午02:08:12
 */
public class DeletePjStoreStaticInfoAction extends BaseAction {

	private PjStoreStaticInfoService pjStoreStaticInfoService;
	// 删除用户成功 用户管理子页面的URL
	private String returnUrl;
	// 用户ID数组，一次性删除多个用户
	private long[] staticInfoId;

	// 普通删除
	public String execute() throws Exception {
		//成功个数
		int sucDelCount=0;
		//失败个数
		int errorCount=0;
		for (long id : staticInfoId) {
			PjStoreStaticInfo pjStoreStaticInfo = pjStoreStaticInfoService.findById(id);
			if (pjStoreStaticInfo != null) {
				
				
				Set<PjStoreStaticInfo> childPjSet=pjStoreStaticInfo.getChildPjStoreStaticInfos();
				if (childPjSet != null && childPjSet.size()>0) {
					errorCount+=1;
				} else {
					//拿到父级配件
					PjStoreStaticInfo parentPj=pjStoreStaticInfo.getParentPjStoreStaticInfo();
					if(parentPj != null){
						//移除关联关系
						parentPj.getChildPjStoreStaticInfos().remove(pjStoreStaticInfo);
					}
					
					pjStoreStaticInfo.setParentPjStoreStaticInfo(null);
					pjStoreStaticInfoService.delete(pjStoreStaticInfo);
					sucDelCount += 1;
				}
			}
		}
		String msg="删除【成功个数："+sucDelCount+"】:【"+"失败个数："+errorCount+"(存在子级配件)】";
		session.setAttribute("message", msg);
		return Action.SUCCESS;
	}



	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}



	public long[] getStaticInfoId() {
		return staticInfoId;
	}



	public void setStaticInfoId(long[] staticInfoId) {
		this.staticInfoId = staticInfoId;
	}

	

}
