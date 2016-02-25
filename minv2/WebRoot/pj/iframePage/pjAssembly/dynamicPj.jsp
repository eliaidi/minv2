<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		<title>点击选择按钮，弹出配件静态信息记录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	</head>

	<body>
		<div class="box1"  roller="false" >
			<table class="tableStyle" width="100%" align="center">
				<tr>
					<td>配件编号：</td>
					<td>
						<input type="text" name="pjNumber" />
					</td>
					<td>配件名称：</td>
					<td>
						<input type="text" name="pjName" />
					</td>
					<td>
						<button><span class="icon_find">查询</span></button>
					</td>
				</tr>
				<tr>
					<td colspan="7">
						配件名称:<font color="blue">单阀</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 所属静态配件:
						<font color="blue">单阀</font>
					</td>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray" style="width:600px">
			<table class="tableStyle" style="width:600px" usecheckbox="false">
				<tr>
					<th width="5%">选择</th>
					<th width="30%">配件编号</th>
					<th width="40%">存储位置</th>
					<th width="25%">检修记录</th>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkName" />
					</td>
					<td>PJJ565922</td>
					<td>中心库</td>
					<td><a href="#">记录</a></td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkName" />
					</td>
					<td>SD589655</td>
					<td>中心库</td>
					<td><a href="#">记录</a></td>
				</tr>
				<tr align="right">
					<td colspan="4">
						<button>确定</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button>取消</button>
					</td>

				</tr>
			</table>
		</div>

		<div style="height:35px;width:500px">
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