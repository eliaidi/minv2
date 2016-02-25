<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>


<html">

	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		
		<script type="text/javascript" src="${urlctx }mainframe/js/attention/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx }mainframe/js/attention/zDialog/zDialog.js"></script>
		<script type="text/javascript" src="${urlctx }mainframe/js/attention/floatPanel.js"></script>
		<script type="text/javascript" src="${urlctx }mainframe/js/attention/messager.js"></script>

	</head>

	<body>
		<input type="hidden" value="${urlctx }" id="basePath" />
		<div class="box2" panelTitle="检修计划" roller="false">
			<form action="${urlctx }plan/queryCashJcMainPlan.action" method="post">
				<table>
					<tr>
						<td>开始日期：</td>
						<td>
							<input type="text" id="startTime" name="startTime" class="Wdate" onclick="WdatePicker(({dateFmt:'yyyy-MM-dd'}))" value="<fmt:formatDate value="${startTime }"  pattern="yyyy-MM-dd"  />" />
						</td>
						<td>截止日期：</td>
						<td>
							<input type="text" id="endTime" name="endTime" class="Wdate" onclick="WdatePicker(({dateFmt:'yyyy-MM-dd'}))" value="<fmt:formatDate value="${endTime }"  pattern="yyyy-MM-dd" />" />
						</td>
						<td>
							<input type="submit" value="查询" class="icon_edit" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="scrollContent" class="box1">
			<table class="tableStyle" useMultColor="true">
				<tr>
					<th width="5%" class="text_align_center">序号</th>
					<th width="10%" class="text_align_center">计划开始日期</th>
					<th width="10%" class="text_align_center">计划结束日期</th>
					<th width="15%" class="text_align_center">计划标题</th>
					<th width="10%" class="text_align_center">编制人</th>
					<th width="10%" class="text_align_center">编制时间</th>
					<th width="10%" class="text_align_center">状态</th>
					<th width="10%" class="text_align_center">操作</th>
				</tr>
				<c:forEach var="mainPlan" items="${spm.data}">
					<tr>
						<td width="5%" class="text_align_center">${mainPlan.id }</td>
						<td width="10%" class="text_align_center"><fmt:formatDate value="${mainPlan.startTime }" pattern="yyyy-MM-dd"/></td>
						<td width="10%" class="text_align_center"><fmt:formatDate value="${mainPlan.endTime }" pattern="yyyy-MM-dd"/></td>
						<td width="15%" class="text_align_center">${mainPlan.title }</td>
						<td width="10%" class="text_align_center">${mainPlan.maker }</td>
						<td width="10%" class="text_align_center"><fmt:formatDate value="${mainPlan.makeTime }" pattern="yyyy-MM-d"/></td>
						<td width="10%" class="text_align_center">
							<c:if test="${mainPlan.status==0}"><font color="red">未发布</font></c:if>
							<c:if test="${mainPlan.status==1}">已发布</c:if>
						</td>
						<td width="10%" class="text_align_center">
							<a href="javascript:void(0);" onclick="findCashDetail(${mainPlan.id});" style="color:blue;">兑现详情</a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${empty spm.data}">
					<tr>
						<td class="text_align_center" colspan="8">没有相应的数据记录!</td>
					</tr>
				</c:if>
			</table>
			<!-- 处理分页 -->
			<div class="float_left padding5">共有信息${spm.totalCount}条,每页显示${spm.pageSize}条</div>
			${spm.pageString }
			
			<!-- 处理分页end -->
			<div style="height:40px;"></div>
		</div>
		<link href="${ctx }/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx }/js/plan/planCash/cash_main_plan.js"></script>
	</body>

</html>