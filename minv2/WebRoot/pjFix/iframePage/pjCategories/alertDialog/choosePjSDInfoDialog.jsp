<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>

<html>
  <head>
    <title>机务检修系统--配件大类--添加待修配件--选择</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	
	<!-- 引用配件大类js文件				开始 -->
    <script type="text/javascript" src="${ctx}/js/pjFix/chooseDialogl_script.js"></script>
    <!-- 引用配件大类js文件				结束 -->
    
  </head>
  
  <body>
  	<!--uurframe盒子模型   上方					开始-->
    <div class="" panelTitle="添加待修配件" roller="true" overflow="true">
    <!-- frmright窗口table索引 -->
    <input type="hidden" value="${param.rowIndex }" id="rowIndex"/>
     <!-- 数据显示层									开始 -->
     <div id="scrollContent">
       <table class="tableStyle" useMultColor="false" useCheckBox="true" id="tbe">
				<tr>
					
					<th>配件编码</th>
					<th>配件状态</th>
					<th>配件位置</th>
					<th>配件生产厂家</th>
					<th>配件出厂日期</th>
					<th>操作</th>
				</tr>
				<c:forEach var="SDInfo" items="${pjSDInfos}">
				<c:set var="psdi" value="${SDInfo}" scope="request"> </c:set>
		     	 <tr>
		     	      <td><input type="hidden" id="pjdCode" name="pjdCode" value="${SDInfo.pjdCode}"/>${SDInfo.pjdCode}</td> 
		     	      <%-- 获取配件状态 --%>
					  <%
						PjStoreDynamicInfo psdi=(PjStoreDynamicInfo)request.getAttribute("psdi");
						long status=psdi.getPjdStatus();
						String statusText=Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS.get(status);
						request.setAttribute("pjdStatus", statusText);
					  %>
		     	      <td>${pjdStatus}</td> 
		     	      <td>${SDInfo.dictStorePosition.storePositionName }</td>
		     	      <td>${SDInfo.pjdFactory}</td>
		     	      <td>${SDInfo.pjdOutFactoryDate}</td>
		     	      <td><button id="choose">选择</button></td>
		     	 </tr>
		     	 </c:forEach>
		 </table>
		 <br><br><br>
		 <center><font size="2"><c:if test="${empty pjSDInfos}">~~~ 无相关配件信息 ~~~ </c:if></font></center>
	   </div>
	   <!-- 数据显示层									结束 -->
		
	</div>
  </body>
</html>
