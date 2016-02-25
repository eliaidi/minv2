package com.repair.pj.action.dictStorePosition;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: DeleteDictStorePositionAction
 * @Description: TODO(删除配件所在位置/仓库)
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 上午11:34:15
 */
public class DeleteDictStorePositionAction extends BaseAction implements ModelDriven<DictStorePosition>{

	/** @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) */
	private DictStorePositionService dictStorePositionService;
	private DictStorePosition dictStorePosition = new DictStorePosition();

	private String returnUrl;
	
	@Override
	public String execute() throws Exception {
		try {
			DictStorePosition storePosition=dictStorePositionService.findById(dictStorePosition.getId());
			dictStorePositionService.delete(storePosition);
			session.setAttribute("message",Constants.COMMON_MESSAGE_DELETE_SUC);
		} catch (Exception e) {
			session.setAttribute("message",Constants.COMMON_MESSAGE_DELETE_ERROR);
		}
		return SUCCESS;
	}


	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}


	public void setDictStorePosition(DictStorePosition dictStorePosition) {
		this.dictStorePosition = dictStorePosition;
	}

	public DictStorePosition getModel() {
		return this.dictStorePosition;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}


	public String getReturnUrl() {
		return returnUrl;
	}

}
