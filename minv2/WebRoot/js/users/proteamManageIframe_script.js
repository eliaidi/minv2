$(function(){

	//删除班组按钮单击
	$("#delProteamBtn").click(function(){
		
		
		var zTree = $.fn.zTree.getZTreeObj("tree");
		
		
		var selNodes=zTree.getCheckedNodes();
		
		if(selNodes.length == 0 || selNodes[0].isParent){
			top.Dialog.alert("请选择班组！");
			return false;
		}
		top.Dialog.confirm("是否删除["+selNodes[0].name+"]？",function(){
//			判断此班组中是否存在用户
			var usersCount=0;
			$.ajax({
					url:"findDictProteamById.action?flag=findUsersCount",
					data:{id:selNodes[0].id},
					success:function(data){
						usersCount=data;
					},
					async:false
			});
			if(usersCount > 0){
				top.Dialog.alert("此班组存在用户，不可以删除！");
				return;
			}
			
			window.location.href="delDictProteamById.action?id="+selNodes[0].id;
		});
		

	});
	
	$("#updateProteamBtn").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("tree");
		
		
		var selNodes=zTree.getCheckedNodes();
		
		if(selNodes.length == 0 || selNodes[0].isParent){
			top.Dialog.alert("请选择班组！");
			return false;
		}
		top.Dialog.open({URL:"findDictProteamById.action?id="+selNodes[0].id,Title:"修改班组"});
	});
	
})