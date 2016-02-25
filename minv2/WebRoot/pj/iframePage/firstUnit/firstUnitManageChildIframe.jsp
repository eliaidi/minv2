<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
 
 <head>
  	<title>${cache['SYS_TITLE'][0].value}--->专业管理-->专业管理右边</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
 </head>
  
  <body>
    <!-- 专业管理 功能操作和数据显示区域    专业详细信息************ -->
  	 <div  class="box2" panelTitle="专业管理" roller="false" overflow="true" panelWidth="400">
		<table transMode="true">
			<tr>
				<td>专业名称：</td>
				<td align="left" width="200px">${pjFirstUnit.firstUnitName}</td>
			</tr>
			<tr>
				<td>拼&nbsp;&nbsp;音：</td>
				<td align="left">${pjFirstUnit.py }</td>
			</tr>
			<tr>
				<td>适应车型：</td>
				<td align="left">
					<c:forEach var="jcTypePjFirstUnit" items="${pjFirstUnit.jcTypePjFirstUnits}">
	                 	 ${jcTypePjFirstUnit.dictJcType.jcTypeValue}
               		</c:forEach>
				</td>
			</tr>
			<tr>
				<td>备&nbsp;&nbsp;注：</td>
				<td align="left">${pjFirstUnit.remark }</td>
			</tr>
		</table>
			
	</div>
	<!-- 用户管理 功能操作和数据显示区域    end  ************* -->
	
	

  </body>
</html>
