$(function() {
	//弹出页面默认选中的
	if ($("#roleInUsersHid").val() != "") {
		var roleInUser = $("#roleInUsersHid").val();
		var roleInUserSplit = roleInUser.split(",");
		for ( var i = 0; i < roleInUserSplit.length; i++) {
			// 获取当前页面所有checkbox的name
			$("input[name=ckRoleInUser][value='" + roleInUserSplit[i] + "']")
					.attr("checked", true);
		}
	}
 	//关闭当前页面，并且进行判断
	$("#closeSelectRoleInUsersDialog").click(function(){
		var leng = $("input:checked").length;
			if((leng > 0 && leng <= 5)){
				Dialog.close();
			 }
	});
	
	// 动态获取被选中的复选框
	var ckRoleInUser = "";
	var ckRoleInUserTemp = "";
	$("input[type='checkbox']").bind(
			"click",
			function() {
				$("input[type='checkbox']:checked").each(function(i) {
					if (0 == i) {
						ckRoleInUser = $(this).val();
					} else {
						ckRoleInUser += ("," + $(this).val());
					}
				});
				$.ajax({
					url:"findRolePrivsNameByRoleId.action",
					data:{ids:ckRoleInUser},
					type:"post",
					async:false,
					success:function(data){
						ckRoleInUserTemp = data;
					}
				});
				//调用父窗口的方法
				parent.document.getElementById("_DialogFrame_0").contentWindow
						.changeRole(ckRoleInUserTemp);
			});

});
