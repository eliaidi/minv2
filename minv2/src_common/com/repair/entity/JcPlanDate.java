package com.repair.entity;

import java.util.Date;
import java.util.Set;

/**
 * @see	机车检修日计划
 * @author 周云韬
 * @version 1.0
 */
public class JcPlanDate  implements java.io.Serializable{
	/* @Field id : 主键 */
	private Long id;
	
	/* @Field jcType : 机车类型 */
	private String jcType;
	
	/* @Field jcTypeValue : 机车型号*/
	private String jcTypeValue;
	
	/* @Field jcNumber : 机车编号*/
	private String jcNumber;
	
	/* @Field dictJcFixMileage : 正常修程修次 */
	private DictJcFixMileage dictJcFixMileage;
	
	/* @Field extraFixMileage : 额外修程修次 */
	private DictJcFixMileage extraFixMileage;
	
	/* @Field jcDetainTime : 扣车时间 */
	private Date jcDetainTime;
	
	/* @Field jcPlanStarTime : 计划起机时间 */
	private Date jcPlanStarTime;
	
	/* @Field jcPlanReceiveTime : 计划交车时间*/
	private Date jcPlanReceiveTime;
	
	/* @Field qcUsers : 质检ID*/
	private UsersPrivs qcUsers;
	
	/* @Field commitLeadUsers : 交车工长ID*/
	private UsersPrivs commitLeadUsers;
	
	/* @Field jcPlanStatus : 计划状态*/
	private Integer jcPlanStatus;
	
	/* @Field stationRacksNumber : 股道号 */
	private String stationRacksNumber;
	
	/* @Field stationNmber : 台位号*/
	private String stationNmber;
	
	/* @Field planMaker : 计划编制人*/
	private String planMaker;
	
	/* @Field planMakeTime : 计划制定时间*/
	private Date planMakeTime;
	
	/* @Field jcFixFlow : 机车检修流程节点*/
	private JcFixFlow jcFixFlow;
	
	/* @Field extraJcFixFlow : 额外检修流程节点 */
	private JcFixFlow extraJcFixFlow;
	
	/* @Field acceptanceUsers : 验收员ID*/
	private UsersPrivs acceptanceUsers;
	
	/* @Field technicianUsers : 技术员ID*/
	private UsersPrivs technicianUsers;
	
	/* @Field projectType : 项目类型*/
	private Integer projectType;
	
	/* @Field actualStarTime : 实际起机时间 */
	private Date actualStarTime;
	
	/* @Field actualReceiveTime : 实际交车时间*/
	private Date actualReceiveTime;
	
	
	/* @Field remark : 备注*/
	private String remark;
	
	/* @Field noProteamSet：  不包修班组  */
	private Set<JcPlanDateProteam> noProteamSet;

	/** @Field oilAMIRecSet： 油水化验主记录集合*/
	private Set<OilAssayMainItemRec> oilAMIRecSet;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getJcDetainTime() {
		return jcDetainTime;
	}

	public void setJcDetainTime(Date jcDetainTime) {
		this.jcDetainTime = jcDetainTime;
	}

	public Date getJcPlanStarTime() {
		return jcPlanStarTime;
	}

	public void setJcPlanStarTime(Date jcPlanStarTime) {
		this.jcPlanStarTime = jcPlanStarTime;
	}

	public Date getJcPlanReceiveTime() {
		return jcPlanReceiveTime;
	}

	public void setJcPlanReceiveTime(Date jcPlanReceiveTime) {
		this.jcPlanReceiveTime = jcPlanReceiveTime;
	}

	public UsersPrivs getQcUsers() {
		return qcUsers;
	}

	public void setQcUsers(UsersPrivs qcUsers) {
		this.qcUsers = qcUsers;
	}

	public UsersPrivs getCommitLeadUsers() {
		return commitLeadUsers;
	}

	public void setCommitLeadUsers(UsersPrivs commitLeadUsers) {
		this.commitLeadUsers = commitLeadUsers;
	}

	public Integer getJcPlanStatus() {
		return jcPlanStatus;
	}

	public void setJcPlanStatus(Integer jcPlanStatus) {
		this.jcPlanStatus = jcPlanStatus;
	}

	public String getStationRacksNumber() {
		return stationRacksNumber;
	}

	public void setStationRacksNumber(String stationRacksNumber) {
		this.stationRacksNumber = stationRacksNumber;
	}

	public String getStationNmber() {
		return stationNmber;
	}

	public void setStationNmber(String stationNmber) {
		this.stationNmber = stationNmber;
	}

	
	public String getPlanMaker() {
		return planMaker;
	}

	public void setPlanMaker(String planMaker) {
		this.planMaker = planMaker;
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

	public Date getPlanMakeTime() {
		return planMakeTime;
	}

	public void setPlanMakeTime(Date planMakeTime) {
		this.planMakeTime = planMakeTime;
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

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public Date getActualStarTime() {
		return actualStarTime;
	}

	public void setActualStarTime(Date actualStarTime) {
		this.actualStarTime = actualStarTime;
	}

	public Date getActualReceiveTime() {
		return actualReceiveTime;
	}

	public void setActualReceiveTime(Date actualReceiveTime) {
		this.actualReceiveTime = actualReceiveTime;
	}

	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public DictJcFixMileage getDictJcFixMileage() {
		return dictJcFixMileage;
	}

	public void setDictJcFixMileage(DictJcFixMileage dictJcFixMileage) {
		this.dictJcFixMileage = dictJcFixMileage;
	}

	public DictJcFixMileage getExtraFixMileage() {
		return extraFixMileage;
	}

	public void setExtraFixMileage(DictJcFixMileage extraFixMileage) {
		this.extraFixMileage = extraFixMileage;
	}

	public JcFixFlow getJcFixFlow() {
		return jcFixFlow;
	}

	public void setJcFixFlow(JcFixFlow jcFixFlow) {
		this.jcFixFlow = jcFixFlow;
	}

	public JcFixFlow getExtraJcFixFlow() {
		return extraJcFixFlow;
	}

	public void setExtraJcFixFlow(JcFixFlow extraJcFixFlow) {
		this.extraJcFixFlow = extraJcFixFlow;
	}

	public Set<JcPlanDateProteam> getNoProteamSet() {
		return noProteamSet;
	}

	public void setNoProteamSet(Set<JcPlanDateProteam> noProteamSet) {
		this.noProteamSet = noProteamSet;
	}

	public Set<OilAssayMainItemRec> getOilAMIRecSet() {
		return oilAMIRecSet;
	}

	public void setOilAMIRecSet(Set<OilAssayMainItemRec> oilAMIRecSet) {
		this.oilAMIRecSet = oilAMIRecSet;
	}
	
	
	
}
