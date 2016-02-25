//新件入库中添加动态配件
$(function() {
	//弹出窗口关闭
	top.Dialog.close();
	var message = $("#message").val();
	if (message != "") {
		top.Dialog.alert(message);
	}

	//弹窗中将下面的width和height设为一个合适的数值让窗口不出现滚动条
	$('.flexiStyle').flexigrid({
		height: 290,
		width: 870,
		resizable: true,
		showToggleBtn: false
	});

	$("input#pjdCode").blur(function() {
		var pjdCode = $("#pjdCode").val();
		$.post("findPjStoreDynamicInfoByPjdCode.action", {
				pjdCode: $("#pjdCode").val()
			},
			function(data) {
				if (data != "") {
					$("#pjdCode").val("");
					top.Dialog.alert(pjdCode + data);
				}
			});
	});

	//智能提示
	$.smartTips({
		"url": "findPjSSInfoListByNameOrPy.action",
		"txtId": "pjName",
		"valEleId": "pjStoreStaticInfoId"
	});


});

function checkform() {
	var bool = false;
	$.ajax({
		url: "findPjStoreStaticInfoByPjName.action",
		data: {
			pjName: $("#pjName").val()
		},
		type: "post",
		success: function(data) {
			bool = data == "";
			if (!bool) {
				top.Dialog.alert(data);
			}
		},
		async: false

	});
	return bool;
}

function deleteDynamicPj(id) {
	top.Dialog.confirm("确定删除吗？", function() {
		$.post("deletePjStoreDynamicInfo.action", {
			"id": id
		}, function(data) {
			top.Dialog.alert(data.retMsg, function() {
				window.location.reload();
			});

		})

	});
}