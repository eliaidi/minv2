package com.repair.dict.dao;

import java.util.List;
import com.repair.entity.DictFault;
import com.repair.entity.DictProteam;

/**
 * 
 * @see 班组dao层
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public interface DictProteamDao {

	public List<DictProteam> findAll();
}
