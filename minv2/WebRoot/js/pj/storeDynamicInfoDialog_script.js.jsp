<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
$(function() {
	//弹出信息

	< c: if test = "${!empty message}" >
		top.Dialog.alert('${message }'); < /c:if>
	<c:remove var="message" scope="session"/ >

	)}
