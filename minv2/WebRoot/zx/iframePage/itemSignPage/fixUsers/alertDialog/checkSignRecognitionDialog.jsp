<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html>
	<head>
		 <title>工人（检查项目签认（子窗体））</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
  </head>
  
  <body>
		<div class="box1" panelTitle="检查项目签认"  panelWidth="310">
			<table class="tableStyle" align="center" style="width:290px">
				<tr>
					<td align="center">检查情况：
					<select id="fixCondition" name="defaultValue">
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
