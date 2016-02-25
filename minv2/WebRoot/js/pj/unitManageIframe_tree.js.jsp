<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.repair.constant.Constants"%>


$(function(){
	  //弹出窗口关闭
    top.Dialog.close();
    <c:if test="${!empty message}">
		top.Dialog.alert('${message}');
	</c:if> 
	<c:remove var="message" scope="session"/>
});
<%--树形菜单设置 --%>
<!-- check：选择框或者单选框的设置 -->
<!-- data：数据的相关设置 -->
<!-- callback：节点相关事件 -->
var setting = {
	check: {
			enable: false
		},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback:{
		onClick:function(event,treeId,treeNode,clickFlag){
			//通过ID获取treeObj对象
			var treeObj=$.fn.zTree.getZTreeObj(treeId);
			//更改treeObj对象的选中状态
			//参数类型：treeNode、选择状态、是否联动、是否触发其他事件
			treeObj.checkNode(treeNode,true,false,true);
		},
		onCheck:function zTreeOnCheck(event, treeId, treeNode) {
			$("#"+treeNode.target).attr("src",treeNode.url);
		}
		
	}
};





var zNodes=[
	{
		  "name": "专业全部",
		  "id": "root",
		  "pId":"-1",
		  "open":true,
		  "target":"minv2_unitManageIframe_rightIframe",
		  "url":"queryPjStoreStaticInfo.action?flag=<%=Constants.QUERY_PJ_SD_INFO_PARAM_UNIT%>",
		  "dynamicCount":"${pjFirstUnitMap['root'] }",
		  children:[
			  	<c:forEach items="${pjFirstUnitList}" var="pjFirstUnit" varStatus="pjFirstUnitStatu">
				<c:set var="pjFirstUnitId" scope="request">
					${pjFirstUnit.id }
				</c:set>
				
				<%	
					 Map<String,Integer> pjFirstUnitMap=(Map<String,Integer>)session.getAttribute("pjFirstUnitMap");
					 String id=(String)request.getAttribute("pjFirstUnitId");
					 Integer count=pjFirstUnitMap.get(id);
					 request.setAttribute("count", count);
				 %>
				<%-- 显示专业信息 --%>
				{
					 "name": "${pjFirstUnit.firstUnitName}",
					 "id": "${pjFirstUnit.id }",
					 "target":"minv2_unitManageIframe_rightIframe",
					 "url":"queryPjStoreStaticInfo.action?firstUnitId=${pjFirstUnit.id }&flag=<%=Constants.QUERY_PJ_SD_INFO_PARAM_UNIT%>",
					 
					 "dynamicCount":"${count }"
				}
				<c:if test="${pjFirstUnitStatu.index != fn:length(pjFirstUnitList)-1 }">
						,
				</c:if>
				</c:forEach>
		  ]
	}

		
];

<c:remove var="pjFirstUnitList" scope="session"/>
<c:remove var="pjFirstUnitMap" scope="session"/>

$(function(){
		//初始化树形菜单
		$.fn.zTree.init($("#tree"), setting, zNodes);
		
		var nodes = $.fn.zTree.getZTreeObj("tree").getNodes();
		
		appendDynamicCount(nodes[0]);

		<!-- 由于动态配件个数显示的为蓝色，所以递归设置 -->		
		function appendDynamicCount(node){
			if(node){
				$("#"+node.tId+"_span").append("[<font color='blue'>"+node.dynamicCount+"</font>件]");
			}
			
			var childNodes=node.children;
			
			if(childNodes && childNodes.length != 0){
				for(var i=0;i<childNodes.length;i++){
					appendDynamicCount(childNodes[i]);
				}
			}
			
		}
		
});