<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
  	<title>${cache['SYS_TITLE'][0].value}--->配件管理-配件-配件静态信息管理-静态配件详细信息</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
 </head>
  <body>
     <div panelTitle="静态配件详细信息" roller="false" overflow="true">
 		<form action="" method="post">
 		    <input type="hidden" id="staticId" value="${pjSSInfo.id }"/>
	 		<input type="hidden" id="pjActivate" value="${pjSSInfo.pjActivate }"/>
            <table transMode="true" align="center">
	        
            <tr>
                 <td>静态名称：&nbsp;</td>
                 <td ><input type="text" name="pjName" value="${pjSSInfo.pjName }" disabled="disabled"/></td>
            </tr>
            <tr>
                 <td>拼 &nbsp;&nbsp;&nbsp;&nbsp&nbsp; 音：</td>
                 <td ><input type="text" name="py" value="${pjSSInfo.py }" disabled="disabled"/></td>
            </tr>
            
            <tr>
                 <td style="color:blue">父级配件：&nbsp;</td>
                 <td align="left">
						<input type="text" name="" value="${pjSSInfo.parentPjStoreStaticInfo.pjName}" disabled="disabled"/>
                 </td>
            </tr>
            
			 <tr>
                 <td style="color:blue">子级配件：&nbsp;</td>
                 <td align="left">
                   <span>
                 	<c:forEach var="childPj" items="${pjSSInfo.childPjStoreStaticInfos}">
                 		${childPj.pjName} &nbsp;&nbsp;&nbsp;&nbsp;
                 	</c:forEach>
                 </span>
                 </td>
            </tr>
            <tr>
                 <td>组装状态：&nbsp;</td>
                 <td>
                 <span>
                     <c:if test="${pjSSInfo.pjAssemblyType==1}">配件组装</c:if>
                     <c:if test="${pjSSInfo.pjAssemblyType==0}">车上组装</c:if>
                 </span>
                 </td>
            </tr>
            <tr>
                 <td>配件班组：&nbsp;</td>
                 <td>
                 <span>
                     <c:forEach items="${pjSSInfo.proteamPjStatics}" var="proteamPjStatic">
	                     ${proteamPjStatic.dictProteam.proteamName}&nbsp;&nbsp;&nbsp;&nbsp;
	                   </c:forEach>
                 </span>
                     
	             </td>
            </tr>
           
            <tr>
                 <td>专业名称：&nbsp;</td>
                 <td>
                   <span>
                 	<c:forEach var="pjStaticJcTypePjFU" items="${pjSSInfo.pjStaticJcTypePjFUs}">
					 		${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName}&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					</span>
                 </td>
            </tr>
            <tr>
                 <td style="color:blue">适应车型：&nbsp;</td>
                 <td>
                   <span>
	                    <c:forEach var="pjStaticJcTypePjFU" items="${pjSSInfo.pjStaticJcTypePjFUs}">
	                         ${pjStaticJcTypePjFU.jcTypePjFirstUnit.dictJcType.jcTypeValue} &nbsp; &nbsp;&nbsp; &nbsp;
	                    </c:forEach>
                   </span> 
                 </td>
            </tr>
            <tr>
                <td>最小库存：&nbsp;</td>
                <td >
                	<input type="text" name="pjLoweStstore" value="${pjSSInfo.pjLoweStstore}" disabled="disabled"/>
                </td>
            </tr>
            <tr>
            	<td colspan="2"> 
            	<c:if test="${pjSSInfo.pjActivate==1}">
            	     <input type="checkbox" id="isOpen" checked disabled="disabled"/><label for="isOpen">是否启用</label>
            	</c:if>
            	<c:if test="${pjSSInfo.pjActivate==0}">
            	     <input type="checkbox" id="isOpen" disabled="disabled"/><label for="isOpen">是否启用</label>
            	</c:if>
            		
            	</td>
            </tr>
        </table>
      </form>
   </div>
  </body>
</html>
