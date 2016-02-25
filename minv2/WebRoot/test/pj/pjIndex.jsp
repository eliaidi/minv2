<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dictPjFirstUnitIndex.jsp' starting page</title>
    
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
      DictPjFirstUni信息：<br>
      <a href="findAllDictPjFirstUnit.action">查询所有数据</a><br><br>
      
      <a href="findDictPjFirstUnitByUnitName.action?firstUnitName='测试3'">通过firstUnitName查询数据</a><br><br>
 
      <a href="addDictPjFirstUnit.action">添加数据</a>
      <hr>
      PjStoreStaticInfo信息：<br>
      <a href="findPjStoreStaticInfoById.action?id=1">通过Id查询数据</a><br><br>
      
      <a href="deletePjStoreStaticInfo.action?id=1">删除数据</a><br><br>
      
      <a href="updatePjStoreStaticInfo.action?id=1&pjName=测试">修改数据</a><br><br>
      <a href="queryPjStoreStaticInfo.action">查询数据</a>
            【分页提取数据】：
      <c:forEach var="pjSSInfon" items="${pjStoreStaticInfo.datas}" varStatus="status">
                    [${status.index }、  ${ pjSSInfon.pjName}]&nbsp;&nbsp;
      </c:forEach>
       <hr>
       PjStoreDynamicInfo信息：<br>
       <a href="findPjStoreDynamicInfoById.action?id=1">通过Id查询数据</a><br><br>
       
       <a href="deletePjStoreDynamicInfo.action?id=3">删除数据</a><br><br>
       
       <a href="updatePjStoreDynamicInfo.action?id=2">修改数据</a>
       <a href="findAllPjStoreDynamicInfo.action">查询数据</a>
          【分页提取数据】：
      <c:forEach var="pjSDInfon" items="${pjStoreDynamicInfo.datas}" varStatus="status">
                    [${status.index }、  ${pjSDInfon.pjdFactory}]&nbsp;&nbsp;
      </c:forEach>
  </body> 
</html>
