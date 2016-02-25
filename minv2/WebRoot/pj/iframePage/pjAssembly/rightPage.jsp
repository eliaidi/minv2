<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		<title>右边菜单页面，显示配件</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
		<script type="text/javascript" src="${urlctx }js/zDialog_split/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx }js/zDialog_split/zDialog.js"></script>
		<!--引入弹出窗组件end-->
		<script type="text/javascript" src="${urlctx }js/table/treeTable.js"></script>
		
		<script>
			function btnClick()
			{
				
				top.Dialog.open({URL:"${urlctx}/pj/iframePage/pjAssembly/addAssemblyPj.jsp",Title:"添加配件编号 ",Width:450,Height:350});
			}
		</script>
		
	</head>

	<body>
	    <input	type="hidden" value="${urlctx}"/>
		<div class="box2" panelHeight="520"  panelTitle="右侧页面">
		<table class="treeTable">
			<tr>
				<th width="5%"></th>
				<th width="10%">专业</th>
				<th width="20%">配件名</th>
				<th width="20%">组装</th>
				<th width="20%">操作</th>
				<th width="25%">组装人</th>
			</tr>
			<tr id="node-1" class="parent collapsed">
				<td><span class="folder"><input type="checkbox" name="chekName"/></span></td>
				<td>制动</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr id="node-8" class="child-of-node-1">
				<td></td>
				<td></td>
				<td>单阀</td>
				<td>
					<button id="btn" onclick="btnClick();"><span class="icon_mark">组装</span></button>
				</td>
				<td><a href="#">禁止</a>&nbsp;&nbsp;<a href="#">修改</a></td>
				<td></td>
			</tr>
			<tr id="node-9" class="child-of-node-2">
				<td></td>
				<td></td>
				<td>副阀</td>
				<td>组装数-<font color="red">2</font>-</td>
				<td><a href="#">禁止</a>&nbsp;&nbsp;<a href="#">修改</a></td>
				<td>张飞 2016-01-08 10:11:15</td>
			</tr>
		</table>
		</div>
		<div style="height:35px;">

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
					<span><a href="javascript:;">下一页</a></span> 每页
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
		
	</body>
	
</html>