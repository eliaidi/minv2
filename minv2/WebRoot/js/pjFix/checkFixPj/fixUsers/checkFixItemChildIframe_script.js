$(function(){
	top.Dialog.close();
	var basePath=$("#basePath").val();
	
	//点击复选框触发的事件,全选或全部选
	$.checkAll("selected","seq");
	//点击项目签认触发的事件
	
	$("#signRecognition").click(function(){
		//拿到所有复选框中的值
		var arr=$.getCheckedValue("seq");
		if(arr.length==0)
		{
			alert("请选中要签认的项目");
			return false;
		}
		var ids=arr.join(",");
		
		
		var diag=new top.Dialog();
		
		
		diag.URL=basePath+"pjFix/iframePage/checkFixPj/fixUsers/alertDialog/checkSignRecognitionDialog.jsp?ids="+ids;
		diag.Height="400px";
		diag.Width="450px";
		diag.Title="工人检查项目签认";
		diag.OKEvent=function(){
			var dialogDoucment = diag.innerFrame.contentWindow.document;
			var fixCondition=$("#defaultValue",dialogDoucment).val();
			$.post("signFixItemByFixUsersForPjFix.action",{"ids":ids,"fixCondition":fixCondition},function(data){
				
				top.Dialog.alert(data);
				window.location.reload();
				diag.close();
				
			});
				
		}
		diag.show();
		
	});
});