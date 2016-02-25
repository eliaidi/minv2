package com.repair.entity;

import java.util.Set;

/**
 * @see 机车流程节点实体类
 * @author 周云韬
 * @date 2015-11-12
 * @version 1.0
 */
public class JcFixFlow  implements java.io.Serializable{
	/* @Field  id ：主键*/
	private Long id;
	
	/* @Field  fixFlowName ：流程节点名称*/
	private String fixFlowName;
	
	/* @Field  fixFlowOrder ：流程节点序号*/
	private Integer fixFlowOrder;

	/* @Field  fixFlowJcTypeSet ：流程节点机车类型中间表集合*/
	private Set<JcFixFlowJcType> fixFlowJcTypeSet;
	
	/* @Field  fixFlowFixMileageSet ： 流程节点修程修次中间表集合*/
	private Set<FixFlowFixMileage> fixFlowFixMileageSet;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getFixFlowName() {
		return fixFlowName;
	}

	public void setFixFlowName(String fixFlowName) {
		this.fixFlowName = fixFlowName;
	}

	public Integer getFixFlowOrder() {
		return fixFlowOrder;
	}

	public void setFixFlowOrder(Integer fixFlowOrder) {
		this.fixFlowOrder = fixFlowOrder;
	}

	public Set<JcFixFlowJcType> getFixFlowJcTypeSet() {
		return fixFlowJcTypeSet;
	}

	public void setFixFlowJcTypeSet(Set<JcFixFlowJcType> fixFlowJcTypeSet) {
		this.fixFlowJcTypeSet = fixFlowJcTypeSet;
	}

	public Set<FixFlowFixMileage> getFixFlowFixMileageSet() {
		return fixFlowFixMileageSet;
	}

	public void setFixFlowFixMileageSet(Set<FixFlowFixMileage> fixFlowFixMileageSet) {
		this.fixFlowFixMileageSet = fixFlowFixMileageSet;
	}


	
	
	
}
