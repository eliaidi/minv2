package com.repair.pjFix.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.repair.entity.JcTypePjFirstUnit;
import com.repair.entity.PjStoreStaticInfo;
import com.repair.entity.ProteamPjStatic;
import com.repair.pjFix.dao.PjStoreStaticInfoDao;
import com.repair.pjFix.dto.PjStoreStaticInfoSearchDto;
import com.repair.util.StringUtil;
import com.repair.util.splitPage.SplitPageDao;
import com.repair.util.splitPage.SplitPageModel;

/**
* @ClassName: PjStoreStaticInfoDaoImpl
* @Description: TODO(静态配件信息dao实现)
* @author 唐鹏
* @version V1.0  
* @date 2015-8-31 下午05:57:24
 */
public class PjStoreStaticInfoDaoImpl implements  PjStoreStaticInfoDao{
     
	private HibernateTemplate hibernateTemplate;
	
	private SplitPageDao splitPageDao;
    
	/**
	 *	 添加配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void addPjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo) {
		this.hibernateTemplate.save(storeStaticInfo);
	}

	/**
	 *	 删除配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void deletePjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo) {
		PjStoreStaticInfo PSSInfo=findPjStoreStaticInfoById(storeStaticInfo.getId());
		if(PSSInfo!=null)
		{
			this.hibernateTemplate.delete(PSSInfo);
		}
	}

	/**
	 *	 通过配件仓库静态信息ID查询
	 *	@param  id：配件仓库静态信息ID
	 *	@return	查询到的 配件仓库静态信息对象
	 */
	@SuppressWarnings("unchecked")
	public PjStoreStaticInfo findPjStoreStaticInfoById(long id) {
	
		PjStoreStaticInfo pjStoreStaticInfo=null;
		List<PjStoreStaticInfo> list=this.hibernateTemplate.find("from PjStoreStaticInfo where id=?", new Object[]{id});
		if(list.size()>0)
		{
			pjStoreStaticInfo=list.get(0);
		}
		return pjStoreStaticInfo;
	}
	
