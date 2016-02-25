
$(function(){
	//修改部门
	flag=false;//标识验证是否通过
	existFlag = false;//标识部门是否已经存在
	startDepartName = $("#_startDepartName").val();//原部门名称，如果相同说明没有修改不需要验证
	$("#_departName").blur(function(){//鼠标在部门名称文本框触发的事件
		if(startDepartName==this.value){//没有修改不需要验证
			$("#errorMsg").html("");
			flag=true;
			return;
		}
		if(this.value == ""){
			//$("#errorMsg").html("<font color='red'>部门名称不能为空</font>");
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
	$("#updateDepartSub").click(function(){
		if($("#_departName").val() == ""){
			//$("#errorMsg").html("<font color='red'>部门名称不能为空</font>");
			$("#_departName").focus();
			return;
		}else if(existFlag){
			$("#errorMsg").html("<font color='red'>此部门已存在</font>");
			$("#_departName").focus();
		}else{
			$("#errorMsg").html("");
		}
		if(!flag){
			$("#_departName").focus();
			return;
		}
		document.updateDepartForm.submit();
		
	})
	
})
