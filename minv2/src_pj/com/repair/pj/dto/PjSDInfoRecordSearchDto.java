package com.repair.pj.dto;

import java.sql.Date;
import com.repair.util.splitPage.SearchDto;

/** 
* @ClassName: PjSDInfoRecordSearchDto
* @Description: TODO	配件出入库记录多条件查询所需要使用的数据传输对象
* @author 周云韬
* @version V1.0  
* @date 2015-9-9 下午4:33:15
 */
public class PjSDInfoRecordSearchDto extends SearchDto {
	
	/** @Field receivingDeliverStatus : 是入库，还是出库（移库）：0、入库，1、出库（移库）*/
	private Long[] receivingDeliverStatus;
		
	/** @Field storeUnitProteamStatus : 0、主仓库-班组仓库，出库入库；1、班组仓库-班组仓库，出库入库；2、主仓库-相关单位-出库入库*/
	private Long[] storeUnitProteamStatus;
	
	/** @Field storeUsersName：仓库人员 */
	private String storeUsersName;
	
	/** @Field pjdCode：配件编码 */
	private String pjdCode;
	
	/** @Field pjName：配件名称*/
	private String pjName;
	
	/** @Field firstUnitName：专业名称*/
	private String firstUnitName;
	
	/** @Field storePositionId：仓库Id*/
	private Long storePositionId;
	
	/** @Field correlationName：相关单位人员*/
	private String correlationName;
	
	/** @Field proteamUsersName：班组单位人员*/
	private String proteamUsersName;
	
	/** @Field startRecordTime：记录开始时间*/
	private Date startRecordTime;
	
	/** @Field endRecordTime：记录结束时间*/
	private Date endRecordTime;
	
	public Long[] getReceivingDeliverStatus() {
		return receivingDeliverStatus;
	}

	public void setReceivingDeliverStatus(Long[] receivingDeliverStatus) {
		this.receivingDeliverStatus = receivingDeliverStatus;
	}

	public Long[] getStoreUnitProteamStatus() {
		return storeUnitProteamStatus;
	}

	public void setStoreUnitProteamStatus(Long[] storeUnitProteamStatus) {
		this.storeUnitProteamStatus = storeUnitProteamStatus;
	}

	public String getStoreUsersName() {
		return storeUsersName;
	}

	public void setStoreUsersName(String storeUsersName) {
		this.storeUsersName = storeUsersName;
	}

	public String getPjdCode() {
		return pjdCode;
	}

	public void setPjdCode(String pjdCode) {
		this.pjdCode = pjdCode;
	}

	public String getPjName() {
		return pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public String getFirstUnitName() {
		return firstUnitName;
	}

	public void setFirstUnitName(String firstUnitName) {
		this.firstUnitName = firstUnitName;
	}

	public Long getStorePositionId() {
		return storePositionId;
	}

	public void setStorePositionId(Long storePositionId) {
		this.storePositionId = storePositionId;
	}

	public String getCorrelationName() {
		return correlationName;
	}

	public void setCorrelationName(String correlationName) {
		this.correlationName = correlationName;
	}

	public Date getStartRecordTime() {
		return startRecordTime;
	}

	public void setStartRecordTime(Date startRecordTime) {
		this.startRecordTime = startRecordTime;
	}

	public Date getEndRecordTime() {
		return endRecordTime;
	}

	public void setEndRecordTime(Date endRecordTime) {
		this.endRecordTime = endRecordTime;
	}

	public String getProteamUsersName() {
		return proteamUsersName;
	}

	public void setProteamUsersName(String proteamUsersName) {
		this.proteamUsersName = proteamUsersName;
	}
	
}
