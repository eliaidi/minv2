<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工长卡控----检修中配件--进入签到（检查项目）</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 自定义js -->
		<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/lead/leadSignManagerIframe_script.js"></script>
		
		<!-- 引用table签认页面js -->
		<script type="text/javascript" src="${ctx}/mainframe/js/nav/tab.js"></script>
	</head>

	<body>
		<input type="hidden" id="sdId" value="${param.id}"/>
		<div id="tab_menu"></div>
		<div id="page" style="width:100%;height:420px;"></div>

	</body>

</html>