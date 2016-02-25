package com.repair.users.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.repair.constant.Constants;
import com.repair.entity.UsersPrivs;
import com.repair.users.dao.UsersPrivsDao;
import com.repair.util.StringUtil;
import com.repair.util.page.PageDao;
import com.repair.util.page.PageModel;
import com.repair.util.splitPage.SplitPageDao;

/**
* @ClassName: UsersPrivsDaoImpl
* @Description: TODO	用户类(UsersPrivs)的dao实现
* @author 周云韬
* @version V1.0  
* @date 2015-8-4 上午10:39:44
 */
public class UsersPrivsDaoImpl extends PageDao implements UsersPrivsDao {
	
	private SplitPageDao splitPageDao;
	
	
	/**添加用户
	 * 参数：usersPrivs[用户对象]*/
	public void addUsers(UsersPrivs usersPrivs) {
		this.getHibernateTemplate().save(usersPrivs);
	}
	
	/**根据id，删除
	 * 参数：id[用户id]*/
	public void delUsersById(long id) {
		UsersPrivs user=findUsersById(id);
		if(user != null){
			getHibernateTemplate().delete(user);
		}
	}
	
	/**根据用户名，删除
	 * 参数：userName[用户名]*/
	public void delUsersByUserName(String userName) {
		UsersPrivs user=findUsersByName(userName);
		
		if(user != null){
			getSession().delete(user);
		}
	}
	
	/**根据用户id，修改
	 * 参数：usersPrivs[用户对象]*/
	public void updateUsersById(UsersPrivs usersPrivs) {
		getSession().update(usersPrivs);
	}
	
	/**查询所有用户
	 * 返回类型：List<UsersPrivs>[用户对象集合]*/
	public List<UsersPrivs> findAllUsers() {
		return this.getHibernateTemplate().find("from UsersPrivs");
	}
	
	/**根据用户id，查找
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：id[用户id]*/
	public UsersPrivs findUsersById(long id) {
		return this.getHibernateTemplate().get(UsersPrivs.class, id);
	}
	
	/**根据用户名，查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：userName[用户名]*/
	public UsersPrivs findUsersByName(String userName) {
		String hql="from UsersPrivs where userName=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{userName});
		return list.size()==0?null:list.get(0);
	}
	
	/**根据地区/机务段id，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：dictAreaId[地区机/务段id]*/
	public List<UsersPrivs> findUsersByDictAreaId(String dictAreaId) {
		String hql="from UsersPrivs where dictArea.id=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{dictAreaId}); 
		return list;
	}
	
	/**根据激活状态，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：status[激活状态]*/
	public List<UsersPrivs> findUsersByStatus(int status) {
		String hql="from UsersPrivs where status=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{status}); 
		return list;
	}
	
	/**根据部门id，查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：dictDepartId[部门id]*/
	public PageModel<UsersPrivs> findUsersByDictDepartId(long dictDepartId) {
		String hql="from UsersPrivs where dictDepart.id=? order by id desc";
		List<Object> params=new ArrayList<Object>();
		params.add(dictDepartId);
		return findPageModel(hql,params.toArray());
	}

	/**根据班组id，查询
	 * 返回类型：List<UsersPrivs>[用户集合]
	 * 参数：dictProteamId[班组id]*/
	public PageModel<UsersPrivs> findUsersByDictProteamId(long dictProteamId) {
		String hql="from UsersPrivs where dictProteam.id=? order by id desc";
		return findPageModel(hql,new Object[]{dictProteamId});
	}

	/**根据工号，查询
	 * 返回类型：UsersPrivs[用户类]
	 * 参数：jobNum[工号]*/
	public UsersPrivs findUsersByJobNum(String jobNum) {
		String hql="from UsersPrivs where jobNum=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{jobNum}); 
		return list.size() == 0 ? null : list.get(0);
	}

	/**根据卡号，查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：cardNum[卡号]*/
	public UsersPrivs findUsersByCardNum(String cardNum) {
		String hql="from UsersPrivs where cardNum=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{cardNum}); 
		return list.size() == 0 ? null : list.get(0);
	}

	/**根据角色id，查询。(角色表，其实就是职务表-字段ID)
	 * 返回类型：List<UsersPrivs>[用户集合]
	 * 参数：rolePrivsId[角色id]*/
	//需要进行修改！！！！！
	public List<UsersPrivs> findUsersByRolePrivsId(int rolePrivsId) {
		String hql="from UsersPrivs where rolePrivs.id=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{rolePrivsId}); 
		return list;
	}

