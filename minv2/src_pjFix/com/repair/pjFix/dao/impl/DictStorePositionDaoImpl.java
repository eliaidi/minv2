package com.repair.pjFix.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.DictStorePosition;
import com.repair.pjFix.dao.DictStorePositionDao;
import com.repair.util.StringUtil;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
 * @ClassName: DictStorePositionDaoImpl
 * @Description: TODO(配件所在位置/仓库表 DAO层实现层)
 * @author 廖雪冰
 * @version V1.0
 * @date 2015-8-28 下午5:04:29
 */
public class DictStorePositionDaoImpl implements DictStorePositionDao {
	
	private HibernateTemplate hibernateTemplate;
	
	private SplitPageDao splitPageDao;
	/**
	 * 通过仓库（所在位置）名称模糊查询
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findDictStorePositionByName(String storePositionName) {
		return this.getHibernateTemplate().find(" from DictStorePosition where storePositionName= ? ",new Object[] { storePositionName });
	}

	/**
	 * 通过仓库（位置）类型 查询
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findDictStorePositionByType(int storePositionType) {
		return this.getHibernateTemplate().find(" from DictStorePosition where storePositionType = ?",new Object[] { storePositionType });
	}

	/**
	 * 通过机务段(地区)ID进行查询
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findDictStorePositionByDictAreaId(String dictAreaId) {
		return this.getHibernateTemplate().find(" from DictStorePosition where dictArea.id = ?",new Object[] { dictAreaId });
	}

	/**
	 * 获得所有仓库（所在位置）信息
	 */
	@SuppressWarnings("unchecked")
	public List<DictStorePosition> findAllDictStorePosition() {
		return this.getHibernateTemplate().find(" from DictStorePosition ");
	}

	/**
	 * 通过查询条件查询仓库集合，具体查询请参考pj/iframePage/storePosition/
	 * storePositionManagerIframe.jsp页面
	 * 配件所在位置分页
	 */
	@SuppressWarnings("unchecked")
	public SplitPageModel queryDictStorePosition(DictStorePosition dictStorePosition) {
		StringBuffer hql = new StringBuffer();
		List params = new ArrayList();
		hql.append("from DictStorePosition where 1=1 ");
		if(StringUtil.isNotBlank(dictStorePosition.getStorePositionName())){
			hql.append(" and storePositionName like ? ");
			params.add("%"+dictStorePosition.getStorePositionName()+"%");
		}
		if(dictStorePosition.getDictArea()!=null && StringUtil.isNotBlank(dictStorePosition.getDictArea().getId())){
			hql.append(" and dictArea.id = ? ");
			params.add(dictStorePosition.getDictArea().getId());
		}
		
		if(dictStorePosition.getStorePositionType()!= -1){
			hql.append(" and storePositionType = ? ");
			params.add(dictStorePosition.getStorePositionType());
		}
		hql.append(" order by id desc ");
		
		return splitPageDao.queryList(hql.toString(), params,dictStorePosition.getPageNo(),dictStorePosition.getPageSize());
	}

	/**
	 * 修改配件仓库(所在位置)
	 */
	public void updateDictStorePosition(DictStorePosition storePosition) {
		this.getHibernateTemplate().update(storePosition);
	}

	/**
	 * 删除配件仓库(所在位置)
	 */
	public void deleteDictStorePosition(DictStorePosition storePosition) {
		this.getHibernateTemplate().delete(storePosition);
	}

	/**
	 * 添加配件仓库(所在位置)
	 */
	public void addDictStorePosition(DictStorePosition storePosition) {
		this.getHibernateTemplate().save(storePosition);
	}
	
	/**
	 * 通过ID获取配件位置
	 */
	public DictStorePosition findDictStorePositionById(long id) {
		DictStorePosition dictStorePosition =null;
		List<DictStorePosition> list =	this.getHibernateTemplate().find(" from DictStorePosition where id = ? ",new Object[]{id});
		if(list.size()>0){
		   dictStorePosition = list.get(0);
	  }	
	 return dictStorePosition;
	}
	
	/**
	 * 通过ID删除配置仓库位置
	 */
	public void delDictStorePositionById(long id) {
		DictStorePosition  dictStorePosition = findDictStorePositionById(id);
		if(dictStorePosition!=null){
			this.getHibernateTemplate().delete(dictStorePosition);
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}

}
