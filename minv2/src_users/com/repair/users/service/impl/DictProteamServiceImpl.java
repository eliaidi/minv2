package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.DictProteam;
import com.repair.users.dao.DictProteamDao;
import com.repair.users.service.DictProteamService;
import com.repair.util.daoSupport.DaoSupport;
import com.repair.util.serviceSupport.ServiceSupport;

/**
* @ClassName: DictProteamServiceImpl
* @Description: TODO(班组类(DictProteamServiceImpl)接口的是实现)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-4 上午10:51:00
 */
public class DictProteamServiceImpl extends ServiceSupport<DictProteam> implements DictProteamService {
    
	private DictProteamDao dictProteamDao;
	
	
	

   /**根据班组名，删除
    * 参数：proteamName[班组名]*/
	public void delDictProteamByName(String proteamName) {
		dictProteamDao.delDictProteamByName(proteamName);
	}

	

	/**根据班组，考勤判别字段，查询（0、不考勤；1、考勤）
	 * 返回类型：List<DictProteam>[班组对象集合]
	 * 参数：attendanceFlag[考勤判别字段]*/
	public List<DictProteam> findDictProteamByAttendanceFlag(int attendanceFlag) {
		return dictProteamDao.findDictProteamByAttendanceFlag(attendanceFlag);
	}



	/**根据班组名，查询
	 * 返回类型：DictProteam[班组类型]
	 * 参数：proteamName[班组名]*/
	public DictProteam findDictProteamByName(String proteamName) {
		return dictProteamDao.findDictProteamByName(proteamName);
	}

	/**根据班组，小辅修、中修判别字段，查询（0、不修；1、小辅修；2、中修；3、小辅修/中修）
	 * 返回类型：List<DictProteam>[班组集合]
	 * 参数：work_flag[小辅修、中修判别字段]*/
	public List<DictProteam> findDictProteamByWorkFlag(int workFlag) {
		return dictProteamDao.findDictProteamByWorkFlag(workFlag);
	}

	


	public void setDictProteamDao(DictProteamDao dictProteamDao) {
		this.dictProteamDao = dictProteamDao;
	}
}
