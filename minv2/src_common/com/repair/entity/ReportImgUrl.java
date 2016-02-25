package com.repair.entity;

import java.io.Serializable;

/**
 * 
 * @see 报活图片路径表
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class ReportImgUrl implements Serializable{

	private Long id;
	
	private String imgUrl;
	
	private JtReport report;
	
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public JtReport getReport() {
		return report;
	}

	public void setReport(JtReport report) {
		this.report = report;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
