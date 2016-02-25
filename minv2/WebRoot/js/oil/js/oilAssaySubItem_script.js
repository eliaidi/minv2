function show(recId) {
	var basePath = $("#basePath").val();
	var diag=new top.Dialog();
	
	diag.URL=basePath + "oil/iframePage/alertDialog/fillInValueldIDialog.jsp";
	diag.Title = "填报值 ";
	diag.Width=300;
	diag.Height=100;
	//diag.Modal=false;
	
	diag.OKEvent=function(){
		var url=basePath+"oil/ajaxUpdateActualCheckData.action";
		
		var childDoc = diag.innerFrame.contentWindow.document;
		var parData={
				"childRecId":recId,
				"actualCheckData":$("#actualCheckData",childDoc).val()
		};
		$.post(url,parData,function(data){
			top.Dialog.alert(data.retMsg,function(){
				window.location.reload();
				diag.close();
			});
			
		});
	};
	
	diag.show();

}