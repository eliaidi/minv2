$(function() {
	var basePath=$("#basePath").val();
	//获取选中的多选框
	
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
	
	//验收员卡控全签
	$("#signAll").click(function(){
		top.Dialog.confirm("确定要卡控全签？",function(){
		var planDateId=$("#planDateId").val();
		var url=basePath+"zx/acceptance/ajaxSignZxFixItemRecord.action";
		var parsData={"planDateId":planDateId,"signAll":true};
		$.post(url,parsData,function(data){
			top.Dialog.alert(data.retMsg,function(){
				window.location.reload();
			});
		});
	  });
	});
});