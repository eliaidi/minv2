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
	
	//工长卡控全签
	$("#signAll").click(function(){
		top.Dialog.confirm("确定要卡控全签？",function(){
		var planDateId=$("#planDateId").val();
		var url=basePath+"zx/lead/ajaxSignAllZxFixItem.action";
		var parsData={"planDateId":planDateId};
		$.post(url,parsData,function(data){
			top.Dialog.alert(data.retMsg,function(){
				window.location.reload();
			});
		});
	  });
	});
	

	//工人检查项目签认
	$("#sign").click(function(){
		if($.getCheckedValue("recId").length == 0){
			top.Dialog.alert("请选择要签认的报活项目");
			return false;
		}
		
		var diag = new top.Dialog();
		diag.Title = "签认窗口";
		diag.URL = basePath +  "zx/iframePage/itemSignPage/fixUsers/alertDialog/checkSignRecognitionDialog.jsp";
		diag.Width = 300;
		diag.Height = 120;
		diag.OKEvent=function(){
			var childDoc=diag.innerFrame.contentWindow.document;
			var fixCondition=$("#fixCondition",childDoc).val();
			var ids=$.getCheckedValue("recId").join(",");
			var url=basePath+"zx/fixUsers/ajaxSignZxFixItem.action";
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