<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<html>
  <head>
  	<title>${cache['SYS_TITLE'][0].value}--->配件管理-配件-配件静态信息管理-新增</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
 </head>
  
  <body>
  <div panelTitle="专业管理-编辑专业" roller="false" overflow="true">
  		<form action="updateDictPjFirstUnit.action" method="post" target="frmright">
	        <table transMode="true" align="center">
	       
	            <tr>
	            	 <input type="hidden" name="id" value="${PjFirstUnit.id }"/>
	                 <td>大部件/专业名称:&nbsp;</td>
	                 <td ><input type="text" name="firstUnitName" value="${PjFirstUnit.firstUnitName}"/></td>
	            </tr>
	            <tr>
	                 <td>拼  音:&nbsp;</td>
	                 <td ><input type="text" name="py" value="${PjFirstUnit.py}"/></td>
	            </tr>
	            
	            <tr>
	                 <td >机车型号:&nbsp;</td>
	                 <td >
	                  
	                 	<select multiple id="jcTypeId" name="jcTypeId">
	                 	   <c:forEach var="jctype" items="${dictJcType}">
	                 	   		<c:set var="found" value="false"></c:set>
	                 	   		<c:forEach items="${PjFirstUnit.jcTypePjFirstUnits}" var="jtpfu">
	                 	   			<c:if test="${!found}">
		                 	   			<c:if test="${jtpfu.dictJcType.id == jctype.id}">
		                 	   				<c:set var="found" value="true"></c:set>
		                 	   			</c:if>
		                 	   		</c:if>
	                 	   		</c:forEach>
		                 		<option ${found ? 'selected' :'' } value="${jctype.id}">${jctype.jcTypeValue}</option>
	                 		</c:forEach>
	                 	</select>
	                 </td>
	            </tr>
				<tr >
					<td colspan="2">
						<input type="submit" value="修改"/>
						<input type="button" value="取消"/>		
					</td>
				</tr>
	        </table>
	      </form>
	    </div>  
  </body>
</html>
