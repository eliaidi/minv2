package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: UsersPrivs
 * @Description: TODO(实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class UsersPrivs implements java.io.Serializable {


	/*@Field id : 主键       */
	private long id;
	
	/*@Field dictDepat :  部门ID  DICT_DEPART（部门表）-字段ID  */
	private DictDepart dictDepart;
	
	/*@Field dictArea :   地区/机务段ID  DICT_AREA（地区表）-字段 ID  */
	private DictArea dictArea;
		
	/*@Field usersRolePrivs : 用户角色ID   UsersRolePrivs(用户角色表，角色表和用户表的中间表-字段ID)   */
	private Set<UsersRolePrivs> usersRolePrivs;
	
	/*@Field dictProteam : 班组ID  DICT_PROTEAM(班组表)-字段ID       */
	private DictProteam dictProteam;
	
	/*@Field status : 激活：0、激活；1、没激活       */
	private int status;
	
	/*@Field userName : 用户姓名     */
	private String userName;
	
	/*@Field jobNum : 工号       */
	private String jobNum;
	
	/*@Field cardNum : 卡号      */
	private String cardNum;
	
	/*@Field password : 密码       */
	private String password;
	
	/*@Field gender : 性别：0、男；1、女      */
	private int gender;
	
	/*@Field py : 拼音       */
	private String py;
	
	/*@Field remark : 备注     */
	private String remark;
	
	/*@Field DepartProteamStatus: 人员班组部门属性判别字段：0、属于部门1、属于班组；2、即属于部门又属于班组，初始值-1，方便查询时的判断*/
	private Integer departProteamStatus=-1;
     
	/*@pjSDInfoRecordSpsForStoreUsersId @配件仓库动态信息记录表-子表，配件移库[主仓库和班组仓库]  仓库人员ID*/
	private Set pjSDInfoRecordSpsForStoreUsersId = new HashSet(0);
	
	/*@pjSDInfoRecordSpsForStoreUsersId @配件仓库动态信息记录表-子表，配件移库[主仓库和班组仓库]  班组人员ID*/
	private Set pjSDInfoRecordPpsForProteamUsersBId = new HashSet(0);
	
	/*@pjSDInfoRecordPpsForProteamUsersAId 配件仓库动态信息记录表-子表，配件移库[班组仓库和班组仓库] 班组人员AID，A是一个变量，代表A班组的一个人*/
	private Set pjSDInfoRecordPpsForProteamUsersAId = new HashSet(0);
	
	/*@pjSDInfoRecordPpsForProteamUsersAId 配件仓库动态信息记录表-子表，配件移库[班组仓库和班组仓库] 班组人员AID，B是一个变量，代表B班组的一个人*/
	private Set pjSDInfoRecordSpsForProteamUsersId = new HashSet(0);
	
	/*@PjSDInfoRecordSu 配件仓库动态信息记录表-子表，新件入库[主仓库和单位]  仓库人员ID*/
	private Set PjSDInfoRecordSu = new HashSet(0);
	
	/*@PjSDIRecordFixCheck  配件动态信息检修记录，卡控信息   工长*/
	private Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForLeadUsers;
	
	/*@PjSDIRecordFixCheck  配件动态信息检修记录，卡控信息  交车 工长*/
	private Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForCommitLeadUsers;
	
	/*@PjSDIRecordFixCheck  配件动态信息检修记录，卡控信息   质检员工长*/
	private Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForQcUsers;
	
	/*@PjSDIRecordFixCheck  配件动态信息检修记录，卡控信息   验收员工长*/
	private Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForAcceUsers;
	
	/*@PjSDIRecordFixCheck  配件动态信息检修记录，卡控信息  技术员工长*/
	private Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForTechUsers;
	
	/*@PjSDIRecordFixCheck  配件动态信息检修记录，卡控信息   复探工长*/
	private Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForTMUsers;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getDepartProteamStatus() {
		return departProteamStatus;
	}

	public void setDepartProteamStatus(int departProteamStatus) {
		this.departProteamStatus = departProteamStatus;
	}

	public DictArea getDictArea() {
		return this.dictArea;
	}

	public void setDictArea(DictArea dictArea) {
		this.dictArea = dictArea;
	}

	public DictProteam getDictProteam() {
		return this.dictProteam;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}

	public DictDepart getDictDepart() {
		return this.dictDepart;
	}

	public void setDictDepart(DictDepart dictDepart) {
		this.dictDepart = dictDepart;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobNum() {
		return this.jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getPjSDInfoRecordSpsForStoreUsersId() {
		return this.pjSDInfoRecordSpsForStoreUsersId;
	}

	public void setPjSDInfoRecordSpsForStoreUsersId(
			Set pjSDInfoRecordSpsForStoreUsersId) {
		this.pjSDInfoRecordSpsForStoreUsersId = pjSDInfoRecordSpsForStoreUsersId;
	}

	public Set getPjSDInfoRecordPpsForProteamUsersBId() {
		return this.pjSDInfoRecordPpsForProteamUsersBId;
	}

	public void setPjSDInfoRecordPpsForProteamUsersBId(
			Set pjSDInfoRecordPpsForProteamUsersBId) {
		this.pjSDInfoRecordPpsForProteamUsersBId = pjSDInfoRecordPpsForProteamUsersBId;
	}

	public Set getPjSDInfoRecordPpsForProteamUsersAId() {
		return this.pjSDInfoRecordPpsForProteamUsersAId;
	}

	public void setPjSDInfoRecordPpsForProteamUsersAId(
			Set pjSDInfoRecordPpsForProteamUsersAId) {
		this.pjSDInfoRecordPpsForProteamUsersAId = pjSDInfoRecordPpsForProteamUsersAId;
	}

	public Set getPjSDInfoRecordSpsForProteamUsersId() {
		return this.pjSDInfoRecordSpsForProteamUsersId;
	}

	public void setPjSDInfoRecordSpsForProteamUsersId(
			Set pjSDInfoRecordSpsForProteamUsersId) {
		this.pjSDInfoRecordSpsForProteamUsersId = pjSDInfoRecordSpsForProteamUsersId;
	}

	public Set<UsersRolePrivs> getUsersRolePrivs() {
		return usersRolePrivs;
	}

	public void setUsersRolePrivs(Set<UsersRolePrivs> usersRolePrivs) {
		this.usersRolePrivs = usersRolePrivs;
	}

	public Set getPjSDInfoRecordSu() {
		return PjSDInfoRecordSu;
	}

	public void setPjSDInfoRecordSu(Set pjSDInfoRecordSu) {
		PjSDInfoRecordSu = pjSDInfoRecordSu;
	}

	public Set<PjSDIRecordFixCheck> getPjSDIRecordFixChecksForLeadUsers() {
		return pjSDIRecordFixChecksForLeadUsers;
	}

	public void setPjSDIRecordFixChecksForLeadUsers(
			Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForLeadUsers) {
		this.pjSDIRecordFixChecksForLeadUsers = pjSDIRecordFixChecksForLeadUsers;
	}

	public Set<PjSDIRecordFixCheck> getPjSDIRecordFixChecksForCommitLeadUsers() {
		return pjSDIRecordFixChecksForCommitLeadUsers;
	}

	public void setPjSDIRecordFixChecksForCommitLeadUsers(
			Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForCommitLeadUsers) {
		this.pjSDIRecordFixChecksForCommitLeadUsers = pjSDIRecordFixChecksForCommitLeadUsers;
	}

	public Set<PjSDIRecordFixCheck> getPjSDIRecordFixChecksForQcUsers() {
		return pjSDIRecordFixChecksForQcUsers;
	}

	public void setPjSDIRecordFixChecksForQcUsers(
			Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForQcUsers) {
		this.pjSDIRecordFixChecksForQcUsers = pjSDIRecordFixChecksForQcUsers;
	}

	public Set<PjSDIRecordFixCheck> getPjSDIRecordFixChecksForAcceUsers() {
		return pjSDIRecordFixChecksForAcceUsers;
	}

	public void setPjSDIRecordFixChecksForAcceUsers(
			Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForAcceUsers) {
		this.pjSDIRecordFixChecksForAcceUsers = pjSDIRecordFixChecksForAcceUsers;
	}

	public Set<PjSDIRecordFixCheck> getPjSDIRecordFixChecksForTechUsers() {
		return pjSDIRecordFixChecksForTechUsers;
	}

	public void setPjSDIRecordFixChecksForTechUsers(
			Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForTechUsers) {
		this.pjSDIRecordFixChecksForTechUsers = pjSDIRecordFixChecksForTechUsers;
	}

	public Set<PjSDIRecordFixCheck> getPjSDIRecordFixChecksForTMUsers() {
		return pjSDIRecordFixChecksForTMUsers;
	}

	public void setPjSDIRecordFixChecksForTMUsers(
			Set<PjSDIRecordFixCheck> pjSDIRecordFixChecksForTMUsers) {
		this.pjSDIRecordFixChecksForTMUsers = pjSDIRecordFixChecksForTMUsers;
	}

	public void setDepartProteamStatus(Integer departProteamStatus) {
		this.departProteamStatus = departProteamStatus;
	}

	
}