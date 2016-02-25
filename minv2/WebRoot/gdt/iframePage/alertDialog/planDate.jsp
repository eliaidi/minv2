<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<head>
	<title>机车检修日计划操作</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<script type="text/javascript" src="${ctx}/gdt/generalJs/planDate_script.js"></script>
		<!-- 时间日历控件						开始 -->
		<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
		<!-- 时间日历控件						结束 -->
	
		<script src="${urlctx}mainframe/js/form/validationEngine-cn.js" type="text/javascript"></script>
		<script src="${urlctx}mainframe/js/form/validationEngine.js" type="text/javascript"></script>
</head>
	<body>
		<input type="hidden" id="basePath" value="${urlctx}"/>
		<div class="box1" panelHeight="410" whiteBg="true">
			<form action="${urlctx}zx/saveJcPlanDate.do" method="post"  id="subform" target="frmContent">
				<input type="hidden" name="id" value="${planDate.id}"/>
				<table width="100%">
					<tr>
						<td width="40%">
							<div style="text-align: right; margin-right: 20px;"  >车型：</div>
						</td>
						<td>
							<input type="text" id="jcTypeValue" value="${planDate.jcTypeValue}" name="jcTypeValue" class="validate[required]"/>
							<input id="jccurriculum" type="button" value="选择"  />&nbsp;<input id="jcweekplan" type="button" value="周计划"/>
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">车号：</div>
						</td>
						<td>
							<input type="text" id="jcNumber" name="jcNumber" value="${planDate.jcNumber}" class="validate[required]"/>
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;" class="validate[required]">修程：</div>
						</td>
						<td>
							
							<input type="hidden" name="jcFixMileageId" id="fixMileageId"/> 
							<input type="hidden" name="extraFixMileageId" id="extraFixMileageId"/>
							<input type="hidden"  id="extraFixMileage"/>  
							<input type="text" id="fixMileageValue"  value="${planDate.dictJcFixMileage.fixMileageValue}"  class="validate[required]" readonly="readonly"/>
							<input id="jcFixFreque" type="button" value="选择" />&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">股道：</div>
						</td>
						<td>
							<input type="text" id="stationRacksNumber" name="stationRacksNumber" value="${empty param.stationRacksNumber ? planDate.stationRacksNumber : param.stationRacksNumber }" class="validate[required]" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">台位：</div>
						</td>
						<td>
							<input type="text" id="stationNmber" name="stationNmber" value="${empty param.stationNmber ? planDate.stationNmber : param.stationNmber }" class="validate[required]" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">计划扣车时间：</div>
						</td>
						<td>
							<input type="text" class="Wdate"  id="jcDetainTime" name="jcDetainTime" style="width:120px" value='<%=new SimpleDateFormat("yyyy-MM-dd 07:00").format(new Date())%>'/>
							如,2012-12-14 04:51
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">计划起机时间：</div>
						</td>
						<td>
							<input type="text" class="Wdate" onfocus="jcPlanStarTime" name="jcPlanStarTime" style="width:120px" value='<%=new SimpleDateFormat("yyyy-MM-dd 13:30").format(new Date())%>'/>
							如,2012-12-14 04:51
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">计划交车时间：</div>
						</td>
						<td>
							<input type="text" class="Wdate" onfocus="jcPlanReceiveTime" name="jcPlanReceiveTime" style="width:120px" value='<%=new SimpleDateFormat("yyyy-MM-dd 16:30").format(new Date())%>'/>
							如,2012-12-14 04:51
						</td>
					</tr>
					<tr>
						<td><div style="text-align: right; margin-right: 20px;">备注: </div></td>
						<td>
						<textarea name="remark" rows="4" cols="10"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<div style="text-align: right; margin-right: 20px;">交车工长：</div>
						</td>
						<td>
							<select name="aaaid" class="default" style="width:80px" id="jcgz">
								<option value="">请选择</option>
									<option value=""></option>
							</select>
							<font color="red">*可以不指定</font>&nbsp;
							<input type="checkbox" id="choiceProteam"/>指定包修班组
						</td>
					</tr>
					<tr style="display: none;" id="showProteam">
						<td>
							<div style="text-align: right; margin-right: 20px;">负责包修班组：</div>
						</td>
						<td>
							<select name="datePlan.proteamId" class="default" style="width:80px" id="proteamId" onchange="setWorkTeamVal();">
								<option value="">请选择</option>
								<c:forEach var="entry" items="${proteams}">
									<option value="${entry.proteamid}">${entry.proteamname}</option>
								</c:forEach>
							</select><font color="red">*整台车由该班组包修</font>
						</td>
					</tr>
					<tr style="display: none;" id="showProteam2">
						<td>
							<div style="text-align: right; margin-right: 20px;">不包修班组：</div>
						</td>
						<td>
							<select multiple id="mulSelect" autoWidth="true" style="width:200px;" onchange="setWorkTeamVal();"> 
								<c:forEach var="entry" items="${proteams}">
								    <c:choose>
								       <c:when test="${entry.proteamname=='制动组'||entry.proteamname=='探伤组'}">
								          <option value="${entry.proteamid}" selected="selected">${entry.proteamname}</option>
								       </c:when>
								       <c:otherwise>
								          <option value="${entry.proteamid}">${entry.proteamname}</option>
								       </c:otherwise>
								    </c:choose>
								</c:forEach>
							</select><font color="red">*指定班组不进行包修</font>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" id="subtn" value=" 提 交 "/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</body>
