package com.repair.entity;

/**
 * 
 * @see 机车检修流程节点_机车型号级联表，该节点下的适应机车类型集合
 * @author 周云韬
 * @date 2015-12-15
 * @version 1.0
 */
public class JcFixFlowJcType implements java.io.Serializable{
	/* @Field  id:主键 */
	private Long id;
	
	/* @Field  jcType:机车型号 */
	private DictJcType jcType;

	/* @Field  jcType:流程节点 */
	private JcFixFlow fixFlow;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DictJcType getJcType() {
		return jcType;
	}

	public void setJcType(DictJcType jcType) {
		this.jcType = jcType;
	}

	public JcFixFlow getFixFlow() {
		return fixFlow;
	}

	public void setFixFlow(JcFixFlow fixFlow) {
		this.fixFlow = fixFlow;
	}
	
	
}
