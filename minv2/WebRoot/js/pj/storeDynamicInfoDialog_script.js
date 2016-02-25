$(function(){
	
	//全选
	$.checkAll("checkAll","ckStoreDynamicInfo");

	//批量删除
	$("#deleteStoreDynamicBtn").click(function() {
		var pars = "";
		var flag;
		var checkpjStoreDynamic = $("input:checkbox[name=ckStoreDynamicInfo]:checked");
		$.each(checkpjStoreDynamic, function(i) {
			flag = true;
			pars += "ids=" + $(this).val() + "&";
		});
		if (flag) {
			top.Dialog.confirm("确定删除吗？", function() {
				window.location.href = "deletePjStoreDynamicByFirstUnitInfo.action?" + pars + "&returnUrl=" + window.location.href;
				//parent.document.getElementById("frmright").contentWindow.location.reload(true);
			});
		} else {
			top.Dialog.alert("请至少选择一个静态配件！");
		}
	});

	//批量移库
	$("#updateStoreDynamicBtn").click(function() {
		var pars = "";
		var flag;
		var checkpjStoreDynamic = $("input:checkbox[name=ckStoreDynamicInfo]:checked");
		$.each(checkpjStoreDynamic, function(i) {
			flag = true;
			pars += "pjStoreDynamicInfoIds=" + $(this).val() + "&";
		});
		if (flag) {

			top.Dialog.open({
				URL: "toMoveStorePositionDialog.action?" + pars,
				Title: "配件移库",
				ShowCloseButton: true
			});
		} else {
			top.Dialog.alert("请至少选择一个动态配件！");
		}
	});


	var count = 0;
	$("#checkAll").click(function() {
		var bool = count == 0;
		$(":checkbox[name='ckStoreDynamicInfo']").attr("checked", bool);
		count += 1;
		count %= 2;
	})
	
});

function deleteDynamicInfo(id) {
	var url = "deletePjStoreDynamicByFirstUnitInfo.action?ids=" + id + "&returnUrl=" + window.location.href;
	top.Dialog.confirm("确定删除吗？", function() {
		window.location.href = url;
	});
}

function updateDynamicInfo(id) {

	var diag = new top.Dialog();
	diag.Title = "修改配件";
	diag.URL = "toUpdateDynamicInfoDialog.action?id=" + id;
	diag.CancelEvent = function() {
		window.location.reload();
		diag.close();
	};
	diag.show();
}
