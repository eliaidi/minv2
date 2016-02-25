package com.repair.entity;

/**
 * @ClassName: 机车中修检修项目表
 * @Description: TODO(实体类)
 * @author 周云涛
 * @version V1.0
 * @date 2015-12-10 下午1:26:16
 */
public class JcZxFixItem  implements java.io.Serializable{
	/** @Field id : 主键 */
	private long id;
	
	/** @Field itemName : 中修项目名称 */
	private String itemName;
	
	/** @Field fixFlow : 机车检修流程节点*/
	private JcFixFlow fixFlow;
	
	/** @Field status : 是否启用（0、禁用，1、启用） */
	private Integer status;
	
	/** @Field itemType : 项目类型 */
	private Integer itemType;
	
	/** @Field defaultVal : 默认值*/
	private String defaultVal;
	
	/** @Field minValue : 最小值 */
	private Double minValue;

	/** @Field maxValue : 最大值 */
	private Double maxValue;
	
	/** @Field unitMeasure : 计量单位 */
	private String unitMeasure;
	
	/** @Field leadCheck : 工长是否卡控*/
	private Integer leadCheck;
	
	/** @Field commitLeadCheck : 交车工长是否卡控*/
	private Integer commitLeadCheck;
	
	/** @Field qcCheck : 质检员是否卡控*/
	private Integer qcCheck;
	
	/** @Field acceptanceCheck : 验收员是否卡控 */
	private Integer acceptanceCheck;
	
	/** @Field technicianCheck : 技术员是否卡控 */
	private Integer technicianCheck;
	
	/** @Field twoInspectionCheck : 复探是否卡控 */
	private Integer twoInspectionCheck;
	
	/** @Field jcTypes : 适应车型 */
	private String jcTypes;
	
	/** @Field jcFixMileages : 修次 */
	private String jcFixMileages;
	
	/** @Field proteam : 班组 */
	private DictProteam proteam;
	
	/** @Field itemUnit : 部件名 */
	private String itemUnit;
	
	/** @Field itemPart : 部位名 */
	private String itemPart;
	
	/** @Field firstUnit : 配件大部件 */
	private DictPjFirstUnit firstUnit;
	
	/** @Field fixDuration : 项目检修时长 */
	private String fixDuration;
	
	/** @Field remark : 备注 */
	private String remark;

	/** @Field preinstallType：预设分类*/
	private FixItemPreinstallType preinstallType;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

	public JcFixFlow getFixFlow() {
		return fixFlow;
	}

	public void setFixFlow(JcFixFlow fixFlow) {
		this.fixFlow = fixFlow;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
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

	public Integer getLeadCheck() {
		return leadCheck;
	}

	public void setLeadCheck(Integer leadCheck) {
		this.leadCheck = leadCheck;
	}

	public Integer getCommitLeadCheck() {
		return commitLeadCheck;
	}

	public void setCommitLeadCheck(Integer commitLeadCheck) {
		this.commitLeadCheck = commitLeadCheck;
	}

	public Integer getQcCheck() {
		return qcCheck;
	}

	public void setQcCheck(Integer qcCheck) {
		this.qcCheck = qcCheck;
	}

	public Integer getAcceptanceCheck() {
		return acceptanceCheck;
	}

	public void setAcceptanceCheck(Integer acceptanceCheck) {
		this.acceptanceCheck = acceptanceCheck;
	}

	public Integer getTechnicianCheck() {
		return technicianCheck;
	}

	public void setTechnicianCheck(Integer technicianCheck) {
		this.technicianCheck = technicianCheck;
	}

	public Integer getTwoInspectionCheck() {
		return twoInspectionCheck;
	}

	public void setTwoInspectionCheck(Integer twoInspectionCheck) {
		this.twoInspectionCheck = twoInspectionCheck;
	}

	public String getJcTypes() {
		return jcTypes;
	}

	public void setJcTypes(String jcTypes) {
		this.jcTypes = jcTypes;
	}

	public DictProteam getProteam() {
		return proteam;
	}

	public void setProteam(DictProteam proteam) {
		this.proteam = proteam;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemPart() {
		return itemPart;
	}

	public void setItemPart(String itemPart) {
		this.itemPart = itemPart;
	}

	public DictPjFirstUnit getFirstUnit() {
		return firstUnit;
	}

	public void setFirstUnit(DictPjFirstUnit firstUnit) {
		this.firstUnit = firstUnit;
	}

	public String getFixDuration() {
		return fixDuration;
	}

	public void setFixDuration(String fixDuration) {
		this.fixDuration = fixDuration;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getJcFixMileages() {
		return jcFixMileages;
	}

	public void setJcFixMileages(String jcFixMileages) {
		this.jcFixMileages = jcFixMileages;
	}

	public FixItemPreinstallType getPreinstallType() {
		return preinstallType;
	}

	public void setPreinstallType(FixItemPreinstallType preinstallType) {
		this.preinstallType = preinstallType;
	}

	

}
