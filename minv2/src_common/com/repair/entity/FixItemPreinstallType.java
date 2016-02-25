package com.repair.entity;

import java.io.Serializable;

/**
 * 
 * @see 检修项目预设分类主表（常规项目，中修和小辅修，以及走小辅修流程的项目）
 * @author 周云韬
 * @date 2016-1-5
 * @version 1.0
 */
public class FixItemPreinstallType implements Serializable{

	/** @Field id：主键 */
	private long id;
	
	/** @Field preinstallTypeName： 预设分类名称*/
	private String preinstallTypeName;
	
	/** @Field jcTypes： 机车型号（如：DF1，HX1）*/
	private String jcTypes;
	
	/** @Field proteam：班组 */
	private DictProteam  proteam;
	
	/** @Field fixFlow：机车检修流程节点表ID */
	private JcFixFlow fixFlow;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPreinstallTypeName() {
		return preinstallTypeName;
	}

	public void setPreinstallTypeName(String preinstallTypeName) {
		this.preinstallTypeName = preinstallTypeName;
	}

	public String getJcTypes() {
		return jcTypes;
	}

	public void setJcTypes(String jcTypes) {
		this.jcTypes = jcTypes;
	}

	public DictProteam getProteam() {
		return proteam;
	}

	public void setProteam(DictProteam proteam) {
		this.proteam = proteam;
	}

	public JcFixFlow getFixFlow() {
		return fixFlow;
	}

	public void setFixFlow(JcFixFlow fixFlow) {
		this.fixFlow = fixFlow;
	}
	
}
