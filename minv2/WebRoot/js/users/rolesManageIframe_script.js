function deleteRole() {
	top.Dialog.alert('该角色存在用户不能删除!');
	//top.Dialog.alert('角色信息删除成功!');
}
function toaddRole() {
	top.Dialog.open( {
		URL : "iframePage/role/alertDialog/addRolesDialog.jsp",
		Width : 360,
		Height : 180,
		Title : "添加角色"
	});
}
function toupdateRole() {
	top.Dialog.open( {
		URL : "iframePage/role/alertDialog/updateRolesDialog.jsp",
		Width : 360,
		Height : 180,
		Title : "修改角色"
	});
}
function tograntRole() {
	top.Dialog.open( {
		URL : "iframePage/role/alertDialog/grantRolesDialog.jsp",
		Width : 480,
		Height : 640,
		Title : "给角色授权"
	});
}
function toclose() {
	top.Dialog.close();
}

$(function(){
	  $("span [id='close]").click(function(){
		   var rowIndex=this.parentElement.parentElement.rowIndex;
    	   var roleId=$("#table1  input[id='roleid']:eq("+(rowIndex-1)+")").val();
		  $.post("deleteRolePrivsById.action",{"id":roleId},function(data){
		
		     if(data=="存在用户，无法删除角色！！！")
		     {
		    	 alert(data);
		     }
       	 })
	  })
	
	
});

