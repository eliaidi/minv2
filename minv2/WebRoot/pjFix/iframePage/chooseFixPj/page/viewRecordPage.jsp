<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>配件检修-查看记录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	</head>

	<body>
		<div class="" panelTitle="添加待修配件" roller="true" overflow="true">
			<div style="color:red">
				<center>
					<table>
						<th><font color="blue" size="4">交流辅助电机</font>-- <font color="black" size="4">检修记录</font></th>
					</table>
				</center>
			</div>
			<div>
				配件名称：<font color="blue">交流辅助机电</font> &nbsp;&nbsp;&nbsp; 配件编号：
				<font color="blue">404-11-22</font> &nbsp;&nbsp;&nbsp; 现存储位置：
				<font color="blue">中心库-平库    </font>&nbsp;&nbsp;&nbsp; 配件状态：
				<font color="red">合格</font> &nbsp;&nbsp;&nbsp; 检修次数：
				<font color="red">2</font>
				<br/>
			</div>
			<!-- 数据显示层									开始 -->

			<div id="scrollContent">
				<table class="tableStyle">
					<tr>

						<th>修次</th>
						<th>检修时间</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>第-<font color="blue">1</font>-次检修</td>
						<td>2015-07-14 12:30</td>
						<td>
							<a target="_blank" style="color:blue" href="${urlctx}/pjFix/iframePage/choosePj/page/viewRecordFixDetailsPage.jsp">查看详情</a>
						</td>
					</tr>
				</table>
				<br/>
				<br/>
				<br/>
				<center><font size="2"><c:if test="${empty recordList}">~~~ 无相关检修记录信息 ~~~ </c:if></font></center>
			</div>
			<!-- 数据显示层									结束 -->
		</div>
		<!--uurframe盒子模型下方						结束-->

	</body>

</html>