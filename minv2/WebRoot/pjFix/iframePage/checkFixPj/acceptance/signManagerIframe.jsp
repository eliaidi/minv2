<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>进入签认(验收员)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 截取单行文本行数                                                               开始  -->
		<link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css" />
		<!-- 截取单行文本行数                                                                           结束-->
		
		<!-- 引用以封装的复选框js							开始 -->
		<script type="text/javascript" src="${urlctx}js/checkboxUtil/checkboxUtil.js"></script>
		<!-- 引用以封装的复选框js								结束 -->
	</head>

	<body>
		<div class="box2" panelTitle="检修项目列表(验收员)" roller="false">
			<button id="sign">签认</button>&nbsp;&nbsp;&nbsp; 配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 配件编号：
			<font color="blue">${psdi.pjdCode}</font>&nbsp;&nbsp;&nbsp;

		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">
						<input type="checkbox" id="checkAll" />序号
					</th>
					<th width="20%">检测项目</th>
					<th width="15%">检修员</th>
					<th width="10%">检修情况</th>
					<th width="10%">工长</th>
					<th width="10%">技术员/质检员</th>
					<th width="10%">交车工长</th>
					<th width="10%">验收员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="checkItem" items="${fixRecordSet}" varStatus="checkItemIndex">
					<tr>
						<td width="5%">
							<input type="checkbox" name="itemId" value="${checkItem.id }" />${checkItemIndex.index+1 }</td>
						<td width="20%">
							<span class="text_slice" style="width:130px" title="检测项目信息如下：</br>${checkItem.pjFixItem.fixItemName}">${checkItem.pjFixItem.fixItemName}</span>
						</td>
						<td width="15%">
							<span class="text_slice" style="width:130px" title="检修人信息如下：</br>${checkItem.fixUsersIds} ${checkItem.fixTime}">${checkItem.fixUsersIds} ${checkItem.fixTime}</span>
						</td>
						<td width="10%">${checkItem.fixCondition}</td>
						<td width="10%">
							<c:if test="${checkItem.pjSDIRecordFixCheck.leadCheck==0}">/</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.leadCheck==1}">
								${checkItem.pjSDIRecordFixCheck.leadUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.leadCheckTime}
							</c:if>
						</td>
						<td width="10%">
							<c:if test="${checkItem.pjSDIRecordFixCheck.technicianCheck==0 || checkItem.pjSDIRecordFixCheck.qcCheck==0}">/</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.technicianCheck==1 || checkItem.pjSDIRecordFixCheck.qcCheck==1}">
								${checkItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.qcCheckTime} ${checkItem.pjSDIRecordFixCheck.technicianUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.technicianCheckTime}
							</c:if>
						</td>
						<td width="10%">
							<c:if test="${checkItem.pjSDIRecordFixCheck.commitLeadCheck==0}">/</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.commitLeadCheck==1}">
								${checkItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.commitLeadCheckTime}
							</c:if>
						</td>
						<td width="10%">
							<c:if test="${checkItem.pjSDIRecordFixCheck.acceptanceCheck==0}">/</c:if>
							<c:if test="${checkItem.pjSDIRecordFixCheck.acceptanceCheck==1}">
								${checkItem.pjSDIRecordFixCheck.acceptanceUsers.userName}&nbsp;${checkItem.pjSDIRecordFixCheck.acceptanceCheckTime}
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>

	<script type="text/javascript" src="${urlctx }/js/pjFix/checkFixPj/acceptance/signManagerIframe.js"></script>

</html>