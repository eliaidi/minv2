package com.repair.pj.action.dictStorePosition;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: AddDictStorePositionAction
 * @Description: TODO(添加配件所在位置/仓库)
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 上午11:33:34
 */
public class AddDictStorePositionAction extends BaseAction implements ModelDriven<DictStorePosition>{

	private static final long serialVersionUID = 1L;
	
	private DictStorePositionService dictStorePositionService;
	private DictStorePosition dictStorePosition = new DictStorePosition();
	
	@Override
	public String execute() throws Exception {
		try {
			dictStorePositionService.save(dictStorePosition);
			session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_SUC);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Constants.COMMON_MESSAGE_ADD_ERROR);
		}
		return SUCCESS;
	}


	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public DictStorePosition getModel() {
		return this.dictStorePosition;
	}

}
