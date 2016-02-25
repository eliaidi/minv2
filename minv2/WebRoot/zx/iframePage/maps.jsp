<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="/common/common.jsp" %>
<html>

	<head>
		<title>${cache['SYS_TITLE'][0].value}-机车信息和股道图</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="this is my page" />
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

		<script type="text/javascript" src="${urlctx}js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${urlctx}js/lhgdialog/lhgdialog.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/attention/zDialog/zDialog.js"></script>
		<link href="${urlctx}js/zx/css/maps.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${urlctx}js/zx/js/maps_script.js"></script>
		<script type="text/javascript" src="${urlctx}mainframe/js/nav/switchable.js"></script>
		
	</head>

	<body>
		
		<input type="hidden" value="${urlctx }" id="basePath" />
		<div id="tabs1" class="tabs-trigger">
			<div class="tabs-triggerLeft">
				<div class="tabs-triggerRight">
					<c:forEach items="${planMap}" var="m" varStatus="status">
						<a href="#tabs_${status.index}">${projectTypeMap[m.key]}</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<table>
			<tr>
				<!--左侧区域start-->
				<td >
					<div id="panels1" class="tabs-panel" style="width:519px;height: 610px;">
						
						<c:forEach items="${planMap}" var="m" varStatus="status">
							<div class="padding_left10" >
								<table style="width:100%;" cellspacing="0" cellpadding="0" class="bluetable">
									<tr>
										<th width="5%">序号</th>
										<th width="20%">车号</th>
										<th width="10%">股道</th>
										<th width="20%">扣车时间</th>
										<th width="10%">交车工长</th>
										<th width="10%">状态</th>
										<th width="15%">操作</th>
									</tr>
									<c:forEach var="plan" items="${m.value }" varStatus="planIndex">
									
										<tr>
											<td align="center">${planIndex.index+1}</td>
											<td align="center">
												<a href="#" >${plan.jcTypeValue }-${plan.jcNumber }-${plan.dictJcFixMileage.fixMileageValue}</a>
											</td>
											<td align="center">${plan.stationRacksNumber }</td>
											<td align="center">${fn:substring(plan.jcDetainTime ,0,16) }</td>
											<td align="center">
												<%-- 判断是否有交车工长 --%>
												<c:if test="${empty plan.commitLeadUsers}">/</c:if>
												<c:if test="${not empty plan.commitLeadUsers}">${plan.commitLeadUsers.userName}</c:if>
											</td>
											<td align="center">
												<%-- 确定所属状态 --%>
												${planStatus[plan.jcPlanStatus] }
											</td>
											<td>
												<div class="simpleMenu" style="width:92px;">
													<div class="simpleMenu_link arrow border" style="z-index: -1;position: static;">
														<a href="javascript:;" style="position: static;">全部操作</a>
													</div>
													<div class="simpleMenu_con" style="width:100px;z-index: 1;position: static;">
														<a href="" target="" style="position: static;"><span class="icon_lightOn">油水化验</span></a>
														<a href="javascript:void(0)" target="" onclick="report(${plan.id})" style="position: static;"><span class="icon_poll">报活</span></a>
														<%--未接车时显示删除和接车 --%>
														<c:if test="${plan.jcPlanStatus == 1 }">
															<a href="javascript:void(0)" onclick="findJcPlanDateById(${plan.id})" style="position: static;"><span class="icon_edit">修改计划</span></a>
															<a href="javascript:void(0)" onclick="deleteDatePlan(${plan.id})" style="position: static;"><span class="icon_remove">删除</span></a>
															<a href="javascript:void(0)" onclick="pickCarJcPlanDate(${plan.id})" style="position: static;"><span class="icon_mark">接车</span></a>
														</c:if>
														<a href="${urlctx}zx/iframePage/page/commitLead/commitLeadWorkerRatify.jsp?planDateId=${plan.id}" target="jcgz_gdt" style="position: static;"><span class="icon_pencil">卡控签字</span></a> 
														<%--
														<a href="javascript:void(0);" onclick="" style="position: static;"><span class="icon_user">超修派工</span></a>
														<a href="" target="jcgz_gdt" style="position: static;"><span class="icon_reload">交车试验</span></a>
							                			<a href="" target="jcgz_gdt" style="position: static;"><span class="icon_ok">竣工交车</span></a>
														<a href="" target="jcgz_gdt" style="position: static;"><span class="icon_star">中修试验</span></a>
														<a href="" target="jcgz_gdt" style="position: static;"><span class="icon_key">机车转出</span></a>
														 --%>
													</div>	
												</div>
											</td>
										</tr>
										
									</c:forEach>
									
								</table>
							</div>
						</c:forEach>
						
					</div>
				</td>
				<!--左侧区域end-->
				<!--右侧区域start-->

				<td width="65%">
					<iframe id="jcgz_gdt" name="jcgz_gdt" scrolling="auto" overflow="auto" width="851px" height="620px" frameBorder=0 src="${urlctx}gdt/iframePage/changsha_gdt/changsha_gdt.jsp" allowTransparency="true"></iframe>
				</td>

				<!--右侧区域end-->
			</tr>
		</table>
	</body>
</html>