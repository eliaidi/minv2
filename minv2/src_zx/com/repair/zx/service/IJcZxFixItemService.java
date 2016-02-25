package com.repair.zx.service;

import java.util.List;
import com.repair.entity.JcZxFixItem;

/**
 * 
 * @see 机车中修检修项目表（相当于静态表）service层
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public interface IJcZxFixItemService {
	
	/**
	 * 通过机车型号和修次 列出所有启用的项目
	 * @param jcType  机车型号，如DF4、SS8
	 * @param jcFixMileage  修次，如Z1、Z2
	 * @param fixFlowId	流程节点ID
	 * @return 机车中修检修项目集合
	 */
	public List<JcZxFixItem> listEnabledItem(String jcType,String jcFixMileage,Long fixFlowId);
	
	
	
}
