//删除大部件(专业)时触发的事件
$(function(){
	//判断提示数据是否存在
	if( $("#message").val() != ""){
		top.Dialog.alert($("#message").val());
	}
	//alert($("#message").val());
	
	//点击删除按钮，删除数据
    $("#delProteamBtn").click(function(){
    	
    	flag=false;//标识验证是否通过
		existFlag = false;//标识静态配件是否已经存在
    	var zTree = $.fn.zTree.getZTreeObj("tree");
    	var selNodes=zTree.getCheckedNodes();
		
		if(selNodes.length == 0 || selNodes[0].isParent){
			top.Dialog.confirm("请选择要删除的部件！");
			return false;
		}
		top.Dialog.confirm("确定删除此专业(大部件)？",function(){
			window.location.href="deleteDictPjFirstUnit.action?id="+selNodes[0].id;
		});
		
		
//		$.post(
//				"deleteDictPjFirstUnit.action",
//				{
//					"id":selNodes[0].id
//				},
//				function(data){
//					if(data == "exist"){
//						
//						existFlag = true;
//					}
//					else if(data == "notExist"){
//						alert("此静态配件存在于动态配件中无法删除");
//						alert("此静态配件可以删除");
//						//window.location.href="deleteDictPjFirstUnit.action?id="+selNodes[0].id;
//						flag=true;
//					}
//					else{
//						alert("服务器出错");
//					}
//				}
//		);
		
    });
    
    //修改树形专业信息
    $("#updateFs").click(function(){
    	var zTree = $.fn.zTree.getZTreeObj("tree");
    	var selNodes=zTree.getCheckedNodes();
		
		if(selNodes.length == 0 || selNodes[0].isParent){
			top.Dialog.alert("请选择要修改的部件！");
			return false;
		}
	     top.Dialog.open({URL:"toUpdateDictPjFirstUnit.action?id="+selNodes[0].id,Title:"修改部门",ShowCloseButton:true});
    });
});