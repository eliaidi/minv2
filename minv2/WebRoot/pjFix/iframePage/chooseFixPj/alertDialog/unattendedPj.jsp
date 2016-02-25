<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<html>

	<head>
		<title>配件检修-待修配件</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	</head>
	  <body>
	       <div class="box2" panelTitle="选择配件" roller="false">
			<table>
				<tr>
				         配件名称：<font color="red">抱轴瓦</font>
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" id=""/>车型
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="checkbox" id=""/>状态
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="checkbox" id=""/>配件编号
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<button>查询</button>
					
					
				       
				</tr>
				<tr>
					<td >
						<div id="" style="display: none;">
							车型 
							<select autoWidth="true"  name="jcType" id="jcTypeId">
								<option value="请选择">请选择</option>
									<option value='' >DF5</option>
									<option value='' >DF12</option>
									<option value='' >SS3B</option>
							</select>
						</div>
					</td>
					<td >
						<div id="" style="display: none;">
							状态 
							<select autoWidth="true"  name="" id="">
								<option value="请选择">请选择</option>
									<option value='' ></option>
							</select>
						</div>
					</td>
					<td >
						<div id="" style="display: none;">
							配件编号
							<input type="text"   name="" id="" />
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle">
				<tr>
					<th width="5%">序号</th>
					<th width="15%">配件编码</th>
					<th width="10%">专业</th>
					<th width="15%">存放位置</th>
					<th width="10%">状态</th>
					<th width="10%">操作</th>
				</tr>
				<tr>
					<td>1</td>
					<td>404-11-33</td>
					<td>走行</td>
					<td>走行班组库</td>
					<td>待修</td>
					<td><button  onclick='top.Dialog.confirm("您确定检修当前配件吗？")'> 选择检修</button>
					    <button  onclick='top.Dialog.open({URL:"../alertDialog/outsourcingMaintenanceDialong.html",Title:"委外检修信息输入框",Width:600,Height:300});'> 委外检修</button>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>404-11-44</td>
					<td>走行</td>
					<td>走行班组库</td>
					<td>待修</td>
					<td><button  onclick='top.Dialog.confirm("您确定检修当前配件吗？")'> 选择检修</button>
					    <button  onclick='top.Dialog.open({URL:"../alertDialog/outsourcingMaintenanceDialong.html",Title:"委外检修信息输入框",Width:600,Height:300});'> 委外检修</button>
					</td>				</tr>
				<tr>
					<td>3</td>
					<td>404-11-55</td>
					<td>走行</td>
					<td>走行班组库</td>
					<td>待修</td>
					<td><button  onclick='top.Dialog.confirm("您确定检修当前配件吗？")'> 选择检修</button>
					    <button  onclick='top.Dialog.open({URL:"../alertDialog/outsourcingMaintenanceDialong.html",Title:"委外检修信息输入框",Width:600,Height:300});'> 委外检修</button>
					</td>
				</tr>
				
			</table>
		</div>
	
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
				<span><a href="javascript:;">下一页</a></span> 每页
				</div>
				<div class="float_left"><select autoWidth="true"><option>50</option><option>100</option><option>150</option></select></div>
				<div class="float_left padding_top4">条记录</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	  </body>
</html>
