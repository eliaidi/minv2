<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>（工人）我的报活</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<!-- 自定义工人js							开始 -->
		<script type="text/javascript" src="${urlctx}js/report/page/general/myReport_script.js"></script>
		<!-- 自定义工人js								结束 -->
		
	</head>

	<body>
		<input type="hidden" id="basePath" value="${urlctx }" />
		<input type="hidden" id="planDateId" value="${param.planDateId }" />
		<div class="box_tool_mid padding_top5 padding_right5" overflow="auto" panelHeight="410">
			<div class="center">
				<div class="left">
					<div class="right">
						<div class="padding_top8 padding_left10">
							<table>
								<tr>
									<td valign="top">机车计划：</td>
									<td valign="top" style="position: static;">
										<select class="default" style="width:140px" name="planDateId" id="pdList">
											<option value="">请选择</option>
										</select>
									</td>
									<td valign="top">
										<button id="reportselect"><span class="icon_find">查询</span></button>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<button id="newreport"><span class="icon_add">报活</span></button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div style="height: 3px;"></div>
		<table width="1361px" class="tableStyle">
			<tr align="center">
				<th class="ver01">类型</th>
				<th class="ver01">故障情况</th>
				<th class="ver01">报活人</th>
				<th class="ver01">报活时间</th>
				<th class="ver01">处理情况</th>
				<th class="ver01">操作</th>
			</tr>
			<c:forEach var="jtReport" items="${jtReportList }">
				<tr align="center">
					<td class="ver01">
						<c:forEach var="item" items="${reportType }">
							<c:if test="${jtReport.reportType==item.key}">
								${item.value}
							</c:if>
						</c:forEach>
					</td>
					<td class="ver01">${jtReport.reportCondition }</td>
					<td class="ver01">${jtReport.reportUsers.userName }</td>
					<td class="ver01">${jtReport.reportTime }</td>
					<td class="ver01">${jtReport.fixCondition }</td>
					<td class="ver01">
						<a href="javascript:;" onclick="reportDatils(${jtReport.id},${jtReport.planDate.id })">详细</a>&nbsp;&nbsp;
						<a href="javascript:;" onclick="updateReport(${jtReport.id},${jtReport.planDate.id  })">修改</a>&nbsp;&nbsp;
						<a href="javascript:;" onclick="jtPreDictDelete(${jtReport.id},${jtReport.planDate.id})">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</body>

</html>