<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="/common/taglibs.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript">
       $(function(){
           $("#btn").click(function(){
               if($("#divId").css("display")=='none')
                {
                  $("#divId").css("display",'block');
               } 
               else
               {
                  $("#divId").css("display",'none')
               }
             
           });
       });
   </script>
  </head>
    
  <body>
    <div style="background-color: ffff;width:200px;position:absolute;top:100px;left: 100px ">
      <div id="divId" style="display:none">
           <span>此用户拥有的角色权限：机车检修，工人签认，</span>
      </div>
      <a id="btn">Click</a>
    </div>
  </body>
</html>
