<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<head>
		<title>机车记录查询目录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		
		<script type="text/javascript" src="${ctx}/gdt/changsha_gdt/js/jcinfodetail_script.js"></script>
		
		 <link rel="stylesheet" type="text/css" href="${ctx}/gdt/changsha_gdt/css/jcinfodetail.css" />
			
	</head>

<body>
<center>
<table class="tableStyle" style="width:550px;" id="infotable">
	<tr>
		<th align="center">车型</th>
		<th align="center">车号</th>
		<th align="center">修程</th>
		<th align="center">扣车时间</th>
		<th align="center">计划起机时间</th>
		<th align="center">计划交车时间</th>
		<th align="center">检修状态</th>
	</tr>
	<tr>
		<td>DF4</td>
		<td>1000</td>
		<td>X1</td>
		<td><%=new SimpleDateFormat("yyyy-MM-dd 07:00").format(new Date())%></td>
		<td>2015-12-3</td>
		<td>2015-12-4</td>
		<td>接车</td>
	</tr>
</table>
<table class="tableStyle" style="width:550px;" id="jcinfo">
	<tr>
		<td>
		<c:choose>
			<c:when test="${datePlan.fixFreque=='LX' || datePlan.fixFreque=='JG'|| datePlan.fixFreque=='ZZ'}">
				<a href="<%=basePath %>query!getInfoByJC.do?jcStype=${datePlan.jcType }&jcNum=${datePlan.jcnum }&xcxc=${datePlan.fixFreque }&rjhmId=${datePlan.rjhmId }" target="_blank">机车</a>
			</c:when>
			<c:when test="${datePlan.fixFreque=='QZ' || datePlan.fixFreque=='CJ'}">
				<a href="<%=basePath %>query!view.do?jcStype=${datePlan.jcType }&jcNum=${datePlan.jcnum }&xcxc=${datePlan.fixFreque }&rjhmId=${datePlan.rjhmId }" target="_blank">机车</a>
			</c:when>
			<c:otherwise>
				<c:if test="${datePlan.projectType==0}">
				  <a href="<%=basePath %>query!view.do?rjhmId=${datePlan.rjhmId }" target="_blank">专业</a>
				  <a href="<%=basePath %>query!getInfoByBZ.do?workFlag=1&rjhmId=${datePlan.rjhmId }" target="_blank">班组</a>
				  <a href="<%=basePath %>query!getInfoByJC.do?rjhmId=${datePlan.rjhmId }&psize=100" target="_blank">机车</a>
				</c:if> 
				<c:if test="${datePlan.projectType==1}">
				  <a href="<%=basePath %>query!zxView.do?rjhmId=${datePlan.rjhmId}" target="_blank">专业</a>
				  <a href="<%=basePath %>query!getZxInfoByBZ.do?workFlag=1&rjhmId=${datePlan.rjhmId}" target="_blank">班组</a>
				  <a href="<%=basePath %>query!getZxInfoByJC.do?rjhmId=${datePlan.rjhmId}&psize=100" target="_blank">机车</a>
				</c:if>
			</c:otherwise>
		</c:choose>
		<a href="../jsp/history.jsp" target="_blank">历史</a>
		<a href="<%=basePath %>query!getAllInfoPre.do?rjhmId=${datePlan.rjhmId }" target="_blank">报活</a>
		<a href="<%=basePath %>query!searchJCjungong.do?rjhmId=${datePlan.rjhmId }" target="_blank">竣工</a>
		<c:if test="${datePlan.projectType==0}">
		  <a href="<%=basePath %>query!searchJcRec.do?rjhmId=${datePlan.rjhmId }&jcStype=${datePlan.jcType }" target="_blank">交车</a>
		</c:if>
		<c:if test="${datePlan.projectType==1}">
		  <a href="<%=basePath %>query!viewExperiment.do?id=${datePlan.rjhmId}&jceiId=5" target="_blank">交车</a>
		</c:if>
		<a href="<%=basePath %>oilAssay!searchOilAssayRecorderDaily.do?rjhmId=${datePlan.rjhmId }" target="_blank">化验单</a>
		</td>
		
	</tr>
	<tr>
		<td>
			<table width="100%">
				<tr>
				<td align="right">
					股道号：<input type="text" value="13" style="width: 40px;" id="gdh" onkeyup="this.value=this.value.replace(/\D/g,'')"/>&nbsp;&nbsp;
					台位号：<input type="text" value="1" id="twh" style="width: 40px;" onkeyup="this.value=this.value.replace(/\D/g,'')"/>
				</td>
				<td align="left"><a href="javascript:void(0);" onclick="move('${datePlan.rjhmId}')">股道转移</a></td>
				<td align="right">
					机车号：<input type="text" value="1000" style="width: 80px;" id="jcnum"/>
				</td>
				<td align="left">
					<a href="javascript:void(0);" onclick="searchJC()">查询</a>
				</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table id="bzFinishiInfo" class="tableStyle" style="width:550px;">
	<tr><th align="center">检修班组</th><th align="center">完成时间</th><th align="center">检修情况</th><th align="center">所处节点</th></tr>
	<c:forEach items="${flowRecs}" var="rec">
		<tr>
			<td align="center">${rec.proTeam.proteamname }</td>
			<td align="center">${rec.finishTime }</td>
			<td align="center">
			  <c:if test="${datePlan.projectType==0}">
			     <c:choose>
					<c:when test="${rec.finishStatus==0}">
						<a  style="color: #f00" href="<%=basePath %>query!getInfoByBZ.do?workFlag=1&teamId=${rec.proTeam.proteamid }&rjhmId=${datePlan.rjhmId }" target="_blank">未完成</a>
					</c:when>
					<c:otherwise>
						<a href="<%=basePath %>query!getInfoByBZ.do?workFlag=1&teamId=${rec.proTeam.proteamid }&rjhmId=${datePlan.rjhmId }" target="_blank">完成</a>
					</c:otherwise>
				</c:choose>
			  </c:if>
			  <c:if test="${datePlan.projectType==1}">
			    <c:choose>
					<c:when test="${rec.finishStatus==0}">
						<a  style="color: #f00" href="<%=basePath %>query!getZxInfoByBZ.do?rjhmId=${datePlan.rjhmId}&workFlag=1&teamId=${rec.proTeam.proteamid }&nodeId=${rec.fixflow.jcFlowId}" target="_blank">未完成</a>
					</c:when>
					<c:otherwise>
						<a href="<%=basePath %>query!getZxInfoByBZ.do?rjhmId=${datePlan.rjhmId}&workFlag=1&teamId=${rec.proTeam.proteamid }&nodeId=${rec.fixflow.jcFlowId}" target="_blank">完成</a>
					</c:otherwise>
				</c:choose>
			  </c:if>
			</td>
			<td align="center">
			  <c:choose>
			    <c:when test="${rec.fixflow.jcFlowId==100}">机车分解</c:when>
			    <c:when test="${rec.fixflow.jcFlowId==101}">车上组装</c:when>
			    <c:otherwise>小辅修</c:otherwise>
			  </c:choose>
			</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${datePlan.projectType==0&&datePlan.planStatue!=-1}">
