<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}--配件管理-->配件记录管理-->配件出入库记录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />


		<!-- 智能联想输入 -->
		<script src="${urlctx }js/smartTips/smartTips.js"></script>
	</head>

	<body>
		<input type="hidden"  value="${urlctx}" id="rootPath"/>
		<!-- 用户管理 功能操作和数据显示区域    start ************ -->
		<div class="position" panelTitle="仓库管理" roller="false" overflow="true">
			<table width="100%">
				<!-- *********	操作功能区  start  ********** -->

				<tr>
					<td>
						<div  class="box_tool padding_bottom3 padding_right5">
							<%-- 将入库、出库查询条件存入变量，然后通过变量判断是否需要选中对应的复选框--%>
							<c:forEach var="receivingDeliverStatus" items="${dto.receivingDeliverStatus}">
								<c:set var="rdStatus">${rdStatus },${ receivingDeliverStatus}</c:set>
							</c:forEach>
							<input type="checkbox" ${fn:contains(rdStatus,'1') ? 'checked' : ''}
								value="<%=Constants.RECEIVING_DELIVER_STATUS_ONE %>" id="outStoreCkb" name="receivingDeliverStatus"/>
							<label for="outStoreCkb">出库</label>
							<input type="checkbox" ${fn:contains(rdStatus,'0') ? 'checked' : ''}
								value="<%=Constants.RECEIVING_DELIVER_STATUS_ZERO %>"  id="inStoreCkb" name="receivingDeliverStatus" />
							<label for="inStoreCkb">入库</label>
							
							<!-- 将移库标识条件存入变量，然后通过变量判断是否需要选中对应的复选框 -->
							<c:forEach var="storeUnitProteamStatus" items="${dto.storeUnitProteamStatus}">
								<c:set var="supStatus">${supStatus },${storeUnitProteamStatus}</c:set>
							</c:forEach>
							<input type="checkbox"  ${fn:contains(supStatus,'0') ? 'checked' : ''}
								value="<%=Constants.STORE_UNIT_PROTEAM_STATUS_ZERO %>" id="mainStoreAndProteamCkb" name="storeUnitProteamStatus"/>
							<label for="mainStoreAndProteamCkb">主仓库与班组仓库</label>
							<input type="checkbox"  ${fn:contains(supStatus,'1') ? 'checked' : ''}
								value="<%=Constants.STORE_UNIT_PROTEAM_STATUS_ONE %>" id="proteamAndProteamCkb" name="storeUnitProteamStatus" />
							<label for="proteamAndProteamCkb">班组仓库与班组仓库</label>
							<input type="checkbox"  ${fn:contains(supStatus,'2') ? 'checked' : ''}
								value="<%=Constants.STORE_UNIT_PROTEAM_STATUS_TWO %>" id="mainStoreAndUnitCkb"  name="storeUnitProteamStatus"/>
							<label for="mainStoreAndUnitCkb">主仓库与相关单位</label>
							<br />
							
							
							<input type="checkbox" id="storeUsersNameCkb" ${dto.storeUsersName != null ? 'checked' : '' } />
							<label for="storeUsersNameCkb">仓库人员</label>
							<input type="checkbox" id="pjdCodeCkb" ${dto.pjdCode != null ? 'checked' : '' } />
							<label for="pjdCodeCkb">配件编码</label>
							<input type="checkbox" id="pjNameCkb"  ${dto.pjName != null ? 'checked' : '' }/>
							<label for="pjNameCkb">配件名称</label>
							<input type="checkbox" id="firstUnitNameCkb" ${dto.firstUnitName != null ? 'checked' : '' } />
							<label for="firstUnitNameCkb">专业</label>
							<input type="checkbox" id="storePositionIdCkb" ${dto.storePositionId !=  null ? 'checked' : '' } />
							<label for="storePositionIdCkb">仓库</label>
							<input type="checkbox" id="proteamUsersNameCkb" ${dto.proteamUsersName !=  null ? 'checked' : '' }/>
							<label for="proteamUsersNameCkb">班组单位人员</label>
							<input type="checkbox" id="recordTimeCkb"  ${(dto.startRecordTime != null || dto.endRecordTime != null) ? 'checked' : '' }/>
							<label for="recordTimeCkb">记录时间段</label>

							&nbsp;&nbsp;&nbsp;

							<br />
							
							<div id="pjdCodeDiv" style="display: none;">
								配件编码：
								<input type="text" name="pjdCode" id="pjdCode" value="${dto.pjdCode}" watermark="" />
							</div>
							<div id="proteamUsersNameDiv" style="display: none;">
								班组单位人员：
								<input type="text" name="proteamUsersName" id="proteamUsersName" value="${dto.proteamUsersName }" watermark="" />
							</div>
							<div id="startRecordTimeDiv" style="display: none;">
								记录开始时间：
								<input type="text" class="date" id="startRecordTime" value="${dto.startRecordTime }" watermark="" />
							</div>
							<div id="storeUsersNameDiv" style="display: none;">
								仓库人员：
								<input type="text" id="storeUsersName" value="${dto.storeUsersName }" watermark="" />
							</div>
							<br />
							<div id="pjNameDiv" style="display: none;">
								配件名称：
								<input type="text" id="pjName" watermark="" value="${dto.pjName }" />
							</div>
							<div id="endRecordTimeDiv" style="display: none;">
								记录结束时间：
								<input type="text" class="date" id="endRecordTime" value="${dto.endRecordTime }" watermark="" />
							</div>
							<div id="firstUnitNameDiv" style="display: none;">
								专业名称：
								<input type="text"  id="firstUnitName" value="${dto.firstUnitName }" watermark="" />
							</div>
							
							<div id="storePositionIdDiv" style="display: none;" class="default">
								仓库：
								<select id="storePositionId">
									<option value="">请选择仓库</option>
									<c:forEach items="${storePositionList }" var="storePosition">
										<option value="${storePosition.id }" 
											${storePosition.id == dto.storePositionId ? 'selected' : ''}  >
											${storePosition.storePositionName }
										</option>
									</c:forEach>
								</select>
							</div>
							&nbsp;&nbsp;
							<button class="float_right" id="queryStorePosition"><span class="icon_find">查询</span></button>
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
									<th width="10%">配件名称</th>
									<th width="15%">配件编码</th>
									<th width="10%">出库/入库</th>
									<th width="15%">出入库单位类型</th>
									<th width="20%">记录时间</th>
								</tr>
								</thead>
								<c:forEach items="${sp.data }" var="pjSDInfoRecord">
									<c:set value="${pjSDInfoRecord.pjStoreDynamicInfo}" var="tempPsdi" scope="request"></c:set>
									<tr>
										<td width="20%">${pjSDInfoRecord.pjStoreDynamicInfo.pjStoreStaticInfo.pjName }</td>
										<td width="20%">
											<span class="text_slice" style="width:130px"  title="配件动态信息如下：</br>
											<%-- 获取配件状态 --%>
											<%
												PjStoreDynamicInfo psdi=(PjStoreDynamicInfo)request.getAttribute("tempPsdi");
												long status=psdi.getPjdStatus();
												String statusText=Constants.PJ_STORE_DYNAMIC_INFO_PJD_STATUS.get(status);
												request.setAttribute("pjdStatus", statusText);
											%>
											    配件编码：【${pjSDInfoRecord.pjStoreDynamicInfo.pjdCode }】<br>
											    配件生产厂家：【${pjSDInfoRecord.pjStoreDynamicInfo.pjdFactory }】<br>
											    配件状态：【${pjdStatus }】<br>
											    配件出厂日期：<br>【${pjSDInfoRecord.pjStoreDynamicInfo.pjdOutFactoryDate }】<br>
											    配件进货价格：【${pjSDInfoRecord.pjStoreDynamicInfo.pjdInPrice }(元)】<br>
											    配件拼音：【${pjSDInfoRecord.pjStoreDynamicInfo.py} 】<br>
											    配件备注：【${pjSDInfoRecord.pjStoreDynamicInfo.remark}  】<br>
											     配件所在位置/仓库：【${pjSDInfoRecord.pjStoreDynamicInfo.dictStorePosition.storePositionName}  】 ">
											     
											<font color="blue">${pjSDInfoRecord.pjStoreDynamicInfo.pjdCode }</font></span>
										</td>
										<td width="20%">
											<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 1}">
												出库（移库）
											</c:if>
											<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 0}">
												入库
											</c:if>
										</td>
										<td width="20%">
											<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 0}">
												<span style="color:red">主仓库</span>&lt;-&gt;<span style="color:orange">班组库</span>
											</c:if>
											<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 1}">
												<span style="color:orange">班组库</span>&lt;-&gt;<span style="color:orange">班组库</span>
											</c:if>
											<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 2}">
												<span style="color:red">主仓库</span>&lt;-&gt;<span style="color:blue">相关单位</span>
											</c:if>
											<c:if test="${pjSDInfoRecord.receivingDeliverStatus == 3}">
												下车入库
											</c:if>
										</td>
										<td width="20%">${pjSDInfoRecord.recordTime }</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						
					</td>
				</tr>
				<!-- *********	数据显示区  end  ********** -->
			</table>
			 <div style="height:35px;">
			<div class="float_left padding5">
				配件总数（除外地库）：<font color="red">${sp.totalCount}</font>件
			</div>
			<div class="float_right padding5 paging">
				<div class="float_left padding_top4">
					${sp.pageString }
				</div>
			</div>
			<div class="clear"></div>
		</div>
		</div>
		<!-- 用户管理 功能操作和数据显示区域    end  ************* -->

		<!-- *********	分页信息显示区  start  ********** -->
		
		<!-- *********	分页信息显示区  start  ********** -->
	</body>
	<!-- 自定义js -->
	<script type="text/javascript" src="${urlctx}js/pj/pjSDInfoRecordManageIframe_script.js"></script>

</html>