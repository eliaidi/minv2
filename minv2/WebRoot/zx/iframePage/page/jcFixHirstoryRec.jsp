<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-机车检修历史记录(历史)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	</head>

	<body style="padding-top:20px">

		<table width="764" border="0" align="center" cellspacing="0" vspace="0">
			<tr>
				<td align="center" colspan="10">
					<h2>机车检修历史记录</h2>
				</td>
			</tr>
			<tr>
				<td align="left" colspan="10">
					机车型号:${pd.jcTypeValue } &nbsp;&nbsp;&nbsp; 机车编号:${pd.jcNumber }
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3" class="tbCELL3">
					<table width="1000px" border="0" align="center" cellspacing="0" vspace="0" id="datatabel">
						<tr style="background-color: #328aa4;font-weight: bolder;">
							<th class="tbCELL1" style="color:#ffffff;">修程修次</th>
							<th class="tbCELL1" style="color:#ffffff;">股道</th>
							<th class="tbCELL1" style="color:#ffffff;">台位</th>
							<th class="tbCELL1" style="color:#ffffff;">扣车时间</th>
							<th class="tbCELL1" style="color:#ffffff;">计划起机时间
								<br/>实际起机时间</th>
							<th class="tbCELL1" style="color:#ffffff;">计划交车时间
								<br/>实际交车时间</th>
							<th class="tbCELL1" style="color:#ffffff;">交车工长</th>
							<th class="tbCELL1" style="color:#ffffff;">检修节点</th>
							<th class="tbCELL1" style="color:#ffffff;">状态</th>
							<th class="tbCELL1" style="color:#ffffff;">查看</th>
						</tr>
						<c:forEach items="${historyList}" var="history">
							<tr>
								<td class="tbCELL1">${history.dictJcFixMileage.fixMileageValue }</td>
								<td class="tbCELL1">${history.stationRacksNumber }</td>
								<td class="tbCELL1">${history.stationNmber }</td>
								<td class="tbCELL1">${history.planMakeTime }</td>
								<td class="tbCELL1">${history.jcPlanStarTime }
									<br/>${history.actualStarTime }</td>
								<td class="tbCELL1">${history.jcPlanReceiveTime }
									<br/>${history.actualReceiveTime }</td>
								<td class="tbCELL1">${history.commitLeadUsers.userName }</td>
								<td class="tbCELL1">${history.jcFixFlow.fixFlowName }</td>
								<td class="tbCELL1">${planStatusMap[history.jcPlanStatus] }</td>
								<th class="tbCELL1">
									<a href="${urlctx}zx/viewZxRecord.action?pageSize=100&planDateId=${history.id}" target="_blank">检修记录</a>
									<a href="<%=basePath%>query!getAllInfoPre.do?rjhmId=${dp.rjhmId}" target="_blank">报活记录</a>
									<a href="<%=basePath%>query!searchJCjungong.do?rjhmId=${dp.rjhmId}" target="_blank">交车竣工单</a>
									<a href="<%=basePath %>query!viewExperiment.do?id=${dp.rjhmId}&jceiId=5" target="_blank">试验记录</a>
									<a href="<%=basePath %>oilAssay!searchOilAssayRecorderDaily.do?rjhmId=${dp.rjhmId }" target="_blank">油水化验记录</a>
								</th>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</body>

</html>