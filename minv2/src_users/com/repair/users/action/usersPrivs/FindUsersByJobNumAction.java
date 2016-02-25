package com.repair.users.action.usersPrivs;

import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindUsersByJobNumAction
 * @Description: TODO(通过jobNum查询数据，AJAX)
 * @author 廖雪冰
 * @version V1.0
 * @date 2015-8-15 下午3:54:15
 */
public class FindUsersByJobNumAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService;
	private UsersPrivs usersPrivs;
	
	public String jobNum;

	//通过工号，找用户
	public void findUsersByJobNum() {

		usersPrivs = usersPrivsService.findUsersByJobNum(this.jobNum);
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_TEXT);

		if (usersPrivs != null) {
			pw.write(Constants.USERS_JOB_NUM_IN);
		}
	}

	//返回到，部门页面
	public String executeDepart() {
		findUsersByJobNum();
		return null;
	}

	//返回到，班组页面
	public String executeProteam() {
		findUsersByJobNum();
		return null;
	}

	//返回到，部门班组页面，（不知道是否正确，要查证？？？）
	public String executeDepartProteam() {
		findUsersByJobNum();
		return null;
	}

	public UsersPrivsService getUsersPrivsService() {
		return usersPrivsService;
	}

	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}

	public UsersPrivs getUsersPrivs() {
		return usersPrivs;
	}

	public void setUsersPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

}
