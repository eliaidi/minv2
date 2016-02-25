<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

//子窗口动作执行成功之后，刷新父窗口，关闭子窗口
$(function(){

		top.Dialog.close();
		<c:if test="${!empty message}">
			top.Dialog.alert("${message}");
		</c:if>
		<c:remove var="message" scope="session"/>
	});

//得到用户从下拉列表选择的每页显示的行数，并刷新到转到首页
//控制上层下拉框数据选中条数
function selectPagesize(field) {
	var obj = document.getElementById("pageSize").value;
	document.location.href = "findRolePrivsAll.action?&psize=" + obj;
}
//控制下层下拉框数据选中条数
function selectPagesize1(field) {
	var obj = document.getElementById("pageSize1").value;
	document.location.href = "findRolePrivsAll.action?&psize=" + obj;
}