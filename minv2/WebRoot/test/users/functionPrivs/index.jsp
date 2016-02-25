<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<a href="http://localhost:8080/minv2/findFunctionById.action?functionPrivs.id=2" 
   		target="_blank">通过功能ID查看信息</a><br/>
   	<a href="http://localhost:8080/minv2/findAllFunction.action" target="_blank">查看所有功能</a><br/>
   	<a href="http://localhost:8080/minv2/findFunctionByParentId.action?functionPrivs.parentId=0" target="_blank">通过父级ID查询功能信息</a><br/>
   	<a href="http://localhost:8080/minv2/findAllOfFunctionOrderASC.action" target="_blank">查询所有，按菜单（操作功能）名顺序，升序</a><br/>
  </body>
</html>
