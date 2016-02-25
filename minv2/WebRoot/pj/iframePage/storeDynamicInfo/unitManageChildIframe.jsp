<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}--配件管理-配件动态信息管理-车型分类</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script src="${ctx}/js/pj/unitManageChildIframe_script.js"></script>
		
		<script src="${urlctx }js/smartTips/smartTips.js"></script>
	</head>

	<body>
		<!-- 动态配件管理 功能操作和数据显示区域    start ************ -->
		<div class="box2" panelTitle="配件动态信息管理--专业分类" style="width:900px">
			<table width="100%">
				<!-- *********	操作功能区  start  ********** -->
				<tr>
					<td width="100%">
						<div panelTitle="静态配件管理" roller="true" overflow="auto">
							<input type="checkbox" id="pjNameCkb" />
							<label for="pjName">配件名称</label>
							<input type="checkbox" id="spidCkb" />
							<label for="spid">仓库</label>
							<input type="checkbox" id="dateCkb" />
							<label for="date">入库日期</label>
							<input type="checkbox" id="unitCkb" />
							<label for="unit">专业</label>

							<button class="minv2_unitManageIframe_findBtn_class" id="find"><span class="icon_find">查询</span></button>
							<br />
							<div id="unitDiv" style="display: none;">
								专业：
								<input id="unitName" type="text" value="${dto.firstUnitName }" />
							</div>

							<div id="pjNameDiv" style="display: none;">
								配件名称：
								<input type="text" value="${dto.pjName }" id="pjName" />
								<input type="hidden" id="pjStoreStaticInfoId"/>
							</div>

							<div id="spidDiv" style="display: none;">
								仓&nbsp;库 ：
								<select id="storePositionId" class="default">
									<option value="">请选择仓库</option>
									<c:forEach items="${storePositionList }" var="storePosition">
										<option value="${storePosition.id }" ${dto.storePositionId==storePosition.id ? 'selected' : ''}>
											${storePosition.id }、${storePosition.storePositionName }
										</option>
									</c:forEach>

								</select>
							</div>

							<div id="dateDiv" style="display: none;">
								入库日期：
								<input type="text" value="${dto.recordTime }" id="recordTime" class="date" dateFmt="yyyy-MM-dd" />
							</div>

							<span class="float_right">${sp.dropDownBox}&nbsp;&nbsp;</span>

						</div>
					</td>
				</tr>

				<!-- *********	操作功能区  end  ********** -->

				<!-- ************************************************************************************************* -->

				<!-- *********	数据显示区  start  ********** -->
				<tr>
					<td>

						<table class="tableStyle" useMultColor="false">
							<thead>
								<tr>
									<th width="160">配件名称</th>
									<th width="160">所属专业</th>
									<th width="160">父级配件</th>
									<th width="80">组装状态</th>
									<th width="80">是否启用</th>
									<th width="80">动态配件个数</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${sp.data}" var="pssi">
									<tr>
										<td><a href="javascript:getDynamicInfo(${pssi.id});" title="点击查询动态配件列表">${pssi.pjName}</a></td>
										<td>
											<c:forEach var="pjStaticJcTypePjFU" items="${pssi.pjStaticJcTypePjFUs}">
												${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName}&nbsp;
											</c:forEach>
										</td>
										<td>
											${pssi.parentPjStoreStaticInfo.pjName }
										</td>
										<td>
											<c:if test="${pssi.pjAssemblyType == 0}">车上组装</c:if>
											<c:if test="${pssi.pjAssemblyType == 1}">配件组装</c:if>
										</td>
										<td>
											<c:if test="${pssi.pjActivate=='0'}">未启用</c:if>
											<c:if test="${pssi.pjActivate=='1'}">启用</c:if>
										</td>
										<td>
											<font size="3" color="blue">${fn:length(pssi.pjStoreDynamicInfos) }</font>

										</td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
			</table>
			<!-- 用户管理 功能操作和数据显示区域    end  ************* -->

			<!-- *********	分页信息显示区  start  ********** -->
			<div style="height:35px;">

				共&nbsp;&nbsp;<font color="red">${sp.totalCount }</font>&nbsp;&nbsp;条数据${sp.pageString }

			</div>
		</div>
	</body>

</html>