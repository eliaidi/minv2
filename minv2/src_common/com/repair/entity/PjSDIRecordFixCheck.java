package com.repair.entity;

import java.util.Date;


/**
* @ClassName: PjSDIRecordFixCheck
* @Description: TODO(实体类)
* @author lxb
* @version V1.0  
* @date 2015-9-21 上午11:03:08
 */
public class PjSDIRecordFixCheck implements java.io.Serializable{
	/*@Field id : 主键 */
	private long id;
	
	private PjSDInfoRecordFix pjSDInfoRecordFix;
	
	/*@Field id : leadUsers  工长对应用户表 */
	private UsersPrivs leadUsers;
	
	/*@Field id : usersPrivsesCLUI 交车工长对应用户表 */
	private UsersPrivs commitLeadUsers;
	
	/*@Field id : usersPrivsesQUI 质检员对应用户表 */
	private UsersPrivs qcUsers;
	
	/*@Field id : usersPrivsesAUI 验收员对应用户表 */
	private UsersPrivs acceptanceUsers;
	
	/*@Field id :  usersPrivsesTUI 技术员对应用户表*/
	private UsersPrivs technicianUsers;
	
	/*@Field id :  twoInspectionUsers 复探员对应用户表*/
	private UsersPrivs twoInspectionUsers;
	
	/*@Field id : 工长是否卡控(0、不卡控；1、卡控) */
	private Integer leadCheck;
	
	/*@Field id : 工长验收时间 */
	private Date leadCheckTime;
	
	/*@Field id : 交车工长是否卡控(0、不卡控；1、卡控) */
	private Integer commitLeadCheck;
	
	/*@Field id : 交车工长验收时间 */
	private Date commitLeadCheckTime;
	
	/*@Field id : 质检员是否卡控(0、不卡控；1、卡控) */
	private Integer qcCheck;
	
	/*@Field id : 质检员验收时间 */
	private Date qcCheckTime;
	
	/*@Field id : 验收员是否卡控(0、不卡控；1、卡控) */
	private Integer acceptanceCheck;
	
	/*@Field id : 验收员验收时间 */
	private Date acceptanceCheckTime;
	
	/*@Field id : 技术员是否卡控(0、不卡控；1、卡控) */
	private Integer technicianCheck;
	
	/*@Field id : 技术员验收时间 */
	private Date technicianCheckTime;
	
	/*@Field id : 复探是否卡控(0、不卡控；1、卡控) */
	private Integer twoInspectionCheck;
	
	/*@Field id : 复探验收时间 */
	private Date twoInspectionCheckTime;
	
	

	

	

	public void setId(long id) {
		this.id = id;
	}

	public int getLeadCheck() {
		return leadCheck;
	}

	public PjSDInfoRecordFix getPjSDInfoRecordFix() {
		return pjSDInfoRecordFix;
	}

	public void setPjSDInfoRecordFix(PjSDInfoRecordFix pjSDInfoRecordFix) {
		this.pjSDInfoRecordFix = pjSDInfoRecordFix;
	}

	public UsersPrivs getLeadUsers() {
		return leadUsers;
	}

	public void setLeadUsers(UsersPrivs leadUsers) {
		this.leadUsers = leadUsers;
	}

	public UsersPrivs getCommitLeadUsers() {
		return commitLeadUsers;
	}

	public void setCommitLeadUsers(UsersPrivs commitLeadUsers) {
		this.commitLeadUsers = commitLeadUsers;
	}

	public UsersPrivs getQcUsers() {
		return qcUsers;
	}

	public void setQcUsers(UsersPrivs qcUsers) {
		this.qcUsers = qcUsers;
	}

	public UsersPrivs getAcceptanceUsers() {
		return acceptanceUsers;
	}

	public void setAcceptanceUsers(UsersPrivs acceptanceUsers) {
		this.acceptanceUsers = acceptanceUsers;
	}

	public UsersPrivs getTechnicianUsers() {
		return technicianUsers;
	}

	public void setTechnicianUsers(UsersPrivs technicianUsers) {
		this.technicianUsers = technicianUsers;
	}

	

	public UsersPrivs getTwoInspectionUsers() {
		return twoInspectionUsers;
	}

	public void setTwoInspectionUsers(UsersPrivs twoInspectionUsers) {
		this.twoInspectionUsers = twoInspectionUsers;
	}

	
	public Date getLeadCheckTime() {
		return leadCheckTime;
	}

	public void setLeadCheckTime(Date leadCheckTime) {
		this.leadCheckTime = leadCheckTime;
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

	public long getId() {
		return id;
	}

	public void setLeadCheck(Integer leadCheck) {
		this.leadCheck = leadCheck;
	}

	
	
}
