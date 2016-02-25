<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="pg" uri="page-taglib"%>
<%@include file="/common/taglibs.jsp" %>

<html>
  <head>
  	<title>${cache['SYS_TITLE'][0].value}--配件管理-->仓库管理</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	 <!-- 自定义js 							开始-->
     <script type="text/javascript" src="${ctx}/js/pj/storePositionManagerIframe_script.js.jsp"></script>
     <!-- 自定义js 								结束-->
  
 </head>

  <body>
    <!-- 用户管理 功能操作和数据显示区域    start ************ -->
  	<div  class="position" panelTitle="仓库管理" roller="false" overflow="true">
		<table width="100%">
			<!-- *********	操作功能区  start  ********** -->
			<tr>
				<td>
					<div  >	
						<table  border="0px">
							 	<input type="checkbox" id="selByStorePositionName"/>通过仓库名查询
							 	<input type="checkbox" id="selByDictArea"/>通过机务段查询
							 	<input type="checkbox" id="selBystorePositionType"/>通过仓库类型查询
							 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 	<button id="queryStorePosition"><span class="icon_find">查询</span></button>
							 	<br/>
								<tr>
									<td >
										<div id="storePositionNameDiv">
											仓库名 <input type="text"  name="storePositionName" id="storePositionName" value="${storePositionName}"/>
										</div>
									</td>
									<td >
										<div id="dictAreaIdDiv">
											机务段 
											<input type="hidden" name="dictAreaIdSec" id="dictAreaIdSec" value="${dictArea.id}"/>
											<select autoWidth="true"  name="dictAreaId" id="dictAreaId">
												<option value="请选择">请选择</option>
												<c:forEach items="${areaList }" var="areaLi">
													<option value='${areaLi.id }' ${areaLi.id == dictArea.id ? "selected" : ""}>${areaLi.areaName }</option>
												</c:forEach>
											</select>
										</div>
									</td>
									<td >
										<div id="storePositionTypeDiv">
											类型
											<input type="hidden" name="storePositionTypeSec" id="storePositionTypeSec" value="${storePositionType }"/>
											<select autoWidth="true" name="storePositionType" id="storePositionType">
												<option value="请选择">请选择</option>
												<c:forEach items="${storePositionTypeMap}" var="storePosition">
													<option value="${storePosition.key }" ${storePositionType == storePosition.key ? "selected" : "" }>${storePosition.value }</option>
												</c:forEach>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2"><span style="float:right">请选择：${sp.dropDownBox}&nbsp;&nbsp;</span>
										<button onclick='top.Dialog.open({URL:"toAddStorePositionDialog.action",Title:"新增仓库",ShowCloseButton:true});'><span class="icon_add">新建</span></button>
										&nbsp;&nbsp;&nbsp;&nbsp;
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
								<th width="10%">序号</th>
								<th width="10%">位置/仓库名</th>
								<th width="5%">配件数/件</th>
								<th width="15%">地区/机务段ID</th>
								<th width="15%">位置/仓库类型</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<c:forEach items="${sp == null ? null : sp.data }" var="dspPm" varStatus="dspCount">
							<tr >
								<td width="5%">${dspCount.index+1}</td>
								<td width="20%">${dspPm.storePositionName }</td>
								<td width="10%">${fn:length(dspPm.pjStoreDynamicInfos)}</td>
								<td width="15%">${dspPm.dictArea.areaName }</td>
								<td width="10%">
									<c:forEach items="${storePositionTypeMap }" var="storePositionTy">
										<c:if test="${storePositionTy.key == dspPm.storePositionType}">
											${storePositionTy.value }
										</c:if>
									</c:forEach>
								</td>
								<td width="10%">
									<button id="storePositionUpd"  name="storePositionUpd" onclick='top.Dialog.open({URL:"toUpdateDictStorePosition.action?id=${dspPm.id}",Title:"仓库修改"});'><span class="icon_edit">修改</span></button>
									<button id="deleteBtnByStorePosition" value="${dspPm.id}"><span class="icon_delete">删除</span></button>
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
			<div class="float_left padding5">
			配件总数（除外地库）：<font color="red">${sp.totalCount }</font>件
			</div>
			${sp.pageString }
		</div>
	 <!-- *********	分页信息显示区  end  ********** -->
	 </div>
 	 <!-- 用户管理 功能操作和数据显示区域  	  end  ************* -->
	
	

	
	
	
  </body>
 
</html>
