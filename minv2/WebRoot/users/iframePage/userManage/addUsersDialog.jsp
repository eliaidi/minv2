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
<script type="text/javascript"
	src="${ctx}/js/users/addUsersDialog_script.js"></script>


</head>
<body>
	<!-- 此处行添加行内样式才能显示12号字体 -->
	<form action="addUsers.action" target="frmright" method="post"
		onsubmit="return checkform()">
		<table class="tableStyle" transMode="true" style="font-size: 12px;">
			<tr>
				<td width="10%">用户名：</td>
				<td width="40%"><input type="text" name="usersPrivs.userName"
					id="userName" value="${usersPrivs.userName}" />
					<div id="checkName" class="checkName"></div></td>
				<td>姓名拼音：</td>
				<td><input type="text" name="usersPrivs.py" id="py" value="${usersPrivs.py}" onchange="javascript:RepNumber(this);"/></td>
			</tr>
			<tr>
				<td width="10%">地区：</td>
				<td><select onchange='' name="" id="area" style="display:block">
						<option value="1">请选择地区</option>
						<c:forEach items="${dictAreaList}" var="areas">
							<option value='${areas.id}'>${areas.areaName}</option>;
                        </c:forEach>
				</select></td>
				<td>机务段：</td>
				<td><select onchange='' name="usersPrivs.dictArea.id"
					id="jwdId">
						<option value="1">请选择机务段</option>
						<c:forEach items="${dictAreaList}" var="areas">
							<option value='${areas.id}'>${areas.areaName}机务段</option>;
                        </c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>班组还是部门：</td>
				<td><select onchange="javascript:changedepartProteamStatus();"
					name="usersPrivs.DepartProteamStatus" id="departProteamStatus">
						<option value="0">请选择班组还是部门</option>
						<option value="1">部门</option>
						<option value="2">班组</option>
						<option value="3">部门和班组</option>
				</select></td>
				<td>是否启用：</td>
				<td><select onchange='' id="isOpen">
						<option value="1">是</option>
						<option value="0">否</option>
				</select></td>
			</tr>
			<tr id="proteamDepart">
				<td id="proteamText">班组：</td>
				<td id="proteamValue"><select onchange=''
					name="usersPrivs.dictProteam.id" id="proteam">
						<option value="0">请选择班组</option>
						<c:forEach items="${dictProteamList}" var="proteams">
							<option value='${proteams.id}'>${proteams.proteamName}</option>
						</c:forEach>
				</select></td>
				<td id="departText">部门：</td>
				<td id="departValue"><select onchange=''
					name="usersPrivs.dictDepart.id" id="depart">
						<option value="0">请选择部门</option>
						<c:forEach items="${dictDepartList}" var="departs">
							<option value='${departs.id}'>${departs.departName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>角色：</td>
				<td><select onchange='' name="usersPrivs.rolePrivs.id"
					id="role">
						<option value="0">请选择角色</option>
						<c:forEach items="${rolePrivsList}" var="roles">
							<option value='${roles.id}'>${roles.roleName}</option>
						</c:forEach>

				</select></td>
				<td>用户工号：</td>
				<td><input type="text" name="usersPrivs.jobNum" id="jobNum"  value="${usersPrivs.jobNum}"/>
					<div id="checkJobNum" class="checkJobNum"></div></td>
			</tr>
			<tr>
				<td>用户卡号：</td>
				<td><input type="text" name="usersPrivs.cardNum" id="cardNum" value="${usersPrivs.cardNum}"/>
					<div id="checkCardNum" class="checkCardNum"></div>
				</td>
				<td>登录密码：</td>
				<td><input type="text" name="usersPrivs.password" id="password" value="${usersPrivs.password}"/>
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><select name="usersPrivs.gender" id="gender" value="${usersPrivs.gender}">
						<option value="0">男</option>
						<option value="1">女</option>
				</select></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3" style="text-align:left"><textarea rows="20"
						cols="10" name="usersPrivs.remark" id="remark"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value=" 提 交 " /> <input
					type="reset" value=" 重 置 " /></td>
			</tr>
		</table>
	</form>
</body>
</html>
