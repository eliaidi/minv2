<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工人签认----待签配件--进入签认（探伤项目）</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 引用js文件				开始 -->
		<script type="text/javascript" src="${ctx}/js/checkFixPj/pjFixItem/fixUsers/checkFixItemChildIframe_script.js"></script>
		<!-- 引用js文件				结束 -->
		<script type="text/javascript" src="${ctx}/js/checkboxUtil/checkboxUtil.js"></script>

		<!-- 截取单行文本行数                                                               开始  -->
		<link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css" />
		<!-- 截取单行文本行数                                                                           结束-->
	</head>

	<body>
		<div>
			<br>
			<button onclick='top.Dialog.open({URL:"${urlctx}pjFix/iframePage/checkFixPj/fixUsers/alertDialog/mainAgentDialog.jsp",Title:"主探签名",Width:400,Height:200});'>主探签名</button>&nbsp;&nbsp;&nbsp;
			<button onclick='top.Dialog.confirm("复伤成功",function(){top.Dialog.alert("点击了确定")});'>复探签名</button>&nbsp;&nbsp;&nbsp; 配件名称：
			<font color="blue">${psdi.pjStoreStaticInfo.pjName }</font>&nbsp;&nbsp;&nbsp; 配件编号：
			<font color="blue">${psdi.pjdCode}</font>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 需要签认项目：-
			<font color="red">2</font>-条，还有：-<font color="red">1</font>-条项目未签认&nbsp;&nbsp;&nbsp;
		</div>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="8%">
						<input type="checkbox" id="selected">序号</th>
					<th width="17%">部位</th>
					<th width="15%">检测项目</th>
					<th width="20%">探伤结果</th>
					<th width="20%">主探</th>
					<th width="20%">副探</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="inspectionItem" items="${inspectionItemList}" varStatus="inspectionItemIndex">
					<tr>
						<td width="5%">
							<input type="checkbox" name="seq"></input>${inspectionItemIndex.index+1}</td>
						<td width="17%">${inspectionItem.pjFixItem.fixItemPart}</td>
						<td width="15%">
							<span class="text_slice" style="width:130px" title="检测项目信息如下：</br>&nbsp;&nbsp;&nbsp;${inspectionItem.pjFixItem.fixItemName}">${inspectionItem.pjFixItem.fixItemName}</span>
						</td>
						<td width="20%"><font color="greed">${inspectionItem.fixCondition}</font></td>
						<td width="20%"><font color="red">${inspectionItem.fixUsersIds}</font></td>
						<td width="20%">
							<font color="red">
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.twoInspectionCheck==0}">
								/
							</c:if>
							<c:if test="${inspectionItem.pjSDIRecordFixCheck.twoInspectionCheck==1}">
								${inspectionItem.pjSDIRecordFixCheck.twoInspectionUsers.userName}&nbsp;${inspectionItem.pjSDIRecordFixCheck.twoInspectionCheckTime}
							</c:if>
						</font>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div style="height:35px;">
			<div class="float_left padding5">
			</div>
			<div class="float_right padding5 paging">
				<div class="float_left padding_top4">
					<span class="paging_disabled"><a href="javascript:;">上一页</a></span>
					<span class="paging_current"><a href="javascript:;">1</a></span>
					<span><a href="javascript:;">2</a></span>
					<span><a href="javascript:;">3</a></span>
					<span><a href="javascript:;">4</a></span>
					<span><a href="javascript:;">5</a></span>
					<span>...</span>
					<span><a href="javascript:;">20</a></span>
					<span><a href="javascript:;">下一页</a></span> 每页
				</div>
				<div class="float_left">
					<select autoWidth="true">
						<option>50</option>
						<option>100</option>
						<option>150</option>
					</select>
				</div>
				<div class="float_left padding_top4">条记录</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</body>

</html>