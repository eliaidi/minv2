package com.repair.pjFix.dto;

import java.sql.Date;
import com.repair.util.splitPage.SearchDto;

/**
* @ClassName: PjStoreDynamicInfoSearchDto
* @Description: TODO  查询动态配件时需要使用的dto，为方便使用分页组件，继承SearchDto类
* @author 周云韬
* @version V1.0   
* @date 2015-9-6 下午3:07:35
 */
public class PjStoreDynamicInfoSearchDto extends SearchDto{
	
	/** 静态配件ID */
	private Long pjSSInfoId;
	
	/** 配件编码  */
	private String pjdCode;
	
	/** 配件名称 */
	private String pjName;
	
	/** 存储仓库ID */
	private Long storePositionId;
	
	/** 大部件（专业）名称 */
	private String firstUnitName;
	
	/** 机车类型 */
	private String jcType;
	
	/** 入库日期 */
	private Date recordTime;
	
	/** 专业ID */
	private Long firstUnitId;
	
	/** 车型ID */
	private Long jcTypeId;
	
	/** 配件状态 */
	private Long pjdStatus;
	
	/** 检修项目是否签认完毕标志。
	 *  如果为0，查询此动态配件检修项目未完全签认/卡控的;
	 *  如果为1，查询已经完全签认的项目，
	 *  如果为null,则查询所有检修项目
	 *  和roleType类型一起配合使用
	 *  */
	private Integer fixItemQueryFlag;
	
	/** 角色类型，和fixItemQueryFlag一起配合使用 */
	private Integer roleType;

	public Long getPjdStatus() {
		return pjdStatus;
	}

	public void setPjdStatus(Long pjdStatus) {
		this.pjdStatus = pjdStatus;
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
	
	public Long getStorePositionId() {
		return storePositionId;
	}

	public void setStorePositionId(Long storePositionId) {
		this.storePositionId = storePositionId;
	}
	
	public String getFirstUnitName() {
		return firstUnitName;
	}

	public void setFirstUnitName(String firstUnitName) {
		this.firstUnitName = firstUnitName;
	}

	public String getJcType() {
		return jcType;
	}

	public void setJcType(String jcType) {
		this.jcType = jcType;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getFixItemQueryFlag() {
		return fixItemQueryFlag;
	}

	public void setFixItemQueryFlag(Integer fixItemQueryFlag) {
		this.fixItemQueryFlag = fixItemQueryFlag;
	}

	public Long getPjSSInfoId() {
		return pjSSInfoId;
	}

	public void setPjSSInfoId(Long pjSSInfoId) {
		this.pjSSInfoId = pjSSInfoId;
	}

}
