<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>机务检修系统--检修记录-检修记录详情--查询子配件</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
  
    
  </head>
  
  
  <body>
        <div class="" panelTitle="检修记录详情" roller="true" overflow="true" >
        <div>
         <center>
	         <table>
	             <th><font color="black" size="4"> 子配件列表</font></th>
	         </table>
      	</center>
      	</div>
      <div>
                     配件名称：<font color="red">${psdi.pjStoreStaticInfo.pjName}</font> &nbsp;&nbsp;&nbsp;&nbsp;
     	配件编号：<font color="red">${psdi.pjdCode}</font> &nbsp;&nbsp;&nbsp;&nbsp; 
     	共有-<font color="red">${fn:length(psdi.childPjStoreDynamicInfos)}</font>-个子配件
     	</div>
     	
     	<!-- 数据显示层									开始 -->
     	
		<div id="scrollContent">
			<table class="tableStyle">
				<tr>
					<th>序号</th>
					<th>配件名称</th>
					<th>配件编号</th>
				</tr>
				<c:forEach var="childPjStoreDynamicInfo" items="${psdi.childPjStoreDynamicInfos}" varStatus="childStratus">
	     	    <tr>
		     	      <td>${childStratus.index+1}</td> 
		     	      <td>${childPjStoreDynamicInfo.pjStoreStaticInfo.pjName}</td> 
		     	      <td>${childPjStoreDynamicInfo.pjdCode}</td>
	     	   </tr>
	     	   </c:forEach>
			</table>
		</div>
     	<!-- 数据显示层									结束 -->
     	
     </div>
        <!--uurframe盒子模型下方						结束-->
        
  </body>
</html>
