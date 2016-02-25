package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

import com.repair.util.splitPage.SearchDto;

/**
 * 
* @ClassName: PjStoreStaticInfo
* @Description: TODO  配件仓库静态/基本信息表
* @author 周云韬
* @version V1.0  
* @date 2015-8-28 下午2:59:12
 */
public class PjStoreStaticInfo extends  SearchDto  implements java.io.Serializable{
	
	/**  @Field  id：主键     */
	private long id;
	
	/**  @Field  pjStaticJcTypePjFUs：配件仓库静态/基本信息__机车型号_大部件（专业）中间表 -- 中间表     */
	private Set<PjStaticJcTypePjFU> pjStaticJcTypePjFUs;
	
	/**  @Field   proteamPjStatics：班组-配件仓库静态信息中间表    */
	private Set<ProteamPjStatic> proteamPjStatics;
	
	/**  @Field   parentPjStoreStaticInfo：父级配件    */
	private PjStoreStaticInfo parentPjStoreStaticInfo;
	
	/**  @Field   pjName：配件名称    */
	private String pjName;
	
	/**  @Field    pjLoweStstore：最小库存量   */
	private String pjLoweStstore;
	
	/**  @Field  pjActivate：是否启用：0、不启用；1、启用，默认1     */
	private long pjActivate=1;
	
	/**  @Field  pjAssemblyType：配件组装状态：0、车上组装；1、配件组装     */
	private long pjAssemblyType=-1;
	
	/**  @Field  py：配件名称拼音     */
	private String py;
	
	/**  @Field  remark：备注     */
	private String remark;
	
	/**  @Field childPjStoreStaticInfos：当前配件的所有子配件      */
	private Set childPjStoreStaticInfos = new HashSet(0);
	
	/**  @Field pjStoreDynamicInfos：配件动态表Set      */
	private Set<PjStoreDynamicInfo> pjStoreDynamicInfos;
	
	/**  @Field pjFixItemPreinstallTypes：预设配件检修项目分类表Set      */
	private Set<PjFixItemPreinstallType> pjFixItemPreinstallTypes;
	
	/**  @Field pjFixItems：配件检修项目表Set      */
	private Set<PjFixItem> pjFixItems;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<PjStaticJcTypePjFU> getPjStaticJcTypePjFUs() {
		return pjStaticJcTypePjFUs;
	}

	public void setPjStaticJcTypePjFUs(Set<PjStaticJcTypePjFU> pjStaticJcTypePjFUs) {
		this.pjStaticJcTypePjFUs = pjStaticJcTypePjFUs;
	}

	public Set<ProteamPjStatic> getProteamPjStatics() {
		return proteamPjStatics;
	}


	public void setProteamPjStatics(Set<ProteamPjStatic> proteamPjStatics) {
		this.proteamPjStatics = proteamPjStatics;
	}

	public PjStoreStaticInfo getParentPjStoreStaticInfo() {
		return parentPjStoreStaticInfo;
	}

	public void setParentPjStoreStaticInfo(PjStoreStaticInfo parentPjStoreStaticInfo) {
		this.parentPjStoreStaticInfo = parentPjStoreStaticInfo;
	}

	public Set getChildPjStoreStaticInfos() {
		return childPjStoreStaticInfos;
	}

	public void setChildPjStoreStaticInfos(Set childPjStoreStaticInfos) {
		this.childPjStoreStaticInfos = childPjStoreStaticInfos;
	}

	public String getPjName() {
		return this.pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public String getPjLoweStstore() {
		return this.pjLoweStstore;
	}

	public void setPjLoweStstore(String pjLoweStstore) {
		this.pjLoweStstore = pjLoweStstore;
	}

	public long getPjActivate() {
		return pjActivate;
	}

	public void setPjActivate(long pjActivate) {
		this.pjActivate = pjActivate;
	}

	public long getPjAssemblyType() {
		return pjAssemblyType;
	}

	public void setPjAssemblyType(long pjAssemblyType) {
		this.pjAssemblyType = pjAssemblyType;
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

	public Set<PjStoreDynamicInfo> getPjStoreDynamicInfos() {
		return pjStoreDynamicInfos;
	}

	public void setPjStoreDynamicInfos(Set<PjStoreDynamicInfo> pjStoreDynamicInfos) {
		this.pjStoreDynamicInfos = pjStoreDynamicInfos;
	}

	public Set<PjFixItemPreinstallType> getPjFixItemPreinstallTypes() {
		return pjFixItemPreinstallTypes;
	}

	public void setPjFixItemPreinstallTypes(
			Set<PjFixItemPreinstallType> pjFixItemPreinstallTypes) {
		this.pjFixItemPreinstallTypes = pjFixItemPreinstallTypes;
	}

	public Set<PjFixItem> getPjFixItems() {
		return pjFixItems;
	}

	public void setPjFixItems(Set<PjFixItem> pjFixItems) {
		this.pjFixItems = pjFixItems;
	}
}