$(function(){
	//一键禁用
	$("#fixItemStatusCloseAll").click(function(){
		var fixItemNum = 0;
		$.ajax({
			url:"updateAllPjSDInfoRecordForFUFixForPjFix.action",
			data:{fixItemStatus:fixItemNum,psdiId:$("#psdiId").val()},
			type:"post",
			success:function(a){
				if(fixItemNum == 0){
					$("input:checkbox[name=fixItemStatus]").attr("checked",false);
				}
			},
			error:function(a){
				top.Dialog.alert("程序出错，请联系管理员！");
			}
		});
	});
	//一键启用
	$("#fixItemStatusAll").click(function(){
		var fixItemNum = 1;
		$.ajax({
			url:"updateAllPjSDInfoRecordForFUFixForPjFix.action",
			data:{fixItemStatus:fixItemNum,psdiId:$("#psdiId").val()},
			type:"post",
			success:function(a){
				if(fixItemNum ==1){
					$("input:checkbox[name=fixItemStatus]").attr("checked",true);
				}
			},
			error:function(a){
				top.Dialog.alert("程序错误，请联系管理员！");
			}
		});
	});
	//工人检测项目启用与不启用
	$("input:checkbox[name=fixItemStatus]").click(function(){
		var fixItemNum;
		if($(this).attr("checked")){
			fixItemNum = 1;
		}else{
			fixItemNum = 0;
		}
		$.ajax({
			url:"updatePjSDInfoRecordForFUFixForPjFix.action",
		    data:{pjSDInfoRecordFixId:$("#jianceItemId").val(),fixItemStatus:fixItemNum},
		    type:"post",
		    success:function(a){
		    },
		   error:function(a){
			   top.Dialog.alert("程序出错，请联系管理员！");
		   }
		});
	});
});