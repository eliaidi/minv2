package com.repair.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.repair.util.smartTips.SmartTips;

public class SmartTipsTestAction extends ActionSupport{
	private String py;
	
	@Override
	public String execute() throws Exception {
		List<SmartTips> list=new ArrayList<SmartTips>();
		
		list.add(new SmartTips(1+"","÷‹‘∆Ë∫","zyt"));
		list.add(new SmartTips(2+"","÷‹∂˜¿¥","zel"));
		list.add(new SmartTips(3+"","Ã∆≈Ù","tp"));
		list.add(new SmartTips(4+"","Ã∆Ÿª","tq"));
		list.add(new SmartTips(5+"","¡Œ—©±˘","lxb"));
		list.add(new SmartTips(6+"","Õıƒ·¬Í","wnm"));
		
		List<SmartTips> tempList=new ArrayList<SmartTips>();
		for (SmartTips smartTips : list) {
			if(smartTips.getPy().startsWith(py)){
				tempList.add(smartTips);
			}
		}
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().getWriter().write(new Gson().toJson(tempList));
		
		return null;
	}

	
	public void setPy(String py) {
		this.py = py;
	}
	
	
	
}
