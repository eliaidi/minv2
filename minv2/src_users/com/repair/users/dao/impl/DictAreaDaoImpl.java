package com.repair.users.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.DictArea;
import com.repair.users.dao.DictAreaDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * ClassName: DictAreaDaoImpl
 * @Package com.repair.users.impl
 * @Description: TODO
 * @author lxb
 * @datetime 2015-8-3 上午11:15
 */
public class DictAreaDaoImpl extends DaoSupport<DictArea> implements DictAreaDao {
	
	/**通过机务段名称删除机务段*/
	public void deleteDictAreaByAreaNameDao(String areaName) {
		@SuppressWarnings("unchecked")
		List<DictArea> list = this.hibernateTemplate.find(
				"from DictArea where areaName=?", new Object[] { areaName });
		DictArea dictArea = new DictArea();
		if (list.size() > 0) {
			dictArea = list.get(0);
		}
		this.hibernateTemplate.delete(dictArea);
	}

	/**通过机务段代码删除机务段*/
	public void deleteDictAreaByJwdCodeDao(String jwdCode) {
		@SuppressWarnings("unchecked")
		List<DictArea> list = this.hibernateTemplate.find(
				"from DictArea where jwdCode=?", new Object[] { jwdCode });
		DictArea dictArea = new DictArea();
		if (list.size() > 0) {
			dictArea = list.get(0);
		}
		this.hibernateTemplate.delete(dictArea);
	}

	
	/** 通过jwdCode进行查询*/
	@SuppressWarnings("unchecked")
	public DictArea findDictAreaByJwdCodeDao(String jwdCode) {
		List<DictArea> list = this.hibernateTemplate.find(
				" from DictArea where jwdCode=?", new Object[] { jwdCode });
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/** 通过areaName进行查询*/
	@SuppressWarnings("unchecked")
	public DictArea findDictAreaByNameDao(String areaName) {
		List<DictArea> list = this.hibernateTemplate.find(
				" from DictArea where areaName=?", new Object[] { areaName });
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	



}
