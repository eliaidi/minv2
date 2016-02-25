<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="pg" uri="page-taglib"%>
<%@include file="/common/taglibs.jsp" %>

<html>
  <head>
  	<title>机务检修信息管理系统-配件管理-->仓库管理</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
    <script>
	    //写脚本，将普通表格渲染为扩展表格
		$(function(){
			//弹窗中将下面的width和height设为一个合适的数值让窗口不出现滚动条
			$('.flexiStyle').flexigrid({
				height:300,
				width:530,
				resizable: false,
				showToggleBtn: false
			});	
})
	</script>
 </head>
<style>
body{
	line-height:150%;
}
</style>
<body>	
	<table class="flexiStyle">
	<thead>
		<tr>
			<th width="60">姓名</th>
			<th width="50">性别</th>
			<th width="50">年龄</th>
			<th width="300">工作</th>
			<th width="300">联系方式</th>
			<th width="300">住址</th>
			<th width="60">婚姻状况</th>
			<th width="80">操作</th>
		</tr>
	</thead>                           
    <tbody>  
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td><span class="text_slice" style="width:200px;" title="这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。">这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。</span></td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>26</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>27</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		</tbody> 
	</table>


<div style="height:35px;">

	<div class="float_right padding5 paging">
		<div class="float_left padding_top4">
		<span class="paging_disabled"><a href="javascript:;">上一页</a></span>
		<span class="paging_current"><a href="javascript:;">1</a></span>
		<span><a href="javascript:;">2</a></span>
		<span><a href="javascript:;">3</a></span>
		<span><a href="javascript:;">4</a></span>
		<span><a href="javascript:;">5</a></span>
		<span>...</span>
		<span><a href="javascript:;">20</a></span>
		<span><a href="javascript:;">下一页</a></span> 每页
		</div>
		<div class="float_left"><select autoWidth="true"><option>50</option><option>100</option><option>150</option></select></div>
		<div class="float_left padding_top4">条记录</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>					
</body>
</html>

