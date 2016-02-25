package com.repair.pj.action.pjSDInfoRecord;

import java.util.List;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictStorePosition;
import com.repair.pj.dto.PjSDInfoRecordSearchDto;
import com.repair.pj.service.DictStorePositionService;
import com.repair.pj.service.PjSDInfoRecordService;
import com.repair.util.action.BaseAction;
import com.repair.util.splitPage.SplitPageModel;

/**
 * 
* @ClassName: QueryPjSDInfoRecordAction
* @Description: TODO	配件出入库记录查询
* @author 周云韬
* @version V1.0  
* @date 2015-9-11 下午2:28:39
 */
public class QueryPjSDInfoRecordAction extends BaseAction  implements ModelDriven<PjSDInfoRecordSearchDto>{
	private PjSDInfoRecordService pjSDInfoRecordService;
	private DictStorePositionService dictStorePositionService;
	private PjSDInfoRecordSearchDto dto=new PjSDInfoRecordSearchDto();
	
	@Override
	public String execute() throws Exception {
		SplitPageModel sp=pjSDInfoRecordService.queryPjSDInfoRecord(dto);
		request.setAttribute("sp", sp);
		
		List<DictStorePosition> storePositionList=dictStorePositionService.listAll();
		request.setAttribute("storePositionList", storePositionList);
		
		request.setAttribute("dto", dto);
		return SUCCESS;
	}
	
	public void setPjSDInfoRecordService(PjSDInfoRecordService pjSDInfoRecordService) {
		this.pjSDInfoRecordService = pjSDInfoRecordService;
	}

	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}

	public PjSDInfoRecordSearchDto getModel() {
		return dto;
	}
}
