<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		<title>${cache['SYS_TITLE'][0].value}-修改油水</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
		
		<!-- 时间日历控件						开始 -->
		<script type="text/javascript" src="${urlctx}/js/oil/alertDialog/updateOilDialog_script.js"></script>
		<!-- 时间日历控件	结束 -->
	</head>

	</head>

	<body>
	<div class="box1" panelWidth="400" panelTitle="修改油水">
		<form action="${urlctx }oil/updateOilAMIRec.action" method="post" id="form" onsubmit="javascript:return vlidate();" target="frmright">
			<table class="tableStyle" transMode="true">
				<input type="hidden" name="id" value="${rec.id}" />
				<tr>
					<td>机车信息：</td>
					<td>
						${rec.planDate.jcTypeValue }-${rec.planDate.jcNumber }
					</td>
				</tr>
				<tr>
					<td>取样日期：</td>
					<td>
						<input type="text" class="Wdate" onfocus="WdatePicker()" name="receiveTime" style="width:140px" value="${rec.receiveTime }" />
					</td>
				</tr>
				<tr>
					<td>化验日期：</td>
					<td>
						<input type="text" class="Wdate" onfocus="WdatePicker()" name="endTime" style="width:140px" value="${rec.endTime }" />
					</td>
				</tr>
				<tr>
					<td>来样人：</td>
					<td>
						<input type="text" style="width:140px" name="sendUsers"  value="${rec.sendUsers }" />
					</td>
				</tr>
				<tr>
					<td>化验者：</td>
					<td>
						<input type="text" style="width:140px"value="${loginUser.userName }" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>质量评定：</td>
					<td>

						<select class="default" style="width:140px" name="qualityStatus" onchange="">
							<option value="1" ${rec.qualityStatus == 1 ? 'selected' : '' }>合格</option>
							<option value="0" ${rec.qualityStatus == 0 ? 'selected' : '' }>不合格</option>
						</select>
					</td>
				</tr>

				<tr id="advice">
					<td>处理意见：</td>
					<td>
						<select class="default" style="width:140px" name="conditionStatus">
							<option value="0" ${rec.conditionStatus == 0 ? 'selected' : '' }>更换</option>
							<option value="1" ${rec.conditionStatus == 1 ? 'selected' : '' }>滤油</option>
						</select>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="submit" value=" 提 交 " />
						<input type="reset" value=" 重 置 " />
					</td>
				</tr>
			</table>
		</form>
	</div>
	</body>

</html>