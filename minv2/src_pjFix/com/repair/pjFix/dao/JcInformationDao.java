package com.repair.pjFix.dao;

import java.util.List;
import com.repair.entity.JcInformation;

/**
* @ClassName: JcInformationDao
* @Description: TODO  机车信息（履历）dao层接口
* @author 周云韬
* @version V1.0  
* @date 2015-9-22 下午3:27:05
 */
public interface JcInformationDao {
	
	/**
	 * 通过机车类型ID查询机车信息（履历）集合
	 * @param  dictJcTypeId		机车类型ID	
	 * @return List<JcInformation>    机车信息（履历）集合	
	 */
	public List<JcInformation> findJcInformationListByDictJcTypeId(long dictJcTypeId);
}