	/**
	 *	 修改配件仓库静态信息
	 *	@param	storeStaticInfo  配件仓库静态信息对象
	 */
	public void updatePjStoreStaticInfo(PjStoreStaticInfo storeStaticInfo) {
		try{
			this.hibernateTemplate.saveOrUpdate(storeStaticInfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过pjName查询条件查询配件仓库静态信息
	 */
	public PjStoreStaticInfo findPjStoreStaticInfoByPjName(String pjName) {
		// TODO Auto-generated method stub
		PjStoreStaticInfo pjStoreStaticInfo = null;
		List<PjStoreStaticInfo> pjStoreStaticList=this.hibernateTemplate.find(" from PjStoreStaticInfo where pjName = ?",new Object[]{pjName});
		if(pjStoreStaticList.size()>0){
			pjStoreStaticInfo = pjStoreStaticList.get(0);
		}
		return pjStoreStaticInfo;
	}
	
	/**
	 * 通过班组_配件静态中间表，查询配件对应的班组
	 */
	public ProteamPjStatic findProteamPjStaticInfoByPjssInfoId(long PjssInfoId) {
		// TODO Auto-generated method stub
		ProteamPjStatic proteamPjStatic =null;
		List<ProteamPjStatic> list=this.hibernateTemplate.find("from ProteamPjStatic where PjStoreStaticInfo.id=?", new Object[]{PjssInfoId});
		if(list.size()>0)
		{
			proteamPjStatic=list.get(0);
		}
		return proteamPjStatic;
	}

	/**
	 * 通过机车型号大部件（专业）中间表实体查询数据
	 */
	@SuppressWarnings("unchecked")
	public List<JcTypePjFirstUnit> findJcTypePjFirstUnitByPjFirstUnitId(long firstUnitId){
		List<JcTypePjFirstUnit> list=this.hibernateTemplate.find("from JcTypePjFirstUnit where dictPjFirstUnit.id=?", new Object[]{firstUnitId});
		return list;
	}

	/**
	 *	 通过查询条件查询配件仓库静态信息，具体查询条件请参考
	 *	@param	dto  查询静态配件时需要使用的dto
	 *	@return	配件仓库静态信息集合
	 */
	@SuppressWarnings("unchecked")
	public SplitPageModel findPagePjStoreStaticInfo(PjStoreStaticInfoSearchDto dto){
		StringBuffer hql=new StringBuffer();
		
		List<Object> pars=new ArrayList<Object>();
		
		hql.append("from PjStoreStaticInfo pssi where 1=1 ");
		//通过大部件ID查询
		if(dto.getFirstUnitId() != null && dto.getFirstUnitId() != -1){
			hql.append(" and pssi.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.id = ?  ))");
			pars.add(dto.getFirstUnitId());
		}
		//通过配件编码查询
		if(StringUtil.isNotBlank(dto.getPjdCode())){
			hql.append(" and pssi.id in (select psdi.pjStoreStaticInfo.id from PjStoreDynamicInfo psdi"+
						" where psdi.pjdCode like ?)");
			pars.add("%"+dto.getPjdCode()+"%");
		}
		//通过配件名称查询
		if(StringUtil.isNotBlank(dto.getPjName())){
			hql.append(" and pssi.pjName like ?");
			pars.add("%"+dto.getPjName()+"%");
		}
		//通过仓库ID查询
		if(dto.getStorePositionId() != null ){
			hql.append(" and pssi.id  in (select psdi.pjStoreStaticInfo.id from PjStoreDynamicInfo psdi" +
					" where psdi.dictStorePosition.id=?)");
			pars.add(dto.getStorePositionId());
		}
		//机车型号ID如果为null或者-1.则查询全部静态配件
		if(dto.getJcTypeId() != null && dto.getJcTypeId() != -1){
			hql.append(" and pssi.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictJcType.id = ?  ))");
			pars.add(dto.getJcTypeId());
		}
		//根据配件组装状态查询数据
		if(dto.getPjAssemblyType()!=null && dto.getPjAssemblyType()!= -1)
		{
			hql.append(" and pjAssemblyType =?");
			pars.add(dto.getPjAssemblyType());
		}
		//班组编号
		if(dto.getProteamId()!=null && dto.getProteamId()!= -1)
		{
			hql.append(" and id in (select pps.pjStoreStaticInfo.id " +
			" from ProteamPjStatic pps where pps.dictProteam.id=?) ");
			pars.add(dto.getProteamId());
		}
		//未启用配件
		if(dto.getPjActivate() != null && dto.getPjActivate() !=-1){
			hql.append(" and pssi.pjActivate = ?");
			pars.add(dto.getPjActivate());
		}
		//通过机车型号模糊查询
		if(StringUtil.isNotBlank(dto.getJcType())){
			hql.append(" and pssi.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
					" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictJcType.jcType like ?  ))");
			pars.add("%"+dto.getJcType()+"%");
		}
		//通过大部件名称模糊查询
		if(StringUtil.isNotBlank(dto.getFirstUnitName())){
			hql.append(" and  pssi.id in (select psjtpjfu.pjStoreStaticInfo.id from PjStaticJcTypePjFU psjtpjfu where " +
						" psjtpjfu.jcTypePjFirstUnit.id in (select jtpfu.id  from JcTypePjFirstUnit jtpfu where jtpfu.dictPjFirstUnit.firstUnitName like ? ) ))");
			pars.add("%"+dto.getFirstUnitName()+"%");
		}

		if(dto.getRecordTime() != null){
			hql.append(" and pssi.id in (select psdi.pjStoreStaticInfo.id from PjStoreDynamicInfo psdi"+
					" where psdi.id in (select  psdir.pjStoreDynamicInfo.id from PjSDInfoRecord psdir where" +
					" psdir.receivingDeliverStatus=0 and psdir.storeUnitProteamStatus=2 " +
					" and recordTime between ? and ?) )");
			pars.add(dto.getRecordTime());
			Timestamp endTime=new Timestamp(dto.getRecordTime().getTime()+86400000);
			
			pars.add(endTime);
		}
		
		//最小库存
		if(dto.isMinStore()){
			hql.append(" and (select count(*) from PjStoreDynamicInfo psd where psd.pjStoreStaticInfo.id=pssi.id)  <  pjLoweStstore ");
		}

		hql.append(" order by pssi.id desc ");
		
		return splitPageDao.queryList(hql.toString(), pars, dto.getPageNo(), dto.getPageSize());
	}
	
	/**
	 * 查询所有静态配件
	 */
	@SuppressWarnings("unchecked")
	public PjStoreStaticInfo findPjStoreStaticInfoAll() {
		PjStoreStaticInfo pjStoreStaticInfo=null;
		List<PjStoreStaticInfo> list=this.hibernateTemplate.find("from PjStoreStaticInfo"); 
		if(list.size()>0)
		{
			pjStoreStaticInfo=list.get(0);
		}
		return pjStoreStaticInfo;
	}
	
	/**
	 * 查询所有静态配件信息
	 */
	@SuppressWarnings("unchecked")
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfo() {
		List<PjStoreStaticInfo> list=this.hibernateTemplate.find("from PjStoreStaticInfo"); 
		return list;
	}
	
	/**
	 * 根据Id查询数据
	 */
	@SuppressWarnings("unchecked")
	public List<PjStoreStaticInfo> findAllPjStoreStaticInfoById(long id) {
		List<PjStoreStaticInfo> list=this.hibernateTemplate.find("from PjStoreStaticInfo where id=?", new Object[]{id});
		return list;
	}

	/**
	 * 通过配件名称或拼音模糊查询配件仓库静态信息集合
	 */
	public List<PjStoreStaticInfo> findPjStoreStaticInfoListByPjNameOrPy(String pjNameOrPy){
		String hql="from PjStoreStaticInfo where pjName like ? or py like ?";
		List pars=new ArrayList();
		pars.add("%"+pjNameOrPy+"%");
		pars.add("%"+pjNameOrPy+"%");
		return splitPageDao.queryList(hql,pars, 1, 10).getData();
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void setSplitPageDao(SplitPageDao splitPageDao) {
		this.splitPageDao = splitPageDao;
	}
	
}
