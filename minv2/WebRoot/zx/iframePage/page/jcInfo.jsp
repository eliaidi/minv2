<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-机车信息（班组信息）</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link href="${ctx }/js/zx/css/jcInfo.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="${ctx }/js/zx/js/jcInfo_script.js"></script>

	</head>

	<body>
		<center>
			<table class="tableStyle" style="width:550px;" id="infotable">
				<tr>
					<th align="center">车型</th>
					<th align="center">车号</th>
					<th align="center">修程</th>
					<th align="center">扣车时间</th>
					<th align="center">计划起机时间</th>
					<th align="center">计划交车时间</th>
					<th align="center">检修状态</th>
				</tr>
				<tr>
					<td>${jcPlanDate.jcTypeValue }</td>
					<td>${jcPlanDate.jcNumber }</td>
					<td>${jcPlanDate.dictJcFixMileage.fixMileageValue }</td>
					<td>${fn:substring(jcPlanDate.jcDetainTime,0,16) }</td>
					<td>${fn:substring(jcPlanDate.jcPlanStarTime,0,16) }</td>
					<td>${fn:substring(jcPlanDate.jcPlanReceiveTime,0,16) }</td>
					<td>${planStatus[jcPlanDate.jcPlanStatus] }</td>
				</tr>
			</table>
			<table class="tableStyle" style="width:550px;" id="jcinfo">
				<tr>
					<td>
						<a href="${urlctx }zx/viewZxRecord.action?pageSize=100&planDateId=${jcPlanDate.id}" target="_blank">机车</a>
						<a href="${urlctx }zx/viewZxProteamRecord.action?planDateId=${jcPlanDate.id}" target="_blank">班组</a>
						<a href="${urlctx }zx/viewFirstUnitRecord.action?planDateId=${jcPlanDate.id}" target="_blank">专业</a>
						<a href="${urlctx }zx/viewJcFixHistory.action?planDateId=${jcPlanDate.id}" target="_blank">历史</a>
						<a href="" target="_blank">报活</a>
						<a href="" target="_blank">竣工</a>
						<a href="" target="_blank">交车</a>
						<a href="" target="_blank">化验单</a>
					</td>

				</tr>
				<tr>
					<td>
						<form action="${urlctx }zx/stationRacksTransfer.action" method="post" target="frmContent" name="stationTransfer">
							<input type="hidden" name="id" value="${jcPlanDate.id }" />
							<table width="100%">
								<tr>
									<td align="right">
											股道号：
											<input type="text" value="${jcPlanDate.stationRacksNumber }" style="width: 40px;" name="stationRacksNumber" onkeyup="this.value=this.value.replace(/\D/g,'')" />&nbsp;&nbsp; 台位号：
											<input type="text" value="${jcPlanDate.stationNmber }" name="stationNmber" style="width: 40px;" onkeyup="this.value=this.value.replace(/\D/g,'')" />
									</td>
									<td align="left"><a href="javascript:void(0);" onclick="stationRacksTransfer()">股道转移</a></td>
									
									<td align="right">
										机车号：
										<input type="text" value="${jcPlanDate.jcNumber }" style="width: 80px;" id="jcnum" />
									</td>
									<td align="left">
										<a href="javascript:void(0);" onclick="searchJC()">查询</a>
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
			<table id="bzFinishiInfo" class="tableStyle" style="width:550px;">
				<tr>
					<th align="center">检修班组</th>
					<th align="center">完成时间</th>
					<th align="center">检修情况</th>
					<th align="center">所处节点</th>
				</tr>
				<c:forEach var="fixFlowRecorder" items="${fixFlowRecorderList}">
				<tr>
					<td align="center">${fixFlowRecorder.dictProteam.proteamName}</td>
					<td align="center">${fixFlowRecorder.endTime}</td>
					<td align="center"><a href="#">
						<c:forEach items="${status}" var="status">
							<c:if test="${status.key== fixFlowRecorder.status}">
								${status.value}
							</c:if>
							
						</c:forEach>
					</a></td>
					<td align="center">${fixFlowRecorder.jcFixFlow.fixFlowName}</td>
				</tr>
				</c:forEach>
			</table>
		</center>
	</body>

</html>