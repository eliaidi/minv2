package com.repair.users.action.roleFunctionPrivs;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.FunctionPrivs;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.entity.RolePrivs;
import com.repair.users.service.FunctionPrivsService;
import com.repair.users.service.RoleFunctionPrivsService;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: RoleGrantAction
* @Description: TODO(为指定的角色授权的action，需要指定角色ID和功能ID列表向role_function_privs表插入数据)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-20 下午07:07:44
*/
public class RoleGrantAction extends BaseAction{
	//角色ID
	private long roleId;
	//功能ID数组-->一个角色对应多个功能
	private long[] functionId;
	
	private RoleFunctionPrivsService roleFunctionPrivsService;
	private RolePrivsService rolePrivsService;
	private FunctionPrivsService functionPrivsService;
	
	@Override
	public String execute() throws Exception {
		
		//删除角色功能表中已经存在的记录
		roleFunctionPrivsService.delRoleFunctionByRole_privs_id(roleId);
		
		for (long fid : functionId) {
			RoleFunctionPrivs roleFunctionPrivs=new RoleFunctionPrivs();
			RolePrivs rolePrivs=rolePrivsService.findRolePrivsByIdService(roleId);
			FunctionPrivs functionPrivs=functionPrivsService.findById(fid);
			
			roleFunctionPrivs.setRolePrivs(rolePrivs);
			roleFunctionPrivs.setFunctionPrivs(functionPrivs);
			roleFunctionPrivsService.save(roleFunctionPrivs);
		}
		
		response.setCharacterEncoding("UTF-8");
		pw.write("角色授权成功");
		return null;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	public void setFunctionId(long[] functionId) {
		this.functionId = functionId;
	}

	public void setRoleFunctionPrivsService(
			RoleFunctionPrivsService roleFunctionPrivsService) {
		this.roleFunctionPrivsService = roleFunctionPrivsService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public void setFunctionPrivsService(FunctionPrivsService functionPrivsService) {
		this.functionPrivsService = functionPrivsService;
	}
	
}
