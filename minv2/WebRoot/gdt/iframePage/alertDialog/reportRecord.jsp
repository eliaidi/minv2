<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<head>
		<title>报活记录页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		
		<script type="text/javascript" src="${ctx}/gdt/changsha_gdt/js/jcinfodetail_script.js"></script>
		
		 <link rel="stylesheet" type="text/css" href="${ctx}/gdt/changsha_gdt/css/jcinfodetail.css" />
			
	</head>
	<!--  
<base href="<%=basePath%>report/">
<title>${flowval }报活记录</title>
<link href="<%=basePath %>css/test.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>css/linkcss.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath %>js/tree/dtree/dtree.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath %>js/test.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.4.js"></script>
<script type="text/javascript" src="<%=basePath %>js/framework.js"></script>
<script type="text/javascript" src="<%=basePath %>js/attention/zDialog/zDrag.js"></script>
<script type="text/javascript" src="<%=basePath %>js/attention/zDialog/zDialog.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.floatDiv.js"></script>
<script type="text/javascript" src="<%=basePath %>js/menu.js"></script>
<link href="<%=basePath %>css/import_basic.css" rel="stylesheet" type="text/css"/>
-->
<!-- 打印插件 -->
<script type="text/javascript" src="<%=basePath %>js/LodopFuncs.js"></script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>  
       <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed> 
</object> 
<!-- 打印end -->



