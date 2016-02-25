<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>${cache['SYS_TITLE'][0].value}-用户新增</title>
<base href="<%=basePath%>" />
<!-- 验证用户自定义 -->
<script type="text/javascript" 
    src="${ctx}/js/users/addUsersDialog_script.js.jsp"></script>
<!-- 通用的拼音验证 -->
<script type="text/javascript"
	src="${ctx}/js/script.js" ></script>


</head>
<body>
	<!-- 此处行添加行内样式才能显示12号字体 -->
	<form action="" target="frmright" method="post"
		onsubmit="return checkform()" name="addUsersForm">
		<table class="tableStyle" transMode="true" style="font-size: 12px;">
		<!-- 判断是否为修改页面，删除session(usersPrivs) -->
			 <c:if test="${updateTitle != 'updateUser'}">
					 <c:remove var="usersPrivs" scope="session"/>
			 </c:if>
			<tr>
			    <input type="hidden" name="id"  value="${usersPrivs.id}"/>
				<td width="10%">用户名：</td>
				<td width="40%"><input type="text" name="userName"
					id="userName" value="${usersPrivs.userName}"  class="validate[required,length[1,20]]"/>
					<div id="checkName" class="checkName"></div>
				</td>
				<td>姓名拼音：</td>
				<td><input type="text" name="py" id="py"
					value="${usersPrivs.py}"  class="validate[required,custom[onlyLetter],length[1,20]]"/>
				</td>
			</tr>
			<tr>
				<td width="10%">地区：</td>
				<td><select onchange='' name="dictArea.id" id="area"
					style="display:block" >
						<option value="0" class="validate[required] select">请选择地区</option>
						<c:forEach items="${dictAreaList}" var="areas">
							<option value='${areas.id}' ${areas.id == usersPrivs.dictArea.id ? "selected":""}>${areas.areaName}</option>;
                        </c:forEach>
				</select>
				</td>
				<td>性别：</td>
				<td><select name="gender" id="gender">
						<option value="0" ${usersPrivs.gender == "0" ? "selected":""}>男</option>
						<option value="1" ${usersPrivs.gender == "1" ? "selected":""}>女</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>班组还是部门：</td>
				<td><select onchange="javascript:changedepartProteamStatus();"
					name="departProteamStatus" id="departProteamStatus">
						<option value="-1" ${usersPrivs.departProteamStatus == "-1" ? "selected":""}>请选择班组还是部门</option>
						<option value="0" ${usersPrivs.departProteamStatus == "0" ? "selected":""}>部门</option>
						<option value="1" ${usersPrivs.departProteamStatus == "1" ? "selected":""}>班组</option>
						<option value="2" ${usersPrivs.departProteamStatus == "2" ? "selected":""}>部门和班组</option>
				</select>
				</td>
				<td>是否启用：</td>
				<td><select onchange='' id="status" name="status">
						<option value="1" ${usersPrivs.status == "1" ? "selected":""}>是</option>
						<option value="0" ${usersPrivs.status == "0" ? "selected":""}>否</option>
				</select>
				</td>
			</tr>
			<tr id="proteamDepart">
				<td id="proteamText">班组：</td>
				<td id="proteamValue"><select onchange=''
					name="dictProteam.id" id="proteam">
						<option value="0">请选择班组</option>
						<c:forEach items="${dictProteamList}" var="proteams">
							<option value='${proteams.id}' ${proteams.id == usersPrivs.dictProteam.id ? "selected":""}>${proteams.proteamName}</option>
						</c:forEach>
				</select>
				</td>
				<td id="departText">部门：</td>
				<td id="departValue"><select onchange=''
					name="dictDepart.id" id="depart">
						<option value="0">请选择部门</option>
						<c:forEach items="${dictDepartList}" var="departs">
							<option value='${departs.id}' ${departs.id == usersPrivs.dictDepart.id ? "selected":"" }>${departs.departName}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><input type="button" value="请选择" id="roleInUsersListCK" name="roleInUsersListCK" style="width:45px;"  onclick='checkRoleInUsers();'/>
				<input type="text" id="roleId" name="roleId" style="width:70px" readonly="readonly"
				 value="<c:forEach items="${usersPrivs.usersRolePrivs }" var="usersRole">${usersRole.rolePrivs.roleName},</c:forEach>"
				/>
				
				<!-- <select onchange='' name="roleId"
					id="role">
						<option value="0">请选择角色</option>
						<c:forEach items="${rolePrivsList}" var="roles">
						   <c:set var="flag" value="false"></c:set>
							<c:forEach items="${usersPrivs.usersRolePrivs}" var="usersRole" >
								<c:if test="${!flag }">
									<c:if test="${roles.id == usersRole.rolePrivs.id }">
										<c:set var="flag" value="true"></c:set>
									</c:if>
								</c:if>	
							</c:forEach>
							<option value='${roles.id}'  ${flag ? 'selected' : '' }>${roles.roleName}</option>
						</c:forEach>
				</select>-->
				</td>
				<td>用户工号：</td>
				<td><input type="text" name="jobNum" id="jobNum"
					value="${usersPrivs.jobNum}" class="validate[required,custom[noSpecialCaracters],length[1,20]]"/><div id="checkJobNum" class="checkJobNum"></div>
				</td>
			</tr>
			<tr>
				<td>用户卡号：</td>
				<td><input type="text" name="cardNum" id="cardNum"
					value="${usersPrivs.cardNum}" class="validate[required,custom[noSpecialCaracters],length[1,20]]"/></td>
				<td>登录密码：</td>
				<td><input type="text" name="password" id="password"
					value="${usersPrivs.password}" class="validate[required,custom[noSpecialCaracters],length[1,20]]"/></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3" style="text-align:left"><textarea rows="20"
						cols="10" name="remark" id="remark">${usersPrivs.remark}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" id="submit" value=" 提 交 " /> <input
					type="reset" value=" 重 置 " />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
