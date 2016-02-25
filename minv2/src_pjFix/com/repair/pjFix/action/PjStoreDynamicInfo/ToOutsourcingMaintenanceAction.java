package com.repair.pjFix.action.pjStoreDynamicInfo;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
* @ClassName: ToOutsourcingMaintenanceAction
* @Description: TODO(跳转到委外检修窗口)
* @author lxb
* @version V1.0  
* @date 2015-10-9 上午9:49:57
 */
public class ToOutsourcingMaintenanceAction extends ActionSupport{
	
	private Long id;
	private String pjdCode;
	private String pjName;
	
	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().setAttribute("id", id);
		ServletActionContext.getRequest().setAttribute("pjdCode", pjdCode);
		ServletActionContext.getRequest().setAttribute("pjName", pjName);
		
		return SUCCESS;
	}
	
	public String getPjdCode() {
		return pjdCode;
	}
	
	public void setPjdCode(String pjdCode) {
		this.pjdCode = pjdCode;
	}
	
	public String getPjName() {
		return pjName;
	}
	
	public void setPjName(String pjName) {
		this.pjName = pjName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
