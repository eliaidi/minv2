package com.repair.pj.action.pjStoreStaticInfo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.PjStaticJcTypePjFU;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.ProteamPjStatic;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.pj.service.PjStaticJcTypePjFUService;
import com.repair.pj.service.PjStoreStaticInfoService;
import com.repair.pj.service.ProteamPjStaticService;
import com.repair.users.service.DictProteamService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @ClassName: UpdatePjStoreStaticInfoAction
 * @Description: TODO(实现updatePjStoreStaticInfo方法,修改数据）
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 上午11:25:17
 */
public class UpdatePjStoreStaticInfoAction extends BaseAction implements
		ModelDriven<PjStoreStaticInfo> {

	private PjStoreStaticInfo pjStoreStaticInfo = new PjStoreStaticInfo();
	private PjStoreStaticInfoService pjStoreStaticInfoService;
	private ProteamPjStaticService proteamPjStaticService;
	private PjStaticJcTypePjFUService pjStaticJcTypePjFUService;
	private DictProteamService dictProteamService;
	private JcTypePjFirstUnitService jcTypePjFirstUnitService;
	private Integer [] proteamId;
	private Integer [] jcTypePjFirstUnitId;
    private Long parentpId;
	@Override
	public String execute() throws Exception {
		PjStoreStaticInfo pssi=pjStoreStaticInfoService.findById(this.pjStoreStaticInfo.getId());
		
		if(pssi != null){
			
			pssi.setPjActivate(this.pjStoreStaticInfo.getPjActivate());
			pssi.setPjName(this.pjStoreStaticInfo.getPjName());
			pssi.setPjAssemblyType(this.pjStoreStaticInfo.getPjAssemblyType());
			pssi.setPjLoweStstore(this.pjStoreStaticInfo.getPjLoweStstore());
			
			if(parentpId != null){
				pssi.setParentPjStoreStaticInfo(pjStoreStaticInfoService.findById(parentpId));
			}
			//删除配件静态_车型_大部件(专业)中间表
			Set<PjStaticJcTypePjFU> set=pssi.getPjStaticJcTypePjFUs();
			pssi.setPjStaticJcTypePjFUs(null);
			if(set != null){
				Iterator<PjStaticJcTypePjFU> it=set.iterator();
				
				while(it.hasNext()){
					PjStaticJcTypePjFU psjtp=it.next();
					psjtp.setPjStoreStaticInfo(null);
					pjStaticJcTypePjFUService.delete(psjtp);
				}
			}
			
			//删除静态配件_班组中间表
			Set<ProteamPjStatic> ppsSet=pssi.getProteamPjStatics();
			pssi.setProteamPjStatics(null);
			if(set != null){
				Iterator<ProteamPjStatic> it=ppsSet.iterator();
				
				while(it.hasNext()){
					ProteamPjStatic  pps=it.next();
					pps.setPjStoreStaticInfo(null);
					proteamPjStaticService.delete(pps);
				}
			}
			
			//添加配件静态_车型_大部件(专业)中间表
			Set<PjStaticJcTypePjFU> psjtpSet=new HashSet<PjStaticJcTypePjFU>();
			if(jcTypePjFirstUnitId != null){
				for (Integer jtpfuId : jcTypePjFirstUnitId) {
					PjStaticJcTypePjFU psjp=new PjStaticJcTypePjFU();
					psjp.setJcTypePjFirstUnit(jcTypePjFirstUnitService.findById(jtpfuId));
					psjp.setPjStoreStaticInfo(pjStoreStaticInfo);
					psjtpSet.add(psjp);
				}
			}
			pssi.setPjStaticJcTypePjFUs(psjtpSet);
			
			//添加静态配件_班组中间表
			Set<ProteamPjStatic> ppsSet1=new HashSet<ProteamPjStatic>();
			if(proteamId != null){
				for (Integer pid : proteamId) {
					ProteamPjStatic pps=new ProteamPjStatic();
					pps.setPjStoreStaticInfo(pjStoreStaticInfo);
					pps.setDictProteam(dictProteamService.findById(pid));
					ppsSet1.add(pps);
				}
			}
			pssi.setProteamPjStatics(ppsSet1);
			//修改配件静态表
			pjStoreStaticInfoService.update(pssi);
			session.setAttribute("message", "数据修改成功");
		}
		
		
		
		return Action.SUCCESS;
	}

	public PjStoreStaticInfo getModel() {
		return this.pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfoService(
			PjStoreStaticInfoService pjStoreStaticInfoService) {
		this.pjStoreStaticInfoService = pjStoreStaticInfoService;
	}

	public void setProteamPjStaticService(
			ProteamPjStaticService proteamPjStaticService) {
		this.proteamPjStaticService = proteamPjStaticService;
	}

	public void setProteamId(Integer[] proteamId) {
		this.proteamId = proteamId;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}

	public void setPjStaticJcTypePjFUService(
			PjStaticJcTypePjFUService pjStaticJcTypePjFUService) {
		this.pjStaticJcTypePjFUService = pjStaticJcTypePjFUService;
	}

	public void setDictProteamService(DictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}

	public void setJcTypePjFirstUnitId(Integer[] jcTypePjFirstUnitId) {
		this.jcTypePjFirstUnitId = jcTypePjFirstUnitId;
	}

	

	

	public void setParentpId(Long parentpId) {
		this.parentpId = parentpId;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	
	
}
