<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工人签认----待签配件--进入签认（检测项目）</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 自定义js -->
		<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/fixUsers/fixUserJianceFixItemChildIframe_script.js"></script>
		<!-- 自定义js -->
		<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/fixUsers/jianceFixItemChildIframe_script.js"></script>

		<!-- 截取单行文本行数                                                               开始  -->
		<link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css" />
		<!-- 截取单行文本行数                                                                           结束-->
	</head>

	<body>
		<div>
			<br>
			<input type="hidden" value="${psdi.id }" id="psdiId" name="psdiId" /> 配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 配件编号：
			<font color="blue">${psdi.pjdCode}</font>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 已签认项目：-
			<font color="red">2</font>-条&nbsp;&nbsp;&nbsp; 未签认项目：-
			<font color="red">1</font>-条&nbsp;&nbsp;&nbsp;
			<button name="fixItemStatusAll" id="fixItemStatusAll"><span>一键启用</span></button>
			<button name="fixItemStatusCloseAll" id="fixItemStatusCloseAll"><span>一键禁用</span></button>
		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">序号</th>
					<th width="15%">部位</th>
					<th width="15%">检测项目</th>
					<th width="15%">检修情况</th>
					<th width="15%">单位</th>
					<th width="15%">是否启用</th>
					<th width="30%">检修员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true" id="table1">
				<c:forEach var="jianceItem" items="${jianceItemList}" varStatus="jianceItemIndex">
					<tr>

						<td width="5%">
							<input type="hidden" value="${jianceItem.id }" name="jianceItemId" id="jianceItemId" />${jianceItemIndex.index+1}</td>
						<td width="15%">${jianceItem.pjFixItem.fixItemPart}</td>
						<td width="15%">
							<span class="text_slice" style="width:130px" title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${jianceItem.pjFixItem.fixItemName}">${jianceItem.pjFixItem.fixItemName}</span>
						</td>
						<td width="15%">
							<input type="text" onchange="fixConditionChange(this)" id="fixConditionId" name="fixConditionId" value="${jianceItem.fixCondition}" style="width:100px" />
						</td>
						<td width="15%">${jianceItem.pjFixItem.unitMeasure}</td>
						<td width="15%">
							<input type="checkbox" name="fixItemStatus" id="fixItemStatus" ${jianceItem.fixItemStatus==1 ? 'checked': ''}/><font color="blue">启用</font>
						</td>
						<td width="30%">${jianceItem.fixUsersIds} ${jianceItem.fixTime}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div style="height:35px;">
		</div>
	</body>

</html>