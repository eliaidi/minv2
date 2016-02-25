package com.repair.zx.service;

import java.util.List;

import com.repair.entity.JcInformation;

/**
 * 
 * @see 机车履历信息service层
 * @author 周云韬
 * @date 2015-12-17
 * @version 1.0
 */
public interface IJcInformationService {

	/**
	 * 列出所有机车履历信息
	 * @return
	 */
	public List<JcInformation> listAll();
}
