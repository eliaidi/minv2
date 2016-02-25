package com.repair.pjFix.action.jcInformation;

import java.util.List;
import com.google.gson.Gson;
import com.repair.constant.Constants;
import com.repair.entity.JcInformation;
import com.repair.pjFix.service.JcInformationService;
import com.repair.util.action.BaseAction;
import com.repair.util.ganged.Ganged;
import com.repair.util.ganged.GangedUtil;

/**
* @ClassName: FindJcInformationListByDictJcTypeIdAction
* @Description: TODO	通过机车类型ID查询机车信息（履历）集合，返回json数据
* @author 周云韬
* @version V1.0  
* @date 2015-9-22 下午3:34:32
 */
public class FindJcInformationListByDictJcTypeIdAction extends BaseAction{
	
	/** 机车信息（履历）service层 */
	private JcInformationService jcInformationForPjFixService;
	
	/**  机车类型ID */
	private Long dictJcTypeId;
	
	@Override
	public String execute() throws Exception {
		List<JcInformation> jcInformationList=jcInformationForPjFixService.findJcInformationListByDictJcTypeId(dictJcTypeId);
		
		List<Ganged> gangedList=GangedUtil.convert(jcInformationList, "id", "jcNumber");
		
		response.setContentType(Constants.RESPONSE_HEADER_CONTENT_TYPE_JSON);
		response.getWriter().write(new Gson().toJson(gangedList));
		
		return null;
	}

	public void setJcInformationForPjFixService(JcInformationService jcInformationForPjFixService) {
		this.jcInformationForPjFixService = jcInformationForPjFixService;
	}

	public void setDictJcTypeId(Long dictJcTypeId) {
		this.dictJcTypeId = dictJcTypeId;
	}
		
}
