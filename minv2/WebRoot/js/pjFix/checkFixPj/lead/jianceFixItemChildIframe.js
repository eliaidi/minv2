$(function(){
	

	$("#signAll").click(function(){
		var pjSDInfoRecordId=$("#pjSDInfoRecordId").val();
		$.post("signAllJianCeFixItemByLeadForPjFix.action","id="+pjSDInfoRecordId,function(data){
			
			top.Dialog.alert(data);
			window.location.reload();
			
		});
		
	})
});