package com.repair.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: PjStoreDynamicInfo
 * @Description: TODO 配件仓库动态信息/库存（所在位置）
 * @author 周云韬
 * @version V1.0
 * @date 2015-8-28 下午2:47:00
 */
public class PjStoreDynamicInfo implements java.io.Serializable {

	/** @Field id：主键 */
	private long id;

	/** @Field dictStorePosition：配件所在位置/仓库 */
	private DictStorePosition dictStorePosition;

	/** @Field pjStoreDynamicInfo：当前配件的父级 */
	private PjStoreDynamicInfo parentPjStoreDynamicInfo;

	/** @Field pjdCode：配件编码 */
	private String pjdCode;

	/** @Field pjdStatus：配件状态：1、新件合格；2、修竣合格；3、待修；4、报废；5、检修中 */
	private long pjdStatus;

	/** @Field pjdFactory：配件生产厂家 */
	private String pjdFactory;

	/** @Field pjdOutFactoryDate：配件出厂日期 */
	private Date pjdOutFactoryDate;

	/** @Field pjdInPrice：配件进货价格 */
	private Double pjdInPrice;

	/** @Field py：拼音 */
	private String py;

	/** @Field remark：备注 */
	private String remark;

	/** @Field pjSDInfoRecords：配件仓库动态信息记录-->出入库记录 */
	private Set<PjSDInfoRecord> pjSDInfoRecords = new HashSet(0);

	/** @Field pjStoreDynamicInfos：配件仓库动态信息/库存（所在位置） */
	private Set childPjStoreDynamicInfos = new HashSet(0);

	/** @Field pjStoreStaticInfo 对应的静态配件 */
	private PjStoreStaticInfo pjStoreStaticInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPjdStatus(long pjdStatus) {
		this.pjdStatus = pjdStatus;
	}

	public DictStorePosition getDictStorePosition() {
		return this.dictStorePosition;
	}

	public void setDictStorePosition(DictStorePosition dictStorePosition) {
		this.dictStorePosition = dictStorePosition;
	}

	public String getPjdCode() {
		return this.pjdCode;
	}

	public void setPjdCode(String pjdCode) {
		this.pjdCode = pjdCode;
	}

	public String getPjdFactory() {
		return this.pjdFactory;
	}

	public void setPjdFactory(String pjdFactory) {
		this.pjdFactory = pjdFactory;
	}

	public Date getPjdOutFactoryDate() {
		return pjdOutFactoryDate;
	}

	public void setPjdOutFactoryDate(Date pjdOutFactoryDate) {
		this.pjdOutFactoryDate = pjdOutFactoryDate;
	}

	public Double getPjdInPrice() {
		return this.pjdInPrice;
	}

	public void setPjdInPrice(Double pjdInPrice) {
		this.pjdInPrice = pjdInPrice;
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

	public Set<PjSDInfoRecord> getPjSDInfoRecords() {
		return pjSDInfoRecords;
	}

	public void setPjSDInfoRecords(Set<PjSDInfoRecord> pjSDInfoRecords) {
		this.pjSDInfoRecords = pjSDInfoRecords;
	}

	public long getPjdStatus() {
		return pjdStatus;
	}

	public PjStoreStaticInfo getPjStoreStaticInfo() {
		return pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}

	public PjStoreDynamicInfo getParentPjStoreDynamicInfo() {
		return parentPjStoreDynamicInfo;
	}

	public void setParentPjStoreDynamicInfo(
			PjStoreDynamicInfo parentPjStoreDynamicInfo) {
		this.parentPjStoreDynamicInfo = parentPjStoreDynamicInfo;
	}

	public Set getChildPjStoreDynamicInfos() {
		return childPjStoreDynamicInfos;
	}

	public void setChildPjStoreDynamicInfos(Set childPjStoreDynamicInfos) {
		this.childPjStoreDynamicInfos = childPjStoreDynamicInfos;
	}

}