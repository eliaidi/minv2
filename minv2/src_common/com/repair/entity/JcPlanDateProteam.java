package com.repair.entity;

/**
 * 
 * @see 机车日计划_班组中间表，不进行包修的班组
 * @author 周云韬
 * @date 2015-12-15
 * @version 1.0
 */
public class JcPlanDateProteam implements java.io.Serializable{
	/** @Field id:主键*/
	private Long id;
	
	/** @Field planDate:机车检修日计划*/
	private JcPlanDate planDate;
	
	/** @Field proteam:班组*/
	private DictProteam proteam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JcPlanDate getPlanDate() {
		return planDate;
	}

	public void setPlanDate(JcPlanDate planDate) {
		this.planDate = planDate;
	}

	public DictProteam getProteam() {
		return proteam;
	}

	public void setProteam(DictProteam proteam) {
		this.proteam = proteam;
	}
	
}
