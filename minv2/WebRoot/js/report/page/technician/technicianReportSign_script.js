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

	//点击签认按钮
	$("#sign").click(function() {
		if ($.getCheckedValue("recId").length == 0) {
			top.Dialog.alert("请选择要签认的报活项目");
			return false;
		}
		var ids = $.getCheckedValue("recId").join(",");
		var url = basePath + "report/ajaxSignReportByTechnician.action";
		var parsData = {
			"ids": ids
		};
		$.post(url, parsData, function(data) {
			top.Dialog.alert(data.retMsg, function() {
				window.location.reload();
			});
		});
	});
});

//报活详情
function reportDatils(id) {
	var basePath = $("#basePath").val();
	var diag = new top.Dialog();
	diag.Title = "报活信息详细窗口";
	diag.URL = basePath + 'report/toShowJtReport.action?id=' + id;
	diag.Width = 1124;
	diag.Height = 480;
	diag.show();
}