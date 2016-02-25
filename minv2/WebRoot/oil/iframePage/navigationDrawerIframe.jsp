<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<!--多级抽屉型导航(分离版)start-->
	<link href="${ctx}/js/navigationDrawer/skins/blue/style.css" rel="stylesheet" type="text/css" id="compStyle" />
	<script type="text/javascript" src="${ctx}/js/navigationDrawer/js/ddaccordion_split.js"></script>
	<!---多级抽屉型导航(分离版)end-->
</head>
	<body>
		<!-- 设置宽度DIV                                                开始 -->
		<div class="minv2_navigationDrawer_mainDiv_class">
			<!-- arrowlistmenu 抽屉导航DIV                                  开始 -->
			<div class="arrowlistmenu">
				<!-- 抽屉导航菜单标题 -->
				<div class="minv2_navigationDrawer_titleDiv_class" align="center">机&nbsp;&nbsp;车&nbsp;&nbsp;检&nbsp;&nbsp;修</div>
				<%--
				<!-- 菜单一                                                                  开始 -->
				<div class="menuheader expandable">报活</div>
				<ul class="categoryitems">
				    <li><a href="#" target="frmright"><span>报活</span></a></li>
				</ul>
				 --%>
				<!-- 菜单一                                                                  结束 -->
				<!-- 菜单二                                                                  开始 -->
				<div class="menuheader expandable">油水</div>
				<ul class="categoryitems">
					<li><a href="${urlctx}oil/listOilAssayMainItemRec.action" target="frmright"><span>油水取样化验 </span></a></li>
					
				</ul>
				<!-- 菜单二                                                                  结束 -->
				
			<!-- arrowlistmenu 抽屉导航DIV                                  结束 -->
		</div>
		<!-- 设置宽度DIV                                                结束 -->
	</div>
</body>
</html>