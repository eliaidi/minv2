$(function(){
	//标志用户检测是否通过
	var flag=false;
	
	$("#proteamName").change(function(){
		flag=false;
		$("#errorMsg").html("");
		
		
	});

	$("#proteamName").blur(function(){
		if($("#proteamName").val() == ""){
			flag=false;
			return;
		}
		
		$.post(
				"findDictProteamByName.action",
				{
					"proteamName":$("#proteamName").val()
				},
				function(data){
					if(data == "exist"){
						$("#errorMsg").html("<font color='red'>此班组已存在</font>");
					}
					else if(data == "not exist"){
						$("#errorMsg").html("<font color='green'>可以使用</font>");
						flag=true;
					}
					else{
						top.Dialog.alert("服务器出错");
					}
				}
		);
	});

	
	$("#enter").click(function(){
		if($("#proteamName").val() == ""){
			top.Dialog.alert("班组名不能为空！");
		}
		
		if(flag){
			document.addProteamForm.submit();
			
		}
		
	})
	
})


