 function getUserName(){
		var user="${session_user.xm}";
		var username=$("#a2").val();
		if(username.length==0){
			$("#a2").val(user+",");
		}else{
			$("#a2").val(username+user+",");
		}
		$("#a2").change();
	  }