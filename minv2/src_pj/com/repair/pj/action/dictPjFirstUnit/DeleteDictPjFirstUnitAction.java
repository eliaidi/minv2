package com.repair.pj.action.dictPjFirstUnit;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.entity.DictPjFirstUnit;
import com.repair.entity.PjStoreDynamicInfo;
import com.repair.pj.service.DictPjFirstUnitService;
import com.repair.pj.service.JcTypePjFirstUnitService;
import com.repair.pj.service.PjStoreDynamicInfoService;
import com.repair.util.action.BaseAction;

/**
 * @ClassName: DeleteDictPjFirstUnitAction
 * @Description: TODO(删除数据专业（大部件）)
 * @author 唐鹏
 * @version V1.0
 * @date 2015-8-31 下午02:46:05
 */
public class DeleteDictPjFirstUnitAction extends BaseAction implements ModelDriven<DictPjFirstUnit> {

	private DictPjFirstUnit dictPjFirstUnit = new DictPjFirstUnit();
	private DictPjFirstUnitService dictPjFirstUnitService;
    private JcTypePjFirstUnitService jcTypePjFirstUnitService; 
    private PjStoreDynamicInfoService pjStoreDynamicInfoService;
	@Override
	public String execute() throws Exception {
		List<PjStoreDynamicInfo> list=pjStoreDynamicInfoService.findPagePjStoreDynamicInfoByFirstUnitid(dictPjFirstUnit.getId());
		if(list.size() == 0)
		{
			DictPjFirstUnit firstUnit=dictPjFirstUnitService.findById(dictPjFirstUnit.getId());
			if(firstUnit != null){
				dictPjFirstUnitService.delete(firstUnit);
			}
			
			session.setAttribute("message", "删除成功");
		}else{
			
			session.setAttribute("message", "此专业存在动态配件,无法删除！");
		}
		
		return Action.SUCCESS;
	}

	public DictPjFirstUnit getModel() {
		return this.dictPjFirstUnit;
	}

	public DictPjFirstUnitService getDictPjFirstUnitService() {
		return dictPjFirstUnitService;
	}

	public void setDictPjFirstUnitService(
			DictPjFirstUnitService dictPjFirstUnitService) {
		this.dictPjFirstUnitService = dictPjFirstUnitService;
	}

	public JcTypePjFirstUnitService getJcTypePjFirstUnitService() {
		return jcTypePjFirstUnitService;
	}

	public void setJcTypePjFirstUnitService(
			JcTypePjFirstUnitService jcTypePjFirstUnitService) {
		this.jcTypePjFirstUnitService = jcTypePjFirstUnitService;
	}

	public PjStoreDynamicInfoService getPjStoreDynamicInfoService() {
		return pjStoreDynamicInfoService;
	}

	public void setPjStoreDynamicInfoService(
			PjStoreDynamicInfoService pjStoreDynamicInfoService) {
		this.pjStoreDynamicInfoService = pjStoreDynamicInfoService;
	}

}
