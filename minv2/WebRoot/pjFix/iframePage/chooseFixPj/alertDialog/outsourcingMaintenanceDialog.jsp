<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>配件检修--委外检修</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

	<body>

		<div class="" panelWidth="500" panelTitle="表单标题" showStatus="false" roller="true">
			<form name="myForm" id="myForm" method="post">
				<table class="tableStyle" transMode="true">
					<tr>
						<td>配件名称：</td>
						<td>
							<input type="hidden" value="${param.id }" id="pjSDInfoId" name="pjSDInfoId"/>
							<input type="hidden" value="${param.pjName }" id="pjName" name="pjName"/>
							${param.pjName }
						</td>
					</tr>
					<tr>
						<td>配件编号：</td>
						<td>
							<input type="hidden" value="${param.pjdCode }" id="pjdCode" name="pjdCode"/>
							${param.pjdCode }
						</td>
					</tr>
					<tr>
						<td>委修厂家：</td>
						<td>
							<input type="text" name="correlationUnit" id="correlationUnit" class="validate[required,length[1,20]]"/>
						</td>
	
					</tr>
					<tr>
						<td>备注：</td>
						<td>
							<span class="float_left" name="remark" id="remark">
						<textarea> </textarea>
					</span>
							<span class="img_light" style="height:80px;" title="限制在200字以内"></span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button id="fixOutSubmit"><span>提交</span></button>
							<input type="reset" value="重 置 " />
						</td>
					</tr>
				</table>
			</form>
		</div>

	</body>
<!-- 自定义js -->
<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/outsourcingMaintenanceDialog_script.js"></script>
</html>