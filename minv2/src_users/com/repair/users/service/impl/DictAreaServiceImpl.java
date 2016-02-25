package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.DictArea;
import com.repair.users.dao.DictAreaDao;
import com.repair.users.service.DictAreaService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
 * ClassName: DictAreaServiceImpl
 * @Package com.repair.users.service.impl
 * @Description: TODO(地区表service接口实现类)
 * @author lxb
 * @datetime 2015-8-3 上午11:15
 */
public class DictAreaServiceImpl extends ServiceSupport<DictArea> implements DictAreaService {

	/** 定义成员变量*/
	private DictAreaDao dictAreaDao;

	

	/** 通过机务段地区名称，删除机务段 */
	public void deleteDictAreaByAreaNameService(String areaName) {
		dictAreaDao.deleteDictAreaByAreaNameDao(areaName);

	}

	/** 通过机务段代码删除机务段 */
	public void deleteDictAreaByJwdCodeService(String jwdCode) {
		dictAreaDao.deleteDictAreaByJwdCodeDao(jwdCode);

	}
	
	

	/** 通过机务段代码查找机务段 */
	public DictArea findDictAreaByJwdCodeService(String jwdCode) {
		DictArea dictArea = dictAreaDao.findDictAreaByJwdCodeDao(jwdCode);
		return dictArea;
	}

	/** 通过机务段名称查找机务段 */
	public DictArea findDictAreaByNameService(String areaName) {
		DictArea dictArea = dictAreaDao.findDictAreaByNameDao(areaName);
		return dictArea;

	}


	public DictAreaDao getDictAreaDao() {
		return dictAreaDao;
	}

	public void setDictAreaDao(DictAreaDao dictAreaDao) {
		this.dictAreaDao = dictAreaDao;
	}

}