	/**根据性别，查询。（性别：0、男；1、女）
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：gender[性别]*/
	public List<UsersPrivs> findUsersByGender(int gender) {
		String hql="from UsersPrivs where gender=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{gender}); 
		return list;
	}

	/**根据工号和密码查询
	 * 返回类型：UsersPrivs[用户对象]
	 * 参数：jobNum[用户名]
	 * 参数：password[密码]*/
	public UsersPrivs findUsersByJobNumAndPassword(String jobNum,String password){
		String hql="from UsersPrivs where jobNum=? and password=?";
		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{jobNum,password}); 
	
		return list.size() == 0 ? null :list.get(0);
	}
	/**根据用户对象中不为空的值查询用户列表，并分页
	 * 返回类型：List<UsersPrivs>
	 * 参数：userPrivs
	 */
	public PageModel<UsersPrivs> findUsersList(UsersPrivs userPrivs){
		StringBuffer hql = new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		hql.append("from UsersPrivs where 1=1");
		
		if(userPrivs.getUsersRolePrivs() !=null && userPrivs.getUsersRolePrivs().size() != 0){
			hql.append(" and id in (select ur.usersPrivs.id  from UsersRolePrivs ur where ur.rolePrivs.id=?)");
			params.add(userPrivs.getUsersRolePrivs().iterator().next().getRolePrivs().getId());
		}
		
		if(userPrivs.getDepartProteamStatus() != -1){
			hql.append(" and (departProteamStatus = ? or departProteamStatus = "+Constants.DEPART_AND_PROTEAM+")");
			params.add(userPrivs.getDepartProteamStatus());
		}
//		if(userPrivs.getRolePrivs().getId()!= 0){
//			hql.append(" and rolePrivs.id = ?");
//			params.add(userPrivs.getRolePrivs().getId());
//		}
	
		if(StringUtil.isNotBlank(userPrivs.getUserName())){
			hql.append(" and userName like ?");
			params.add("%"+userPrivs.getUserName()+"%");
		}
		if(StringUtil.isNotBlank(userPrivs.getJobNum())){
			hql.append(" and jobNum like ?");
			params.add("%"+userPrivs.getJobNum()+"%");
		}
		
		hql.append(" order by id desc ");
		return findPageModel(hql.toString(),params.toArray());
	}
	
	/**根据部门或班组判别字段查询
	 * 返回类型：List<UsersPrivs>[用户对象集合]
	 * 参数：DepartOrProteamStatus*/
	public PageModel<UsersPrivs> findUsersByDepartOrProteamStatus(int status){
		String hql="from UsersPrivs where departProteamStatus=? or departProteamStatus=? order by id desc";
		
//		List<UsersPrivs> list=this.getHibernateTemplate().find(hql,new Object[]{status,Constants.DEPART_AND_PROTEAM}); 
		return findPageModel(hql, new Object[]{status,Constants.DEPART_AND_PROTEAM});
	}
	
	/**根据班组标识字段查询
	 * 返回类型：PageModel<UsersPrivs>[用户对象集合]
	 * 参数：DepartOrProteamStatus*/
	public PageModel<UsersPrivs> findUsersByProteamWorkFlag(int workFlag){
		String hql="from UsersPrivs where dictProteam.workFlag=? or dictProteam.workFlag=? order by id desc";
		return findPageModel(hql, new Object[]{workFlag,Constants.DEPART_AND_PROTEAM});
	}
	
	
	/** 通过用户名或拼音查询用户列表(不区分大小写) */
	public List<UsersPrivs> findUsersListByPjNameOrPy(String nameOrPy){
		if(nameOrPy != null){
			nameOrPy=nameOrPy.toLowerCase();
			String hql="from UsersPrivs where userName like ? or py like lower(?)";
			List<String> pars=new ArrayList<String>();
			pars.add("%"+nameOrPy+"%");
			pars.add("%"+nameOrPy+"%");
			return splitPageDao.queryList(hql,pars,1,Constants.SMART_TIPS_SHOW_COUNT).getData();
		}
		return new ArrayList<UsersPrivs>();
	}

	
	
	/**
	 * 通过班组ID获得所有此班组用户
	 * @param proteamId：班组ID
	 * @return 用户集合*/
	public List<UsersPrivs> findUsersListByProteamId(long proteamId){
		String hql="from UsersPrivs where dictProteam.id=?";
		return this.getHibernateTemplate().find(hql,proteamId);
	}
	
	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}
	
}
