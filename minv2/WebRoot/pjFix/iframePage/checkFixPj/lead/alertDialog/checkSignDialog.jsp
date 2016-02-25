<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		<title>工长（检查项目签认（子窗口））</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<!-- 引用js文件				开始 -->
   		 <script type="text/javascript" src="${ctx}/js/pjFix/pjFixItem/lead/checkSignRecognitionDialog_script.js"></script>
    	<!-- 引用js文件				结束 -->
  </head>
  
  <body>
		<div class="" panelTitle="检查项目签认">
			<input type="hidden" name="ids" id="ids" value="${param.ids}"/>
			<table class="tableStyle" transMode="true">
			
				<tr>
					<td>检查情况：</td>
					<td colspan="2">
					<select id="defaultValue" name="defaultValue">
							<option value="良好">请选择或输入</option>
						    <option value="良好">良好</option>
						    <option value="更换良好">更换良好</option>
						    <option value="检修良好">检修良好</option>
						    <option value="清洗良好">清洗良好</option>
						    <option value="处理后探伤良好">处理后探伤良好</option>
						    <option value="没有启用">没有启用</option>
						 </select>				
					</td>
				</tr>
				
			</table>
		</div>
  </body>
</html>
