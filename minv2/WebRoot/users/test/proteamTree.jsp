<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${urlctx }">
    
    <title>My JSP 'proteamTree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    	
	<!-- uurframe多级树形表格组件		                              开始 -->
	<script type="text/javascript" src="js/dtree/dtree.js"></script>
	<link href="js/dtree/dtree.css" rel="stylesheet" type="text/css"/>
	<!-- uurframe多级树形表格组件		                               结束 -->
	
  </head>
  
  <body>
   <!-- 盒子模型上方                                                            开始 -->
	<div class="box4" panelWidth="800" panelHeight="600"  panelTitle="班组目录">
		<!--班组(proteam)目录进行编辑数据部分 				开始-->
		<div style="text-align:left;" >
			<br />
				<button onclick='top.Dialog.open({URL:"updProteam.jsp",Width:800,Height:600,Title:""});'>
				<span class="icon_add">新增</span></button>
				<button onclick='top.Dialog.open({URL:"updProteam.jsp",Width:800,Height:600,Title:""});'>
				<span class="icon_edit">修改</span></button>
				<button><span class="icon_delete">删除</span></button>
		</div>
	   <!--班组(proteam)目录进行编辑数据部分 				结束-->
  	    <!-- 班组(proteam)目录数据的显示 DIV						开始-->
		<div id="scrollContent">
			<script type="text/javascript" src="js/dtree/dtreedata.js"></script>
	    </div>
	    <!-- 班组(proteam)目录数据的显示 DIV						结束-->
    </div>
    <!-- 盒子模型上方                                                            结束 -->	
  </body>
</html>
