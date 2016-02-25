<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-交车</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="${ctx}/js/zx/css/handCar.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="${ctx}/js/zx/js/handCar_script.js"></script>

		<!-- 打印插件 -->
		<script type="text/javascript" src="<%=basePath %>js/LodopFuncs.js"></script>
		<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
			<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
		</object>
		<!-- 打印end -->

	</head>

	<body>
		<!-- 浮动导航菜单start -->
		<div id="scoll_div_id" style="background:#328aa4;width:864px;height:23px;margin-left:280px;">
			<ul id="nav">
				<li><a href="<%=basePath%>query!getInfoByJC.do?rjhmId=${datePlan.rjhmId}&psize=100">◇整车记录 </a></li>
				<li><a href="javascript:void(0);">◇机车部件</a>
					<ul>
						<li>
							<a href=""></a>
						</li>
					</ul>
				</li>
				<li><a href="javascript:void(0);">◇检修班组</a>
					<ul>
						<li>
							<a href=""></a>
						</li>
					</ul>
				</li>
				<li><a href="" style="background-color:#fff;color:blue;">◇交车试验</a></li>
				<li><a href="">◇配件记录</a></li>
				<li><a href="">◇未完成记录 </a></li>
				<li><a href="">◇报活记录</a></li>
				<li><a href="">◇交车竣工 </a></li>
				<li><a href="javascript:void(0);" onclick="SaveAsFile();">◇记录导出 </a></li>
				<li><a href="javascript:void(0);">◇打印 </a>
					<ul>
						<li><a href="javascript:void(0);" onclick="setup();">打印设置</a></li>
						<li><a href="javascript:void(0);" onclick="preview();">打印预览</a></li>
						<li><a href="javascript:void(0);" onclick="print();">直接打印</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<br/>
		<br/>
		<!-- 浮动导航菜单end -->
		<div id="scrollContent" style="margin-top: 50px;margin-left:280px;text-align: center;font-size: 14px;">
			<div style="background-color:#328AA4;width:1000px;height:50px;font-size: 20px;font-weight: bold;align:center;">
				<div style="float:left;padding-top: 20px;padding-left: 400px; color: #fff;">交车检测项目</div>
				<%--
				<div style="float:left;padding-top: 20px;padding-left: 350px;"><button class="icon_xls" onclick="excelExport(${rjhmId});">EXCEL导出</button></div>
				 --%>
			</div>
			<table id="tbspan_" class="bluetable" style="width: 1000px;text-align: center;margin-bottom: 10px;" border="1">
				<tr>
					<th colspan="20" align="center" style="font-weight: bold;"></th>
				</tr>
				<tr>
					<th width="20%">项目</th>
					<th width="5%" style="font-weight: normal;font-size: 12px;"></th>
				</tr>
				<tr>
					<th>情况/xxxx</th>
					<td></td>
				</tr>
				<tr>
					<th>检修人</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>质检/技术</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>验收</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>交车工长</th>
					<td>xxxx</td>
				</tr>
			</table>
			<table id="tbspan_" class="bluetable" style="width: 1000px;text-align: center;margin-bottom: 10px;" border="1">
				<tr>
					<th colspan="20" align="center" style="font-weight: bold;">xxxx</th>
				</tr>
				<tr>
					<th width="20%">项目</th>
					<th width="5%" style="font-weight: normal;font-size: 12px;">xxxx</th>
				</tr>
				<tr>
					<th>情况</th>
					<td>xxxx
						<br/>xxxx</td>
				</tr>
				<tr>
					<th>检修人</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>质检/技术</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>验收</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>交车工长</th>
					<td>xxxx</td>
				</tr>
			</table>
			<table id="tbspan_" class="bluetable" style="width: 1000px;text-align: center;margin-bottom: 10px;" border="1">
				<tr>
					<th colspan="7" align="center" style="font-weight: bold;">$xxxx</th>
				</tr>
				<tr>
					<th width="20%">项目</th>
					<th style="font-weight: normal;">xxxx</th>
				</tr>
				<tr>
					<th>情况</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>检修人</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>质检/技术</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>验收</th>
					<td>xxxx</td>
				</tr>
				<tr>
					<th>交车工长</th>
					<td>xxxx</td>
				</tr>
			</table>
		</div>
	</body>

</html>