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
		enable: true,
		chkStyle: "radio",
		radioType: "all"
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




<%-- 树数据显示数组 --%>
var zNodes=[
	{
		  "name": "部门管理",
		  "id": "root",
		  "pId":"-1",
		  "open":true,
		  "target":"minv2_departManageIfraame_contentIframe",
		  "url":"queryDepartUsers!executeDepart.action?flag=root&userPrivs.departProteamStatus=<%=Constants.DEPART_STATU %>",
		  "usersCount":"${totalUsersCount }",
		  children:[
		  	<c:forEach items="${departList}" var="depart" varStatus="departStatu">
			
			<%-- 显示部门信息 --%>
			{
				 "name": "${depart.departName}",
				 "id": ${depart.id },
				 "pId":"-1",
				 "target":"minv2_departManageIfraame_contentIframe",
				 "url":"findUsersByDictDepartId.action?flag=list&departId=${depart.id }",
				 "usersCount":"${fn:length(depart.usersPrivses) }"
			}
			<c:if test="${departStatu.index != fn:length(departList)-1 }">
					,
			</c:if>
			</c:forEach>
		  ]
	}

		
];

<c:remove var="departList" scope="session"/>
<c:remove var="totalUsersCount" scope="session"/>

$(function(){
		//初始化树形菜单
		$.fn.zTree.init($("#tree"), setting, zNodes);
		
		var nodes = $.fn.zTree.getZTreeObj("tree").getNodes();
		
		appendUsersCount(nodes[0]);

		<!-- 由于用户个数显示的为蓝色，所以递归设置 -->		
		function appendUsersCount(node){
			if(node){
				$("#"+node.tId+"_span").append("[<font color='blue'>"+node.usersCount+"</font>人]");
			}
			
			var childNodes=node.children;
			
			if(childNodes && childNodes.length != 0){
				for(var i=0;i<childNodes.length;i++){
					appendUsersCount(childNodes[i]);
				}
			}
			
		}
		
});