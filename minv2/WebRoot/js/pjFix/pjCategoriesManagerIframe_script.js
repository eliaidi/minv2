$(function(){
	
	// 点击复选框触发的事件
	$("#selByjcType").click(function() {
		$("#selByjcTypeDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#selByfirstUnitName").click(function() {
		$("#selByfirstUnitNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#selByStoreStaticPjName").click(function() {
		$("#selByStoreStaticPjNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	
	
	// 查询数据之后数据保存在文本框中，复选框选中
	//机车类型
	var bool = $("#jcTypeId").val() != "";
	$("#selByjcType").attr("checked", bool ? true : false);
	$("#selByjcTypeDiv").css("display", bool ? 'inline' : 'none');

	// 专业
	var bool = $("#firstUnitNameId").val() != "";
	$("#selByfirstUnitName").attr("checked", bool ? true : false);
	$("#selByfirstUnitNameDiv").css("display", bool ? 'inline' : 'none');

	// 配件名称
	var bool = $("#pjName").val() != "";
	$("#selByStoreStaticPjName").attr("checked", bool ? true : false);
	$("#selByStoreStaticPjNameDiv").css("display", bool ? 'inline' : 'none');

	
    //点击查询按钮，触发的事件，对数据进行模糊查询
	$("#queryStorePosition").click(function() {
		// alert($("#pjName").val());
		var url = "queryPjSSInfoForPjFix.action?";
		
		// 车型
		var bool = $("#selByjcType").attr("checked") && $("#jcTypeId").val() != null;
		if (bool) {
			url += "jcTypeId=" + $("#jcTypeId").val() + "&";
		}
		
		// 专业名称
		var bool = $("#selByfirstUnitName").attr("checked") && $("#firstUnitNameId").val() != null;
		if (bool) {
			url += "firstUnitId=" + $("#firstUnitNameId").val() + "&";
		}
		
		// 配件名称
		var bool = $("#selByStoreStaticPjName").attr("checked") && $("#pjName").val() != null;
		if (bool) {
			url += "pjName=" + $("#pjName").val() + "&";
		}
	
		window.location.href = url;
	});
	
	
});