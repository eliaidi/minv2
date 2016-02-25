<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDialog.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/floatPanel.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/messager.js"></script>

	</head>

	<body>
		<input type="hidden" id="basePath" value="${urlctx }"/>
		<div class="box2" panelTitle="检修计划" roller="false">
			<table>
				<tr>
					<td>开始日期：</td>
					<td>
						<input type="text" id="startTime" name="startTime" class="Wdate" onclick="WdatePicker(({minDate:'%y-%M-{%d}',dateFmt:'yyyy-MM-dd'}))" style="width:100px;" />
					</td>
					<td>截止日期：</td>
					<td>
						<input type="text" id="endTime" name="endTime" class="Wdate" onclick="WdatePicker(({minDate:'%y-%M-{%d}',dateFmt:'yyyy-MM-dd'}))" style="width:100px;" />
					</td>
					<td>计划标题：</td>
					<td>
						<input type="text" id="plan_title" />
					</td>
					<td>
						<input type="checkbox" checked="checked" id="isWeek" />过滤周末</td>
					<td>
						<button onclick="editInput();"><span class="icon_edit">开始编制</span></button>
					</td>
					<td>
						<button onclick="uploadExcel();"><span class="icon_xls">Excel导入</span></button>
					</td>
					<td><a href="<%=basePath%>page/plan/plan_template.xls" style="color: red;">excel模板下载</a></td>
				</tr>
			</table>
		</div>
		<div id="editTable" style="display: none;">
			<div>
				<table class="tableStyle" headFixMode="true" useMultColor="true">
					<tr>
						<td colspan="11">
							<button onclick="savePlan();"><span class="icon_save">保存计划</span></button>&nbsp;
						</td>
					</tr>
					<tr>
						<th width="9%">日期</th>
						<th width="9%">星期</th>
						<th width="5%">序号</th>
						<th width="9%">机型</th>
						<th width="9%">机号</th>
						<th width="9%">修程</th>
						<th width="9%">计划走行公里</th>
						<th width="9%">实际走行公里</th>
						<th width="9%">扣修地点</th>
						<th>备注</th>
						<th width="8%">操作</th>
					</tr>
				</table>
			</div>
			<div id="scrollContent">
				<table class="tableStyle" useMultColor="true" useCheckBox="true">
					<tr>
						<td width="80">2013-12-12</td>
						<td width="80">星期一</td>
						<td width="25">1</td>
						<td width="80">
							<input type="text" style="width: 60px" />
						</td>
						<td width="80">
							<input type="text" style="width: 60px" />
						</td>
						<td width="80">
							<input type="text" style="width: 60px" />
						</td>
						<td width="80">
							<input type="text" style="width: 60px" />
						</td>
						<td width="80">
							<input type="text" style="width: 60px" />
						</td>
						<td width="80">
							<input type="text" style="width: 60px" />
						</td>
						<td>
							<input type="text" />
						</td>
						<td width="80">
							<input type="button" value="增加" id="copyBtn" />
						</td>
					</tr>
				</table>
			</div>
			<div style="height:40px;"></div>
		</div>
		<link href="${urlctx }js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${urlctx }js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${urlctx }js/plan/planCompile/edit_main_plan.js"></script>
	</body>

</html>