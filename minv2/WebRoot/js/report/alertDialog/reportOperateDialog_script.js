var basePath;
$(function() {
	basePath = $("#basePath").val();
	/**
	 * 显示班组
	 */
	var url = basePath + "report/ajaxListDictFault.action";
	$.ajax({
		"url": url,
		"type": "post",
		"success": function(data) {
			var json = eval(data.retMsg);
			$.each(json, function() {
				var option = "<option value='" + this.id + "'>" + this.unitName + "</option>"
				$("#firstUnit").append(option);
			});
		},
		"async": false
	});

	/**
	 * 显示专业
	 */
	url = basePath + "report/ajaxListDictProteam.action";
	$.post(url, "", function(data) {
		var json = eval(data.retMsg);
		$.each(json, function() {
			var option = "<option value='" + this.id + "'>" + this.proteamName + "</option>"
			$("#proteamId").append(option);
		});
	});

	/**
	 * 选中专业，联动二级部件
	 */
	$("#firstUnit").change(function() {
		url = basePath + "report/ajaxListDictFault.action";
		var parData = {
			"unitType": 1,
			"parentId": this.value
		};
		$.post(url, parData, function(data) {
			var json = eval(data.retMsg);
			$("#secondUnit").empty();
			$("#secondUnit").append("<option value=''>请选择部位</option>");

			$.each(json, function() {
				var option = "<option value='" + this.id + "'>" + this.unitName + "</option>"
				$("#secondUnit").append(option);
			});
		});
	});

	/**
	 * 选中二级部件，联动三级部件
	 */
	$("#secondUnit").change(function() {
		url = basePath + "report/ajaxListDictFault.action";
		var parData = {
			"unitType": 2,
			"parentId": this.value
		};
		$.post(url, parData, function(data) {
			var json = eval(data.retMsg);
			$("#thirdUnit").empty();
			$("#thirdUnit").append("<option value=''>请选择处所</option>");

			$.each(json, function() {
				var option = "<option value='" + this.id + "'>" + this.unitName + "</option>"
				$("#thirdUnit").append(option);
			});
		});
	});

	/**
	 * 选中三级部件，联动故障名称，显示报活故障内容
	 */
	$("#thirdUnit").change(function() {
		url = basePath + "report/ajaxListDictFault.action";
		var parData = {
			"unitType": 3,
			"parentId": this.value
		};
		$.post(url, parData, function(data) {
			var json = eval(data.retMsg);
			$("#faultContentTable tr:gt(0)").empty();

			$.each(json, function() {
				var tr = $("<tr></tr>");
				//添加选中点击事件
				tr.append("<td><input type='radio' name='faultRadio' onclick='faultClick(this)' value='" + this.faultContent + "'></td>")
				tr.append("<td>" + this.faultContent + "</td>")
				$("#faultContentTable").append(tr);
			});
		});
	});

	$("#jczSelect").click(function() {
		if (this.checked) {
			this.value = "true";
		} else {
			this.value = "false";
		}
	});
});

//选中故障内容，将选中的故障内容传至故障说明文本内
function faultClick(obj) {
	$("#faultContent").val(obj.value);
}

function submitValidate() {

	var type = $("input[type=radio][name='reportType']").filter('[checked=true]').val();

	if (!type) {
		top.Dialog.alert("请选择报活类型！");
		return false;
	}

	var proTeam = $('#proteamId').val();
	if (!proTeam) {
		top.Dialog.alert("请选择报给的班组！");
		return false;
	}

	var secondUnit = $('#secondUnit').val();
	if (!secondUnit) {
		top.Dialog.alert("请选择故障所处位置！")
		return false;
	}

	var explain = $('#faultContent').val();
	if (!explain) {
		top.Dialog.alert("请输入故障说明！")
		return false;
	}
	
	var formData = new FormData($('#reportForm')[0]); 
	
	jQuery_2_1_4.ajax({
		url:basePath+"report/saveJtReport.action",
		cache:false,
		data:formData,
		type:"POST",
		contentType: false,  
        processData: false,
		success:function(data){
			top.Dialog.alert(data.retMsg);
		},
		error:function(data){
			top.Dialog.alert("报活失败");
		},
		contentType:false,
		processData: false
	});
	return false;
}