package com.repair.pj.action.pjStoreDynamicInfo;

import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * 
* @ClassName: FindPjStoreDynamicInfoByPjdCodeAction
* @Description: TODO(配件编码的唯一性)
* @author lxb
* @version V1.0  
* @date 2015-9-14 下午2:49:36
 */
public class FindPjStoreDynamicInfoByPjdCodeAction extends BaseAction{
		private PjStoreDynamicInfoService pjStoreDynamicInfoService;
		private String pjdCode;
		@Override
		public String execute() throws Exception {
			PjStoreDynamicInfo pjStoreDynamicInfo=pjStoreDynamicInfoService.findPjStoreDynamicInfoByPjdCode(this.pjdCode);
			if(pjStoreDynamicInfo !=null){
				response.setHeader("content-type","text/html; charset=utf-8");
				response.getWriter().write("配件编码已存在，请重新填写配件编码！");
			}
			return null;
		}
		
		public void setPjStoreDynamicInfoService(
				PjStoreDynamicInfoService pjStoreDynamicInfoService) {
			this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
		}
		
		public void setPjdCode(String pjdCode) {
			this.pjdCode = pjdCode;
		}
		
		
}
