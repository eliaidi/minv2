package com.repair.pj.action.pjStoreStaticInfo;

import java.util.HashSet;
import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.PjStaticJcTypePjFU;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.ProteamPjStatic;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: AddPjStoreStaticInfoAction
 * @Description: TODO(实现addPjStoreStaticInfo方法，添加数据)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 上午11:33:13
 */
public class AddPjStoreStaticInfoAction extends BaseAction implements
		ModelDriven<PjStoreStaticInfo> {

	private PjStoreStaticInfo pjStoreStaticInfo = new PjStoreStaticInfo();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	private DictProteamService dictProteamService;
	private JcTypePjFirstUnitService jcTypePjFirstUnitService;
    private long parentpId;
    private long[] proteamId;
    private long[] jcTypePjFirstUnitId;
	@Override
	public String execute() throws Exception {
        //先添加配件静态表数据
		PjStoreStaticInfo parentStoreStatic=null;
		//判断父级配件
		if(parentpId != 0){
			parentStoreStatic=pjStoreStaticInfoService.findById(parentpId);
		}
		pjStoreStaticInfo.setParentPjStoreStaticInfo(parentStoreStatic);
		
		
		
		//添加班组中间表数据
		Set<ProteamPjStatic> pp=new HashSet<ProteamPjStatic>();
		if(proteamId!=null)
		{
			for (long pid : proteamId) {
				ProteamPjStatic  pps=new ProteamPjStatic();
				pps.setDictProteam(dictProteamService.findById(pid));
			    pp.add(pps);
			}
			
		}
		pjStoreStaticInfo.setProteamPjStatics(pp);
		
		//添加静态配件_机车类型_大部件（专业）中间表
		Set<PjStaticJcTypePjFU> psjt=new HashSet<PjStaticJcTypePjFU>();
		if(jcTypePjFirstUnitId!=null)
		{
			for (long jcpid : jcTypePjFirstUnitId) {
				PjStaticJcTypePjFU ps=new PjStaticJcTypePjFU();
				ps.setJcTypePjFirstUnit(jcTypePjFirstUnitService.findById(jcpid));
				ps.setPjStoreStaticInfo(parentStoreStatic);
				psjt.add(ps);
			}
		}
		pjStoreStaticInfo.setPjStaticJcTypePjFUs(psjt);
		
		
		pjStoreStaticInfoService.save(pjStoreStaticInfo);
		session.setAttribute("message", "数据添加成功");
		return Action.SUCCESS;
	}

	public PjStoreStaticInfo getModel() {
		return this.pjStoreStaticInfo;
	}


	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	public void setParentpId(long parentpId) {
		this.parentpId = parentpId;
	}

	public void setProteamId(long[] proteamId) {
		this.proteamId = proteamId;
	}

	public void setJcTypePjFirstUnitId(long[] jcTypePjFirstUnitId) {
		this.jcTypePjFirstUnitId = jcTypePjFirstUnitId;
	}

	


	
	
}
