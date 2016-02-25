$(function(){
	//当点击查询时，保留原来的查询条件
	var bool = $("#jcTypeId").val() != "请选择";
	$("#dictJcTypeIdCkb").attr("checked", bool ? true : false);
	$("#dictJcTypeIdDiv").css("display", bool ? 'inline' : 'none');
	
	//当点击查询时，保留原来的查询条件
	var bool = $("#pjdCode").val() != "";
	$("#pjdCodeCkb").attr("checked", bool ? true : false);
	$("#pjdCodeDiv").css("display", bool ? 'inline' : 'none');
	
	//当点击查询时，保留原来的查询条件
	var bool = $("#firstUnitId").val() != "请选择";
	$("#firstUnitIdCkb").attr("checked", bool ? true : false);
	$("#firstUnitIdDiv").css("display", bool ? 'inline' : 'none');
	//当点击查询时，保留原来的查询条件
	var bool = $("#pjName").val() != "";
	$("#pjNameCkb").attr("checked", bool ? true : false);
	$("#pjNameDiv").css("display", bool ? 'inline' : 'none');
	
	//复选框添加单击事件
	$("#pjdCodeCkb").click(function(){
		$("#pjdCodeDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//复选框添加单击事件
	$("#firstUnitIdCkb").click(function(){
		$("#firstUnitIdDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//复选框添加单击事件
	$("#pjNameCkb").click(function(){
		$("#pjNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//复选框添加单击事件
	$("#dictJcTypeIdCkb").click(function(){
		$("#dictJcTypeIdDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//查询按钮跳转路径
	$("#queryFindSDInfo").click(function(){
		var url = "queryPjSDInfoByCommitLeadPjForPjFix.action?";
		
		if($("#pjdStatus").val() != "" && $("#pjdStatus").val() !=undefined){
			url +="pjdStatus=" +$("#pjdStatus").val() + "&";
		}
		
		if($("#pjName").val() != "" && $("#pjName").val() !=undefined){
			url +="pjName=" +$("#pjName").val() + "&";
		}
		//如果配件编码复选框选中<静态信息ID>
		if($("#pjSSInfoId").val() != "" && $("#pjSSInfoId").val() !=undefined){
			url +="pjSSInfoId=" +$("#pjSSInfoId").val() + "&";
		}
		//如果配件编码复选框选中<配件编码>
		if($("#pjdCodeCkb").attr("checked") && $("#pjdCode").val() != "") {
			url += "pjdCode=" + $("#pjdCode").val() + "&";
		}
		//如果专业复选框选中<专业>
		if($("#firstUnitIdCkb").attr("checked") && $("#firstUnitId").val() != "请选择"){
			url += "firstUnitId=" + $("#firstUnitId").val() + "&";
	}
		
		//如果车型复选框选中<车型ID>
		if($("#dictJcTypeIdCkb").attr("checked") && $("#jcTypeId").val() != "请选择") {
			url += "jcTypeId=" + $("#jcTypeId").val() + "&";
		}
		window.location.href=url;
	});
	
});