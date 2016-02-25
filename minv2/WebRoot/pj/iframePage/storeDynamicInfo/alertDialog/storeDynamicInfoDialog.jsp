<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>${cache['SYS_TITLE'][0].value}-动态配件信息列表</title>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		
		<script type="text/javascript" src="${urlctx}js/pj/storeDynamicInfoDialog_script.js.jsp"></script>

		<!-- 引用以封装的复选框js						开始 -->
		<script type="text/javascript" src="${urlctx}js/checkboxUtil/checkboxUtil.js"></script>
		<!-- 引用以封装的复选框js							结束 -->
		<script type="text/javascript" src="${urlctx}js/pj/storeDynamicInfoDialog_script.js"></script>
		
		<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
		<!--引入弹出窗组件end-->
	</head>
	<body>
		<!-- 工具栏															开始 -->
		<div class="box_tool_mid padding_right5">
			<div class="center">
				<div class="left">
					<div class="right">
						<div class="padding_top8 padding_left10">
							<table>
								<tr>
									<td>
										<button id="updateStoreDynamicBtn"><span class="">批量移库</span></button>
										<button id="deleteStoreDynamicBtn"><span class="">批量删除</span></button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 工具栏															结束 -->
		
		
		<!-- 数据显示区														开始-->
		<div id="scrollContent">
			<table class="tableStyle" useMultColor="false" useCheckBox="false">
				<tr>
					<th width="25"><input type="checkbox" name="checkAll" id="checkAll"/>选择</th>
					<th width="100">配件编码</th>
					<th width="100">状态</th>
					<th width="100">仓库</th>
					<th width="100">入库日期</th>
					<th width="100">适用车型</th>
					<th width="200">操作</th>
				</tr>
				<c:forEach items="${psdiList}" var="psdi">
				<c:set var="tempPsdi" value="${psdi }" scope="request"></c:set>
				<tr>
					<td width="25">
						<input type="checkbox" name="ckStoreDynamicInfo" value="${psdi.id}"/>
					</td>
					<td width="100">${psdi.pjdCode }</td>
					<%-- 获取配件状态 --%>
					<%
						PjStoreDynamicInfo psdi=(PjStoreDynamicInfo)request.getAttribute("tempPsdi");
						long status=psdi.getPjdStatus();
						String statusText=Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS.get(status);
						request.setAttribute("pjdStatus", statusText);
					%>
					<td>
						${pjdStatus }
					</td>
					<td width="100">
						<span class="float_left">${psdi.dictStorePosition.storePositionName }</span>
					</td>
					<td width="100">
						<c:forEach items="${psdi.pjSDInfoRecords }" var="pjSDInfoRecord">
							<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 0 &&  pjSDInfoRecord.storeUnitProteamStatus == 2}">
								${pjSDInfoRecord.recordTime }
							</c:if>
						</c:forEach>
					</td>
					<td width="100">
						<select class="default">
							<c:forEach var="pjStaticJcTypePjFU" items="${psdi.pjStoreStaticInfo.pjStaticJcTypePjFUs }">
								<option value="${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictJcType.id }">
									${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictJcType.jcTypeValue }
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<input type="button" value="修改" id="updateDynamic" onclick="updateDynamicInfo(${psdi.id})" />
						<input type="button" value="移库" onclick='top.Dialog.open({URL:"${urlctx}toMoveStorePositionDialog.action?pjStoreDynamicInfoIds=${psdi.id}",Title:"配件移库",ShowCloseButton:true});' />
						<input type="button" value="删除" id="deleteDynamicInfo" onclick="deleteDynamicInfo(${psdi.id})" />
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<!-- 数据显示区														结束-->
	</body>
	
</html>