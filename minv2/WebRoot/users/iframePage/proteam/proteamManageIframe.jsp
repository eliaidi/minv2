<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

  <head>
    <title>${cache['SYS_TITLE'][0].value}-班组管理</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
 
	<!-- dynaTree树形菜单组件-加载数据js                               开始 -->
    <script src="${ctx}/js/users/proteamManageIframe_tree_script.js.jsp" type="text/javascript"></script>
    <!-- dynaTree树形菜单组件-加载数据js                               结束 -->

  </head>
  
  <body>
  	<!-- proteamManageIfraame_mainDiv 主div                                           开始 -->
    <div id="minv2_proteamManageIfraame_mainDiv" class="minv2_proteamManageIfraame_mainDiv_class">
    	 <!--左边菜单DIV                                                                     开始-->
            <div id="minv2_proteamManageIfraame_leftDiv" class="minv2_proteamManageIfraame_leftDiv_class">
            	<!-- 盒子模型上方                                                            开始 -->
				<div class="box2" panelWidth="250" panelHeight="500" panelTitle="班组目录" overflow="auto">
					<!--班组(proteam)目录进行编辑数据部分 				开始-->
					<div class="minv2_proteamManageIfraame_proteamDictBtnDiv_class">
							<button onclick='top.Dialog.open({URL:"${ctx}/users/iframePage/proteam/alertDialog/addProteamDialog.jsp",Title:"新增班组"});'/><span class="icon_add">新增</span></button>
							<button id="updateProteamBtn"><span class="icon_edit">修改</span></button>
							<button id="delProteamBtn"><span class="icon_delete" >删除</span></button>
					</div>
				   <!--班组(proteam)目录进行编辑数据部分 				结束-->
			  	    <!-- 班组(proteam)目录数据的显示 DIV						开始-->
					<div id="tree" class="minv2_proteamManageIfraame_tree_class ztree">
						
					
				    </div>
				    <!-- 班组(proteam)目录数据的显示 DIV						结束-->
			    </div>
			    <!-- 盒子模型上方                                                            结束 -->			
            </div>
            <!--左边菜单DIV                                                                  结束-->
            
           <%--通过判断得到用户管理子页面的路径 --%>
            
            <c:if test="${ param.returnUrl == null  }">
            	<c:set var="usersManagerChildUrl" value="queryProteamUsers.action?flag=bz_root&userPrivs.departProteamStatus=<%=Constants.PROTEAM_STATU %>"></c:set>
            </c:if>
            
            <c:if test="${ param.returnUrl != null }">
            	<c:set var="usersManagerChildUrl" value="${param.returnUrl }"></c:set>
            </c:if>
            
         
            <!--右边内容DIV                                                                  开始-->
            <div id="minv2_proteamManageIfraame_rightDiv" class="minv2_proteamManageIfraame_rightDiv_class">
            	<iframe id="minv2_proteamManageIfraame_contentIframe" name="minv2_proteamManageIfraame_contentIframe" class="minv2_proteamManageIfraame_contentIframe_class" scrolling="no" frameborder="no" 
            	src="${usersManagerChildUrl}" width="99%" height="95%"></iframe>
            </div> 
            <!--右边内容DIV                                                                  结束-->
    </div>
    <!-- proteamManageIfraame_mainDiv 主div                                           结束 -->
  </body>
  
  <!-- 此页面要用到的JS -->
  <script src="${ctx}/js/users/proteamManageIframe_script.js" type="text/javascript"></script>
</html>
