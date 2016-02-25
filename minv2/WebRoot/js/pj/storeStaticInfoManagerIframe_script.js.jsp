<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.repair.constant.Constants"%>

<%--窗体加载时，关闭子窗体刷新父窗体 --%>
$(function(){		
 		<!-- 添加数据完成后，关闭子窗口，刷新父窗口 -->
		top.Dialog.close();
		<c:if test="${!empty message}">
			top.Dialog.alert("${message}");
		</c:if>
		<c:remove var="message" scope="session"/>
		
});		