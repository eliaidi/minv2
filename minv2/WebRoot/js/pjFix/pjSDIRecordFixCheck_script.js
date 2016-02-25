$(function(){
	
	// 点击复选框触发的事件
	//机车型号
	$("#jcType").click(function() {
		$("#jcTypeDiv").css("display", this.checked ? 'inline' : 'none');
	});
	//配件名称
	$("#pjNameId").click(function() {
		$("#pjNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	//配件状态
	$("#pjAssemblyType").click(function() {
		$("#pjAssemblyTypeDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//机车编号
	//$("#jcId").click(function() {
	//	$("#jcIdDiv").css("display", this.checked ? 'inline' : 'none');
	//});
	
	//配件编号
	$("#pjId").click(function() {
		$("#pjIdDiv").css("display", this.checked ? 'inline' : 'none');
	});
	//存储位置
	$("#storageLocation").click(function() {
		$("#storageLocationDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	// 查询数据之后数据保存在文本框中，复选框选中
	//机车型号
	var bool = $("#jctype").val() != "";
	$("#jcType").attr("checked", bool ? true : false);
	$("#jcTypeDiv").css("display", bool ? 'inline' : 'none');
	//配件名称
	var bool = $("#pjName").val() != "";
	$("#pjNameId").attr("checked", bool ? true : false);
	$("#pjNameDiv").css("display", bool ? 'inline' : 'none');
	//配件状态
	var bool = $("#pjdStatus").val() != "";
	$("#pjAssemblyType").attr("checked", bool ? true : false);
	$("#pjAssemblyTypeDiv").css("display", bool ? 'inline' : 'none');
	
	//机车编号
	//var bool = $("#jcTypeNum").val() != "";
	////$("#jcId").attr("checked", bool ? true : false);
	//$("#jcIdDiv").css("display", bool ? 'inline' : 'none');
	
	//配件编号
	var bool = $("#pjdCode").val() != "";
	$("#pjId").attr("checked", bool ? true : false);
	$("#pjIdDiv").css("display", bool ? 'inline' : 'none');
	//存储位置
	var bool = $("#storePositionId").val() != "";
	$("#storageLocation").attr("checked", bool ? true : false);
	$("#storageLocationDiv").css("display", bool ? 'inline' : 'none');
	
	
	 //点击查询按钮，触发的事件，对数据进行模糊查询
	$("#find").click(function() {
		// alert($("#pjName").val());
		var url = "queryPjSDInfoForPjFix.action?";
		
		// 机车型号
		var bool = $("#jcType").attr("checked") && $("#jctype").val() != null;
		if (bool) {
			url += "jcTypeId=" + $("#jctype").val() + "&";
		}
		//配件名称
		var bool = $("#pjNameId").attr("checked") && $("#pjName").val() != null;
		if (bool) {
			url += "pjName=" + $("#pjName").val() + "&";
		}
		//配件状态
		var bool = $("#pjAssemblyType").attr("checked") && $("#pjdStatus").val() != null;
		if (bool) {
			url += "pjdStatus=" + $("#pjdStatus").val() + "&";
		}
		
		//机车编号
		//var bool = $("#jcId").attr("checked") && $("#jcTypeNum").val() != null;
		//if (bool) {
			//url += "jcTypeNum=" + $("#jcTypeNum").val() + "&";
		//}
		
		//配件编号
		var bool = $("#pjId").attr("checked") && $("#pjdCode").val() != null;
		if (bool) {
			url += "pjdCode=" + $("#pjdCode").val() + "&";
		}
		//存储位置
		var bool = $("#storageLocation").attr("checked") && $("#storePositionId").val() != null;
		if (bool) {
			url += "storePositionId=" + $("#storePositionId").val() + "&";
		}
		window.location.href = url;
	});
	
	
	
});