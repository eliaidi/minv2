package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DictArea
 * @Description: TODO(功能表实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class FunctionPrivs implements java.io.Serializable {
    
	// Fields
	/*@Field id : 主键       */
	private long id;
	
	/*@Field functionName : 菜单(操作功能)名       */
	private String functionName;
	
	/*@Field url :菜单URL       */
	private String url;
	
	/*@Field parentId :父级，菜单（操作功能)名ID      */
	private String parentid;
	
	/*@Field status :激活：0、激活；1、没激活     */
	private int status;
	
	/*@Field functionOrder :菜单(操作功能)名顺序    */	
	private int functionOrder;
	
	/*@Field remark :备注   */
	private String remark;
	
	/*@Field roleFunctionPrivses :角色功能表  */
	private Set roleFunctionPrivses = new HashSet(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFunctionOrder() {
		return functionOrder;
	}

	public void setFunctionOrder(int functionOrder) {
		this.functionOrder = functionOrder;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getRoleFunctionPrivses() {
		return this.roleFunctionPrivses;
	}

	public void setRoleFunctionPrivses(Set roleFunctionPrivses) {
		this.roleFunctionPrivses = roleFunctionPrivses;
	}

}