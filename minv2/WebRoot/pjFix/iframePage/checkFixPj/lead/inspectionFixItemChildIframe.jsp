<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工长卡控----检修中配件--进入签到（探伤项目）</title>
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
			<br>
			<button>项目签认</button>&nbsp;&nbsp;&nbsp;
			<button>卡控全签</button>&nbsp;&nbsp;&nbsp; 配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 配件编号：
			<font color="blue">${psdi.pjdCode}</font>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 项目签认：-
			<font color="red">2</font>-条&nbsp;&nbsp;&nbsp; 未签认：-
			<font color="red">1</font>-条&nbsp;&nbsp;&nbsp;
		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">序号</th>
					<th width="5%">部位</th>
					<th width="15%">检测项目</th>
					<th width="10%">主探</th>
					<th width="5%">副探</th>
					<th width="15%">工长</th>
					<th width="15%">技术/质检员</th>
					<th width="15%">交车工长</th>
					<th width="15%">验收员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="inspectionItem" items="${inspectionItemList}" varStatus="inspectionItemIndex">
					<tr>
						<td width="5%">${inspectionItemIndex.index+1}</td>
						<td width="5%">${inspectionItem.pjFixItem.fixItemPart}</td>
						<td width="15%">
							<span class="text_slice" style="width:130px" title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${inspectionItem.pjFixItem.fixItemName}">${inspectionItem.pjFixItem.fixItemName}</span>
						</td>
						<td width="10%">
							<font color="red">
							${inspectionItem.fixUsersIds}
						</font>
						</td>
						<td width="5%">
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.twoInspectionCheck==0}">
								/
							</c:if>
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.twoInspectionCheck==1}">
								${inspectionItem.pjSDIRecordFixCheck.twoInspectionUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.twoInspectionCheckTime}
							</c:if>
						</td>
						<td width="15%">
							<font color="red">
						<c:if test="${inspectionItem.pjSDIRecordFixCheck.leadCheck==0}">
							/
						</c:if>
						<c:if test="${inspectionItem.pjSDIRecordFixCheck.leadCheck==1}">
							${inspectionItem.pjSDIRecordFixCheck.leadUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.leadCheckTime}
						</c:if>
						</font>
						</td>
						<td width="15%">
							<font color="red">
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.technicianCheck==0 || inspectionItem.pjSDIRecordFixCheck.qcCheck==0}">
							/
							</c:if>
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.technicianCheck==1 || inspectionItem.pjSDIRecordFixCheck.qcCheck==1}">
								${inspectionItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.qcCheckTime}
								${inspectionItem.pjSDIRecordFixCheck.technicianUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.technicianCheckTime}
							</c:if>
						</font>
						</td>
						<td width="15%">
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.commitLeadCheck==0}">
								/
							</c:if>
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.commitLeadCheck==1}">
								${inspectionItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.commitLeadCheckTime}
							</c:if>
						</td>
						<td width="15%">
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.acceptanceCheck==0}">
								/
							</c:if>
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.acceptanceCheck==1}">
								${inspectionItem.pjSDIRecordFixCheck.acceptanceUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.acceptanceCheckTime}
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		
	</body>

</html>