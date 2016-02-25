<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="com.repair.constant.Constants"%>
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

	<!-- 引用以封装的复选框js						开始 -->
	<script type="text/javascript" src="${urlctx}js/checkboxUtil/checkboxUtil.js"></script>
	<!-- 引用以封装的复选框js							结束 -->
	<script type="text/javascript" src="${urlctx}js/users/departChoose_script.js"></script>
 </head>
  
  <body>
    <!-- 用户管理 功能操作和数据显示区域    start ************ -->
  	<div class="box2" panelTitle="部门-用户管理"  panelWidth="100%" panelHeight="500">
		<table width="100%">
			<!-- *********	操作功能区  start  ********** -->
			<tr>
				<td width="25%">
					<div align="left" class="minv2_usersManageChildIframe_line_class">
						<input type="checkbox" id="selByRole"/>通过角色查询
						<input type="checkbox" id="selByName"/>通过用户名查询
						<input type="checkbox" id="selByJobNum"/>通过工号查询
						<button id="queryUsers"><span class="icon_find">查询</span></button>
						<br/>
					
						<div  id="roleDiv">
							角色:
							<select id="roleId" autoWidth="true" name="" colNum="3">
								<option value="0">请选择</option>
								<c:forEach items="${roleList}" var="role">
									<%-- 如果通过角色查询用户，在下次显示时选中对应的角色 --%>
									<option value="${role.id }"  }>${role.roleName }</option>
								</c:forEach>
							</select>
						</div>
						
						<div id="userNameDiv">
							姓名：<input type="text" value="${usersPrivs.userName }" watermark="输入姓名" id="userName" name="usersPrivs.userName"/>
						</div>
						
						<div id="jobNumDiv">
							工号：<input type="text" value="${usersPrivs.jobNum }" watermark="输入工号" id="jobNum" name="usersPrivs.jobNum"/>
						</div>
					</div>
					<div align="right" class="minv2_usersManageChildIframe_line_class">
						每页<select id="pageSizeTop" name="pageSizeTop" onchange="selectPagesize('pageSizeTop')" autoWidth="true">   
						<c:forEach begin="10" end="50" step="10" var="i">   
							 <option value="${i}" <c:if test="${pageSize eq i }">selected</c:if>>${i}</option>   
						</c:forEach>   
						</select>
						条记录
						<button onclick='top.Dialog.open({URL:"findDictAreaAllByDepart!executeDepart.action",Title:"新增用户",ShowCloseButton:true});'><span class="icon_add">新建</span></button>
						<button id="deleteUsersBtn"><span class="icon_delete">批量删除</span></button>
						<button id="transferBtnDepart"><span class="icon_mark">转移</span></button>
					</div>
				</td>
			</tr>
			<!-- *********	操作功能区  end  ********** -->
			
			<!-- ************************************************************************************************* -->
			
			<!-- *********	数据显示区  start  ********** -->
			<tr>
				<td>
					<div id="scrollContent" class="border_gray">
					 <!-- 分页使用滚动条 -->
						  <div  class="winXP" style="height:360px;border:solid 1px #cccccc">
							   <div class="scroller" style="width:100%;" scrollerHeight="200">
									<table class="tableStyle" id="usersData" usecheckbox="false">
										<tr>
											<th align="center" width="5%"><input type="checkbox" name="checkAll" id="checkAll"/>选择</th>
											<th width="10%">用户ID</th>
											<th width="5%">用户工号</th>
											<th width="20%">用户名称</th>
											<th width="15%">登录账号</th>
											<th width="10%">操作</th>
										</tr>
										<c:forEach var="users" items="${pm.datas }"  varStatus="usersStatu">
										<tr>
											<td><input type='checkbox' name='checkId' value='${users.id}'/></td>
											<td>${users.id }</td>
											<td>${users.jobNum }</td>
											<td>${users.userName }</td>
											<td>${users.jobNum }</td>
											<td>
												<span class='img_view hand'  title='查看详情' onclick='lookMessage(${users.id});'></span>
												<span class='img_edit hand' title='修改' onclick='update(${users.id});'></span>
												<span class='img_delete hand' onclick='deletes(${users.id})'  title='删除'></span>
										    </td>
										</tr>
										</c:forEach>
									</table>
							   </div>
						 </div>
					</div>
				</td>
			</tr>
			<!-- *********	数据显示区  end  ********** -->
		</table>
	</div>
	<!-- 用户管理 功能操作和数据显示区域    end  ************* -->
	
	

	<!-- *********	分页信息显示区  start  ********** -->
	<div class="minv2_bottom_page_class">
		<div class="float_left padding5">
			  共有信息${pm.count}条。
		</div>
		<div class="float_right padding5 paging">
			<div class="float_left padding_top4">
				<pg:pager maxPageItems="${pageSize }" url="queryDepartUsers.action" items="${pm.count }" export="page1=pageNumber">
		  		<!--<pg:param name="userPrivs.departProteamStatus" value="${userPrivs.departProteamStatus }" />-->
		  		<pg:param name="userName" value="${usersPrivs.userName }"/>
		  		<pg:param name="jobNum" value="${usersPrivs.jobNum }"/>
		  		<c:forEach var="usersRole" items="${usersPrivs.usersRolePrivs}">
		  			<pg:param name="roleId" value="usersRole.rolePrivs.id"/>
		  		</c:forEach>
		  		
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
			 	每页<select id="pageSize" name="pageSize" onchange="selectPagesize('pageSize')" autoWidth="true">   
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
  <script type="text/javascript">
	//得到用户从下拉列表选择的每页显示的行数，并刷新到转到首页
	function selectPagesize(pageId){
		var obj =  document.getElementById(pageId).value;
		document.getElementById("pageSize").value = obj;
		document.getElementById("pageSizeTop").value = obj;
	 	document.location.href = "queryDepartUsers!executeDepart.action?userPrivs.departProteamStatus=1&psize="+obj;   
	}   
 </script>
  <!-- 此页面要用到的JS  -->
  <script src="${ctx}/js/users/usersDepartManageChildIframe_script.js.jsp" type="text/javascript"></script>
</html>
