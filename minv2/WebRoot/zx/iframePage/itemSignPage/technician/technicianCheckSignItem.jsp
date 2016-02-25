<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="/common/common.jsp" %>
		<html>

		<head>
			<title>（技术员）项目签认</title>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			<meta http-equiv="pragma" content="no-cache" />
			<meta http-equiv="cache-control" content="no-cache" />
			<meta http-equiv="expires" content="0" />
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
			<meta http-equiv="description" content="This is my page" />

			<!-- 引用以封装的复选框js							开始 -->
			<script type="text/javascript" src="${urlctx}js/checkboxUtil/checkboxUtil.js"></script>
			<!-- 引用以封装的复选框js								结束 -->
			
			<!-- 引用工人table表格js											开始 -->
			<script type="text/javascript" src="${urlctx}mainframe/js/table/treeTable.js"></script>
			<!-- 引用工人table表格js												结束 -->
			
			<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
			<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
			<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
			<!--引入弹出窗组件end-->	
			<script type="text/javascript" src="${urlctx}js/zx/itemSignPage/technician/technicianCheckSignItem_script.js"></script>
			
		</head>

		<body>
			<input type="hidden" value="${urlctx}" id="basePath" />
			<input type="hidden" value="${planDate.id}" id="planDateId" />
			<button id="signAll" style="position: fixed; left:5px; top: 5px;"><span class="icon_ok">卡控全签</span></button>
			<button id="newreport1" style="position: fixed; left:80px; top: 5px;"><span class="icon_print">报活</span></button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" value="0" name="sortType" ${(param.sortType == null ||  param.sortType == 0) ? 'checked' : ''}/><font color="red">按班组分类</font>
			&nbsp;&nbsp;
			<input type="radio" value="1" name="sortType" ${(param.sortType == null ||  param.sortType == 0) ? '' : 'checked'} /><font color="red">按专业分类</font>
			<br/>
			<span>自选签认项目<font color="red" size="3">(*自选项目不能全签)</font>
			</span><button id="sign" style="position: fixed; left:230px; top: 25px;"><span class="icon_ok">项目签认</span></button>
			<table class="treeTable" style="margin-top: 3px;">
				<tr>
					<th class="5%">选择</th>
					<th class="10%">部件/部位</th>
					<th class="15%">检修内容/项目名称</th>
					<th class="10%">检修情况</th>
					<th class="10%">检修人</th>
					<th class="10%">工长</th>
					<th class="10%">技术员</th>
					<th class="10%">质检员</th>
					<th class="10%">交车工长</th>
					<th class="10%">验收员</th>
				</tr>
				<c:forEach var="map" items="${zxFixItemRecMap}" varStatus="mStatus">
				<tr id="node-${mStatus.index }" class="parent collapsed">
				<td align="right"></td>
					<td  colspan="12">
						<span class="folder">
							<c:choose>
								<c:when test="${param.sortType == null ||  param.sortType == 0}">
									${map.key.proteamName}&nbsp;&nbsp;<font color="red">(${fn:length(map.value) }条项目签认为完成)</font>
								</c:when>
								<c:otherwise>
									${map.key.firstUnitName}&nbsp;&nbsp;<font color="red">(${fn:length(map.value) }条项目签认为完成)</font>
								</c:otherwise>
							</c:choose>
						</span>
					</td>
				</tr>
				<c:forEach var="jcZxFixItemRec" items="${map.value}" varStatus="nStatus">
				<tr id="node-${mStatus.index}-${nStatus.index}" class="child-of-node-${mStatus.index }">
					<td align="right"></td>
					<td>${jcZxFixItemRec.fixItem.itemUnit}/${jcZxFixItemRec.fixItem.itemPart}</td>
					<td>${jcZxFixItemRec.fixItem.itemName }</td>
					<td>${jcZxFixItemRec.fixCondition}</td>
					<td width="10%">
						${jcZxFixItemRec.fixUsers == null ? '<font color=red>未签完</font>' : jcZxFixItemRec.fixUsers}
					</td>
					<td width="10%">
						${jcZxFixItemRec.leadCheck == needCheck ? jcZxFixItemRec.leadUsers.userName : '<font color=red>/</font>' }
					</td>
					<td width="10%">
						${jcZxFixItemRec.technicianCheck == needCheck ? jcZxFixItemRec.technicianUsers.userName : '<font color=red>/</font>' }
					</td>
					<td width="10%">
						${jcZxFixItemRec.qcCheck == needCheck ? jcZxFixItemRec.qcUsers.userName : '<font color=red>/</font>' }
					</td>
					<td width="10%">
						${jcZxFixItemRec.commitLeadCheck == needCheck ? jcZxFixItemRec.commitLeadUsers.userName : '<font color=red>/</font>' }
					</td>
					<td width="10%">
					${jcZxFixItemRec.acceptanceCheck == needCheck ?  jcZxFixItemRec.acceptanceUsers.userName : '<font color=red>/</font>' }
					</td>
				</tr>
				</c:forEach>
				</c:forEach>
			</table>

		</body>

		</html>