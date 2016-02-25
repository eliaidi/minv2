package com.repair.entity;

import java.util.Set;

/**
* @ClassName: PjFixItemPreinstallType
* @Description: TODO(实体类)预设配件检修项目分类表
* @author lxb
* @version V1.0  
* @date 2015-9-21 上午11:30:08
 */
public class PjFixItemPreinstallType  implements java.io.Serializable{
	/*@Field id : 主键 */
	private int id; 
	
	/*@Field id : preinstallTypeName  预设配件检修项目分类名称*/
	private String preinstallTypeName;
	
	/*@Field id : PJ_STORE_STATIC_INFO（配件仓库静态/基本信息表）*/
	private PjStoreStaticInfo pjStoreStaticInfo;
	
	/*@Field id : PJ_F_ITEM_PREINSTALL_TYPE（检修项目-预设配件检修项目分类表-中间表）Set*/
	private Set<PjFItemPreinstallType> pjFItemPreinstallTypes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreinstallTypeName() {
		return preinstallTypeName;
	}

	public void setPreinstallTypeName(String preinstallTypeName) {
		this.preinstallTypeName = preinstallTypeName;
	}

	public PjStoreStaticInfo getPjStoreStaticInfo() {
		return pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}

	public Set<PjFItemPreinstallType> getPjFItemPreinstallTypes() {
		return pjFItemPreinstallTypes;
	}

	public void setPjFItemPreinstallTypes(
			Set<PjFItemPreinstallType> pjFItemPreinstallTypes) {
		this.pjFItemPreinstallTypes = pjFItemPreinstallTypes;
	}
	
}
