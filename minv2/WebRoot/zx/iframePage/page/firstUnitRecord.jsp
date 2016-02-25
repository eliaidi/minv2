<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-专业记录页面(专业)</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link href="${ctx }/js/zx/css/firstUnitRecord.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="${ctx }/js/zx/js/firstUnitRecord_script.js"></script>
	</head>

	<body bgcolor="#f8f7f7">
		<!-- 浮动导航菜单start -->
		<div id="scoll_div_id" style="background:#328aa4;width:730px;height:23px;margin-left:100px;">
			<ul id="nav">
				<li><a href="javascript:void(0);">◇整车记录 </a>
					<ul>
						<li><a href="">整车检修记录</a></li>
						<li><a href="">检修配件记录</a></li>
					</ul>
				</li>
				<li><a href="" style="background-color:#fff;color:blue;">◇机车部件</a>
					<ul>
					<c:forEach items="${recMap}" var="m">
						<li>
							<a href="">${m.key.firstUnitName }</a>
						</li>
					</c:forEach>
					</ul>
				</li>
				<li><a href="">◇检修班组</a>
					<ul>
						<li>
							<a href=""></a>
						</li>
					</ul>
				</li>
				<li><a href="javascript:void(0);">◇试验记录</a>
					<ul>
						<li><a href="">水阻试验</a></li>
						<li><a href="">顶轮试验</a></li>
						<li><a href="">高低压试验</a></li>
						<li><a href="">试运行试验</a></li>
					</ul>
				</li>
				<li><a href="">◇配件记录</a></li>
				<li><a href="">◇探伤记录</a></li>
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
		<!-- 浮动导航菜单end -->
		<form id="form1">
			<div style="width:960px;margin-left:-475px;left:50%;position:absolute;" id="content2">
				<table width="960" border="0" align="center" cellspacing="0" vspace="0" style="padding-top:10px;">
					<tr>
						<td colspan="6" align="center" height="40">
							<h2 align="center"><font style="font-family:'隶书'">
								<b>${pd.jcTypeValue}-${pd.jcNumber}-专业检修记录</b></font>
							</h2>
						</td>
						<td align="right"></td>
					</tr>
					<tr>
						<td width="163" align="right">机车号：${pd.jcNumber }</td>
						<td width="240"></td>
						<td width="55" align="left">修程：${pd.dictJcFixMileage.fixMileageValue }</td>
						<td width="251"></td>
						<td width="240" align="left">检修日期：${fn:substring(pd.jcDetainTime ,0,16) }</td>
						<td width="195" algin="left"></td>
					</tr>
					<tr>
						<td colspan="6">
							<table width="960" border="1" align="center" cellspacing="0" vspace="0" id="content">
								<tr>
									<td align="center" colspan="3" class="tbCELL3">
										<table width="960" border="1" align="center" cellspacing="0" vspace="0" id="datatabel" style="font-size:10pt;">
											<tr style="line-height:50px;height:30px;background-color: #328aa4;font-weight: bolder;">
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="8%">部位</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="20%">检修项目</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="10%">所处节点</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="13%">检修/探伤情况</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="10%">配件编号</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="10%">检修/探伤人</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="8%">工长</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="6%">质检员</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="6%">技术员</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="6%">交车工长</td>
												<td class="tbCELL1" align="center" style="white-space:nowrap;color:#ffffff;" width="6%">验收员</td>
											</tr>
											
											<c:forEach items="${recMap}" var="m" begin="0" end="0">
												<tr>
												<td class="tbCELL1" align="center" rowspan="${fn:length(m.value)}">${m.key.firstUnitName }</td>
											</tr>
											<c:forEach items="${m.value}" var="rec" begin="0">
											<tr>
												<td class="tbCELL1" align="center" >${rec.fixItem.itemName }</td>
												<td class="tbCELL1" align="center">${rec.fixFlow.fixFlowName }</td>
												<td class="tbCELL1" align="center">${rec.fixCondition }</td>
												<td class="tbCELL1" align="center"></td>
												<td class="tbCELL1" align="center">${rec.fixUsersIds }</td>
												<td class="tbCELL1" align="center">
													<c:if test="${rec.leadCheck == 1}">
														${rec.leadUsers }${rec.leadUsersCheckTime }
													</c:if>
												</td>
												<td class="tbCELL1" align="center">
													<c:if test="${rec.qcCheck == 1}">
														${rec.qcUsers }${rec.qcCheckTime }
													</c:if>
												</td>
												<td class="tbCELL1" align="center">
													<c:if test="${rec.technicianCheck == 1}">
														${rec.technicianUsers }${rec.technicianCheckTime }
													</c:if>
												</td>
												<td class="tbCELL1" align="center">
													<c:if test="${rec.commitLeadCheck == 1}">
														${rec.commitLeadUsers }${rec.commitLeadCheckTime }
													</c:if>
												</td>
												<td class="tbCELL1" align="center">
													<c:if test="${rec.acceptanceCheck == 1}">
														${rec.acceptanceUsers }${rec.acceptanceCheckTime }
													</c:if>
												</td>
											</tr>
											</c:forEach>
											</c:forEach>
											<tr>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
			</div>
		</form>
	</body>

</html>