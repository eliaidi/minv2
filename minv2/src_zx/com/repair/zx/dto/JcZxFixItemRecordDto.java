package com.repair.zx.dto;

import com.repair.util.splitPage.SearchDto;

/**
 * 
 * @see 机车中修项目
 * @author 周云韬
 * @date 2015-12-17
 * @version 1.0
 */
public class JcZxFixItemRecordDto extends SearchDto{

	private Long planDateId;
	
	private Long  proteamId;
	
	private Long firstUnitId;

	public Long getPlanDateId() {
		return planDateId;
	}

	public void setPlanDateId(Long planDateId) {
		this.planDateId = planDateId;
	}

	public Long getProteamId() {
		return proteamId;
	}

	public void setProteamId(Long proteamId) {
		this.proteamId = proteamId;
	}

	public Long getFirstUnitId() {
		return firstUnitId;
	}

	public void setFirstUnitId(Long firstUnitId) {
		this.firstUnitId = firstUnitId;
	}
	
	
	
}
