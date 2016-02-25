$(function(){
	
	var basePath=$("#basePath").val();

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
	
	//交车工长卡控全签
	$("#signAll").click(function(){
		top.Dialog.confirm("确定要卡控全签？",function(){
		var planDateId=$("#planDateId").val();
		var url=basePath+"zx/commitLead/ajaxSignAllZxFixItem.action";
		var parsData={"planDateId":planDateId};
		$.post(url,parsData,function(data){
			top.Dialog.alert(data.retMsg,function(){
				window.location.reload();
			});
		});
	  });
	});
});