package com.repair.pjFix.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.JcInformation;
import com.repair.pjFix.dao.JcInformationDao;

/**
* @ClassName: JcInformationDaoImpl
* @Description: TODO  机车信息（履历）dao层接口实现类
* @author 周云韬
* @version V1.0  
* @date 2015-9-22 下午3:27:05
 */
public class JcInformationDaoImpl implements JcInformationDao{
	
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 通过机车类型ID查询机车信息（履历）集合
	 * @param  dictJcTypeId		机车类型ID	
	 * @return List<JcInformation>    机车信息（履历）集合	
	 */
	public List<JcInformation> findJcInformationListByDictJcTypeId(long dictJcTypeId){
		String hql="from JcInformation where dictJcType.id = ?";
		return hibernateTemplate.find(hql,dictJcTypeId);
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
