package com.repair.pj.action.dictPjFirstUnit;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.repair.constant.Constants;
import com.repair.entity.DictPjFirstUnit;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.util.action.BaseAction;
import com.repair.util.smartTips.SmartTips;

/**
* @ClassName: FindDictPjFirstUnitListByNameOrPyAction
* @Description: TODO 通过专业名或拼音模糊查询大部件（不区分大小写）
* @author 周云韬
* @version V1.0  
* @date 2015-9-18 上午8:51:13
 */
public class FindDictPjFirstUnitListByNameOrPyAction extends BaseAction{

	private DictPjFirstUnitService dictPjFirstUnitService;

	private String py;

	@Override
	public String execute() throws Exception {
		List<DictPjFirstUnit> list = dictPjFirstUnitService.findDictPjFirstUnitListByUnitNameOrPy(py);

		List<SmartTips> tempList=new ArrayList<SmartTips>();
		for (DictPjFirstUnit firstUnit : list) {
			tempList.add(new SmartTips(firstUnit.getId()+"",firstUnit.getFirstUnitName(),firstUnit.getPy()));
		}
		
		response.setCharacterEncoding(Constants.RESPONSE_DEFAULT_ENCODING);
		pw.write(new Gson().toJson(tempList));
		return null;

	}

	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}

	public void setPy(String py) {
		this.py = py;
	}

}
