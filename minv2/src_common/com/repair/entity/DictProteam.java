package com.repair.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DictArea
 * @Description: TODO(实体类)
 * @author lxb
 * @version V1.0
 * @date 2015-8-28 下午1:26:16
 */
public class DictProteam  implements java.io.Serializable{

	/*@Field id : 主键       */
	private long id;
	
	/*@Field  proteamName: 班组名称      */
	private String proteamName;
	
	/*@Field  workFlag:  小辅修、中修判别字段：0、不修；1、小辅修；2、中修；3、小辅修/中修  */
	private int workFlag;
	
	/*@Field attendanceFlag: 考勤判别字段：0、不考勤；1、考勤*/
	private int attendanceFlag;
	
	/*@Field pjStoreStaticInfos : 配件仓库静态/基本信息表  */
	private Set<PjStoreStaticInfo> pjStoreStaticInfos;
	
	/*@Field usersPrivses: 用户表Set*/
	private Set<UsersPrivs> usersPrivses;
	
	/*@Field usersPrivses: 仓库表Set*/
	private DictStorePosition dictStorePosition;
	
	/*@Field pjFixItems: 配件检修项目表Set*/
	private Set<PjFixItem> pjFixItems;
	
	/*@Field modifyTime: 乐观锁标识字段*/
	private int versionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProteamName() {
		return this.proteamName;
	}

	public void setProteamName(String proteamName) {
		this.proteamName = proteamName;
	}

	public Set getPjStoreStaticInfos() {
		return this.pjStoreStaticInfos;
	}

	

	public Set getUsersPrivses() {
		return this.usersPrivses;
	}

	public int getWorkFlag() {
		return workFlag;
	}

	public void setWorkFlag(int workFlag) {
		this.workFlag = workFlag;
	}

	public int getAttendanceFlag() {
		return attendanceFlag;
	}

	public void setAttendanceFlag(int attendanceFlag) {
		this.attendanceFlag = attendanceFlag;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Set<PjFixItem> getPjFixItems() {
		return pjFixItems;
	}

	public void setPjFixItems(Set<PjFixItem> pjFixItems) {
		this.pjFixItems = pjFixItems;
	}

	public void setUsersPrivses(Set<UsersPrivs> usersPrivses) {
		this.usersPrivses = usersPrivses;
	}

	public DictStorePosition getDictStorePosition() {
		return dictStorePosition;
	}

	public void setDictStorePosition(DictStorePosition dictStorePosition) {
		this.dictStorePosition = dictStorePosition;
	}

	public void setPjStoreStaticInfos(Set<PjStoreStaticInfo> pjStoreStaticInfos) {
		this.pjStoreStaticInfos = pjStoreStaticInfos;
	}

	

	
}