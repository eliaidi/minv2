<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>${cache['SYS_TITLE'][0].value}-首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--进入页面右下角上升出现消息提示对话框-->
	<script type="text/javascript" src="${ctx}/js/openMessager_script.js" charset="UTF-8"></script>
	
  </head>

  <body>
  	<!--mainFrame 主DIV                                                开始  -->
	<div id="mainFrame">
		<!--bs_bannercenter 上部DIV 头部与导航                                         开始  -->
		<div id="bs_bannercenter">
			<!--bs_bannerleft 上部左边DIV                                             开始  -->
			<div id="bs_bannerleft">
				<!--bs_bannerright 上部右边                                                            开始  -->
				<div id="bs_bannerright">
					<!--bs_banner_logo logo标志DIV  -->
					<div class="bs_banner_logo"></div>
					<!--bs_banner_title 标题DIV，系统基本菜单                                        开始  -->
					<div class="bs_banner_title"></div>
					<div class="hmenuFunc">
						<div class="hmenuFunction">
								<a href="#"><span class="icon_home hand" onclick="checkLogin();">帮助文档</span></a>
								<span class="icon_mark hand" onclick='top.Dialog.open({URL:"leftPages/skin_menu_h.html",Title:"帮助文档",Width:720,Height:490});'>修改密码</span>
								<span class="icon_no hand" onclick='top.Dialog.confirm("确定要退出系统吗",function(){window.location="http://localhost:8080/min/loginAction!loginOut.do"});'>退出系统</span>
								<div class="clear"></div>
						</div>
						<div class="hmenuUserInfo">
							<li class="top">
								<span class="top_link">
								欢迎-<span class="minv2_main_important_text">长沙机务段</span>-，
								用户-<span class="minv2_main_important_text">张飞</span>-登录，
								职务-
								<span class="minv2_main_important_text">工长</span>-</span>
							</li>
						</div>
					</div>	
					<!--bs_banner_title 标题DIV，系统基本菜单                                        结束  -->	
					<!--bs_nav 导航栏DIV                                                       开始  -->
					<!--<div class="bs_nav">  -->
						<ul id="nav">
							<li class="top"><a href="#" class="top_link"><span>机车检修 </span></a></li>
							<li class="top"><a href="#" class="top_link"><span>配件检修</span></a></li>
							<li class="top"><a href="#" class="top_link"><span>探伤检修</span></a></li>
							<li class="top"><a href="#" class="top_link"><span>技术管理</span></a></li>
							<li class="top"><a href="#" class="top_link"><span>车间管理</span></a></li>
							<li class="top"><a href="#" class="top_link"><span>标准管理</span></a></li>
							<li class="top"><a href="#" class="top_link"><span>计划管理</span></a></li>
						    <!--<c:if test="${parameterValue == 1}">-->
							<li class="top"><a href="#" class="top_link"><span>考勤管理</span></a></li>
							<!--</c:if>  -->
							<li class="top"><a class="top_link"><span class="down">检修记录</span></a>
								<ul class="sub">
									<li><a href="#" class="fly" target="frmright">机车检修记录</a>
										<ul>
											<li><a href="#" target="frmright">中&nbsp;&nbsp;修</a></li>
											<li><a href="#" target="frmright">小&nbsp;&nbsp;修</a></li>
											<li><a href="#" target="frmright">辅&nbsp;&nbsp;修</a></li>
											<li><a href="#" target="frmright">临&nbsp;&nbsp;修</a></li>
											<li><a href="#" target="frmright">加&nbsp;&nbsp;改</a></li>
											<li><a href="#" target="frmright">整&nbsp;&nbsp;治</a></li>
											<li><a href="#" target="frmright">春&nbsp;&nbsp;鉴</a></li>
											<li><a href="#" target="frmright">其&nbsp;&nbsp;他</a></li>
										</ul>
									</li>
									<li><a href="#" target="frmright">配件检修记录</a></li>
								</ul>
							</li>
						</ul>
					<!--</div>  -->
					<!--bs_nav 导航栏DIV                                                       结束  -->
				</div>
				<!--bs_bannerright 上部右边                                                             结束  -->
			</div>
			<!--bs_bannerleft 上部左边DIV                                              结束  -->
		</div>
		<!--bs_bannercenter 上部DIV 头部与导航                                            结束  -->
		
		<!-- 头部与导航分界线----------------------------------------------------------------------------------------------------------------------------- -->
		
		<!-- 中部  表格                                                                                           开始 -->
		<table width="100%" cellpadding="0" cellspacing="0" class="table_border0">
			<tr>
				<!-- 中部 左侧区域                                                                                   开始 -->
				<td id="hideCon" class="ver01 ali01">
				
					<!--1box 中部 左侧区域 盒子                                                                            开始-->
					<div id="lbox">
						 <!--lbox_topcenter 中部 左侧区域 盒子 上部内容                                                     开始  -->
						 <div id="lbox_topcenter">
						 	<!--lbox_topcenter 中部 左侧区域 盒子 上部内容 左侧                                                   开始  -->
						 	<div id="lbox_topright">
						 		<!--lbox_topcenter 中部 左侧区域 盒子 上部内容 右侧                                                    开始  -->
						 		<div id="lbox_topright">
						 			<div class="lbox_title">操作菜单</div>
						 		</div>
						 		<!--lbox_topcenter 中部 左侧区域 盒子 上部内容 右侧                                                    结束  -->
						 	</div>
						 	<!--lbox_topcenter 中部 左侧区域 盒子 上部内容 左侧                                                   结束  -->
						 </div>     
						 <!--lbox_topcenter 中部 左侧区域 盒子 上部内容                                                     结束  -->                                        
					</div>
					<!--1box 中部 左侧区域 盒子                                                                            结束 -->
					
					<!--lbox_middlecenter 中部 左侧区域 盒子 中间内容                                                   开始-->
					<div id="lbox_middlecenter">
						<!-- lbox_middleleft 中部 左侧区域 盒子 中间内容 左侧                                               开始-->
						<div id="lbox_middleleft">
							<!-- lbox_middleleft 中部 左侧区域 盒子 中间内容 右侧                                               开始-->
							<div id="lbox_middleright">
								<div id="bs_left">
									<!--<IFRAME scrolling="no" width="100%"  frameBorder=0 id=frmleft name=frmleft src="#"  allowTransparency="true"></IFRAME>-->
								</div>
								<!--更改左侧栏的宽度需要修改id="bs_left"的样式-->
							</div>
							<!-- lbox_middleleft 中部 左侧区域 盒子 中间内容 右侧                                               结束-->
						</div>
						<!-- lbox_middleleft 中部 左侧区域 盒子 中间内容 左侧                                               结束-->
					</div>
					<!--lbox_middlecenter 中部 左侧区域 盒子 中间内容                                                   结束-->
					
					<!--lbox_middlecenter 中部 左侧区域 盒子 下部内容                                                   开始-->
					<div id="lbox_bottomcenter">
						<!--lbox_middlecenter 中部 左侧区域 盒子 下部内容 左侧                                              开始-->
						<div id="lbox_bottomleft">
							<!--lbox_middlecenter 中部 左侧区域 盒子 下部内容 右侧                                              开始-->
							<div id="lbox_bottomright">
								<div class="lbox_foot"></div>
							</div>
							<!--lbox_middlecenter 中部 左侧区域 盒子 下部内容 右侧                                              结束-->
						</div>
						<!--lbox_middlecenter 中部 左侧区域 盒子 下部内容 左侧                                              结束-->
					</div>
					<!--lbox_middlecenter 中部 左侧区域 盒子 下部内容                                                   结束-->
					
				</td>
				<!-- 中部 左侧区域                                                                                    结束 -->
				
				<!-- 中部 左侧区域 界线----------------------------------------------------------------------------------------------------------------------------- -->
				
				<!-- main_shutiao 中部 中间栏区域                                                                 开始-->
				<td class="main_shutiao">
					<div class="bs_leftArr" id="bs_center" title="收缩面板"></div>
				</td>
				<!-- main_shutiao 中部 中间栏区域                                                                 结束-->
				
				<!-- 中部 中间栏区域 界线----------------------------------------------------------------------------------------------------------------------------- -->
				
				<!-- 中部 右侧区域                                                                                    开始-->
				<td class="ali01 ver01"  width="100%">
					<!-- rbox 中部 右侧区域 盒子                                                                        开始 -->
					<div id="rbox">
						<!-- 中部 右侧区域 盒子 上部内容                                                                     开始-->
						<div id="rbox_topcenter">
							<!-- 中部 右侧区域 盒子 上部内容 左侧                                                               开始-->
							<div id="rbox_topleft">
								<!-- 中部 右侧区域 盒子 上部内容 右侧                                                                开始-->
								<div id="rbox_topright">
									<div class="rbox_title">
										操作内容
									</div>
								</div>
								<!-- 中部 右侧区域 盒子 上部内容 右侧                                                                结束-->
							</div>
							<!-- 中部 右侧区域 盒子 上部内容 左侧                                                               结束-->
						</div>
						<!-- 中部 右侧区域 盒子 上部内容                                                                     结束-->
						<!-- 中部 右侧区域 盒子 中部内容                                                                     开始-->
						<div id="rbox_middlecenter"> 
							<!-- 中部 右侧区域 盒子 中部内容 左侧                                                           开始 -->
							<div id="rbox_middleleft">
								<!-- 中部 右侧区域 盒子 中部内容 右侧                                                           开始 -->
								<div id="rbox_middleright">
									<div id="bs_right">
									    <!-- <IFRAME scrolling="no" width="100%" frameBorder=0 id=frmright name=frmright src="#"  allowTransparency="true"></IFRAME>-->
									</div>
								</div>
								<!-- 中部 右侧区域 盒子 中部内容 右侧                                                           结束 -->
							</div>
							<!-- 中部 右侧区域 盒子 中部内容 左侧                                                           结束 -->
						</div>
						<!-- 中部 右侧区域 盒子 中部内容                                                                     结束-->				
						
					</div>
					<!-- rbox 中部 右侧区域 盒子                                                                        结束 -->
				<td>
				<!-- 中部 右侧区域                                                                                    结束-->
							
			</tr>
		</table>
		<!-- 中部  表格                                                                                           结束 -->
		
		<!-- 中部区域  界线----------------------------------------------------------------------------------------------------------------------------- -->
				
		<!--底部区域                                                                                          开始 -->
		<div id="fbox">
			<div id="bs_footcenter">
				<div id="bs_footleft">
					<div id="bs_footright" class="white">
						骁睿公司 COPYRIGHT 2015 @ www.xiaorui123.com
					</div>
				</div>
			</div>
		</div>
		<!--底部区域                                                                                          结束 -->
		
		<!-- 底部区域 界线----------------------------------------------------------------------------------------------------------------------------- -->
		
		<!--浏览器resize事件修正  开始-->
		<div id="resizeFix"></div>
		<!--浏览器resize事件修正  结束-->

		<!--载进度条  开始-->
		<div class="progressBg" id="progress" style="display:none;"><div class="progressBar"></div></div>
		<!--载进度条  结束-->
		
	</div>
	<!--mainFrame 主DIV                                                  结束  -->
  </body>
  
  <script language="JavaScript" src="../mainframe/js/menu/ocscript_h.js" type="text/javascript"></script>
</html>
