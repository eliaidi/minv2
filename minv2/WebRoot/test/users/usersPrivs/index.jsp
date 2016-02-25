<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usersPrivsActionTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	-->

  </head>
  
  <body>
    <a href="findUserById.action?userPrivs.id=1" target="_blank" >通过用户Id查询</a><br/>
     <a href="findUserByDictAreaId.action?userPrivs.dictArea.id=1" target="_blank" >通过/地区机务段Id查询</a><br/>
     <a href="updateUserById.action?userPrivs.id=1" target="_blank" >修改test用户密码</a><br/>
     <a href="delUserById.action?userPrivs.id=1" target="_blank" >删除test用户</a><br/>
     <a href="findAllUser.action?userPrivs.id=1" target="_blank" >查看所有用户</a><br/>
     <a href="findUserByName.action?userPrivs.userName=test" target="_blank" >通过用户名字查询</a><br/>
      <a href="findUserByDictDepartId.action?userPrivs.dictDepat.id=2" target="_blank" >通过部门Id查询</a><br/>
     
  </body>
</html>
