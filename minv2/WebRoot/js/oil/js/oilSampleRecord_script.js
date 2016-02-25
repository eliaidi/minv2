//定义的路径
var basePath;
$(function() {
	basePath = $("#basePath").val();
	top.Dialog.close();
	//添加油水化验
	$("#add").click(function() {
		var url = basePath + "oil/iframePage/alertDialog/addOilDialog.jsp";
		top.Dialog.open({
			URL: url,
			Title: "添加油水化验 ",
			Width: 400,
			Height: 250
		});
	});
	//修改油水化验
	$("#update").click(function() {
		var recRadio=$("input[name='rec']:checked");
		if(recRadio.length == 0){
			top.Dialog.alert("请选择记录");
			return ;
		}
	
		top.Dialog.open({
			URL: basePath + "oil/toUpdateOilAMIRec.action?mainRecId="+recRadio.val(),
			Title: "修改油水化验 ",
			Width: 400,
			Height: 300
		});
	});
});