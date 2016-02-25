package com.repair.pj.service.impl;

import com.repair.entity.PjSDInfoRecord;
import com.repair.pj.dao.PjSDInfoRecordDao;
import com.repair.pj.dto.PjSDInfoRecordSearchDto;
import com.repair.pj.service.PjSDInfoRecordService;
import com.repair.util.serviceSupport.ServiceSupport;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @ClassName: PjSDInfoRecordServiceImpl
 * @Description: TODO(配件动态信息记录的service实现层)
 * @author 周云韬
 * @version V1.0
 * @date 2015-9-1 上午8:47:11
 */
public class PjSDInfoRecordServiceImpl extends ServiceSupport<PjSDInfoRecord> implements PjSDInfoRecordService {
	
	private PjSDInfoRecordDao pjSDInfoRecordDao;

	/**
	 *   多条件查询 动态配件出库入库记录，具体查询条件请参考pj/iframePage/pjSDInfoRecord/pjSDInfoRecordManageIframe.jsp页面
	 *   @param pjSDInfoRecord  动态配件出库入库记录
	 *   @return 动态配件出库入库记录集合（分页模型）
	 */
	public SplitPageModel queryPjSDInfoRecord(PjSDInfoRecordSearchDto dto){
		return pjSDInfoRecordDao.queryPjSDInfoRecord(dto);
	}

	

	public void setPjSDInfoRecordDao(PjSDInfoRecordDao pjSDInfoRecordDao) {
		this.pjSDInfoRecordDao = pjSDInfoRecordDao;
	}
	
}
