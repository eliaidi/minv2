<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

  <head>
    <title>${cache['SYS_TITLE'][0].value}-班组新增</title>
    <base href="<%=basePath%>">
   	
  </head>
  <body>
    <!--uurframe盒子模型   上方					开始-->
    <div panelWidth="536" panelHeight="366" id="addProteamDiv" >
    	<!-- 设置target属性，当提交表单时，将会自动刷新父页面 -->
    	<form action="addDictProteam.action" method="post" name="addProteamForm" target="frmright">
		    <table class="tableStyle" formMode="true" transMode="true" border="2" weight="100%" height="100%">
				    <tr>
						<td>班组名称: </td>
						<td >
							<input  type="text" name="proteamName"  id="proteamName" />
							<span id="errorMsg"></span>
						</td>
					</tr>
					<tr>	
						<td>是否考勤: </td>
						<td >
							<input  type="radio" name="attendanceFlag" id='attendanceFlagNo' value="0" checked="checked"/><label for="attendanceFlagNo">不考勤</label>
							<input  type="radio" name="attendanceFlag" value="1" id='attendanceFlagYes'/><label for="attendanceFlagYes">考勤</label>
						</td>
					</tr>
				  	
					<tr>	
						<td>班组类型: </td>
						<td>
						<!-- 班组类型数据选择                                                                                                                 开始(class:render) -->
							<div class="">	
			                     <input type="radio"  name="workFlag"  id='bz_bz' value="0" /><label for="bz_bz">不修班组</label>
			                     <input type="radio"  name="workFlag"  id='xf_xbz' value="1" checked="checked"/><label for="xf_xbz">小辅修班组</label>
			                     <input type="radio"  name="workFlag"  id='zx_bz' value="2" /><label for="zx_bz">中修班组</label>
			                     <input type="radio"  name="workFlag"  id='zx_xfx_xz' value="3" /><label for="zx_xfx_xz">中修、小辅修班组</label>
		                    </div>
		                <!-- 班组类型数据选择                                                                                                                 结束 -->        
						</td>
					</tr>   
		            <tr>
						<td colspan="2">
							<input type="button" id="enter"  value="新 增"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="重 置 "/>
						</td>
					</tr>      
				</table>
			</form>
        </div>
        <!--uurframe盒子模型下方						结束-->
  </body>
  
  <!-- 此页面需要用到的JS -->
  <script type="text/javascript" src="${ctx}/js/users/addProteamDialog_script.js"></script>
  
</html>
