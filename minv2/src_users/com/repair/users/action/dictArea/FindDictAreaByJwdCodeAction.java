package com.repair.users.action.dictArea;

import com.repair.entity.DictArea;
import com.repair.users.service.DictAreaService;
import com.repair.util.action.BaseAction;

/**
 * ClassName: AddAction
 * @Package com.repair.users.action.dictArea
 * @Description: TODO(地区表(dictArea),通过jwdCode查询数据)
 * @author lxb
 * @datetime 2015-8-4 下午2:15
 */
public class FindDictAreaByJwdCodeAction extends BaseAction{
	private DictArea dictArea;
	private DictAreaService dictAreaService;
	
    @Override
    public String execute() throws Exception {
		System.out.println("通过jwdCode查询dictArea进行中....");
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
