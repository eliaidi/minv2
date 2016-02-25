package com.repair.pjFix.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.constant.Constants;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pjFix.dao.DictPjFirstUnitDao;
import com.repair.util.splitPage.SplitPageDao;

/**
* @ClassName: DictPjFirstUnitDaoImpl
* @Description: TODO 大部件(专业)表 dao层接口实现层
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午4:44:19
 */
public class DictPjFirstUnitDaoImpl implements DictPjFirstUnitDao {

	private HibernateTemplate hibernateTemplate;
	
	private SplitPageDao splitPageDao;
	
	/**
	 * 添加大部件
	 */
	public void addDictPjFirstUnit(DictPjFirstUnit firstUnit) {
		this.hibernateTemplate.save(firstUnit);
	}

	/**
	 * 通过大部件(专业名)模糊查询大部件
	 */
	@SuppressWarnings("unchecked")
	public List<DictPjFirstUnit> findDictPjFirstUnitByUnitName(String unitName) {
		List<DictPjFirstUnit> list=this.hibernateTemplate.find("from DictPjFirstUnit where firstUnitName=?", new Object[]{unitName});
		return list;
	}
	
	/**
	 * 查询所有大部件
	 */
	@SuppressWarnings("unchecked")
	public List<DictPjFirstUnit> findAllDictPjFirstUnit() {
		List<DictPjFirstUnit> list=this.hibernateTemplate.find("from DictPjFirstUnit");
		return list;
	}

	/**
	 * 通过Id删除数据
	 */
	public void deleteDictPjFirstUnit(long id) {
		DictPjFirstUnit dictPjFirstUnit=findDictPjFirstUnitById(id);
		if(dictPjFirstUnit!=null)
		{
			this.hibernateTemplate.delete(dictPjFirstUnit);
		}
	}

	/**
	 * 通过Id查找数据
	 */
	@SuppressWarnings("unchecked")
	public DictPjFirstUnit findDictPjFirstUnitById(long id) {
		DictPjFirstUnit dictPjFirstUnit=null;
		List<DictPjFirstUnit> list=this.hibernateTemplate.find("from DictPjFirstUnit where id=?",new Object[]{id});
		if(list.size()>0)
		{
			dictPjFirstUnit=list.get(0);
		}
		return dictPjFirstUnit;
	}
	
	
	/**
	* 通过专业名或拼音模糊查询大部件（不区分大小写）
	* @param   unitNameOrPy：专业名或拼音
	* @return 大部件集合
	 */
	@SuppressWarnings("unchecked")
	public  List<DictPjFirstUnit> findDictPjFirstUnitListByUnitNameOrPy(String unitNameOrPy){
		if(unitNameOrPy != null){
			unitNameOrPy=unitNameOrPy.toLowerCase();
			String hql="from DictPjFirstUnit where firstUnitName like ? or py like ?";
			List parsValue=new ArrayList();
			parsValue.add("%"+unitNameOrPy+"%");
			parsValue.add("%"+unitNameOrPy+"%");
			return splitPageDao.queryList(hql, parsValue, 1,Constants.SMART_TIPS_SHOW_COUNT).getData();
		}
		return null;
	}
	
	/**
	 * 修改数据
	 */
	public void updateDictPjFirstUnit(DictPjFirstUnit dictPjFirstUnit) {
			this.hibernateTemplate.update(dictPjFirstUnit);
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}

}
