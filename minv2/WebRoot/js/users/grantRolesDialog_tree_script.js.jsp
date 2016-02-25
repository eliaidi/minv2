<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%--树形菜单设置 --%>
<!-- check：选择框或者单选框的设置 -->
<!-- data：数据的相关设置 -->
<!-- callback：节点相关事件 -->

var setting = {
	check: {
		"enable": "true",
		"chkStyle": "checkbox",
		"radioType": "all",
		"nocheckInherit":"true"<!-- 关联下拉框 -->
	},
	data: {
		simpleData: {
			"enable": "true"
		}
	},
	callback:{
		onClick:function(event,treeId,treeNode,clickFlag){
			//通过ID获取treeObj对象
			var treeObj=$.fn.zTree.getZTreeObj(treeId);
			//更改treeObj对象的选中状态
			//参数类型：treeNode、选择状态、是否联动、是否触发其他事件
			treeObj.checkNode(treeNode,true,false,true);
		}
	}
};

<%--功能信息 --%>
var zNodes=[
	{
		  "name": "权限列表",
		  "id": "root",
		  "pId":"-1",
		  "open":true,
		  "children":[
		         <!-- 获取一级菜单 -->
		  		<c:forEach items="${funMap}" var="firstFunction" varStatus="functionStatu">
					<%-- 显示功能信息 --%>
					{
						 "name": "${firstFunction.key}",
						 "id": "${firstFunction.key}",
						  "children":[
						     <!-- 获取二级菜单 -->
						     <c:forEach var="secondFunction" items="${firstFunction.value}" varStatus="functionStatu1">
						      {
						          "name": "${secondFunction.key}",
						          "id": "${secondFunction.key}",
						          "children":[
						          	<c:forEach var="thirdFunction" items="${secondFunction.value}" varStatus="functionStatu2">	
					          		{
						          		"name": "${thirdFunction.functionName}",
						          		"id": "${thirdFunction.id}",
						          		"functionId":"${thirdFunction.id}"
						          		
								         <c:forEach items="${grantRoleFunctions }" var="grantRoleFunction">
								          	<c:if test="${grantRoleFunction.functionPrivs.id ==  thirdFunction.id}">
								          		,"checked":"true"
								          	</c:if>
								         </c:forEach>
								          
					          		}
							        <c:if test="${functionStatu2.index != fn:length(secondFunction.value)-1 }">
										,
									</c:if>
								    </c:forEach>
						          ]
						       }
						       <c:if test="${functionStatu1.index != fn:length(firstFunction.value)-1 }">
									,
							   </c:if>
						     </c:forEach>
						  ]
					}
					<c:if test="${functionStatu.index != fn:length(funMap)-1 }">
							,
					</c:if>
					
				</c:forEach>
		  ]
	}
	
];




<!--  
<c:remove var="proteamMap" scope="session"/>
<c:remove var="totalUsersCount" scope="session"/>
-->

$(function(){
		//初始化树形菜单
		$.fn.zTree.init($("#tree"), setting, zNodes);
		
		
		$("#roleGrant").click(function(){
			var nodes=$.fn.zTree.getZTreeObj("tree").getCheckedNodes();
			if(nodes.length == 0){
				top.Dialog.alert("请选择功能！");
				return false;
			}
			
			var url="roleGrant.action?roleId=${role.id }&";
			
			var fids="";
			$.each(nodes,function(){
				if(this.functionId){
					
					fids += "functionId="+this.functionId+"&";
				}
			});
			$.post(url,fids,function(data){
				if(data == "角色授权成功"){
					top.Dialog.alert("角色授权成功",function(){
						top.Dialog.close();
					});
				}else{
					top.Dialog.alert("角色授权失败");
				}
			});
			
			//top.Dialog.close();
			
		})
		
		
		$("#closeWindow").click(function(){
		
			top.Dialog.close();
		});
});

