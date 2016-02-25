package com.repair.entity;

import java.util.Date;


/**
* @ClassName: PjSDInfoRecordFix
* @Description: TODO(实体类)
* @author lxb
* @version V1.0  
* @date 2015-9-21 上午9:32:01
 */
public class PjSDInfoRecordFix  implements java.io.Serializable{
	/*@Field id : 主键 */
	private long id;
	
	/*@Field pjSDInfoRecord :  配件仓库动态信息记录表，出库入库记录主表*/
	private PjSDInfoRecord pjSDInfoRecord;
	
	/*@Field  : 机车检修日计划表Set*/
	/**private JcPlanDate jcPlanDate;*/
	
	/*@Field  : 检修项目表Set*/
	private PjFixItem pjFixItem;
	
	/*@Field  : 班组表Set*/
	private DictProteam dictProteam;
	
	/*@Field  : 检修卡控节点（ 0、新建；1、已派工；2 、 检修人签认； 3、工长验收；4、交车工长验收；5、技术员验收；6、质检员验*/
	private int fixCheckNode;
	
	/*@Field  : 检修人ID字符串组合，可以表示一个或多个检修人，存储方式：1,2,4,7,6；逗号隔开的ID号不能重复。表示多个工人维修一个*/
	private String fixUsersIds;
	
	/*@Field  : 检修人签认时间（如果有多位检修人，只要其中一位检修人签认时间，表示该配件确认检修完）*/
	private Date fixTime;
	
	/*@Field  : 检修状态，0禁用，1启用*/
	private Integer fixItemStatus;
	
	/*@Field  : 检修情况（当这条记录有了后，检修情况才能修改，如果有两位检修工人，他们都可以修改检修情况）*/
	private String fixCondition;
	
	/*@Field  : 配件动态信息检修记录，卡控信息Set*/
	private PjSDIRecordFixCheck pjSDIRecordFixCheck;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PjSDInfoRecord getPjSDInfoRecord() {
		return pjSDInfoRecord;
	}

	public void setPjSDInfoRecord(PjSDInfoRecord pjSDInfoRecord) {
		this.pjSDInfoRecord = pjSDInfoRecord;
	}

	public PjFixItem getPjFixItem() {
		return pjFixItem;
	}

	public void setPjFixItem(PjFixItem pjFixItem) {
		this.pjFixItem = pjFixItem;
	}

	public DictProteam getDictProteam() {
		return dictProteam;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}

	public int getFixCheckNode() {
		return fixCheckNode;
	}

	public void setFixCheckNode(int fixCheckNode) {
		this.fixCheckNode = fixCheckNode;
	}

	public String getFixUsersIds() {
		return fixUsersIds;
	}


	public void setFixUsersIds(String fixUsersIds) {
		this.fixUsersIds = fixUsersIds;
	}

	

	public Date getFixTime() {
		return fixTime;
	}

	public void setFixTime(Date fixTime) {
		this.fixTime = fixTime;
	}

	public String getFixCondition() {
		return fixCondition;
	}

	public void setFixCondition(String fixCondition) {
		this.fixCondition = fixCondition;
	}

	public PjSDIRecordFixCheck getPjSDIRecordFixCheck() {
		return pjSDIRecordFixCheck;
	}

	public void setPjSDIRecordFixCheck(PjSDIRecordFixCheck pjSDIRecordFixCheck) {
		this.pjSDIRecordFixCheck = pjSDIRecordFixCheck;
	}

	public Integer getFixItemStatus() {
		return fixItemStatus;
	}

	public void setFixItemStatus(Integer fixItemStatus) {
		this.fixItemStatus = fixItemStatus;
	}

	

}
