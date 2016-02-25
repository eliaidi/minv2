package com.repair.zx.dao;

import java.util.List;
import com.repair.entity.JcFixFlow;
import com.repair.util.daoSupport.BaseDao;



/**
 * 
 * @see 机车检修流程节点dao层
 * @author 周云韬
 * @date 2015-12-14
 * @version 1.0
 */
public interface IJcFixFlowDao extends BaseDao<JcFixFlow>{
	
	/**
	 * 通过机车类型和修次列出流程节点
	 * @param jcType	机车类型
	 * @param fixMileage	修次
	 * @return	流程节点集合
	 */
	public List<JcFixFlow> list(String jcType,String fixMileage);
	
}
