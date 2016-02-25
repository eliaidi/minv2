had<%@ page contentType="text/html; charset=UTF-8"%>
<!--引用公共插件文件，每个jsp文件都引用该文件 --> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!-- 得到根路径 -->
<c:set value="<%=request.getContextPath()%>" var="ctx"></c:set>
<!-- 得到全路径 uur框架图标不显示，需要用到全路径，才能显示图片-->
<c:set value="<%=basePath%>" var="urlctx"></c:set>



<!--<link href="skins/sky/import_skin.css" rel="stylesheet" type="text/css" id="skin" themeColor="blue"/>  -->

<!--框架必需start-->
<script type="text/javascript" src="${urlctx}mainframe/js/jquery-1.4.js"></script>
<script type="text/javascript" src="${urlctx}mainframe/js/framework.js"></script>
<link href="${urlctx}mainframe/css/import_basic.css" rel="stylesheet" type="text/css"/>

<!-- uurframe页面框架                                                                                        开始-->
<!-- 所有的css都从mainframe目录开始找 -->
<link  rel="stylesheet" type="text/css"  id="skin" prePath="${urlctx}mainframe/"/>

<!--左侧  导航栏     			
<script type="text/javascript" src="${urlctx}mainframe/js/bsFormat.js"></script>
			结束-->

<!--框架必需end-->

<!-- uurframe表单验证码框架							开始 -->
<script src="${urlctx}mainframe/js/form/validationEngine-cn.js" type="text/javascript"></script>
<script src="${urlctx}mainframe/js/form/validationEngine.js" type="text/javascript"></script>
<!-- uurframe表单验证码框架							结束-->

<script type="text/javascript" src="${urlctx}mainframe/js/attention/floatPanel.js"></script>
<script type="text/javascript" src="${urlctx}mainframe/js/attention/messager.js"></script>
<%--
<!--修正IE6支持透明png图片start-->
<script type="text/javascript" src="${ctx}/mainframe/js/method/pngFix/supersleight.js"></script>
 --%>
 
 <%--
 <!--  滚动条                                                                                        开始-->
<script type="text/javascript" src="../js/mainframe/scroll/jquery.mousewheel.js"></script>
<script type="text/javascript" src="../js/mainframe/scroll/jScrollPane.js"></script>
  <!-- 滚动条                                                                                        结束-->
 --%>
 
<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
<!--引入弹出窗组件end-->

<!-- uurframe页面框架                                                                                        结束-->
<!-- dynatree树形菜单 				开始-->



 <!--多功能表格start-->
<link rel="stylesheet" type="text/css" href="${urlctx }mainframe/js/table/flexigrid/css/flexigrid/flexigrid.css">
<script type="text/javascript" src="${urlctx }mainframe/js/table/flexigrid/flexigrid.js"></script>
<!--多功能表格end-->


<!-- ztree树形菜单                                                   开始-->
<link rel="stylesheet" href="${urlctx}js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${urlctx}js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${urlctx}js/ztree/jquery.ztree.excheck-3.5.js"></script>
 <!-- ztree树形菜单                                                 结束-->
 
 <!-- 多选下拉框 -->
 <script type="text/javascript" src="${urlctx}mainframe/js/form/multiselect.js"></script>
 
<!-- 多级树形表格 --> 
<script type="text/javascript" src="${urlctx}mainframe/js/table/treeTable.js"></script>
 
<!-- 自定义样式和js文件 -->
<link rel="stylesheet" type="text/css" href="${urlctx}js/style.css" />
<script type="text/javascript" src="${urlctx}js/script.js" charset="UTF-8"></script>



