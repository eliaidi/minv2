<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <!-- 取map缓存中list元素中得第一个对象的value值，标题 -->
    <title>${cache['SYS_TITLE'][0].value}</title>
    
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
  	  添加<br>
      <form action="addTest.action" method="post">
    	 姓名：<input type="text" id="name" name="test.name" /><br/>
     	 密码：<input type="password" id="password" name="test.password" /><br/>
     	<input type="submit" value="提交">
    	</form>
    	
    	删除<br>
    	 <form action="delTest.action" method="post">
    	 id：<input type="text" id="id" name="test.id" /><br/>
     	<input type="submit" value="提交">
    	</form>
    	
    	<br/>
    	<c:forEach var="item" items="${cache['ROLE_FIELD']}">
			${item }<br>
		</c:forEach>
  </body>
</html>
