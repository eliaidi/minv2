package com.repair.pjFix.dto;

import java.sql.Timestamp;
import java.util.Date;
import com.repair.util.splitPage.SearchDto;

/** 
* @ClassName: PjStoreStaticInfoSearchDto
* @Description: TODO  查询静态配件时需要使用的dto，为方便使用分页组件，继承SearchDto类
* @author 周云韬
* @version V1.0  
* @date 2015-9-6 下午3:07:35
 */
public class PjStoreStaticInfoSearchDto extends SearchDto{
	
	//配件编码
	private String pjdCode;
	
	//配件名称
	private String pjName;

	//拼音
	private String py;
	
	//存储仓库ID
	private Long storePositionId;
	
	//班组ID
	private Long proteamId;
	
	//组装状态
	private Long pjAssemblyType;
	
	//启用状态
	private Long pjActivate;
	
	//入库时间
	private Date pjdIntStoreDate;
	
	//大部件（专业）ID
	private Long firstUnitId=null;
	
	//大部件（专业）名称
	private String firstUnitName;

	//机车类型ID
	private Long jcTypeId;
	
	//机车类型
	private String jcType;
	
	//入库时间
	private Timestamp recordTime;
	
	//最小库存
	private boolean minStore;
	
	//静态配件信息
	private Long pjStoreStaticInfoId;
	
	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
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

	public Long getPjActivate() {
		return pjActivate;
	}

	public void setPjActivate(Long pjActivate) {
		this.pjActivate = pjActivate;
	}

	public Long getStorePositionId() {
		return storePositionId;
	}

	public void setStorePositionId(Long storePositionId) {
		this.storePositionId = storePositionId;
	}

	public Date getPjdIntStoreDate() {
		return pjdIntStoreDate;
	}

	public void setPjdIntStoreDate(Date pjdIntStoreDate) {
		this.pjdIntStoreDate = pjdIntStoreDate;
	}

	public String getFirstUnitName() {
		return firstUnitName;
	}

	public void setFirstUnitName(String firstUnitName) {
		this.firstUnitName = firstUnitName;
	}

	public Long getFirstUnitId() {
		return firstUnitId;
	}

	public void setFirstUnitId(Long firstUnitId) {
		this.firstUnitId = firstUnitId;
	}

	public Long getJcTypeId() {
		return jcTypeId;
	}

	public void setJcTypeId(Long jcTypeId) {
		this.jcTypeId = jcTypeId;
	}

	public Long getProteamId() {
		return proteamId;
	}

	public void setProteamId(Long proteamId) {
		this.proteamId = proteamId;
	}

	public Long getPjAssemblyType() {
		return pjAssemblyType;
	}

	public void setPjAssemblyType(Long pjAssemblyType) {
		this.pjAssemblyType = pjAssemblyType;
	}

	public String getJcType() {
		return jcType;
	}

	public void setJcType(String jcType) {
		this.jcType = jcType;
	}

	public Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public boolean isMinStore() {
		return minStore;
	}

	public void setMinStore(boolean minStore) {
		this.minStore = minStore;
	}

	public Long getPjStoreStaticInfoId() {
		return pjStoreStaticInfoId;
	}

	public void setPjStoreStaticInfoId(Long pjStoreStaticInfoId) {
		this.pjStoreStaticInfoId = pjStoreStaticInfoId;
	}

}
