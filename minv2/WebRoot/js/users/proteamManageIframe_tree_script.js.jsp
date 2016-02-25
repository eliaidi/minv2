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




<%-- 班组类型：小辅修、中修班组 --%>
var zNodes=[
	{
		  "name": "全部",
		  "id": "bz_root",
		  "pId":"-1",
		  "open":true,
		  "target":"minv2_proteamManageIfraame_contentIframe",
		  "url":"queryProteamUsers!executeProteam.action?flag=bz_root&userPrivs.departProteamStatus=<%=Constants.PROTEAM_STATU %>",
		  "usersCount":"${totalUsersCount }"
	}
	<%-- 如果 存在班组类型，打印逗号（为了拼接json）--%>
	<c:if test="${ fn:length(proteamMap) != 0 }">
				,
	</c:if>
	
	<c:forEach items="${proteamMap }" var="proteamType" varStatus="proteamTypeStatu">
		<c:set var="usersCount" value="0"></c:set>
		<%-- 获得班组人员个数 --%>
		<c:forEach items="${proteamType.value}" var="tempProteam">
			<%-- 班组类型：小辅修、中修班组人数 --%>
			<c:set var="usersCount" value="${usersCount + fn:length(tempProteam.usersPrivses) }"></c:set>
			
		</c:forEach>
		
		<%-- 所有班组的人数 --%>
		<c:set var="totalCount" value="${totalCount +  usersCount}"></c:set>
		
		
		
		<c:if test="${proteamType.key == '1'}">
			<c:set var="proteamTypeName" value="小辅修班组"></c:set>
		</c:if>
		
		<c:if test="${proteamType.key == '2'}">
			<c:set var="proteamTypeName" value="中修班组"></c:set>
		</c:if>

		
		
		<%-- 显示班组类型信息 --%>
		{
			 "name": "${proteamTypeName}",
			 "id": "bz_type_${proteamType.key }",
			 <!--  "open": ${proteamTypeStatu.index == 0 ? 'true' : 'false' },-->
			 "open": 'true',
			 "pId":"bz_root",
			 "target":"minv2_proteamManageIfraame_contentIframe",
		  	 "url":"queryProteamUsers!executeProteam.action?flag=bzType_${proteamType.key }&userPrivs.departProteamStatus=<%=Constants.PROTEAM_STATU %>",
		  	  "usersCount":"${usersCount }",
		  	  
		}
		
		
		<%-- 如果此班组类型有班组存在 --%>
		<c:if test="${fn:length(proteamType.value) != 0 }">,</c:if>
		
		
		<c:forEach items="${proteamType.value}" var="proteam" varStatus="proteamStatu">
			
			<%-- 显示班组信息 --%>
			{
				 "name": "${proteam.proteamName}",
				 "id": ${proteam.id },
				 "pId":"bz_type_${proteamType.key }",
				 "target":"minv2_proteamManageIfraame_contentIframe",
				 "url":"queryProteamUsers!executeProteam.action?flag=bz_${proteam.id }&userPrivs.departProteamStatus=<%=Constants.PROTEAM_STATU %>",
				 "usersCount":"${fn:length(proteam.usersPrivses) }",
				 "bzid":"${proteamType.key }"
			}
			<c:if test="${proteamStatu.index != fn:length(proteamType.value)-1 }">
					,
			</c:if>
		</c:forEach>
		
		
		<c:if test="${proteamTypeStatu.index != fn:length(proteamMap)-1 }">
				,
		</c:if>
		
	</c:forEach>

	
];



<c:remove var="proteamMap" scope="session"/>
<c:remove var="totalUsersCount" scope="session"/>

$(function(){
		//初始化树形菜单
		$.fn.zTree.init($("#tree"), setting, zNodes);
		
		var nodes = $.fn.zTree.getZTreeObj("tree").getNodes();
		
		
		
		appendUsersCount(nodes[0]);
		
		
		//关闭所有弹出窗口
		top.Dialog.close();
		
		<c:if test="${sessionScope.message != null}">
			top.Dialog.alert("${sessionScope.message}");
		</c:if>
		
		<c:remove var="message" scope="session"/>

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