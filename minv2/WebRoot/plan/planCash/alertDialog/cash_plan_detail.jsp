<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDialog.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/floatPanel.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/messager.js"></script>
		<!-- 打印插件 -->
		<script type="text/javascript" src="<%=basePath %>js/LodopFuncs.js"></script>
		<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
		<!-- 打印end -->

	</head>

	<body>
		<input type="hidden" value="${urlctx}" id="basePath"/>
		<table class="tableStyle" useMultColor="true" id="datatabel">
			<tr>
				<th colspan="10" align="center" class="text_align_center"><font style="font-weight:bold;font-size:15px;">${mainPlan.title }</font></th>
			</tr>
			<tr>
				<th colspan="10" align="center" class="text_align_center">制表日期:${mainPlan.makeTime }&nbsp;&nbsp;&nbsp;&nbsp;制表人:${mainPlan.maker }</th>
			</tr>
		</table>
		<div id="content">
			<table class="tableStyle" useMultColor="true" id="datatabel">
				<tr>
					<th width="8%"  class="text_align_center">日期</th>
					<th width="5%"  class="text_align_center">星期</th>
					<th width="5%"  class="text_align_center">序号</th>
					<th width="5%"  class="text_align_center">机型</th>
					<th width="5%"  class="text_align_center">机号</th>
					<th width="5%"  class="text_align_center">修程</th>
					<th width="8%"  class="text_align_center">公里</th>
					<th width="10%" class="text_align_center">扣修点</th>
					<th width="15%" class="text_align_center">备注</th>
					<th width="5%"  class="text_align_center">状态</th>
					<th>原因</th>
				</tr>
				<c:forEach var="detail" items="${mainPlan.planRecorderSet }">
					<tr>
						<td align="center" name="planTime" class="text_align_center">${detail.planDate }</td>
						<td align="center" name="planWeek" class="text_align_center">${detail.planWeek }</td>
						<td align="center" class="text_align_center">${detail.mainPlanNum }</td>
						<td align="center" class="text_align_center">${detail.jcType }</td>
						<td align="center" class="text_align_center">${detail.jcNumber }</td>
						<td align="center" class="text_align_center">${detail.dictJcFixMileage.fixMileageValue }</td>
						<td align="center" class="text_align_center">${detail.planKilometre }</td>
						<td align="center" class="text_align_center">${detail.dictArea }</td>
						<td align="center" class="text_align_center">${detail.remark }</td>
						<td align="center" class="text_align_center">
							<c:if test="${detail.cash==0}"><font color="red">未兑现</font></c:if>
							<c:if test="${detail.cash==1}">日兑现</c:if>
							<c:if test="${detail.cash==2}">周兑现</c:if>
						</td>
						<td align="center" class="text_align_center">
							<c:if test="${detail.cash==0}">
								<input type="text" style="width:200px;" onblur="getCashReason(this,${detail.id});" value="${detail.noCashReason }" />
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr></tr>
			</table>
		</div>
	</body>


	<script type="text/javascript" src="${urlctx }js/plan/planCash/alertDialog/cash_plan_detail.js"></script>
</html>