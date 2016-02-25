package com.repair.pj.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.pj.dao.JcTypePjFirstUnitDao;
import com.repair.util.daoSupport.DaoSupport;

/***
* @ClassName: JcTypePjFirstUnitDao
* @Description: TODO  机车型号-大部件（专业）中间表 dao层实现
* @author 唐鹏
* @version V1.0  
* @date 2015-9-6 上午09:08:37
 */
public class JcTypePjFirstUnitDaoImpl extends DaoSupport<JcTypePjFirstUnit> implements JcTypePjFirstUnitDao{
	

	
	
	/**
	 * 根据大部件（专业）id查询，机车类型-大部件（专业）中间表数据
	 */
	public List<JcTypePjFirstUnit> findJcTypePjFirstUnitByPjFirstUnitId(long firstUnitId) {
		List<JcTypePjFirstUnit> list=this.hibernateTemplate.find("from JcTypePjFirstUnit where dictPjFirstUnit.id=?",new Object[]{firstUnitId});
		return list;
	}
	
	/**
	 * 根据大部件（专业）id，查找机车类型-大部件（专业）中间表数据，然后进行删除    注意：方法名和实际功能不一致
	 */
	public void findJcTypePjFirstUnitBy_PjFirstUnitId(long firstUnitId) {
		List<JcTypePjFirstUnit> list=this.hibernateTemplate.find("from JcTypePjFirstUnit where dictPjFirstUnit.id=?",new Object[]{firstUnitId});
		for (JcTypePjFirstUnit jcTypePjFirstUnit : list) {
			this.hibernateTemplate.delete(jcTypePjFirstUnit);
		}
	}
	
	

}
