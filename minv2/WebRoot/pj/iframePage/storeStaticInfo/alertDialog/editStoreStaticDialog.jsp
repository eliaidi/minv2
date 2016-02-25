<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<html>
  <head>
  	<title>${cache['SYS_TITLE'][0].value}-->配件管理-配件-配件静态信息管理-新增</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<script  src="${ctx }/js/pj/editStoreStaticDialog_script.js"></script>
 </head>
  
  <body>
  <div panelTitle="配件静态信息管理-新增" roller="false" overflow="true">
  		<form action="addPjStoreStaticInfo.action" method="post" onSubmit="formSubmit()" name="addPjStoreStaticInfo" target="frmright">
	        <s:token></s:token>
	        <table formMode="true" align="center" id="_DialogFrame_0">
	        
	            <tr>
	                 <td>静态名称:&nbsp;</td>
	                 <td align="left"><input type="text" name="pjName" class="validate[required,length[2,10]]"/></td>
	            </tr>
	            <tr>
	                 <td>拼  音:&nbsp;</td>
	                 <td align="left"><input type="text" name="py" watermark="输入小写英文首字母" class="validate[required,length[2,10]]"/></td>
	            </tr>
	            
	            <tr>
	                 <td >父级配件:&nbsp;</td>
	                 <td align="left">
	                 <input type="text" name="parentName"  id="showParentStoreInfo"/>
	                  <input type="hidden" name="parentpId" id="showParentStoreInfoId"/>
	                 </td>
	                
	            </tr>

	            <tr>
	                 <td>组装状态:&nbsp;</td>
	                 <td>
	                
	                     <select name="pjAssemblyType" id="pjAssemblyTypeId">
	                          <c:forEach var="items"  items="${pjAssemblyType}">
		                     	<option value="${items.key }">${items.key }、${items.value }</option>
		                     </c:forEach>	
		                 </select>
	                 </td>
	            </tr>
	            <tr>
	                 <td>配件班组:&nbsp;</td>
	                 <td>
	                 
	                     <select multiple id="proteamId" name="proteamId">
	                       <c:forEach var="proteam" items="${dictProteams}">
		                     <option value="${proteam.id}">${proteam.proteamName }</option>
		                    </c:forEach>  
		                 </select> 
		             </td>
	            </tr>
	           
	            <tr>
	                 <td>车型专业:&nbsp;</td>
	                 <td>
	               
	                 	<select multiple id="jcTypePjFirstUnitId" name="jcTypePjFirstUnitId">
	                 		<c:forEach var="jcTypePjFirstUnit" items="${jcTypePjFirstUnitList}">
		                 		<option value="${jcTypePjFirstUnit.id}" >${jcTypePjFirstUnit.dictJcType.jcTypeValue}-${jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName}</option>
	                 		</c:forEach>
	                 	</select>
	                 </td>
	            </tr>
	            <tr>
	                <td>最小库存:&nbsp;</td>
	                <td >
	                	<input type="text" name="pjLoweStstore" class="validate[required,custom[onlyNumber]]"/>
	                </td>
	            </tr>
	            <tr>
	            	<td></td>
	            	<td > 
	            		&nbsp;&nbsp;
	            			
	            		<input type="checkbox" id="enable" checked value="1" name="pjActivate"/><label for="isOpen">是否启用</label>
	            	</td>
	            </tr>
	             <tr>
	             	<td colspan="2">
	             		<input type="submit" value="新增"/>
	                	<input type="reset" value="重置"/>
	                </td>
	            </tr>
	        </table>
	      </form>
	    </div>  
  </body>
</html>
