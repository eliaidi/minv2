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
   	<a href="http://localhost:8080/minv2/roleFunction/delRoleFunctionById.action?roleFunctionPrivs.id=6" 
   		target="_blank">通过角色功能ID删除角色功能</a><br/>
   	<a href="http://localhost:8080/minv2/roleFunction/delRoleFunctionByFunctionPrivsId.action?roleFunctionPrivs.functionPrivs.id=4" target="_blank">通过功能ID删除角色功能</a><br/>
   	<a href="http://localhost:8080/minv2/roleFunction/delRoleFunctionByRolePrivsId.action?roleFunctionPrivs.rolePrivs.id=3" target="_blank">通过角色ID删除角色功能</a><br/>
  </body>
</html>
