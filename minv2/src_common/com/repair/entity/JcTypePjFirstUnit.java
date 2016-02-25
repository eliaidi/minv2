package com.repair.entity;

import java.util.Set;

/**
 * 
* @ClassName: JcTypePjFirstUnit
* @Description: TODO(机车型号大部件（专业）中间表实体类)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 上午10:18:31
 */

public class JcTypePjFirstUnit implements java.io.Serializable {
	
	/** @Field  id：主键 */
	private long id;
	
	/** @Field  dictPjFirstUnit：大部件（专业）表 */
	private DictPjFirstUnit dictPjFirstUnit;
	
	/** @Field  dictJcType：机车型号表 */
	private DictJcType dictJcType;
	
	/** @Field  pjStaticJcTypePjFUs：配件仓库静态/基本信息_机车型号_大部件（专业）中间表-中间表 */
	private Set<PjStaticJcTypePjFU> pjStaticJcTypePjFUs;
	
	
	

	public Set<PjStaticJcTypePjFU> getPjStaticJcTypePjFUs() {
		return pjStaticJcTypePjFUs;
	}

	public void setPjStaticJcTypePjFUs(Set<PjStaticJcTypePjFU> pjStaticJcTypePjFUs) {
		this.pjStaticJcTypePjFUs = pjStaticJcTypePjFUs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DictPjFirstUnit getDictPjFirstUnit() {
		return this.dictPjFirstUnit;
	}

	public void setDictPjFirstUnit(DictPjFirstUnit dictPjFirstUnit) {
		this.dictPjFirstUnit = dictPjFirstUnit;
	}

	public DictJcType getDictJcType() {
		return this.dictJcType;
	}

	public void setDictJcType(DictJcType dictJcType) {
		this.dictJcType = dictJcType;
	}

}