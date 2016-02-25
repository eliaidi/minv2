<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>机务检修信息管理系统-配件管理-->配件记录管理-->配件出入库记录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

    <script  src="${ctx }/test/lenovoInput/lenovoInput.js"></script>
  </head>
  
  <body>
      <input onkeyup= "showTips(event);" id="txt" >(eg.ShanDong)<br>
      <select id="sel" class="default" style='display:none' onclick="rv()" onkeydown='if(event.keyCode==13)rv();'>
          <c:forEach var="s" items="${staticInfo}"> 
        		 <option  value="${s.id}">${s.pjName}</option>
         </c:forEach>
      </select>
  </body>
</html>
