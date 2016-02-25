<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>${cache['SYS_TITLE'][0].value}--配件管理-配件动态信息管理-专业分类</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
		
  </head>
  
  <body>
  	<!-- unitManageIfraame_mainDiv 主div                                           开始 -->
    <div id="minv2_unitManageIframe_mainDiv" class="minv2_unitManageIframe_mainDiv_class">
    	 <!--左边菜单DIV                                                                     开始-->
            <div id="minv2_unitManageIframe_leftDiv" class="minv2_unitManageIframe_leftDiv_class">
            	<!-- 盒子模型上方                                                            开始 -->
				<div class="box2" panelWidth="230" style="float:left" panelHeight="558" panelTitle="专业管理" overflow="auto" >
				
			  	    <!-- 专业(unit)目录数据的显示 DIV						开始-->
					<div id="scrollContent">
						<div id="tree" class="ztree">
							
						</div>
				    </div>
				    <!-- 专业(unit)目录数据的显示 DIV						结束-->
			    </div>
			    <!-- 盒子模型上方                                                            结束 -->			
            </div>
            <!--左边菜单DIV                                                                  结束-->
            
            <!--右边内容DIV                                                                  开始-->
            <div id="minv2_unitManageIframe_rightDiv" class="minv2_unitManageIframe_rightDiv_class">
            	<iframe id="minv2_unitManageIframe_contentIframe" name="minv2_unitManageIframe_rightIframe" 
            	class="minv2_unitManageIframe_rightIframe_class" scrolling="no" frameborder="no"
            	 src="${urlctx}queryPjStoreStaticInfo.action?flag=<%=Constants.QUERY_PJ_SD_INFO_PARAM_UNIT %>" width="850px" height="550px"></iframe>
            </div> 
            <!--右边内容DIV                                                                  结束-->
    </div>
    <!-- unitManageIfraame_mainDiv 主div                                           结束 -->
  </body>
  
  <!-- 显示树形菜单		开始 -->
  <script type="text/javascript" src="${urlctx}js/pj/unitManageIframe_tree.js.jsp"></script>
  <!-- 显示树形菜单		结束 -->
</html>


