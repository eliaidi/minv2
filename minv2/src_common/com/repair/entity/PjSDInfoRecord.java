package com.repair.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 
* @ClassName: PjSDInfoRecord
* @Description: TODO(配件仓库动态信息记录表，出库入库记录主表实体类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午03:19:09
 */

public class PjSDInfoRecord implements java.io.Serializable {

	/** @Fields id : 主键*/
	private long id;
	
	/** @Fields id : 配件仓库动态信息/库存（所在位置）*/
	private PjStoreDynamicInfo pjStoreDynamicInfo;
	
	/** @Fields id : 是入库，还是出库（移库）：0、入库，1、出库（移库）*/
	private long receivingDeliverStatus;
	
	/** @Fields id : 0、主仓库-班组仓库，出库入库；1、班组仓库-班组仓库，出库入库；2、主仓库-相关单位-出库入库*/
	private long storeUnitProteamStatus;
	
	/** @Fields id : 记录时间*/
	private Date recordTime;
	
	/** @Fields remark : 备注*/
	private String remark;
	
	/** @Fields pjSDInfoRecordSus :配件仓库动态信息记录表-子表，新件入库[主仓库和单位]*/
	private Set pjSDInfoRecordSus = new HashSet(0);
	
	/** @Fields pjSDInfoRecordSps :配件仓库动态信息记录表-子表，配件移库[主仓库和班组仓库]*/
	private Set pjSDInfoRecordSps = new HashSet(0);
	
	/**  @Fields pjSDInfoRecordPps :配件仓库动态信息记录表-子表，配件移库[班组仓库和班组仓库]*/
	private Set pjSDInfoRecordPps = new HashSet(0);
	
	/**  @Fields pjSDInfoRecordFixs :配件仓库动态信息记录表-子表，动态配件检修记录集合*/
	private Set<PjSDInfoRecordFix> pjSDInfoRecordFixs=new HashSet<PjSDInfoRecordFix>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReceivingDeliverStatus() {
		return receivingDeliverStatus;
	}

	public void setReceivingDeliverStatus(long receivingDeliverStatus) {
		this.receivingDeliverStatus = receivingDeliverStatus;
	}

	public long getStoreUnitProteamStatus() {
		return storeUnitProteamStatus;
	}

	public void setStoreUnitProteamStatus(long storeUnitProteamStatus) {
		this.storeUnitProteamStatus = storeUnitProteamStatus;
	}

	public PjStoreDynamicInfo getPjStoreDynamicInfo() {
		return this.pjStoreDynamicInfo;
	}

	public void setPjStoreDynamicInfo(PjStoreDynamicInfo pjStoreDynamicInfo) {
		this.pjStoreDynamicInfo = pjStoreDynamicInfo;
	}

	

	

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getPjSDInfoRecordSus() {
		return this.pjSDInfoRecordSus;
	}

	public void setPjSDInfoRecordSus(Set pjSDInfoRecordSus) {
		this.pjSDInfoRecordSus = pjSDInfoRecordSus;
	}

	public Set getPjSDInfoRecordSps() {
		return pjSDInfoRecordSps;
	}

	public void setPjSDInfoRecordSps(Set pjSDInfoRecordSps) {
		this.pjSDInfoRecordSps = pjSDInfoRecordSps;
	}

	public Set getPjSDInfoRecordPps() {
		return pjSDInfoRecordPps;
	}

	public void setPjSDInfoRecordPps(Set pjSDInfoRecordPps) {
		this.pjSDInfoRecordPps = pjSDInfoRecordPps;
	}

	public Set<PjSDInfoRecordFix> getPjSDInfoRecordFixs() {
		return pjSDInfoRecordFixs;
	}

	public void setPjSDInfoRecordFixs(Set<PjSDInfoRecordFix> pjSDInfoRecordFixs) {
		this.pjSDInfoRecordFixs = pjSDInfoRecordFixs;
	}

	
}