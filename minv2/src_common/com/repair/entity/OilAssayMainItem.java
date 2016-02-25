package com.repair.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @see 机车油水化验项目主表
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayMainItem implements Serializable{
	
	/** @Field  id ：主键 */
	private Long id;
	
	/** @Field  mainItemName ：油水化验主项目名称 */
	private String mainItemName;
	
	/** @Field   orderNum：油水化验项目顺序号 */
	private Integer orderNum;
	
	/** @Field  status ：是否启用(0、禁用；1、启用) */
	private Integer status;
	
	/** @Field   py：拼音 */
	private String py;
	
	/** @Field   remark：备注 */
	private String remark;
	
	/** @Field   childItemSet：子油水化验项目集合 */
	private Set<OilAssayChildItem> childItemSet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMainItemName() {
		return mainItemName;
	}

	public void setMainItemName(String mainItemName) {
		this.mainItemName = mainItemName;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<OilAssayChildItem> getChildItemSet() {
		return childItemSet;
	}

	public void setChildItemSet(Set<OilAssayChildItem> childItemSet) {
		this.childItemSet = childItemSet;
	}
	
	
}
