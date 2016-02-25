package com.repair.pj.action.dictJcType;

import java.util.List;
import com.repair.entity.DictJcType;
import com.repair.pj.service.DictJcTypeService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindAllDictJcTypeAction
 * @Description: TODO(查询所有机车类型的action层)
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 下午11:56:10
 */
public class FindAllDictJcTypeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private DictJcTypeService dictJcTypeService;

	@Override
	public String execute() throws Exception {
		List<DictJcType> list = dictJcTypeService.listAll();
		session.setAttribute("dictJcTypeList", list);
		return SUCCESS;
	}

	public DictJcTypeService getDictJcTypeService() {
		return dictJcTypeService;
	}

	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}

}
