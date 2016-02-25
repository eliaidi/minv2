<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


<html>
  <head>
    <base href="<%=basePath%>">
    
   </head>
   <body>
   		共${sp.totalCount }条数据<br/>
   		<c:forEach var="test" items="${sp.data }">
   			${test.id }--${test.name }<br/>
   		</c:forEach>
   		${sp.pageString }  ${sp.dropDownBox }
   </body>
</html>
