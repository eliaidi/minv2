package com.repair.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 
 * @see 	机车中修\小辅修\临修，报活表（所有修程报活）
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class JtReport implements Serializable{
	
	/** @Field  id: 主键 */
	private Long id;
	
	/** @Field  reportType: 报活类型：0、机统28报活；1、复检报活；2、检修过程报活；3、临修加改报活；6、零公里报活； 不是修程。 */
	private Integer reportType;
	
	/** @Field reportTime : 报活时间。 */
	private Date reportTime;
	
	/** @Field planDate : 机车检修日计划表ID */
	private JcPlanDate planDate;
	
	/** @Field reportPart : 报活部位，从故障表中得到部位名，但数据库表不关联，可以在表中选，也可以在页面上输入 */
	private String reportPart;
	
	/** @Field  reportCondition: 报活情况，从故障表中得到部位名，但数据库表不关联，可以在表中选，也可以在页面上输入 */
	private String reportCondition;
	
	/** @Field reportUsers : 报活人 */
	private UsersPrivs reportUsers;
	
	/** @Field  proteam:  检修班组ID */
	private DictProteam proteam;
	
	/** @Field fixUsers : 检修人（张飞_001,关羽_002），检修人必须是检修班组的人 */
	private String fixUsers;
	
	/** @Field fixCondition : 检修处理情况 */
	private String fixCondition;
	
	/** @Field fixEndTime : 检修结束时间 */
	private Date fixEndTime;

	/** @Field leadUsers : 工长ID */
	private UsersPrivs leadUsers;
	
	/** @Field leadCheck : 工长是否卡控（0、不卡控；1、卡控） */
	private Integer leadCheck;
	
	/** @Field leadUsersCheckTime : 工长签认时间 */
	private Date leadUsersCheckTime;
	
	/** @Field commitLeadUsers : 交车工长ID */
	private UsersPrivs commitLeadUsers;
	
	/** @Field  commitLeadCheck: 交车工长是否卡控（0、不卡控；1、卡控） */
	private Integer commitLeadCheck;
	
	/** @Field  commitLeadCheckTime: 交车工长验收时间 */
	private Date commitLeadCheckTime;
	
	/** @Field qcUsers : 质检员ID */
	private UsersPrivs qcUsers;
	
	/** @Field qcCheck : 质检员是否卡控（0、不卡控；1、卡控） */
	private Integer qcCheck;
	
	/** @Field qcCheckTime : 质检员验收时间 */
	private Date qcCheckTime;
	
	/** @Field acceptanceUsers : 验收员ID */
	private UsersPrivs acceptanceUsers;
	
	/** @Field acceptanceCheck : 验收员是否卡控（0、不卡控；1、卡控） */
	private Integer acceptanceCheck;
	
	/** @Field acceptanceCheckTime : 验收员验收时间 */
	private Date acceptanceCheckTime;
	
	/** @Field technicianUsers : 技术员ID */
	private UsersPrivs technicianUsers;
	
	/** @Field technicianCheck : 技术员是否卡控（0、不卡控；1、卡控） */
	private Integer technicianCheck;
	
	/** @Field technicianCheckTime: 技术员验收时间 */
	private Date technicianCheckTime;
	
	/** @Field recordStatus : 报活记录状态：0、作废审批不通过；1、审批；2、接收；3、处理完成；4、工长核验；5、质检员、验收员核验；6、完成存档； */
	private Integer recordStatus;
	
	/** @Field remark : 备注 */
	private String remark;
	
	/** @Field reportImgUrlSet：报活图片集合*/
	private Set<ReportImgUrl> reportImgUrlSet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public JcPlanDate getPlanDate() {
		return planDate;
	}

	public void setPlanDate(JcPlanDate planDate) {
		this.planDate = planDate;
	}

	public String getReportPart() {
		return reportPart;
	}

	public void setReportPart(String reportPart) {
		this.reportPart = reportPart;
	}

	public String getReportCondition() {
		return reportCondition;
	}

	public void setReportCondition(String reportCondition) {
		this.reportCondition = reportCondition;
	}

	public UsersPrivs getReportUsers() {
		return reportUsers;
	}

	public void setReportUsers(UsersPrivs reportUsers) {
		this.reportUsers = reportUsers;
	}

	public DictProteam getProteam() {
		return proteam;
	}

	public void setProteam(DictProteam proteam) {
		this.proteam = proteam;
	}

	public String getFixUsers() {
		return fixUsers;
	}

	public void setFixUsers(String fixUsers) {
		this.fixUsers = fixUsers;
	}

	public String getFixCondition() {
		return fixCondition;
	}

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}

	public Date getFixEndTime() {
		return fixEndTime;
	}

	public void setFixEndTime(Date fixEndTime) {
		this.fixEndTime = fixEndTime;
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

	public Set<ReportImgUrl> getReportImgUrlSet() {
		return reportImgUrlSet;
	}

	public void setReportImgUrlSet(Set<ReportImgUrl> reportImgUrlSet) {
		this.reportImgUrlSet = reportImgUrlSet;
	}
	
	
}
