package com.repair.util.daoSupport;

import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.util.ClassUtil;
import com.repair.util.splitPage.SearchDto;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;


/**
 * 
 * @see 抽象出来的dao实现层
 * @author 周云韬
 * @date 2015-11-13
 * @version 1.0
 */
public class DaoSupport<T> implements BaseDao<T>{
	
	protected HibernateTemplate hibernateTemplate;
	
	protected SplitPageDao splitPageDao;

	//T所代表的类
	protected Class actualParamClass;
	
	public DaoSupport() {
		if(this.getClass().getGenericSuperclass() == DaoSupport.class){
			return;
		}
		Class[] clsArr=ClassUtil.getGenericParametersForClass(this.getClass());
		if(clsArr.length != 0){
			actualParamClass=clsArr[0];
		}
	}
	
	/**
	 * 通过ID进行查找
	 * @param id	主键ID
	 * @return	返回对应的对象
	 */
	public T findById(Serializable id){
		return (T) hibernateTemplate.get(actualParamClass, id);
	}
	
	/**
	 * 保存对象
	 * @param t 
	 * @return 保存后的对象的ID
	 */
	public Serializable save(T t){
		return hibernateTemplate.save(t);
	}
	
	/**
	 * 修改兑现
	 * @param t
	 */
	public void update(T t){
		hibernateTemplate.update(t);
	}
	
	/**
	 * 删除对象
	 * @param t
	 */
	public void delete(T t){
		hibernateTemplate.delete(t);
	}
	
	/**
	 * 查询所有
	 * @return	对象集合
	 */
	public List<T> listAll() {
		return hibernateTemplate.find("from "+actualParamClass.getSimpleName());
	}
	
	/**
	 * 分页查询
	 * @param dto
	 * @return	对象集合
	 */
	public SplitPageModel<T> listAllByPage(SearchDto dto){
		return splitPageDao.queryList("from "+actualParamClass.getSimpleName(), dto.getPageNo(), dto.getPageSize());
	}
	
	
	
	
	

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}
	
	
	
}
