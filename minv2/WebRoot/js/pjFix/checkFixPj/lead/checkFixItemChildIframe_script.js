$(function(){
	
	var basePath=$("#basePath").val();
	
	//点击复选框触发的事件,全选或全部选
	$.checkAll("checkAll","itemId");
	//点击项目签认触发的事件
	
	$("#sign").click(function(){
		//拿到所有复选框中的值
		var arr=$.getCheckedValue("itemId");
		if(arr.length==0)
		{
			alert("请选中要签认的项目");
			return false;
		}
		var ids=arr.join(",");
		
		
		var diag=new top.Dialog();
		diag.URL=basePath+"pjFix/iframePage/checkFixPj/lead/alertDialog/checkSignDialog.jsp?ids="+ids;
		diag.Height=100;
		diag.Width=450;
		diag.Title="工长检查项目签认";
		diag.OKEvent=function(){
			var dialogDoucment = diag.innerFrame.contentWindow.document;
			var fixCondition=$("#defaultValue",dialogDoucment).val();
			$.post("signFixItemByLeadForPjFix.action",{"ids":ids,"fixCondition":fixCondition},function(data){
				
				top.Dialog.alert(data);
				window.location.reload();
				diag.close();
				
			});
				
		}
		diag.show();
		
	});
	
	
	$("#signAll").click(function(){
		var pjSDInfoRecordId=$("#pjSDInfoRecordId").val();
		$.post("signAllCheckFixItemByLeadForPjFix.action","id="+pjSDInfoRecordId,function(data){
			
			top.Dialog.alert(data);
			window.location.reload();
			
		});
		
	})
});