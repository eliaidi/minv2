package com.repair.entity;

import java.io.Serializable;

/**
 * 
* @ClassName: PjStaticJcTypePjFU
* @Description: TODO 配件仓库静态/基本信息__机车型号_大部件（专业）中间表 -- 中间表
* @author 周云韬
* @version V1.0  
* @date 2015-9-1 下午8:48:01
 */
public class PjStaticJcTypePjFU implements Serializable{
	/** @Field  id：主键  */
	private int id;
	
	/** @Field pjStoreStaticInfo：配件仓库静态/基本信息   */
	private PjStoreStaticInfo pjStoreStaticInfo;
	
	/** @Field  jcTypePjFirstUnit：机车型号-大部件(专业)中间表  */
	private JcTypePjFirstUnit jcTypePjFirstUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PjStoreStaticInfo getPjStoreStaticInfo() {
		return pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}

	public JcTypePjFirstUnit getJcTypePjFirstUnit() {
		return jcTypePjFirstUnit;
	}

	public void setJcTypePjFirstUnit(JcTypePjFirstUnit jcTypePjFirstUnit) {
		this.jcTypePjFirstUnit = jcTypePjFirstUnit;
	}
	
	
	
}
