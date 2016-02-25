<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  
      <form action="addDictDepart.action" method="post">
		       <%--     部门编号：<input name="id" type="text"/><br>
		          部门名称：<input name="depatName" type="text"/><br>
		          拼音：<input name="py" type="text"/><br>
		          备注：<input name="remark" type="text"/><br> --%> 
		          <input value="添加部门执行" type="submit"/><br>
      </form>
       <a href="findAllDictDepat.action">部门信息</a><br><br>
       <a href="delDictDepatById.action?dictDepat.id=12"> 根据id，删除</a><br><br>
       <a href="delDictDepatByName.action?dictDepat.depatName=kkk"> 根据部门名，删除</a><br><br>
       <a href="updateDictDepatById.action"> 根据部门id，修改</a><br><br>
       <a href="findDictDepatById.action?dictDepat.id=4"> 根据部门id，查找</a><br><br>
       <a href="findDictDepatByName.action?dictDepat.depatName=晓睿科技">根据部门名，查询部门</a><br><br>
      <br><br>
      <hr>
     <form action="addDictProteam.action" method="post">
		        <%--   班组编号：<input name="id" type="text"/><br>
		          班组名称：<input name="proteamName" type="text"/><br>
		          字段：<input name="workFlag" type="text"/><br>
		          考情字段：<input name="attendanceFlag" type="text"/><br> --%> 
		          <input value="添加班组部门执行" type="submit"/><br>
      </form>
      <a href="delDictProteamById.action?dictProteam.id=8"> 班组，根据id，删除</a><br><br>
      <a href="delDictProteamByName.action?dictProteam.proteamName=车床组"> 班组，根据班组名，删除</a><br><br>
      <a href="findAllDictProteam.action"> 查询所有班组</a><br><br>
      <a href="findDictProteamById.action?dictProteam.id=3">根据班Id，查询</a><br><br><br>
      <a href="findDictProteamByName.action?dictProteam.proteamName=机关中修组">根据班组名，查询</a><br><br><br>
      <a href="findDictProteamByWorkFlag.action?dictProteam.workFlag=3">根据班组，小辅修、中修判别字段，查询</a><br><br>
      <a href="findDictProteamByAttendanceFlag.action?dictProteam.attendanceFlag=0">根据班组，考勤判别字段，查询（0、不考勤；1、考勤）</a><br><br>
      <a href="UpdateDictProteamById.action">根据班组id修改数据</a><br><br>
  </body>
</html>
