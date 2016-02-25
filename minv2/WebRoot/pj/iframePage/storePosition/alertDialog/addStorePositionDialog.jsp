<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>${cache['SYS_TITLE'][0].value}-配件管理-仓库-仓库管理-新增</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
  </head>
  <body>
    <!--uurframe盒子模型   上方					开始-->
     <div panelTitle="仓库-仓库管理-修改" roller="false" overflow="true">
     	<form action="" method="post" id="addDictStorePosition" name="addDictStorePosition" target="frmright">
		    <table  transMode="true" align="center">
				<s:token></s:token>     
			    <tr>
			    	<td>仓库名：</td>
			    	<td><input type="text" id="storePositionName" name="storePositionName"  class="validate[required,length[1,20]]"/></td>
			    </tr>
			    <tr>
			    	<td>机务段：</td>
			    	<td>
			    		<select name="dictArea.id" id="dictArea.id">
			    		<c:forEach items="${areaList }" var="area">
			    			<option value="${area.id }">${area.areaName }</option>
			    		</c:forEach>
			    		</select>
			    	</td>
			    </tr> 
			      <tr>
			    	<td>班组：</td>
			    	<td>
			    		<select name="dictProteam.id" id="dictProteam.id">
			    		<c:forEach items="${dpList }" var="dp">
			    			<option value="${dp.id }">${dp.proteamName }</option>
			    		</c:forEach>
			    		</select>
			    	</td>
			    </tr> 
			    
			    <tr>
			    	<td>仓库类型：</td>
			    	<td>
			    		<select name="storePositionType" id="storePositionType">
			    			<c:forEach items="${storePositionType}" var="storePosition">
			    				<option value="${storePosition.key }">${storePosition.value }</option>
			    			</c:forEach>
			    		</select>
			    	</td>
			    </tr>   
			    <tr>
			        <td colspan="2">
				        <input type="hidden" value="fewfwe" name="remark"/>
				    	<input type="hidden" value="cctt" name="py"/>
			       		<button id="addStorePositionSubmit" name="addStorePositionSubmit"><span class="icon_edit">提交</span></button>
			       	</td>
			    </tr>      
			</table>
    	</form>
     </div>
        <!--uurframe盒子模型下方						结束-->
  </body>
  <!-- 自定义js -->
<script type="text/javascript" src="${ctx}/js/pj/addStorePositionDialog_script.js"></script>
</html>
