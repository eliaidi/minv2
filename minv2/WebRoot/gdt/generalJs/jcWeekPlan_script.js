function getRadioLine(){
	var msg;
	msg=$("#radioTable input[type=radio]").filter("[checked=true]").val();
	if (typeof(msg) == 'undefined') {
		top.Dialog.alert("请选择需要扣的机车！");
		return "";
	} else {
		return msg;
	}
}