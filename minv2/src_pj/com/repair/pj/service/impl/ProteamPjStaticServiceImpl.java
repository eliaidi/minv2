package com.repair.pj.service.impl;

import java.util.List;
import com.repair.entity.ProteamPjStatic;
import com.repair.pj.dao.ProteamPjStaticDao;
import com.repair.pj.service.ProteamPjStaticService;
import com.repair.util.serviceSupport.ServiceSupport;

/**
* @ClassName: ProteamPjStaticServiceImpl
* @Description: TODO(����-��̬����м��serviceʵ����)
* @author �����
* @version V1.0  
* @date Nov 25, 2015 9:52:56 AM
 */
public class ProteamPjStaticServiceImpl extends ServiceSupport<ProteamPjStatic> implements ProteamPjStaticService {
   
	private ProteamPjStaticDao proteamPjStaticDao;
	
	


	public void setProteamPjStaticDao(ProteamPjStaticDao proteamPjStaticDao) {
		this.proteamPjStaticDao = proteamPjStaticDao;
	}
   
}
