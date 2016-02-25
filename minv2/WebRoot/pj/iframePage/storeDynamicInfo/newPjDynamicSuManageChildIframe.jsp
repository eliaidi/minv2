<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<html>
	
  <head>
  	<title>${cache['SYS_TITLE'][0].value}--->配件-->新件入库右边Iframe</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
    <script type="text/javascript" src="${urlctx }js/My97DatePicker/WdatePicker.js"></script>
   
    <script src="${urlctx }js/smartTips/smartTips.js"></script>
 
	<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
	<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
	<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
	<!--引入弹出窗组件end-->
	
	<!-- 自定义js -->
	<script type="text/javascript" src="${urlctx}js/pj/newPjDynamicSuManageChildIframe_script.js"></script>
 </head>
  
  <body>
  	<input type="hidden" id="message" value="${message }"/>
  	<c:remove var="message" scope="session"/>
    <!-- 用户管理 功能操作和数据显示区域    动态配件管理 ************ -->
  	<div class="box2" panelTitle="动态配件管理" panelHeight="520">
			<table width="100%">
				<!-- *********	操作功能区  start  ********** -->
				<tr>
					<td width="100%" >
						<div panelTitle="" roller="true" overflow="auto">
							<form action="addPjStoreDynamicInfo.action" method="post" id="pjDynamicSuManageChildSubmit" name="pjDynamicSuManageChildSubmit" onsubmit="return checkform()">
								<table>
								<s:token></s:token>
									<tr>
										<td>
											<input type="hidden"  value="0" name="receivingDeliverStatus"/>
											静态配件名称:<input type="text" watermark="必填,PY或名称联想输入" id="pjName" name="pjStoreStaticInfo.pjName" value=""  class="validate[required,length[1,20]]"/>
											<input type="hidden" id="pjStoreStaticInfoId" />
										</td>
										<td>
											&nbsp; 出厂日期:<input type="text" name="pjdOutFactoryDate" watermark="出厂日期" class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"/>
										</td>
										<td>
											 &nbsp;收件人员：<input type="text" color="red" watermark="收件人员" style="width:130px" name="usersPrivs.userName" value="张飞" class="validate[required,length[1,20]]" readonly="readonly"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											&nbsp;入库仓库:
											<select name="dictStorePosition.id" colnum="3">
												<c:forEach items="${storePositionList}" var="storePosition">
													<c:if test="${storePosition.storePositionType ==0 || storePosition.storePositionType ==1}">
														<option value="${storePosition.id}">${storePosition.storePositionName}</option>
													</c:if>
												</c:forEach>
											</select>
										</td>
										<td>
											&nbsp; <span>入库价格:</span><input type="text"  name="pjdInPrice" watermark="入库价格"  class="validate[required,custom[onlyNumber]]"/>
										</td>
										<td>
											&nbsp;<input type="radio" id="mainPosition" name="pjSDInfoRecord.storeUnitProteamStatus" value="2" checked/><label for="mainPosition">主仓库与单位</label> 
										</td>
									</tr>
									<tr>
										<td colspan="2" align="right">
										&nbsp;生产厂家: 
											<input type="text" style="width:320px" watermark="非必填项" name="pjdFactory"/>
										</td>
										<td>
											&nbsp;送件人员:<input type="text" watermark="单位/班组" style="width: 60px" name="correlationUnit" class="validate[required,length[1,20]]"/>
											&nbsp;<input type="text" watermark="姓名" style="width: 60px" name="correlationName"/>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											&nbsp;&nbsp;&nbsp;备  注: <input type="text" name="remark" style="width:528px" watermark="非必填项" />
										</td>
									</tr>
									<tr>
										<td colspan="3">
											配件名称：<font color="blue">火车轮子</font>&nbsp;&nbsp;&nbsp;
											配件编码：<input type="text" style="width:335px" watermark="通过外部设备扫描输入，或手工输入，不能为空" name="pjdCode" id="pjdCode" class="validate[required,length[1,20]]"/>
											<!-- 
											<button id="addStoreDynamicBtn" name="addStoreDynamicBtn"><span class="icon_add">添加</span></button>
											 -->
											<input type="submit" value="添加"/>
										</td>
									</tr>
								</table>
						  	</form>	
						</div>
					</td>
				</tr>
				<!-- *********	操作功能区  end  ********** -->
				
				<!-- ************************************************************************************************* -->
				
				<!-- *********	数据显示区  start  ********** -->
				<tr>
					<td>
						
						<table class="flexiStyle" useMultColor="false" striped="true" useCheckBox="false">
								<thead>
									<tr>
										<th width="70">序号</th>
										<th width="200">配件编码</th>
										<th width="200">状态</th>
										<th width="150">出厂日期</th>
										<th width="145">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pjStoreDynamicInfoPm == null ? null :pjStoreDynamicInfoPm.datas }" var="dynamicInfo" varStatus="dynamicInfoStatus">
										<c:set var="tempPsdi" value="${dynamicInfo }" scope="request"></c:set>
										<tr>
											<td>${dynamicInfo.id}</td>
											<td>${dynamicInfo.pjdCode }</td>
											<%-- 获取配件状态 --%>
											<td>
												<c:forEach var="map" items="${mapPjStatue }">
												<c:if test="${map.key==dynamicInfo.pjdStatus}">
													${map.value}
												</c:if>
												</c:forEach>
											</td>
											<td>${dynamicInfo.pjdOutFactoryDate }</td>
											<td>
												<button onclick='top.Dialog.open({URL:"toUpdateDynamicInfoDialog.action?id=${dynamicInfo.id}",Title:"修改配件",Height:500});'><span class="icon_edit" >修改</span></button>
												<button onclick='deleteDynamicPj(${dynamicInfo.id});'><span class="icon_delete">删除</span></button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
					</td>
				</tr>
				<!-- *********	数据显示区  end  ********** -->
			</table>
	</div>
	<!-- 用户管理 功能操作和数据显示区域    end  ************* -->
	
	

	<!-- *********	分页信息显示区  start  ********** -->
	<div style="height:35px; width: 100%;">
	</div>
	<!-- *********	分页信息显示区  start  ********** -->
	
  </body>
</html>
