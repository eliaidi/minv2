package com.repair.pjFix.action.pjStoreDynamicInfo;

import java.util.List;
import com.repair.entity.DictJcType;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.DictJcTypeService;
import com.repair.pjFix.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: ToAddPjSDInfoForRepairChildIframeAciton
* @Description: TODO 跳至addPjSDInfoForRepairChildIframe.jsp页面
* @author 周云韬
* @version V1.0  
* @date 2015-9-24 下午8:10:19
 */
public class ToAddPjSDInfoForRepairChildIframeAciton extends BaseAction{
	
	private DictJcTypeService dictJcTypeForPjFixService;
	private UsersPrivsService usersPrivsForPjFixService;
	
	private String[] pjdCodes;
	
	@Override
	public String execute() throws Exception {
		List<DictJcType> dictJcTypeList=dictJcTypeForPjFixService.findAllDictJcType();
		
		
		request.setAttribute("dictJcTypeList", dictJcTypeList);	
		
		UsersPrivs loginUsers=getLoginUsers();
		if(loginUsers != null){
			loginUsers=usersPrivsForPjFixService.findUsersById(loginUsers.getId());
		}
		request.setAttribute("loginUsers", loginUsers);	
		
		return SUCCESS;
	}

	public void setDictJcTypeForPjFixService(
			DictJcTypeService dictJcTypeForPjFixService) {
		this.dictJcTypeForPjFixService = dictJcTypeForPjFixService;
	}

	public void setPjdCodes(String[] pjdCodes) {
		this.pjdCodes = pjdCodes;
	}

	public String[] getPjdCodes() {
		return pjdCodes;
	}

	public void setUsersPrivsForPjFixService(
			UsersPrivsService usersPrivsForPjFixService) {
		this.usersPrivsForPjFixService = usersPrivsForPjFixService;
	}
	
}
