<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/common.jsp" %>

<!--引入弹出窗组件end-->
<html>
	<head>
		<title>机务检修信息管理系统-配件管理主页</title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link rel="stylesheet" type="text/css" href="${urlctx}js/style.css" />
		<script type="text/javascript" src="${urlctx}js/script.js" charset="UTF-8"></script>
		
		
		<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
		
		<link href="${ctx}/js/maintenanceRecord/dhlStyle.css" rel="stylesheet" type="text/css" />
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
											<iframe scrolling="no" width="100%" height="500px" frameBorder="0" id="frmleft" name="frmleft" src="${urlctx}/pj/iframePage/navigationDrawerIframe.jsp" allowTransparency="true"></iframe>
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
						<td class="ali01 ver01" width="100%">
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
												<IFRAME scrolling="no" height="500px" width="100%" frameBorder="0" id="frmright" name="frmright" src="queryDictStorePosition.action" allowTransparency="true"></IFRAME>
											</div>
										</div>
										<!-- 中部 右侧区域 盒子 中部内容 右侧                                                           结束 -->
									</div>
									<!-- 中部 右侧区域 盒子 中部内容 左侧                                                           结束 -->
								</div>
								<!-- 中部 右侧区域 盒子 中部内容                                                                     结束-->

							</div>
							<!-- rbox 中部 右侧区域 盒子                                                                        结束 -->
						</td>
						<!-- 中部 右侧区域                                                                                    结束-->
					</tr>
				</table>
			</div>
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
		</div>
		<!--mainFrame 主DIV                                                  结束  -->
		<!-- 底部区域 界线----------------------------------------------------------------------------------------------------------------------------- -->

		<!--浏览器resize事件修正  开始-->
		<div id="resizeFix"></div>
		<!--浏览器resize事件修正  结束-->

		<!--载进度条  开始-->
		<div class="progressBg" id="progress" style="display:none;">
			<div class="progressBar"></div>
		</div>
		<!--载进度条  结束-->
		<script language="JavaScript" src="${ctx }/mainframe/js/menu/ocscript_h.js" type="text/javascript"></script>

	</body>

</html>