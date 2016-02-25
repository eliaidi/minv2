package com.repair.entity;

import java.util.Date;

/**
 * @see 机车检修主计划详情表
 * @author 周云韬
 * @version 1.0
 * @date 2015-11-12
 */
public class JcMainPlanRecorder  implements java.io.Serializable{
	/* @Field id : 主键 */
	private Long id;
	
	/* @Field id : 机车检修主计划表 */
	private JcMainPlan jcMainPlan;
	
	/* @Field id : 机车检修日计划*/
	private JcPlanDate jcPlanDate;
	
	/* @Field id : 计划日期*/
	private Date planDate;
	
	/* @Field id : 对应日期，星期*/
	private String planWeek;
	
	/* @Field id : 同一个主计划下的排序*/
	private Integer mainPlanNum;
	
	/* @Field id : 机车类型*/
	private String jcType;
	
	/* @Field id : 机车型号*/
	private String jcTypeValue;
	
	/* @Field id : 机车编号 */
	private String jcNumber;
	
	/* @Field id : 机车修程修次*/
	private DictJcFixMileage dictJcFixMileage;
	
	/* @Field id : 机车计划行走公里 */
	private Integer planKilometre;
	
	/* @Field id : 机车实际行走公里 */
	private Integer realityKilometre;
	
	/* @Field id : 所属机务段*/
	private DictArea dictArea;
	
	/* @Field id : 是否兑现：0、未兑现，1、兑现 */
	private Integer cash;
	
	/* @Field id : 未兑现原因 */
	private String noCashReason;
	
	/* @Field id : 备注 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JcMainPlan getJcMainPlan() {
		return jcMainPlan;
	}

	public void setJcMainPlan(JcMainPlan jcMainPlan) {
		this.jcMainPlan = jcMainPlan;
	}


	
	public JcPlanDate getJcPlanDate() {
		return jcPlanDate;
	}

	public void setJcPlanDate(JcPlanDate jcPlanDate) {
		this.jcPlanDate = jcPlanDate;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getPlanWeek() {
		return planWeek;
	}

	public void setPlanWeek(String planWeek) {
		this.planWeek = planWeek;
	}

	public Integer getMainPlanNum() {
		return mainPlanNum;
	}

	public void setMainPlanNum(Integer mainPlanNum) {
		this.mainPlanNum = mainPlanNum;
	}

	public String getJcType() {
		return jcType;
	}

	public void setJcType(String jcType) {
		this.jcType = jcType;
	}

	public String getJcTypeValue() {
		return jcTypeValue;
	}

	public void setJcTypeValue(String jcTypeValue) {
		this.jcTypeValue = jcTypeValue;
	}

	public String getJcNumber() {
		return jcNumber;
	}

	public void setJcNumber(String jcNumber) {
		this.jcNumber = jcNumber;
	}
	

	public DictJcFixMileage getDictJcFixMileage() {
		return dictJcFixMileage;
	}

	public void setDictJcFixMileage(DictJcFixMileage dictJcFixMileage) {
		this.dictJcFixMileage = dictJcFixMileage;
	}

	public DictArea getDictArea() {
		return dictArea;
	}

	public void setDictArea(DictArea dictArea) {
		this.dictArea = dictArea;
	}

	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public String getNoCashReason() {
		return noCashReason;
	}

	public void setNoCashReason(String noCashReason) {
		this.noCashReason = noCashReason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPlanKilometre() {
		return planKilometre;
	}

	public void setPlanKilometre(Integer planKilometre) {
		this.planKilometre = planKilometre;
	}

	public Integer getRealityKilometre() {
		return realityKilometre;
	}

	public void setRealityKilometre(Integer realityKilometre) {
		this.realityKilometre = realityKilometre;
	}
	
	
	
	
}
