package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.pj.dao.JcTypePjFirstUnitDao;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.util.serviceSupport.ServiceSupport;

/***
* @ClassName: JcTypePjFirstUnitDao
* @Description: TODO  机车型号-大部件（专业）中间表  service层接口
* @author 唐鹏
* @version V1.0  
* @date 2015-9-6 上午09:08:37
 */
public class JcTypePjFirstUnitServiceImpl extends ServiceSupport<JcTypePjFirstUnit> implements JcTypePjFirstUnitService{
    
	 private JcTypePjFirstUnitDao jcTypePjFirstUnitDao;	
	 
	
	
	/**
	 * 根据FirstUnitId（大部件（专业）中间表id）查询数据
	 */
	public List<JcTypePjFirstUnit> findJcTypePjFirstUnitByPjFirstUnitId(
			long firstUnitId) {
		return jcTypePjFirstUnitDao.findJcTypePjFirstUnitByPjFirstUnitId(firstUnitId);
	}
	

	

	public void setJcTypePjFirstUnitDao(JcTypePjFirstUnitDao jcTypePjFirstUnitDao) {
		this.jcTypePjFirstUnitDao = jcTypePjFirstUnitDao;
	}

}
