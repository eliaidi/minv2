<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<base href="<%=basePath%>" />
		<script src="${urlctx}mainframe/js/form/validationEngine-cn.js" type="text/javascript"></script>
		<script src="${urlctx}mainframe/js/form/validationEngine.js" type="text/javascript"></script>

	</head>

	<body>
		<form action="${urlctx}plan/excelImportJCMainPlan.action" method="post" onsubmit="return subForm();" enctype="multipart/form-data" target="frmright">
			<input type="hidden" name="startTime" value="${param.startTime }" />
			<input type="hidden" name="endTime" value="${param.endTime }" />
			<input type="hidden" name="title" value="${param.planTitle }" />
			<table class="tableStyle" useHover="false" useClick="false">
				<tr>
					<td align="center">
						<span style="font-weight:bold;font-size:12px;">请选择要导入的Excel文件:</span>
						<a href="<%=basePath%>plan/plan_template.xls" style="color: red;">excel模板下载</a>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="file" name="excelFile" id="excel" style="width:250px;" />
					</td>
				</tr>
			</table>
			<div align="center">
				<input type="submit" value=" 提 交 " />&nbsp;&nbsp;
				<input type="button" value=" 取 消 " onclick="exit();" />
			</div>
		</form>
	</body>

</html>