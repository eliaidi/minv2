<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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


<!--框架必需start-->
<script type="text/javascript" src="${urlctx}mainframe/js/jquery-1.4.js"></script>

<script type="text/javascript" src="${urlctx}mainframe/js/framework.js"></script>
<link href="${urlctx}mainframe/css/import_basic.css" rel="stylesheet" type="text/css"/>

<!-- 所有的css都从mainframe目录开始找 -->
<link  rel="stylesheet" type="text/css"  id="skin" prePath="${urlctx}mainframe/"/>
<!--框架必需end-->


<!-- 自定义样式和js文件 -->
<link rel="stylesheet" type="text/css" href="${urlctx}js/style.css" />