<body bgcolor="#f8f7f7">
<div id="scoll_div_id" style="background:#328aa4;width:864px;height:23px;">
<ul id="nav">
    <c:if test="${datePlan.projectType==0}">
      <li><a href="<%=basePath%>query!getInfoByJC.do?rjhmId=${datePlan.rjhmId}&psize=100">◇整车记录 </a></li>
    </c:if>
     <c:if test="${datePlan.projectType==1}">
        <li><a href="javascript:void(0);">◇整车记录 </a>
	       <ul>
	         <li><a href="<%=basePath%>query!getZxInfoByJC.do?rjhmId=${datePlan.rjhmId}&psize=100">整车检修记录</a></li>
	         <li><a href="<%=basePath%>query!findJCAll.do?rjhmId=${datePlan.rjhmId}&jcStype=${datePlan.jcType }">检修配件记录</a></li>
	       </ul>
    	</li>
     </c:if>
     <c:if test="${datePlan.projectType==0}">
	      <c:if test="${datePlan.fixFreque!='LX'&&datePlan.fixFreque!='JG'&&datePlan.fixFreque!='ZZ'}">
	            <li><a href="javascript:void(0);">◇机车部件</a>
	              <ul>
	        		<c:forEach items="${units}" var="unit">
	           			<li><a href="<%=basePath%>query!view.do?rjhmId=${datePlan.rjhmId }&fristUnit=${unit.firstunitid }">${unit.firstunitname }</a></li>
	        		</c:forEach>
	     		</ul>
	      </c:if>
     </c:if>
     <c:if test="${datePlan.projectType==1}">
             <li><a href="javascript:void(0);">◇机车部件</a>
               <ul>
                <c:forEach items="${units}" var="unit">
        		 <li><a href="<%=basePath%>query!zxView.do?rjhmId=${datePlan.rjhmId}&fristUnit=${unit.firstunitid }">${unit.firstunitname }</a></li>
        		</c:forEach>
        	   </ul>
        	 </li>
     </c:if>
    <li><a href="javascript:void(0);">◇检修班组</a>
       <ul>
            <c:if test="${datePlan.projectType==0}">
	            <c:forEach items="${bzs}" var="bz" varStatus="index">
		            <li><a href="<%=basePath%>query!getInfoByBZ.do?rjhmId=${datePlan.rjhmId }&teamId=${bz.proteamid }">${bz.proteamname }</a></li>
	            </c:forEach>
            </c:if>
            <c:if test="${datePlan.projectType==1}">
                 <c:forEach items="${bzs}" var="bz" varStatus="index">
		            <li><a href="<%=basePath %>query!getZxInfoByBZ.do?rjhmId=${datePlan.rjhmId}&workFlag=1&teamId=${bz.proteamid}">${bz.proteamname }</a></li>
	            </c:forEach>
            </c:if>
      </ul>
    </li>
    <c:if test="${datePlan.projectType==0}">
	    <li><a href="<%=basePath%>query!searchJcRec.do?rjhmId=${datePlan.rjhmId}">◇交车试验</a></li>
    </c:if>
    <c:if test="${datePlan.projectType==1}">
        <li><a href="javascript:void(0);">◇试验记录</a>
	       <ul>
	            <li><a href="<%=basePath%>query!viewExperiment.do?id=${datePlan.rjhmId}&jceiId=2">水阻试验</a></li>
	            <li><a href="<%=basePath%>query!viewExperiment.do?id=${datePlan.rjhmId}&jceiId=5">顶轮试验</a></li>
	            <li><a href="<%=basePath%>query!viewExperiment.do?id=${datePlan.rjhmId}&jceiId=4">高低压试验</a></li>
	            <li><a href="<%=basePath%>query!viewExperiment.do?id=${datePlan.rjhmId}&jceiId=3">试运行试验</a></li>
	      </ul>
      </li>
    </c:if>
    <c:if test="${datePlan.projectType==0}">
       <c:if test="${datePlan.fixFreque!='LX'&&datePlan.fixFreque!='JG'&&datePlan.fixFreque!='ZZ'}">
	    <li><a href="<%=basePath%>query!findXXJCPJ.do?rjhmId=${datePlan.rjhmId}">◇配件记录</a></li>
	   </c:if>
    </c:if>
    <c:if test="${datePlan.projectType==1}">
        <li><a href="<%=basePath%>query!findJCPJ.do?rjhmId=${datePlan.rjhmId}">◇配件记录</a></li>
        <li><a href="<%=basePath%>query!findJCTS.do?rjhmId=${datePlan.rjhmId}">◇探伤记录</a></li>
    </c:if>
    <c:if test="${datePlan.projectType==0}">
        <c:if test="${datePlan.fixFreque!='LX'&&datePlan.fixFreque!='JG'&&datePlan.fixFreque!='ZZ'}">
	    	<li><a href="<%=basePath%>query!listLeftWorkRecord.do?rjhmId=${datePlan.rjhmId }">◇未完成记录 </a></li>
	    </c:if>
    </c:if>
    <c:if test="${datePlan.projectType==1}">
        <li><a href="<%=basePath%>query!listZXLeftWorkRecord.do?rjhmId=${datePlan.rjhmId }">◇未完成记录 </a></li>
    </c:if>
    <li><a href="<%=basePath %>query!getAllInfoPre.do?rjhmId=${datePlan.rjhmId}" style="background-color:#fff;color:blue;">◇报活记录</a></li>
    <li><a href="<%=basePath%>query!searchJCjungong.do?rjhmId=${datePlan.rjhmId }">◇交车竣工 </a></li>
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
<br><br>
<!-- 浮动导航菜单end -->
<div style="width:870px;margin-left:-435px;left:50%;position:absolute;" id="content2">
	<table width="864" border="0" align="center" cellspacing="0" style="padding-top:10px;">
	
		<tr>
			<td colspan="6" align="center" height="40">
				<h2 align="center">
					<font style="font-family:'隶书'">
						<b>
							${flowval } 报活记录
						</b>
					</font>
				</h2>
			</td>
		</tr>
	
		<tr>
			<td width="163" align="right">机车号：</td>
			<td width="240">${datePlan.jcType }  ${datePlan.jcnum }</td>
			<td width="55" align="left">修程：</td>
			<td width="251">${datePlan.fixFreque}</td>
			<td width="140" align="left">检修日期：</td>
			<td width="195" align="left">${fn:substring(datePlan.kcsj,0,10)}</td>
		</tr>
	
		<tr>
			<td colspan="6">
				<table width="884" border="0" align="center" cellspacing="0" style="margin-top: 10px;" id="content">
					<tr>
					  	<td align="center" colspan="3" class="tbCELL3" style="background-color: #328aa4;">
					  		<span style="margin: 0 20px 0 20px;;color:#ffffff;">JT28报活:&nbsp;&nbsp;${JTNum }</span>
					  		<span style="margin: 0 20px 0 20px;;color:#ffffff;">复检报活:&nbsp;&nbsp;${FJNum }</span>
					  		<span style="margin: 0 20px 0 20px;;color:#ffffff;">检修过程报活:&nbsp;&nbsp;${JGNum }</span>
					  		<span style="margin: 0 20px 0 20px;;color:#ffffff;">零公里检查:&nbsp;&nbsp;${LGNum }</span>
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
								<c:forEach items="${preDictRecs}" var="preItem">
									<tr>
										<td class="tbCELL1" align="center"  name="preType">
											<c:if test="${preItem.type==0}">
												JT28报活
											</c:if>
											<c:if test="${preItem.type==1}">
												复检报活
											</c:if>
											<c:if test="${preItem.type==2}">
												检修过程报活
											</c:if>
											<c:if test="${preItem.type==6}">
												零公里检查
											</c:if>
										</td>
										<td class="tbCELL1" align="center" name="proteam">${preItem.proTeamId.proteamname }&nbsp;</td>
										<td class="tbCELL1" align="center">
										<a href="javascript:;" style="color:blue" onclick="return jtPreDictDatils(${preItem.preDictId})">
											${fn:replace(preItem.repPosi,',','/') }/${preItem.repsituation }
										</a>&nbsp;
										</td>
										<td class="tbCELL1" align="center">${preItem.repemp}&nbsp;</td>
										<td class="tbCELL1" align="center">${preItem.repTime }&nbsp;</td>
										<td class="tbCELL1" align="center">${preItem.fixEndTime }&nbsp;</td>
										<td class="tbCELL1" align="center">${preItem.dealSituation }&nbsp;
											 <!-- 2015-05-29,宁佐锌，修改工长显示配件编号，开始-->
											 <c:if test="${!empty preItem.upPjNum}"><br/>
				             						 <c:forTokens items="${preItem.upPjNum }" delims="," var="num">
														<a href="query!findPjRecordByPjNum.do?rjhmId=${datePlan.rjhmId}&pjNum=${num}" target="_blank" style="color:blue;">${num }</a>&nbsp;
							 						 </c:forTokens>
						 					 </c:if>
						 					 <!-- 2015-05-29,宁佐锌，修改工长显示配件编号，结束-->
										</td>
										<td class="tbCELL1" align="center">
											<c:if test="${empty preItem.fixEmp && empty preItem.dealFixEmp}"><font style="color: red;font-weight: bold;">(未派工)</font></c:if>
											<c:if test="${!empty preItem.fixEmp && empty preItem.dealFixEmp}">
												${preItem.fixEmp}<font style="color: red;font-weight: bold;"><br/>(未签认)</font>
											</c:if>
											<c:if test="${!empty preItem.fixEmp && !empty preItem.dealFixEmp}">${preItem.fixEmp}&nbsp;</c:if>
											<c:if test="${empty preItem.fixEmp && !empty preItem.dealFixEmp}">${fn:replace(preItem.dealFixEmp,',','')}&nbsp;</c:if>
										</td>
										<td class="tbCELL1" align="center">
											<c:if test="${empty preItem.lead}">
												<font style="color: red;font-weight: bold;">(未签认)</font>
											</c:if>
											<c:if test="${!empty preItem.lead}">
												${preItem.lead}<br/>${fn:substring(preItem.ldAffirmTime, 5, 16) }&nbsp;
											</c:if>
										</td>
										<td class="tbCELL1" align="center">${preItem.qi }<br/>${fn:substring(preItem.qiAffiTime, 5, 16) }&nbsp;</td>
										<td class="tbCELL1" align="center">${preItem.technician }<br/>${fn:substring(preItem.techAffiTime, 5, 16) }&nbsp;</td>
										<td class="tbCELL1" align="center">${preItem.commitLd }<br/>${fn:substring(preItem.comLdAffiTime, 5, 16) }&nbsp;</td>
										<td class="tbCELL1" align="center">${preItem.accepter }<br/>${fn:substring(preItem.acceTime, 5, 16) }&nbsp;</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
		  		</table>
		  	</td>
		</tr>
	</table>
</div>
</body>
