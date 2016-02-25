package com.repair.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @see 机车油水化验项目子记录表
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayChildItemRec implements Serializable{
	
	/** @Field id：主键 */
	private Long id;
	
	/** @Field childItem：关联OIL_ASSAY_CHILD_ITEM（机车油水化验项目子表-详细表）-字段ID */
	private OilAssayChildItem childItem;
	
	/** @Field mainItemRec： 关联OIL_ASSAY_MAIN_ITEM_REC（机车油水化验项目主记录表）-字段ID*/
	private OilAssayMainItemRec mainItemRec;
	
	/** @Field assayUsers： 检验人（化验人）ID*/
	private UsersPrivs assayUsers;
	
	/** @Field endTime：化验结束时间 */
	private Date endTime;
	
	/** @Field actualCheckData： 实际检测数据*/
	private Double actualCheckData;
	
	/** @Field unitMeasure：计量单位 */
	private String unitMeasure;
	
	/** @Field status：是否启用(0、禁用（删除）；1、启用（没删除）)（也就是逻辑删除的意思） */
	private Integer status;
	
	/** @Field assayStatus：化验情况（0、不合格；1、合格） */
	private Integer assayStatus;
	
	/** @Field remark： 备注*/
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OilAssayChildItem getChildItem() {
		return childItem;
	}

	public void setChildItem(OilAssayChildItem childItem) {
		this.childItem = childItem;
	}

	public OilAssayMainItemRec getMainItemRec() {
		return mainItemRec;
	}

	public void setMainItemRec(OilAssayMainItemRec mainItemRec) {
		this.mainItemRec = mainItemRec;
	}

	public UsersPrivs getAssayUsers() {
		return assayUsers;
	}

	public void setAssayUsers(UsersPrivs assayUsers) {
		this.assayUsers = assayUsers;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getActualCheckData() {
		return actualCheckData;
	}

	public void setActualCheckData(Double actualCheckData) {
		this.actualCheckData = actualCheckData;
	}

	public String getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAssayStatus() {
		return assayStatus;
	}

	public void setAssayStatus(Integer assayStatus) {
		this.assayStatus = assayStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
