$(function(){
	//工长检测项目启用与不启用
	$("input:checkbox[name=fixItemStatus]").click(function(){
		var fixItemNum;
		if($(this).attr("checked")){
			fixItemNum = 1;
		}else{
			fixItemNum = 0;
		}
		$.ajax({
			url:"updatePjSDInfoRecordForCLFixForPjFix.action",
		   data:{pjSDInfoRecordFixId:$("#jianceItemId").val(),fixItemStatus:fixItemNum},
		   type:"post",
		   success:function(a){
		   }
		});
	});
});