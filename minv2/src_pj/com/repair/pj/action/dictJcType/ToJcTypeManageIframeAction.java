package com.repair.pj.action.dictJcType;

import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.repair.entity.DictJcType;
import com.repair.pj.service.DictJcTypeService;
import com.repair.pojoUtil.PjSDInfoUtil;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: ToJcTypeManageIframeAction
 * @Description: TODO
 *               跳至配件动态信息管理->车型分类（pj/iframePage/storeDynamicInfo/unitManageIframe.jsp）
 *               页面，为树形菜单提供数据
 * @author 周云韬
 * @version V1.0
 * @date 2015-9-8 下午4:57:34
 */
public class ToJcTypeManageIframeAction extends BaseAction {

	private DictJcTypeService dictJcTypeService;

	@Override
	public String execute() throws Exception {

		List<DictJcType> list = dictJcTypeService.listAll();

		// 车型动态配件个数
		Map<String, Integer> jcTypeDcMap = PjSDInfoUtil.getDynamicCountByDictJcTypeList(list);

		session.setAttribute("jcTypeList", list);
		session.setAttribute("jcTypeDcMap", jcTypeDcMap);
		return Action.SUCCESS;
	}

	public void setDictJcTypeService(DictJcTypeService dictJcTypeService) {
		this.dictJcTypeService = dictJcTypeService;
	}

}
