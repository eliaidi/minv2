<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

$(function(){
    //top.Dialog.close()
    <c:if test="${!empty message}">
		top.Dialog.alert('${message}');
	</c:if>
	
	//全选、反选
	$.checkAll("checkAll","checkId");
	
	<%--
	$("#selByRole").attr("checked",${(usersPrivs.usersRolePrivs[0].rolePrivs == null || usersPrivs.usersRolePrivs[0].rolePrivs.id == 0) ? 'false' : 'true' });
	 --%>
	$("#selByName").attr("checked",${usersPrivs.userName == null ? 'false' : 'true' });
	$("#selByJobNum").attr("checked",${usersPrivs.jobNum == null ? 'false' : 'true' });
	
	$("#roleDiv").css("display",'none');
	<%--
	$("#roleDiv").css("display","${(usersPrivs.usersRolePrivs[0].rolePrivs == null || usersPrivs.usersRolePrivs[0].rolePrivs.id == 0) ? 'none' : 'inline' }");
	 --%>
	$("#userNameDiv").css("display","${usersPrivs.userName == null ? 'none' : 'inline' }");
	$("#jobNumDiv").css("display","${usersPrivs.jobNum == null ? 'none' : 'inline' }");
	
	<%-- 保证数据不冲突，使用完毕移除 --%>
	<c:remove var="usersPrivs" scope="session"/>
	
	
	<%--删除数据，刷新到当前页面 --%>
	$("#deleteUsersBtn").click(function(){
		
		var pars="";
		var flag;
		var checkUsers=$.getCheckedValue("checkId");
		
		$.each(checkUsers,function(i){
		   flag=true;
           pars += "usersId="+this+"&";
     	});
     	
     	if(flag){
     		top.Dialog.confirm("确定删除吗？",function(){
     			parent.window.location.href="delUsersByIdByDepart!executeDepart.action?returnUrl="+window.location.href+"&"+pars;
     		});
     	}else{
     	   top.Dialog.alert("请至少选择一个用户！");
     	}
		     	
	})
	    //修改部门
		$("#transferBtnDepart").click(function(){
		var pars="";
		var flag;
		var checkUsers=$("input:checkbox[name=userCkb]:checked");
		$.each(checkUsers,function(i){
		   flag=true;
           pars += "usersId="+$(this).val()+"&";
     	});
     	
     	if(flag){
     	   top.Dialog.open({URL:"toUpdateUsersDepartDialog.action?"+pars,Title:"修改用户部门",ShowCloseButton:true});
     	}else{
     	   top.Dialog.alert("请至少选择一个用户！");
     	}
		     	
	})
	//查询按钮被单击
	$("#queryUsers").click(function(){
    	//判断查询的是部门还是班组的用户
    	//var url="queryUsers.action?departProteamStatus="+$("#departProteamStatus").val()+"&";
    	
    	var url="queryDepartUsers.action?flag=root&";
    	
    	var bool= $("#selByRole").attr("checked") && $("#roleId").val() != "0" 
    	if(bool){
    		url += "roleId="+$("#roleId").val()+"&";
    	}
    	
    	bool= $("#selByName").attr("checked") && $("#userName").val() != "" && $("#userName").val() != "输入姓名";
    	if(bool){
    		url += "userName="+$("#userName").val()+"&";	
    	}
    	
    	bool= $("#selByJobNum").attr("checked") && $("#jobNum").val() != "" && $("#jobNum").val() != "输入工号";
    	if(bool){
    		url += "jobNum="+$("#jobNum").val();
    	}
    	window.location.href=url;
    })
    
    <!-- 通过角色查询复选框改变事件 -->
    $("#selByRole").change(function(){
		$("#roleDiv").css("display",this.checked ? 'inline' : 'none');
	})	
	 <!-- 通过用户名查询复选框改变事件 -->
	$("#selByName").change(function(){
		$("#userNameDiv").css("display",this.checked ? 'inline' : 'none');
	})		
	 <!-- 通过工号查询复选框改变事件 -->
	$("#selByJobNum").change(function(){
		$("#jobNumDiv").css("display",this.checked ? 'inline' : 'none');
	})
	
});


    //删除
    function deletes(userId){
    top.Dialog.confirm("确定删除吗？",function(){parent.window.location.href="delUsersByIdByDepart!executeDepart.action?returnUrl="+window.location.href+"&usersId="+userId});
    } 
    //修改
    function update(userId){
           top.Dialog.open({URL:"findDictAreaAllByDepart!executeDepart.action?usersId="+userId+"&updateTitle=updateUser",Title:"修改用户",ShowCloseButton:true});
    }
    //查看详情
    function lookMessage(userId){
             top.Dialog.open({URL:"findUsersById!executeDepart.action?usersId="+userId,Title:"查看详情",ShowCloseButton:true});
    }
    
    

<%--使用完之后从session中移除 --%>
<c:remove var="usersList" scope="session"/>
<c:remove var="message" scope="session"/>
<c:remove var="dictAreaList" scope="session"/>
<c:remove var="dictProteamList" scope="session"/>
<c:remove var="dictDepartList" scope="session"/>
<c:remove var="rolePrivsList" scope="session"/>


