<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>机务检修系统--配件大类--添加待修配件检查-待修配件入库</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

	<body>
		<!--uurframe盒子模型   上方					开始-->
		<!-- 盒子模型								 					开始-->
		<div class="box2" panelWidth="100%" panelHeight="600" showStatus="false" panelTitle="配件入库">
			<form action="addToRepairNotExistPjSDInfo.action" method="post">
				<span>收件人员:张飞</span>
				<div class="float_right">
					<button><span>入库</span></button>
				</div>
				<br/>
				<br/>
				<!-- 数据显示层												开始 -->
				<table class="tableStyle" useMultColor="false" useCheckBox="true" id="tbRepairParts">
					<tr>
						<th>
							<input type="checkbox" name="ckAll" id="ckAll" />序号
						</th>
						<th>配件编号</th>
						<th>车型</th>
						<th>配件大类(静态)</th>
						<th>入库仓库</th>
						<th>生产厂家</th>
						<th>出厂日期</th>
						<th>出厂价格</th>
					</tr>
					<c:forEach var="pjdCode" items="${pjdCodes}" varStatus="pjdCodeStatus">
						<tr>
							<td>
								<input type="checkbox" />&nbsp;${pjdCodeStatus.index + 1 }</td>
							<td>
								<input type="text" value="${pjdCode}" name="pjdCodes"/>
							</td>
							<td>
								<select class="default" name="dictJcTypeId" >
									<c:forEach var="dictJcType" items="${dictJcTypeList}">
										<option value="${dictJcType.id }">${dictJcType.jcTypeValue }</option>
									</c:forEach>
									
								</select>
							</td>
							<td>
								<select name="pjStoreStaticInfoId"  class="default">
									<option value="21">配件所属大类</option>
								</select>
							</td>
							<td>${loginUsers.dictProteam.dictStorePosition.storePositionName }</td>
							<td>
								<input type="text" value="非必填" name="pjdFactory"/>
							</td>
							<td>
								<input type="text" value="" name="pjdOutFactoryDate"/>
							</td>
							<td>
								<input type="text" value="10" name="pjdOutPrice"/>
							</td>
						</tr>
					</c:forEach>

				</table>
				<!-- 数据显示层												结束 -->
				<br>
				<button id="getCheckRow"><span>删除</span></button>
			</form>
		</div>
		<!-- 盒子模型								 					结束-->
		<!--uurframe盒子模型下方						结束-->
	</body>
	<!-- 自定义js 删除行-->
	<script type="text/javascript" src="${ctx}/js/tableUtil/tableUtil.js"></script>
	<!-- 复选框全选 、反选 -->
	<script type="text/javascript" src="${ctx}/test/checkboxUtil/checkboxUtil.js"></script>
	<!-- 自定义js -->
	<script type="text/javascript" src="${ctx}/js/pjFix/addPjSDInfoForRepairChildIframe/addPjSDInfoForRepair_script.js"></script>

	<!-- 二级联动JS -->
	<script type="text/javascript" src="${urlctx }/js/ganged/ganged.js"></script>
</html>