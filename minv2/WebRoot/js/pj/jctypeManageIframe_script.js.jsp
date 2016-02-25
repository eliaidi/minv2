<%@page import="com.repair.constant.Constants"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
$(function(){
	  //弹出窗口关闭
    top.Dialog.close();
    <c:if test="${!empty message}">
		top.Dialog.alert('${message}');
	</c:if> 
	<c:remove var="message" scope="session"/>
});

$(function() {
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
	
	var zNodes = [{
		"id": 1,
		"pId": 0,
		"name": "车型",
		"open": true,
		"url":"queryPjStoreStaticInfo.action?flag=<%=Constants.QUERY_PJ_SD_INFO_PARAM_JCTYPE %>",
		"target":"minv2_jctypeManageIfraame_rightIframe",
		"dynamicCount":"${jcTypeDcMap['root'] }",
		"children":[
			<!-- 显示机车型号信息 -->
			<c:forEach items="${jcTypeList}" var="jcType" varStatus="status" >
			<c:set var="jcTypeId" scope="request">${jcType.id }</c:set>
			<%	
				 Map<String,Integer> jcTypeDcMap=(Map<String,Integer>)session.getAttribute("jcTypeDcMap");
				 String id=(String)request.getAttribute("jcTypeId");
				 Integer count=jcTypeDcMap.get(id);
				 request.setAttribute("count", count);
			 %>
			{
				id:"${jcType.id }",
				pId:1,
				name:'${jcType.jcTypeValue }' ,
				"url":"queryPjStoreStaticInfo.action?flag=<%=Constants.QUERY_PJ_SD_INFO_PARAM_JCTYPE %>&jcTypeId=${jcType.id }",
				"target":"minv2_jctypeManageIfraame_rightIframe",
				"dynamicCount":"${count}",
				"children":[
					<!-- 显示专业信息 -->
					<c:forEach items="${jcType.jcTypePjFirstUnits }" var="jcTypePjFirstUnit" varStatus="jtpuStatus">
					<c:set var="dictPjFirstUnit" value="${jcTypePjFirstUnit.dictPjFirstUnit }" scope="request"></c:set>
					{
						id:"${jcType.id }-${dictPjFirstUnit.id}",
						pId:"${jcType.id}",
						name:"${dictPjFirstUnit.firstUnitName }",
						"url":"queryPjStoreStaticInfo.action?flag=<%=Constants.QUERY_PJ_SD_INFO_PARAM_JCTYPE %>&firstUnitId=${dictPjFirstUnit.id }",
						"target":"minv2_jctypeManageIfraame_rightIframe",
						"dynamicCount":"<s:property value="@com.repair.pojoUtil.PjSDInfoUtil@getDynamicCountByDictPjFirstUnit(#request.dictPjFirstUnit)" />"
					}	
					<c:if test="${jtpuStatus.index != fn:length(jcType.jcTypePjFirstUnits) }">
						,
					</c:if>
					
					</c:forEach>
				]
			}
			<c:if test="${status.index != fn:length(jcTypeList) }">
				,
			</c:if>
			
			</c:forEach>
		]
	}]

	$(function() {
		$.fn.zTree.init($("#tree"), setting, zNodes);
		
		var nodes = $.fn.zTree.getZTreeObj("tree").getNodes();
		
		appendDynamicCount(nodes[0]);
		
		<!-- 由于动态配件个数显示的为蓝色，所以递归设置 -->		
		function appendDynamicCount(node){
			
			//$("#"+node.tId+"_span").append("[<font color='blue'>"+node.dynamicCount+"</font>件]");
		
			$("span[id='"+node.tId+"_span']").html($("#"+node.tId+"_span").html()+"[<font color='blue'>"+node.dynamicCount+"</font>件]");
		
			var childNodes=node.children;
			
			if(childNodes){
				for(var i=0;i<childNodes.length;i++){
					appendDynamicCount(childNodes[i]);
				}
			}
			
			
			
		}
		
	})
})

<c:remove var="jcTypeList" scope="session"/>