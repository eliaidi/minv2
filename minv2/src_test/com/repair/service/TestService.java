package com.repair.service;

import java.util.List;

import com.repair.entity.JcPlanDate;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.Test;
import com.repair.util.splitPage.SplitPageModel;

/**
 * ClassName: TestService 
 * @Package com.repair.service
 * @Description: 测试service接口
 * @author andy
 * @datetime Jul 15, 2015 3:52:44 PM
 */
public interface TestService {
	public void addTest(Test test);
	
	public SplitPageModel findAllTest(Test test);
	
	
	
	/**
	 * 
	* @Title: findAllPjStoreStaticInfoByPjName 
	* @Description: TODO(联想输入获取数据接口层) 
	* @return List<PjStoreStaticInfo>    PjStoreStaticInfo实体集合 
	* @throws
	 */
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfoByPjName();
	
	/**
	 * jcPlanStatus计划状态新建和在修统的机车
	 * @return
	 */
	public List<JcPlanDate> findAllJcName();
}
