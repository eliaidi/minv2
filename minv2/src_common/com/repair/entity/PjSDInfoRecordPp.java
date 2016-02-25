package com.repair.entity;


/**
 * 
* @ClassName: PjSDInfoRecordPp
* @Description: TODO  配件仓库动态信息记录表-子表，配件移库（班组仓库和班组仓库）
* @author 周云韬
* @version V1.0  
* @date 2015-8-28 下午2:33:05
 */
public class PjSDInfoRecordPp implements java.io.Serializable {

	/** @Field  id */
	private long id;
	
	/** @Field proteamUsersB 班组人员BID B是一个变量，代表B班组的一个人 */
	private UsersPrivs proteamUsersB;
	
	/** @Field pjSDInfoRecord 出库入库记录主表*/
	private PjSDInfoRecord pjSDInfoRecord;
	
	/** @Field proteamUsersA 班组人员AID A是一个变量，代表B班组的一个人 */
	private UsersPrivs proteamUsersA;
	
	/** @Field   remark：备注 */
	private String remark;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	


	public UsersPrivs getProteamUsersB() {
		return proteamUsersB;
	}

	public void setProteamUsersB(UsersPrivs proteamUsersB) {
		this.proteamUsersB = proteamUsersB;
	}

	public UsersPrivs getProteamUsersA() {
		return proteamUsersA;
	}

	public void setProteamUsersA(UsersPrivs proteamUsersA) {
		this.proteamUsersA = proteamUsersA;
	}

	public PjSDInfoRecord getPjSDInfoRecord() {
		return pjSDInfoRecord;
	}

	public void setPjSDInfoRecord(PjSDInfoRecord pjSDInfoRecord) {
		this.pjSDInfoRecord = pjSDInfoRecord;
	}

	
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}