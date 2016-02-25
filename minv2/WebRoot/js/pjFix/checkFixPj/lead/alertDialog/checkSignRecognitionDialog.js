$(function(){
$("#sign").click(function(){
		
		var idArr=$.getCheckedValue("itemId");
		if(idArr.length == 0){
			return;
		}
		var ids=$("#ids").val();
		
		$.post("signFixItemByLeadForPjFix.action",{"ids":ids},function(data){
			top.Dialog.alert(data);
			if(data == "操作成功"){
				window.location.reload();
			}
		});
	})
	
	
})