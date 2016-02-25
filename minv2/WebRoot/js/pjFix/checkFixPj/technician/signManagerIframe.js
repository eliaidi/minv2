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
		
		$.post("signFixItemByTechnicianForPjFix.action",{"ids":ids},function(data){
			top.Dialog.alert(data);
			if(data == "操作成功"){
				window.location.reload();
			}
		});
	})
})