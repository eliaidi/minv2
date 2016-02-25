package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.DictJcType;
import com.repair.pj.dao.DictJcTypeDao;
import com.repair.pj.service.DictJcTypeService;
import com.repair.util.serviceSupport.ServiceSupport;

/** 
 * @ClassName: DictJcTypeServiceImpl
 * @Description: TODO(机车型号)
 * @author lxb
 * @version V1.0
 * @date 2015-8-31 下午11:50:01
 */
public class DictJcTypeServiceImpl extends ServiceSupport<DictJcType> implements DictJcTypeService {
	
	private DictJcTypeDao dictJcTypeDao;

	
	
	
	public void setDictJcTypeDao(DictJcTypeDao dictJcTypeDao) {
		this.dictJcTypeDao = dictJcTypeDao;
	}

}
