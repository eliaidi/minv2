package com.repair.util.serviceSupport;

import java.io.Serializable;
import java.util.List;
import com.repair.util.daoSupport.BaseDao;
import com.repair.util.splitPage.SearchDto;
import com.repair.util.splitPage.SplitPageModel;

/**
 * 
 * @see service支持。提供了一些常用的增删改查方法
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 * @param <T>
 */
public class ServiceSupport<T>   implements BaseService<T>{

	private BaseDao<T> baseDao;
	
	/**
	 * 通过ID进行查找
	 * @param id	主键ID
	 * @return	返回对应的对象
	 */
	public T findById(Serializable id){
		return baseDao.findById(id);
	}
	
	/**
	 * 保存对象
	 * @param t 
	 * @return 保存后的对象的ID
	 */
	public Serializable save(T t){
		return baseDao.save(t);
	}
	
	/**
	 * 修改对象
	 * @param t
	 */
	public void update(T t){
		baseDao.update(t);
	}
	
	/**
	 * 删除对象
	 * @param t
	 */
	public void delete(T t){
		baseDao.delete(t);
	}
	
	/**
	 * 查询所有
	 * @return	对象集合
	 */
	public List<T> listAll() {
		return baseDao.listAll();
	}
	
	/**
	 * 分页查询
	 * @param dto
	 * @return	对象集合
	 */
	public SplitPageModel<T> listAllByPage(SearchDto dto){
		return baseDao.listAllByPage(dto);
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	
	
}
