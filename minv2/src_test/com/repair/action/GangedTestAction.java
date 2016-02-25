package com.repair.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.util.ganged.Ganged;

/**
 * 
* @ClassName: GangedTestAction
* @Description: TODO 下拉框联动查询测试
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午3:59:46
 */
public class GangedTestAction extends ActionSupport{
	private Integer testId;
	
	
	@Override
	public String execute() throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		
		Map<Integer, List<Ganged>> map=initData();
		
		List<Ganged> list=map.get(testId);
		
	
		
		response.setContentType("application/json;charset=UTF-8");
		if(list != null){
			response.getWriter().write(new Gson().toJson(list));
		}else{
			response.getWriter().write("[]");
		}
		
		return null;
	}
	
	
	public Map<Integer, List<Ganged>> initData(){
		Map<Integer, List<Ganged>> map=new HashMap<Integer, List<Ganged>>();
		List<Ganged> list=new ArrayList<Ganged>();
		list.add(new Ganged("1","张三"));
		list.add(new Ganged("2","李四"));
		map.put(1, list);
		
		
		
		list=new ArrayList<Ganged>();
		list.add(new Ganged("3","王五"));
		list.add(new Ganged("4","赵六"));
		map.put(2, list);
		
		list=new ArrayList<Ganged>();
		list.add(new Ganged("5","周云韬"));
		list.add(new Ganged("6","贺斌"));
		map.put(3, list);
		
		list=new ArrayList<Ganged>();
		list.add(new Ganged("7","唐鹏"));
		list.add(new Ganged("8","廖雪冰"));
		map.put(4, list);
		
		return map;
	}


	public Integer getTestId() {
		return testId;
	}


	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	
	
	
}
