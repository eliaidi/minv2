<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
     <table width="100%">
         <tr>
           <td>id</td>
           <td>name</td>
           <td>py</td>
           <td>remark</td>
            <td>操作</td>
         </tr>
         <c:forEach var="dd" items="${dictDepart}">
         <tr>
           <td>${dd.id}</td>
           <td>${dd.depatName}</td>
           <td>${dd.py}</td>
           <td>${dd.remark}</td>
           <td><a href="dictDepart!findById.action?id=${dd.id }">修改</a>
           &nbsp;&nbsp;&nbsp;
           <a href="dictDepart!delById.action?id=${dd.id }">删除</a>
             &nbsp;&nbsp;&nbsp;
            <a href="dictDepart!findByName.action?depatName=${dd.depatName }">根据部门名称查询，部门</a>
           </td>
          
         </tr>
         </c:forEach>
     </table>
  </body>
</html>
