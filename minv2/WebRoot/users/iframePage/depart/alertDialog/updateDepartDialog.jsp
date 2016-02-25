<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
  <head>
    <title>管理员界面-->用户角色-->用户管理-->部门目录-->修改部门页面</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="${ctx}/js/users/updateDepartDialog_script.js" type="text/javascript"></script>
    <!-- 表单验证                                                                               开始 -->
	 <script type="text/javascript" src="${ctx}/js/validationEngine/validationEngine-cn.js"></script>
	 <script type="text/javascript" src="${ctx}/js/validationEngine/validationEngine.js"></script>
	 <!-- 表单验证                                                                                           结束 -->
  </head>
  
  <body>
    <!--uurframe盒子模型   上方					开始-->
     <div class="box8" panelWidth="536" panelHeight="300">
	    <form action="updateDictDepatById.action" method="post" id="updateDepartForm"  name="updateDepartForm" target="frmright">
	    <input type="hidden" name="dictDepart.id" value="${dictDepart.id }"/>
	    <table class="tableStyle" transMode="true" border="2">
			    <tr>
					<td>部门名称: </td>
					<td>
						<input type="text" id="_departName" name="dictDepart.departName" value="${dictDepart.departName }" maxlength="20" class="validate[required,custom[chinese],length[2,20]]"></input>
						<input type="hidden" id="_startDepartName" value="${dictDepart.departName }" />
						<span id="errorMsg"></span>
					</td>
				</tr>
				<tr>	
					<td>部门拼音: </td>
					<td>
						<input type="text" id="_py" name="dictDepart.py" value="${dictDepart.py }" maxlength="20" class="validate[custom[onlyLetter],length[2,20]]"></input>
					</td>
				</tr>
			  	<tr>	
					<td>备注: </td>
					<td>
					<textarea rows="4" cols="5" id="_remark" name="dictDepart.remark" maxlength="500">${dictDepart.remark }</textarea>
	                </td>    
				</tr>	
	            <tr>
					<td colspan="2">
						<input type="button" id="updateDepartSub"  value="修 改"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重 置 "/>
					</td>
				</tr>      
			</table>
			</form>
        </div>
        <!--uurframe盒子模型下方						结束-->
  </body>
</html>
