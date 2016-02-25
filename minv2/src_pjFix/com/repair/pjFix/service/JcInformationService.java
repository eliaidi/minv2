package com.repair.pjFix.service;

import java.util.List;
import com.repair.entity.JcInformation;

/**
* @ClassName: JcInformationService
* @Description: TODO	机车信息service接口
* @author 周云韬
* @version V1.0  
* @date 2015-9-22 下午3:34:32
 */
public interface JcInformationService {
	
	/**
	 * 通过机车类型ID查询机车信息（履历）集合
	 * @param  dictJcTypeId		机车类型ID	
	 * @return List<JcInformation>    机车信息（履历）集合	
	 */
	public List<JcInformation> findJcInformationListByDictJcTypeId(long dictJcTypeId);
	
}
