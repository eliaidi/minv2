<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${urlctx }">
    
    <title>My JSP 'updProteam.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   
  </head>
  
  <body>
     <!--uurframe盒子模型   上方					开始-->
    <div class="box4" panelWidth="750" panelHeight="550"  panelTitle="修改班组">
	    <table class="tableStyle" transMode="true">
			    <tr>
					<td>班组名称: </td>
					<td>
						<input class="easyui-validatebox" type="text" name="dictproteam.proteamname" value="交车组"></input>
					</td>
				</tr>
				<tr>	
					<td>班组拼音: </td>
					<td>
						<input class="easyui-validatebox" type="text" name="dictproteam.py" value="JCZ"></input>
					</td>
				</tr>
			  	<tr>	
					<td>适应车型: </td>
					<td>
					<!-- 显示车型数据                                                                  开始-->
						<div id="checkGroup" class="render">
		                      <input type="checkbox"  name="jctypes" value="DF5" checked="checked"/>DF5
		                      <input type="checkbox"  name="jctypes" value="DF5D" checked="checked"/>DF5D
		                      <input type="checkbox"  name="jctypes" value="DF4" checked="checked"/>DF4
		                      <input type="checkbox"  name="jctypes" value="DF11" checked="checked"/>DF11
		                      <input type="checkbox"  name="jctypes" value="SS8" checked="checked"/>SS8  
		                      <input type="checkbox"  name="jctypes" value="SS9" />SS9
		                      <input type="checkbox"  name="jctypes" value="HXD3C" checked="checked"/>HXD3C           
		                      <input type="checkbox"  name="jctypes" value="DF12" checked="checked"/>DF12
		                      <input type="checkbox"  name="jctypes" value="DF11G" checked="checked"/>DF11G
		                      <input type="checkbox"  name="jctypes" value="HXD1D" />HXD1D
		                  <div class="clear"></div>
	                    </div>
	                <!-- 显示车型数据                                                                  结束 -->
	                </td>    
	                    <td><input type="button" value="全选" onclick="checkSelAll()"/></td>
				</tr>	
				<tr>	
					<td>班组类型: </td>
					<td>
					<!-- 班组类型数据选择                                                                                                                 开始 -->
						<div class="render">	
		                     <input type="radio"  name="flag"  value="0" />小辅修班组
		                     <input type="radio"  name="flag"  value="1" />中修班组
		                     <input type="radio"  name="flag"  value="2" />中修、小辅修班组
		                     <input type="radio"  name="flag"  value="3" checked="checked"/>管理部门
	                    </div>
	                <!-- 班组类型数据选择                                                                                                                 结束 -->        
					</td>
				</tr>   
	            <tr>
					<td colspan="2">
						<input type="button" id="enter"  value="修 改"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重 置 "/>
					</td>
				</tr>      
			</table>
        </div>
        <!--uurframe盒子模型下方						结束-->
  </body>
</html>
