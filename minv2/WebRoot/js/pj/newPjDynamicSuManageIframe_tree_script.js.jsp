<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.repair.constant.Constants"%>

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




<%-- 树数据显示大部件专业 --%>
var zNodes=[
	{
		  "name": "专业全部",
		  "id": "root",
		  "pId":"-1",
		  "open":true,
		  "target":"minv2_newPiecesManageIframe_rightIframe",
		  "url":"findPagePjStoreDynamicInfoByDictFirstUnitId.action",
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
				<%-- 显示大部件专业信息 --%>
				{
					 "name": "${pjFirstUnit.firstUnitName}",
					 "id": "${pjFirstUnit.id }",
					 "target":"minv2_newPiecesManageIframe_rightIframe",
					 "url":"findPagePjStoreDynamicInfoByDictFirstUnitId.action?firstUnitId=${pjFirstUnit.id }",
					 "dynamicCount":"${count }"
				}
				<c:if test="${pjFirstUnitStatu.index != fn:length(pjFirstUnitList)-1 }">
						,
				</c:if>
				</c:forEach>
		  ]
	}

		
];

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