package com.repair.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * @ClassName: DictArea
 * @Description: TODO(实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class DictArea implements java.io.Serializable {
	/* @Field id : 主键 */
	private String id;

	/* @Field areaName: 地区名称 */
	private String areaName;

	/* @Field jwdCode : 机务段编号 */
	private String jwdCode;

	/* @Field py : 拼音 */
	private String py;

	/* @Field usersPrivses :用户表list */
	private Set<UsersPrivs> usersPrivses;

	/* @Field dictStorePositions :配件所在位置/仓库表 */
	private Set dictStorePositions = new HashSet(0);

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getJwdCode() {
		return this.jwdCode;
	}

	public void setJwdCode(String jwdCode) {
		this.jwdCode = jwdCode;
	}

	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public Set getUsersPrivses() {
		return this.usersPrivses;
	}

	public void setUsersPrivses(Set usersPrivses) {
		this.usersPrivses = usersPrivses;
	}

	public Set getDictStorePositions() {
		return this.dictStorePositions;
	}

	public void setDictStorePositions(Set dictStorePositions) {
		this.dictStorePositions = dictStorePositions;
	}

}