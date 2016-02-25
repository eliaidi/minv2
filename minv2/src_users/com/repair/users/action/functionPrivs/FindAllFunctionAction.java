package com.repair.users.action.functionPrivs;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.FunctionPrivs;
import com.repair.users.service.FunctionPrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindAllFunctionAction
* @Description: TODO(获取所有操作功能（菜单）)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午6:56:39
*/
public class FindAllFunctionAction extends BaseAction{
	
	private FunctionPrivsService functionPrivsService;
	
	@Override
	public String execute() throws Exception {
		List<FunctionPrivs> list=functionPrivsService.listAll();
		//将功能表数据存放到session中
		request.setAttribute("functionList", list);
		return SUCCESS;
	}
	
	public void setFunctionPrivsService(FunctionPrivsService functionPrivsService) {
		this.functionPrivsService = functionPrivsService;
	}
	
}
