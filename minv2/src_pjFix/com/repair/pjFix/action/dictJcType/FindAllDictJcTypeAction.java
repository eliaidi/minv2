package com.repair.pjFix.action.dictJcType;

import java.util.List;
import com.google.gson.Gson;
import com.repair.entity.DictJcType;
import com.repair.pjFix.service.DictJcTypeService;
import com.repair.util.action.BaseAction;
import com.repair.util.ganged.GangedUtil;
/**
* @ClassName: FindAllDictJcTypeAction
* @Description: TODO(查找所有的机车类型)
* @author lxb
* @version V1.0  
* @date 2015-9-23 上午9:07:03
 */
public class FindAllDictJcTypeAction extends BaseAction{
	private DictJcTypeService dictJcTypeForPjFixService;
	@Override
	public String execute() throws Exception {
		//显示机车类型
		List<DictJcType> list = dictJcTypeForPjFixService.findAllDictJcType();
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(new Gson().toJson(GangedUtil.convert(list, "id", "jcType")));
		return null;
	}
	public void setDictJcTypeForPjFixService(
			DictJcTypeService dictJcTypeForPjFixService) {
		this.dictJcTypeForPjFixService = dictJcTypeForPjFixService;
	}
}
