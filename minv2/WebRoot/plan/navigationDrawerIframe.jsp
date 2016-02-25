<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<html >
	
	<!--多级抽屉型导航(分离版)start-->
	<link href="${ctx}/js/navigationDrawer/skins/blue/style.css" rel="stylesheet" type="text/css" id="compStyle"/>
	<script type="text/javascript" src="${ctx}/js/navigationDrawer/js/ddaccordion_split.js"></script>
	<!---多级抽屉型导航(分离版)end-->
	
	<body>
		<!-- 设置宽度DIV                                                开始 -->
		<div class="minv2_navigationDrawer_mainDiv_class">
			<!-- arrowlistmenu 抽屉导航DIV                                  开始 -->
			<div class="arrowlistmenu">
				<!-- 抽屉导航菜单标题 -->
				<div class="minv2_navigationDrawer_titleDiv_class" class="center">计&nbsp;&nbsp;划&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;菜&nbsp;&nbsp;单</div>
				<!-- 菜单一                                                                  开始 -->
				<!-- 
				<div class="menuheader expandable">加改管理</div>
				<ul class="categoryitems">
				    <li><a href="#" target="frmright"><span>加改编辑</span></a></li>
				    <li><a href="#" target="frmright"><span>统计查询</span></a></li>
				</ul>
				 -->
				<!-- 菜单一                                                                  结束 -->
				<!-- 菜单二                                                                  开始 -->
				<div class="menuheader expandable">计划管理</div>
				<ul class="categoryitems">
					<li><a href="${urlctx }plan/planCompile/edit_main_plan.jsp" target="frmright"><span>计划编制</span></a></li>
					<li><a href="${urlctx }plan/queryJcMainPlan.action" target="frmright"><span>计划查询</span></a></li>
					<li><a href="${urlctx }plan/queryCashJcMainPlan.action" target="frmright"><span>计划兑现</span></a></li>
				</ul>
				
			</div>
			<!-- arrowlistmenu 抽屉导航DIV                                  结束 -->
		</div>
		<!-- 设置宽度DIV                                                结束 -->
	<body>
</html>