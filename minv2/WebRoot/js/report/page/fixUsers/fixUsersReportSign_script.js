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

$(function(){
	var basePath=$("#basePath").val();
	
	
	//点击主选择框，全选
	$(":checkbox[id*='parent']").each(function(index) {
		$.checkAll($(this).attr("id"), "recId" + index);
	});
	
	//报活
	$("#newreport1").click(function(){
		var planDateId=$("#planDateId").val();
		var diag = new top.Dialog();
		diag.Title = "报活操作窗口";
		diag.URL = basePath + 'report/iframePage/alertDialog/reportOperateDialog.jsp?planDateId='+planDateId;
		diag.Width=1000;
		diag.Height=520;
		diag.show();
	});
	
	//点击签认按钮
	$("#sign").click(function(){
		if($.getCheckedValue("recId").length == 0){
			top.Dialog.alert("请选择要签认的报活项目");
			return false;
		}
		
		var diag = new top.Dialog();
		diag.Title = "报活签认窗口";
		diag.URL = basePath +  "report/iframePage/alertDialog/fixUsersSignInput.jsp";
		diag.Width = 300;
		diag.Height = 120;
		diag.OKEvent=function(){
			var childDoc=diag.innerFrame.contentWindow.document;
			var fixCondition=$("#fixCondition",childDoc).val();
			
			var ids=$.getCheckedValue("recId").join(",");
			var url=basePath+"report/ajaxSignReportByFixUsers.action";
			var parsData={"ids":ids,"fixCondition":fixCondition};
			$.post(url,parsData,function(data){
				top.Dialog.alert(data.retMsg,function(){
					window.location.reload();
					diag.close();
				});
			});
		};
		diag.show();
	});
});

//取消检测项目签认
function cancelSign(recId){
	top.Dialog.confirm("确认取消签认？", function() {
		var url=basePath+"zx/ajaxCancelSignZxFixItem.action";
		var parsData={"id":recId};
		$.post(url,parsData,function(data){
			top.Dialog.alert(data.retMsg,function(){
				window.location.reload();
			});
		});
	});
}
