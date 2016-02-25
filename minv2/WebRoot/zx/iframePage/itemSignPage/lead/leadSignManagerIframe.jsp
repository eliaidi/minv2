<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>（工长）卡控签认</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 截取单行文本行数                                                               开始  -->
		<link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css" />
		<!-- 截取单行文本行数                                                                           结束-->
		<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
		<!--引入弹出窗组件end-->
		<script type="text/javascript" src="${urlctx}js/zx/itemSignPage/lead/leadSignManagerIframe_script.js"></script>
		<!-- 引用以封装的复选框js						开始 -->
		<script type="text/javascript" src="${urlctx}js/checkboxUtil/checkboxUtil.js"></script>
		<!-- 引用以封装的复选框js							结束 -->
	</head>

	<body>
		<input type="hidden" value="${urlctx }" id="basePath" />
		<div class="box2" panelTitle="工长签认" roller="false">
			<button id="sign"><span class="icon_ok">项目签认</span></button>
			<button id="signAll" ><span class="icon_ok">卡控签认</span></button>
			<button id="newreport1"><span class="icon_print">报活</span></button>
		</div>
		<input type="hidden" value="${plandDate.id}" id="planDateId"/>
		<div>
			<table class="tableStyle" headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">选择</th>
					<th width="10%">部件/部位</th>
					<th width="15%">检修内容/项目名称</th>
					<th width="10%">检修/探伤情况</th>
					<th width="10%">检修人/探伤员</th>
					<th width="10%">工长</th>
					<th width="10%">质检员</th>
					<th width="10%">技术员</th>
					<th width="10%">交车工长</th>
					<th width="10%">验收员</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<c:forEach var="zxFixItemRec" items="${zxFixItemRecList }">
					<tr>
						<td width="5%">
						 <input type="checkbox" name="recId" value="${zxFixItemRec.id}"/>
						</td>
						<td width="10%">${zxFixItemRec.fixItem.itemUnit }/${zxFixItemRec.fixItem.itemPart }</td>
						<td width="15%">${zxFixItemRec.fixItem.itemName }</td>
						<td width="10%">${zxFixItemRec.fixCondition }</td>
						<td width="10%">
						${zxFixItemRec.fixUsers == null ? '<font color=red>未签完</font>' : zxFixItemRec.fixUsers}
						</td>
						<td width="10%">
						${zxFixItemRec.leadCheck == needCheck ? zxFixItemRec.leadUsers.userName : '<font color=red>/</font>' }
						</td>
						<td width="10%">
						${zxFixItemRec.qcCheck == needCheck ? zxFixItemRec.qcUsers.userName : '<font color=red>/</font>' }
						</td>
						<td width="10%">
						${zxFixItemRec.technicianCheck == needCheck ? zxFixItemRec.technicianUsers.userName : '<font color=red>/</font>' }
						</td>
						<td width="10%">
						${zxFixItemRec.commitLeadCheck == needCheck ? zxFixItemRec.commitLeadUsers.userName : '<font color=red>/</font>' }
						</td>
						<td width="10%">
						${zxFixItemRec.acceptanceCheck == needCheck ?  zxFixItemRec.acceptanceUsers.userName : '<font color=red>/</font>' }
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
    
</html>