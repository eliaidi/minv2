package com.repair.pj.dao;

import java.util.List;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSu;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: PjSDInfoRecordSuDao
* @Description: TODO(主仓库和单位的记录dao层)
* @author lxb
* @version V1.0  
* @date 2015-9-6 下午7:39:39
 */
public interface PjSDInfoRecordSuDao extends BaseDao<PjSDInfoRecordSu>{
	/**
	
	  
	  
	  /**
	   * 	通过相关单位人员名称模糊查找
	   */
	  public List<PjSDInfoRecordSu> findPjSDInfoRecordSuListByCName(String correlationName);
}
