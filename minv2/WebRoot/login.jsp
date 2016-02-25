<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>${cache['SYS_TITLE'][0].value}-登录</title>
		
		<!-- login登录页面组件   开始-->
		<link href="${urlctx}/mainframe/login/skin1/style.css" rel="stylesheet" type="text/css" id="skin"/>
		<script type="text/javascript" src="${urlctx}/mainframe/js/login.js"></script>
		<!-- login登录页面组件   结束-->
		
		<!-- uur居中显示组件-->
		<script type="text/javascript" src="${urlctx}/mainframe/js/method/center-plugin.js"></script>
		
		<!-- 自定义专门对应login.jsp页面的js文件-->
		<script type="text/javascript" src="${urlctx}/js/users/login_script.js"></script>
	
	</head>
	<body >
		<!--login_main 登录主DIV                                                        开始  -->
		<div class="login_main">
			<!--login_top 登录上部DIV                                                        开始  -->
			<div class="login_top">
				<!--login_title 登录标题DIV  -->
				<div class="login_title"></div>
			</div>
			<!--login_top 登录上部DIV                                                        结束  -->
			
			<!-- 上部分界线----------------------------------------------------------------------------------------------------------------------------- -->
			
			<!--login_middle 登录中部DIV                                                        开始  -->
			<div class="login_middle">
				<div class="login_middleleft"></div>
				<div class="login_middlecenter">
						<form name="loginForm" action="usersLogin.action" class="login_form" method="post" onsubmit="return checkLogin();">
							<div class="login_user"><input type="text" id="_username" name="jobNum"/></div>
							<div class="login_pass"><input type="password" id="_password" name="password"/></div>
							<div class="clear"></div>
							<div class="login_button">
								<div class="login_button_left"><input type="submit" value="" /></div>
								<div class="login_button_right"><input type="reset" value="" /></div>
								<div class="clear"></div>
							</div>
						</form>
						<div class="login_info">${loginError}</div>
				</div>
				<div class="login_middleright"></div>
				<div class="clear"></div>
			</div>
			<!--login_middle 登录中部DIV                                                        结束  -->
			
			<!-- 中部分界线----------------------------------------------------------------------------------------------------------------------------- -->
			
			<!--login_bottom 登录下部DIV                                                        开始  -->
			<div class="login_bottom">
				<div class="login_copyright">广州铁路(集团)公司 COPYRIGHT 2012</div>
			</div>
			<!--login_bottom 登录下部DIV                                                        结束  -->
		</div>
		<!--login_main 登录主DIV                                                        结束  -->
	</body>
</html>
