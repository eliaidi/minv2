package com.repair.users.action.usersPrivs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersPrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.users.service.RolePrivsService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;

/**
* @ClassName: QueryUsersAction
* @Description: TODO(通过查询条件查询用户)
* @author 周云韬
* @version V1.0  
* @date 2015-8-19 上午9:44:30
 */
public class QueryUsersAction extends BaseAction implements ModelDriven<UsersPrivs>{
	
	private UsersPrivsService usersPrivsService;
	private RolePrivsService rolePrivsService;
	
	private UsersPrivs usersPrivs=new UsersPrivs();
	
	private Integer roleId;
	private long departId;
	//用来判断查询的是全部、小辅修、中修班组、每个班组的用户
	private String flag;
	
	public void queryUsers(){
		//usersPrivs.setDepartProteamStatus(Constants.PROTEAM_STATU);
	}
	
	//查找用户，返回到部门页面
	public String executeDepart() {
		usersPrivs.setDepartProteamStatus(Constants.DEPART_STATU);
		
		Set<UsersRolePrivs> usersRoleSet=new HashSet<UsersRolePrivs>();
		UsersRolePrivs usersRolePrivs=new UsersRolePrivs();
		if(roleId != null){
			RolePrivs role=rolePrivsService.findRolePrivsByIdService(roleId);
			if(role != null){
				usersRolePrivs.setRolePrivs(role);
				usersRoleSet.add(usersRolePrivs);
			}
		}
		
		usersPrivs.setUsersRolePrivs(usersRoleSet);
		
		PageModel<UsersPrivs> pm=usersPrivsService.findUsersByDictDepartId(departId);
		if("list".equals(flag)){
			request.setAttribute("pm", pm);
			List<RolePrivs> roleList=rolePrivsService.findRolePrivsAllService();
			request.setAttribute("roleList", roleList);
			return SUCCESS;
		}else{
			PageModel<UsersPrivs> pageModel=usersPrivsService.findUsersList(usersPrivs);
			request.setAttribute("pm", pageModel);
			//由于需要通过查询条件  页面显示对应的div，但JS和JSP分离，所有必须存入session
			request.getSession().setAttribute("usersPrivs", usersPrivs);
		}/*else{
			PageModel<UsersPrivs> pm=usersPrivsService.findUsersByDictDepartId(departId);
			HttpServletResponse response=ServletActionContext.getResponse();
			try {
				response.getWriter().write(pm.getDatas().size()+"");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	return null;
		}*/
		List<RolePrivs> roleList=rolePrivsService.findRolePrivsAllService();
		request.setAttribute("roleList", roleList);
		return SUCCESS;
	}
	//查找用户，返回到班组页面
	public String executeProteam() {
		usersPrivs.setDepartProteamStatus(Constants.PROTEAM_STATU);
		
		Set<UsersRolePrivs> usersRoleSet=new HashSet<UsersRolePrivs>();
		UsersRolePrivs usersRolePrivs=new UsersRolePrivs();
		
		if(roleId != null){
			RolePrivs role=rolePrivsService.findRolePrivsByIdService(roleId);
			if(role != null){
				usersRolePrivs.setRolePrivs(role);
				usersRoleSet.add(usersRolePrivs);
			}
		}
		
		usersPrivs.setUsersRolePrivs(usersRoleSet);
		
		PageModel<UsersPrivs> pageModel=null;
		
		if(flag != null){
			if(Constants.BZ_ROOT.equals(flag)){
				//查询全部用户
				pageModel=usersPrivsService.findUsersByDepartOrProteamStatus(Constants.PROTEAM_STATU);
				
			}else if(flag.startsWith(Constants.BZTYPE_)){
				//查询指定班组类型的用户（小辅修、中修）
				int index=flag.indexOf(Constants.BZTYPE_)+Constants.BZTYPE_.length();
				int workFlag=flag.substring(index) != null ? Integer.parseInt(flag.substring(index)) : 0;
				
				pageModel=usersPrivsService.findUsersByProteamWorkFlag(workFlag);
				
			}else if(flag.startsWith(Constants.BZ_)){
				int index=flag.indexOf(Constants.BZ_)+Constants.BZ_.length();
				int id=flag.substring(index) != null ? Integer.parseInt(flag.substring(index)) : 0;
				pageModel= usersPrivsService.findUsersByDictProteamId(id);
			}
		}else{
			pageModel=usersPrivsService.findUsersList(usersPrivs);
			//由于需要通过查询条件  页面显示对应的div，但JS和JSP分离，所有必须存入session
			request.getSession().setAttribute("usersPrivs", usersPrivs);
		}
		
		//查询角色
		List<RolePrivs> roleList=rolePrivsService.findRolePrivsAllService();
		request.setAttribute("roleList", roleList);
		
		request.setAttribute("pm", pageModel);
		return SUCCESS;
	}
	
	//查找用户，返回到部门班组（不知是否正确，需查证？？？）
	public String executeDepartProteam() {
		queryUsers();
		return SUCCESS;
	}

	
	public void setUsersPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public UsersPrivs getModel() {
		return this.usersPrivs;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public UsersPrivs getUsersPrivs() {
		return usersPrivs;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setDepartId(long departId) {
		this.departId = departId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
