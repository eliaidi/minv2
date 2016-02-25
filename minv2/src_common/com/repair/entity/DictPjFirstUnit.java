package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
* @ClassName: DictPjFirstUnit
* @Description: TODO(大部件专业实体类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午02:52:56
 */
public class DictPjFirstUnit implements java.io.Serializable {
	
	/** @Fields id : 主键*/
	private long id;
	
	/** @Fields firstUnitName :大部件专业名*/
	private String firstUnitName;
	
	/** @Fields py : 拼音*/
	private String py;
	
	/** @Fields remark : 备注*/
	private String remark;
	
	/** @Fields jcTypePjFirstUnits : 机车型号-大部件（专业）中间实体*/
	private Set jcTypePjFirstUnits = new HashSet(0);


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstUnitName() {
		return this.firstUnitName;
	}

	public void setFirstUnitName(String firstUnitName) {
		this.firstUnitName = firstUnitName;
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

	public Set getJcTypePjFirstUnits() {
		return this.jcTypePjFirstUnits;
	}

	public void setJcTypePjFirstUnits(Set jcTypePjFirstUnits) {
		this.jcTypePjFirstUnits = jcTypePjFirstUnits;
	}



	@Override
	public String toString() {
		return "DictPjFirstUnit [firstUnitName=" + firstUnitName + ", id=" + id
				+ ", py=" + py + ", remark=" + remark + "]";
	}

	
}