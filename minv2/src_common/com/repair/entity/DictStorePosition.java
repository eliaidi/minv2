package com.repair.entity;

import java.util.HashSet;
import java.util.Set;
import com.repair.util.splitPage.SearchDto;

/**
 * 
* @ClassName: DictStorePosition
* @Description: TODO(配件所在位子/仓库实体类用)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-28 下午03:03:59
 */
public class DictStorePosition extends SearchDto implements java.io.Serializable {

	/** @Fields id : 主键*/
	private long id;
	
	/** @FieldsdictArea : 地区/机务段*/
	private DictArea dictArea;
	
	/** @Fields storePositionName : 位置/仓库名*/
	private String storePositionName;
	
	/** @Fields storePositionType : 位置/仓库类型：0、平库；1、立库；2、班组库；3、车上；4、配件上；5、外地*/
	private int storePositionType = -1;
	
	/** @Fields py : 拼音*/
	private String py;
	
	/** @Fields remark : 备注*/
	private String remark;
	
	/** @Fields pjStoreDynamicInfos : 配件仓库动态信息/库存（所在位置）*/
	private Set pjStoreDynamicInfos = new HashSet(0);
	
	/** @Fields	DICT_PROTEAM 班组信息*/
	private DictProteam dictProteam;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DictArea getDictArea() {
		return this.dictArea;
	}

	public void setDictArea(DictArea dictArea) {
		this.dictArea = dictArea;
	}

	public String getStorePositionName() {
		return this.storePositionName;
	}

	public void setStorePositionName(String storePositionName) {
		this.storePositionName = storePositionName;
	}

	public int getStorePositionType() {
		return this.storePositionType;
	}

	public void setStorePositionType(int storePositionType) {
		this.storePositionType = storePositionType;
	}

	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getPjStoreDynamicInfos() {
		return this.pjStoreDynamicInfos;
	}

	public void setPjStoreDynamicInfos(Set pjStoreDynamicInfos) {
		this.pjStoreDynamicInfos = pjStoreDynamicInfos;
	}

	public DictProteam getDictProteam() {
		return dictProteam;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}
}