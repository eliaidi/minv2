package com.repair.entity;

/**
* @ClassName: PjFItemPreinstallType
* @Description: TODO(实体类) 检修项目-预设配件检修项目分类表-中间表
* @author lxb
* @version V1.0  
* @date 2015-9-21 上午11:33:16
 */
public class PjFItemPreinstallType  implements java.io.Serializable{
	/*@Field id : 主键 */
	private int id;
	
	/*@Field id : pjFixItem  PJ_FIX_ITEM（配件检修项目表）*/
	private PjFixItem pjFixItem;
	
	/*@Field id : pjFixItemPreinstallType PJ_FIX_ITEM_PREINSTALL_TYPE（预设配件检修项目分类表）*/
	private PjFixItemPreinstallType pjFixItemPreinstallType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PjFixItem getPjFixItem() {
		return pjFixItem;
	}

	public void setPjFixItem(PjFixItem pjFixItem) {
		this.pjFixItem = pjFixItem;
	}

	public PjFixItemPreinstallType getPjFixItemPreinstallType() {
		return pjFixItemPreinstallType;
	}

	public void setPjFixItemPreinstallType(
			PjFixItemPreinstallType pjFixItemPreinstallType) {
		this.pjFixItemPreinstallType = pjFixItemPreinstallType;
	}
	
	
}