<br/>
<table id="bzFinishiInfo" class="tableStyle" style="width:550px;">
  <tr>
      <th align="center">试验项目</th>
      <th align="center">工人</th>
      <th align="center">工长</th>
      <th align="center">质检员</th>
      <th align="center">技术员</th>
      <th align="center">交车工长</th>
      <th align="center">验收员</th>
         <c:if test="${!empty map}">
           <tr>
            <td>${map.item}</td>
            <td>
              <c:if test="${map.grFinished==0}">完成</c:if>
              <c:if test="${map.grFinished!=0}"><font style="color: #f00">未签完</font></c:if>
            </td>
            <td>
              <c:if test="${map.gzFinished==0}">完成</c:if>
              <c:if test="${map.gzFinished!=0}"><font style="color: #f00">未签完</font></c:if>
            </td>
            <td>
              <c:if test="${map.zjFinished==0}">完成</c:if>
              <c:if test="${map.zjFinished!=0}"><font style="color: #f00">未签完</font></c:if>
            </td>
            <td>
              <c:if test="${map.jsFinished==0}">完成</c:if>
              <c:if test="${map.jsFinished!=0}"><font style="color: #f00">未签完</font></c:if>
            </td>
            <td>
              <c:if test="${map.jcgzFinished==0}">完成</c:if>
              <c:if test="${map.jcgzFinished!=0}"><font style="color: #f00">未签完</font></c:if>
            </td>
            <td>
              <c:if test="${map.ysFinished==0}">完成</c:if>
              <c:if test="${map.ysFinished!=0}"><font style="color: #f00">未签完</font></c:if>
            </td>
           </tr>
      	 </c:if>
 </tr>
</table>
</c:if>
</center>
</body>
