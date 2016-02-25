//提交表单
function subForm() {
	var filePath = $("#excel").val();
	if (filePath == "") {
		top.Dialog.alert("请选择要上传的文件!");
		return false;
	} else {
		var fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
		fileType = fileType.toLowerCase();
		if (fileType != "xls" && fileType != "xlsx") {
			top.Dialog.alert("请选择Excel类型文件!");
			return false;
		} else {
			return true;
		}
	}
}

//关闭
function exit() {
	top.Dialog.close();
}