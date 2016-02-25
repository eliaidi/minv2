<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		<title>${cache['SYS_TITLE'][0].value}-油样项目目录(左侧)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script type="text/javascript" src="${urlctx}js/oil/js/oilAssayItem_script.js"></script>
	</head>

	<body>
	<input type="hidden" value="${urlctx}" name="basePath"/>
		<div id="scrollContent">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="25%">
						<div class="box2" panelTitle="油样项目目录" roller="true" showStatus="false" overflow="auto" panelHeight="450">
							<table width="100%" class="tableStyle">
								<tr>
									<th class="ver01" width="3%">选择</th>
									<th class="ver01">油样项目</th>
								</tr>
								<c:forEach var="item" items="${oilAssayMainItemList}">
								<tr onclick="showSubItem(${item.id},${param.planDateId})">
									<td>
										<input type="radio" id="rdoId" name="rdoId" value="${item.id}" />
									</td>
									<td class="ver01">${item.mainItemName}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
					</td>
					<td>
						<div class="box2" panelHeight="450" panelTitle="油样化验项目" panelUrl="javascript:openWin()" showStatus="false" overflow="auto" roller="true">
							当前机车：${param.jcType }----${param.jcNumber }
							<IFRAME scrolling="auto" width="100%" height="390px" frameBorder=0 id=oilsubitem name=oilsubitem src="" allowTransparency="true"></IFRAME>
						</div>
		</td>
		</tr>
		</table>
		</div>
	</body>
	</html>

