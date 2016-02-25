<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>机务检修系统--配件检修-添加待修配件</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
    
    <!-- 引入自定义样式				开始 -->
    <link href="${ctx}/js/style.css" rel="stylesheet" type="text/css"/>
    <!-- 引入自定义样式				结束 -->
    
  </head>
  
  
  <body>
      <div class="" panelTitle="添加待修配件" roller="true" overflow="true">
        <div style="color:red">
         <center>
	         <table>
	             <th> <font color="blue" size="4">${psdi.pjStoreStaticInfo.pjName}</font>-- <font color="black" size="4">检修记录</font></th>
	         </table>
      	</center>
      	</div>
      <div>
     	 配件名称：<font color="red">${psdi.pjStoreStaticInfo.pjName }</font> &nbsp;&nbsp;&nbsp;
     	配件编号：<font color="red">${psdi.pjdCode}</font> &nbsp;&nbsp;&nbsp;
     	现存储位置：
     	<font color="red">
	     	${psdi.dictStorePosition.storePositionName} 
	    </font>
	     	--- 
     	<font color="red">
     	 <c:forEach var="pjSDInfoPjdStypeEntry" items="${pjSDInfoPjdStypeMap}">
	        		<c:if test="${pjSDInfoPjdStypeEntry.key == psdi.dictStorePosition.storePositionType}">
	        			${pjSDInfoPjdStypeEntry.value }
	        		</c:if>
	        	</c:forEach>
      	 </font>&nbsp;&nbsp;&nbsp;
     	配件状态：
	     	<font color="red">
	     	     <c:forEach var="pjSDInfoPjdStatusEntry" items="${pjSDInfoPjdStatusMap}">
	        		<c:if test="${pjSDInfoPjdStatusEntry.key == psdi.pjdStatus}">
	        			${pjSDInfoPjdStatusEntry.value }
	        		</c:if>
	        	</c:forEach>
	     	</font> &nbsp;&nbsp;&nbsp;
                    检修次数：<font color="red">${fn:length(recordList) }</font><br>
     	</div>
     	<!-- 数据显示层									开始 -->
     	
		<div id="scrollContent">
			<table class="tableStyle"  >
				<tr>
					
					<th>修次</th>
					<th>检修时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="pjSDRd" items="${recordList}" varStatus="pjSDRdIndex">
		     	  <tr>
		     	      
		     	      <td>第-<font color="blue">${pjSDRdIndex.index+1}</font>-次检修</td> 
		     	      <td>${pjSDRd.recordTime}</td>
		     	      <td>
						<a target="_blank" style="color:blue" href="findPjSDRByPjSDInfoIdForPjFix.action?pjSDInfoRecordId=${pjSDRd.id}">检修记录</a>
					  </td>
		     	  </tr>
     	  	   </c:forEach>
			</table>
			<br><br><br>
			 <center><font size="2"><c:if test="${empty recordList}">~~~ 无相关检修记录信息 ~~~ </c:if></font></center>
		</div>
     	<!-- 数据显示层									结束 -->
     </div>
        <!--uurframe盒子模型下方						结束-->
        
	
  </body>
</html>
