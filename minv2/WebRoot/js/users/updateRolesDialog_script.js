//角色判断
$(function() {
	var flag = false;

	$("#roleName").blur(function() {
		flag = false;
		//判断文本框是否为空
			if (this.value == "") {
				$("#roleNameId").html("<font color='red'>角色名称不能为空</font>");
				return;
			} else {
				$("#roleNameId").html("");
			}

			$.post("findRolePrivsByName.action", {
				"roleName" : $("#roleName").val()
			}, function(data) {
				//判断角色名已存在数据库中
					if (data == "exist") {
						$("#roleNameId").html(
								"<font color='red'>此角色已存在,请重新输入</font>");
						flag = true;
					}
					//判断角色名没存在数据库中
					else if (data == "not exist") {
						$("#roleNameId").html(
								"<font color='green'>此角色名可以使用</font>");
						flag = true;
					}
				});
		});
	//判断角色拼音是否为空
	$("#py").blur(function() {
		if (this.value == "") {
			$("#pyId").html("<font color='red'>角色拼音不能空</font>");
			$("#py").focus();
			return;
		} else {
			$("#pyId").html("");
		}
	});
	//判断角色说明是否为空
	$("#remark").blur(function() {
		if (this.value == "") {
			$("#remarkId").html("<font color='red'>角色说明不能为空</font>");
			$("#remark").focus();
			return;
		} else {
			$("#remarkId").html("");
		}
	});
	//点击修改按钮触发的事件
	$("#btn").click(function() {
		if (!flag) {
			$("#roleName").focus();
			return;
		}
		document.updateRolePrivsForm.submit();
		return true;
	});

});


