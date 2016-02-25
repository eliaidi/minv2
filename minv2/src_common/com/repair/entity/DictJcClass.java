package com.repair.entity;

/**
 * 
 * @see 机车类型
 * @author 周云韬
 * @date 2015-12-15
 * @version 1.0
 */
public class DictJcClass implements java.io.Serializable{
	
	/* @Field id： 主键 */
	private Long id;
	
	/* @Field jcClassName：机车类型名 */
	private String jcClassName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJcClassName() {
		return jcClassName;
	}

	public void setJcClassName(String jcClassName) {
		this.jcClassName = jcClassName;
	}
	
	
}
