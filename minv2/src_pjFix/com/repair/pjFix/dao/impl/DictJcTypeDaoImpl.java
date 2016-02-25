package com.repair.pjFix.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.DictJcType;
import com.repair.pjFix.dao.DictJcTypeDao;

/**
 * @ClassName: DictJcTypeDaoImpl
 * @Description: TODO 机车类型dao层实现
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 上午11:52:08
 */
public class DictJcTypeDaoImpl implements DictJcTypeDao {
	
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 获得所有机车类型
	 */
	@SuppressWarnings("unchecked")
	public List<DictJcType> findAllDictJcType() {
		return this.hibernateTemplate.find(" from DictJcType");
	}
	
	/**
	 *  通过机车类型ID获取机车类型
	 */
	public DictJcType findDictJcTypeById(long id) {
		DictJcType dictJcType=null;
		List<DictJcType> list=this.hibernateTemplate.find("from DictJcType where id=?", new Object[]{id});
		if(list.size()>0)
		{
			dictJcType=list.get(0);
		}
		return dictJcType;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
