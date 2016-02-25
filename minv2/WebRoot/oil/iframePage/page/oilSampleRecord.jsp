<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-油样化验记录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script type="text/javascript" src="${urlctx}js/oil/js/oilSampleRecord_script.js"></script>
		
		<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
		<!--引入弹出窗组件end-->
		

	</head>

	<body>
		<input type="hidden" value="${urlctx}" id="basePath" />
		<div id="scrollContent">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<div class="box2" panelHeight="450" panelTitle="油样化验记录"  showStatus="false" overflow="auto" roller="true">
							<table>
								<tr>
									<td>
										<!-- <button id="add" onclick='top.Dialog.open({URL:"iframePage/alertDialog/addOilDialog.jsp",Title:"角色增加",ShowCloseButton:true});'><span class="icon_add">接活</span></button> -->
										<button id="add"><span class="icon_add">接活</span></button>
										<button id="update" style="margin-top: 3px;margin-left: 10px;margin-bottom: 3px"><span class="icon_edit">修改</span></button>
									</td>
								</tr>
							</table>
							<table width="100%" class="tableStyle">
								<tr align="center">
									<th class="ver01" width="2%">选择</th>
									<th class="ver01" width="5%">机车型号</th>
									<th class="ver01" width="5%">机车号</th>
									<th class="ver01" width="10%">取样日期</th>
									<th class="ver01" width="10%">化验日期</th>
									<th class="ver01" width="10%">来样人</th>
									<th class="ver01" width="10%">化验者</th>
									<th class="ver01" width="10%">质量评定</th>
									<th class="ver01" width="10%">处理意见</th>
									<th class="ver01" width="10%">状态</th>
									<th class="ver01" width="20%">操作</th>
								</tr>
								<c:forEach var="rec" items="${oilAssayMainItemRecList}">
								<tr>
									<td>
										<input type="radio" name="rec" value="${rec.id}" />
									</td>
									<td class="ver01" align="center">${rec.planDate.jcTypeValue}</td>
									<td class="ver01" align="center">${rec.planDate.jcNumber}</td>
									<td class="ver01" align="center">${rec.endTime}</td>
									<td class="ver01" align="center">${rec.receiveTime}</td>
									<td class="ver01" align="center">${rec.sendUsers}</td>
									<td class="ver01" align="center">${rec.receiveUsers.userName}</td>
									<td class="ver01" align="center">
										<c:if test="${rec.conditionStatus==1}">
											合格
										</c:if>
										<c:if test="${rec.conditionStatus==0}">
											不合格
										</c:if>
									</td>
									<td class="ver01" align="center">
										<c:if test="${rec.conditionStatus==0}">
											其他油，更换
										</c:if>
										<c:if test="${rec.conditionStatus==1}">
											变压器，滤油
										</c:if>
									
									</td>
									<td class="ver01" align="center">
										<c:if test="${rec.assayStatus==0}">
											作废
										</c:if>
										<c:if test="${rec.assayStatus==1}">
											待化验
										</c:if>
										<c:if test="${rec.assayStatus==2}">
											化验完成
										</c:if>
									</td>
									<td class="ver01" align="center">
										<a href="${urlctx}oil/listOilAMIByJcType.action?jcType=${rec.planDate.jcTypeValue}&planDateId=${rec.planDate.id}&jcNumber=${rec.planDate.jcNumber}" style="color:blue;">油样化验</a>
										<a href="${urlctx}oil/listOilAssayChildItemRecById.action?planDateId=${rec.planDate.id}" target="_blank" style="color:blue;">记录查询</a>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
		</div>
	</body>

</html>