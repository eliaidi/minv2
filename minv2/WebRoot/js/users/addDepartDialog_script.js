
$(function(){
	//添加部门
	$("#_departName").blur(function(){//鼠标在部门名称文本框触发的事件
		flag=false;//标识验证是否通过
		existFlag = false;//标识部门是否已经存在
		if(this.value == ""){
			$("#_departName").focus();
			return;
		}else{
			$("#errorMsg").html("");
		}
		$.post(
				"findDictDepatByName.action",
				{
					"dictDepart.departName":$("#_departName").val()
				},
				function(data){
					if(data == "exist"){
						$("#errorMsg").html("<font color='red'>此部门已存在</font>");
						existFlag = true;
					}
					else if(data == "not exist"){
						$("#errorMsg").html("<font color='green'>可以使用</font>");
						flag=true;
					}
					else{
						alert("服务器出错");
					}
				}
		);
		
	})
	//提交表单
	$("#addDepartSub").click(function(){
		if($("#_departName").val() == ""){
			//$("#errorMsg").html("<font color='red'>部门名称不能为空</font>");
			$("#_departName").focus();
			return;
		}else 
		if(existFlag){
			$("#errorMsg").html("<font color='red'>此部门已存在</font>");
			$("#_departName").focus();
		}else{
			$("#errorMsg").html("");
		}
		if(!flag){
			$("#_departName").focus();
			return;
		}
		document.addDepartForm.submit();
		
	})
	
	
})
