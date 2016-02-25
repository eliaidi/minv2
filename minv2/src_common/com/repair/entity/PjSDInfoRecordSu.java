package com.repair.entity;



/**
 * 
* @ClassName: PjSDInfoRecordSu
* @Description: TODO(配件仓库动态信息记录表-字表，新建入库【主仓库和单位】)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 上午10:20:28
 */
public class PjSDInfoRecordSu implements java.io.Serializable {


	/**  @Filed   */
	private long id;
	
	/**  @Filed pjSDInfoRecord：动态配件出入库记录  */
	private PjSDInfoRecord pjSDInfoRecord;
	
	/**	 @Filed usersPrivs: 用户表 ,一般指收件人员，仓库人员	*/
	private UsersPrivs usersPrivs;
	
	/**  @Filed  correlationUnit：相关单位，一般指送货单位 */
	private String correlationUnit;
	
	/**  @Filed  correlationName：相关单位人员，一般指送货人 */
	private String correlationName;
	/**  @Filed  备注 */
	private String remark;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PjSDInfoRecord getPjSDInfoRecord() {
		return this.pjSDInfoRecord;
	}

	public void setPjSDInfoRecord(PjSDInfoRecord pjSDInfoRecord) {
		this.pjSDInfoRecord = pjSDInfoRecord;
	}

	public String getCorrelationUnit() {
		return this.correlationUnit;
	}

	public void setCorrelationUnit(String correlationUnit) {
		this.correlationUnit = correlationUnit;
	}

	public String getCorrelationName() {
		return this.correlationName;
	}

	public void setCorrelationName(String correlationName) {
		this.correlationName = correlationName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public UsersPrivs getUsersPrivs() {
		return usersPrivs;
	}

	public void setUsersPrivs(UsersPrivs usersPrivs) {
		this.usersPrivs = usersPrivs;
	}

	
}