//仓库位置修改后的页面
$(function(){
	$("#storePositionSubmit").click(function(){
		document.updateStorePositionAction.action="updateDictStorePosition.action?returnUrl="+parent.window.frames["frmright"].location;
	});
});