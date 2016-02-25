<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>
	<head>
		<title>技术员卡控----需要卡控配件</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
	</head>

	<body>
		<div class="box2" panelTitle="需要卡控配件" roller="false">
			<table>
				<tr>
					<input type="checkbox" id="" />车型 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					<input type="checkbox" id="" />专业 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="checkbox" id="" />配件编号 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					<button>查询</button>
				</tr>
				<tr>
					<td>
						<div id="" style="display: none;">
							车型
							<select autoWidth="true" name="jcType" id="jcTypeId">
								<option value="请选择">请选择</option>
								<option value=''>DF5</option>
								<option value=''>DF12</option>
								<option value=''>SS3B</option>
							</select>
						</div>
					</td>
					<td>
						<div id="" style="display: none;">
							专业
							<select autoWidth="true" name="firstUnitName" id="firstUnitName">
								<option value="请选择">请选择</option>
								<option value=''></option>
							</select>
						</div>
					</td>
					<td>
						<div id="" style="display: none;">
							配件编号
							<input type="text" name="" id="" />
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div>
		   <table>
		       <tr><td>配件名称:<font color="red">抱轴瓦</font></td></tr>
		   </table>
		</div>
		<div>
			<table class="tableStyle"  headFixMode="true" useMultColor="false" useCheckBox="true">
				<tr>
					<th width="5%">序号</th>
					<th width="20%">配件名称</th>
					<th width="8%">机车类型</th>
					<th width="8%">专业</th>
					<th width="8%">状态</th>
					<th width="10%">操作</th>
				</tr>
			</table>
		</div>
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" useMultColor="false" useCheckBox="true">
				
				<tr>
					<td width="5%">1</td>
					<td width="20%">制动器</td>
					<td width="8%">SS3</td>
					<td width="8%">走行</td>
					<td width="8%"><font color="red">检修中</font></td>
					<td width="10%"><a style="color:blue" href="enterTheQRDialong.html">进入签到</a></td>
				</tr>
				<tr>
					<td  width="5%">2</td>
					<td  width="20%">车钩及缓冲器</td>
					<td  width="8%">DF4</td>
					<td width="8%">走行</td>
					<td width="8%"><font color="red">检修中</font></td>
					<!-- target="frmright" -->
					<td  width="10%"><a style="color:blue" href="enterTheQRDialong.html">进入签到</a></td>
				</tr>
				<tr>
					<td  width="5%">3</td>
					<td  width="20%">交流辅助电机</td>
					<td  width="8%">XH5</td>
					<td width="8%">走行</td>
					<td width="8%"><font color="red">检修中</font></td>
					<td  width="10%"><a style="color:blue" href="enterTheQRDialong.html">进入签到</a></td>
				</tr>
				<tr>
					<td width="5%">4</td>
					<td width="20%">真空主断路器</td>
					<td width="8%">G6</td>
					<td width="8%">走行</td>
					<td width="8%"><font color="red">检修中</font></td>
					<td width="10%"><a style="color:blue" href="../qcCheckPage/enterTheQRDialong.html">进入签到</a></td>
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