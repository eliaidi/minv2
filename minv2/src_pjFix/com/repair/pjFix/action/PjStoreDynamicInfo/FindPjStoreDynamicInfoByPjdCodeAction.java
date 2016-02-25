package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pjFix.service.PjStoreDynamicInfoService;

/**
* @ClassName: FindPjStoreDynamicInfoByPjdCodeAction
* @Description: TODO(通过配件编码获取信息)
* @author lxb
* @version V1.0  
* @date 2015-9-22 下午3:43:07
 */
public class FindPjStoreDynamicInfoByPjdCodeAction extends ActionSupport{
	
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	//获取配件编码数组
	private String[] pjdCodes;
	
	@Override
	public String execute() throws Exception {
		//判断是否为空
		if(pjdCodes == null)
		{
			return null;
		}
		//存在的配件
		List<PjStoreDynamicInfo>  existPj = new ArrayList<PjStoreDynamicInfo>();
		List<String>  notExistPjdCode = new ArrayList<String>();
		
		for (String pjdCode:pjdCodes) {
			PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoByPjdCode(pjdCode);
			if(psdi !=null ){
				if(psdi.getPjdStatus() != Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS_TWO){
					existPj.add(psdi);
				}
				
			}else{
				notExistPjdCode.add(pjdCode);
			}
		}
		
		ServletActionContext.getRequest().setAttribute("existPj", existPj);
		ServletActionContext.getRequest().setAttribute("notExistPjdCode", notExistPjdCode);
		
		return Action.SUCCESS;
	}
	
	public PjStoreDynamicInfoService getPjSDInfoForPjFixService() {
		return pjSDInfoForPjFixService;
	}

	public void setPjSDInfoForPjFixService(
			PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}

	public void setPjdCodes(String[] pjdCodes) {
		this.pjdCodes = pjdCodes;
	}
	
	public String[] getPjdCodes() {
		return pjdCodes;
	}
	
}	
