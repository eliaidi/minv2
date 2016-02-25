$(function(){
	$("#fixOutSubmit").click(function(){
		var url="addOutsourcingMaintenanceForPjFix.action?pjSDInfoId="+$("#pjSDInfoId").val()+"&returnUrl="+parent.window.location.href;
		parent.window.location.href=url;
		dialog.close();
	});
});