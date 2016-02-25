<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="pg" uri="page-taglib"%>

	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="/common/taglibs.jsp"%>
	<head>
		<title>${cache['SYS_TITLE'][0].value}-角色管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- 
	  	<script type="text/javascript" src="${ctx}/js/users/rolesManageIframe_script.js"></script> 
	  	 -->
        <!-- 引用js刷新父窗口，关闭子窗口            开始-->
        <script src="${ctx}/js/users/closeAddRoleDialog_script.jsp" type="text/javascript"></script>         
         <!--引用js刷新父窗口，关闭子窗口                       结束-->
         
         <!-- 截取单行文本行数                                                               开始  -->
         <link href="${ctx}/js/skins/style.css" rel="stylesheet" type="text/css"/>
         <!-- 截取单行文本行数                                                                           结束-->
	</head>
	
	<body style="background-color: ffffff">
		<!-- minv2_rolesManageIfraame_mainDiv 主div                                           开始 -->
	    <div id="minv2_rolesManageIfraame_mainDiv" class="minv2_rolesManageIfraame_mainDiv_class">
			<!-- 用户管理 功能操作和数据显示区域    start ************ -->
			<div class="box2" panelTitle="角色管理" roller="false" overflow="auto">
				<table width="100%">
					<!-- *********	操作功能区  start  ********** -->
					<tr>
						<td width="50%">
							<div align="right" class="minv2_usersManageChildIframe_line_class">
								<button
									onclick='top.Dialog.open({URL:"iframePage/roles/alertDialog/addRolesDialog.jsp",Title:"角色增加",ShowCloseButton:true});'>
									<span class="icon_add">新增</span>
								</button>
	                            
								<!-- 用户选择每页显示行数下拉列表  start-->
								每页
								<select id="pageSize" name="pageSize"
									onchange="selectPagesize(this)" autoWidth="true">
									<c:forEach begin="10" end="50" step="10" var="i">
										<option value="${i}"<c:if test="${pageSize eq i }">selected</c:if>>${i}</option>
									</c:forEach>
								</select>
								条记录
								<!-- 用户选择每页显示行数下拉列表  end-->
							</div>
	
						</td>
					</tr>
					<!-- *********	操作功能区  end  ********** -->
	
					<!-- ************************************************************************************************* -->
	
					<!-- *********	数据显示区  start  ********** -->
					<tr>
						<td colspan="11">
							<div  id="scrollContent" class="border_gray">
							  <div class="scroller" style="width:100%;" scrollerHeight="200">
								<table class="tableStyle" id="rolessData" align="center">
									<tr>
										<th width="5%">
											序号
										</th>
										<th>
											角色编号
										</th>
										<th>
											角色名称
										</th>
										<th>
											角色拼音
										</th>
										<th>
											角色说明
										</th>
										<th>
											操作
										</th>
									</tr>
									<c:forEach var="role" items="${Role.datas}" varStatus="status">
	
										<tr>
											<td>
											<input type="hidden" name="id" value="${role.id}" id="roleid"/>
												${status.index+1}
											</td>
											<td>
												${role.id}
											</td>
											<td>
												<a id="show" title="请点击查看授权信息"
												onclick='top.Dialog.open({URL:"findFunctinPrivsAll.action?id=${role.id}",Title:"角色授权信息显示",ShowCloseButton:true});'>${role.roleName}</a>
											</td>
											<td>
												${role.py}
											</td>
											<td style="width:200px">
												<span class="text_slice" style="width:130px"  title="角色说明信息如下：</br>&nbsp;&nbsp;&nbsp;${role.remark}">${role.remark}</span>
											</td>
											<td>
												<span class="img_user hand" title="授权"
													onclick='top.Dialog.open({URL:"toRoleGrantByRoleId.action?roleId=${role.id}",Title:"角色授权",ShowCloseButton:true});'></span>
												<span class="img_edit hand" title="修改"
													onclick='top.Dialog.open({URL:"findRolePrivsById.action?id=${role.id}",Title:"角色修改",ShowCloseButton:true});'></span>
												<span class="img_delete hand" title="删除"
													onclick='top.Dialog.confirm("确定删除吗？",function(){window.location="deleteRolePrivsById.action?id=${role.id}"});'></span>
											</td>
										</tr>
									</c:forEach>
									<c:if test="${empty Role.datas}">
										<tr>
											<td align="center" colspan="8">
												没有相应的数据记录!
											</td>
										</tr>
									</c:if>
								</table>
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
				<!-- 处理分页 -->
				<div class="float_left padding5">
					共有信息${Role.count}条。
				</div>
				<div class="float_right padding5 paging">
					<div class="float_left padding_top4">
						<pg:pager maxPageItems="${pageSize }" url="findRolePrivsAll.action"
							items="${Role.count }" export="page1=pageNumber">
							<pg:first>
								<span><a href="${pageUrl }" id="first">首页</a> </span>
							</pg:first>
							<pg:prev>
								<span><a href="${pageUrl }">上一页</a> </span>
							</pg:prev>
							<pg:pages>
								<c:choose>
									<c:when test="${page1==pageNumber }">
										<span class="paging_current"><a href="javascript:;">${pageNumber
												}</a> </span>
									</c:when>
									<c:otherwise>
										<span><a href="${pageUrl }">${pageNumber }</a> </span>
									</c:otherwise>
								</c:choose>
							</pg:pages>
							<pg:next>
								<span><a href="${pageUrl }">下一页</a> </span>
							</pg:next>
							<pg:last>
								<span><a href="${pageUrl }">末页</a> </span>
							</pg:last>&nbsp;
							<!-- 用户选择每页显示行数下拉列表  start-->
								每页
								<select id="pageSize1" name="pageSize"
									onchange="selectPagesize1(this)"  autoWidth="true">
									<c:forEach begin="10" end="50" step="10" var="i">
										<option value="${i}"<c:if test="${pageSize eq i }">selected</c:if>>${i}</option>
									</c:forEach>
								</select>
								条记录
							<!-- 用户选择每页显示行数下拉列表  end-->
						</pg:pager>
					</div>&nbsp;&nbsp;
					<div class="clear"></div>
				</div>
				<!-- 处理分页end -->
			</div>
			<!-- *********	分页信息显示区  end  ********** -->
	    </div>
	    <!-- minv2_rolesManageIfraame_mainDiv 主div                                           结束 -->

	</body>
</html>
