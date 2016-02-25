<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		<title>${cache['SYS_TITLE'][0].value}油水化验记录查询</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	</head>

<body>
<div id="showImage">
              <center><h2>${oamItemRec.planDate.jcTypeValue }-${oamItemRec.planDate.jcNumber }-油水化验记录</h2></center>
	    	 	 <table width="100%" class="tableStyle">
	    	 	  <c:forEach var="m" items="${map}">
	    	 	      <tr><th colspan="7" style="font-size: 20px;color: blue;" align="center">${m.key.mainItemName  }</th></tr>
					  <tr>
						<th class="ver01" width="40%" align="center">项目</th>
						<th class="ver01"  width="10%" align="center">标准(最小值)</th>
						<th class="ver01" width="10%" align="center">标准(最大值)</th>
						<th class="ver01" width="5%" align="center">填报值</th>
						<th class="ver01" width="10%" align="center">合格情况</th>
						<th class="ver01" width="25%" align="center">检验人</th>
					 </tr>
					<c:forEach var="childItemRec" items="${m.value}">
					   <tr>
					    <td class="ver01" align="center">${childItemRec.childItem.childItemName }</td>
						<td class="ver01" align="center">${childItemRec.childItem.minValue }</td>
						<td class="ver01" align="center">${childItemRec.childItem.maxValue}</td>
						<td class="ver01" align="center">${childItemRec.actualCheckData}</td>
						<td class="ver01" align="center">${childItemRec.assayStatus }</td>
						<td class="ver01" align="center">${childItemRec.assayUsers.userName }</td>
					  </tr>
					  </c:forEach>
					  </c:forEach>
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
					   <c:if test="${empty map}"> 
			            <img src="${ctx}/images/icons/png/ku.png" width="100" height="100"/>
			            <font size="3"> ${oamItemRec.planDate.jcTypeValue }-${oamItemRec.planDate.jcNumber } 此车暂无油水化验记录信息！</font>
		      		   </c:if>
				</table>
	    	  </div>
</body>
</html>