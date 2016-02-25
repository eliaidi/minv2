<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

  <head>
    <title>${cache['SYS_TITLE'][0].value}-修改班组</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
   	
  </head>
<body>
  	<form action="updateUsersByIdByDepart!executeDepart.action" method="post" target="frmright" name="updateUsersProteamForm" id="updateUsersProteamForm">   
		<table class="tableStyle" transMode="true">
		    <tr>
				<td>转移到部门:</td>
				<td>
					<c:forEach items="${requestScope.usersId }" var="uid">
						<input type="hidden" id="usersId" name="usersId" value="${uid }"/>
					</c:forEach>	
				    <select id="departChange"  name="departChange" colNum="2">
					     <option value="">请选择部门</option>
					     <c:forEach items="${departList}" var="depart">
    	                     <option value="${depart.id}">${depart.departName}</option>
    	                 </c:forEach>
					</select>
				</td>
			</tr>
		
			<tr>
				<td colspan="2">
					<input type="submit" value=" 提 交 "/>
				</td>
			</tr>      
		</table>
  	</form>  
</body>
</html>