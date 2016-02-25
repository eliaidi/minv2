package com.repair.pj.action.pjStoreStaticInfo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.util.action.BaseAction;
import com.repair.util.smartTips.SmartTips;

/**
 * 
* @ClassName: FindPjSSInfoListByNameOrPyAction
* @Description: TODO	通过静态配件名字或拼音模糊查询
* @author 周云韬
* @version V1.0  
* @date 2015-9-18 上午10:59:55
 */
public class FindPjSSInfoListByNameOrPyAction extends BaseAction{
	
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	
	private String py;
	
	
	@Override
	public String execute() throws Exception {
		List<PjStoreStaticInfo> list=pjStoreStaticInfoService.findPjStoreStaticInfoListByPjNameOrPy(py);
		
		
		List<SmartTips> tempList=new ArrayList<SmartTips>();
		for (PjStoreStaticInfo pssi : list) {
			tempList.add(new SmartTips(pssi.getId()+"",pssi.getPjName(),pssi.getPy()));
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(tempList));
		return null;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public void setPy(String py) {
		this.py = py;
	}


	
	
	
	
}
