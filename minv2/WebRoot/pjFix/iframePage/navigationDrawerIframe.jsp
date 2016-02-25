<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--多级抽屉型导航(分离版)start-->
	<link href="${ctx}/js/navigationDrawer/skins/blue/style.css" rel="stylesheet" type="text/css" id="compStyle" />
	<script type="text/javascript" src="${ctx}/js/navigationDrawer/js/ddaccordion_split.js"></script>
	<!---多级抽屉型导航(分离版)end-->

	<body>
		<!-- 设置宽度DIV                                                开始 -->
		<div class="minv2_navigationDrawer_mainDiv_class">
			<!-- arrowlistmenu 抽屉导航DIV                                  开始 -->
			<div class="arrowlistmenu">
				<!-- 抽屉导航菜单标题 -->
				<div class="minv2_navigationDrawer_titleDiv_class" align="center">管&nbsp;&nbsp;理&nbsp;&nbsp;菜&nbsp;&nbsp;单</div>
				<!-- 菜单一                                                                  开始 -->
				<div class="menuheader expandable">配件检修</div>
				<ul class="categoryitems">
					 <li><a href="queryPjSSInfoByChooseFixPj.action" target="frmright"><span>选择配件</span></a></li>
				    <li><a href="queryPjSSInfoByFixUsers.action" target="frmright"><span>工人签认</span></a></li>
				    <li><a href="queryPjSSInfoByLead.action" target="frmright"><span>工长签认</span></a></li>
				    <li><a href="queryPjSSInfoByQC.action" target="frmright"><span>质检员卡控</span></a></li>
				    <li><a href="queryPjSSInfoByTechnician.action" target="frmright"><span>技术员卡控</span></a></li>
				    <li><a href="queryPjSSInfoByCommitLead.action" target="frmright"><span>交车工长卡控</span></a></li>
				    <li><a href="queryPjSSInfoByAcceptance.action" target="frmright"><span>验收员卡控</span></a></li>
				</ul>
				<!-- 菜单一                                                                  结束 -->
				<!-- 菜单二                                                                  开始 -->
				<div class="menuheader expandable">配件管理</div>
				<ul class="categoryitems">
					<li><a href="${ctx}/pjFix/iframePage/pjSDInfoForRepair/pjSDInfoForRepairCheckIframe.jsp" target="frmright"><span>添加待修配件检查</span></a></li>
					<li><a href="queryPjSSInfoForPjFix.action" target="frmright"><span>配件大类</span></a></li>
					<li><a href="queryPjSDInfoForPjFix.action" target="frmright"><span>查询配件检修记录</span></a></li>
				</ul>
				<!-- 菜单二                                                                  结束 -->
				<!-- arrowlistmenu 抽屉导航DIV                                  结束 -->
			</div>
			<!-- 设置宽度DIV                                                结束 -->

			<body>

</html>