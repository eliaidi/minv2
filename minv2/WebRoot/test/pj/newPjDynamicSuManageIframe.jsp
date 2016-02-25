<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


<html>
  <head>
    <title>机务检修信息管理系统-配件管理-配件-新件入库</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  
    
    <!-- 显示树形菜单		开始 -->
    <script>
    	var setting = {
			check: {
				enable: false
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		
		var zNodes =[
			{ id:1, pId:0, name:"专业全部[26件]", open:true},
			{ id:11, pId:1, name:"电机[8件]", open:true},
			{ id:111, pId:1, name:"柴油机[3件]"},
			{ id:112, pId:1, name:"仪表[15件]"}
		];
		
		$(function(){
			$.fn.zTree.init($("#tree"), setting, zNodes);
		})
    </script>
    <!-- 显示树形菜单		结束 -->
  </head>
  
  <body>
  	<!-- newPiecesManageIfraame_mainDiv 主div                                           开始 -->
    <div id="minv2_newPiecesManageIframe_mainDiv" class="">
    	 <!--左边菜单DIV                                                                     开始-->
            <div id="minv2_newPiecesManageIframe_leftDiv" class="">
            	<!-- 盒子模型上方                                                            开始 -->
				<div class="box2" panelWidth="230" panelHeight="520" style="float:left" panelTitle="专业管理" overflow="auto" >
					
			  	    <!-- 大部件(专业)(unit)目录数据的显示 DIV						开始-->
					<div id="scrollContent">
						<div id="tree" class="ztree">
							
						</div>
				    </div>
				    <!-- 大部件(专业)(unit)目录数据的显示 DIV						结束-->
			    </div>
			    <!-- 盒子模型上方                                                            结束 -->			
            </div>
            <!--左边菜单DIV                                                                  结束-->
            
            <!--右边内容DIV                                                                  开始-->
            <div id="minv2_newPiecesManageIframe_rightDiv" style="display:inline">
            	<iframe id="minv2_newPiecesManageIframe_contentIframe" name="minv2_newPiecesManageIframe_rightIframe" class="" scrolling="auto" frameborder="no" src="newPjDynamicSuManageChildIframe.jsp"  width="1100" height="600"></iframe>
            </div> 
            <!--右边内容DIV                                                                  结束-->
    </div>
    <!-- newPjDynamicSuManageChildIframe_mainDiv 主div                                           结束 -->
  </body>
</html>


