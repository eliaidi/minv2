package com.repair.pj.service;

import com.repair.entity.PjSDInfoRecord;
import com.repair.pj.dto.PjSDInfoRecordSearchDto;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjSDInfoRecordService
* @Description: TODO 配件仓库动态信息记录表，出库入库记录  service层
* @author 周云韬
* @version V1.0  
* @date 2015-8-31 下午2:55:38
 */
public interface PjSDInfoRecordService extends BaseDao<PjSDInfoRecord>{
	
	/**
	 *   多条件查询 动态配件出库入库记录，具体查询条件请参考pj/iframePage/pjSDInfoRecord/pjSDInfoRecordManageIframe.jsp页面
	 *   @param pjSDInfoRecord  动态配件出库入库记录
	 *   @return 动态配件出库入库记录集合（分页模型）
	 */
	public SplitPageModel queryPjSDInfoRecord(PjSDInfoRecordSearchDto dto);
	
	
}
