package com.repair.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 
 * @see 机车油水化验项目主记录表
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAssayMainItemRec implements Serializable{
	/** @Field  id: 主键 */
	private Long id;
	
	/** @Field planDate :机车检修日计划表ID  */
	private JcPlanDate planDate;
	
	/** @Field jcType : 机车型号表ID */
	private DictJcType jcType;
	
	/** @Field sendUsers :送样人  */
	private String sendUsers;
	
	/** @Field receiveUsers :收样人ID  */
	private UsersPrivs receiveUsers;
	
	/** @Field receiveTime :接收待化验样品时间  */
	private Date receiveTime;
	
	/** @Field endTime :样品化验结束时间  */
	private Date endTime;
	
	/** @Field assayStatus :化验状态（0、作废；1、待化验；2、化验完成）  */
	private Integer assayStatus;
	
	/** @Field conditionStatus :处理意见（0、其他油，更换；1、变压器，滤油 */
	private Integer conditionStatus;
	
	/** @Field qualityStatus : 质量评定  */
	private String qualityStatus;
	
	/** @Field remark : 备注 */
	private String remark;
	
	/** @Field childItemRec：子项目记录 */
	private Set<OilAssayChildItemRec> childItemRec;

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

	public DictJcType getJcType() {
		return jcType;
	}

	public void setJcType(DictJcType jcType) {
		this.jcType = jcType;
	}

	

	public String getSendUsers() {
		return sendUsers;
	}

	public void setSendUsers(String sendUsers) {
		this.sendUsers = sendUsers;
	}

	public UsersPrivs getReceiveUsers() {
		return receiveUsers;
	}

	public void setReceiveUsers(UsersPrivs receiveUsers) {
		this.receiveUsers = receiveUsers;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getAssayStatus() {
		return assayStatus;
	}

	public void setAssayStatus(Integer assayStatus) {
		this.assayStatus = assayStatus;
	}

	public Integer getConditionStatus() {
		return conditionStatus;
	}

	public void setConditionStatus(Integer conditionStatus) {
		this.conditionStatus = conditionStatus;
	}

	public String getQualityStatus() {
		return qualityStatus;
	}

	public void setQualityStatus(String qualityStatus) {
		this.qualityStatus = qualityStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<OilAssayChildItemRec> getChildItemRec() {
		return childItemRec;
	}

	public void setChildItemRec(Set<OilAssayChildItemRec> childItemRec) {
		this.childItemRec = childItemRec;
	}
	
	
}
