package com.repair.util.splitPage;

import java.util.List;


/**
 * 
* @ClassName: SplitPageDao
* @Description: TODO 分页查询dao层接口
* @author 周云韬
* @version V1.0  
* @date 2015-9-1 下午3:16:10
 */
public interface SplitPageDao {
	/**
	 * 	分页查询列表，适合无参时的分页
	 *  @param queryHql：查询hql
	 *  @param parsValue：参数对应的值
	 *  @param pageNo：当前页数
	 *  @param pageSize：每页大小
	 *  @return SplitPageModel 分页模型
	 */
	public   SplitPageModel queryList(final String queryHql,List parsValue,final int pageNo,final int pageSize);
	
	/**
	 * 	分页查询列表，适合无参时的分页
	 *  @param queryHql：查询hql
	 *  @param pageNo：当前页数
	 *  @param pageSize：每页大小
	 *  @return SplitPageModel 分页模型
	 */
	public   SplitPageModel queryList(final String queryHql,final int pageNo,final int pageSize);
	
	
	/**
	 * 	无参分页查询时适用
	 * 	@param dto  
	 */
	public   SplitPageModel queryList(SearchDto dto);
}
