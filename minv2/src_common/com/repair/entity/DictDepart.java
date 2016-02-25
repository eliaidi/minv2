package com.repair.entity;

import java.util.Set;

/**
 * @ClassName: DictArea
 * @Description: TODO(实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class DictDepart implements java.io.Serializable {

	/* @Field id: 主键 */
	private long id;

	/* @Field depatName : 部门名称 */
	private String departName;

	/* @Field py : 拼音 */
	private String py;

	/* @Field remark : 备注 */
	private String remark;

	/* @Field usersPrivses : 用户表Set */
	private Set<UsersPrivs> usersPrivses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
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

	public Set getUsersPrivses() {
		return this.usersPrivses;
	}

	public void setUsersPrivses(Set usersPrivses) {
		this.usersPrivses = usersPrivses;
	}

}