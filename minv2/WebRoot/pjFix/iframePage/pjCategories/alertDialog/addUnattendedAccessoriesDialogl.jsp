<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.repair.entity.PjStoreDynamicInfo"%>
<%@include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>机务检修系统--配件大类--添加待修配件</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
    
    <!-- 引用配件大类js文件				开始 -->
    <script type="text/javascript" src="${ctx}/js/pjFix/addUnattendedAccessoriesDialogl_script.js"></script>
    <!-- 引用配件大类js文件				结束 -->
  
    <script type="text/javascript" src="${ctx}/js/checkboxUtil/checkboxUtil.js"></script>
  	<script type="text/javascript" src="${ctx}/js/tableUtil/tableUtil.js"></script>
  </head>
  
	<body>
		<div class="box_tool_mid padding_right5">
			<div class="center">
				<div class="left">
					<div class="right">
						<div class="padding_top8 padding_left10">
							配件名称：
     						<font color="red">${pjSSInfo.pjName}</font>
	     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     					    检修班组：
     						<font color="red">
	     						<c:forEach var="proteamPjSs" items="${pjSSInfo.proteamPjStatics}">
	     							 ${proteamPjSs.dictProteam.proteamName} &nbsp;&nbsp;&nbsp;
			 				    </c:forEach>
     					   </font>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
			<div class="center">
				<div class="left">
					<div class="right">
						<div class="padding_top5 padding_left10">
								<button id="addPjNum">添加配件编码输入框</button>
								
     							<button class="float_right button" id="addBtn">添加待修配件</button><br>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div>
			<table class="tableStyle" sortMode="false" headFixMode="true" useMultColor="false" useCheckBox="true" id="tbe">
				<tr>
					<th width="10%"><span ><input type="checkbox" id="all"/><button id="del" >删除</button></span></th>
					<th width="40%">配件编码</th>
					<th width="50%">操作</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent">
			<%--动态配件隐藏域Id --%>
			<input type="hidden" id="pjSSInfoId" value="${pjSSInfo.id}"/>
			<table class="tableStyle" useMultColor="false" useCheckBox="true"  id="addUnattendedAccessoriesDialogl_table" >
				<tr>
					
					<td width="10%"><input type="checkbox" name="seq"/>1</td>
					<td width="40%"><input type="text"  name="pjdCode"/></td>
					<td width="50%">
						<button onclick='top.Dialog.open({URL:"toChoosePjSDInfo.action?pjSStInfoId=${pjSSInfo.id}&rowIndex=0",Title:"选动态配件编码",Width:1355,Height:300});'>选择</button>
				    </td>
				</tr>
				
			</table>
		</div>
		
	</body>