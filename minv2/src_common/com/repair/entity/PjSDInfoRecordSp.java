package com.repair.entity;


/**
 * 
* @ClassName: PjSDInfoRecordSp
* @Description: TODO 配件移库（主仓库和班组仓库）
* @author 周云韬
* @version V1.0  
* @date 2015-8-28 下午3:12:29
 */
public class PjSDInfoRecordSp implements java.io.Serializable {
	/**  @Field  */
	private long id;
	
	/**  @Field  storeUsers ：仓库人员*/
	private UsersPrivs storeUsers;
	
	/**  @Field  proteamUsers：班组人员*/
	private UsersPrivs proteamUsers;
	
	/**  @Field  pjSDInfoRecordSu：配件仓库动态信息记录-子表，新件入库（主仓库和单位）*/
	private PjSDInfoRecord pjSDInfoRecord;
	
	/**  @Field remark：备注 */
	private String remark;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PjSDInfoRecord getPjSDInfoRecord() {
		return pjSDInfoRecord;
	}

	public void setPjSDInfoRecord(PjSDInfoRecord pjSDInfoRecord) {
		this.pjSDInfoRecord = pjSDInfoRecord;
	}

	public UsersPrivs getStoreUsers() {
		return storeUsers;
	}

	public void setStoreUsers(UsersPrivs storeUsers) {
		this.storeUsers = storeUsers;
	}

	public UsersPrivs getProteamUsers() {
		return proteamUsers;
	}

	public void setProteamUsers(UsersPrivs proteamUsers) {
		this.proteamUsers = proteamUsers;
	}
	
	

}