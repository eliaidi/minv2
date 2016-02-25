package com.repair.util.ganged;

/**
* @ClassName: Ganged
* @Description: TODO 下拉框联动查询时需要使用的实体类
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午3:56:06
 */
public class Ganged {
	/** @Field ID：option的value */
	private String value;
	
	/** @Field value ：option所显示的值*/
	private String showValue;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

	public Ganged(String value, String showValue) {
		super();
		this.value = value;
		this.showValue = showValue;
	}


	public Ganged() {
		// TODO Auto-generated constructor stub
	}
	
}
