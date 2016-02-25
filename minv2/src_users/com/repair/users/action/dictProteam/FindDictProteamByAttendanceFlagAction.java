package com.repair.users.action.dictProteam;

import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.entity.DictProteam;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
* @ClassName: FindByAttendanceFlagAction
* @Description: TODO(根据班组，考勤判别字段，查询（0、不考勤；1、考勤）)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-5 上午08:34:57
 */
public class FindDictProteamByAttendanceFlagAction extends BaseAction{
	
    private DictProteamService dictProteamService;
    private DictProteam dictProteam;
  
    public String execute() throws Exception {
	  List<DictProteam> list=dictProteamService.findDictProteamByAttendanceFlag(dictProteam.getAttendanceFlag());
		for (DictProteam dictProteam : list) {
			System.out.println(dictProteam);
		}
		 return Action.SUCCESS;
		 
    }
	
	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}

}
