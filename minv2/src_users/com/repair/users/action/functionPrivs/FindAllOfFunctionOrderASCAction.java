package com.repair.users.action.functionPrivs;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.FunctionPrivs;
import com.repair.users.service.FunctionPrivsService;
import com.repair.util.action.BaseAction;

/** 
* @ClassName: FindAllOfFunctionOrderASCAction
* @Description: TODO(查询所有，按菜单（操作功能）名顺序，升序)
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 下午6:56:39
*/
public class FindAllOfFunctionOrderASCAction extends BaseAction{
	
	private FunctionPrivsService functionPrivsService;

	@Override
	public String execute() throws Exception {
		List<FunctionPrivs> list=functionPrivsService.findAllOfFunctionOrderASC();
		for (FunctionPrivs functionPrivs : list) {
			System.out.println(functionPrivs.getFunctionName()+"----"+functionPrivs.getFunctionOrder());
		}
		return null;
	}
	
	public void setFunctionPrivsService(FunctionPrivsService functionPrivsService) {
		this.functionPrivsService = functionPrivsService;
	}
	
}
