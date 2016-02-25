<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


  <head>
    <title>${cache['SYS_TITLE'][0].value}-选择角色</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
   	
  </head>
 
  
  <body>
  	<form action="">
  		<table>
  			
	         <c:forEach items="${roleInUsers }" var="roleInUser" varStatus="roleCount">
	          		&nbsp;&nbsp;&nbsp;&nbsp;
		          		<input type="checkbox" name="ckRoleInUser" id="ckRoleInUser" value="${roleInUser.id}"/>
		          		${roleInUser.id}.${roleInUser.roleName } 
		          		<c:if test="${roleCount.count % 2 eq 0}">
		          			<br/>
		          	    </c:if>
	         </c:forEach>
	        <tr>
	        	 <td>
	        	 <!--隐藏域获取复选框的值-->
	        	  <input type="hidden" id="roleInUsersHid" name="roleInUsersHid" value="${roleInUsersList }"  />
	        	 友情提示：用户需要充当一个角色,请选择角色的时候,<br/>
	        	 至少选择一个角色，最多5个角色。如有存在多于5个角色的用户,<br/>
	        	 请联系系统管理员。
		        	 <br/>
		        	 <br/>
		        	 <br/>
		        	 <br/>
	        	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        	 &nbsp;&nbsp;&nbsp;&nbsp;
	        	
		        	<input type="button" id="closeSelectRoleInUsersDialog" value="确定"/>
		        	<input type="reset" value="重置"/>
		        </td>
	        </tr>
	    </table> 
    </form> 
  </body>
  <!-- 自定义js -->
  <script type="text/javascript" charset="UTF-8" src="${ctx}/js/users/selectRolesInUsersDialog.js" ></script>
</html>
