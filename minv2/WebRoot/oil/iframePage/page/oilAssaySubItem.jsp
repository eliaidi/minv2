<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		<title>${cache['SYS_TITLE'][0].value}-油样化验项目(右侧)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		
		<script type="text/javascript" src="${urlctx}js/oil/js/oilAssaySubItem_script.js"></script>
	</head>

	<body>
		<input type="hidden" id="basePath" value="${urlctx }"/>
		<div id="showImage">
			<table width="100%" class="tableStyle">
				<tr>
					<th class="ver01" width="5%">选择</th>
					<th class="ver01" width="40%">项目</th>
					<th class="ver01" width="5%">填报值</th>
					<th class="ver01" width="10%">化验情况</th>
					<th class="ver01" width="25%">检验人</th>
				</tr>
				<c:forEach var="rec" items="${oilAssayChildItemRecList }">
				<tr onclick="show(${rec.id})">
					<td align="center">
						<input type="radio" id="rdoId" name="recId"/>
					</td>
					<td class="ver01" align="center">${rec.childItem.childItemName }</td>
					<td class="ver01" align="center">${rec.actualCheckData }</td>
					<td class="ver01" align="center" id="fillValue">
						<c:if test="${rec.assayStatus==0 }">不合格</c:if>
						<c:if test="${rec.assayStatus==1 }">合格</c:if>
					</td>
					<td class="ver01" align="center">${rec.assayUsers.userName }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>

</html>