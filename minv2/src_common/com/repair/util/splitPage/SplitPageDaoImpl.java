package com.repair.util.splitPage;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.repair.constant.Constants;
import com.repair.entity.Test;
public class SplitPageDaoImpl  extends HibernateDaoSupport implements SplitPageDao{
	
	/**
	 * 	分页查询列表，适合无参时的分页
	 *  @param queryHql：查询hql
	 *  @param parsValue：参数对应的值
	 *  @param pageNo：当前页数
	 *  @param pageSize：每页大小
	 *  @return SplitPageModel 分页模型
	 */
	public   SplitPageModel queryList(final String queryHql,final int pageNo,final int pageSize){
		
		return queryList(queryHql,null,pageNo,pageSize);
	} 
	
	
	
	/**
	 * 	分页查询列表，适合无参时的分页
	 *  @param queryHql：查询hql
	 *  @param pageNo：当前页数
	 *  @param pageSize：每页大小
	 *  @return SplitPageModel 分页模型
	 */
	private String getCountHql(String queryHql){
	
		return "select count(*) "+queryHql.substring(queryHql.indexOf("from"));
	}




	public SplitPageModel queryList(final String queryHql,final List parsValue,
			final int pageNo,final  int pageSize) {
		final int currentPageNo=pageNo <= 0 ? 1 : pageNo;
		final int currentPageSize=pageSize <= 0 ? Constants.SPLIT_PAGE_DEFALT_SIZE : pageSize;
		@SuppressWarnings("unchecked")
		List dataList=this.getHibernateTemplate().executeFind(new HibernateCallback<List<Object>>() {

			public List<Object> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query=session.createQuery(queryHql);
				
				if(parsValue != null){
					for (int i = 0; i < parsValue.size(); i++) {
						query.setParameter(i, parsValue.get(i));
					}
				}
				
				query.setMaxResults(currentPageSize);
				query.setFirstResult((currentPageNo-1)*currentPageSize);
				
				return query.list();
			}
		});
		
		String countHql=getCountHql(queryHql);
		Query query=this.getSession().createQuery(countHql);
		if(parsValue != null){
			for (int i = 0; i < parsValue.size(); i++) {
				query.setParameter(i, parsValue.get(i));
			}
		}
		long totalCount= (Long)query.uniqueResult();
		return new SplitPageModel(pageNo, pageSize, dataList, totalCount);
		
	}

	/**
	 * 	无参分页查询时适用
	 * 	@param dto  
	 */
	public   SplitPageModel queryList(SearchDto dto){
		if(dto == null){
			return null;
		}
		String hql="from "+dto.getClass().getName();
		return queryList(hql,null,dto.getPageNo(),dto.getPageSize());
	}
	

}
