$(function(){
	
	var basePath=$("#basePath").val();
	
	//点击主选择框，全选
	$(":checkbox[id*='parent']").each(function(index) {
		$.checkAll($(this).attr("id"), "recId" + index);
	});
	
	
	//质检员卡控全签
	$("#signAll").click(function(){
		top.Dialog.confirm("确定要卡控全签？",function(){
		var planDateId=$("#planDateId").val();
		var url=basePath+"zx/qc/ajaxSignZxFixItemRecord.action";
		var parsData={"planDateId":planDateId,"signAll":"true"};
		$.post(url,parsData,function(data){
			top.Dialog.alert(data.retMsg,function(){
				window.location.reload();
			});
		});
	  });
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
	})
	
	//班组和专业的选择显示
	$(":radio[name='sortType']").change(function(){
		var url=basePath+"zx/qc/viewZxFixItemRecord.action?planDateId="+$("#planDateId").val()+"&sortType="+this.value;
		window.location.href=url;
	})
});