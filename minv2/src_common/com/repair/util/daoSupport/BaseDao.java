package com.repair.util.daoSupport;

import java.io.Serializable;
import java.util.List;

import com.repair.util.splitPage.SearchDto;
import com.repair.util.splitPage.SplitPageModel;

/**
 * 
 * @see 抽象dao层，提供了一些基础的方法接口
 * @author 周云韬
 * @date 2015-12-18
 * @version 1.0
 */
public interface BaseDao<T> {

	/**
	 * 通过ID进行查找
	 * @param id	主键ID
	 * @return	返回对应的对象
	 */
	public T findById(Serializable id);
	
	/**
	 * 保存对象
	 * @param t 
	 * @return 保存后的对象的ID
	 */
	public Serializable save(T t);
	
	/**
	 * 修改对象
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 删除对象
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 查询所有
	 * @return	对象集合
	 */
	public List<T> listAll() ;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return	对象集合
	 */
	public SplitPageModel<T> listAllByPage(SearchDto dto);
	
}
