<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
  <head>
    <title>管理员界面-->用户角色-->用户管理-->部门目录-->添加部门页面</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="${ctx}/js/users/addDepartDialog_script.js" type="text/javascript"></script>
    <!-- 表单验证                                                                               开始 -->
	 <script type="text/javascript" src="${ctx}/js/validationEngine/validationEngine-cn.js"></script>
	 <script type="text/javascript" src="${ctx}/js/validationEngine/validationEngine.js"></script>
	 <!-- 表单验证                                                                                           结束 -->
  </head>
  
  <body>
    <!--uurframe盒子模型   上方					开始-->
    <div class="box8" panelWidth="536" panelHeight="300">
	    <form action="addDictDepart.action" method="post" name="addDepartForm" target="frmright">
	    	<table class="tableStyle" transMode="true" border="2" weight="100%" height="100%">
			    <tr>
					<td>部门名称: </td>
					<td align="left">
						<input type="text" id="_departName" name="dictDepart.departName"  maxlength="20" class="validate[required,custom[chinese],length[2,20]]"></input>
						<span id="errorMsg"></span>
					</td>
				</tr>
				<tr>	
					<td>部门拼音: </td>
					<td align="left">
						<input type="text" id="_py" name="dictDepart.py" maxlength="20" class="validate[custom[onlyLetter],length[2,20]]"></input>
					</td>
				</tr>
			  	<tr>	
					<td>备注: </td>
					<td align="left">
					<textarea rows="2" cols="3" id="_remark" name="dictDepart.remark" maxlength="500"></textarea>
	                </td>    
				</tr>	
	            <tr>
					<td colspan="2">
						<input type="button" id="addDepartSub" value="提 交"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重 置 "/>
					</td>
				</tr>      
			</table>
	    </form>
        </div>
        <!--uurframe盒子模型下方						结束-->
  </body>
</html>
