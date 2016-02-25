<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>机务检修系统--配件大类--添加待修配件检查</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

	<body>
		<input type="hidden" id="rootPath" value="${urlctx }"/>
		<!--uurframe盒子模型   上方					开始-->
		<!-- 盒子模型左侧								 		开始-->
		<div class="box2 float_left" panelWidth="33%" panelHeight="520" showStatus="false" panelTitle="添加待修配件">
			<button id="addRowBtn" title="请点击确定!"><span>添加输入框</span></button>
			<button id="checkRepairBtn" title="3.填写完配件编号后，请检测待修配件是否存在!"><span>检查待修配件编号</span></button>
			<br/>
			<br/>
			<!-- 数据显示层												开始 -->
			<table class="tableStyle" useMultColor="false" useCheckBox="true" id="tbAddToRP">
				<tbody>
					<tr>
						<th>
							<input type="checkbox" name="ckAll" id="ckAll" />
							<button id="getCheckRow"><span>删除</span></button>
						</th>
						<th style="text-align:center">配件编号</th>
						<th>操作</th>
					</tr>
					<c:forEach var="pjdCode" items="${pjdCodes}" varStatus="pjdCodeStatus">
					<tr>
						<td><input type="checkbox" name="ckPj"/>${pjdCodeStatus.index+1 }</td>
						<td><input type="text" name="tdRepairValue" value="${pjdCode}" readonly/></td>
						<td><button id='delRowOneBtn' onclick='deleteSimple();'><span>删除</span></button></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 数据显示层												开始 -->
		</div>
		<!-- 盒子模型左侧								 		结束-->
		<!-- 盒子模型中部								 			开始-->
		<div class="box2 float_left" panelWidth="35%" panelHeight="520" showStatus="false" panelTitle="动态库存在配件" id="pjSDExistDiv">
			<div class="float_right">
				<button id="addToRepairExistPjSDInfo"><span title="存在于配件大类中,将配件的状态转为待修状态">添加待修配件</span></button>&nbsp;&nbsp;&nbsp;
			</div>
			<br/>
			<span>检修班组 <span style="color:blue">走行班组</span></span>
			<!-- 数据显示层													开始 -->
			<table class="tableStyle" useMultColor="false" useCheckBox="true" id="tbAddToRPExist">
				<thead>
					<tr>
						<th>序号</th>
						<th>配件编号</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach var="psdi" items="${existPj}" varStatus="pjStatus">
				<tr>
					<td>${pjStatus.index+1 }</td>
					<td>
						<input type="text" name="existPjdCode" value="${psdi.pjdCode}"
							title="配件名称：【${psdi.pjStoreStaticInfo.pjName }】"
						readonly />
					</td>
					<td><button id='delRowOneBtn' onclick='deleteSimple();'><span>删除</span></button></td>
				</tr>
				</c:forEach>
			</table>
			<!-- 数据显示层													结束 -->
		</div>
		<!-- 盒子模型中部								 			结束-->
		<!-- 盒子模型右侧								 							开始-->
		<div class="box2 float_left" panelWidth="30%" panelHeight="520" showStatus="false" panelTitle="动态库不存在配件" id="pjSDNoExistDiv">
			<div class="float_right">
				<button id="addToRepairNotExist"><span title="在配件大类中不存在此配件，需要先进行配件入库">添加待修配件入库</span></button>
			</div>
			<br/>
			<br/>
			<!-- 数据显示层																	开始 -->
			<table class="tableStyle" useMultColor="false" useCheckBox="true" id="tbAddToRPNoExist">
				<tr>
					<th>序号</th>
					<th>配件编号</th>
					<th>操作</th>
				</tr>
				<c:forEach var="notExistPjdCode" items="${notExistPjdCode}" varStatus="notExistPjdCodeStatus">
				<tr>
					<td>${notExistPjdCodeStatus.index+1 }</td>
					<td>
						<input type="text" name="notExistPjdCode" value="${notExistPjdCode}" readonly/>
					</td>
					<td><button id='delRowOneBtn' onclick='deleteSimple();'><span>删除</span></button></td>
				</tr>
				</c:forEach>
			</table>
			<!-- 数据显示层																	结束 -->
		</div>
		<!-- 盒子模型右侧								 							结束-->
		<!--uurframe盒子模型下方						结束-->
	</body>
	<!-- 自定义js 删除行-->
	<script type="text/javascript" src="${ctx}/js/tableUtil/tableUtil.js"></script>
	<!-- 自定义js 全选反选复选框 -->
	<script type="text/javascript" src="${ctx}/test/checkboxUtil/checkboxUtil.js"></script>
	<!-- 自定义js -->
	<script type="text/javascript" src="${ctx}/js/pjFix/pjSDInfoForRepairCheckIframe/pjSDInfoForRepairCheck_script.js"></script>
	<!-- 二级联动 -->
	<script type="text/javascript" src="${urlctx}/js/ganged/ganged.js"></script>

</html>