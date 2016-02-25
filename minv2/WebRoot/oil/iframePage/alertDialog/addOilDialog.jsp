<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-添加油水</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script type="text/javascript" src="${ctx}/js/oil/alertDialog/addOilDialog_script.js"></script>
		<!-- 时间日历控件						开始 -->
		<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
		<!-- 时间日历控件	结束 -->

	</head>

	<body>
		<input type="hidden" id="basePath" value="${urlctx }"/>
		<div class="box1" panelTitle="添加油水">
			<table class="tableStyle" transMode="true">
				<tr>
					<td>机车信息：</td>
					<td>
						<select class="default" style="width:140px" name="planDateId"  id="pdList">
							<option value="">请选择日计划</option>

						</select>
					</td>
				</tr>
				<tr>
					<td>取样日期：</td>
					<td>
						<input type="text" class="Wdate" onfocus="WdatePicker()" name="receiveTime" style="width:140px" id="receiveTime" />
					</td>
				</tr>
				<tr>
					<td>化验日期：</td>
					<td>
						<input type="text" class="Wdate" onfocus="WdatePicker()" name="endTime" id="endTime" style="width:140px" />
					</td>
				</tr>
				<tr>
					<td>来样人：</td>
					<td>
						<input type="text" style="width:140px" name="sendUsers" id="sendUsers" />
					</td>
				</tr>
				<tr>
					<td>化验者：</td>
					<td>
						<input type="text" style="width:140px"  id="receiptPeo" value="${loginUser.userName }" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" id="subBtn" value=" 提 交 " />
						<input type="reset" value=" 重 置 " />
					</td>
				</tr>
			</table>
		</div>
	</body>

</html>