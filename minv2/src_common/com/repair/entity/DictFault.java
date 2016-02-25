package com.repair.entity;

import java.io.Serializable;

/**
 * 
 * @see 故障字典表(此功能放入dict字典模块)
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class DictFault implements Serializable{
	/** @Field id：主键 */
	private Long id;
	
	/** @Field unitType： 部件种类表示符（0、一级部件；1、二级部件；2、三级部件） */
	private Integer unitType;
	
	/** @Field parent：父级ID */
	private DictFault parent;
	
	/** @Field unitName： 部件名称 */
	private String unitName;
	
	/** @Field faultContent： 故障内容*/
	private String faultContent;
	
	/** @Field fixContent：检修处理意见 */
	private String fixContent;
	
	/** @Field score： 分数（默认值1）*/
	private Double score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUnitType() {
		return unitType;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	public DictFault getParent() {
		return parent;
	}

	public void setParent(DictFault parent) {
		this.parent = parent;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getFaultContent() {
		return faultContent;
	}

	public void setFaultContent(String faultContent) {
		this.faultContent = faultContent;
	}

	public String getFixContent() {
		return fixContent;
	}

	public void setFixContent(String fixContent) {
		this.fixContent = fixContent;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
