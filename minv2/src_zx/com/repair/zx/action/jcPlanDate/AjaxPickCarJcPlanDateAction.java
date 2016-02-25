package com.repair.zx.action.jcPlanDate;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.entity.JcFixFlow;
import com.repair.entity.JcFixFlowRecorder;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.entity.JcPlanDate;
import com.repair.entity.JcZxFixItem;
import com.repair.entity.JcZxFixItemRecord;
import com.repair.util.action.BaseAction;
import com.repair.zx.service.IJcFixFlowRecorderService;
import com.repair.zx.service.IJcFixFlowService;
import com.repair.zx.service.IJcMainPlanRecorderService;
import com.repair.zx.service.IJcPlanDateService;
import com.repair.zx.service.IJcZxFixItemRecordService;
import com.repair.zx.service.IJcZxFixItemService;


/**
 * 
 * @see ajax进行接车
 * @author 周云韬
 * @date 2015-12-16
 * @version 1.0
 */
public class AjaxPickCarJcPlanDateAction extends BaseAction {

	private IJcPlanDateService jcPlanDateService;
	private IJcFixFlowService jcFixFlowService;
	private IJcFixFlowRecorderService jcFixFlowRecorderService;
	private IJcZxFixItemService jcZxFixItemService;
	private IJcZxFixItemRecordService jcZxFixItemRecordService;
	private IJcMainPlanRecorderService jcMainPlanRecorderService;
	private Long id;
	
	@Override
	public String execute() throws Exception {
		try{
			JcPlanDate pd=jcPlanDateService.findById(id);
							
			if(pd == null){
				writeJson("-1", "不存在此日计划");
				return null;
			}
			
			String jcTypeValue=pd.getJcTypeValue();
			String fixMileage=pd.getDictJcFixMileage().getFixMileageValue();
			Set<DictProteam> proteamSet=new HashSet<DictProteam>();
			
			List<JcFixFlow> fixFlowList=jcFixFlowService.list(jcTypeValue,fixMileage);
			if(fixFlowList.size() == 0){
				writeJson("-1", "流程节点不存在");
				return null;
			}
			
			
			pd.setJcFixFlow(fixFlowList.get(1));
			pd.setJcPlanStatus(Constants.JC_PLAN_STATUS_IN_REPAIR);
			pd.setActualStarTime(Constants.TIME_STAMP_SYSTEM_DATE);
			
			
			//如果没有额外的修次
			if(pd.getExtraFixMileage() == null){
				//如果是中修
				if(pd.getDictJcFixMileage().getMileageType().equals(Constants.JC_FIX_MILEAGE_TYPE_ZHONG_FIX)){
					List<JcZxFixItem> fixItemList=jcZxFixItemService.listEnabledItem(jcTypeValue,fixMileage,pd.getJcFixFlow().getId());
					if(fixItemList.size() == 0){
						writeJson("-1", "不存在检修项目");
						return null;
					}
					proteamSet=getProteamSetByZx(fixItemList);
					saveZxFixItemRec(pd,fixItemList);
				}
				
				//保存检修流程节点记录
				saveFixFlowRec(pd,proteamSet);
			}
			
			jcPlanDateService.update(pd);
			
			String jcNumber=pd.getJcNumber();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			
			//判断当前扣得车 是否在  已经做好的日计划 范围之内，如果在，则计划已兑现
			List<JcMainPlanRecorder> mainPlanRecList=jcMainPlanRecorderService.listByConditions(jcTypeValue,jcNumber , Constants.JC_MP_RECORDER_CASH_NO);
			for (JcMainPlanRecorder rec : mainPlanRecList) {
				boolean bool=jcTypeValue.equals(rec.getJcTypeValue()) && jcNumber.equals(rec.getJcNumber());
				
				String d1=format.format(rec.getPlanDate());
				String d2=format.format(pd.getPlanMakeTime());
				
				bool &= d1.equals(d2);
				bool &= pd.getDictJcFixMileage().getId().equals(rec.getDictJcFixMileage().getId());
				if(bool){
					rec.setJcPlanDate(pd);
					rec.setCash(Constants.JC_MP_RECORDER_CASH_YES);
					jcMainPlanRecorderService.update(rec);
					break;
				}
			}
			
			
			writeJson("0", "接车成功");
		}catch(Exception e){
			e.printStackTrace();
			writeJson("-1", "接车失败");
		}
		
		return null;
	}

	
	/**
	 * 保存检修流程记录，成功返回true，失败返回false
	 * @param fixFlowList
	 * @return
	 * @throws Exception 
	 */
	public boolean saveFixFlowRec(JcPlanDate pd,Set<DictProteam> proteamSet) {
			
			
		Iterator<DictProteam> it=proteamSet.iterator();
		
		while (it.hasNext()) {
			JcFixFlowRecorder rec=new JcFixFlowRecorder();
			rec.setJcPlanDate(pd);
			rec.setJcFixFlow(pd.getJcFixFlow());
			rec.setDictProteam(it.next());
			rec.setStatus(Constants.JC_FF_RECORDER_STATUS_UNFINISH);
			
			jcFixFlowRecorderService.save(rec);
		}
				
		return true;
	}
	
	/**
	 * 保存中修项目记录，成功返回true，失败返回false
	 * @param fixItemList
	 * @return
	 * @throws Exception 
	 */
	public boolean saveZxFixItemRec(JcPlanDate pd,List<JcZxFixItem> fixItemList) throws Exception{
		
		
		for (JcZxFixItem fixItem : fixItemList) {
			JcZxFixItemRecord rec=new JcZxFixItemRecord();
			BeanUtils.copyProperties(rec, fixItem);
			
			rec.setPlanDate(pd);
			rec.setFixItem(fixItem);
			rec.setRecordStatus(Constants.JC_ZX_F_I_R_RECORD_STATUS_FIXEMP_STAY_SIGN);
			
			jcZxFixItemRecordService.save(rec);
		}
		
		
		return true;
	}
	
	/**
	 * 通过中修项目得到班组集合（不重复）
	 * @param fixItemList
	 * @return
	 */
	public Set<DictProteam> getProteamSetByZx(List<JcZxFixItem> fixItemList){
		Set<DictProteam> proteamSet=new HashSet<DictProteam>();
		for (JcZxFixItem jcZxFixItem : fixItemList) {
			proteamSet.add(jcZxFixItem.getProteam());
		}
		return proteamSet;
	}
	
	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJcFixFlowService(IJcFixFlowService jcFixFlowService) {
		this.jcFixFlowService = jcFixFlowService;
	}

	public void setJcZxFixItemService(IJcZxFixItemService jcZxFixItemService) {
		this.jcZxFixItemService = jcZxFixItemService;
	}

	public void setJcZxFixItemRecordService(
			IJcZxFixItemRecordService jcZxFixItemRecordService) {
		this.jcZxFixItemRecordService = jcZxFixItemRecordService;
	}


	public void setJcFixFlowRecorderService(
			IJcFixFlowRecorderService jcFixFlowRecorderService) {
		this.jcFixFlowRecorderService = jcFixFlowRecorderService;
	}

	public void setJcMainPlanRecorderService(
			IJcMainPlanRecorderService jcMainPlanRecorderService) {
		this.jcMainPlanRecorderService = jcMainPlanRecorderService;
	}
	
	
}
