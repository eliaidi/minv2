<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  	<title>${cache['SYS_TITLE'][0].value}-->配件管理-配件-配件静态信息管理-新增</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<script  src="${ctx }/js/pj/updateStoreStaticDialog_script.js"></script>
 </head>
  
  <body>
  <div panelTitle="配件静态信息管理-修改" roller="false" overflow="true" >
  		<form action="updatePjStoreStaticInfo.action" name="updatePjStoreStaticInfo" method="post" target="frmright" onSubmit="return formSubmit()" id="_DialogFrame_0">
	        <table transMode="true" align="center" >
	            <tr>
	            	<input type="hidden" name="id" value="${staticInfo.id }"/>
	                 <td>静态名称:&nbsp;</td>
	                 <td align="left"><input type="text" name="pjName" value="${staticInfo.pjName}"/></td>
	            </tr>
	            <tr>
	                 <td>拼  音:&nbsp;</td>
	                 <td align="left"><input type="text" name="py" value="${staticInfo.py}"/></td>
	            </tr>
	            
	            <tr>
	                 <td >父级配件:&nbsp;</td>
	                 <td align="left"><input type="text" name="" value="${staticInfo.parentPjStoreStaticInfo.pjName}" id="showParentStoreInfo"/>
	                 <input type="hidden" name="parentpId" name="parentpName" id="showParentStoreInfoId"/>
	                 </td>
	                 
	            </tr>

	            <tr>
	                 <td>组装状态:&nbsp;</td>
	                 <td>
	                     <select name="pjAssemblyType" id="pjAssemblyTypeId">
	                          <c:forEach var="item"  items="${pjAssemblyType}">
		                     <option ${staticInfo.pjAssemblyType == item.key ? 'selected' : ''} value="${item.key}" >${item.value }</option>
		                     </c:forEach>	
		                 </select>
	                 </td>
	            </tr><!-- staticInfoE -->
	            <tr>
	         
	                 <td>配件班组:&nbsp;</td>
	                    
	                 <td>
	                     <select multiple id="proteamId" name="proteamId">
	                       <c:forEach var="proteam" items="${dictProteams}">
	                       	<c:set var="found" value="false"></c:set>
	                           <c:forEach var="proteamPjStatic" items="${staticInfo.proteamPjStatics}"> 
	                               <c:if test="${!found}">
		                 	   			<c:if test="${proteamPjStatic.dictProteam.id == proteam.id}">
		                 	   				<c:set var="found" value="true"></c:set>
		                 	   			</c:if>
		                 	   			</c:if>
	                           </c:forEach>
		                     <option  ${found ? 'selected' :'' } value="${proteam.id}" >${proteam.proteamName }</option>
		                    </c:forEach>  
		                 </select> 
		             </td>
	            </tr>
	            <tr>
	                 <td>车型专业:&nbsp;</td>
	                 <td>
	                 	<select multiple id="jcTypePjFirstUnitId" name="jcTypePjFirstUnitId">
	                 	   <c:forEach var="jcTypePjFirstUnit" items="${jcTypePjFirstUnitList}">
	                 		  <c:set var="found" value="false"></c:set>
	                 		      <c:forEach var="pjStaticJcTypePjFU" items="${staticInfo.pjStaticJcTypePjFUs}">
	                 		      <c:if test="${!found}">
		                 	   			<c:if test="${pjStaticJcTypePjFU.jcTypePjFirstUnit.id == jcTypePjFirstUnit.id}">
		                 	   				<c:set var="found" value="true"></c:set>
		                 	   			</c:if>
	                 	   		  </c:if>
	                 		</c:forEach>
	                 		<option ${found ? 'selected' :'' }  value="${jcTypePjFirstUnit.id}">${jcTypePjFirstUnit.dictJcType.jcTypeValue}-${jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName}</option>
	                 		 </c:forEach>
	                 	</select>
	                 </td>
	            </tr>
	            <tr>
	                <td>最小库存:&nbsp;</td>
	                <td >
	                	<input type="text" name="pjLoweStstore" value="${staticInfo.pjLoweStstore}"/>
	                </td>
	            </tr>
	            <tr>
	            	<td></td>
	            	<td > 
	            		<input type="hidden" name="pjActivate" id="pjActivate" value="${staticInfo.pjActivate}"/>
	            		&nbsp;&nbsp;
	            		<c:if test="${staticInfo.pjActivate==1}">
	            		   <input type="checkbox" value="1" id="enable"  checked/><label for="enable">是否启用</label>
	            		</c:if>	
	            		<c:if test="${staticInfo.pjActivate==0}">
	            		   <input type="checkbox" value="0" id="enable" /><label for="enable">是否启用</label>
	            		</c:if>	
	            		
	            	</td>
	            </tr>
	             <tr>
	             	<td colspan="2">
	             		<input type="submit" value="修改"/>
	                	<input type="reset" value="重置"/>
	                </td>
	            </tr>
	        </table>
	      </form>
	    </div>  
  </body>
</html>
