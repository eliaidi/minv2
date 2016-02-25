<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>报活详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

	<body>
		<div class="box1" whiteBg="true">
			<table width="100%" class="tableStyle">
				<tr align="center">
					<td rowspan="4" colspan="6" width="65%">
						<c:forEach items="${jtReport.reportImgUrlSet }" var="img">
							<a href="${urlctx }upload/reportImages/${img.imgUrl}" title="点击查看原图" target="_blank"><img src="${urlctx }upload/reportImages/${img.imgUrl}" alt="报活图"  width="100"/></a>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td align="center">机车类型</td>
					<td align="center" colspan="4">${jtReport.planDate.jcTypeValue }</td>
				</tr>
				<tr>
					<td align="center">机车编号</td>
					<td align="center" colspan="4">${jtReport.planDate.jcNumber }</td>
				</tr>
				<tr>
					<td align="center">修程修次</td>
					<td align="center" colspan="4">${jtReport.planDate.dictJcFixMileage.fixMileageValue }</td>
				</tr>
				<tr>
					<td align="center">报活类型</td>
					<td align="center">
						${reportType[jtReport.reportType] }
					</td>
					<td align="center">对应项目</td>
					<td align="center"></td>
					<td align="center">项目卡控</td>
					<td align="center" colspan="3">
						技术员<input type="checkbox" disabled="disabled" ${jtReport.technicianCheck eq needCheck? 'checked':'' }/> 
						质检员<input type="checkbox" disabled="disabled" ${jtReport.qcCheck eq needCheck ? 'checked':'' }/> 
						交车工长<input type="checkbox" disabled="disabled" ${jtReport.commitLeadCheck eq needCheck ? 'checked':'' }/> 
						验收员<input type="checkbox" disabled="disabled" ${jtReport.acceptanceCheck eq needCheck ? 'checked':'' }/>
					</td>
				</tr>
				<tr>
					<td align="center">故障部位</td>
					<td align="center">${jtReport.reportPart }</td>
					<td align="center">报活情况</td>
					<td align="center">${jtReport.reportCondition }</td>
					<td align="center">报活人</td>
					<td align="center">${jtReport.reportUsers.userName}</td>
					<td align="center">报活时间
					</td>
					<td align="center">${jtReport.reportTime}</td>
				</tr>
				<tr>
					<td align="center">审批人</td>
					<td align="center"></td>
					<td align="center">审批时间</td>
					<td colspan="5" align="center"></td>
				</tr>
				<tr>
					<td align="center">报修班组</td>
					<td align="center" colspan="3">${jtReport.reportUsers.dictDepart.departName}</td>
					<td align="center">接收人</td>
					<td align="center" colspan="3"></td>
				</tr>
				<tr>
					<td align="center">检修人</td>
					<td align="center">${jtReport.fixUsers}</td>
					<td align="center">处理情况</td>
					<td align="center">${jtReport.fixCondition}</td>
					<td align="center">检修人签字时间</td>
					<td align="center" colspan="3">${jtReport.fixEndTime}</td>
				</tr>
				<tr>
					<td align="center">工长</td>
					<td align="center">${jtReport.leadUsers.userName}</td>
					<td align="center">签字时间</td>
					<td align="center" colspan="5">${jtReport.leadUsersCheckTime}</td>
				</tr>
				<tr>
					<td align="center">技术员</td>
					<td align="center">${jtReport.technicianUsers.userName}</td>
					<td align="center">签字时间</td>
					<td align="center" colspan="5">${jtReport.technicianCheckTime}</td>
				</tr>
				<tr>
					<td align="center">质检员</td>
					<td align="center">${jtReport.qcUsers.userName}</td>
					<td align="center">签字时间</td>
					<td align="center" colspan="5">${jtReport.qcCheckTime}</td>
				</tr>
				<tr>
					<td align="center">交车工长</td>
					<td align="center">${jtReport.commitLeadUsers.userName}</td>
					<td align="center">签字时间</td>
					<td align="center" colspan="5">${jtReport.commitLeadCheckTime}</td>
				</tr>
				<tr>
					<td align="center">验收员</td>
					<td align="center">${jtReport.acceptanceUsers.userName }</td>
					<td align="center">签字时间</td>
					<td align="center" colspan="5">${jtReport.acceptanceCheckTime }</td>
				</tr>
				<tr>
					<td align="center">状态</td>
					<td align="center" colspan="7">${recordStatusMap[jtReport.recordStatus] }</td>
				</tr>
			</table>
		</div>
	</body>

</html>