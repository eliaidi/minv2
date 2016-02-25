package com.repair.users.service;

import java.util.List;
import com.repair.entity.DictArea;
import com.repair.util.serviceSupport.BaseService;
/**
 * ClassName: DictAreaService
 * @Package com.repair.users.service
 * @Description: TODO(地区表service接口)
 * @author lxb
 * @datetime 2015-8-3 上午11:15
 */
public interface DictAreaService extends BaseService<DictArea>{
	
	/**根据地区（机务段）名，删除
	 * 参数：areaName[地区（机务段）名]*/
	public void deleteDictAreaByAreaNameService(String areaName);
	/**根据地区（机务段）编号，删除
	 * 参数jwdCode[地区（机务段）编号]*/
	public void deleteDictAreaByJwdCodeService(String jwdCode);
	
	
	/**根据地区（机务段）名，查询
	 * 返回类型：DictArea[地区（机务段）类]
	 * 参数：areaName[（地区（机务段）名]*/
	public DictArea findDictAreaByNameService(String areaName);
	/**根据地区（机务段）编码，查询
	 * 返回类型：DictArea[地区（机务段）类]
	 * 参数：jwdCode[（地区（机务段）编码]*/
	public DictArea findDictAreaByJwdCodeService(String jwdCode);
}
