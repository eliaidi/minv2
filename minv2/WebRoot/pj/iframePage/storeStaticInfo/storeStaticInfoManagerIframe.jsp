<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@page import="com.repair.entity.PjStoreStaticInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}--配件管理--配件静态信息管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script  src="${ctx }/js/pj/storeStaticInfoManagerIframe_script.js"></script>
		
		<script  src="${ctx }/js/pj/storeStaticInfoManagerIframe_script.js.jsp"></script>
		
		<!-- 智能联想输入 -->
		<script src="${urlctx }js/smartTips/smartTips.js"></script>
	</head>

	<body>
		<!--  功能操作和数据显示区域    start ************ -->
		<div class="box2" panelTitle="配件静态信息管理" roller="false" overflow="true">
			<table width="100%">
				<!-- *********	操作功能区  start  ********** -->

				<tr>
					<td>
						<div>
							<table width="100%" border="0px">
								<tr>
									<td colspan="3" >
										<input type="checkbox" id="staticName" />
										<label for="staticName">静态名称</label>
										<input type="checkbox" id="pjProteam" />
										<label for="pjProteam">配件班组</label>
										<input type="checkbox" id="statu" />
										<label for="statu">组装状态</label>
										<input type="checkbox" id="unitName" />
										<label for="unitName">专业名称</label>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="checkbox" id="minStore" ${param.minStore ? 'checked' : '' }/>
										<label for="minStore"><font color="blue">最小库存</font></label>
										<input type="checkbox" id="isOpen"  value="0"  ${dto.pjActivate == 0 ? 'checked' : '' } />
										<label for="isOpen"><font color="blue">未启用</font></label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button style="" id="vagueSelect"><span class="icon_find">查询</span></button>
									</td>
								</tr>
								<tr>
									<td >
										<div id="staticNameDiv" style="display: none;">
											静态名称
											<input type="text" style="width:200px;height:20px"   id="pjName" value="${dto == null? '' : dto.pjName}"/>
											<input type="hidden" id="pjStoreStaticInfoId"/>
										</div>
									</td>
									
									<td >
										<div id="pjProteamDiv" style="display: none;">
											配件班组
											<select autoWidth="true" id="proteamName" name="proteamName">
											   <option value="">请选择班组</option>
											   <c:forEach var="proteam" items="${dictProteams}">
												  <option value="${proteam.id}" ${dto.proteamId == proteam.id ? 'selected' : ''}>${proteam.proteamName}</option>
												</c:forEach>
											</select>
										</div>
									</td>
									<td style="text-align:right">

									</td>
								</tr>
								<tr>
									<td >
										<div id="statuDiv" style="display: none;">
											组装状态
											<select id="pjAssemblyTypeId" name="pjAssemblyTypeId">
												<option value="">请选择组装状态</option>
												<c:forEach var="ay" items="${assembly}">
												    <option value="${ay.key}" ${dto.pjAssemblyType == ay.key ? 'selected' : ''}>${ay.value}</option>
												</c:forEach>
											</select>
											<%-- <input type="text" style="width:220px" id="pjAssemblyType" value="${pssi == null? '' : pssi.pjAssemblyType}"/>
										    <input type="hidden"  id="pjAssemblyTypeId" value=""/>--%>
										</div>

									</td>
									<td >
										<div id="unitNameDiv" style="display: none;">
											专业名称
											<input type="text" style="width:220px" id="firstUnitName" value="${dto.firstUnitName}"/>
										</div>
									</td>
									<td style="text-align:right">

									</td>
								</tr>
								<tr>
									<td >
										<button id="batchDel"><span class="icon_delete">批量删除</span></button>
									</td>
									
									<td colspan="2" style="">
										
										&nbsp;&nbsp;
										<button onclick='top.Dialog.open({URL:"toAddPjStoreStaticInfo.action",Title:"新增配件静态信息",ShowCloseButton:true});'><span class="icon_add">新增</span></button>
								                 &nbsp;&nbsp;&nbsp;&nbsp; 请选择：${pssiList.dropDownBox} 
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
						<div>
							<table class="flexiStyle" id="checkboxTable">
								<thead id="theadId">
									<tr class="odd">
										<th width="60"><span class="img_checkAllOff" id="all"></span></th>
										<th width="160">配件名称</th>
										<th width="160">所属大部件</th>
										<th width="170">父级配件</th>
										<th width="150">组装状态</th>
										<th width="100">是否启用</th>
										<th width="205">操作</th>
									</tr>
								</thead>
                                 <c:forEach var="pssi" items="${pssiList.data}">
                                 <c:set value="${pssi }" var="tempPssi" scope="request"></c:set>
								<tr>
									<td width="5%">
										<input type="checkbox" id="pjSSInfonCkbId" name="pjSSInfonCkb" value="${pssi.id}"/>
									</td>
									<td width="15%">${pssi.pjName}</td>
									<td width="15%">
									   <c:forEach var="pjStaticJcTypePjFU" items="${pssi.pjStaticJcTypePjFUs}">
								   			${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName}&nbsp;
									   </c:forEach>
									</td>
									<td width="15%">
								
										${pssi.parentPjStoreStaticInfo.pjName }
									    
								    </td>
									<td width="10%">
										<%
											PjStoreStaticInfo pssi=(PjStoreStaticInfo)request.getAttribute("tempPssi");
											String pjAssemblyType=Constants.PJ_ASSEMBLY_TYPE.get(pssi.getPjAssemblyType());
											request.setAttribute("pjAssemblyType", pjAssemblyType);
										%>
										${requestScope.pjAssemblyType }
									</td>
									<td width="10%">
										  <c:if test="${pssi.pjActivate=='0'}">未启用</c:if>
										  <c:if test="${pssi.pjActivate=='1'}">启用</c:if>  
									</td>
									<td width="20%">
										<button onclick='top.Dialog.open({URL:"findPjStoreStaticInfoById.action?id=${pssi.id}",Title:"查看配件静态信息",ShowCloseButton:true});'><span class="icon_view">查看</span></button>
										<button onclick='top.Dialog.open({URL:"toUpdatePjStoreStaticInfo.action?id=${pssi.id}",Title:"修改配件静态信息",ShowCloseButton:true});'><span class="icon_edit">修改</span></button>
										<button onclick='deleteStaticInfo(${pssi.id})'><span class="icon_delete"  title="删除" id="deleteStaticInfo">删除</span></button>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
					</td>
				</tr>
				<!-- *********	数据显示区  end  ********** -->
			</table>
		</div>
		<!-- 用户管理 功能操作和数据显示区域    end  ************* -->

		<!-- *********	分页信息显示区  start  ********** -->
		<div style="height:35px;">
			 共&nbsp;&nbsp;<font color="red">${pssiList.totalCount}</font>&nbsp;&nbsp;条数据 ${pssiList.pageString}
		</div>
		<!-- *********	分页信息显示区  start  ********** -->
	</body>

</html>