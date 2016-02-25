<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工人签认----检修中配件--进入签认</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- 自定义js -->
		<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/fixUsers/fixUsersSignManagerIframe_script.js"></script>

		<!-- 引用table签认页面js -->
		<script type="text/javascript" src="${ctx}/mainframe/js/nav/tab.js"></script>
	</head>

	<body>
		<input type="hidden" id="sdId" value="${sdList.id}" />
		<div id="tab_menu"></div>
		<div id="page" style="width:100%;height:420px;"></div>
	</body>

</html>