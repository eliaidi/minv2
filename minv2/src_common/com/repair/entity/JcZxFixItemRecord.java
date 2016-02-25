package com.repair.entity;

import java.util.Date;

/**
 * @ClassName: 机车中修项目记录表
 * @Description: TODO(实体类)
 * @author 周云涛
 * @version V1.0
 * @date 2015-12-10 下午1:26:16
 */

public class JcZxFixItemRecord  implements java.io.Serializable{
	/** @Field  id：主键*/
	private Long id;
	
	/** @Field  planDate：机车检修日计划表*/
	private JcPlanDate planDate;
	
	/** @Field   fixItem：机车中修检修项目表*/
	private JcZxFixItem fixItem;
	
	/** @Field   fixCondition：检修情况（如71,90；完成；1；13-05-42D，等数据，是工人签的内容  ）*/
	private String fixCondition;
	
	/** @Field  计量单位 ：*/
	private String unitMeasure;
	
	/** @Field   fixFlow：项目节点，机车检修节点ID*/
	private JcFixFlow fixFlow;
	
	/** @Field  fixUsers：检修人姓名(name_工号)，存值如：（张飞_0726,关羽_1189….）*/
	private String fixUsers;
	
	/** @Field  fixUsersCheckTime：检修人签认时间*/
	private Date fixUsersCheckTime;
	
	/** @Field  leadUsers ：工长ID*/
	private UsersPrivs leadUsers;
	
	/** @Field  leadCheck：工长是否卡控（0、不卡控；1、卡控）*/
	private Integer leadCheck;
	
	/** @Field  leadUsersCheckTime ：工长签认时间*/
	private Date leadUsersCheckTime;
	
	/** @Field  commitLeadUsers：交车工长ID*/
	private UsersPrivs commitLeadUsers;
	
	/** @Field  commitLeadCheck ：交车工长是否卡控（0、不卡控；1、卡控）*/
	private Integer commitLeadCheck;
	
	/** @Field  commitLeadCheckTime ：交车工长验收时间*/
	private Date commitLeadCheckTime;
	
	/** @Field  qcUsers ：质检员*/
	private UsersPrivs qcUsers;
	
	/** @Field  qcCheck ：质检员是否卡控（0、不卡控；1、卡控）*/
	private Integer qcCheck;
	
	/** @Field  qcCheckTime ：质检员验收时间*/
	private Date qcCheckTime;
	
	/** @Field  acceptanceUsers：验收员*/
	private UsersPrivs acceptanceUsers;
	
	/** @Field  acceptanceCheck ：验收员是否卡控（0、不卡控；1、卡控）*/
	private Integer acceptanceCheck;
	
	/** @Field  acceptanceCheckTime ：验收员验收时间*/
	private Date acceptanceCheckTime;
	
	/** @Field   technicianUsers：技术员*/
	private UsersPrivs technicianUsers;
	
	/** @Field   technicianCheck：技术员是否卡控（0、不卡控；1、卡控）*/
	private Integer technicianCheck;
	
	/** @Field  technicianCheckTime ：技术员验收时间*/
	private Date technicianCheckTime;
	
	/** @Field  twoInspectionUsers ：复探人员*/
	private UsersPrivs twoInspectionUsers;
	
	/** @Field  twoInspectionCheck ：复探是否卡控（0、不卡控；1、卡控）*/
	private Integer twoInspectionCheck;
	
	/** @Field  twoInspectionCheckTime ：复探验收时间*/
	private Date twoInspectionCheckTime;
	
	/** @Field  inspectionCondition ：探伤处理情况*/
	private String inspectionCondition;
	
	/** @Field  recordStatus ：记录状态 0、检修人待签字；1、工长待签字；2、技术员待签字；3、质检员待签字； 3、交车工长待签字； 4、验收员待签字； 5、完成； */
	private Integer recordStatus;
	
	/** @Field  remark ：备注*/
	private String remark;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JcZxFixItem getFixItem() {
		return fixItem;
	}

	public void setFixItem(JcZxFixItem fixItem) {
		this.fixItem = fixItem;
	}

