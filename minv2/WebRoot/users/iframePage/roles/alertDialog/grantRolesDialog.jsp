<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

  <head>
  	<title>${cache['SYS_TITLE'][0].value}-角色授权</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

    <!-- dynaTree树形菜单组件-加载数据js                               开始 -->
    <script src="${ctx}/js/users/grantRolesDialog_tree_script.js.jsp" type="text/javascript"></script>
    <!-- dynaTree树形菜单组件-加载数据js                               结束 -->
 </head>
	<body>
	    <!-- 盒子模型上方				开始 -->
		<div class="box1" style="width:540px; height:540px; overflow:auto; border:1px solid #000000;">
			<!-- 树形菜单数据显示                                    		开始 -->
			<div style="overFlow:scroll;width:510px;height: 300px">
			<div id="tree" class="ztree">
			  
			</div>
			</div>
			<!-- 树形菜单数据显示                                    		结束 -->
		    <button id="roleGrant" ><span class="icon_save">授权</span></button>&nbsp;&nbsp;
		    <button id="closeWindow"><span class="icon_mark">关闭</span></button>
		</div>
		<!-- 盒子模型上方				结束 -->
		
		<div style="display: inline">
			
		</div>
	</body>
	<!-- 导入树形菜单脚本文件 -->
    <!--<script src="${ctx}/js/wdTree/pageEnd_script.js" type="text/javascript"></script> -->
</html>