package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
* @ClassName: DictJcType
* * @Description: TODO(机车型号实体类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午02:36:28
 */
public class DictJcType implements java.io.Serializable {
    
	/** @Field id : 主键*/
	private long id;
	
	/** @Field jcClass : 机车类型*/
	private DictJcClass jcClass;
	
	/** @Field jcTypeValue : 机车型号值*/
	private String jcTypeValue;
	
	/** @Field jcTypePjFirstUnits :大部件专业实体类*/
	private Set<JcTypePjFirstUnit> jcTypePjFirstUnits = new HashSet(0);
	
	/** @Field jcInformations：机车信息履历集合  */
	private Set<JcInformation> jcInformations=new HashSet<JcInformation>(0);
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public DictJcClass getJcClass() {
		return jcClass;
	}

	public void setJcClass(DictJcClass jcClass) {
		this.jcClass = jcClass;
	}

	public String getJcTypeValue() {
		return this.jcTypeValue;
	}

	public void setJcTypeValue(String jcTypeValue) {
		this.jcTypeValue = jcTypeValue;
	}

	public Set getJcTypePjFirstUnits() {
		return this.jcTypePjFirstUnits;
	}

	

	public Set<JcInformation> getJcInformations() {
		return jcInformations;
	}

	public void setJcInformations(Set<JcInformation> jcInformations) {
		this.jcInformations = jcInformations;
	}

	public void setJcTypePjFirstUnits(Set<JcTypePjFirstUnit> jcTypePjFirstUnits) {
		this.jcTypePjFirstUnits = jcTypePjFirstUnits;
	}

	
	
	

}