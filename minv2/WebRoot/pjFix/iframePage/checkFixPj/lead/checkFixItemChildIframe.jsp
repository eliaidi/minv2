<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工长卡控----检修中配件--进入签到（检查项目）</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 截取单行文本行数                                                               开始  -->
		<link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css" />
		<!-- 截取单行文本行数                                                                           结束-->

	</head>

	<body>
		<div>
			<input type="hidden" value="${urlctx}" id="basePath" />
			<input type="hidden" value="${pjSDInfoRecord.id}" id="pjSDInfoRecordId" />
			<br>
			<button id="sign">项目签认</button>&nbsp;&nbsp;&nbsp;
			<button id="signAll">卡控签认</button>&nbsp;&nbsp;&nbsp; 配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 配件编号：
			<font color="blue">${psdi.pjdCode}</font> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 项目签认：-
			<font color="red">2</font>-条&nbsp;&nbsp;&nbsp; 未签认：-
			<font color="red">1</font>-条&nbsp;&nbsp;&nbsp;
		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">
						<input type="checkbox" id="checkAll" />序号</th>
					<th width="20%">检测项目</th>
					<th width="8%">检修情况</th>
					<th width="15%">检修员</th>
					<th width="10%">组装配件编码</th>
					<th width="15%">工长</th>
					<th width="10%">技术员/质检员</th>
					<th width="10%">交车工长</th>
					<th width="10%">验收员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="checkItem" items="${checkItemList}" varStatus="checkItemIndex">
					<tr>
						<td width="5%">
							<input type="checkbox" name="itemId" value="${checkItem.id }" />${checkItemIndex.index+1 }</td>
						<td width="20%">
							<span class="text_slice" style="width:130px" title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${checkItem.pjFixItem.fixItemName}">${checkItem.pjFixItem.fixItemName}</span>
						</td>
						<td width="8%">${checkItem.fixCondition}</td>
						<td width="15%"><font color="red">
					<span class="text_slice" style="width:130px"  title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${checkItem.fixUsersIds}">${checkItem.fixUsersIds}</span>
					</font></td>
						<td width="10%">${checkItem.pjSDInfoRecord.pjStoreDynamicInfo.pjdCode}</td>
						<td width="15%">
							<font color="red">
							<c:if test="${checkItem.pjSDIRecordFixCheck.leadCheck==0}">
								/
							</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.leadCheck==1}">
								${checkItem.pjSDIRecordFixCheck.leadUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.leadCheckTime}
							</c:if>
						</font>
						</td>
						<td width="10%">
							<font color="red">
							<c:if test="${checkItem.pjSDIRecordFixCheck.technicianCheck==0 || checkItem.pjSDIRecordFixCheck.qcCheck==0}">
								/
							</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.technicianCheck==1 || checkItem.pjSDIRecordFixCheck.qcCheck==1}">
								${checkItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.qcCheckTime}
								${checkItem.pjSDIRecordFixCheck.technicianUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.technicianCheckTime}
							</c:if>
						</font>
						</td>
						<td width="10%">
							<c:if test="${checkItem.pjSDIRecordFixCheck.commitLeadCheck==0}">
								/
							</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.commitLeadCheck==1}">
								${checkItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.commitLeadCheckTime}
							</c:if>
						</td>
						<td width="10%">
							<c:if test="${checkItem.pjSDIRecordFixCheck.acceptanceCheck==0}">
								/
							</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.acceptanceCheck==1}">
								${checkItem.pjSDIRecordFixCheck.acceptanceUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.acceptanceCheckTime}
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>
	<!-- 自定义js -->
	<script type="text/javascript" src="${urlctx }/js/checkboxUtil/checkboxUtil.js"></script>
	<script type="text/javascript" src="${urlctx}/js/pjFix/checkFixPj/lead/checkFixItemChildIframe_script.js"></script>

</html>