package com.repair.entity;

/**
 * 
 * @see 机车检修流程节点_机车修程修次中间表，该节点下的适应修程修次集合
 * @author 周云韬
 * @date 2015-12-15
 * @version 1.0
 */
public class FixFlowFixMileage implements java.io.Serializable{
	/* @Field  id:主键 */
	private Long id;
	
	/* @Field  fixMileage:修次 */
	private DictJcFixMileage fixMileage;

	/* @Field  jcType:流程节点 */
	private JcFixFlow fixFlow;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public DictJcFixMileage getFixMileage() {
		return fixMileage;
	}

	public void setFixMileage(DictJcFixMileage fixMileage) {
		this.fixMileage = fixMileage;
	}

	public JcFixFlow getFixFlow() {
		return fixFlow;
	}

	public void setFixFlow(JcFixFlow fixFlow) {
		this.fixFlow = fixFlow;
	}
	
	
}
