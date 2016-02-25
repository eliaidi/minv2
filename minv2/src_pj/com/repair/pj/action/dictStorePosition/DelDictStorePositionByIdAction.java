package com.repair.pj.action.dictStorePosition;

import com.repair.entity.DictStorePosition;
import com.repair.pj.service.DictStorePositionService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: DelDictStorePositionByIdAction
 * @Description: TODO(删除仓库位置action层)
 * @author lxb
 * @version V1.0
 * @date 2015-9-6 上午8:36:55
 */
public class DelDictStorePositionByIdAction extends BaseAction {
	private DictStorePositionService dictStorePositionService;
	private long dictStorePositionId;

	@Override
	public String execute() throws Exception {
		try {
			DictStorePosition sp=dictStorePositionService.findById(dictStorePositionId);
			if(sp != null){
				dictStorePositionService.delete(sp);
			}
			
			session.setAttribute("message", "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", "删除失败，请联系管理员！！");
		}
		return SUCCESS;
	}

	
	public void setDictStorePositionId(long dictStorePositionId) {
		this.dictStorePositionId = dictStorePositionId;
	}


	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

}
