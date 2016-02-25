package com.repair.entity;

import java.io.Serializable;

public class OilAssayChildItem implements Serializable{
	/** @Field  id： 主键 */
	private Long id;
	
	/** @Field  childItemName：油水化验子项目名称  */
	private String childItemName;
	
	/** @Field item ：机车油水化验项目主表ID  */
	private OilAssayMainItem item;
	
	/** @Field proteam ：检修班组ID  */
	private DictProteam proteam;
	
	/** @Field orderNum： 序列号 */
	private Integer orderNum;
	
	/** @Field status：是否启用(0、禁用；1、启用)  */
	private Integer status;
	
	/** @Field minValue ： 最小值，小数点后10 */
	private Double minValue;
	
	/** @Field maxValue ： 最大值，小数点后10 */
	private Double maxValue;
	
	/** @Field unitMeasure ：计量单位  */
	private String unitMeasure;
	
	/** @Field py ： 拼音 */
	private String py;
	
	/** @Field remark ： 备注 */
	private String remark;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getChildItemName() {
		return childItemName;
	}


	public void setChildItemName(String childItemName) {
		this.childItemName = childItemName;
	}


	public OilAssayMainItem getItem() {
		return item;
	}


	public void setItem(OilAssayMainItem item) {
		this.item = item;
	}


	public DictProteam getProteam() {
		return proteam;
	}


	public void setProteam(DictProteam proteam) {
		this.proteam = proteam;
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


	public Double getMinValue() {
		return minValue;
	}


	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}


	public Double getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}


	public String getUnitMeasure() {
		return unitMeasure;
	}


	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
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
	
	
}
