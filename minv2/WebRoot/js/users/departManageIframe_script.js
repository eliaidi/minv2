$(function(){
	//关闭所有弹出窗口
	top.Dialog.close();

	//单击删除部门按钮
	$("#delDepartBtn").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("tree");
		
		var selNodes=zTree.getCheckedNodes();
		
		if(selNodes.length == 0 || selNodes[0].isParent){
			top.Dialog.alert("请选择要删除的部门！");
			return false;
		}
		//判断此部门中是否存在用户
		var usersCount=0;
		$.ajax({
				url:"findUsersByDictDepartId.action?flag=findUsersCount",
				data:{departId:selNodes[0].id},
				success:function(data){
					usersCount=data;
				},
				async:false
		});
		if(usersCount > 0){
			top.Dialog.alert("此部门存在用户，不可以删除！");
			return;
		}
		window.location.href="delDictDepartById.action?dictDepart.id="+selNodes[0].id;
	});
	
	$("#updateDepartBtn").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("tree");
		
		var selNodes=zTree.getCheckedNodes();
		
		if(selNodes.length == 0 || selNodes[0].isParent){
			top.Dialog.alert("请选择要修改的部门！");
			return false;
		}
		top.Dialog.open({URL:"findDictDepatById.action?dictDepart.id="+selNodes[0].id,Title:"修改部门"});
	});
	
})