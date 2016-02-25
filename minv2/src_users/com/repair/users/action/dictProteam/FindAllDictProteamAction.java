package com.repair.users.action.dictProteam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.entity.DictionaryBase;
import com.repair.users.service.DictProteamService;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: FindAllAction
 * @Description: TODO(获得所有班组信息)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-5 08:34:19
 */
public class FindAllDictProteamAction extends BaseAction {

	private DictProteamService dictProteamService;
	private UsersPrivsService usersPrivsService;
	
	private int[] usersId;
	
	public String execute() throws Exception {
		int totalUsersCount=usersPrivsService.findUsersByDepartOrProteamStatus(Constants.PROTEAM_STATU).getCount();
		session.setAttribute("totalUsersCount", totalUsersCount);
		
		//所有班组
		List<DictProteam> proteamList = dictProteamService.listAll();
		//班组类型：小辅修、中修、小辅修/中修
		List<DictionaryBase> proteamTypes=(List<DictionaryBase>) ((Map)servletContext.getAttribute("cache")).get("SYS_PROTEAM");
		
		Map<String, Set<DictProteam>> proteamMap=new HashMap<String, Set<DictProteam>>();
		
		for (DictionaryBase dictionaryBase : proteamTypes) {
			//如果是不修班组，跳过
			if(Constants.PROTEAM_BX_BZ.equals(dictionaryBase.getKey())){
				continue;
			}
			
			if(Constants.PROTEAM_XFX_ZX_BZ.equals(dictionaryBase.getKey())){
				continue;
			}
			
			Set<DictProteam> set=proteamMap.get(dictionaryBase.getKey()) == null ? new HashSet<DictProteam>() : proteamMap.get(dictionaryBase.getKey());
			
			//遍历所有班组，将班组分类在一起
			for (DictProteam dictProteam : proteamList) {
				if(dictProteam.getWorkFlag() == Integer.parseInt(dictionaryBase.getValue())
						|| dictProteam.getWorkFlag() == 3){
					set.add(dictProteam);
				}
			}
			
			proteamMap.put(dictionaryBase.getValue(), set);
			
		}
		
		session.setAttribute("proteamMap", proteamMap);
		return Action.SUCCESS;
		
	}

	public int[] getUsersId() {
		return usersId;
	}


	public void setUsersId(int[] usersId) {
		this.usersId = usersId;
	}
    
	public void setUsersPrivsService(UsersPrivsService usersPrivsService) {
		this.usersPrivsService = usersPrivsService;
	}


	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}
	
}
