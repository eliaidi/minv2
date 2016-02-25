<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editUsers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
  </head>
  
  <body>
	    <div class="box2" panelTitle="" showStatus="false" roller="true"  >
	    	<form action="" method="post">
				<table class="tableStyle" transMode="true" width="580">
					<tr>
						<td width="10%">角色：</td>
						<td width="40%">
							<select  onchange='' id="role" class="validate[required,custom[chinese],value=''">
							    <option value="" selected>请选择角色</option>
							    <option value="1">新增图片</option>
							    <option value="2">维护图片</option>
							    <option value="3">新增新闻</option>
							 </select>&nbsp;<font color="red">*</font>
						</td>
						<td>机务段：</td>
						<td>
							<select  onchange='' id="jwd">
							    <option value="1">广州机务段</option>
							    <option value="2">维护图片</option>
							    <option value="3">新增新闻</option>
							 </select><font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td width="10%">地区：</td>
						<td>
							<select  onchange='' id="area">
							    <option value="1">广州</option>
							    <option value="2">维护图片</option>
							    <option value="3">新增新闻</option>
							 </select>
						</td>
						<td>是否启用：</td>
						<td>
							<select  onchange='' id="isOpen">
							    <option value="1">是</option>
							    <option value="0">否</option>
							 </select>
						</td>
					</tr>
					<tr>
						<td>班组：</td>
						<td>
							<select  onchange='' id="bz">
							    <option value="1">请选择班组</option>
							    <option value="2">维护图片</option>
							    <option value="3">新增新闻</option>
							 </select>
						</td>
						<td>用户姓名：</td>
						<td>
							<input type="text" class="validate[required,custom[chinese],length[0,20]]"/><font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>登录名称：</td>
						<td>
							<input type="text" />
						</td>
						<td>用户工号：</td>
						<td>
							<input type="text" /><font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>IDK卡号：</td>
						<td>
							<input type="text" />
						</td>
						<td>登录密码：</td>
						<td>
							<input type="text" /><font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>登录时间：</td>
						<td>
							<input type="text"/>
						</td>
						<td>登记日期：</td>
						<td>
							<input type="text" />
						</td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>
							<input type="text"/>
						</td>
						
						<td>办公电话：</td>
						<td>
							<input type="text"/>
						</td>
					</tr>
					<tr>
						<td>办公传真：</td>
						<td>
							<input type="text" />
						</td>
						<td>手机1：</td>
						<td>
							<input type="text" />
						</td>
					</tr>
					<tr>
						<td>手机2：</td>
						<td>
							<input type="text" />
						</td>
						<td>家庭电话：</td>
						<td>
							<input type="text" />
						</td>
					</tr>
					<tr>
						<td>通讯地址：</td>
						<td>
							<input type="text" />
						</td>
						<td>IP地址：</td>
						<td>
							<input type="text" />
						</td>
					</tr>
					<tr>
						<td>姓名拼音：</td>
						<td>
							<input type="text" />
						</td>
						<td>备注：</td>
						<td>
							<input type="text" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="submit" value=" 提 交 "/>
							<input type="reset" value=" 重 置 "/>
						</td>
					</tr>
					
				</table>
			</form>
		</div>
  </body>
</html>
