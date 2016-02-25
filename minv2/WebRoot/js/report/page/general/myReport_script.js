$(function() {
	var basePath = $("#basePath").val();
	//页面显示时，ajax加载机车信息
	var url = basePath + "report/ajaxListUnDealJcPlanDate.action";
	$.post(url, "", function(data) {

		if (data.errCode != -1) {

			var pdList = eval(data.retMsg);
			$.each(pdList, function() {
				var value = this.jcType + "-" + this.jcNumber + "-" + this.fixMileage;
				if (this.extraFixMileage != "") {
					value += "-" + this.extraFixMileage;
				}
				var option = $("<option value='" + this.id + "'>" + value + "</option>");
				$("#pdList").append(option);
			});
			$("#pdList").val($("#planDateId").val());
		} else {
			top.Dialog.alert(data.retMsg);
		}
	});

	//添加报活
	$("#newreport").click(function() {
		top.Dialog.open({
			URL: basePath + "report/iframePage/alertDialog/reportOperateDialog.jsp?planDateId=" + $("#pdList").val(),
			Title: "添加报活 ",
			Width: 1000,
			Height: 800
		});
	});

	//点击查询触发的事件，查询出未交车的报活信息
	$("#reportselect").click(function() {
		var url = basePath + "report/listMyReport.action?planDateId=" + $("#pdList").val();
		window.location.href = url;
	});
});


//修改报活
function updateReport(id,planDateId) {
	var basePath = $("#basePath").val();
	top.Dialog.open({
		URL: basePath + "report/findJcReportById.action?jtReportId=" + id+'&planDateId='+planDateId,
		Title: "修改报活 ",
		Width: 1000,
		Height: 600
	});

}


//报活详情
function reportDatils(id,planDateId) {
	var basePath = $("#basePath").val();
	var diag = new top.Dialog();
	diag.Title = "报活信息详细窗口";
	diag.URL = basePath + 'report/toShowJtReport.action?id=' + id+'&planDateId='+planDateId;
	diag.Width = 1124;
	diag.Height = 480;
	diag.show();
}


//报活删除
function jtPreDictDelete(id, planDateId) {
	var basePath = $("#basePath").val();
	top.Dialog.confirm("确认删除该报活记录?", function() {
		url = basePath + "report/deleteJtReport.action";
		$.post(url, {
			"id": id
		}, function(data) {
			if (data.errCode == 0) {
				top.Dialog.alert("删除成功!", function() {
					window.location.reload();
				});
			} else {
				top.Dialog.alert("删除失败!");
			}
		});
	});
}