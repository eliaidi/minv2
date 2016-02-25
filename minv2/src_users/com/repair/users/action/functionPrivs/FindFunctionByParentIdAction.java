package com.repair.users.action.functionPrivs;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.FunctionPrivs;
import com.repair.users.service.FunctionPrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindFunctionByParentIdAction
* @Description: TODO(ͨ��˵����������ܣ�����Id��ȡ�˵���Ϣ)
* @author �����
* @version V1.0  
* @date 2015-8-4 ����6:56:39
*/
public class FindFunctionByParentIdAction extends BaseAction{
	
	private FunctionPrivsService functionPrivsService;
	private FunctionPrivs functionPrivs;
	
	@Override
	public String execute() throws Exception {
//		List<FunctionPrivs> list=functionPrivsService.findFunctionByParentId(functionPrivs.getParentId());
//		
//		for (FunctionPrivs fp : list) {
//			System.out.println("������ƣ�"+fp.getFunctionName());
//			System.out.println("��������"+fp.getFunctionOrder());
//			System.out.println("��ע��"+fp.getRemark());
//		}
		
		return null;
	}
	
	public void setFunctionPrivsService(FunctionPrivsService functionPrivsService) {
		this.functionPrivsService = functionPrivsService;
	}
	public void setFunctionPrivs(FunctionPrivs functionPrivs) {
		this.functionPrivs = functionPrivs;
	}
	
}
