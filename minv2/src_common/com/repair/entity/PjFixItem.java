package com.repair.entity;

import java.util.Set;

/**
* @ClassName: PjFixItem
* @Description: TODO(实体类)
* @author lxb
* @version V1.0  
* @date 2015-9-21 上午10:59:53
 */
public class PjFixItem  implements java.io.Serializable{
	/*@Field id : 主键 */
	private long id;
	
	/*@Field id : PjFixItem配件检修项目表*/
	private PjFixItem parentPjFixItem;
	
	/*@Field id : 配件检修项目名称*/
	private String fixItemName;
	
	/*@Field id : 配件检修项目-部位名称*/
	private String fixItemPart;
	
	/*@Field id : 配件静态信息ID*/
	private PjStoreStaticInfo pjStoreStaticInfo;
	
	/*@Field id : 配件检修项目顺序号*/
	private int fixItemNumber;
	
	/*@Field id : 项目填报默认值*/
	private String defaultValue;
	
	/*@Field id : 项目在查询报表显示状态：0、不显示；1显示*/
	private int showStatus;
	
	/*@Field id : 项目检修班组ID*/
	private DictProteam dictProteam;
	
	/*@Field id : 工长是否卡控（0、不卡控；1、卡控）*/
	private int leadCheck;
	
	/*@Field id : 交车工长是否卡控（0、不卡控；1、卡控）*/
	private int commitLeadCheck;
	
	/*@Field id : 质检员是否卡控（0、不卡控；1、卡控）*/
	private int qcCheck;
	
	/*@Field id : 验收员是否卡控（0、不卡控；1、卡控）*/
	private int acceptanceCheck;
	
	/*@Field id : 技术员是否卡控（0、不卡控；1、卡控）*/
	private int technicianCheck;
	
	/*@Field id : 复探是否卡控（0、不卡控；1、卡控）*/
	private int twoInspectionCheck;
	
	/*@Field id : 最小值（double,10）*/
	private Double minValue;
	
	/*@Field id : 最大值（double,10）*/
	private Double maxValue;
	
	/*@Field id : 计量单位*/
	private String unitMeasure;
	

	/*@Field id : 配件仓库动态信息记录表-子表-配件检修记录表，机车配件下车入班组库检修/(入库班组库即为检修状态)Set
	private Set<PjSDInfoRecordFix> pjSDInfoRecordFixes;
	*/
	
	/*@Field id : PjFixItem配件检修项目表*/
	private Set<PjFixItem> childPjFixItems;
	
	/*@Field id : 检修项目-预设配件检修项目分类表-中间表Set*/
	private Set<PjFItemPreinstallType> pjFItemPreinstallTypes;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PjFixItem getParentPjFixItem() {
		return parentPjFixItem;
	}

	public void setParentPjFixItem(PjFixItem parentPjFixItem) {
		this.parentPjFixItem = parentPjFixItem;
	}

	public String getFixItemName() {
		return fixItemName;
	}

	public void setFixItemName(String fixItemName) {
		this.fixItemName = fixItemName;
	}

	public String getFixItemPart() {
		return fixItemPart;
	}

	public void setFixItemPart(String fixItemPart) {
		this.fixItemPart = fixItemPart;
	}

	public PjStoreStaticInfo getPjStoreStaticInfo() {
		return pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}

	public int getFixItemNumber() {
		return fixItemNumber;
	}

	public void setFixItemNumber(int fixItemNumber) {
		this.fixItemNumber = fixItemNumber;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(int showStatus) {
		this.showStatus = showStatus;
	}

	public DictProteam getDictProteam() {
		return dictProteam;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}

	public int getLeadCheck() {
		return leadCheck;
	}

	public void setLeadCheck(int leadCheck) {
		this.leadCheck = leadCheck;
	}

	public int getCommitLeadCheck() {
		return commitLeadCheck;
	}

	public void setCommitLeadCheck(int commitLeadCheck) {
		this.commitLeadCheck = commitLeadCheck;
	}

	public int getQcCheck() {
		return qcCheck;
	}

	public void setQcCheck(int qcCheck) {
		this.qcCheck = qcCheck;
	}

	public int getAcceptanceCheck() {
		return acceptanceCheck;
	}

	public void setAcceptanceCheck(int acceptanceCheck) {
		this.acceptanceCheck = acceptanceCheck;
	}

	public int getTechnicianCheck() {
		return technicianCheck;
	}

	public void setTechnicianCheck(int technicianCheck) {
		this.technicianCheck = technicianCheck;
	}

	
	

	public int getTwoInspectionCheck() {
		return twoInspectionCheck;
	}

	public void setTwoInspectionCheck(int twoInspectionCheck) {
		this.twoInspectionCheck = twoInspectionCheck;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public String getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public Set<PjFixItem> getChildPjFixItems() {
		return childPjFixItems;
	}

	public void setChildPjFixItems(Set<PjFixItem> childPjFixItems) {
		this.childPjFixItems = childPjFixItems;
	}

	

	public Set<PjFItemPreinstallType> getPjFItemPreinstallTypes() {
		return pjFItemPreinstallTypes;
	}

	public void setPjFItemPreinstallTypes(
			Set<PjFItemPreinstallType> pjFItemPreinstallTypes) {
		this.pjFItemPreinstallTypes = pjFItemPreinstallTypes;
	}
	
}