	public String getFixCondition() {
		return fixCondition;
	}

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}

	public String getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	
	public JcPlanDate getPlanDate() {
		return planDate;
	}

	public void setPlanDate(JcPlanDate planDate) {
		this.planDate = planDate;
	}

	public JcFixFlow getFixFlow() {
		return fixFlow;
	}

	public void setFixFlow(JcFixFlow fixFlow) {
		this.fixFlow = fixFlow;
	}

	

	public void setFixUsers(String fixUsers) {
		this.fixUsers = fixUsers;
	}

	public Date getFixUsersCheckTime() {
		return fixUsersCheckTime;
	}

	public void setFixUsersCheckTime(Date fixUsersCheckTime) {
		this.fixUsersCheckTime = fixUsersCheckTime;
	}

	public UsersPrivs getLeadUsers() {
		return leadUsers;
	}

	public void setLeadUsers(UsersPrivs leadUsers) {
		this.leadUsers = leadUsers;
	}

	public Integer getLeadCheck() {
		return leadCheck;
	}

	public void setLeadCheck(Integer leadCheck) {
		this.leadCheck = leadCheck;
	}

	public Date getLeadUsersCheckTime() {
		return leadUsersCheckTime;
	}

	public void setLeadUsersCheckTime(Date leadUsersCheckTime) {
		this.leadUsersCheckTime = leadUsersCheckTime;
	}

	public UsersPrivs getCommitLeadUsers() {
		return commitLeadUsers;
	}

	public void setCommitLeadUsers(UsersPrivs commitLeadUsers) {
		this.commitLeadUsers = commitLeadUsers;
	}

	public Integer getCommitLeadCheck() {
		return commitLeadCheck;
	}

	public void setCommitLeadCheck(Integer commitLeadCheck) {
		this.commitLeadCheck = commitLeadCheck;
	}

	public Date getCommitLeadCheckTime() {
		return commitLeadCheckTime;
	}

	public void setCommitLeadCheckTime(Date commitLeadCheckTime) {
		this.commitLeadCheckTime = commitLeadCheckTime;
	}

	public UsersPrivs getQcUsers() {
		return qcUsers;
	}

	public void setQcUsers(UsersPrivs qcUsers) {
		this.qcUsers = qcUsers;
	}

	public Integer getQcCheck() {
		return qcCheck;
	}

	public void setQcCheck(Integer qcCheck) {
		this.qcCheck = qcCheck;
	}

	public Date getQcCheckTime() {
		return qcCheckTime;
	}

	public void setQcCheckTime(Date qcCheckTime) {
		this.qcCheckTime = qcCheckTime;
	}

	public UsersPrivs getAcceptanceUsers() {
		return acceptanceUsers;
	}

	public void setAcceptanceUsers(UsersPrivs acceptanceUsers) {
		this.acceptanceUsers = acceptanceUsers;
	}

	public Integer getAcceptanceCheck() {
		return acceptanceCheck;
	}

	public void setAcceptanceCheck(Integer acceptanceCheck) {
		this.acceptanceCheck = acceptanceCheck;
	}

	public Date getAcceptanceCheckTime() {
		return acceptanceCheckTime;
	}

	public void setAcceptanceCheckTime(Date acceptanceCheckTime) {
		this.acceptanceCheckTime = acceptanceCheckTime;
	}

	public UsersPrivs getTechnicianUsers() {
		return technicianUsers;
	}

	public void setTechnicianUsers(UsersPrivs technicianUsers) {
		this.technicianUsers = technicianUsers;
	}

	public Integer getTechnicianCheck() {
		return technicianCheck;
	}

	public void setTechnicianCheck(Integer technicianCheck) {
		this.technicianCheck = technicianCheck;
	}

	public Date getTechnicianCheckTime() {
		return technicianCheckTime;
	}

	public void setTechnicianCheckTime(Date technicianCheckTime) {
		this.technicianCheckTime = technicianCheckTime;
	}

	public UsersPrivs getTwoInspectionUsers() {
		return twoInspectionUsers;
	}

	public void setTwoInspectionUsers(UsersPrivs twoInspectionUsers) {
		this.twoInspectionUsers = twoInspectionUsers;
	}

	public Integer getTwoInspectionCheck() {
		return twoInspectionCheck;
	}

	public void setTwoInspectionCheck(Integer twoInspectionCheck) {
		this.twoInspectionCheck = twoInspectionCheck;
	}

	public Date getTwoInspectionCheckTime() {
		return twoInspectionCheckTime;
	}

	public void setTwoInspectionCheckTime(Date twoInspectionCheckTime) {
		this.twoInspectionCheckTime = twoInspectionCheckTime;
	}

	public String getInspectionCondition() {
		return inspectionCondition;
	}

	public void setInspectionCondition(String inspectionCondition) {
		this.inspectionCondition = inspectionCondition;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFixUsers() {
		return fixUsers;
	}
	
	
	
	
}
