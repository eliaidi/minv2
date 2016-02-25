<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
	<title>（验收员）报活</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<!-- 引用table签认页面js 			开始-->
		<script type="text/javascript" src="${urlctx}mainframe/js/nav/tab.js"></script>
		<!-- 引用table签认页面js 			结束-->
		
		<!-- 自定义js							开始 -->
		<script type="text/javascript" src="${urlctx}js/zx/itemSignPage/acceptance/acceptanceWorkerRatify_script.js"></script>
		<!-- 自定义js							结束 -->
		<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
		<!--引入弹出窗组件end-->	
</head>
<body>
		<input type="hidden" value="${urlctx }" id="basePath" />
		<input type="hidden" id="planDateId" value="${param.planDateId}"/>
		<div id="tab_menu"></div>
		<div id="page" style="width:100%;height:420px;"></div>
</body>
</html>