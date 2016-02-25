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
        <link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css"/>
        <!-- 截取单行文本行数                                                                           结束-->
	</head>

	<body>
		<div>
			<input type="hidden" value="${pjSDInfoRecord.id}" id="pjSDInfoRecordId"/>
		<br>
			<button id="signAll">卡控签认</button>&nbsp;&nbsp;&nbsp; 
			配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 
			配件编号：
			<font color="blue">${psdi.pjdCode}</font>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 已签认项目：-
			<font color="red">2</font>-条&nbsp;&nbsp;&nbsp; 未签认项目：-
			<font color="red">1</font>-条&nbsp;&nbsp;&nbsp;
		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">序号</th>
					<th width="5%">部位</th>
					<th width="15%">检测项目</th>
					<th width="5%">检修情况</th>
					<th width="5%">单位</th>
					<th width="5%">是否启用</th>
					<th width="12%">工长</th>
					<th width="12%">检修员</th>
					<th width="12%">交车工长</th>
					<th width="12%">技术/质检员</th>
					<th width="12%">验收员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="jianceItem" items="${jianceItemList}" varStatus="jianceItemIndex">
				<tr>
					<td width="5%">
						${jianceItemIndex.index+1}
					</td>
					<td width="5%">${jianceItem.pjFixItem.fixItemPart}</td>
					<td width="15%">
					<span class="text_slice" style="width:130px"  title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${jianceItem.pjFixItem.fixItemName}">${jianceItem.pjFixItem.fixItemName}</span>
					</td>
					<td width="5%">
						<input type="text" value="${jianceItem.pjFixItem.defaultValue}" style="width:60px" />
					</td>
					<td width="5%">${jianceItem.pjFixItem.unitMeasure}</td>
					<td width="5%">
					  		<input type="checkbox" name="fixItemStatus" id="fixItemStatus" ${jianceItem.fixItemStatus==1 ? 'checked':''}/><font color="blue">启用</font>
					</td>
					<td width="12%">
						<font color="red">
							<c:if test="${jianceItem.pjSDIRecordFixCheck.leadCheck==0}">
								/
							</c:if>
							<c:if test="${jianceItem.pjSDIRecordFixCheck.leadCheck==1}">
								${jianceItem.pjSDIRecordFixCheck.leadUsers.userName}&nbsp;${jianceItem.pjSDIRecordFixCheck.leadCheckTime}
							</c:if>	
						</font>
					</td>
					<td width="12%">
						${jianceItem.fixUsersIds} ${jianceItem.fixTime}
					</td>
					<td width="12%">
						<font color="red">
							<c:if test="${jianceItem.pjSDIRecordFixCheck.commitLeadCheck==0}">
								/
							</c:if>
							<c:if test="${jianceItem.pjSDIRecordFixCheck.commitLeadCheck==1}">
								${jianceItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${jianceItem.pjSDIRecordFixCheck.commitLeadCheckTime}
							</c:if>
						</font>
					</td>
					<td width="12%">
						<font color="red">
							<c:if test="${jianceItem.pjSDIRecordFixCheck.technicianCheck==0 || jianceItem.pjSDIRecordFixCheck.qcCheck==0}">
								/
							</c:if>
							<c:if test="${jianceItem.pjSDIRecordFixCheck.technicianCheck==1 || jianceItem.pjSDIRecordFixCheck.qcCheck==1}">
								${jianceItem.pjSDIRecordFixCheck.qcUsers.userName}&nbsp;${jianceItem.pjSDIRecordFixCheck.qcCheckTime}
								${jianceItem.pjSDIRecordFixCheck.technicianUsers.userName}&nbsp;${jianceItem.pjSDIRecordFixCheck.technicianCheckTime}
							</c:if>
						</font>
					</td>
					<td width="12%">
						<c:if test="${jianceItem.pjSDIRecordFixCheck.acceptanceCheck==0}">
							/
						</c:if>
						<c:if test="${jianceItem.pjSDIRecordFixCheck.acceptanceCheck==1}">
							${jianceItem.pjSDIRecordFixCheck.acceptanceUsers.userName}&nbsp;${jianceItem.pjSDIRecordFixCheck.acceptanceCheckTime}
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>

		<div style="height:35px;">
		</div>
	</body>
	<!-- 自定义js -->
	<script type="text/javascript" src="${urlctx}/js/pjFix/checkFixPj/lead/jianceFixItemChildIframe.js"></script>
</html>