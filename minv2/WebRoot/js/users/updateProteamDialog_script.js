$(function(){
	//标志用户检测是否通过
	var flag=false;
	$("#proteamName").focus();
	$("#proteamName").blur(function(){
		flag=false;
		if(this.value == ""){
			$("#errorMsg").html("<font color='red'>班组名称不能为空</font>");
			return;
		}else{
			flag=true;
			$("#errorMsg").html("");
		}
		
	})
	
	$("#enter").click(function(){
		
		if(!flag){
			$("#proteamName").focus();
			return;
		}
		
		document.updateProteamForm.submit();
		diag.close();

	})
	
	
})