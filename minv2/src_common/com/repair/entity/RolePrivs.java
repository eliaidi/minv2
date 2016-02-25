package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: RolePrivs
 * @Description: TODO(实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class RolePrivs implements java.io.Serializable {

	/** @Field id : 主键 */
	private long id;

	/** @Field roleName : 角色名 */
	private String roleName;

	/** @Field py : 拼音 */
	private String py;

	/** @Field remark : 备注 */
	private String remark;

	/** @Field roleFunctionPrivses : 角色功能表 */
	private Set roleFunctionPrivses = new HashSet(0);

	/** @Filed usersRolePrivses : 用户角色表 */
	private Set usersRolePrivses = new HashSet(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getRoleFunctionPrivses() {
		return this.roleFunctionPrivses;
	}

	public void setRoleFunctionPrivses(Set roleFunctionPrivses) {
		this.roleFunctionPrivses = roleFunctionPrivses;
	}

	public Set getUsersRolePrivses() {
		return this.usersRolePrivses;
	}

	public void setUsersRolePrivses(Set usersRolePrivses) {
		this.usersRolePrivses = usersRolePrivses;
	}

}