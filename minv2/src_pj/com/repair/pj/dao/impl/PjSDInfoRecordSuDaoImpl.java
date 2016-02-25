package com.repair.pj.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordSu;
import com.repair.pj.dao.PjSDInfoRecordSuDao;
import com.repair.util.daoSupport.DaoSupport;

/** 
* @ClassName: PjSDInfoRecordSuDaoImpl
* @Description: TODO(主仓库和单位的记录dao层实现层)
* @author lxb
* @version V1.0  
* @date 2015-9-6 下午7:41:22
 */
public class PjSDInfoRecordSuDaoImpl extends DaoSupport<PjSDInfoRecordSu> implements PjSDInfoRecordSuDao{
	
	
	  /**
	   * 	通过相关单位人员名称模糊查找
	   */
	 public List<PjSDInfoRecordSu> findPjSDInfoRecordSuListByCName(String correlationName){
		  return null;
	 }
	
	
}
