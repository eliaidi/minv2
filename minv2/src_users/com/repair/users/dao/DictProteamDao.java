package com.repair.users.dao;

import java.util.List;
import com.repair.entity.DictProteam;
import com.repair.util.daoSupport.BaseDao;

/**
* @ClassName: DictProteamDao
* @Description: TODO(班组类(DictProteamDao)接口)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-4 上午10:47:45
*/
public interface DictProteamDao extends BaseDao<DictProteam>{
	
    /**根据班组名，删除
    * 参数：proteamName[班组名]*/
	public void delDictProteamByName(String proteamName);
	
	/**根据班组名，查询
	 * 返回类型：DictProteam[班组类型]
	 * 参数：proteamName[班组名]*/
	public DictProteam findDictProteamByName(String proteamName);
	/**根据班组，小辅修、中修判别字段，查询（0、不修；1、小辅修；2、中修；3、小辅修/中修）
	 * 返回类型：List<DictProteam>[班组集合]
	 * 参数：work_flag[小辅修、中修判别字段]*/
	public List<DictProteam> findDictProteamByWorkFlag(int workFlag);
	/**根据班组，考勤判别字段，查询（0、不考勤；1、考勤）
	 * 返回类型：List<DictProteam>[班组对象集合]
	 * 参数：attendanceFlag[考勤判别字段]*/
	public List<DictProteam> findDictProteamByAttendanceFlag(int attendanceFlag);
}
