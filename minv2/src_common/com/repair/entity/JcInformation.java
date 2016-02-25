package com.repair.entity;

import java.sql.Date;

/**
 * 
* @ClassName: JcInformation
* @Description: TODO 机车信息实体类
* @author 周云韬
* @version V1.0  
* @date 2015-9-22 下午2:48:32
 */
public class JcInformation  implements java.io.Serializable{
	/** @Fields id：主键*/
	private long id;
	
	/** @Fields jcNumber：机车编号 */
	private String jcNumber;
	
	
	/** @Fields dictJcType：机车类型*/
	private DictJcType dictJcType;
	
	
	/** @Fields belongToDictArea：机车所属机务段*/
	private DictArea belongToDictArea;
	
	/** @Fields useDictArea：机车使用机务段*/
	private DictArea useDictArea;
	
	/** @Fields jcStatus：机车状态*/
	private Integer jcStatus;
	
	/** @Fields jcMadeTime：机车制造时间*/
	private Date jcMadeTime;
	
	/** @Fields jcAttachTime：配属时间*/
	private Date jcAttachTime;
	
	/** @Fields jcMakeUnit：机车制造单位*/
	private String jcMakeUnit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJcNumber() {
		return jcNumber;
	}

	public void setJcNumber(String jcNumber) {
		this.jcNumber = jcNumber;
	}

	public DictJcType getDictJcType() {
		return dictJcType;
	}

	public void setDictJcType(DictJcType dictJcType) {
		this.dictJcType = dictJcType;
	}

	public DictArea getBelongToDictArea() {
		return belongToDictArea;
	}

	public void setBelongToDictArea(DictArea belongToDictArea) {
		this.belongToDictArea = belongToDictArea;
	}

	public DictArea getUseDictArea() {
		return useDictArea;
	}

	public void setUseDictArea(DictArea useDictArea) {
		this.useDictArea = useDictArea;
	}

	public Integer getJcStatus() {
		return jcStatus;
	}

	public void setJcStatus(Integer jcStatus) {
		this.jcStatus = jcStatus;
	}

	public Date getJcMadeTime() {
		return jcMadeTime;
	}

	public void setJcMadeTime(Date jcMadeTime) {
		this.jcMadeTime = jcMadeTime;
	}

	public Date getJcAttachTime() {
		return jcAttachTime;
	}

	public void setJcAttachTime(Date jcAttachTime) {
		this.jcAttachTime = jcAttachTime;
	}

	public String getJcMakeUnit() {
		return jcMakeUnit;
	}

	public void setJcMakeUnit(String jcMakeUnit) {
		this.jcMakeUnit = jcMakeUnit;
	}
	
	
	
}
