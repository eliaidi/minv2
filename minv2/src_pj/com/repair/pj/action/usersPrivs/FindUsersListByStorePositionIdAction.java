package com.repair.pj.action.usersPrivs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.repair.entity.DictStorePosition;
import com.repair.entity.UsersPrivs;
import com.repair.pj.service.DictStorePositionService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;
import com.repair.util.smartTips.SmartTips;

/**
 * 
* @ClassName: FindUsersListByStorePositionIdAction
* @Description: TODO 通过仓库ID获得班组所属班组，然后通过班组获得用户集合（json格式）
* @author 周云韬
* @version V1.0  
* @date 2015-9-18 下午3:21:49
 */
public class FindUsersListByStorePositionIdAction extends BaseAction{
	private int dictStorePositionId;
	private UsersPrivsService usersPrivsService;
	private DictStorePositionService dictStorePositionService;
	
	@Override
	public String execute() throws Exception {
		DictStorePosition dictStorePosition=dictStorePositionService.findById(dictStorePositionId);
		
		if(dictStorePosition != null){
			List<UsersPrivs> list=usersPrivsService.findUsersListByProteamId(dictStorePosition.getDictProteam().getId());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			Map<Long, String> map=new HashMap<Long, String>();
			List<SmartTips> stList=new ArrayList<SmartTips>();
			for (UsersPrivs usersPrivs : list) {
				stList.add(new SmartTips(usersPrivs.getId()+"",usersPrivs.getUserName(),usersPrivs.getPy()));
			}
			pw.write(new Gson().toJson(stList));
		}else{
			pw.write(new Gson().toJson(new ArrayList()));
		}
		return null;
	}


	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}
	
	public void setDictStorePositionService(
			DictStorePositionService dictStorePositionService) {
		this.dictStorePositionService = dictStorePositionService;
	}


	

	public void setDictStorePositionId(int dictStorePositionId) {
		this.dictStorePositionId = dictStorePositionId;
	}


	
	
	
}
