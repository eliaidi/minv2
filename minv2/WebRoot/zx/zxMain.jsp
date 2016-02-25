<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>

		<title>${cache['SYS_TITLE'][0].value}-中修主页</title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDialog.js"></script>
		
		<script type="text/javascript">
			$(function(){
				top.Dialog.close();
			})
		</script>
	</head>

	<body>
		<!--mainFrame 主DIV                                                开始  -->
		<div id="mainFrame">
			<!-- 引入头部DIV内容                                                						开始    -->
			<jsp:include page="/common/top.jsp" flush="true" />

			<!-- 引入头部DIV内容         											结束 -->

			<!-- 头部与导航分界线----------------------------------------------------------------------------------------------------------------------------- -->

			<!-- 中部  表格                                                                                           开始 -->
			<div id="minv2_main_centerDiv" class="minv2_main_centerDiv_class">
				<!-- 扣车信息与股道图	开始 -->
				<iframe scrolling="no" src="${urlctx}zx/listUnOutJcPlanDate.do?type=JCGZ" width="100%" height="80%" id="frmContent" name="frmContent"></iframe>
				<!-- 扣车信息与股道图												结束 -->

			</div>
			<!--底部区域                                                                                          结束 -->

			<!-- 底部区域 界线----------------------------------------------------------------------------------------------------------------------------- -->

			<!--浏览器resize事件修正  开始-->
			<div id="resizeFix"></div>
			<!--浏览器resize事件修正  结束-->

		</div>
		<!--mainFrame 主DIV                                                  结束  -->
	</body>

</html>