package com.repair.users.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.users.dao.DictProteamDao;
import com.repair.util.daoSupport.DaoSupport;

/**
 * @ClassName: DictProteamDaoImpl
 * @Description: TODO(班组类(DictProteamDaoImpl)接口的实现)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-4 上午10:49:33
 */
public class DictProteamDaoImpl extends DaoSupport<DictProteam> implements DictProteamDao {


	

	/** 根据班组名，删除 */
	public void delDictProteamByName(String proteamName) {
		DictProteam dictProteam = findDictProteamByName(proteamName);
		if (dictProteam != null) {
			this.hibernateTemplate.delete(dictProteam);
		}
	}

	

	/** 根据班组，考勤判别字段，查询（0、不考勤；1、考勤） 返回类型：List<DictProteam>[班组对象集合]
	 * 参数：attendanceFlag[考勤判别字段]*/
	public List<DictProteam> findDictProteamByAttendanceFlag(int attendanceFlag) {
		List list = this.hibernateTemplate.find(
				"from DictProteam where attendanceFlag=?",
				new Object[] { attendanceFlag });

		return list;
	}

	

	/**根据班组名，查询*/
	public DictProteam findDictProteamByName(String proteamName) {
		DictProteam dictProteam = null;
		List<DictProteam> list = this.hibernateTemplate.find("from DictProteam where proteamName=?",
				new Object[] { proteamName });
		if (list.size() > 0) {
			dictProteam = list.get(0);
		}
		return dictProteam;
	}

	/** 根据班组，小辅修、中修判别字段，查询（0、不修；1、小辅修；2、中修；3、小辅修/中修） 返回类型：List<DictProteam>[班组集合]
	 * 参数：work_flag[小辅修、中修判别字段]*/
	public List<DictProteam> findDictProteamByWorkFlag(int workFlag) {
		List list = this.hibernateTemplate.find("from DictProteam where workFlag=? or workFlag=?",
				new Object[] { workFlag, Constants.XFX_ZX_BZ_STATU });
		return list;
	}



	
}
