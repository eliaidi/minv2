<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>验收员卡控----检修中配件</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

<body>
		<div class="box2" panelTitle="待签配件（验收员）" roller="false">
			<table>
				<tr>
					<input type="hidden" value="${pjdStatus }" name="pjdStatus" id="pjdStatus"/>
					配件名称：<font color="red">${pjName }<input type="hidden" value="${pjName}" name="pjName" id="pjName" /></font>
					<input type="checkbox" id="dictJcTypeIdCkb" />
					<label for="dictJcTypeIdCkb">车型</label>
					<input type="checkbox" id="firstUnitIdCkb" />
					<label for="firstUnitIdCkb">专业</label>
					<input type="checkbox" id="pjdCodeCkb"/>
					<label for="pjdCodeCkb">配件编号</label>
				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					<button id="queryFindSDInfo">查询</button>
				</tr>
				<tr>
					<td>
						<div id="dictJcTypeIdDiv" name="dictJcTypeIdDiv">
							车型
							<select autoWidth="true" name="jcTypeId" id="jcTypeId">
								<option value="请选择">请选择</option>
							   <c:forEach var="jcType" items="${jcType}">
									<option value="${jcType.id}" ${dto.jcTypeId == jcType.id ? 'selected' : ''}>${jcType.jcTypeValue}</option>
							   </c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div id="firstUnitIdDiv" name="firstUnitIdDiv">
							专业
							<select autoWidth="true" name="firstUnitId" id="firstUnitId"  colnum="2">
								<option value="请选择">请选择</option>
								<c:forEach var="firstUnit" items="${firstUnitList }">
									<option value="${firstUnit.id }" ${dto.firstUnitId == firstUnit.id ? 'selected' : '' }>${firstUnit.firstUnitName }</option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div id="pjdCodeDiv" name="pjdCodeDiv">
							配件编号
							<input type="text" name="pjdCode" id="pjdCode" value="${dto.pjdCode }"/>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">序号</th>
					<th width="20%">配件编码</th>
					<th width="8%">机车类型</th>
					<th width="8%">专业</th>
					<th width="8%">状态</th>
					<th width="10%">操作</th>
				</tr>
				<c:forEach var="pjSSInfo"  items="${spm.data}" varStatus="countPJ">
					    <tr>
					        <td>${countPJ.index+1 }</td>
					        <td>${pjSSInfo.pjdCode }</td>
							<td width="8%">
								<c:forEach items="${pjSSInfo.pjStoreStaticInfo.pjStaticJcTypePjFUs}" var="pjStaticJcTypePjFU">
			        				${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictJcType.jcTypeValue }
					        	</c:forEach>
							</td>
							<td>
					        	<c:forEach items="${pjSSInfo.pjStoreStaticInfo.pjStaticJcTypePjFUs}" var="pjStaticJcTypePjFU">
			        				${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName }
					        	</c:forEach>
					        </td>
							<td width="15%"><span class="minv2_maintenancePjManagerIframe_span_class">检修中</span></td>
							<td width="8%"><a href="enterSignByAcceptanceOfCheckForPjFix.action?id=${pjSSInfo.id}"><span>进入签认</span></a></td>
						</tr>
				</c:forEach>
			</table>
		</div>
		<div style="height:35px;">
		  	  共&nbsp;&nbsp;<font color="red">${spm.totalCount}</font>&nbsp;&nbsp;条数据 ${spm.pageString}  
		</div>
	</body>
<!-- 自定义js -->
<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/acceptance/acceptanceFixingPjManagerIframe_script.js"></script>
</html>