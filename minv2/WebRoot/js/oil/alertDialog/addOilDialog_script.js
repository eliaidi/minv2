$(function(){
	var basePath = $("#basePath").val();
	var url=basePath+"report/ajaxListUnDealJcPlanDate.action";
	$.post(url,"",function(data){
		
		if(data.errCode != -1){
			
			var pdList=eval(data.retMsg);
			$.each(pdList,function(){
				var value = this.jcType+"-"+this.jcNumber+"-"+this.fixMileage;
				if(this.extraFixMileage != ""){
					value += "-"+ this.extraFixMileage;
				}
				var option=$("<option value='"+this.id+"'>"+value+"</option>")
				$("#pdList").append(option);
			})
		}else{
			top.Dialog.alert(data.retMsg);
		}
	})
	
	$("#subBtn").click(function(){
		if($("#pdList").val() == ""){
			top.Dialog.alert("请选择日计划!");
			return false;
		}

		if ($("#recesamTime").val() == "") {
			top.Dialog.alert("来样日期不能为空!");
			return false;
		}
		if ($("#sendUsers").val() == "") {
			top.Dialog.alert("来样人不能为空!");
			return false;
		}
		
		
		var url=basePath+"oil/ajaxAddOilAMItemRec.action";
		var parData={
				"planDateId":$("#pdList").val(),
				"receiveTime":$("#receiveTime").val(),
				"endTime":$("#endTime").val(),
				"sendUsers":$("#sendUsers").val()
		};
		$.post(url,parData,function(data){
			top.Dialog.alert(data.retMsg);
			if(data.errCode != 0){
				
			}else{
				top.frmright.location.reload();
			}
		})
	})
	
	
})

