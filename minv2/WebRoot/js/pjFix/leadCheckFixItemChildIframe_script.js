$(function(){
	
	//检查项目签认 ， 以工人身份
	$("#ckbAll").click(function(){
		if($("#ckbAll").attr("checked")){
			$("input:checkbox[name=ckbRecord]").attr("checked",true);
		}else{
			$("input:checkbox[name=ckbRecord]").attr("checked",false);
		}
	});
	
		$("#leadCheck").click(function(){
			var par="ids=";
			var ckRecord = $("input:checkbox[name=ckbRecord]:checked");
			ckRecord.each(function(){
					par +=this.value+",";
			});
			if(par !="ids="){
			//拿到所有复选框中的值
				top.Dialog.open({URL:"../pjFix/iframePage/checkFixPj/lead/alertDialog/checkSignRecognitionDialog.jsp?"+par,Height:240,Width:400});
			}
			else
			{
				top.Dialog.alert("请选择需要签认的项目！");
			}
		});
	
	//工长卡控签认
	$("#leadAllCheck").click(function(){
		var psdiId=$("#psdiId").val();
		top.Dialog.open({URL:"../pjFix/iframePage/checkFixPj/lead/alertDialog/checkSignRecognitionDialog.jsp?ids="+psdiId,Height:240,Width:400});
	});
	/**$("#leadCheck").click(function(){
		 $.ajax({
			url:"",
			data:{},
			type:"type",
			success:function(data){
				top.Dialog.alert("签认成功！");
			}
		 });
	});
	$("#leadAllCheck").click(function(){
		$.ajax({
			url:"signAllJianCeFixItemByLeadForPjFix.action",
			data:{},
			type:"type",
			success:function(data){
				top.Dialog.alert("卡控全签成功！");
			}
		 });
	});*/
});