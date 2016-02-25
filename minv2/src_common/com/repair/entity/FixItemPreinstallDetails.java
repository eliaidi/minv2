package com.repair.entity;

import java.io.Serializable;

/**
 * 
 * @see 检修项目预设分类详细表（常规项目，中修和小辅修）
 * @author 周云韬
 * @date 2016-1-5
 * @version 1.0
 */
public class FixItemPreinstallDetails implements Serializable{

	/**  @Field  id：主键 */
	private long id;
	
	/**  @Field  type：检修项目预设分类主表（常规项目，中修和小辅修）ID */
	private FixItemPreinstallType type;
	
	/**  @Field  zxItem：机车检修中修项目表ID */
	private JcZxFixItem zxItem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FixItemPreinstallType getType() {
		return type;
	}

	public void setType(FixItemPreinstallType type) {
		this.type = type;
	}

	public JcZxFixItem getZxItem() {
		return zxItem;
	}

	public void setZxItem(JcZxFixItem zxItem) {
		this.zxItem = zxItem;
	}
	
	
	
	
}
