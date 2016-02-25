package com.repair.pjFix.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.pjFix.dao.PjSDInfoRecordFixDao;

/**
* @ClassName: PjSDInfoRecordFixDao
* @Description: TODO 配件检修记录dao层实现类-配件检修
* @author 周云韬
* @version V1.0  
* @date 2015-9-23 上午10:38:09
 */
public class PjSDInfoRecordFixDaoImpl implements PjSDInfoRecordFixDao{
	
	private HibernateTemplate hibernateTemplate;
	/**
 	 * 通过配件检修记录ID得到动态配件检修记录对象
	 * @return PjSDInfoRecordFix    
	 * @throws
	 */
	public PjSDInfoRecordFix findPjSDInfoRecordFixById(long id){
		return hibernateTemplate.load(PjSDInfoRecordFix.class, id);
	}
	
	/**
	 * 修改配件检修记录
	 * @throws
	 */
	public void updatePjSDInfoRecordFix(PjSDInfoRecordFix fix){
		hibernateTemplate.update(fix);
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
