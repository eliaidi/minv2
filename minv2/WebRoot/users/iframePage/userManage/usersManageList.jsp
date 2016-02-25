<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib prefix="pg" uri="page-taglib" %>
  <head>
  	<title>${cache['SYS_TITLE'][0].value}-用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>

 </head>
  
  <body>
    <!-- 用户管理 功能操作和数据显示区域    start ************ -->
  	<div class="box2" panelTitle="班组-用户管理"  panelWidth="100%" panelHeight="500">
		
		<table width="100%">
			<!-- *********	操作功能区  start  ********** -->
			<tr>
				<td width="25%">
				<form action="findAllUsers.action" method="post">
					<input type="hidden" name="userPrivs.departProteamStatus" value="${userPrivs.departProteamStatus }">
					<div align="left" class="minv2_usersManageChildIframe_line_class">
						角色:
						<select id="dd" autoWidth="true" name="userPrivs.rolePrivs.id">
							<option value="0">请选择</option>
							<option value="1">院系1</option>
							<option value="2">院系2</option>
							<option value="3">院系3</option>
						</select>
						姓名：<input type="text" watermark="输入姓名" name="userPrivs.userName"/>
						工号：<input type="text" watermark="输入工号" name="userPrivs.jobNum"/>
						<button type="submit"><span class="icon_find">查询</span></button>
					</div>
					<div align="right" class="minv2_usersManageChildIframe_line_class">
						每页：
						<select autoWidth="true">
							<option>10</option>
							<option>20</option>
							<option>50</option>
						</select>
						条数据
						<button onclick='top.Dialog.open({URL:"findDictAreaAll.action",Title:"新增用户",ShowCloseButton:true});'><span class="icon_add">新建</span></button>
						<button id="deleteUsersBtn"><span class="icon_delete">删除</span></button>
						<button onclick=''><span class="icon_mark">转移</span></button>
					</div>
					</form>
				</td>
			</tr>
			<!-- *********	操作功能区  end  ********** -->
			
			<!-- ************************************************************************************************* -->
			
			<!-- *********	数据显示区  start  ********** -->
			<tr>
				<td>
					<div id="scrollContent" class="border_gray">
						<table class="tableStyle" id="usersData">
							<tr>
								<th align="center" width="5%"><span class="img_checkAllOff"></span></th>
								<th width="10%">用户ID</th>
								<th width="5%">用户工号</th>
								<th width="20%">用户名称</th>
								<th width="15%">登录账号</th>
								<th width="10%">操作</th>
							</tr>
							<c:forEach var="user1" items="${pm.datas}">
							<tr>
								<td align="center" width="5%"><input type="checkbox"></span></td>
								<td width="10%">${user1.id }</td>
								<td width="5%">${user1.jobNum }</td>
								<td width="20%">${user1.userName }</td>
								<td width="15%">${user1.jobNum }</td>
								<td width="10%">
									<span class="img_view hand" title="查看" onclick='top.Dialog.open({URL:"alertDialog/findUsersDialog.jsp",Title:"查看用户详情",ShowCloseButton:true});'></span>
									<span class="img_edit hand" title="修改" onclick='top.Dialog.open({URL:"alertDialog/updateUsersDialog.jsp",Title:"查看用户详情",ShowCloseButton:true});'></span>
									<span class="img_delete hand" title="删除"></span>
								</td>
							</tr>
							</c:forEach>
							<c:if test="${empty pm.datas}"><tr><td align="center" colspan="8">没有相应的数据记录!</td></tr></c:if>
						</table>
					</div>
				</td>
			</tr>
			<!-- *********	数据显示区  end  ********** -->
		</table>
	</div>
	<!-- 用户管理 功能操作和数据显示区域    end  ************* -->
	
	

	<!-- *********	分页信息显示区  start  ********** -->
	<div class="minv2_usersManageChildIframe_bottom_page_class">
		<div class="float_left padding5">
			  共有信息${pm.count}条。
		</div>
		<div class="float_right padding5 paging">
			<div class="float_left padding_top4">
				<pg:pager maxPageItems="${pageSize }" url="findAllUsers.action" items="${pm.count }" export="page1=pageNumber">
		  		<pg:param name="userPrivs.departProteamStatus" value="${userPrivs.departProteamStatus }" />
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
			 	每页<select id="pageSize" name="pageSize" onchange="selectPagesize(this)" autoWidth="true">   
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
	<!-- *********	分页信息显示区  start  ********** -->
  </body>
  
  <!-- 此页面要用到的JS -->
  <script src="${ctx}/js/users/usersManageChildIframe_script.js.jsp" type="text/javascript"></script>
  <script type="text/javascript">
	//得到用户从下拉列表选择的每页显示的行数，并刷新到转到首页
	function selectPagesize(field){
		var obj =  document.getElementById("pageSize").value;
	 	document.location.href = "findAllUsers.action?userPrivs.departProteamStatus=1&psize="+obj;   
	}   
 </script>
</html>
