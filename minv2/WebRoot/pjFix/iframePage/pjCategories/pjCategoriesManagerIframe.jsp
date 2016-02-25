<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>机务检修系统--配件检修-配件大类</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
    
    <!-- 引用配件大类js文件				开始 -->
    <script type="text/javascript" src="${urlctx}/js/pjFix/pjCategoriesManagerIframe_script.js"></script>
    <!-- 引用配件大类js文件				结束 -->
  </head>
  
  <body>
       <!-- 用户管理 功能操作和数据显示区域    start ************ -->
  	<div  class="position" panelTitle="配件大类" roller="false" overflow="true">
		<table width="100%">
			<!-- *********	操作功能区  start  ********** -->
			<tr>
				<td>
					<div>	
						<table  border="0px">
							 	<input type="checkbox" id="selByjcType"/>
							 	<label for="selByjcType">车型</label>
							 	<input type="checkbox" id="selByfirstUnitName"/>
							 	<label for="selByfirstUnitName">专业</label>
							 	<input type="checkbox" id="selByStoreStaticPjName"/>
							 	<label for="selByStoreStaticPjName">配件名称</label>
							 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 	<button id="queryStorePosition"><span class="icon_find">查询</span></button>
							 	<br/>
								<tr>
									<td >
										<div id="selByjcTypeDiv" style="display: none;">
											车型 
											<select name="jcType" id="jcTypeId">
												<option value="">请选择</option>
												   <c:forEach var="jcType" items="${jcType}">
														<option value="${jcType.id}" ${dto.jcTypeId == jcType.id ? 'selected' : ''}>${jcType.jcTypeValue}</option>
												   </c:forEach>
											</select>
										</div>
									</td>
									<td >
										<div id="selByfirstUnitNameDiv" style="display: none;">
											专业 
											<select  name="firstUnitName" id="firstUnitNameId"  colNum="2">
												<option value="">请选择</option>
												<c:forEach items="${pjFirstUnit}" var="pjFirstUnit">
													<option value="${pjFirstUnit.id}" ${dto.firstUnitId == pjFirstUnit.id ? 'selected' : ''}>${pjFirstUnit.firstUnitName}</option>
											    </c:forEach>
											</select>
										</div>
									</td>
									<td >
										<div id="selByStoreStaticPjNameDiv" style="display: none;">
											配件名称
											<input type="text"   name="pjName" id="pjName" value="${dto.pjName}" />
										</div>
									</td>
								</tr>
						</table>
					</div>
				</td>
			</tr>
			<!-- *********	操作功能区  end  ********** -->
			
			<!-- ************************************************************************************************* -->
			
			<!-- *********	数据显示区  start  ********** -->
			<tr>
				<td colspan="11">
					<div id="scrollContent" class="border_gray">
						<table class="tableStyle">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="15%">配件名称</th>
								<th width="5%">最小库存</th>
								<th width="15%">所属专业</th>
								<th width="15%">机车类型</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<c:forEach var="pjSSInfo"  items="${spm.data}">
						    <tr>
						        <td>${pjSSInfo.id}</td>
						        <td>${pjSSInfo.pjName}</td>
						        <td>${pjSSInfo.pjLoweStstore}</td>
						        <td>
						          <c:forEach var="pjStaticJcTypePjFU" items="${pjSSInfo.pjStaticJcTypePjFUs}">
						             ${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName}&nbsp;&nbsp;
						          </c:forEach>
						        </td>
						        <td>
						           <c:forEach var="pjStaticJcTypePjFU" items="${pjSSInfo.pjStaticJcTypePjFUs}">
						             ${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictJcType.jcTypeValue}&nbsp;&nbsp;
						          </c:forEach>
						        </td>
						        <td>
						        	<a target="frmright" style="color:blue" href="findPjSSInfoByIdForPjFix.action?id=${pjSSInfo.id}">添加待修配件</a>
						       </td>
						    </tr>
						 </c:forEach>
						</table>
					</div>
				</td>
			</tr>
			<!-- *********	数据显示区  end  ********** -->
		</table>
		<!-- *********	分页信息显示区		 start  ********** -->
		<div style="height:35px;">
		    共&nbsp;&nbsp;<font color="red">${spm.totalCount}</font>&nbsp;&nbsp;条数据 ${spm.pageString}  
		</div>
	 <!-- *********	分页信息显示区  end  ********** -->
	 </div>
 	 <!-- 用户管理 功能操作和数据显示区域  	  end  ************* -->
  </body>
</html>
