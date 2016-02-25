<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<!--框架必需end-->
	
	<script type="text/javascript" src="${urlctx}js/plan/planCompile/exist_main_plan.js"></script>
	
</head>
<body>
	<input type="hidden" id="basePath" value="${urlctx }" /> 
	<table class="tableStyle"  useMultColor="true">
		  <tr>
		        <th width="5%">序号</th>
				<th width="10%">计划开始日期</th>
				<th width="10%">计划结束日期</th>
				<th width="15%">计划标题</th>
				<th width="10%">编制人</th>
				<th width="10%">编制时间</th>
				<th width="10%">状态</th>
				<th width="10%">操作</th>
		   </tr>
	      <c:forEach var="mainPlan" items="${planList}" varStatus="s">
	         <tr>
	            <td width="5%" align="center">${s.index+1}</td>
          		<td width="10%" align="center"><fmt:formatDate value="${mainPlan.startTime }" pattern="yyyy-MM-dd"/></td>
				<td width="10%" align="center"><fmt:formatDate value="${mainPlan.endTime }" pattern="yyyy-MM-dd"/></td>
				<td width="15%" align="center">${mainPlan.title }</td>
				<td width="10%" align="center">${mainPlan.maker }</td>
				<td width="10%" align="center"><fmt:formatDate value="${mainPlan.makeTime }" pattern="yyyy-MM-dd"/></td>
				<td width="10%" align="center">
				  <c:if test="${mainPlan.status==0}"><font color="red">未发布</font></c:if>
				  <c:if test="${mainPlan.status==1}">已发布</c:if>
				</td>
				<td width="10%" align="center">
				       <a href="javascript:void(0);" onclick="findMainPlanDetail(${mainPlan.id});" style="color:blue;">计划详情</a>&nbsp;&nbsp;&nbsp;
				       <a href="javascript:void(0);" onclick="findCashDetail(${mainPlan.id});" style="color:blue;">兑现详情</a>
				</td>
	         </tr>
	      </c:forEach>
	      <tr><td colspan="8" align="center"><button onclick="closeDialog();"><span class="icon_ok">确       认</span></button></td></tr>
		</table>
		<div style="height:40px;"></div>
</body>
</html>