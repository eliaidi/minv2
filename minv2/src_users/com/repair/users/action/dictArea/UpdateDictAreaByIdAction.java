package com.repair.users.action.dictArea;

import com.opensymphony.xwork2.ActionSupport;
import com.repair.entity.DictArea;
import com.repair.users.service.DictAreaService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: AddAction
 * @Package com.repair.users.action.dictArea
 * @Description: TODO(�����(dictArea),ͨ��ID�޸����)
 * @author lxb
 * @datetime 2015-8-4 ����2:15
 */
public class UpdateDictAreaByIdAction extends BaseAction{
	private DictArea dictArea;
	private DictAreaService dictAreaService;
	
    @Override
    public String execute() throws Exception {
    	return SUCCESS;
    }
    
	public DictArea getDictArea() {
		return dictArea;
	}
	public void setDictArea(DictArea dictArea) {
		this.dictArea = dictArea;
	}
	public DictAreaService getDictAreaService() {
		return dictAreaService;
	}
	public void setDictAreaService(DictAreaService dictAreaService) {
		this.dictAreaService = dictAreaService;
	}
}
