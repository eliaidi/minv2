package com.repair.pj.action.pjStoreStaticInfo;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: AddPjStoreStaticInfoAction
 * @Description: TODO(添加数据之前，先查询数据，到添加配件静态信息页面)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 上午11:33:13
 */
public class ToAddPjStoreStaticInfoAction extends BaseAction implements
		ModelDriven<PjStoreStaticInfo> {

	private PjStoreStaticInfoService pjStoreStaticInfoService;
    private DictProteamService dictProteamService;
    private JcTypePjFirstUnitService jcTypePjFirstUnitService;
    
    private PjStoreStaticInfo pjStoreStaticInfo = new PjStoreStaticInfo();
    
	@Override
	public String execute() throws Exception {
        //查询班组信息
		List<DictProteam> dictProteams=dictProteamService.listAll();
		request.setAttribute("dictProteams", dictProteams);
		//组装状态
		request.setAttribute("pjAssemblyType", Constants.PJ_ASSEMBLY_TYPE);
		//查询车型表数据
//		List<DictJcType> list=dictJcTypeService.findAllDictJcType();
//		ServletActionContext.getRequest().setAttribute("jcTypeList",list);
		List<JcTypePjFirstUnit> list=jcTypePjFirstUnitService.listAll();
		request.setAttribute("jcTypePjFirstUnitList",list);
		
		return Action.SUCCESS;
	}

	public PjStoreStaticInfo getModel() {
		return this.pjStoreStaticInfo;
	}

	public PjStoreStaticInfoService getPjStoreStaticInfoService() {
		return pjStoreStaticInfoService;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public JcTypePjFirstUnitService getJcTypePjFirstUnitService() {
		return jcTypePjFirstUnitService;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}
	
}
