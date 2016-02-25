package com.repair.entity;


/**
 * @ClassName: UsersRolePrivs
 * @Description: TODO(实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class UsersRolePrivs implements java.io.Serializable {

	/* @Field id : 主键 */
	private long id;

	/* @Field rolePrivs : ROLE_PRIVS(角色表，其实就是职务表)-字段ID */
	private RolePrivs rolePrivs;

	/* @Field rolePrivs : Users_PRIVS(用户表)-字段ID */
	private UsersPrivs usersPrivs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RolePrivs getRolePrivs() {
		return this.rolePrivs;
	}

	public void setRolePrivs(RolePrivs rolePrivs) {
		this.rolePrivs = rolePrivs;
	}

	public UsersPrivs getUsersPrivs() {
		return this.usersPrivs;
	}

	public void setUsersPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

}