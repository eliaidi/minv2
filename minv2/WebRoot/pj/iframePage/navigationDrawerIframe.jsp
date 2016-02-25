<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!-- 得到根路径 -->
<c:set value="<%=request.getContextPath()%>" var="ctx"></c:set>
<!-- 得到全路径 uur框架图标不显示，需要用到全路径，才能显示图片-->
<c:set value="<%=basePath%>" var="urlctx"></c:set>
<html >
	<head>
	<!--框架必需start-->
	<script type="text/javascript" src="${urlctx}mainframe/js/jquery-1.4.js"></script>
	<script type="text/javascript" src="${urlctx}mainframe/js/framework.js"></script>
	<link href="${urlctx}mainframe/css/import_basic.css" rel="stylesheet" type="text/css"/>
	
	<!-- uurframe页面框架                                                                                        开始-->
	<!-- 所有的css都从mainframe目录开始找 -->
	<link  rel="stylesheet" type="text/css"  id="skin" prePath="${urlctx}mainframe/"/>
	

	<!--左侧  导航栏     			开始-->
	<script type="text/javascript" src="${urlctx}mainframe/js/bsFormat.js"></script>
	<link rel="stylesheet" type="text/css" href="${urlctx}js/style.css" />
	<script type="text/javascript" src="${urlctx}mainframe/js/nav/ddaccordion.js"></script>
	<style>
	a {
		behavior:url(../js/method/focus.htc)
	}
	
	</style>
<!--左侧  导航栏     				结束-->
</head>
	<body>
		<!-- 设置宽度DIV                                                开始 -->
		<div class="minv2_navigationDrawer_mainDiv_class">
			<!-- arrowlistmenu 抽屉导航DIV                                  开始 -->
			<div class="arrowlistmenu">
				<!-- 抽屉导航菜单标题 -->
				<div class="minv2_navigationDrawer_titleDiv_class" align="center">管&nbsp;&nbsp;理&nbsp;&nbsp;菜&nbsp;&nbsp;单</div>
				<!-- 菜单一                                                                  开始 -->
				<div class="menuheader expandable">仓库</div>
				<ul class="categoryitems">
				    <li><a href="queryDictStorePosition.action" target="frmright"><span>仓库管理</span></a></li>
				</ul>
				<!-- 菜单一                                                                  结束 -->
				<!-- 菜单二                                                                  开始 -->
				<div class="menuheader expandable">配件</div>
				<ul class="categoryitems">
					<li><a href="${urlctx }findPagePjStoreStaticInfo.action" target="frmright"><span>配件静态信息管理</span></a></li>
					<li><a href="${urlctx }findAllDictPjFirstUnit.action" target="frmright"><span>新件入库</span></a></li>
					
					<li>
						<a href="javascript:;" target="frmright"><span>配件动态信息管理</span></a>
						<ul>
							<li><a href="${urlctx}toUnitManageIframe.action" target="frmright"><span>专业分类</span></a></li>
							<li><a href="${urlctx }toJcTypeManageIframe.action" target="frmright"><span>车型分类</span></a></li>
						</ul>
					</li>
					<li>
						<a href="javascript:;" target="frmright"><span>配件记录管理</span></a>
						<ul>
							<li><a href="${urlctx }queryPjSDInfoRecord.action" target="frmright"><span>配件出入库记录</span></a></li>
						</ul>
					</li>
					
				</ul>
				<!-- 菜单二                                                                  结束 -->
				<!-- 菜单三                                                                  开始 -->
				<div class="menuheader expandable">专业</div>
				<ul class="categoryitems">
					<li><a href="toFirstUnitManageIframe.action" target="frmright"><span>专业管理</span></a></li>
				</ul>
				<%--
				<!-- 菜单四                                                                  开始 -->
				<div class="menuheader expandable">车上组装</div>
				<ul class="categoryitems">
					<li><a href="${urlctx }pj/iframePage/pjAssembly/jcChoosePjAssemblyManageIframe.jsp" target="frmright"><span>机配车上组装</span></a></li>
					<li><a href="${urlctx }pj/iframePage/pjAssembly/pjAssembly.jsp" target="frmright"><span>配机车上组装</span></a></li>
				</ul>
				 --%>
			</div>
			<!-- arrowlistmenu 抽屉导航DIV                                  结束 -->
		</div>
		<!-- 设置宽度DIV                                                结束 -->
	</body>
</html>