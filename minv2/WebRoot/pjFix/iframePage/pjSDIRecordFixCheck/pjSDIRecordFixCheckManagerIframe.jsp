<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>机务检修系统--配件检修-查询配件检修记录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<!-- 引用配件大类js文件				开始 -->
		<script type="text/javascript" src="${urlctx}/js/pjFix/pjSDIRecordFixCheck_script.js"></script>
		<!-- 引用配件大类js文件				结束 -->

	</head>

	<body>
		<!-- 动态配件管理 功能操作和数据显示区域    start ************ -->
		<div class="box2" panelTitle="查询配件检修记录" panelHeight="540">
			<table width="100%" height="500px">
				<!-- *********	操作功能区  start  ********** -->
				<tr>
					<td width="100%">
						<input type="checkbox" id="jcType" />
						<label for="jcType">机车型号</label>
						<input type="checkbox" id="pjNameId" />
						<label for="pjNameId">配件名称</label>
						<input type="checkbox" id="pjAssemblyType" />
						<label for="pjAssemblyType">配件状态</label>
						<input type="checkbox" id="jcId" />
						<label for="jcId">机车编号</label>
						<input type="checkbox" id="pjId" />
						<label for="pjId">配件编号</label>
						<input type="checkbox" id="storageLocation" />
						<label for="storageLocation">存储位置</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="minv2_unitManageIframe_findBtn_class" id="find"><span class="icon_find">查询</span></button>
						<br />
						<div id="jcTypeDiv" class="minv2_pjSDIRecordFixCheck_float_left" style="display: none;">
							机车型号：
							<select id="jctype" name="jctype">
								<option value="">请选择</option>
								<c:forEach var="jctype" items="${jcType}">
									<option value="${jctype.id}" ${dto.jcTypeId==jctype.id? 'selected' : ''}>${ jctype.jcTypeValue}</option>
								</c:forEach>

							</select>
						</div>

						<div id="pjNameDiv" class="minv2_pjSDIRecordFixCheck_float_left" style="display: none;">
							配件名称：
							<input type="text" id="pjName" name="pjName" value="${dto.pjName }" />
						</div>

						<div id="pjAssemblyTypeDiv" class="minv2_pjSDIRecordFixCheck_float_left" style="display: none;">
							配件状态：
							<select id="pjdStatus" name="pjdStatus">
								<option value="">请选择配件状态</option>
								<c:forEach var="status" items="${statusType}">
									<option value="${status.key}" ${dto.pjdStatus==status.key ? 'selected' : '' }>${status.value}</option>
								</c:forEach>
							</select>
						</div>

						<div id="jcIdDiv" class="minv2_pjSDIRecordFixCheck_float_left" style="display: none;">
							机车编号：
							<select id="jcTypeNum" name="jcTypeNum" class="">
								<option value="">请选择机车编号</option>
								<c:forEach var="jcType" items="${jcType}">
									<option value="${jcType.id}" ${dto.jcTypeId==jcType.id? 'selected' : ''}>${jcType.jcTypeValue }</option>
								</c:forEach>
							</select>
						</div>

						<div id="pjIdDiv" class="minv2_pjSDIRecordFixCheck_float_left" style="display: none;">
							配件编号：
							<input type="text" id="pjdCode" name="pjdCode" value="${dto.pjdCode}" />
						</div>

						<div id="storageLocationDiv" class="minv2_pjSDIRecordFixCheck_float_" style="display: none;">
							存储位置：
							<select id="storePositionId" name="storePositionId" class="">
								<option value="">请选择配件存储位置</option>
								<c:forEach var="spList" items="${storePositionList}">
									<option value="${spList.id}" ${dto.storePositionId==spList.id? 'selected' : ''}>${spList.storePositionName}</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>

				<!-- *********	操作功能区  end  ********** -->

				<!-- ************************************************************************************************* -->

				<!-- *********	数据显示区  start  ********** -->
				<tr>
					<td>
						<table class="treeTable">
							<tr>
								<th width="5%">序号</th>
								<th width="15%">配件名称</th>
								<th width="15%">配件编号</th>
								<th width="10%">机车类型</th>
								<th width="15%">存储位置</th>
								<th width="8%">配件状态</th>
								<th width="10%">操作</th>
							</tr>
							<c:forEach var="m" items="${map}" varStatus="pjSSInfoStatus">
								<tr id="node-2" class="child-of-node-1">
									<td>${pjSSInfoStatus.index+1 }</td>
									<td><span>${m.key.pjName }</span></td>
									<td colspan="5"></td>
								</tr>
								<c:forEach var="pjStoreDynamicInfo" items="${m.value}" varStatus="pjSDInfoStatus">
									<c:set var="psdi" value="${pjStoreDynamicInfo }" scope="request"> </c:set>
									<tr id="node-${pjSSInfoStatus.index+1 }-${pjSDInfoStatus.index+1}" class="child-of-node-${m.key.id }">
										<td>${pjSSInfoStatus.index+1 }-${pjSDInfoStatus.index+1}</td>
										<td></td>
										<td>${pjStoreDynamicInfo.pjdCode }</td>
										<td>
											<c:forEach var="pjStaticJcTypePjFU" items="${m.key.pjStaticJcTypePjFUs }">
												${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictJcType.jcTypeValue }&nbsp;&nbsp;
											</c:forEach>
										</td>
										<td>${pjStoreDynamicInfo.dictStorePosition.storePositionName }</td>

										<%-- 获取配件状态 --%>
										<%
											PjStoreDynamicInfo psdi=(PjStoreDynamicInfo)request.getAttribute("psdi");
											long status=psdi.getPjdStatus();
											String statusText=Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS.get(status);
											request.setAttribute("pjdStatus", statusText);
										%>
										<td>${pjdStatus}</td>
										<td>
											<a target="_blank" style="color:blue" href="findPjSDInfoRecordByPjSDInfoIdForPjFix.action?pjSDInfoId=${pjStoreDynamicInfo.id}">检修记录</a>
										</td>
									</tr>
								</c:forEach>
							</c:forEach>
						</table>
					</td>

				</tr>
			</table>
			<!-- 用户管理 功能操作和数据显示区域    end  ************* -->

			<!-- *********	分页信息显示区 			 start  ********** -->
			<div style="height:35px;">
				共&nbsp;&nbsp;<font color="red">${spm.totalCount }</font>&nbsp;&nbsp;条数据${spm.pageString }
				<!-- *********	分页信息显示区 			end  ********** -->
			</div>
		</div>
	</body>

</html>