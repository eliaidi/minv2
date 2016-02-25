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
	
	<script  src="${ctx }/js/pj/storeStaticDialogInfo_script.js"></script>
	
 </head>
  
  <body>
  <div panelTitle="配件静态信息管理-新增" roller="false" overflow="true">
  <br/>
  <table id="table1">
     <tr>
        <c:forEach var="pjStoreStatic" items="${pjStoreStaticInfo}">
         
	        <input type="radio" name="storeStaticInfoId" id="radioId${pjStoreStatic.id}" value="${pjStoreStatic.id }"/>
	          <label for="radioId${pjStoreStatic.id}">${pjStoreStatic.pjName }&nbsp;&nbsp;&nbsp;&nbsp;</label>
	   
       </c:forEach>
     </tr>
  </table>
  		    
	    </div>  
  </body>
</html>
