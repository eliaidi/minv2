package com.repair.users.action.functionPrivs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.FunctionPrivs;
import com.repair.entity.RoleFunctionPrivs;
import com.repair.entity.RolePrivs;
import com.repair.users.service.FunctionPrivsService;
import com.repair.users.service.RoleFunctionPrivsService;
import com.repair.users.service.RolePrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: ToRoleGrantAction
 * @Description: TODO(转到角色授权页面)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-4 下午6:56:39
 */
public class ToRoleGrantByRoleIdAction extends BaseAction {
	
	private FunctionPrivsService functionPrivsService;
	private RoleFunctionPrivsService roleFunctionPrivsService;
	private RolePrivsService rolePrivsService;
	private long roleId;

	@Override
	public String execute() throws Exception {

		RolePrivs rolePrivs = rolePrivsService.findRolePrivsByIdService(roleId);
		List<FunctionPrivs> grandFunctions = functionPrivsService.findFunctionByParentId(0);
		Map<String, Map<String, List<FunctionPrivs>>> funmap = new LinkedHashMap<String, Map<String, List<FunctionPrivs>>>();
		
		for (FunctionPrivs grandFunction : grandFunctions) {
			String grandFunctionName = grandFunction.getFunctionName();
			
			if (funmap.get(grandFunctionName) == null) {
				funmap.put(grandFunctionName,new LinkedHashMap<String, List<FunctionPrivs>>());
			}
			
			//父级
			List<FunctionPrivs> fatherFunctions = functionPrivsService.findFunctionByParentId(grandFunction.getId());
			
			for (FunctionPrivs fatherFunction : fatherFunctions) {
				
				String fatherFunctionName = fatherFunction.getFunctionName();
				
				if (funmap.get(grandFunctionName).get(fatherFunctionName) == null) {
					funmap.get(grandFunctionName).put(fatherFunctionName,new ArrayList<FunctionPrivs>());
				}
				
				//子级
				List<FunctionPrivs> childFunctions = functionPrivsService.findFunctionByParentId(fatherFunction.getId());
				
				for (FunctionPrivs child : childFunctions) {
					funmap.get(grandFunctionName).get(fatherFunctionName).add(child);
				}
			}
		}

		request.setAttribute("funMap",funmap);
		request.setAttribute("role",rolePrivs);
		
		//查出此角色拥有的权限
		RolePrivs role=rolePrivsService.findRolePrivsByIdService(roleId);
		
		Set<RoleFunctionPrivs> grantRoleFunctions= (role == null ? null :role.getRoleFunctionPrivses());
		request.setAttribute("grantRoleFunctions",grantRoleFunctions);
		
		return Action.SUCCESS;
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

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
