<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		if(session.getAttribute(Constants.LOGIN_USER) == null){
			response.sendRedirect("login.jsp");
			return;
		}
	 %>
</body>
</html>