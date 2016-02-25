<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>配件检修-选择配件-查看</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

	<body>
		<div class="box2" panelTitle="" roller="false">
			<table>
				<tr> 
					配件名称：<font color="red">${pjName }<input type="hidden" value="${pjName}" name="pjName" id="pjName" /></font>
					<input type="checkbox" id="dictJcTypeCkb"/>车型
					<input type="checkbox" id="pjdStatusCkb"/>状态
					<input type="checkbox" id="pjdCodeCkb"/>配件编号
					<input type="hidden" value="${pjSSInfoId}" name="pjSSInfoId" id="pjSSInfoId"/ >
					<div class="float_right">
						<button id="queryFindSDInfo">查询</button>
					</div>
				</tr>
				<tr>
					<td>
						<div id="dictJcTypeIdDiv" name="dictJcTypeIdDiv">
							车型
							<select autoWidth="true" name="jcType" id="jcTypeId">
								<option value="请选择">请选择</option>
							   <c:forEach var="jcType" items="${jcType}">
									<option value="${jcType.id}" ${dto.jcTypeId == jcType.id ? 'selected' : ''}>${jcType.jcTypeValue}</option>
							   </c:forEach>
							</select>
						</div>
					</td>
					<td>
						<div id="pjdStatusDiv" name="pjdStatusDiv">
							状态
							<select autoWidth="true" name="pjdStatus" id="pjdStatus"  colnum="2">
								<option value="请选择">请选择</option>
								<c:forEach items="${pjSDInfoPjdStatus }" var="pjsdInfoPjD">
									<option value="${pjsdInfoPjD.key }" ${dto.pjdStatus == pjsdInfoPjD.key ? 'selected' : '' }>${pjsdInfoPjD.value }</option>
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
			<table class="tableStyle" id="table1">
				<tr>
					<th width="5%">序号</th>
					<th width="10%">配件名称</th>
					<th width="15%">配件编码</th>
					<th width="10%">专业</th>
					<th width="15%">存放位置</th>
					<th width="10%">状态</th>
					<th width="10%">操作</th>
				</tr>
				<c:forEach var="pjSDInfo"  items="${spm.data}">
					<c:set var="psdi" value="${pjSDInfo}" scope="request"></c:set>
				    <tr>
				        <td>${pjSDInfo.id}</td>
						<td>${pjSDInfo.pjStoreStaticInfo.pjName}</td>						       
				        <td>${pjSDInfo.pjdCode}<input type="hidden" name="pjdCode" id="pjdCode" value="${pjSDInfo.pjdCode}"/></td>
				        <td>
				        	<c:forEach items="${pjSDInfo.pjStoreStaticInfo.pjStaticJcTypePjFUs}" var="pjStaticJcTypePjFU">
		        				${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName }
				        	</c:forEach>
				        </td>
				        <td>${pjSDInfo.dictStorePosition.storePositionName}</td>
				        <td>
				        	<c:forEach var="pjsdInfoStatu" items="${pjSDInfoPjdStatus}">
				        		<c:if test="${pjsdInfoStatu.key == pjSDInfo.pjdStatus }">
				        			${pjsdInfoStatu.value }
				        		</c:if>
				        	</c:forEach>
				        </td>
				        <td>
			        		<input type="hidden"  name="message"  id="message" value="${message }"/>
			        		<c:remove var="message" scope="session" />
				        		
							<c:choose><%--sureFixPjStoreDynamicInfo.action?id=${pjSDInfo.id} --%>
				        		
				        		<c:when test="${pjSDInfo.pjdStatus  == 2}">
				        			<button  onclick="chooseFix('${pjSDInfo.id}')"> 选择检修</button>
					    			<button  onclick='top.Dialog.open({URL:"toOutsourcingMaintenanceForPjFix.action?id=${pjSDInfo.id }&pjdCode=${pjSDInfo.pjdCode}&pjName=${pjSDInfo.pjStoreStaticInfo.pjName }",Title:"委外检修信息输入框",Width:600,Height:300});'> 委外检修</button>
				        		</c:when>
				        		<c:otherwise>
				        			<a style="color:blue" href="findPjSDInfoRecordByPjSDInfoIdForPjFix.action?pjSDInfoId=${pjSDInfo.id}">查看记录</a>
				        		</c:otherwise>
			        		</c:choose>		
				        </td>
				    </tr>
				 </c:forEach>
			</table>
		</div>

		<div style="height:35px;">
		    共&nbsp;&nbsp;<font color="red">${spm.totalCount}</font>&nbsp;&nbsp;条数据 ${spm.pageString}  
		</div>
	</body>
<!-- 自定义js -->
<script type="text/javascript" src="${ctx}/js/pjFix/checkFixPj/viewDynamicPjPage_script.js"></script>
</html>