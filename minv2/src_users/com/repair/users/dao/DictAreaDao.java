package com.repair.users.dao;

import java.util.List;
import com.repair.entity.DictArea;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: DictAreaDao
* @Description: TODO(地区/机务段dao接口)
* @author andy
* @version V1.0  
* @date Aug 3, 2015 10:09:51 AM
*/
public interface DictAreaDao extends BaseDao<DictArea>{
	
	/**根据地区（机务段）名，删除
	 * 参数：areaName[地区（机务段）名]*/
	public void deleteDictAreaByAreaNameDao(String areaName);
	/**根据地区（机务段）编号，删除
	 * 参数jwdCode[地区（机务段）编号]*/
	public void deleteDictAreaByJwdCodeDao(String jwdCode);
	
	
	
	/**根据地区（机务段）名，查询
	 * 返回类型：DictArea[地区（机务段）类]
	 * 参数：areaName[（地区（机务段）名]*/
	public DictArea findDictAreaByNameDao(String areaName);
	/**根据地区（机务段）编码，查询
	 * 返回类型：DictArea[地区（机务段）类]
	 * 参数：jwdCode[（地区（机务段）编码]*/
	public DictArea findDictAreaByJwdCodeDao(String jwdCode);
}

