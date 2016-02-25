<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		 <link href="${ctx}/js/maintenanceRecord/dhlStyle.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<!--bs_bannercenter 上部DIV 头部与导航                                         开始  -->
		<div id="bs_bannercenter">
			<!--bs_bannerleft 上部左边DIV                                             开始  -->
			<div id="bs_bannerleft">
				<!--bs_bannerright 上部右边                                                            开始  -->
				<div id="bs_bannerright">
					<!--bs_banner_logo logo标志DIV                 开始 -->
					<div class="bs_banner_logo"></div>
					<!--bs_banner_logo logo标志DIV  					     结束-->
					<!--bs_banner_title 标题DIV，系统基本菜单                                           开始  -->
					<div class="bs_banner_title"></div>
					<!--bs_banner_title 标题DIV，系统基本菜单                                                    结束  -->
					<div class="hmenuFunc">
						<!-- 转jsp时，动态包含部分，此处动态包含页面在common/topPage.jsp             开始 -->
						<div class="hmenuFunction">
							<a href="#"><span class="icon_home hand">帮助文档</span>
							</a>
							<span class="icon_mark hand"
								onclick='top.Dialog.open({URL:"leftPages/skin_menu_h.html",Title:"帮助文档",Width:720,Height:490});'>修改密码</span>
							<span class="icon_no hand"
								onclick='top.Dialog.confirm("确定要退出系统吗",function(){window.location="login.html"});'>退出系统</span>
							<div class="clear"></div>
						</div>
						<div class="hmenuUserInfo">
							<li class="top">
								<span class="top_link"> 欢迎-<span
									class="minv2_main_important_text">长沙机务段</span>-， 用户-<span
									class="minv2_main_important_text">张飞</span>-， 职务- <span
									class="minv2_main_important_text">工长</span>-， 您现在位于：<span
									class="minv2_main_important_text">系统管理员主页</span> </span>
							</li>
						</div>
						<!-- 转jsp时，动态包含部分，此处动态包含页面在common/topPage.jsp             结束 -->
					</div>
					<!--bs_banner_title 标题DIV，系统基本菜单                                        结束  -->
					<!--bs_nav 导航栏DIV                                                       开始  -->
					<div id="minv2_main_navDiv" class="minv2_main_navDiv_class">
					 <!-- 导航中联动下拉菜单                            											开始 -->
						  <ul class="nav">
						    <li class="drop"></li>
						    <li class="drop" style="position:absolute;top:81px;right:450px"><a class="main down" href="#url"><b>检修记录</b></a>
						      <ul class="sub1">
						        <li class="fly"><a class="main" href="#url"><b>机车检修记录</b></a>
						          <ul>
						            <li><a href="#url"><b>中修</b></a></li>
						            <li><a href="#url"><b>小修</b></a></li>
						            <li><a href="#url"><b>辅修</b></a></li>
						            <li><a href="#url"><b>临修</b></a></li>
						            <li><a href="#url"><b>加改</b></a></li>
						            <li><a href="#url"><b>整治</b></a></li>
						            <li><a href="#url"><b>春鉴</b></a></li>
						            <li><a href="#url"><b>其他</b></a></li>
						            
						            <li class="fly"><a class="main" href="#url"><b>三级菜单1</b></a>
						              <ul>
						                <li><a href="#url"><b>三级子菜单1</b></a></li>
						                <li><a href="#url"><b>三级子菜单1</b></a></li>
						                <li><a href="#url"><b>三级子菜单1</b></a></li>
						                <li><a href="#url"><b>三级子菜单1</b></a></li>
						              </ul>
						            </li>
						            <li><a href="#url"><b>三级菜单2</b></a></li>
						          </ul>
						        </li>
						        <li><a href="#url"><b>配件检修记录</b></a></li>
						       </ul>
						      </li>
						     </ul>
						  <!-- 导航中联动下拉菜单                            											结束-->
					</div>
					<!--bs_nav 导航栏DIV                                                       结束  -->
				</div>
				<!--bs_bannerright 上部右边                                                             结束  -->
			</div>
			<!--bs_bannerleft 上部左边DIV                                              结束  -->
		</div>
		<!--bs_bannercenter 上部DIV 头部与导航                                            结束  -->










	</body>
</html>