<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


  <head>
    <title>${cache['SYS_TITLE'][0].value}-修改班组</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
   	
  </head>
 
  <body>
    <!--uurframe盒子模型   上方					开始-->
     <div  panelWidth="600" panelHeight="410">
     	<form action="updateDictProteamById.action" target="frmright" name="updateProteamForm">
		    <table class="tableStyle" transMode="true" border="2">
				    <tr>
						<td>班组名称: </td>
						<td>
							<input type="hidden" name="id" value="${proteam.id }"/>
							<input type="hidden" name="versionId" value="${proteam.versionId }"/>
							<input type="text" name="proteamName" id="proteamName" value="${proteam.proteamName }"></input>
							<span id="errorMsg"></span>
						</td>
					</tr>
					<tr>	
						<td>是否考勤: </td>
						<td >
							<input  type="radio" name="attendanceFlag" value="0" ${proteam.attendanceFlag == 0 ? 'checked' : '' }/>不考勤
							<input  type="radio" name="attendanceFlag" value="1" ${proteam.attendanceFlag == 1 ? 'checked' : '' }/>考勤
						</td>
					</tr>
				  	
					<tr>	
						<td>班组类型: </td>
						<td>
						<!-- 班组类型数据选择                                                                                                                 开始 -->
							<div class="render">	
			                     <input type="radio"  name="workFlag"  value="0" ${proteam.workFlag == 0 ? 'checked' : ''}/>不修班组
			                     <input type="radio"  name="workFlag"  value="1" ${proteam.workFlag == 1 ? 'checked' : ''} />小辅修班组
			                     <input type="radio"  name="workFlag"  value="2" ${proteam.workFlag == 2 ? 'checked' : ''} />中修班组
			                     <input type="radio"  name="workFlag"  value="3" ${proteam.workFlag == 3 ? 'checked' : ''} />中修、小辅修班组
		                    </div>
		                <!-- 班组类型数据选择                                                                                                                 结束 -->        
						</td>
					</tr>    
		            <tr>
						<td colspan="2">
							<input type="button" id="enter"  value="修 改"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" id="reset" value="重 置 "/>
						</td>
					</tr>      
				</table>
			</form>
        </div>
        <!--uurframe盒子模型下方						结束-->
  </body>
  
  <!-- 此页面需要用到的JS -->
  <script type="text/javascript" src="${ctx}/js/users/updateProteamDialog_script.js"></script>
</html>
