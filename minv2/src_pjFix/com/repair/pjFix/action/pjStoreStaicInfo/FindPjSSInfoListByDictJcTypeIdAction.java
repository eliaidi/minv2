package com.repair.pjFix.action.pjStoreStaicInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.google.gson.Gson;
import com.repair.constant.Constants;
import com.repair.entity.DictJcType;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.entity.PjStaticJcTypePjFU;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.pjFix.service.DictJcTypeService;
import com.repair.util.action.BaseAction;
import com.repair.util.ganged.GangedUtil;

/**
* @ClassName: FindAllDictJcTypeAction
* @Description: TODO 通过机车类型查询所有的静态大类，返回json格式数据
* @author lxb
* @version V1.0  
* @date 2015-9-23 上午9:07:03
 */
public class FindPjSSInfoListByDictJcTypeIdAction extends BaseAction{
	
	private DictJcTypeService dictJcTypeForPjFixService;
	
	private long dictJcTypeId;
	
	@Override
	public String execute() throws Exception {
		//显示机车类型
		DictJcType dictJcType = dictJcTypeForPjFixService.findDictJcTypeById(dictJcTypeId);
		
		Set<JcTypePjFirstUnit> set=dictJcType.getJcTypePjFirstUnits();
		Iterator<JcTypePjFirstUnit> it =(set != null ? set :new HashSet()).iterator();
		Set<PjStoreStaticInfo> pssiSet=new HashSet<PjStoreStaticInfo>();
		
		while (it.hasNext()) {
			Iterator<PjStaticJcTypePjFU> psjtIt=it.next().getPjStaticJcTypePjFUs().iterator();
			while (psjtIt.hasNext()) {
				PjStaticJcTypePjFU  pjStaticJcTypePjFU=psjtIt.next();
				pssiSet.add(pjStaticJcTypePjFU.getPjStoreStaticInfo());
			}
		}
		
		List<PjStoreStaticInfo> pssiList=new ArrayList<PjStoreStaticInfo>();
		pssiList.addAll(pssiSet);
		
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_JSON);
		response.getWriter().write(new Gson().toJson(GangedUtil.convert(pssiList, "id", "pjName")));
		
		return null;
	}

	public void setDictJcTypeForPjFixService(DictJcTypeService dictJcTypeForPjFixService) {
		this.dictJcTypeForPjFixService = dictJcTypeForPjFixService;
	}

	public void setDictJcTypeId(long dictJcTypeId) {
		this.dictJcTypeId = dictJcTypeId;
	}
	
}
