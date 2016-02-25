package com.repair.dict.dao;

import java.util.List;
import com.repair.entity.DictFault;

/**
 * 
 * @see 故障字典dao层
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public interface DictFaultDao {

	public List<DictFault> findAll();
}
