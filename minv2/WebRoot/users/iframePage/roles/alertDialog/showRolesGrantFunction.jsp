<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

  <head>
  	<title>${cache['SYS_TITLE'][0].value}-角色授权</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

 </head>
	<body>
	    <!-- 盒子模型上方				开始 -->
		<div>
		<div  style="overFlow:scroll;width:510px;height: 350px">
			<!--角色授权数据据显示                                    		开始 -->
			  
			    <font style="font-weight:bold">角色拥有的权限功能：</br>
			      <c:forEach var="roleFunctionPrivs" items="${role.roleFunctionPrivses}" varStatus="start">
			              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${start.index+1}、【<font color="red">${roleFunctionPrivs.functionPrivs.functionName}</font>】<br/>
			      </c:forEach>
			      </font>
			      
			     &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
			      <c:if test="${empty role.roleFunctionPrivses}"> 
			           <img src="${ctx}/images/icons/png/ku.png" width="50" height="60"/>
			                                             暂无 角色相关的功能权限信息！
			      </c:if>
			
			<!-- 角色授权数据数据显示          结束 -->
		   </div>
		</div>
		<!-- 盒子模型上方				结束 -->
		
		<div style="display: inline">
			
		</div>
	</body>
</html>