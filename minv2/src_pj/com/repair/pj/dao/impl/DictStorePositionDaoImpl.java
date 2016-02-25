package com.repair.pj.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.DictStorePosition;
import com.repair.pj.dao.DictStorePositionDao;
import com.repair.util.StringUtil;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @ClassName: DictStorePositionDaoImpl
 * @Description: TODO(配件所在位置/仓库表 DAO层实现层)
 * @author 廖雪冰
 * @version V1.0
 * @date 2015-8-28 下午5:04:29
 */
public class DictStorePositionDaoImpl extends DaoSupport<DictStorePosition> implements DictStorePositionDao {

	

	/**
	 * 通过仓库（所在位置）名称模糊查询
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findDictStorePositionByName(String storePositionName) {
		return this.hibernateTemplate.find(" from DictStorePosition where storePositionName= ? ",new Object[] { storePositionName });
	}

	/**
	 * 通过仓库（位置）类型 查询
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findDictStorePositionByType(int storePositionType) {
		return this.hibernateTemplate.find(" from DictStorePosition where storePositionType = ?",new Object[] { storePositionType });
	}

	/**
	 * 通过机务段(地区)ID进行查询
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findDictStorePositionByDictAreaId(String dictAreaId) {
		return this.hibernateTemplate.find(" from DictStorePosition where dictArea.id = ?",new Object[] { dictAreaId });
	}

	
	/**
	 * 通过查询条件查询仓库集合，具体查询请参考pj/iframePage/storePosition/
	 * storePositionManagerIframe.jsp页面 配件所在位置分页
	 */
	@SuppressWarnings("unchecked")
	public SplitPageModel queryDictStorePosition(DictStorePosition dictStorePosition) {
		StringBuffer hql = new StringBuffer();
		List params = new ArrayList();
		hql.append("from DictStorePosition where 1=1 ");
		if (StringUtil.isNotBlank(dictStorePosition.getStorePositionName())) {
			hql.append(" and storePositionName like ? ");
			params.add("%" + dictStorePosition.getStorePositionName() + "%");
		}
		if (dictStorePosition.getDictArea() != null&& StringUtil.isNotBlank(dictStorePosition.getDictArea().getId())) {
			hql.append(" and dictArea.id = ? ");
			params.add(dictStorePosition.getDictArea().getId());
		}
		if (dictStorePosition.getStorePositionType() != -1) {
			hql.append(" and storePositionType = ? ");
			params.add(dictStorePosition.getStorePositionType());
		}
		hql.append(" order by id desc ");

		return splitPageDao.queryList(hql.toString(), params, dictStorePosition.getPageNo(), dictStorePosition.getPageSize());
	}



	

}
