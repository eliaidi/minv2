package com.repair.dict.service;

import java.util.List;
import com.repair.entity.DictFault;

/**
 * 
 * @see 故障字典service层
 * @author 周云韬
 * @date 2016-1-4
 * @version 1.0
 */
public interface DictFaultService {

	public List<DictFault> findAll();
}
