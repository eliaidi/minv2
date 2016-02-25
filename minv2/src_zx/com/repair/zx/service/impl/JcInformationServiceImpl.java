package com.repair.zx.service.impl;

import java.util.List;

import com.repair.entity.JcInformation;
import com.repair.zx.dao.IJcInformationDao;
import com.repair.zx.service.IJcInformationService;

/**
 * 
 * @see 机车履历信息service层
 * @author 周云韬
 * @date 2015-12-17
 * @version 1.0
 */
public class JcInformationServiceImpl implements IJcInformationService{
	private IJcInformationDao jcInformationDao;
	
	/**
	 * 列出所有机车履历信息
	 * @return
	 */
	public List<JcInformation> listAll(){
		return jcInformationDao.listAll();
	}

	public void setJcInformationDao(IJcInformationDao jcInformationDao) {
		this.jcInformationDao = jcInformationDao;
	}
	
	
	
}
