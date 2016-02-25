package com.repair.entity;

import java.util.Date;
import java.util.Set;

/**
 * @see 机车检修主记录
 * @author 周云韬
 * @version 1.0
 * @date 2015-11-12
 */
public class JcMainPlan  implements java.io.Serializable{
	private Long id;
	
	
	private Date startTime;
	
	private Date endTime;
	
	private String title;
	
	private String maker;
	
	private Date makeTime;
	
	private Integer status;
	
	
	private String remark;

	private Set<JcMainPlanRecorder> planRecorderSet;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public Date getMakeTime() {
		return makeTime;
	}


	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	


	public String getMaker() {
		return maker;
	}


	public void setMaker(String maker) {
		this.maker = maker;
	}


	


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Set<JcMainPlanRecorder> getPlanRecorderSet() {
		return planRecorderSet;
	}


	public void setPlanRecorderSet(Set<JcMainPlanRecorder> planRecorderSet) {
		this.planRecorderSet = planRecorderSet;
	}


	
}
