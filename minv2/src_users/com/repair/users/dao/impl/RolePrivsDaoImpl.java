package com.repair.users.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.repair.entity.RolePrivs;
import com.repair.entity.UsersRolePrivs;
import com.repair.users.dao.RolePrivsDao;
import com.repair.util.page.PageDao;
import com.repair.util.page.PageModel;

/**
 * @ClassName: RolePrivsDao
 * @Description: TODO(角色dao接口实现类，其实就是职务dao接口实现类）
 * @author lxb
 * @version V1.0
 * @date 2015-8-4 上午 9:40
 */
public class RolePrivsDaoImpl extends PageDao implements RolePrivsDao {

	/** 添加role信息 */
	public void addRolePrivsDao(RolePrivs rolePrivs) {
		this.getSession().save(rolePrivs);
	}

	/** 根据Id删除数据 */
	@SuppressWarnings("unchecked")
	public void deleteRolePrivsByIdDao(long id) {
		RolePrivs role = findRolePrivsByIdDao(id);
		if (role != null) {
			this.getSession().delete(role);
		}
	}

	/** 根据roleName删除数据*/
	@SuppressWarnings("unchecked")
	public void deleteRolePrivsByRoleNameDao(String roleName) {
		List<RolePrivs> list = this.getHibernateTemplate().find(
				"from RolePrivs where roleName=?", new Object[] { roleName });
		RolePrivs rolePrivs = new RolePrivs();
		if (list.size() > 0) {
			rolePrivs = list.get(0);
		}
		this.getHibernateTemplate().delete(rolePrivs);

	}

	/** 查询Role所有信息*/
	@SuppressWarnings("unchecked")
	public List<RolePrivs> findRolePrivsAllDao() {
		List<RolePrivs> list = this.getHibernateTemplate().find(
				" from RolePrivs");
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	/** 根据Id查询数据*/
	@SuppressWarnings("unchecked")
	public RolePrivs findRolePrivsByIdDao(long id) {
		List<RolePrivs> list = this.getHibernateTemplate().find(
				" from RolePrivs where id=?", new Object[] { id });
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/** 修改role数据*/
	public void updateRolePrivsByIdDao(RolePrivs rolePrivs) {
		this.getHibernateTemplate().update(rolePrivs);
	}

	/** 根据roleName查询数据*/
	@SuppressWarnings("unchecked")
	public RolePrivs findRolePrivsByNameDao(String name) {
		RolePrivs rp = null;
		List<RolePrivs> role = this.getHibernateTemplate().find(
				"from RolePrivs where roleName=?", new Object[] { name });
		if (role.size() > 0) {
			rp = role.get(0);
		}
		return rp;
	}

	/** 分页查询数据*/
	@SuppressWarnings("unchecked")
	public PageModel<RolePrivs> findRolePrivsList() {
		StringBuffer hql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		hql.append("from RolePrivs order by id desc");
		return findPageModel(hql.toString(), params.toArray());
	}

	/** 通过roleId查询functionPrivs对象信息*/
	@SuppressWarnings("unchecked")
	public List<RolePrivs> findFunctinPrivsAll(long roleId) {
		List<RolePrivs> list = this.getHibernateTemplate().find(
				"from RolePrivs where id=?", new Object[] { roleId });
		return list;
	}

	/** 通过角色id删除用户角色中间表*/
	public void deleteUsersRolePrivsByRoleId(long id) {
		UsersRolePrivs usersRolePrivs = findUsersRolePrivsById(id);
		if (usersRolePrivs != null) {
			this.getSession().delete(usersRolePrivs);
		}
	}

	/** 根据roleId查找用户角色功能表数据*/
	@SuppressWarnings("unchecked")
	public List<UsersRolePrivs> findUserRolePrivsByRoleId(long roleid) {
		List<UsersRolePrivs> list = this.getHibernateTemplate().find(
				"from UsersRolePrivs where rolePrivs.id=?",
				new Object[] { roleid });
		return list;
	}

	/** 根据Id查找用户角色功能表数据*/
	@SuppressWarnings("unchecked")
	public UsersRolePrivs findUsersRolePrivsById(long id) {
		UsersRolePrivs usersRolePrivs = null;
		List<UsersRolePrivs> list = this.getHibernateTemplate().find(
				"from UsersRolePrivs where id=?", new Object[] { id });
		if (list.size() > 0) {
			usersRolePrivs = list.get(0);
		}
		return usersRolePrivs;
	}

	/** 返回所有users_role_privs对象*/
	public List<UsersRolePrivs> findAllUsersRolePrivs() {
		List<UsersRolePrivs> list = this.getHibernateTemplate().find(
				"from UsersRolePrivs");
		return list;
	}
}
