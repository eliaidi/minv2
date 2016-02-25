<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
  <head>
    <title>左侧菜单页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
    
   
    <!-- 弹出窗口的JS	开始 -->
    <script type="text/javascript" src="${urlctx }js/zDialog_split/zDialog.js"></script>
    <script type="text/javascript" src="${urlctx }js/zDialog_split/zDrag.js"></script>
    <!-- 弹出窗口的JS  结束 -->
	<!-- 自定义样式 				开始 -->
    <link rel="stylesheet" href="${urlctx }js/style.css"/>
    <!-- 自定义样式 				开始 -->
    
   
  </head>
  
  <body>
  	<!-- minv2_firstUnitManageIframe_mainDiv 主div                                           开始 -->
    <div id="minv2_firstUnitManageIframe_mainDiv" class="minv2_firstUnitManageIframe_mainDiv_class">
    	 <!--左边菜单DIV                                                                     开始-->
            <div id="minv2_firstUnitManageIframe_leftDiv" class="minv2_firstUnitManageIframe_leftDiv_class">
            	<!-- 盒子模型上方                                                            开始 -->
				<div class="box1"  panelHeight="516"  panelWidth="270">
			  	    <!-- 大部件(专业)(unit)目录数据的显示 DIV						开始-->
					<div id="scrollContent">
						<table class="tableStyle">
							<tr>
								<td>
									<input type="text" />
								</td>
								<td>
									<button><span class="icon_find">定位车号</span></button>
								</td>
							</tr>
						</table>
					</div>
					<div id="scrollContent" class="border_gray" style="width:200px">
						<table class="tableStyle" style="width:230px">
							<tr align="center">
								<th width="5%">车型</th>
								<th width="5%">车号</th>
							</tr>
							<tr align="center">
								<td>DF4</td>
								<td><a href="#"><font color="blue">11111</font></a></td>
							</tr>
							<tr align="center">
								<td>DF12</td>
								<td><a href="#"><font color="blue">22222</font></a></td>
							</tr>
						</table>									
					</div>
				    </div>
				    <!-- 大部件(专业)(unit)目录数据的显示 DIV						结束-->
			    </div>
			    <!-- 盒子模型上方                                                            结束 -->			
            <!--左边菜单DIV                                                                  结束-->
            
            <!--右边内容DIV                                                                  开始-->
            <div id="minv2_firstUnitManageIframe_rightDiv" class="minv2_firstUnitManageIframe_rightDiv_class" style="position:relative;left:40px;">
            	<iframe id="minv2_firstUnitManageIframe_contentIframe" name="minv2_firstUnitManageIframe_rightIframe" class="minv2_firstUnitManageIframe_rightIframe_class" scrolling="no" frameborder="no" src="${urlctx }pj/iframePage/pjAssembly/pjAssemblyManageIframe.jsp" width="100%" height="100%"></iframe>
            </div> 
            <!--右边内容DIV                                                                  结束-->
    </div>
    <!-- firstUnitManageIframe_mainDiv 主div                                           结束 -->
  </body>
</html>


