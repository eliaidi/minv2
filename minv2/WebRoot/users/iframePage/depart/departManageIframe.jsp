<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
  <head>
    <title>${cache['SYS_TITLE'][0].value}-部门管理</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	
	<!-- dynaTree树形菜单组件-加载数据js                 开始 -->
    <script src="${ctx}/js/users/departManageIframe_tree_script.js.jsp" type="text/javascript"></script>
    <!-- dynaTree树形菜单组件-加载数据js -->
    <!-- 此页面要用到的JS -->
    <script src="${ctx}/js/users/departManageIframe_script.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<!-- departManageIfraame_mainDiv 主div                                           开始 -->
    <div id="minv2_departManageIfraame_mainDiv" class="minv2_departManageIfraame_mainDiv_class">
    	 <!--左边菜单DIV                                                                     开始-->
            <div id="minv2_departManageIfraame_leftDiv" class="minv2_departManageIfraame_leftDiv_class">
            	<!-- 盒子模型上方                                                            开始 -->
				<div class="box2" panelWidth="250" panelHeight="500" panelTitle="部门目录" overflow="auto" >
					<!--部门(depart)目录进行编辑数据部分 				开始-->
					<div class="minv2_departManageIfraame_departDictBtnDiv_class">
							<button id="addDepart" onclick='top.Dialog.open({URL:"${ctx}/users/iframePage/depart/alertDialog/addDepartDialog.jsp",Title:"新增部门"});'/><span class="icon_add">新增</span></button>
							<button id="updateDepartBtn"><span class="icon_edit">修改</span></button>
							<button id="delDepartBtn"><span class="icon_delete">删除</span></button>
					</div>
				   <!--部门(depart)目录进行编辑数据部分 				结束-->
			  	    <!-- 部门(depart)目录数据的显示 DIV						开始-->	
					<div id="tree" class="minv2_departManageIfraame_tree_class ztree">
							
				    </div>
				    <!-- 部门(depart)目录数据的显示 DIV						结束-->
			    </div>
			    <!-- 盒子模型上方                                                            结束 -->			
            </div>
            <!--左边菜单DIV                                                                  结束-->
            
            <!--右边内容DIV                                                                  开始-->
            <div id="minv2_departManageIfraame_rightDiv" class="minv2_departManageIfraame_rightDiv_class">
            	<iframe id="minv2_departManageIfraame_contentIframe" name="minv2_departManageIfraame_contentIframe" class="minv2_departManageIfraame_rightIframe_class" scrolling="no" frameborder="no" src="queryDepartUsers.action?flag=root" width="99%" height="95%"></iframe>
            </div> 
            <!--右边内容DIV                                                                  结束-->
    </div>
    <!-- departManageIfraame_mainDiv 主div                                           结束 -->
  </body>
</html>


