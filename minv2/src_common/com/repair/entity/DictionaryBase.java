package com.repair.entity;

/**
* @ClassName: DictionaryBaseCache
* @Description: 基础数据字典实体类
* @author andy
* @version V1.0  
* @date 2015-07-17 下午 3:09:34 
*/
public class DictionaryBase implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	/** @Fields id : 主键*/
	private long id;
	
	/** @Fields codeType : 类型码*/
	private String codeType;
	
	/** @Fields typeDesc : 类型码描述*/
	private String typeDesc;
	
	/** @Fields key : 数据键*/
	private String key;
	
	/** @Fields value : 数据值*/
	private String value;
	
	/** @Fields isValid : 是否有效或可见：0否，1是*/
	private Integer isValid;
	
	/** @Fields orderId : 排序*/
	private Integer orderId;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
