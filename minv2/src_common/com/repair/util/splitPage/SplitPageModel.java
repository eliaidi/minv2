package com.repair.util.splitPage;

import java.util.List;
import com.repair.constant.Constants;

/**
 * 
* @ClassName: SplitPageModel
* @Description: TODO 分页模型，用于存储分页相关信息
* @author 周云韬
* @version V1.0  
* @date 2015-9-18 上午9:52:33
 */
public class SplitPageModel<T> {
	/** 总页数  */
	private long totalPage;
	
	/** 当前页数 */
	private int pageNo;
	
	/** 数据总个数 */
	private long totalCount;
	
	/** 每页显示数据大小 */
	private int pageSize;
	
	/** 数据集合 */
	private List<T> data;
	
	/** 页面显示标签（页数）数量，比如showTag为5，当前页数为1，总页数为20，则只显示   1-5页标签 */
	private int showTag;
	
	
	public SplitPageModel(int pageNo,int pageSize,List<T> data,long totalCount){
		this.totalCount=totalCount;
		setPageSize(pageSize);
		setPageNo(pageNo);
		this.data=data;
		this.totalPage=getTotalPage();
	}
	
	
	
	public long getTotalCount(){
		return this.totalCount;
	}
	
	public List<T> getData(){
		return this.data;
	}
	
	private void setPageNo(int pageNo){
		if(pageNo <= 0){
			this.pageNo=1;
		}else{
			this.pageNo=pageNo;
		}
	}
	
	private void setPageSize(int pageSize){
		if(pageSize <= 0){
			this.pageSize=Constants.SPLIT_PAGE_DEFALT_SIZE;
		}else{
			this.pageSize=pageSize;
		}
	}
	
	public long getTotalPage(){
	
		long mod=this.totalCount % this.pageSize;
		long totalPage=0;
		if(mod == 0){
			totalPage = this.totalCount / this.pageSize;
		}else{
			totalPage= this.totalCount / this.pageSize + 1;
		}
		return totalPage;
	}
	
	
	
	
	//获取下拉框，更改每页显示大小
	public String getDropDownBox(){
		StringBuffer sb=new StringBuffer();
		sb.append("<select class='default' id='changePageSize' onchange='changePageSize(this)'  >");
		
		
		sb.append("		<option value='5'  >每页5条</option>");
		sb.append("		<option value='10' >每页10条</option>");
		sb.append("		<option value='15' >每页15条</option>");
		sb.append("		<option value='20' >每页20条</option>");
		sb.append("		<option value='50' >每页50条</option>");
		sb.append("		<option value='100' >每页100条</option>");
		sb.append("</select>");
		
		
		sb.append("<script type=\"text/javascript\">\n");
		sb.append("$(function(){\n" );
//		sb.append("		$(\"div[class='mainCon']\").remove();\n");
		sb.append("		$(\"select[id='changePageSize']\").css('display','inline');\n");
		sb.append("		$(\"select[id='changePageSize']\").val("+this.pageSize+");\n");
		sb.append("})\n");
		sb.append("function changePageSize(obj){\n");
		sb.append("		var url = document.location+'';\n");
		sb.append("		if(url.indexOf('?')>-1){\n");
		sb.append("			if(url.indexOf('pageSize')>-1){\n");
		sb.append("				var reg = /pageSize=\\d*/g;\n");
		sb.append("				url = url.replace(reg,'pageSize='+$(obj).val());\n");
		sb.append("			}else{\n");
		sb.append("				url += \"&pageSize=\"+$(obj).val();\n");
		sb.append("			}\n");
		sb.append("		}else{url += \"?pageSize=\"+$(obj).val();}\n");
		sb.append("		document.location = url;\n");
		sb.append("}\n");
		sb.append("</script>\n");
		
		
		return sb.toString();
	}
	
	public String getPageString(){
		
		StringBuffer sb=new StringBuffer();
		if(totalCount > 0){
			sb.append("<div class='float_right padding5 paging'>");
			
			if(pageNo == 1){
				sb.append("	<span class='paging_disabled'><a>首页</a></span>\n");
				sb.append("	<span class='paging_disabled'><a>上页</a></span>\n");
			}else{
				sb.append("	<span ><a onclick=\"nextPage(1)\">首页</a></span>\n");
				sb.append("	<span ><a onclick=\"nextPage("+(pageNo-1)+")\">上页</a></span>\n");
			}
			
			int showTag=Constants.SPLIT_PAGE_SHOW_TAG;
			int startTag = 1;
			if(pageNo>showTag){
				startTag = pageNo-1;
			}
			int endTag = startTag+showTag-1;
			
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(pageNo == i)
					sb.append("<span class='paging_current'><a><font >"+i+"</font></a></span>\n");
				else
					sb.append("	<span ><a onclick=\"nextPage("+i+")\">"+i+"</a></span>\n");
			}
			
			if(pageNo == totalPage){
				sb.append("	<span class='paging_disabled'><a>下页</a></span>\n");
				sb.append("	<span class='paging_disabled'><a>尾页</a></span>\n");
			}else{
				sb.append("	<span ><a onclick=\"nextPage("+(pageNo+1)+")\">下页</a></span>\n");
				sb.append("	<span ><a onclick=\"nextPage("+totalPage+")\">尾页</a></span>\n");
			}
			
			sb.append("	<span>第<font color='blue'>"+pageNo+"</font>页</span>\n");
			sb.append("	<span>共"+totalPage+"页</span>\n");
			
			sb.append(getDropDownBox());
			sb.append("</div>");
			
			sb.append("<script type=\"text/javascript\">\n");
			sb.append("function nextPage(page){\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('pageNo')>-1){\n");
			sb.append("				var reg = /pageNo=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'pageNo='+page);\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&pageNo=\"+page;\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?pageNo=\"+page;}\n");
			sb.append("		document.location = url;\n");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		
		return sb.toString();
	}



	public int getPageNo() {
		return pageNo;
	}



	public int getPageSize() {
		return pageSize;
	}
	
	
	
}

