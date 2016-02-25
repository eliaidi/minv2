package com.repair.entity;

/**
 * 
 * @see 车上组装配件记录
 * @author 周云韬
 * @date 2016-1-11
 * @version 1.0
 */
public class PjAssembleRecord implements java.io.Serializable{
	/** @Field  id:主键 */
	private long id;
	
	/** @Field  planDate:日计划表ID（中有机车编号）*/
	private JcPlanDate planDate;
	
	/** @Field  pjDynamicInfo:配件动态信息ID */
	private PjStoreDynamicInfo pjDynamicInfo;
	
	/** @Field  pjdCode: 配件编码*/
	private String pjdCode;
	
	/** @Field  remark:备注 */
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public JcPlanDate getPlanDate() {
		return planDate;
	}

	public void setPlanDate(JcPlanDate planDate) {
		this.planDate = planDate;
	}

	public PjStoreDynamicInfo getPjDynamicInfo() {
		return pjDynamicInfo;
	}

	public void setPjDynamicInfo(PjStoreDynamicInfo pjDynamicInfo) {
		this.pjDynamicInfo = pjDynamicInfo;
	}

	public String getPjdCode() {
		return pjdCode;
	}

	public void setPjdCode(String pjdCode) {
		this.pjdCode = pjdCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
