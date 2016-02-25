package com.repair.util.smartTips;

/**
* @ClassName: SmartTips
* @Description: TODO(文本框联想输入提示所需bean类（json格式）)
* @author 周云韬
* @version V1.0  
* @date 2015-9-16 下午4:55:56
 */
public class SmartTips {
	private String id;
	private String name;
	private String py;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}
	
	public SmartTips() {
		// TODO Auto-generated constructor stub
	}

	public SmartTips(String id, String name, String py) {
		super();
		this.id = id;
		this.name = name;
		this.py = py;
	}
	
}
