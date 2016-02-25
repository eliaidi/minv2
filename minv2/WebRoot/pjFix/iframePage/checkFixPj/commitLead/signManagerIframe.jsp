<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>进入签认</title>
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
		<div class="box2" panelTitle="交车工长-配件卡控" roller="false">
			<button id="sign">签认</button>&nbsp;&nbsp;&nbsp; 配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 配件编号：
			<font color="blue">${psdi.pjdCode}</font>&nbsp;&nbsp;&nbsp;

		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">
						<input type="checkbox" id="checkAll" />序号</th>
					<th width="20%">检测项目</th>
					<th width="15%">检修员</th>
					<th width="5%">检修情况</th>
					<th width="15%">工长</th>
					<th width="10%">技术员/质检员</th>
					<th width="10%">交车工长</th>
					<th width="10%">验收员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="fixRecord" items="${fixRecordSet}" varStatus="fixRecordIndex">
					<tr>
						<td width="5%">
							<input type="checkbox" name="itemId" value="${fixRecord.id }" />${fixRecordIndex.index+1 }</td>
						<td width="20%">
							<span class="text_slice" style="width:130px" title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${fixRecord.pjFixItem.fixItemName}">${fixRecord.pjFixItem.fixItemName}</span>
						</td>
						<td width="15%">
							<span class="text_slice" style="width:130px" title="检修人信息如下：</br>&nbsp;&nbsp;&nbsp;${fixRecord.fixUsersIds} ${checkItem.fixTime}">${fixRecord.fixUsersIds} ${checkItem.fixTime}</span>
						</td>
						<td width="5%">${fixRecord.fixCondition}</td>
						<td width="15%">
							<c:if test="${fixRecord.pjSDIRecordFixCheck.leadCheck==0}">
								/
							</c:if>
							<c:if test="${fixRecord.pjSDIRecordFixCheck.leadCheck==1}">
								${fixRecord.pjSDIRecordFixCheck.leadUsers.userName}&nbsp;${fixRecord.pjSDIRecordFixCheck.leadCheckTime}
							</c:if>
						</td>
						<td width="10%">
							<c:if test="${fixRecord.pjSDIRecordFixCheck.technicianCheck==0 || fixRecord.pjSDIRecordFixCheck.qcCheck==0}">
								/
							</c:if>
							<c:if test="${fixRecord.pjSDIRecordFixCheck.technicianCheck==1 || fixRecord.pjSDIRecordFixCheck.qcCheck==1}">
								${fixRecordpjSDIRecordFixCheck.qcUsers.userName}&nbsp;${fixRecord.pjSDIRecordFixCheck.qcCheckTime} ${fixRecord.pjSDIRecordFixCheck.technicianUsers.userName}&nbsp;${fixRecord.pjSDIRecordFixCheck.technicianCheckTime}
							</c:if>
						</td>
						<td width="10%">
							<font color="red">
							<c:if test="${fixRecord.pjSDIRecordFixCheck.commitLeadCheck==0}">
								/
							</c:if>
							<c:if test="${fixRecord.pjSDIRecordFixCheck.commitLeadCheck==1}">
								${fixRecord.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${fixRecord.pjSDIRecordFixCheck.commitLeadCheckTime}
							</c:if>
						</font>
						</td>
						<td width="10%">
							<c:if test="${fixRecord.pjSDIRecordFixCheck.acceptanceCheck==0}">
								/
							</c:if>
							<c:if test="${fixRecord.pjSDIRecordFixCheck.acceptanceCheck==1}">
								${fixRecord.pjSDIRecordFixCheck.acceptanceUsers.userName}&nbsp;${fixRecord.pjSDIRecordFixCheck.acceptanceCheckTime}
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>

	<script type="text/javascript" src="${urlctx }/js/checkboxUtil/checkboxUtil.js"></script>
	<script type="text/javascript" src="${urlctx }/js/pjFix/checkFixPj/commitLead/signManagerIframe.js"></script>

</html>