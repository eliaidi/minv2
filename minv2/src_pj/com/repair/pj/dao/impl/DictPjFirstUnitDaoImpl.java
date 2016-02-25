package com.repair.pj.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.constant.Constants;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.dao.DictPjFirstUnitDao;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.splitPage.SplitPageDao;

/**
* @ClassName: DictPjFirstUnitDaoImpl
* @Description: TODO 大部件(专业)表 dao层接口实现层
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午4:44:19
 */
public class DictPjFirstUnitDaoImpl extends DaoSupport<DictPjFirstUnit> implements DictPjFirstUnitDao {


	/**
	 * 通过大部件(专业名)模糊查询大部件
	 */
	@SuppressWarnings("unchecked")
	public List<DictPjFirstUnit> findDictPjFirstUnitByUnitName(String unitName) {
		List<DictPjFirstUnit> list=this.hibernateTemplate.find("from DictPjFirstUnit where firstUnitName=?", new Object[]{unitName});
		return list;
	}
	
	

	
	
	
	/**
	* 通过专业名或拼音模糊查询大部件（不区分大小写）
	* @param   unitNameOrPy：专业名或拼音
	* @return 大部件集合
	 */
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
	

}
