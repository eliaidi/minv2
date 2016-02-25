package com.repair.entity;

/**
 * @see 机车修程修次表
 * @author 周云韬
 * @date 2015-11-12
 */
public class DictJcFixMileage implements java.io.Serializable{
	private Long id;
	
	/** @Field	fixMileageValue：修次 */
	private String fixMileageValue;
	
	/** @Field  mileageType：修程修次类型（0、小修；1、辅修；2、中修；3、和谐修程；4、整治；5、额外修程）*/
	private Integer mileageType;
	
	/** @Field	remark：备注 */
	private String remark;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFixMileageValue() {
		return fixMileageValue;
	}


	public void setFixMileageValue(String fixMileageValue) {
		this.fixMileageValue = fixMileageValue;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Integer getMileageType() {
		return mileageType;
	}


	public void setMileageType(Integer mileageType) {
		this.mileageType = mileageType;
	}
	
	
	
}
