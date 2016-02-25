$(function(){
	
	$.checkAll("checkAll","itemId");
	
	$("#sign").click(function(){
		
		var idArr=$.getCheckedValue("itemId");
		if(idArr.length == 0){
			return;
		}
		var ids="";
		$.each(idArr,function(){
			ids += this+",";
		});
		
		$.post("signFixItemByAcceptanceForPjFix.action",{"ids":ids},function(data){
			top.Dialog.alert(data);
			window.location.reload();
		});
	})
})