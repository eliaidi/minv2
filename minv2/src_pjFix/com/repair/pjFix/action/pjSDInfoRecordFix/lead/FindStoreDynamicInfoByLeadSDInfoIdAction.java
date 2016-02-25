package com.repair.pjFix.action.pjSDInfoRecordFix.lead;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.entity.PjSDInfoRecord;
import com.repair.entity.PjSDInfoRecordFix;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.entity.UsersPrivs;
import com.repair.pjFix.service.PjStoreDynamicInfoService;
import com.repair.pojoUtil.PjSDInfoRecordUtil;
import com.repair.util.action.BaseAction;

/**
* @Description: TODO(通过动态配件Id查询数据,工长签认（进入签主页面）)
* @author 唐鹏
* @version V1.0  
* @date 2015-10-9 上午10:41:12
 */
public class FindStoreDynamicInfoByLeadSDInfoIdAction extends BaseAction{
	 
	private PjStoreDynamicInfoService pjSDInfoForPjFixService;
	
	/**定义动态配件编号Id**/
	private long id;
	
	@Override
	public String execute() throws Exception {
		
		//如果用户未登录
		UsersPrivs loginUsers=(UsersPrivs) request.getSession().getAttribute(Constants.LOGIN_USER);
		if(loginUsers == null){
			return Action.SUCCESS;
		}
		
		PjStoreDynamicInfo psdi=pjSDInfoForPjFixService.findPjStoreDynamicInfoById(id);
		request.setAttribute("psdi",psdi );
		
		//第一步      动过动态配件Id 得到检修主记录
		List<PjSDInfoRecord> list=PjSDInfoRecordUtil.listPjSDInfoFixMainRecord(psdi,1);
		
		if(list.size() == 0){
			return Action.SUCCESS;
		}
		
		//获得配件检修记录
		Iterator<PjSDInfoRecordFix> fixIt=list.get(0).getPjSDInfoRecordFixs().iterator();

		//检查项目集合
		List<PjSDInfoRecordFix> checkItemList=new ArrayList<PjSDInfoRecordFix>();
		//检测项目集合
		List<PjSDInfoRecordFix> jianceItemList=new ArrayList<PjSDInfoRecordFix>();
		//探伤项目集合
		List<PjSDInfoRecordFix> inspectionItemList=new ArrayList<PjSDInfoRecordFix>();
		
		while (fixIt.hasNext()) {
			PjSDInfoRecordFix fix=fixIt.next();
			DictProteam fixItemProteam=fix.getPjFixItem().getDictProteam();
			if(fixItemProteam == null){
				continue;
			}
			if(fixItemProteam.getId() == loginUsers.getDictProteam().getId()){
				if(Constants.INSPECTION_PROTEAM_NAME.equals((fixItemProteam.getProteamName()))){
					inspectionItemList.add(fix);
				}else if(fix.getPjFixItem().getDefaultValue() == null){
					checkItemList.add(fix);
				}else{
					jianceItemList.add(fix);
				}
			}
		}
		
		request.setAttribute("fixIt", fixIt);
		request.setAttribute("checkItemList", checkItemList);
		request.setAttribute("jianceItemList", jianceItemList);
		request.setAttribute("inspectionItemList", inspectionItemList);
		
		return Action.SUCCESS;
	}
	
	public void setPjSDInfoForPjFixService(PjStoreDynamicInfoService pjSDInfoForPjFixService) {
		this.pjSDInfoForPjFixService = pjSDInfoForPjFixService;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
}
