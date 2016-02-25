<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>


<html>
  <head>
    <title>${cache['SYS_TITLE'][0].value}--配件管理-配件-新件入库</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="this is my page"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
  	<!-- dynaTree树形菜单组件-加载数据js                               开始 -->
    <script src="${ctx}/js/pj/newPjDynamicSuManageIframe_tree_script.js.jsp" type="text/javascript"></script>
    <!-- dynaTree树形菜单组件-加载数据js                               结束 -->
  
  </head>
  
  <body>
  	<!-- newPjDynamicSuManageIframe_mainDiv 主div                                           开始 -->
    <div id="minv2_newPiecesManageIframe_mainDiv" class="minv2_newPjDynamicSuManageIframe_mainDiv_class">
    	 <!--左边菜单DIV                                                                     开始-->
            <div id="minv2_newPiecesManageIframe_leftDiv" class="minv2_newPjDynamicSuManageIframe_leftDiv_class">
            	<!-- 盒子模型上方                                                            开始 -->
				<div class="box2" panelWidth="230" style="float:left" panelHeight="520" panelTitle="专业管理" overflow="auto" >
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
            <div id="minv2_newPiecesManageIframe_rightDiv" class="minv2_newPjDynamicSuManageIframe_rightDiv_class" style="display:inline">
            	<iframe id="minv2_newPiecesManageIframe_contentIframe" name="minv2_newPiecesManageIframe_rightIframe" class="minv2_newPjDynamicSuManageIframe_rightIframe_class"
            	 scrolling="no" frameborder="no" width="850" height="532" src="findPagePjStoreDynamicInfoByDictFirstUnitId.action" ></iframe>
            </div> 
            <!--右边内容DIV                                                                  结束-->
    </div>
    <!-- newPjDynamicSuManageChildIframe_mainDiv 主div                                           结束 -->
  </body>
</html>


