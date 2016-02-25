<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib prefix="pg" uri="page-taglib" %>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>分页test</title>
    <link href="${ctx}/mainframe/skins/import_skin.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
  <div id="scrollContent" class="box1">
  	<form action="queryUserList.action" method="post">
  		<button type="submit" value="分页测试"> 分页测试  </button>
  	</form>
   <table class="tableStyle"  useMultColor="true">
	  <tr>
	        <th width="5%">序号</th>
			<th width="10%">登录帐号</th>
			<th width="10%">登录密码</th>
			<th width="10%">用户姓名</th>
			<th width="15%">性别</th>
	   </tr>
      <c:forEach var="uu" items="${pm.datas}">
         <tr>
            <td width="5%" align="center">${uu.id }</td>
         	<td width="5%" align="center">${uu.jobNum }</td>
         	<td width="5%" align="center">${uu.password}</td>
         	<td width="5%" align="center">${uu.userName}</td>
         	<td width="5%" align="center">${uu.gender }</td>
         </tr>
      </c:forEach>
      <c:if test="${empty pm.datas}"><tr><td align="center" colspan="8">没有相应的数据记录!</td></tr></c:if>
	</table>
  <!-- 处理分页 -->
  	<div class="float_left padding5">  共有信息${pm.count}条。</div>
	<div class="float_right padding5 paging">
		<div class="float_left padding_top4">
			<pg:pager maxPageItems="${pageSize }" url="queryUserList.action" items="${pm.count }" export="page1=pageNumber">
		  		<pg:first>
					 <span><a href="${pageUrl }" id="first">首页</a></span>
		 		</pg:first>
		 		<pg:prev>
					  <span><a href="${pageUrl }">上一页</a></span>
		  		</pg:prev>
	  	  		<pg:pages>
					<c:choose>
						<c:when test="${page1==pageNumber }">
							<span class="paging_current"><a href="javascript:;">${pageNumber }</a></span>
						</c:when>
						<c:otherwise>
							<span><a href="${pageUrl }">${pageNumber }</a></span>
						</c:otherwise>
					</c:choose>
		  		</pg:pages>
		  		<pg:next>
				    <span><a href="${pageUrl }">下一页</a></span>
		  		</pg:next>
		  		<pg:last>
				  	<span><a href="${pageUrl }">末页</a></span>
		 		</pg:last>
		 		<!-- 用户选择每页显示行数下拉列表  start-->
			 	<div class="float_left">
			 	每页<select id="pageSize" name="pageSize" onchange="selectPagesize(this)">   
					<c:forEach begin="10" end="50" step="10" var="i">   
						 <option value="${i}" <c:if test="${pageSize eq i }">selected</c:if>>${i}</option>   
					</c:forEach>   
				</select>条记录
				</div>
				<!-- 用户选择每页显示行数下拉列表  end-->
		 	</pg:pager>
		 	 
		</div>
		<div class="clear"></div>
	</div>
	<!-- 处理分页end -->
	<script type="text/javascript">
		//得到用户从下拉列表选择的每页显示的行数，并刷新到转到首页
		function selectPagesize(field){
			var obj =  document.getElementById("pageSize").value;
		 	document.location.href = "queryUserList.action?&psize="+obj;   
		}   
	</script>
  </body>
</html>
