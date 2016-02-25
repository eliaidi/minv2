<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-报活记录页面(报活)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link href="${ctx }/js/zx/css/reportRecord.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="${ctx }/js/zx/js/reportRecord_script.js"></script>
	</head>

	<body bgcolor="#f8f7f7">
		<div id="scoll_div_id" style="background:#328aa4;width:1000px;height:23px;">
			<ul id="nav">
				<li><a href="">◇整车记录 </a></li>
				<li><a href="javascript:void(0);">◇整车记录 </a>
					<ul>
						<li><a href="">整车检修记录</a></li>
						<li><a href="">检修配件记录</a></li>
					</ul>
				</li>
				<li><a href="javascript:void(0);">◇机车部件</a>
					<ul>
						<li>
							<a href=""></a>
						</li>
					</ul>
				</li>
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
						<li>
							<a href=""></a>
						</li>
					</ul>
				</li>
				<li><a href="">◇交车试验</a></li>

				<li><a href="javascript:void(0);">◇试验记录</a>
					<ul>
						<li><a href="">水阻试验</a></li>
						<li><a href="">顶轮试验</a></li>
						<li><a href="">高低压试验</a></li>
						<li><a href="">试运行试验</a></li>
					</ul>
				</li>
				<li><a href="">◇配件记录</a></li>
				<li><a href="">◇配件记录</a></li>
				<li><a href="">◇探伤记录</a></li>
				<li><a href="">◇未完成记录 </a></li>
				<li><a href="" style="background-color:#fff;color:blue;">◇报活记录</a></li>
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
		<br>
		<br>
		<!-- 浮动导航菜单end -->
		<div style="width:870px;margin-left:-435px;left:50%;position:absolute;" id="content2">
			<table width="864" border="0" align="center" cellspacing="0" style="padding-top:10px;">

				<tr>
					<td colspan="6" align="center" height="40">
						<h2 align="center">
					<font style="font-family:'隶书'">
						<b>报活记录</b></font></h2></td>
				</tr>

				<tr>
					<td width="163" align="right">机车号：</td>
					<td width="240"></td>
					<td width="55" align="left">修程：</td>
					<td width="251"></td>
					<td width="140" align="left">检修日期：</td>
					<td width="195" align="left"></td>
				</tr>

				<tr>
					<td colspan="6">
						<table width="884" border="0" align="center" cellspacing="0" style="margin-top: 10px;" id="content">
							<tr>
								<td align="center" colspan="3" class="tbCELL3" style="background-color: #328aa4;">
									<span style="margin: 0 20px 0 20px;;color:#ffffff;">JT28报活:&nbsp;&nbsp;xxx</span>
									<span style="margin: 0 20px 0 20px;;color:#ffffff;">复检报活:&nbsp;&nbsp;xxx</span>
									<span style="margin: 0 20px 0 20px;;color:#ffffff;">检修过程报活:&nbsp;&nbsp;xxx</span>
									<span style="margin: 0 20px 0 20px;;color:#ffffff;">零公里检查:&nbsp;&nbsp;xxx</span>
								</td>
							</tr>

							<tr height="5px">
								<td></td>
							</tr>

							<tr>
								<td align="center" class="tbCELL3">
									<table width="890" border="0" align="center" cellspacing="0" id="datatabel">
										<tr style="line-height:40px;height: 40px;background-color: #328aa4;font-weight: bolder;">
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="10%">报活类别</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="8%">检修班组</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="18%">报活内容</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="6%">报活人</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="9%">报活时间</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="10%">检修完成时间</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="10%">检修情况</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="8%">检修人</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="8%">工长</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="7%">质检员</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="7%">技术员</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="7%">交车工长</td>
											<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="7%">验收员</td>
										</tr>
										<tr>
											<td class="tbCELL1" align="center" name="preType">xxx</td>
											<td class="tbCELL1" align="center" name="proteam">xxx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
											<td class="tbCELL1" align="center">xx</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</body>

</html>