package com.repair.entity;

/**
 * 
* @ClassName: ProteamPjStatic
* @Description: TODO 班组-配件仓库静态信息-中间表
* @author 周云韬
* @version V1.0  
* @date 2015-9-1 下午8:29:50
 */
public class ProteamPjStatic  implements java.io.Serializable{
	
	/** @Field   id：主键 */
	private int id;
	
	/** @Field   dictProteam：班组 */
	private DictProteam dictProteam;
	
	/** @Field   pjStoreStaticInfo：配件静态信息 */
	private PjStoreStaticInfo pjStoreStaticInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DictProteam getDictProteam() {
		return dictProteam;
	}

	public void setDictProteam(DictProteam dictProteam) {
		this.dictProteam = dictProteam;
	}

	public PjStoreStaticInfo getPjStoreStaticInfo() {
		return pjStoreStaticInfo;
	}

	public void setPjStoreStaticInfo(PjStoreStaticInfo pjStoreStaticInfo) {
		this.pjStoreStaticInfo = pjStoreStaticInfo;
	}
	
	
	
	
	
	
}
