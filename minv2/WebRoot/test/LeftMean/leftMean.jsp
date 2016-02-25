<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="pg" uri="page-taglib"%>
<%@include file="/common/taglibs.jsp" %>

<html>
  <head>
  	<title>机务检修信息管理系统-配件管理-->仓库管理</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	 
	 <script type="text/javascript" src="${ctx}js/leftMeanjquery.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
			$(".div2").click(function(){ 
				$(this).next("div").slideToggle("slow")  
				.siblings(".div3:visible").slideUp("slow");
			});
		});
	</script>
 </head>
<meta charset="utf-8">
<title>jquery网站后台管理系统导航 - 站长素材</title>

<style>
body{ margin:0;font-family:微软雅黑;}
.left{ width:200px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; color:#000000; font-size:14px; text-align:center;}
.div1{text-align:center; width:200px; padding-top:10px;}
.div2{height:40px; line-height:40px;cursor: pointer; font-size:13px; position:relative;border-bottom:#ccc 1px dotted;}
.jbsz {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/1.png);}
.xwzx {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/2.png);}
.zxcp {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/4.png);}
.lmtj {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; background:url(images/8.png);}
.div3{display: none;cursor:pointer; font-size:13px;}
.div3 ul{margin:0;padding:0;}
.div3 li{ height:30px; line-height:30px; list-style:none; border-bottom:#ccc 1px dotted; text-align:center;}
</style>
</head>
<body>
<div class="left">
<div class="div1">
<div class="left_top"><img src="images/bbb_01.jpg"><img src="images/bbb_02.jpg" id="2"><img src="images/bbb_03.jpg"><img src="images/bbb_04.jpg"> </div>
  <div class="div2"><div class="jbsz"> </div>仓库</div>
      <div class="div3">
<ul>
		<li> 仓库管理</li>
</ul>
  </div>
    
    <div class="div2"><div class="zxcp"> </div>专业</div>
      <div class="div3">
      <ul>
		<li>专业管理</li>
         </ul>
  </div>
   <div class="div2"><div class="xwzx"> </div>配件</div>
      <div class="div3">
      <ul>
		<li> 配件静态信息管理</li>
		<li> 新件入库</li>
		<li>
		  <div class="div2"><div class="xwzx"> </div> 配件静态信息管理</div>
			  <div class="div3">
			       <ul>
			          <li> 专业分类</li>
			           <li> 车型分类</li>
			       </ul>
		     </div>
        </li>
        <li>
		  <div class="div2"><div class="xwzx"> </div> 配件记录管理</div>
			  <div class="div3">
			       <ul>
			          <li> 配件出入库记录</li>
			       </ul>
		     </div>
        </li>
     </ul>
  </div>
</div>
</div>
</body>
</html>
