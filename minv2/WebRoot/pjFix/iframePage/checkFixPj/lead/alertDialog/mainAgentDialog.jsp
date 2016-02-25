<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>

	<head>
		 <title>mainAgentDialg.jsp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
  </head>
  
  <body>
		<div class="box2" panelWidth="500" panelTitle="探伤签认">
			<table class="tableStyle" transMode="true">
				<tr>
					<td>探伤情况：</td>
					<td>
					<select id="sel2" colNum="3">
							<option>请选择或输入</option>
						    <option>良好</option>
						    <option>一般</option>
						    <option>优秀</option>
						    <option>很差</option>
						 </select>				
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value=" 提 交 "/>
						<input type="reset" value=" 重 置 "/>
					</td>
				</tr>
			</table>
		</div>
  </body>
</html>
