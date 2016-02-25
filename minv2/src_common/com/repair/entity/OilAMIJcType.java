package com.repair.entity;

import java.io.Serializable;

/**
 * 
 * @see 机车油水化验项目主表_机车类型中间表，该主表下适应机车类型集合（A代表ASSAY【化验】，M代表MAIN【主要的】，I代表ITEM【项目】，OilAMIJcType为建议实体类名。）
 * @author 周云韬
 * @date 2015-12-21
 * @version 1.0
 */
public class OilAMIJcType implements Serializable{
	
	/* @Field    id：主键 */
	private Long id;
	
	/* @Field    item：机车油水化验项目主表ID */
	private OilAssayMainItem item;
	
	/* @Field   jcType ：机车型号表ID */
	private DictJcType jcType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OilAssayMainItem getItem() {
		return item;
	}

	public void setItem(OilAssayMainItem item) {
		this.item = item;
	}

	public DictJcType getJcType() {
		return jcType;
	}

	public void setJcType(DictJcType jcType) {
		this.jcType = jcType;
	}
	
	
	
}
