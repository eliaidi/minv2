package com.repair.zx.dao.impl;

import java.util.List;
import com.repair.entity.JcFixFlow;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.zx.dao.IJcFixFlowDao;



/**
 * 
 * @see 机车检修流程节点dao层
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public class JcFixFlowDaoImpl extends DaoSupport<JcFixFlow> implements IJcFixFlowDao{
	
	/**
	 * 通过机车类型和修次列出流程节点
	 * @param jcType	机车类型
	 * @param fixMileage	修次
	 * @return	流程节点集合
	 */
	public List<JcFixFlow> list(String jcType,String fixMileage){
		StringBuffer sb=new StringBuffer();
		sb.append("from JcFixFlow fixFlow where id in");
		sb.append(" ( 	select ffjt.fixFlow.id from JcFixFlowJcType ffjt where ffjt.jcType.jcTypeValue=?)  ");
		sb.append(" and id in ");
		sb.append(" (	select fffm.fixFlow.id from FixFlowFixMileage fffm where fffm.fixMileage.fixMileageValue=? )");
		sb.append(" order by fixFlowOrder");
		return hibernateTemplate.find(sb.toString(),jcType,fixMileage);
	}
	
}
