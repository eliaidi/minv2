<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>机务检修系统--检修记录-检修记录详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
    
    <!-- 引入自定义样式				开始 -->
    <link href="${ctx}/js/style.css" rel="stylesheet" type="text/css"/>
    <!-- 引入自定义样式				结束 -->
	
    <!-- 引进打印功能 外部插件			开始 -->
	<script type="text/javascript" src="${ctx}/js/pjFix/printData/printJs/jquery.jqprint-0.3.js"></script>
	<script type="text/javascript" src="${ctx}/js/pjFix/pjSDIRecordFixCheckDetailsDialog_script.js"></script>
    <!-- 引进打印功能 外部插件			结束 -->
  </head>
  
  <body>
  <div id="print">
      <div class="" panelTitle="检修记录详情" roller="true" overflow="true" >
        <div>
         <center>
	         <table>
	             <th> <font color="blue" size="4">${pjSDR.pjStoreDynamicInfo.pjStoreStaticInfo.pjName}</font>-- <font color="black" size="4"> 检修记录详情</font></th>
	         </table>
      	</center>
      	</div>
      <div>
                     配件名称：<font color="red">${pjSDR.pjStoreDynamicInfo.pjStoreStaticInfo.pjName}</font> &nbsp;&nbsp;&nbsp;&nbsp;
     	配件编号：<font color="red">${pjSDR.pjStoreDynamicInfo.pjdCode}</font> &nbsp;&nbsp;&nbsp;&nbsp; 
     	现存储位置：
     	<font color="red">
	     	${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionName} 
	    </font>
	     	--- 
     	<font color="red">
     		   <c:forEach var="pjSDInfoPjdStypeEntry" items="${pjSDInfoPjdStypeMap}">
	        		<c:if test="${pjSDInfoPjdStypeEntry.key == pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType}">
	        			${pjSDInfoPjdStypeEntry.value }
	        		</c:if>
	        	</c:forEach>
      	 </font>
     	&nbsp;&nbsp; &nbsp;&nbsp;
     	配件状态：
     	<font color="red">
	     	    <c:forEach var="pjSDInfoPjdStatusEntry" items="${pjSDInfoPjdStatusMap}">
	        		<c:if test="${pjSDInfoPjdStatusEntry.key == pjSDR.pjStoreDynamicInfo.pjdStatus}">
	        			${pjSDInfoPjdStatusEntry.value }
	        		</c:if>
	        	</c:forEach>
	     	</font> 
     	 &nbsp;&nbsp; &nbsp;&nbsp;
     	检修项目：<font color="red">${fn:length(pjSDR.pjSDInfoRecordFixs) }</font>项&nbsp;&nbsp;&nbsp;&nbsp;
     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     	
     	<button  onclick='top.Dialog.open({URL:"findPjSDRByPjSDIdForPjFix.action?pjSDInfoId=${pjSDR.pjStoreDynamicInfo.id}",Title:"查看子配件",Width:600,Height:300});'>查询子配件</button>
     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     	
     	<button id="go">打印</button>
     	
     	<br>
     	</div>
     	
     	<!-- 数据显示层									开始 -->
     	
		<div id="scrollContent">
		  
			<table class="tableStyle">
				<tr>
					<th>项目名称</th>
					<th>部位</th>
					<th>检修/探伤情况</th>
					<th>检修/探伤人</th>
					<th>工长</th>
					<th>交车工长</th>
					<th>质检员</th>
					<th>技术员</th>
					<th>验收员</th>
				</tr>
				<c:forEach var="recordFix" items="${pjSDR.pjSDInfoRecordFixs}">
	     	    <tr>
		     	      <td>${recordFix.pjFixItem.fixItemName}</td> 
		     	      <td>${recordFix.pjFixItem.fixItemPart}</td> 
		     	      <td>${recordFix.fixCondition}10</td>
		     	       <td>${recordFix.fixUsersIds}${recordFix.fixTime}</td> 
		     	      <td>${recordFix.pjSDIRecordFixCheck.leadUsers.userName}${recordFix.pjSDIRecordFixCheck.leadCheckTime}</td> 
		     	      <td>${recordFix.pjSDIRecordFixCheck.commitLeadUsers.userName}${recordFix.pjSDIRecordFixCheck.commitLeadCheckTime}</td> 
		     	      <td>${recordFix.pjSDIRecordFixCheck.qcUsers.userName}${recordFix.pjSDIRecordFixCheck.qcCheckTime}</td> 
		     	      <td>${recordFix.pjSDIRecordFixCheck.technicianUsers.userName}${recordFix.pjSDIRecordFixCheck.technicianCheckTime}</td> 
		     	      <td>${recordFix.pjSDIRecordFixCheck.acceptanceUsers.userName}${recordFix.pjSDIRecordFixCheck.acceptanceCheckTime}</td> 
	     	   </tr>
	     	   </c:forEach>
			</table>
		</div>
     	<!-- 数据显示层									结束 -->
     	
     </div>
        <!--uurframe盒子模型下方						结束-->
      </div> 
	<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
  </body>
</html>
