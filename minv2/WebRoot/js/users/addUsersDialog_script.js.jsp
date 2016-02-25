<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
$(function(){
   contextPath="<%=request.getContextPath() %>/";
   
   
   $("#jobNum").blur(function() {
		$.get("findUsersByJobNum!executeProteam.action", {
			"jobNum" : $(this).val()
		}, function(data) {
			$("#checkJobNum").html(data);	
			$("#password").val(jobNum.value);
		});
	});	
	
   
});




//班组还是部门，隐藏班组和部门下拉框信息的。
function noneAll() {
	$("#proteamDepart").css("display", "none");
}
// 班组还是部门，显示班组和部门下拉框信息的。
function departProteamAll() {
	$("#proteamDepart").css("display", "");
	$("#proteamText").css("display", "");
	$("#proteamValue").css("display", "");
	$("#departText").css("display", "");
	$("#departValue").css("display", "");
}
// 班组还是部门，显示部门下拉框信息的。
function departAll() {
	$("#proteamDepart").css("display", "");
	$("#departText").css("display", "");
	$("#departValue").css("display", "");
	$("#proteamText").css("display", "none");
	$("#proteamValue").css("display", "none");
}
// 班组还是部门，显示班组下拉框信息的。
function proteamAll() {
	$("#proteamDepart").css("display", "");
	$("#proteamText").css("display", "");
	$("#proteamValue").css("display", "");
	$("#departText").css("display", "none");
	$("#departValue").css("display", "none");
}
// 对班组还是部门，进行分支结构
function changedepartProteamStatus() {
	var departProteamStatus = $("#departProteamStatus").val();
	switch (departProteamStatus) {
	case "-1":
		noneAll();
		break;
	case "0":
		departAll();
		break;
	case "1":
		proteamAll();
		break;
	case "2":
		departProteamAll();
		break;
	}
	;
};
//页面加载是调用方法
window.onload = changedepartProteamStatus;
//验证表单
    
function checkform() {
	
	if($("#area").val()== "0"){
		top.Dialog.alert("请选择地区!");
		return false;
	}
	
	if ($("#departProteamStatus").val() == "-1") {
		top.Dialog.alert("请选择班组还是部门!");
		return false;

	} else if ($("#departProteamStatus").val() == "0") {
		if ($("#depart").val() == "0") {
			top.Dialog.alert("请选择部门！");
			return false;
		}
	} else if ($("#departProteamStatus").val() == "1") {
		if ($("#proteam").val() == "0") {
			top.Dialog.alert("请选择班组！");
			return false;
		}
	}else if ($("#departProteamStatus").val() == "2"){
		if ($("#depart").val() == "0") {
				top.Dialog.alert("请选择部门！");
				return false;
			}
		if ($("#proteam").val() == "0") {
			top.Dialog.alert("请选择班组！");
			return false;
		}
			
	}
	if($("#role").val()=="0"){
		top.Dialog.alert("请选择角色!");
		return false;
	}	
	 //表单避免重复提交
	$("#submit").attr('disabled','disabled');
	
//	alert($("#frmright",parent.document).attr("src") );
//	alert(parent.document.getElementById("frmright") );
	//获取用户管理子页面的地址
	//var returnUrl=$("#frmright",parent.document).contents().find("#minv2_proteamManageIfraame_contentIframe").attr("src");
	
	//跳转的action<添加 和 修改>
	<c:if test="${updateTitle == null  }">
		document.addUsersForm.action="addUsersByProteam!executeProteam.action";	
	</c:if>
	
	<c:if test="${updateTitle != null  }">
		document.addUsersForm.action="updateUsersByIdByProteam!executeProteam.action";
	</c:if>
	
}

//通过子窗口传值到父窗口
function changeRole(roleList){
	 $("#roleId").val(roleList);
    //var roleListSplitAfter = roleList.split(",");
    //for(var i = 0;i < roleListSplitAfter.length;i++){
    //		alert(roleListSplitAfter[i]);
    //}

}

//打开添加页面选择角色子窗口
function checkRoleInUsers(){
     var roleInUserstemp =  $("#roleId").val();
     top.Dialog.open({URL:"findRolePrivsInUsers!executeProteam.action?roleInUsersList="+roleInUserstemp,Title:"请选择角色",ShowCloseButton:true});
     
}


	


