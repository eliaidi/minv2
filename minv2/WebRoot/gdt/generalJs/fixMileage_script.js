/**
 * 获取选中的修程修次的值
 */
function getFixFrequeRadioLine(){
	var obj=$("input[type=radio][name='ra']").filter("[checked=true]");
	var msg=obj.val();
	if (typeof(msg) == 'undefined') {
		top.Dialog.alert("请选择修程！");
	} else {
		$("#fixFreque").val(msg);
		$("#fixFrequeId").val(obj.attr("id"));
		
		obj=$("input[type='checkbox'][name='other']").filter("[checked=true]");
		msg=obj.val();
		$("#extraFixFreque").val(msg);
		$("#extraFixFrequeId").val(obj.attr("id"));
	}
}