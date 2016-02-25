<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<%@page import="com.repair.constant.Constants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
	<head>
		<title>修程修次</title>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<meta http-equiv="pragma" content="no-cache" />
			<meta http-equiv="cache-control" content="no-cache" />
			<meta http-equiv="expires" content="0" />
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
			<meta http-equiv="description" content="This is my page" />
			
			<script type="text/javascript" src="${ctx}/gdt/generalJs/fixMileage_script.js"></script>
			<!-- 时间日历控件						开始 -->
			<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
			<!-- 时间日历控件						结束 -->
	</head>
	<body>
		<div class="box1" panelHeight="350" whiteBg="true" panelWidth="350">
			<c:forEach items="${fixMileageMap}" var="m" >
				<c:forEach items="${m.value}" var="fix" varStatus="status">
					<c:if test="${status.index != 0  && status.index % 6 == 0 }">
						<br/>
					</c:if>
					
					<c:choose>
						<c:when test="${m.key == otherFixType}">
							<input type="checkbox" id="${fix.id}" name="other" value="${fix.fixMileageValue }" />
						</c:when>
						<c:otherwise>
							<input type="radio" id="${fix.id}" name="ra" value="${fix.fixMileageValue }" />
						</c:otherwise>
					</c:choose>
					
					<label for="${fix.id}">${fix.fixMileageValue }</label>
				</c:forEach>	
				<hr/>
			</c:forEach>
			<input type="hidden" id="fixFreque"/>
			<input type="hidden" id="fixFrequeId"/>
			<input type="hidden" id="extraFixFreque" />
			<input type="hidden" id="extraFixFrequeId" />
		</div>
		
	</body>
</html>