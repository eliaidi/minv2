package com.repair.users.action.usersPrivs;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.smartTips.SmartTips;

/**
* @ClassName: FindUsersListByNameOrPyAction
* @Description: TODO	通过拼音或名字模糊查询（不区分大小写）
* @author 周云韬
* @version V1.0  
* @date 2015-9-17 下午3:46:37
 */
public class FindUsersListByNameOrPyAction extends BaseAction{
	
	private UsersPrivsService usersPrivsService;
	
	private String py;
	
	@Override
	public String execute() throws Exception {
		
		List<UsersPrivs> list=usersPrivsService.findUsersListByPjNameOrPy(py);
		
		List<SmartTips> tempList=new ArrayList<SmartTips>();
		for (UsersPrivs users : list) {
			tempList.add(new SmartTips(users.getId()+"",users.getUserName(),users.getPy()));
		}
		
		response.setCharacterEncoding(Constants.RESPONSE_DEFAULT_ENCODING);
		pw.write(new Gson().toJson(tempList));
		return null;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}
	
}
