package com.repair.zx.dao.impl;

import java.util.List;

import com.repair.constant.Constants;
import com.repair.entity.JcZxFixItem;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.zx.dao.IJcZxFixItemDao;

/**
 * 
 * @see 机车中修检修项目表（相当于静态表）Dao层
 * @author 周云韬
 * @date 2015-12-10
 * @version 1.0
 */
public class JcZxFixItemDaoImpl extends DaoSupport<JcZxFixItem> implements IJcZxFixItemDao{
	
	/**
	 * 通过机车型号和修次 列出所有启用的项目
	 * @param jcType  机车型号，如DF4、SS8
	 * @param jcFixMileage  修次，如Z1、Z2
	 * @param fixFlowId	流程节点ID
	 * @return 机车中修检修项目集合
	 */
	public List<JcZxFixItem> listEnabledItem(String jcType,String jcFixMileage,Long fixFlowId){
		String hql="from JcZxFixItem where status=? and jcTypes like ? and jcFixMileages like ? and fixFlow.id=?";
		
		if(! jcType.endsWith(",")){
			jcType += ",";
		}
		if(! jcFixMileage.endsWith(",")){
			jcFixMileage += ",";
		}
		
		return hibernateTemplate.find(hql,Constants.JC_ZX_FIX_ITEM_STATUS_ENABLED,"%"+jcType+"%","%"+jcFixMileage+"%",fixFlowId);
	}
	
	
	
}
