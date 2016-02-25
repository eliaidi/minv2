$(function() {
	//点击复选框触发的事件
	//车型
	$("#jctypeCkb").click(function() {
		$("#jctypeDiv").css("display", this.checked ? 'inline' : 'none');
	});
	//专业
	$("#firstUnitNameCkb").click(function() {
		$("#firstUnitNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	//配件名称
	$("#pjNameCkb").click(function() {
		$("#pjNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	// 查询数据之后数据保存在文本框中，复选框选中
	//车型
	var bool = $("#jcTypeId").val() != "";
	$("#jctypeCkb").attr("checked", bool ? true : false);
	$("#jctypeDiv").css("display", bool ? 'inline' : 'none');
	//专业
	var bool = $("#firstUnitName").val() != "";
	$("#firstUnitNameCkb").attr("checked", bool ? true : false);
	$("#firstUnitNameDiv").css("display", bool ? 'inline' : 'none');
	//配件名称
	var bool = $("#pjName").val() != "";
	$("#pjNameCkb").attr("checked", bool ? true : false);
	$("#pjNameDiv").css("display", bool ? 'inline' : 'none');
	
	
		 //点击查询按钮，触发的事件，对数据进行模糊查询
	$("#find").click(function() {
		var url = "queryPjSSInfoByQC.action?";
		
		// 机车型号
		var bool = $("#jctypeCkb").attr("checked") && $("#jcTypeId").val() != null;
		if (bool) {
			url += "jcTypeId=" + $("#jcTypeId").val() + "&";
		}
		//专业
		var bool = $("#firstUnitNameCkb").attr("checked") && $("#firstUnitName").val() != null;
		if (bool) {
			url += "firstUnitId=" + $("#firstUnitName").val() + "&";
		}
		//配件名称
		var bool = $("#pjNameCkb").attr("checked") && $("#pjName").val() != null;
		if (bool) {
			url += "pjName=" + $("#pjName").val() + "&";
		}
		window.location.href=url;
	}); 
}); 	