$(function(){
	//通过ID修改动态配件
	$("#updatePjStoreDynamicInfoSubmitById").click(function(){
		document.updatePjStoreDynamicInfoSubmit.action="updatePjStoreDynamicInfo.action?returnUrl="+parent.window.frames["frmright"].location;
	});
});