<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
		<!-- 引进打印功能 外部插件			开始 -->
		<script type="text/javascript" src="${ctx}/js/pjFix/printData/printJs/jquery.jqprint-0.3.js"></script>
		<script type="text/javascript" src="${ctx}/js/pjFix/pjSDIRecordFixCheckDetailsDialog_script.js"></script>
	    <!-- 引进打印功能 外部插件			结束 -->
	</head>

	<body>
	<div id="print">
		<div class="" panelTitle="添加待修配件" roller="true" overflow="true">
			<div>
				<center>
					<table>
						<th> <font color="blue">${pjSDR.pjStoreDynamicInfo.pjStoreStaticInfo.pjName} </font>-- 检修记录详情</th>
					</table>
				</center>
			</div>
			<div>
				配件名称：<font color="red">${pjSDR.pjStoreDynamicInfo.pjStoreStaticInfo.pjName}</font> &nbsp;&nbsp;&nbsp;&nbsp;
				 配件编号：
				<font color="red">${pjSDR.pjStoreDynamicInfo.pjdCode}</font> &nbsp;&nbsp;&nbsp;&nbsp;
				 现存储位置：
				<font color="red">
	     			${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionName} 
			    </font>
			     	--- 
		     	<font color="red">
		     		 <c:if test="${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType==0}">平库</c:if>
					 <c:if test="${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType==1}">立库</c:if>
					 <c:if test="${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType==2}">班组库</c:if>
					 <c:if test="${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType==3}">车上</c:if>
					 <c:if test="${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType==4}">配件上</c:if>
					 <c:if test="${pjSDR.pjStoreDynamicInfo.dictStorePosition.storePositionType==5}">外地</c:if>
				</font>&nbsp;&nbsp; &nbsp;&nbsp;
				 配件状态：
				 	 <c:forEach var="pjsdInfoStatuEntry" items="${pjSDInfoPjdStatusMap}">
		        		<c:if test="${pjsdInfoStatuEntry.key == pjSSInfo.pjdStatus }">
		        			${pjsdInfoStatuEntry.value }
		        		</c:if>
	        		</c:forEach>
				<font color="red">合格</font> &nbsp;&nbsp; &nbsp;&nbsp;
				 检修项目：
				<font color="red">${fn:length(pjSDR.pjSDInfoRecordFixs) }</font>项&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button  onclick='top.Dialog.open({URL:"findPjSDRByPjSDIdForPjFix.action?pjSDInfoId=${pjSDR.pjStoreDynamicInfo.id}",Title:"查看子配件",Width:600,Height:300});'>查询子配件</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="float_right">
					<button id="go">打印</button>
				</div>
				<br>
			</div>

			<!-- 数据显示层									开始 -->

			<div id="scrollContent">
				<table class="tableStyle">
					<tr>
						<th>项目名称</th>
						<th>部位</th>
						<th>检修/探伤情况</th>
						<th>检修/探伤人</th>
						<th>工长</th>
						<th>交车工长</th>
						<th>质检员</th>
						<th>技术员</th>
						<th>验收员</th>
					</tr>
					<tr>
						<td>绕阻对地绝缘</td>
						<td>一端</td>
						<td>15</td>
						<td>张飞 2013-07-14 12:5</td>
						<td>关羽 2013-07-14 13:9</td>
						<td>刘备 2013-07-14 14:9</td>
						<td>孙权 2013-07-14 15:9</td>
						<td>孙尚香 2013-07-14 16:9</td>
						<td>/</td>
					</tr>
				</table>
			</div>
			<!-- 数据显示层									结束 -->

			<!-- 分页数据显示层									开始 -->
			<div style="height:35px;">
				<div class="float_left padding5">

				</div>
				<div class="float_right padding5 paging">
					<div class="float_left padding_top4">
						<span class="paging_disabled"><a href="javascript:;">上一页</a></span>
						<span class="paging_current"><a href="javascript:;">1</a></span>
						<span><a href="javascript:;">2</a></span>
						<span><a href="javascript:;">3</a></span>
						<span><a href="javascript:;">4</a></span>
						<span><a href="javascript:;">5</a></span>
						<span>...</span>
						<span><a href="javascript:;">20</a></span>
						<span><a href="javascript:;">下一页</a></span>&nbsp;每页
					</div>
					<div class="float_left">
						<select autoWidth="true">
							<option>50</option>
							<option>100</option>
							<option>150</option>
						</select>
					</div>
					<div class="float_left padding_top4">条记录</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!-- 分页数据显示层									结束 -->
		</div>
		<!--uurframe盒子模型下方						结束-->
	</div>
	</body>

</html>