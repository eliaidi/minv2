package com.repair.dao;

import java.util.List;

import com.repair.entity.JcPlanDate;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.Test;
import com.repair.util.splitPage.SplitPageModel;


/**
 * ClassName: TestDao 
 * @Description: 测试Dao接口
 * @author andy
 * @datetime Jul 15, 2015 2:49:55 PM
 */
public interface TestDao {
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

