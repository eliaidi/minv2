<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html>
  <head>
    <title>main.html</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
         <!-- 头部div             
         <div style="width:100%;height: 80px">
            <iframe style="width:100%;height: 110px " src="top.jsp"  MARGINHEIGHT="0" MARGINWIDTH="0" framespacing="0"
                    frameborder="0" scrolling="yes" >
            </iframe>
        </div>
                     		-->
        	
        <!-- 中部左侧管理菜单             				 开始-->
        <div style="width:100%;height: 600px">
         <jsp:include page="/users/iframePage/navigationDrawerIframe.jsp"></jsp:include>
        </div>	
        <!-- 中部左侧管理菜单           			 			  结束-->
  </body>
</html>
