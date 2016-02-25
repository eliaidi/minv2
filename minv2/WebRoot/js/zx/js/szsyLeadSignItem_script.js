function signItem(itemFlag,num){
			var rjhmId = $("#rjhmId").val();
			var expId = $("#expId").val();
			var roleFlag = $("#roleFlag").val();
			var len = $("a[name="+itemFlag+"]").length;
			if(len==0){
				top.Dialog.alert("还有检修员未签认的项目，您暂时不能签认");
				return false;
			}else{
				var flag = true;
				$("a[name="+itemFlag+"]").each(function(){
					var val = $(this).text();
					if(val.length==0){
						top.Dialog.alert("还有检修员未签认的项目，您暂时不能签认");
						flag = false;
						return false;
					}
				});
				if(flag){
					$.post("experiment!leadSignExpItem.do",{rjhmId:rjhmId,expId:expId,itemName:itemFlag,roleFlag:roleFlag},function(data){
						top.Dialog.alert(data,function(){
							window.location.reload();
						});
					},"text");
				}
			}
		}

		//保存或修改试验时间
		function changeExpTime(){
			var time = $("#sytime").val();
			var rjhmId = $("#rjhmId").val();
			var expId = $("#expId").val();
			$.post("experiment!signExpTime.do",{rjhmId:rjhmId,expId:expId,time:time},function(data){
				if(data=="success"){
					top.Dialog.alert("操作成功");
				}else{
					top.Dialog.alert("操作失败");
				}
			},"text");
		}
	