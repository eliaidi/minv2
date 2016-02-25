package com.repair.users.action.usersPrivs;

import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindUsersByCardNumAction
 * @Description: TODO(通过查找用户卡号查询用户数据)
 * @author lxb
 * @version V1.0
 * @date 2015-8-15 下午6:43:10
 */
public class FindUsersByCardNumAction extends BaseAction {
	
	private UsersPrivsService usersPrivsService;
	private UsersPrivs usersPrivs;
	
	private String cardNum;

	//查找用户卡号
	public void findUsersCardNum() {
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_TEXT);
		usersPrivs = usersPrivsService.findUsersByCardNum(this.cardNum);

		if ("".equals(this.cardNum)) {
			pw.write(Constants.USERS_CARD_NUM_NOT_NULL);
		}
		if (usersPrivs != null) {
			pw.write(Constants.USERS_CARD_NUM_IN);
		}
	}

	//部门子页面-查找用户卡号
	public String executeDepart() {
		findUsersCardNum();
		return null;
	}

	//班组子页面-查找用户卡号
	public String executeProteam() {
		findUsersCardNum();
		return null;
	}

	//部门班组-查找用户卡号（不知是否正确，需查证？？？）
	public String executeDepartProteam() {
		findUsersCardNum();
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

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public void setUsersPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

}
