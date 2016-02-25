package com.repair.pjFix.service.impl;

import java.util.List;
import com.repair.entity.JcInformation;
import com.repair.pjFix.dao.JcInformationDao;
import com.repair.pjFix.service.JcInformationService;

/**
* @ClassName: JcInformationService
* @Description: TODO	机车信息（履历）service层接口
* @author 周云韬
* @version V1.0  
* @date 2015-9-22 下午3:34:32
 */
public class JcInformationServiceImpl implements JcInformationService{
	
	private JcInformationDao jcInformationForPjFixDao;
	
	/**
	 * 通过机车类型ID查询机车信息（履历）集合
	 * @param  dictJcTypeId		机车类型ID	
	 * @return List<JcInformation>    机车信息（履历）集合	
	 */
	public List<JcInformation> findJcInformationListByDictJcTypeId(long dictJcTypeId){
		return jcInformationForPjFixDao.findJcInformationListByDictJcTypeId(dictJcTypeId);
	}

	public JcInformationDao getJcInformationForPjFixDao() {
		return jcInformationForPjFixDao;
	}

	public void setJcInformationForPjFixDao(
			JcInformationDao jcInformationForPjFixDao) {
		this.jcInformationForPjFixDao = jcInformationForPjFixDao;
	}

	
	
	
}
