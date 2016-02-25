package com.repair.users.action.usersPrivs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.entity.DictionaryBase;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.DictProteamService;
import com.repair.users.service.RolePrivsService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.page.PageModel;

/**
 * @ClassName: FindUsersByDictProteamIdAction
 * @Description: TODO(通过班组D寻找用户)
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-4 上午10:45:48
 */
public class FindUsersByDictProteamIdAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService;
	private DictProteamService	dictProteamService;
	private RolePrivsService rolePrivsService;
	
	//用来判断查询的是全部、小辅修、中修班组、每个班组的用户
	private String flag;
	
	@Override
	public String execute() throws Exception {
	
		List<UsersPrivs> usersList=new ArrayList<UsersPrivs>();
		
		PageModel<UsersPrivs> pageModel=null;
		if(flag != null){
			
			if(Constants.BZ_ROOT.equals(flag)){
				//查询全部用户
				pageModel=usersPrivsService.findUsersByDepartOrProteamStatus(Constants.PROTEAM_STATU);
				
			}else if(flag.startsWith(Constants.BZTYPE_)){
				
				//查询指定班组类型的用户（小辅修、中修）
				int index=flag.indexOf(Constants.BZTYPE_)+Constants.BZTYPE_.length();
				int workFlag=flag.substring(index) != null ? Integer.parseInt(flag.substring(index)) : 0;
				
				List<DictProteam> proteamList=dictProteamService.findDictProteamByWorkFlag(workFlag);
				
				for (DictProteam dictProteam : proteamList) {
					usersList.addAll(dictProteam.getUsersPrivses()  );
				}
				
				List<DictionaryBase> proteamDictionaryList=
					( List<DictionaryBase>) ((Map)servletContext.getAttribute("cache")).get("SYS_PROTEAM");
				
				//小辅修、中修班组，workflag为3的
				proteamList=dictProteamService.findDictProteamByWorkFlag(Integer.parseInt((proteamDictionaryList.get(3).getValue())));
				
				for (DictProteam dictProteam : proteamList) {
					usersList.addAll(dictProteam.getUsersPrivses()  );
				}
				
			}else if(flag.startsWith(Constants.BZ_)){
				
				int index=flag.indexOf(Constants.BZ_)+Constants.BZ_.length();
				int id=flag.substring(index) != null ? Integer.parseInt(flag.substring(index)) : 0;
				 usersPrivsService.findUsersByDictProteamId(id);
				 
			}
		}
		
		//查询角色
		List<RolePrivs> roleList=rolePrivsService.findRolePrivsAllService();
		
		ServletActionContext.getRequest().setAttribute("roleList", roleList);
		
		//由于JS与 JSP分离，要在JS中使用，必须存入session
		PageModel<UsersPrivs> pg=new PageModel<UsersPrivs>();
		pg.setCount(usersList.size());
		pg.setDatas(usersList);
		request.setAttribute("pg", pg);
		
		return Action.SUCCESS;
		
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

}
