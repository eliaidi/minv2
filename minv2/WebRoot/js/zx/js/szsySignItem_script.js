	$(function(){
		$("input").change(function(){
			alert(111);
			var val = $(this).val();
			var name = $(this).attr("name");
			var rjhmId = $("#rjhmId").val();
			var expId = $("#expId").val();
			var roleFlag = $("#roleFlag").val();
			var recId = $(this).attr("recid");
			//alert("试验项目记录id："+recId);
			if(recId.length>0){
				var changeFlag = confirm("你确认修改当前记录吗？");
				if(changeFlag){
					$.post("experiment!changeExpItemRec.do",{recId:recId,itemVal:val},function(data){
						alert(data);
						window.location.reload();
					},"text");
				}
			}else{
				if($.trim(val).length>0){
					$.post("experiment!signExpItem.do",{itemName:name,itemVal:val,rjhmId:rjhmId,expId:expId,roleFlag:roleFlag},function(data){
						if(data=="success"){
							$.messager.show(0, '保存成功', 1000);
							//top.Dialog.alert("保存成功");
						}else{
							top.Dialog.alert("保存失败");
						}
					},"text");
				}
			}
			
		})
	})
	
	//保存或修改试验时间
	function changeExpTime(){
		var time = $("#sytime").val();
		var rjhmId = $("#rjhmId").val();
		var expId = $("#expId").val();
		$.post("experiment!signExpTime.do",{rjhmId:rjhmId,expId:expId,time:time},function(data){
			if(data=="success"){
				alert("操作成功");
			}else{
				alert("操作失败");
			}
		},"text");
	}