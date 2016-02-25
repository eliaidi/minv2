<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>（技术员）报活签认</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<!-- 引用以封装的复选框js							开始 -->
		<script type="text/javascript" src="${urlctx}js/checkboxUtil/checkboxUtil.js"></script>
		<!-- 引用以封装的复选框js								结束 -->
		<!-- 引用工人js											开始 -->
		<script type="text/javascript" src="${urlctx}js/report/page/technician/technicianReportSign_script.js"></script>
		<!-- 引用工人js												结束 -->
		<!-- 引用工人table表格js											开始 -->
		<script type="text/javascript" src="${urlctx}mainframe/js/table/treeTable.js"></script>
		<!-- 引用工人table表格js												结束 -->
	</head>

	<body>
		<input type="hidden" value="${urlctx}" id="basePath"/>
		<button id="sign" style="position: fixed; left:5px; top: 5px;"><span class="icon_ok">签认</span></button>
		<button id="print1" style="position: fixed; left:75px; top: 5px;" onclick="javascript:screenPrint();"><span class="icon_print">打印</span></button>
		<button id="newreport1" style="position:fixed; left:145px; top: 5px;"><span class="icon_print">报活</span></button>
		<input type="hidden" value="${param.planDateId}" id="planDateId"/>
		<table  class="treeTable" style="margin-top: 30px;">
			<%-- 
			<tr style="background-color: lightblue;">
				<td colspan="11" align="left" style="font-weight: bolder;">我的报活项目
					<button anchor="nbz" id="bz">自选报活项目</button>
				</td>
			</tr>
			--%>
			<tr align="center">
				<th class="ver01">选择</th>
				<th class="ver01">具体报活部位</th>
				<th class="ver01">故障情况</th>
				<th class="ver01">报活人</th>
				<th class="ver01">报活时间</th>
				<th class="ver01">类型</th>
				<th class="ver01">处理情况</th>
				<th class="ver01">检修人签字</th>
				<th class="ver01">工长</th>
				<th class="ver01">技术员</th>
				<th class="ver01">质检员</th>
				<th class="ver01">交车工长</th>
				<th class="ver01">验收员</th>
			</tr>
			<c:forEach var="map" items="${jtReportMap}" varStatus="mStatus">
				<tr id="node-${mStatus.index }" class="parent collapsed">
					<td colspan="13"><input type="checkbox" id="parent${mStatus.index}" /><span class="folder">${map.key.proteamName}</span></td>
				</tr>
				<c:forEach var="jtReport" items="${map.value }" varStatus="nStatus">
					<tr id="node-${mStatus.index}-${nStatus.index}" class="child-of-node-${mStatus.index }">
						<td class="ver01">
							<c:if test="${jtReport.recordStatus <= technicianCheckFlag && jtReport.qcCheck ==needCheck && jtReport.technicianUsers == null }">
								<input type="checkbox" name="recId${mStatus.index}" value="${jtReport.id }" />
							</c:if>
						</td>
						<td class="ver01">
							${jtReport.reportPart }
						</td>
						<td class="ver01">
							<a href="javascript:void(0);" onclick="reportDatils(${jtReport.id})">${jtReport.reportCondition }</a>
						</td>
						<td class="ver01">${jtReport.reportUsers.userName }</td>
						<td class="ver01">${jtReport.reportTime }</td>
						<td class="ver01">
							${reportType[jtReport.reportType] }
						</td>

						<td class="ver01">${jtReport.fixCondition }</td>
						<td class="ver01">
							${jtReport.fixUsers == null ? '<font color=red>未签完</font>' : jtReport.fixUsers}
						</td>
						<td class="ver01">
							${jtReport.leadCheck == needCheck ? jtReport.leadUsers.userName : '<font color=red>/</font>' }
						</td>
						<td class="ver01">
							${jtReport.technicianCheck == needCheck ? jtReport.technicianUsers.userName : '<font color=red>/</font>' }
						</td>
						<td class="ver01">
							${jtReport.qcCheck == needCheck ? jtReport.qcUsers.userName : '<font color=red>/</font>' }
						</td>
						<td class="ver01">
							${jtReport.commitLeadCheck == needCheck ? jtReport.commitLeadUsers.userName : '<font color=red>/</font>' }
						</td>
						<td class="ver01">
							${jtReport.acceptanceCheck == needCheck ? jtReport.acceptanceUsers.userName : '<font color=red>/</font>' }
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>

	</body>

</html>