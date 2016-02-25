package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.DictJcType;
import com.repair.pjFix.dao.DictJcTypeDao;
import com.repair.pjFix.service.DictJcTypeService;

/**
 * @ClassName: DictJcTypeServiceImpl
 * @Description: TODO 机车类型service层实现
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 上午11:50:01
 */
public class DictJcTypeServiceImpl implements DictJcTypeService {
	
	private DictJcTypeDao dictJcTypeForPjFixDao;

	/**
	 *  获取所有机车类型
	 */
	public List<DictJcType> findAllDictJcType() {
		return dictJcTypeForPjFixDao.findAllDictJcType();
	}

	/**
	 * ͨ通过机车类型ID获取机车类型
	 * 	 */
	public DictJcType findDictJcTypeById(long id) {
		return dictJcTypeForPjFixDao.findDictJcTypeById(id);
	}

	
	public DictJcTypeDao getDictJcTypeForPjFixDao() {
		return dictJcTypeForPjFixDao;
	}

	public void setDictJcTypeForPjFixDao(DictJcTypeDao dictJcTypeForPjFixDao) {
		this.dictJcTypeForPjFixDao = dictJcTypeForPjFixDao;
	}
}
