//�ֿ�λ���޸ĺ��ҳ��
$(function(){
	$("#storePositionSubmit").click(function(){
		document.updateStorePositionAction.action="updateDictStorePosition.action?returnUrl="+parent.window.frames["frmright"].location;
	});
});