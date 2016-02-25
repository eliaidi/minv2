$(function() {
	var basePath = $("#basePath").val();

	//点击主选择框，全选
	$(":checkbox[id*='parent']").each(function(index) {
		$.checkAll($(this).attr("id"), "recId" + index);
	});

	//报活
	$("#newreport1").click(function() {
		var planDateId = $("#planDateId").val();
		var diag = new top.Dialog();
		diag.Title = "报活操作窗口";
		diag.URL = basePath + 'report/iframePage/alertDialog/reportOperateDialog.jsp?planDateId=' + planDateId;
		diag.Width = 1000;
		diag.Height = 520;
		diag.show();
	});


	//工人检查项目签认
	$("#sign").click(function() {
		if ($.getCheckedValue("recId").length == 0) {
			top.Dialog.alert("请选择要签认的报活项目");
			return false;
		}
		var diag = new top.Dialog();
		diag.Title = "签认窗口";
		diag.URL = basePath + "zx/iframePage/itemSignPage/fixUsers/alertDialog/checkSignRecognitionDialog.jsp";
		diag.Width = 300;
		diag.Height = 120;
		diag.OKEvent = function() {
			var childDoc = diag.innerFrame.contentWindow.document;
			var fixCondition = $("#fixCondition", childDoc).val();
			var ids = $.getCheckedValue("recId").join(",");
			var url = basePath + "zx/fixUsers/ajaxSignZxFixItem.action";
			var parsData = {
				"ids": ids,
				"fixCondition": fixCondition
			};
			$.post(url, parsData, function(data) {
				top.Dialog.alert(data.retMsg, function() {
					window.location.reload();
					diag.close();
				});
			});
		};
		diag.show();
	});

	//禁用
	$("#disable").click(function() {
		if ($.getCheckedValue("recId").length == 0) {
			top.Dialog.alert("请选择要禁用的项目");
			return false;
		}
		var planDateId = $("#planDateId").val();
		var data = {
			"planDateId": planDateId
		};
		var datePath = basePath + "zx/fixUsers/ajaxDisabledZxFixItemRecord.action";
		$.ajax({
			"type": "post",
			"url": datePath,
			"data": data,
			"success": function(data) {
				top.Dialog.alert(data.retMsg, function() {
					window.location.reload();
					diag.close();
				});
			},
		});
	});

	//一键禁用项目
	$("#disableAll").click(function() {
		top.Dialog.confirm("确定要一键禁用项目？", function() {
			var itemType = $("#itemType").val();
			var planDateId = $("#planDateId").val();
			var data = {
				"planDateId": planDateId,
				"disableAll": true,
				"itemType": itemType
			};
			var datePath = basePath + "zx/fixUsers/ajaxDisabledZxFixItemRecord.action";
			$.ajax({
				"type": "post",
				"url": datePath,
				"data": data,
				"success": function(data) {
					top.Dialog.alert(data.retMsg, function() {
						window.location.reload();
						diag.close();
					});
				},
			});
		});
	});

});

//取消检查项目签认
function cancelSign(recId) {
	top.Dialog.confirm("确认取消签认？", function() {
		var url = basePath + "zx/fixUser/ajaxCancelSignZxFixItem.action";
		var parsData = {
			"id": recId
		};
		$.post(url, parsData, function(data) {
			top.Dialog.alert(data.retMsg, function() {
				window.location.reload();
			});
		});
	});
}